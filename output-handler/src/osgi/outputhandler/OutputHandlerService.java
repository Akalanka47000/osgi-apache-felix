package osgi.outputhandler;

public interface OutputHandlerService {
	public void PrintToConsole(String Input);
	public void formatAndPrint(String Input);
	public void PrintWithBorder(String Input);
	public void PrintList(String[] Input);
}
