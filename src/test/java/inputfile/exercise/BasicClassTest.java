package inputfile.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.*;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BasicClassTest {
	static ArrayList<String[]>linesRead;
	static Scanner inputStream;
	static BasicClass bc = new BasicClass();
	@BeforeClass
	public static void SetupClass(){
		bc.initializeList();
		linesRead = new ArrayList<String[]>();
		String fileName = "values.txt";
		inputStream = null;
		try{
			inputStream = new Scanner(new File(fileName));
		}catch (FileNotFoundException e){
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		while(inputStream.hasNextLine()){
			String singleLine = inputStream.nextLine();
			String[]tokens = singleLine.split(" ");
			linesRead.add(tokens);
		}
	}
	@AfterClass
	public static void EndClass(){
		inputStream.close();
	}
	@Before
	public void SetupMethod(){
		bc.initializeList();
		int lineNum = 1;
		for (String[]strArray : linesRead){
			System.out.print("Line " + lineNum + " : ");
			for(int i = 0; i < strArray.length; i++){
				System.out.print(strArray[i] + " ");
			}
			lineNum++;
			System.out.println();
		}
	}
	
	@Test
	public void testBothSUTV1(){
		bc.addStringsToList(linesRead.get(0));
		String [] result = bc.getArrayList();
		String [] expectedResult = {"cat", "dog", "mouse", "1", "2", "3"};
		assertArrayEquals(expectedResult, result);
		//System.out.println(bc.getArrayList()[0]);
	}
	@Test
	public void testBothSUTV2(){
		bc.addStringsToList(linesRead.get(1));
		String [] result = bc.getArrayList();
		String [] expectedResult = {"3", "4", "5", "monkey", "elephant"};
		assertArrayEquals(expectedResult, result);
		//System.out.println(bc.getArrayList()[0]);
	}
	@Test
	public void testBothSUTV3(){
		bc.addStringsToList(linesRead.get(2));
		String [] result = bc.getArrayList();
		String [] expectedResult = {"zebra", "10", "100", "donkey"};
		assertArrayEquals(expectedResult, result);
		//System.out.println(bc.getArrayList()[0]);
	}
}
