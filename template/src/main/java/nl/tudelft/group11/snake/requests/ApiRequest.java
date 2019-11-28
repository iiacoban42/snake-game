package nl.tudelft.group11.snake.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.util.ArrayList;
import java.util.List;

public abstract class ApiRequest<V> {

    protected static final int HTTP_OKAY = 200;

    private transient ArrayList<String> errors;
    private HttpResponse<V> result;

    public ApiRequest() {
        this.errors = new ArrayList<>();
    }

    protected HttpRequestWithBody post(String path) {
        return Unirest.post("http://localhost:9090/api" + path);
    }

    protected void setResult(HttpResponse<V> res) {
        this.result = res;
    }

    public HttpResponse<V> getResult() {
        return this.result;
    }

    protected void addError(String msg) {
        this.errors.add(msg);
    }

    public boolean hasErrors() {
        return this.errors.size() > 0;
    }

    public List<String> getErrors() {
        return new ArrayList<String>(this.errors);
    }

    public abstract void execute();

}
