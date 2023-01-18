package Test;

import org.testng.annotations.Test;

import pages.Pnrpage;

public class Pnrpagetest extends Baseclass {
@Test
public void test2() throws Exception
{
	Pnrpage ob=new Pnrpage(driver);
	ob.click();
	ob.datadrive();
	
}

	 
}
