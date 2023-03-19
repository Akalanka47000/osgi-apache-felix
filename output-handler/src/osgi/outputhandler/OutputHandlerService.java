package osgi.outputhandler;

public interface OutputHandlerService {
	public void printToConsole(String Input);
	public void formatAndPrint(String Input);
	public void printWithBorder(String Input);
	public void printList(String[] Input);
}
