package osgi.filewriter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration fileWriterRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("File-writer started");
		IFileWriter fileWriter = new FileWriterImpl();
		fileWriterRegistration = context.registerService(IFileWriter.class.getName(), fileWriter, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("file-writer Stopped");
		fileWriterRegistration.unregister();
	}

}
