package osgi.http.client;

import java.io.IOException;
import java.util.Map;

/**
 * A simple http client to make API requests
 **/
public interface HttpClient {

    public HttpResponse get(String path) throws IOException;

    public HttpResponse get(String path, Map<String,String> headers) throws IOException;

    public HttpResponse post(String path, Map<String,String> payload) throws IOException;
    
    public HttpResponse post(String path, Map<String,String> payload, Map<String,String> headers) throws IOException;

    public HttpResponse put(String path, Map<String,String> payload) throws IOException;
    
    public HttpResponse put(String path, Map<String,String> payload, Map<String,String> headers) throws IOException;

    public HttpResponse delete(String path) throws IOException;

    public HttpResponse delete(String path, Map<String,String> headers) throws IOException;
    
    public void setBaseURL(String baseURL);
    
    public void setHeaders(Map<String,String> headers);
}