package inputfile.exercise;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;

import org.junit.Test;

import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)
public class BasicClassTestV2 {
	BasicClass bc;
	static ArrayList<String[]>linesRead;
	static{
		Scanner inputStream;
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
	
	public BasicClassTestV2(){
		System.out.println("In constructor");
		bc = new BasicClass();
		bc.initializeList();
	}
	
	private Object[] paramForBothTestParam(){
		return new Object[]{
			new Object[]{linesRead.get(0), new String[]{"cat", "dog", "mouse", "1", "2", "3"}},
			new Object[]{linesRead.get(1), new String[]{"3", "4", "5", "monkey", "elephant"}},
			new Object[]{linesRead.get(2), new String[]{"zebra", "10", "100", "donkey"}}
		};
	}
	
	@Test
	@Parameters(method = "paramForBothTestParam")
	public void testBothTestParam(String [] input, String [] expectedResult){
		bc.addStringsToList(input);
		String [] result = bc.getArrayList();
		assertArrayEquals(expectedResult, result);
		//System.out.println(bc.getArrayList()[0]);
	}
}
