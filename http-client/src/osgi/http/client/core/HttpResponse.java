package osgi.http.client.core;

import java.util.Map;

public class HttpResponse {
    int status;
    Map<String, Object> data;

    public HttpResponse(int status, Map<String,Object> data) {
        this.status = status;
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setData(Map<String,Object> data) {
        this.data = data;
    }

    public Map<String,Object> getData() {
        return data;
    }
}