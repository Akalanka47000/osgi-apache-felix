package osgi.http.client.core;

import java.util.Map;

/**
 * A simple http client to make API requests
 **/
public interface HttpClient {

    public HttpResponse get(String url);

    public HttpResponse post(String url, Map<String, Object> data);

    public HttpResponse put(String url, Map<String, Object> data);

    public HttpResponse patch(String url, Map<String, Object> data);

    public HttpResponse delete(String url, Map<String, Object> data);
}