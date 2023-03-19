package osgi.outputhandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import osgi.commands.CatFactFetch;
import osgi.intervalexecutor.IIntervalExecutor;

public class OutputHandlerImpl implements OutputHandlerService{
	
	public OutputHandlerImpl(BundleContext context) {
		ServiceTracker<?, ?> tracker;
		tracker = new ServiceTracker<StringManipulatorService, StringManipulatorService>(
				context,
				context.createFilter(
						"(&(objectClass=" + StringManipulatorService.class.getName() + "))"),
				null);
		tracker.open();
		
		try {
			StringManipulatorImpl executor = (StringManipulatorImpl) tracker.getService();
	      
	       executor.setInitialDelay(300);
	       executor.setInterval(3000);
	       executor.run(context);
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
		} 
	}
	
	public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }

	@Override
	public void PrintToConsole(String Input) {
		
		Input = Input.trim();
				
	}

	@Override
	public void formatAndPrint(String Input) {
		Input = Input.trim();
		
	}

	@Override
	public void PrintWithBorder(String Input) {
		Input = Input.trim();
		String outputToPrint = stringManipulator.
	}

	@Override
	public void PrintList(String[] Input) {
		
		
		
	}

}
