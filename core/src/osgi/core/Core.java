package osgi.core;

import java.io.Serializable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import osgi.intervalexecutor.IIntervalExecutor;
import osgi.command.ICommand;
import osgi.commands.CatFactFetch;

public class Core {
	public static void run(BundleContext context) throws InvalidSyntaxException {
		ServiceTracker<?, ?> tracker;
		tracker = new ServiceTracker<IIntervalExecutor, IIntervalExecutor>(
				context,
				context.createFilter(
						"(&(objectClass=" + IIntervalExecutor.class.getName() + "))"),
				null);
		tracker.open();
		
		try {
	       IIntervalExecutor executor = (IIntervalExecutor) tracker.getService();
	       executor.setCommand(new CatFactFetch(context));
	       executor.setInitialDelay(300);
	       executor.setInterval(3000);
	       executor.run(context);
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
		} 
	}
}
