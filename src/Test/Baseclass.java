package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
public  WebDriver driver;
@BeforeClass
public void setup()
{
	driver=new ChromeDriver();
	driver.get("https://online.keralartc.com/oprs-web/");
}
}
