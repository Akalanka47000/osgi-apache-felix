package osgi.stringmanipulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;

public class StringManipulatorImpl implements StringManipulatorService{
	
	public StringManipulatorImpl() {
		
	}
	
	public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }

	@Override
	public String addBorder(String input) {
        String out = "";
        String stars = new String(new char[40]).replace("\0", "* ");
        String[] strArr = input.split("\n");
        
        for (int i = 0; i < strArr.length; i++) {
            int diff = 76 - strArr[i].length();
            String tmp = new String(new char[diff]).replace("\0", " ");
            tmp = tmp + "*";
            strArr[i] = "* " + strArr[i] + tmp;
            out = String.join("\n", out, strArr[i]);
        }
        
        out = stars + out + "\n" + stars;
        return out;
    }

	@Override
	public String formatParagraph(String input) {
        String[] strArr = input.split(" ");
        String tmp = "";
        String out = "";

        for (String str: strArr) {
            if (tmp.length() + str.length() <= 75) {
                if (tmp.equals("")){
                    tmp = str;
                } else {
                    tmp = tmp + " " + str;
                }
                
            } else {
                if (out.equals("")){
                    out =  tmp;
                }else {
                    out = String.join("\n", out, tmp);
                }
                
                tmp = str;
            }
        }
        
        out = String.join("\n", out, tmp );

        return out;
    }

	@Override
	public String combineAll(String[] input) {
		String finalOut = "";
		String out="";
        for(String subStr : input) {
        	out = formatParagraph(subStr);
        	out = addBorder(out);
        	if(finalOut.equals("")) {
        		finalOut = out + "\n\n";
        	}else {
        		finalOut = finalOut + out + "\n\n";
        	}
        	
        }
		return finalOut;
	}
    
}
