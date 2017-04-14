package ee.ttu.geocollection.domain;

import ee.ttu.geocollection.interop.api.Response.ApiResponse;
import io.reactivex.Observable;

import java.util.Map;

public class TargetWithCall {
    private Map target;
    private Observable<ApiResponse> call;

    public TargetWithCall(Map target, Observable<ApiResponse> call) {
        this.target = target;
        this.call = call;
    }

    public Map getTarget() {
        return target;
    }

    public Observable<ApiResponse> getCall() {
        return call;
    }
}