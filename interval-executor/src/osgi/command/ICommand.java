package osgi.command;

import org.osgi.framework.BundleContext;

public interface ICommand {
	public void execute(BundleContext context);
	
	public void onInitiation();
	public void onSuccess();
	public void onError(Exception e);
}