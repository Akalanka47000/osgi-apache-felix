package osgi.logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
	private static BundleContext context;
	ServiceRegistration loggerServiceRegistration;
	
	static BundleContext getContext() {
		return context;
		
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Logger started");
		LoggerService loggerService = new LoggerServiceImpl();
		loggerServiceRegistration = bundleContext.registerService(LoggerService.class.getName(), loggerService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Logger Stopped");
		loggerServiceRegistration.unregister();
		
	}

}