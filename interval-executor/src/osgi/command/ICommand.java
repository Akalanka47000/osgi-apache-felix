package osgi.command;

import org.osgi.framework.BundleContext;

public interface ICommand {
	// TODO: Reduce the repetitive context passing
	public void execute(BundleContext context) throws Exception;
	
	public void onInitiation(BundleContext context);
	public void onSuccess(BundleContext context);
	public void onError(BundleContext context, Exception e);
}