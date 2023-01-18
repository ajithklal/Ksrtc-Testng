package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ksrtcmainpage {
WebDriver driver;

By startingpoint = By.name("fromPlaceName");
By endpoint =By.name("toPlaceName");
By departuredate=By.id("txtJourneyDate");

By depmonth=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]");
By scroll=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
By alldates=By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a");
By button=By.xpath("//*[@id=\"searchBtn\"]");
public Ksrtcmainpage(WebDriver driver)
{
	this.driver=driver;
}
public void title()
{
	String a=driver.getTitle();
	System.out.println(a);
	if(a.contains("KERALA RTC Official Website for Online Bus Ticket Booking - online.keralartc.com"))
	{
		System.out.println("Title is correct");
	}else 
	{
		System.out.println("Title is wrong");
	}

}
public void setvalues(String startingpoint1,String endpoint1)
{
	driver.findElement(startingpoint).sendKeys(startingpoint1);
	driver.findElement(endpoint).sendKeys(endpoint1);
}

public void depdate()
{
	driver.findElement(departuredate).click();
	
	
}
public void select()
{
	while(true)
	{
		WebElement month=driver.findElement(depmonth);
	String month1=month.getText();
	
	if(month1.equals("February"))
	{
		System.out.println(month1);
		break;
	}else
	{
		driver.findElement(scroll).click();
	}
	}
	
	List<WebElement> alldates1=driver.findElements(alldates);
	

    
    for (WebElement dateelement : alldates1) {
        try {
            String date = dateelement.getText();
            if (date.equals("11")) {
                System.out.println(date);
                dateelement.click();
                System.out.println("date selected");
            }
        } catch (StaleElementReferenceException e) {
            continue;
        }
    }
}
public void search()
{
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	wait.until(ExpectedConditions.elementToBeClickable(button)).click();
	
}
}

