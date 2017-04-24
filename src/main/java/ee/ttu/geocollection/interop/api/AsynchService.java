package ee.ttu.geocollection.interop.api;

import ee.ttu.geocollection.core.domain.AppConfig;
import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class AsynchService {

    @Autowired
    private AppConfig appConfig;

    /**
     * For each entry in target object executes call method. Once call method retrieves result, onCompleteAction is called.
     * First argument in both call and onCompleteAction is same entry in target object.
     */
    public void doAsynchCallsForEachResult(
            ApiResponse target, Function<Map<String, Object>, Callable<ApiResponse>> call, Function<Map<String, Object>, Consumer<ApiResponse>> onCompleteAction) {

        Preconditions.checkNotNull(target);

        List<Observable<ApiResponse>> observables = target.getResult().stream()
                .map(resultObject ->
                        Observable.fromCallable(call.apply(resultObject))
                                .timeout(appConfig.asynchRequestTimeoutMillisecs, TimeUnit.MILLISECONDS)
                                .onErrorResumeNext(Observable.empty())
                                .subscribeOn(Schedulers.io())
                                .doOnNext(onCompleteAction.apply(resultObject)))
                .collect(toList());

        // zip hack blocks current thread until all asynch requests are done
        // otherwise current thread will proceed without waiting for response from asynch requests
        // https://solidsoft.wordpress.com/2016/02/26/parallel-execution-of-blocking-tasks-with-rxjava-and-completable/
        Observable.zip(observables, a -> a)
                .blockingSubscribe();
    }
}