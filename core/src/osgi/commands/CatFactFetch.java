package osgi.commands;

import java.io.Serializable;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import osgi.command.ICommand;
import osgi.http.client.HttpClient;
import osgi.http.client.HttpResponse;
import osgi.logger.LoggerService;
import osgi.outputhandler.OutputHandlerService;

public class CatFactFetch implements ICommand, Serializable {
	private LoggerService logger;
	private OutputHandlerService output;
	private BundleContext context;
	
	public CatFactFetch(BundleContext context) {
		this.context = context;
		
		// get the module logger
		ServiceTracker<?, ?> tracker = null;
		try {
			 tracker = new ServiceTracker<LoggerService, LoggerService>(
					context,
					context.createFilter(
							"(&(objectClass=" + LoggerService.class.getName() + "))"),
					null);
			tracker.open();
			logger = (LoggerService) tracker.getService();
			tracker.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		// get output handler service
		try {
			 tracker = new ServiceTracker<LoggerService, LoggerService>(
					context,
					context.createFilter(
							"(&(objectClass=" + OutputHandlerService.class.getName() + "))"),
					null);
			tracker.open();
			output = (OutputHandlerService) tracker.getService();
			tracker.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}

	@Override
	public void execute(BundleContext context) throws Exception {
	    ServiceTracker<?, ?> tracker = null;
	    		
		tracker = new ServiceTracker<HttpClient, HttpClient>(
				context,
				context.createFilter(
						"(&(objectClass=" + HttpClient.class.getName() + "))"),
				null);
		tracker.open();
		HttpClient client = (HttpClient) tracker.getService();
		tracker.close();
		
        HttpResponse res = client.get("https://catfact.ninja/fact");
        System.out.println(res.getStatus());
        System.out.println(res.getData());

        output.PrintWithBorder((String) res.getData().get("message"));
	}

	@Override
	public void onInitiation(BundleContext context) {
		logger.logInit("API Request Initiated");
	}

	@Override
	public void onSuccess(BundleContext context) {
		logger.logSuccess("Data fetched successfully");
		logger.logPerformanceMetrics();
	}

	@Override
	public void onError(BundleContext context, Exception e) {
		logger.logError(e.getMessage());
		logger.logPerformanceMetrics();
	}

}
