package osgi.logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import file_writer.IFileWriter;

public class Activator implements BundleActivator
{
	
	ServiceRegistration loggerServiceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Logger started");
		ServiceTracker<IFileWriter, IFileWriter> fileWriterTracker = new ServiceTracker<>(bundleContext, IFileWriter.class.getName(),null);
		fileWriterTracker.open();
		ServiceMap.setService("file-writer", (IFileWriter) fileWriterTracker.getService());
		fileWriterTracker.close();
		LoggerService loggerService = new LoggerServiceImpl();
		loggerServiceRegistration = bundleContext.registerService(LoggerService.class.getName(), loggerService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Logger Stopped");
		loggerServiceRegistration.unregister();
		
	}

}