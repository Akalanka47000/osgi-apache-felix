package osgi.logger;

public interface LoggerService {
	void logError(String errorMessage);
    void logPerformanceMetrics(long elapsedTime);
    void logRequestData(String requestData);
    void logResponseData(String responseData);
}
