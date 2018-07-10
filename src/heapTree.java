
public class heapTree extends binarySearchTree {

	public heapTree() {
		// TODO Auto-generated constructor stub
	}

	public heapTree(String newWord) {
		super(newWord);
		// TODO Auto-generated constructor stub
	}
	
	public static int findMax(Node node){
        if (node == null)
            return Integer.MIN_VALUE;
 
        int res = String.valueOf(node.getData()).codePointAt(0);
        int lres = findMax(node.getLeft());
        int rres = findMax(node.getRight());
 
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

}
