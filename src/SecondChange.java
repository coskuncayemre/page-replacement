import java.io.IOException;
import java.util.ArrayList;

public class SecondChange extends Queue {
	
	private int[] bitArray;
	private int secondChance;
	public int counter;
	public ArrayList<String> secondArray= new ArrayList<String>();
	public ArrayList<Integer> supportSecond = new ArrayList<Integer>();
	
	public SecondChange(int size) {
		super(size);
		bitArray=new int[size];
		for(int i = 0 ; i<size;i++) {
			bitArray[i]=0;
		}
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
	    	  		newBST=new binarySearchTree(word);
    	  			setRear((getRear()+1) % getSize());
    	  			if(bitArray[getRear()]==1) {
    	  				setSecondChance(1);
    	  				while(bitArray[getRear()]==1) {
    	  					supportSecond.add(getRear());
    	  					secondArray.add(getWordArray()[getRear()]);
    	  					setRear((getRear()+1) % getSize());
    	  					counter++;
    	  				}
    	  				resetArray();
    	  			}
	    	  	}
	    	  	else {
	    	  		bitArray[getIndex(word,getWordArray())]=1;
	    	  		return;
	    	  	}
	      }
	      getWordArray()[getRear()]=word;
	      newBST.giveArray(newBST.getRoot(),getWordArray());
	      pageFault(outText);
	}
	
	
	public int getIndex(String word,String[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==null) {
				
			}
			else {
				if(arr[i].equals(word)) {
					return i;
				}
			}
		}
		return 0;
	}
	
	public void resetArray() {
		for(int i = 0 ; i<supportSecond.size();i++) {
			bitArray[supportSecond.get(i)]=0;
		}
		supportSecond.clear();
	}


	/**
	 * @return the secondChance
	 */
	public int getSecondChance() {
		return secondChance;
	}


	/**
	 * @param secondChance the secondChance to set
	 */
	public void setSecondChance(int secondChance) {
		this.secondChance = secondChance;
	}

	
	public void pageFault(ArrayList<String> outText) throws IOException {
		setPageFault(getPageFault()+1);
	  	outText.add("Page Fault\t");
	    display(outText);
		if(getSecondChance()==0) {
			outText.add("\n");
		}
		else {
			outText.add("Second Chance ");
			for(int i = 0;i<counter;i++) {
				outText.add(secondArray.get(i)+ " ");
			}
			outText.add("\n");
		}
		counter=0;
		setSecondChance(0);
		secondArray.clear();
	}
	
	
}
