package osgi.outputhandler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi.strings.*;

public class Activator implements BundleActivator {

	ServiceRegistration outputHandlerRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Output handler started");
		OutputHandlerService outputHandlerService = new OutputHandlerImpl(context);
		
		outputHandlerRegistration = context.registerService(OutputHandlerService.class.getName(), outputHandlerService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Output handler Stopped");
		outputHandlerRegistration.unregister();
	}

}
