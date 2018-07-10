import java.io.IOException;
import java.util.ArrayList;


public class Queue {

	private int front,rear,size;
	private String[] wordArray;
	private int pageFault;
  	public binarySearchTree newBST;
  	
	public Queue(int size) {
		this.setFront(-1);
		this.setRear(-1);
		this.setSize(size);
		this.wordArray= new String[getSize()];
	}
	
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if((getFront() == (getRear() + 1) % getSize()) || (getFront() == 0 && getRear() == getSize() -1)) {
			return true;
		}
		return false;
	}
	
	
	public void enqueue(String word,ArrayList<String> outText) throws IOException {
		if(isEmpty()) {
	    	  	setFront(0);
	    	  	setRear(0);
	    	  	newBST=new binarySearchTree(word);
	    	  	wordArray[getRear()]=word;
	    	  	pageFault(outText);
	    	  	return;
	      }
	      else{
	    	  	if(!newBST.search(newBST.getRoot(), word,wordArray,outText)) {
	    	  		if(isFull()) {
	    	  			newBST=new binarySearchTree(word);
	    	  			setRear((getRear()+1) % getSize());
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
	      wordArray[getRear()]=word;
	      newBST.giveArray(newBST.getRoot(),wordArray);
	      pageFault(outText);
	}

	
	
	
	
	public void display(ArrayList<String> outText) throws IOException {
		for(int i=0;i<getSize();i++) {
			if(getWordArray()[i]!=null) {
				outText.add(getWordArray()[i] + " ");
			}
		}
	}
	
	
	public void pageFault(ArrayList<String> outText) throws IOException {
		setPageFault(getPageFault()+1);
		outText.add("Page Fault\t");
	    display(outText);
	    outText.add("\n");
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the rear
	 */
	public int getRear() {
		return rear;
	}

	/**
	 * @param rear the rear to set
	 */
	public void setRear(int rear) {
		this.rear = rear;
	}

	/**
	 * @return the front
	 */
	public int getFront() {
		return front;
	}

	/**
	 * @param front the front to set
	 */
	public void setFront(int front) {
		this.front = front;
	}

	/**
	 * @return the wordArray
	 */
	public String[] getWordArray() {
		return wordArray;
	}

	/**
	 * @param wordArray the wordArray to set
	 */
	public void setWordArray(String[] wordArray) {
		this.wordArray = wordArray;
	}

	/**
	 * @return the pageFault
	 */
	public int getPageFault() {
		return pageFault;
	}

	/**
	 * @param pageFault the pageFault to set
	 */
	public void setPageFault(int pageFault) {
		this.pageFault = pageFault;
	}

	
	

}
