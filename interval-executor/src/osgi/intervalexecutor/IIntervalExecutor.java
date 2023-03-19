package osgi.intervalexecutor;

import org.osgi.framework.BundleContext;

import osgi.command.ICommand;

public interface IIntervalExecutor {
	public void run(BundleContext context);
	
	public int getInitialDelay();
	public void setInitialDelay(int initialDelay);
	
	public int getInterval();
	public void setInterval(int interval);
	
	public ICommand getCommand();
	public void setCommand(ICommand command);
}