package osgi.outputhandler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration outputHandlerRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("outputHandler started");
		OutputHandlerService outputHandlerService = new OutputHandlerImpl();
		
		outputHandlerRegistration = context.registerService(OutputHandlerService.class.getName(), outputHandlerService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("string manipulator Stopped");
		outputHandlerRegistration.unregister();
	}

}
