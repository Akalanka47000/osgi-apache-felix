package osgi.logger;

public interface LoggerService {
	public void logError(String errorMessage);
	public void logPerformanceMetrics(long elapsedTime);
	public void logRequestData(String requestData);
	public void logResponseData(String responseData);
	public void logWarnings(String warning);
}
