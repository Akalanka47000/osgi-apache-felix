package file_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;

public class FileWriterImpl implements IFileWriter {
	
	private final String DEFAULT_FILE_NAME = "log.txt";
	
	private boolean separateLogLevels = false;
   
	private void write(String level, String data, String path) {
		try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("["+level + "] --> " + data + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void info(String data) {
		this.write("INFO", data, DEFAULT_FILE_NAME);
	}
	
	@Override
	public void info(String data, String path) {
		this.write("INFO",  data, path);
	}
	
	@Override
	public void error(String data) {
		this.write("ERROR", data, DEFAULT_FILE_NAME);
	}
	
	@Override
	public void error(String data, String path) {
		this.write("ERROR",  data, path);
	}
	
	@Override
	public void warn(String data) {
		this.write("WARN", data, DEFAULT_FILE_NAME);
	}
	
	@Override
	public void warn(String data, String path) {
		this.write("WARN",  data, path);
	}

}
