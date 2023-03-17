package file_writer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration fileWriterRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("File-writer started");
		FileWriterService fileWriterService = new FileWriterImpl();
		
		fileWriterRegistration = context.registerService(FileWriterService.class.getName(), fileWriterService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("file-writer Stopped");
		fileWriterRegistration.unregister();
	}

}
