package osgi.jsonparser;

import java.util.HashMap;
import java.util.Map;

public class JSONParserImpl implements JSONParser {
	public Map<String, Object> parse(String json) {
        json = json.substring(1, json.length() - 1);
        String[] pairs = json.split(",");
        Map<String, Object> map = new HashMap<String, Object>();
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
