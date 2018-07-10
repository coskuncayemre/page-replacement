import java.io.IOException;
import java.util.ArrayList;

public class binarySearchTree {
	
	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node x) {
		this.root=x;
	}
	
	public binarySearchTree() {
		
	}
	
	public binarySearchTree(String newWord) {
		root=new Node(newWord);
	}
	
	public boolean isEmpty() {
		if(root.getLeft()==null && root.getRight()==null) {
			return true;
		}
		return false;
	}

	public void put(Node x,String word) {
		int cmp=word.compareTo(x.getData());
		if(cmp < 0) {
			if(x.getLeft()==null) {
				Node tempNode= new Node(word);
				x.setLeft(tempNode);
			}
			else {
				put(x.getLeft(),word);
			}
		}
		else if(cmp > 0) {
			if(x.getRight()==null) {
				Node tempNode= new Node(word);
				x.setRight(tempNode);
			}
			else {
				put(x.getRight(), word);
			}
		}
		else {
			return;
		}
		
	}
	
	public boolean search(Node root, String word,String[] arr,ArrayList<String> outText) throws IOException{
	    if (root.getData().equals(word)) {
	    		outText.add("\t\t" );
			display(arr,outText);
			outText.add("\n");
	    		return true;	
	    }
	    int cmp=word.compareTo(root.getData());
	    if (cmp < 0) {
	    		if(root.getLeft()==null) {
	    			return false;
	    		}
	    		else {
	    			return search(root.getLeft(), word,arr,outText);
	    		}
	    }
	    else if(cmp>0){
		    	if(root.getRight()==null) {
	    			return false;
	    		}
	    		else {
	    			return search(root.getRight(), word,arr,outText);
	    		}
	    }
		return false;
	}
	
	
	public void giveArray(Node tempRoot,String[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==null) {
				
			}
			else {
				put(tempRoot,arr[i]);
			}
		}
	}
	
	
	public void display(String [] arr,ArrayList<String> outText) throws IOException {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				outText.add(arr[i] + " ");
			}
		}
	}

}
