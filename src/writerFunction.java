import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writerFunction {

	static FileWriter fileWriter = null;
	public static void writer(ArrayList<String> log) {
        try {
        		fileWriter = new FileWriter("output.txt");
        		for(int i=0;i<log.size();i++) {
        			fileWriter.append(log.get(i));
        		}
        } catch (Exception e) {
        		System.err.println("Error,please try again!");
            e.printStackTrace();

        } 
        finally {
	    		try {
	    			fileWriter.flush();
	            fileWriter.close();
	        } catch (IOException e) {
	        		System.err.println("Error,please try again!");
	        		e.printStackTrace();
	        }
        }
	}
	

}
