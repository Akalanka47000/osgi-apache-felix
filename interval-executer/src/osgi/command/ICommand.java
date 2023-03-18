package osgi.command;

public interface ICommand {
	public void execute();
	
	public void onInitiation();
	public void onSuccess();
	public void onError(Exception e);
}
