package osgi.jsonparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class JSONParser {

    public static Map parse(String json) {
        json = json.substring(1, json.length() - 1);
        String[] pairs = json.split(",");
        Map map = new HashMap();
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            Object value;
            if (keyValue[1].trim().equals("true")) {
                value = true;
            } else if (keyValue[1].trim().equals("false")) {
                value = false;
            } else {
                value = keyValue[1].trim().replace("\"", "");
            }
            map.put(key, value);
        }
        return map;
    }
}
