package osgi.filewriter;

public interface IFileWriter {
	public void info(String data);
	public void info(String data, String path);
	public void error(String data);
	public void error(String data, String path);
	public void warn(String data);
	public void warn(String data, String path);
}
