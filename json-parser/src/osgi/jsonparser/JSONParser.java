package osgi.jsonparser;

import java.util.Map;

public interface JSONParser {
    public Map<?, ?> parse(String json);
}
