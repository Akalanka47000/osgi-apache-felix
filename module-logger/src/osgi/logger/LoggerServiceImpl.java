package osgi.logger;

import osgi.filewriter.FileWriterService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;


public class LoggerServiceImpl implements LoggerService{
	
	private FileWriterService fileWriterService;
	public LoggerServiceImpl() {
		
	}
	
	public void start(BundleContext bundleContext) throws Exception{
		//creating service tracker
		ServiceTracker<FileWriterService, FileWriterService> fileWriterTracker = new ServiceTracker<>(bundleContext, FileWriterService.class.getName(),null);
		fileWriterTracker.open();
		fileWriterService = fileWriterTracker.getService();
		fileWriterTracker.close();
		
	}
	
	public void stop(BundleContext bundleContext) throws Exception{
		
	}
	
	@Override
	public void logError(String errorMessage) {
		String logMessage = "Error: " + errorMessage;
        (fileWriterService).writeToFile(logMessage);
		
	}

	@Override
	public void logPerformanceMetrics(long elapsedTime) {
		String logMessage = "Performance Metrics: " + elapsedTime + " milliseconds";
        fileWriterService.writeToFile(logMessage);
		
	}

	@Override
	public void logRequestData(String requestData) {
		 String logMessage = "Request Data: " + requestData;
	     fileWriterService.writeToFile(logMessage);
	}

	@Override
	public void logResponseData(String responseData) {
		String logMessage = "Response Data: " + responseData;
        fileWriterService.writeToFile(logMessage);
		
	}

}
