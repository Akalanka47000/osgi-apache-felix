package osgi.http.client;

import java.io.IOException;

/**
 * A simple http client to make API requests
 **/
public interface HttpClient {

    public HttpResponse get(String url) throws IOException;

}