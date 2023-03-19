package osgi.http.client;

import java.util.HashMap;
import java.util.Map;

import osgi.jsonparser.JSONParser;

public class HttpResponse {
    int status;
    String stringData;
    Map data = new HashMap<>();

    public HttpResponse(int status, String data) {
        this.status = status;
        this.stringData = data;
        JSONParser parser = (JSONParser) ServiceMap.getService("json-parser");
        this.data = parser.parse(data);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setData(String data) {
        this.stringData = data;
    }

    public String getStringData() {
        return stringData;
    }

    public Map getData() {
        return data;
    }
}