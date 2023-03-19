package osgi.logger;

import java.util.Calendar;
import java.util.Date;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import osgi.filewriter.IFileWriter;


public class LoggerServiceImpl implements LoggerService{
	
	private Date lastBegin;
	private Date lastEnd;
	private IFileWriter fileWriter;
	
	public LoggerServiceImpl() {
		this.lastBegin = new Date();
		this.lastEnd = new Date();
		this.fileWriter = (IFileWriter) ServiceMap.getService("file-writer");
	}
	
	@Override
	public void logError(String message) {
		lastEnd = new Date();
		String logMessage = getTimeAsString() + " | ERROR   | " + message;
		fileWriter.error(logMessage);
	}

	@Override
	public void logInit(String message) {
		lastBegin = new Date();
		String logMessage = getTimeAsString() + " | INIT    | " + message;
		fileWriter.info(logMessage);
	}
	
	@Override
	public void logSuccess(String message) {
		lastEnd = new Date();
		String logMessage = getTimeAsString() + " | SUCCESS | " + message;
		fileWriter.info(logMessage);
	}

	@Override
	public void logPerformanceMetrics() {
		long elapedTime = lastEnd.getTime() - lastBegin.getTime();
		String logMessage = getTimeAsString() + " | METRICS | " + "Elapsed Time = " + Long.toString(elapedTime) + " ms";
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
