package osgi.stringmanipulator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration stringmanipulatorRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("string manipulator started");
		StringManipulatorService stringmanipulatorService = new StringManipulatorImpl();
		
		stringmanipulatorRegistration = context.registerService(StringManipulatorService.class.getName(), StringManipulatorImpl.class.getName(), null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("file-writer Stopped");
		stringmanipulatorRegistration.unregister();
	}

}
