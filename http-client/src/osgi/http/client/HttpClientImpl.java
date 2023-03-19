package osgi.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClientImpl implements HttpClient {
	
	private String baseURL = "";
	private Map<String,String> defaultHeaders = new HashMap<String, String>();

    private HttpResponse apiRequest(String method, String url, Map<String,String> payload, Map<String,String> headers) throws IOException {
        try {
        	new URL(url);
        } catch (Exception e) {
        	url = baseURL + url;
        	try {
            	new URL(url);
            } catch (Exception e1) {
            	System.out.println("Invalid request url");
            	return null;
            }
        }
    	URL connectionUri = new URL(url);
        HttpURLConnection con = (HttpURLConnection) connectionUri.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");

        // Set user specified headers
        if (headers != null) {
        	defaultHeaders.putAll(headers);
        }
        
        for (Map.Entry<String,String> header : defaultHeaders.entrySet()) {
            con.setRequestProperty(header.getKey(), header.getValue());
        }

        if (payload != null) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(payload));
            out.flush();
            out.close();
        }
    
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();

        Reader streamReader = null;
        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }

        BufferedReader in = new BufferedReader(streamReader);
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return new HttpResponse(status, content.toString());
    }

    @Override
    public HttpResponse get(String path) throws IOException {
        return this.apiRequest("GET", path, null, null);
    }

    @Override
    public HttpResponse get(String path, Map<String,String> headers) throws IOException {
        return this.apiRequest("GET", path, headers, null);
    }
    
    @Override
    public HttpResponse post(String path, Map<String,String> payload) throws IOException {
        return this.apiRequest("POST", path, payload, null);
    }

    @Override
    public HttpResponse post(String path, Map<String,String> payload, Map<String,String> headers) throws IOException {
        return this.apiRequest("POST", path, payload, headers);
    }
    
    @Override
    public HttpResponse put(String path, Map<String,String> payload) throws IOException {
        return this.apiRequest("PUT", path, payload, null);
    }

    @Override
    public HttpResponse put(String path, Map<String,String> payload, Map<String,String> headers) throws IOException {
        return this.apiRequest("PUT", path, payload, headers);
    }

    @Override
    public HttpResponse delete(String path) throws IOException {
        return this.apiRequest("DELETE", path, null, null);
    }

    @Override
    public HttpResponse delete(String path, Map<String,String> headers) throws IOException {
        return this.apiRequest("DELETE", path, headers, null);
    }
    
    @Override
    public void setBaseURL(String baseURL) {
    	this.baseURL = baseURL;
    }
    
    @Override
    public void setHeaders(Map<String,String> headers) {
    	this.defaultHeaders = headers;
    }
}
