package outdated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;
import org.junit.Test;

public class ExerciseQ1 {
	static ArrayList<String[]> linesRead;
	static Scanner inputStream;
	BasicClass bc = new BasicClass();
	
	@BeforeClass
	public static void setupMethod(){
		linesRead = new ArrayList<String[]>();
		inputStream = null;
		String fileName = "values.txt";
		
		System.out.println("The file " + fileName + "\ncontains the following lines:\n");
		try {
			inputStream = new Scanner(new File(fileName));
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		while (inputStream.hasNextLine())
		{
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(" ");
			linesRead.add(tokens);
		}
/*
		int lineNum = 1;
		for (String[] strArray : linesRead) {
		System.out.print("Line " + lineNum + " : ");
		for (int i = 0; i < strArray.length; i ++)
			System.out.print(strArray[i]+ " ");
		lineNum++;
		System.out.println();
		}
*/
	}
	
	@AfterClass 
	public static void endMethod(){
		inputStream.close();
	}
	
	@Before
	public void setupClass(){
		bc.initializeList();
	}
	
	@Test
	public void testAddStringToList(){
		String [] inputStr = new String [linesRead.get(0).length + linesRead.get(1).length + linesRead.get(2).length];
		int item = 0;
		for(int i = 0; i<linesRead.size(); i++){
			for(int j=0; j<linesRead.get(i).length; j++){
				System.out.println(linesRead.get(i)[j]);
				inputStr[item] = linesRead.get(i)[j];
				item++;
			}
		}
		String[] expectedResult ={"cat", "dog", "mouse", "1", "2", "3", "3", "4", "5", "monkey", "elephant", "zebra", "10", "100", "donkey"};
		bc.setStrLimit(linesRead.get(0).length + linesRead.get(1).length + linesRead.get(2).length);
		bc.addStringsToList(inputStr);
		System.out.println(bc.getArrayList()[1]);
		String [] result = bc.getArrayList();
		assertEquals(expectedResult[0], bc.getArrayList()[0]);
		//assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testGetTotalStringLength(){
		
	}
	
}
