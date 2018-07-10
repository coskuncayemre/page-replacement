import java.io.IOException;
import java.util.ArrayList;

public class PriorityQueue extends Queue {
	
	private int maxValue;
	
	public PriorityQueue(int size) {
		super(size);
	}
	
	
	public void enqueue(String word,ArrayList<String> outText) throws IOException {
	      if(isEmpty()) {
	    	  	setFront(0);
	    	  	setRear(0);
	    	  	newBST=new binarySearchTree(word);
	    	  	getWordArray()[getRear()]=word;
	    	  	pageFault(outText);
	    	  	return;
	      }
	      else{
	    	  	if(!newBST.search(newBST.getRoot(), word,getWordArray(),outText)) {
	    	  		if(full()) {
	    	  			newBST=new binarySearchTree(word);
	    	  			setRear(findMax());
	    	  			heapFindMax();
	    	  		}
	    	  		else {
	    	  			newBST=new binarySearchTree(word);
	    	  			setRear((getRear()+1) % getSize());
	    	  		}
	    	  	}
	    	  	else {
	    	  		return;
	    	  	}
	      }
	      getWordArray()[getRear()]=word;
	      newBST.giveArray(newBST.getRoot(),getWordArray());
	      pageFault(outText);
	}
	
	
	public boolean full() {
		int counter =0 ;
		for(int i =0;i<getSize();i++) {
			if(getWordArray()[i]!=null) {
				counter++;
			}
		}
		if(counter==getSize()) {
			return true;
		}
		return false;
	}
	
	public int findMax() {
		
		String maxWord= getWordArray()[0];
		for(int i=0;i<getSize();i++) {
			if(getWordArray()[i]==null) {
				
			}
			else{
				if(maxWord.compareTo(getWordArray()[i])<0) {
					maxWord=getWordArray()[i];
					setMaxValue(i);
				}
			}
		}
		return getMaxValue();
	}

	public int heapFindMax() {
		return heapTree.findMax(newBST.getRoot());
	}

	/**
	 * @return the maxValue
	 */
	public int getMaxValue() {
		return maxValue;
	}


	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	
	
}
