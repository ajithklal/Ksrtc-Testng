package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pnrpage {
	WebDriver driver;
	
	By pnrbutton=By.xpath("/html/body/header/section[2]/div/div/div[2]/a[2]");
	By transtatus=By.xpath("//*[@id=\"profile-tab\"]");
	By obnumbercol=By.name("bankRefNo");
	By subbutton =By.name("searchBtn");
	
	public Pnrpage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void click()
	{
		driver.findElement(pnrbutton).click();
		driver.findElement(transtatus).click();
	}
	public void datadrive() throws Exception
	{
		
		FileInputStream ob= new FileInputStream("C:\\Users\\User\\Desktop\\KSRTC.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(ob);
		XSSFSheet sh= wb.getSheet("testdata");
		int rowsize=sh.getLastRowNum();
		for(int i=1;i<=rowsize;i++)
		{
			String obno=sh.getRow(i).getCell(0).getStringCellValue();
			
			driver.findElement(obnumbercol).sendKeys(obno);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(subbutton)).click();
			
		}
	}
}
