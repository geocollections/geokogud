package ee.ttu.geodeesia.interop.api.Response;

import java.util.List;

/**
 * Created by 48707222248 on 24.02.2017.
 */
public class Response {
    private int count;
    private List<ResponseEntities> result;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ResponseEntities> getResult() {
        return result;
    }

    public void setResult(List<ResponseEntities> result) {
        this.result = result;
    }
}
