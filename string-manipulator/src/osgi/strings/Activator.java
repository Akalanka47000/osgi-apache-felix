package osgi.strings;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration stringmanipulatorRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("string manipulator started");
		StringManipulatorService stringmanipulatorService = new StringManipulatorImpl();
		
		stringmanipulatorRegistration = context.registerService(StringManipulatorService.class.getName(), stringmanipulatorService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("string manipulator Stopped");
		stringmanipulatorRegistration.unregister();
	}

}
