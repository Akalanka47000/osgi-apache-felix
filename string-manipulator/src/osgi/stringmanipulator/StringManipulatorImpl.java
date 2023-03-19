package osgi.stringmanipulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;

public class StringManipulatorImpl implements StringManipulatorService{
	
	private final String FILE_NAME = "log.txt";
	
	public StringManipulatorImpl() {
		
	}
	
	public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }

	@Override
	public String addBorder(String input) {
		input = new String(new char[75]).replace("\0", "*") + "/n" + input + "/n" + new String(new char[75]).replace("\0", "*");		
		return input;
	}

	@Override
	public String formatParagraph(String input) {
		
		if(input.length() > 75) {
			input = String.join("/n",input.substring(0, input.indexOf(" ", 74)),input.substring(input.indexOf(" ", 74),input.length()));
		}
		
		return input;
	}

	@Override
	public String combineAll(String[] input) {
		String out = "";
		for(String subStr : input) {
			out = String.join("/n", out, subStr);
		}
		return out;
	}
    

}
