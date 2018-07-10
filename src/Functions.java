import java.util.ArrayList;

public class Functions {
	
	private int memorySize;
	private String searchType;
	private String replacementType;
	private ArrayList<String> readList = new ArrayList<String>();
	
	public void valueDeterminer(ArrayList<String> textList) {
		this.setMemorySize(Integer.parseInt(textList.get(0).split(" ")[1]));
		this.setReplacementType(textList.get(1).split(" ")[1]);
		this.setSearchType(textList.get(2).split(" ")[1]);
		for(int i=3;i<textList.size();i++) {
			readList.add(textList.get(i).split(" ")[1]);
		}
	}
	
	public String getReplacementType() {
		return replacementType;
	}

	public void setReplacementType(String replacementType) {
		this.replacementType = replacementType;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}
	
	
	public void printerType(ArrayList<String> outText) {
		outText.add("Memory" +this.getMemorySize() + "\n");
		outText.add(this.getReplacementType() + " Page Replacement\n");
		outText.add("Binary Search Tree\n");
	}

	/**
	 * @return the readList
	 */
	public ArrayList<String> getReadList() {
		return readList;
	}

	
	
}
