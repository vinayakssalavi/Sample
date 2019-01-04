package tests;

import java.util.HashMap;
import java.util.Map.Entry;

public class POST extends Thread {

	HashMap<String, String> temp;
	public POST(HashMap<String, String> testData) {
		// TODO Auto-generated constructor stub
		temp = new HashMap<String, String>(testData);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Calling POST Method");
			Thread.sleep(1000);
			System.out.println("Calling again POST Method");
			Thread.sleep(1000);
			System.out.println("Calling again  and again POST Method");
			Thread.sleep(1000);
			displyMap(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTestData(HashMap<String, String> m)
	{
		temp.putAll(m);
	}
	
	
	public static void displyMap(HashMap<String, String> testData)
	{
		
		System.out.println("###################POST DATA############################");
		
		for(Entry<String, String> entry : testData.entrySet())
		{
			System.out.println("Key:::  "+ entry.getKey()+ "   Value:::::" + entry.getValue() );
		}
	}
}
