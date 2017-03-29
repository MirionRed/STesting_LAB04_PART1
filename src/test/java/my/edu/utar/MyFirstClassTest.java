package my.edu.utar;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;
import org.junit.Ignore;

@RunWith(JUnitParamsRunner.class)
public class MyFirstClassTest {
	
	/*
	@Test
	public void testAddTwoNumbers(){
		Student s = new Student();
		int result = s.addTwoNumbers(10, 15);
		assertEquals(25, result);
	}
	*/
	
	@Test
	public void testSetAge(){
		Student s = new Student("Peter", 25);
		s.setAge(30);
		assertEquals(30,s.getAge());
	}
	
	@Ignore("Temporarily skipped this test")
	@Test
	@Parameters({"Peter, 25, 30, true", "Peter, 25, -5, false", "Peter, 25, 180, false"})
	public void testSetAgeV2(String name, int age, int change, boolean expectedResult){
		Student s = new Student(name,age);
		boolean result =s.setAgeV2(change);
		if (expectedResult){
			assertEquals(change, s.getAge());
			assertTrue(result);
		}else{
			assertEquals(age, s.getAge());
			assertFalse(result);
		}
	}
	
	@Test
	@Parameters({"Peter, 25, 30", "Peter, 25, 70"})
	public void testSetAgeV4Valid(String name,int age,int change){
		Student s = new Student(name, age);
		s.setAgeV4(change);
		assertEquals(change, s.getAge());
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters({"Peter, 25, -5", "Peter, 25, 180"})
	public void testSetAgeV4Invalid(String name, int age, int change){
		Student s = new Student(name,age);
		s.setAgeV4(change);
	}
	
	
	@Test(timeout = 100)
	@Parameters({"10000", "50000", "100000"})
	public void testCreateMultipleObjects(int numObjects){
		ArrayList<Student>sList = new ArrayList<Student>();
		for (int i = 0; i<numObjects; i++){
			sList.add(new Student("Peter", 25));
		}
	}
	
}
