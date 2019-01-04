package tests;

import java.util.HashMap;
import java.util.Map.Entry;

public class Get extends Thread{
	
	HashMap<String, String> temp;
	public Get(HashMap<String, String> testData) {
		// TODO Auto-generated constructor stub
		temp = new HashMap<String, String>(testData);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Calling Get Method");
			Thread.sleep(3000);
			System.out.println("Calling again Get Method");
			Thread.sleep(3000);
			System.out.println("Calling again  and again Get Method");
			Thread.sleep(3000);
			displyMap(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void displyMap(HashMap<String, String> testData)
	{
		System.out.println("###################Get DATA############################");
		for(Entry<String, String> entry : testData.entrySet())
		{
			System.out.println("Key:::  "+ entry.getKey()+ "   Value:::::" + entry.getValue() );
		}
	}
}
