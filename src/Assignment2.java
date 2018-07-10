import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/*
 * 
 * 	EMRE COSKUNCAY
 * 		21526806
 * BBM204 - Assignment2
 * 
 */

public class Assignment2 {
	
	public static void main(String[] args) throws NumberFormatException, 
												ParseException,ArrayIndexOutOfBoundsException, IOException{
		
		readFile readObj = new readFile();
		ArrayList<String> textList = readObj.read_file(args[0]);
		ArrayList<String> outText = new ArrayList<String>();
		Functions func = new Functions();
		func.valueDeterminer(textList);
		func.printerType(outText);
		long start = System.nanoTime();
		
        	if(func.getReplacementType().equals("FIFO")) {
			Queue newQueue= new Queue(func.getMemorySize());
			for(int j=0;j<func.getReadList().size();j++) {
				String tempWord=func.getReadList().get(j);
				newQueue.enqueue(tempWord,outText);
			}
			outText.add(Integer.toString(newQueue.getPageFault()) + "\n");
		}
		
		else if(func.getReplacementType().equals("SecondChance")) {
			SecondChange newSec= new SecondChange(func.getMemorySize());
			for(int j=0;j<func.getReadList().size();j++) {
				String tempWord=func.getReadList().get(j);
				newSec.enqueue(tempWord,outText);
			}
			outText.add(Integer.toString(newSec.getPageFault()) + "\n");
		}
		
		else if(func.getReplacementType().equals("PriorityQueue")) {
			PriorityQueue newPriQueue = new PriorityQueue(func.getMemorySize());
			for(int j=0;j<func.getReadList().size();j++) {
				String tempWord=func.getReadList().get(j);
				newPriQueue.enqueue(tempWord,outText);
			}
			outText.add(Integer.toString(newPriQueue.getPageFault()) + "\n");
		}
		
		long end = System.nanoTime();
		long out = end - start;
		long fino= out / 1000000;
		outText.add("Running Time (ms): ");
		outText.add(Long.toString(fino));
		writerFunction.writer(outText);
	}
}