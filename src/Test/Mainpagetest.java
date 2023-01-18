
package Test;

import org.testng.annotations.Test;

import pages.Ksrtcmainpage;

public class Mainpagetest extends Baseclass {
	
	@Test
	public void Test1()
	{
		Ksrtcmainpage ob=new Ksrtcmainpage(driver);
		ob.title();
	}
	

	@Test
	public void Test2()
	{
		
		Ksrtcmainpage ob=new Ksrtcmainpage(driver);
		
		ob.setvalues("THRISSUR", "BANGALORE");
		ob.depdate();
		ob.select();
		ob.search();
	}
	
	
}
