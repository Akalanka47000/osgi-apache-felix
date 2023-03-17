package file_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;

public class FileWriterImpl implements FileWriterService{
	
	private final String FILE_NAME = "log.txt";
	
	public FileWriterImpl() {
		
	}
	
	public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }
    
	@Override
	public void writeToFile(String data) {
		try {
            File file = new File(FILE_NAME);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(data + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
