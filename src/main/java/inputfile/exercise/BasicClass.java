package inputfile.exercise;

import java.util.ArrayList;


public class BasicClass {
	private ArrayList<String>strList;
	private int strLimit = 0;
	
	public void initializeList(){
		strList = new ArrayList<String>();
	}
	
	public void setStrLimit(int  strLimit){
		this.strLimit = strLimit;
	}
	
	public String[]getArrayList(){
		String [] returnStr = new String[strList.size()];
		returnStr = strList.toArray(returnStr);
		return returnStr;
	}
	
	public void addStringsToList(String[]strToAdd){
		for (int i = 0; i < strToAdd.length; i++){
			if(strToAdd[i].length() > strLimit)
				strList.add(strToAdd[i]);
		}
	}
	
	public int getTotalStringLength(){
		int totalCount = 0;
		for (String str : strList){
			totalCount += str.length();
		}
		return totalCount;
	}
}
