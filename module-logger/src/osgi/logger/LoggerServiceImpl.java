package osgi.logger;

import osgi.filewriter.FileWriterService;

import java.util.Calendar;
import java.util.Date;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;


public class LoggerServiceImpl implements LoggerService{
	
	private FileWriterService fileWriterService;
	private Date lastBegin;
	private Date lastEnd;
	
	public LoggerServiceImpl() {
		this.lastBegin = new Date();
		this.lastEnd = new Date();
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
	public void logError(String message) {
		lastEnd = new Date();
		String logMessage = getTimeAsString() + " | ERROR   | " + message;
		fileWriterService.writeToFile(logMessage);
	}

	@Override
	public void logInit(String message) {
		lastBegin = new Date();
		String logMessage = getTimeAsString() + " | INIT    | " + message;
		fileWriterService.writeToFile(logMessage);
	}
	
	@Override
	public void logSuccess(String message) {
		lastEnd = new Date();
		String logMessage = getTimeAsString() + " | SUCCESS | " + message;
		fileWriterService.writeToFile(logMessage);
	}

	@Override
	public void logPerformanceMetrics() {
		long elapedTime = lastEnd.getTime() - lastBegin.getTime();
		
		String logMessage = getTimeAsString() + " | METRICS | " + "Elapsed Time = " + Long.toString(elapedTime) + " ms";
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
	
	private String getTimeAsString() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		return
				filldigits(calendar.get(Calendar.YEAR), 4) + ":" +
				filldigits(calendar.get(Calendar.MONTH), 2) + ":" +
				filldigits(calendar.get(Calendar.DAY_OF_MONTH), 2) + "-" +
				filldigits(calendar.get(Calendar.HOUR_OF_DAY), 2) + ":" +
				filldigits(calendar.get(Calendar.MINUTE), 2) + ":" +
				filldigits(calendar.get(Calendar.SECOND), 2) + ":" +
				filldigits(calendar.get(Calendar.MILLISECOND), 3);
	}
	
	private String filldigits(int value, int minDigits) {
		String out = Integer.toString(value);
		for (int i = out.length(); i < minDigits; i++) {
			out = "0" + out;
		}
		return out;
	}
}
