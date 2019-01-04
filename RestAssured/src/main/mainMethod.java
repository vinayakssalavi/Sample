package main;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;


import util.ExcelReader;

public class mainMethod {

	public static void main (String [] args) throws Exception{
//		RunTest run = new RunTest();
//		run.runTests();
		ExcelReader excel = new ExcelReader();
		List <String> classes = excel.getClassesToRun();
		for(String clas : classes){
//			Thread t1 = (Thread)Class.forName("tests."+clas).newInstance();
//			t1.start();	
			
			
			HashMap<String, String> temp = excel.getTestData(clas);		
			Class obj = Class.forName("tests."+clas);
	        Constructor constructor = obj.getConstructor(HashMap.class);   
			Thread t1 = (Thread)constructor.newInstance(temp);
			t1.start();	
			
			
			
		}
	}
}
