package osgi.logger;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import file_writer.IFileWriter;


public class LoggerServiceImpl implements LoggerService{
	
	private IFileWriter fileWriter;
	
	public LoggerServiceImpl () {
		this.fileWriter = (IFileWriter) ServiceMap.getService("file-writer");
	}
	
	@Override
	public void logError(String errorMessage) {
		String logMessage = "Error: " + errorMessage;
        (fileWriter).error(logMessage);
		
	}

	@Override
	public void logPerformanceMetrics(long elapsedTime) {
		String logMessage = "Performance Metrics: " + elapsedTime + " milliseconds";
        fileWriter.info(logMessage);
		
	}

	@Override
	public void logRequestData(String requestData) {
		 String logMessage = "Request Data: " + requestData;
	     fileWriter.info(logMessage);
	}

	@Override
	public void logResponseData(String responseData) {
		String logMessage = "Response Data: " + responseData;
        fileWriter.info(logMessage);
		
	}

	@Override
	public void logWarnings(String warning) {
		String logMessage = "Warning : " + warning;
		fileWriter.warn(logMessage);
	}

}
