package file_writer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private FileWriterImpl fileWriterImpl;
	
	public void start(BundleContext context) throws Exception {
		fileWriterImpl = new FileWriterImpl();
		context.registerService(FileWriterService.class.getName(),fileWriterImpl, null);
		fileWriterImpl.start(context);
	}

	public void stop(BundleContext context) throws Exception {
		fileWriterImpl.stop(context);
	}

}
