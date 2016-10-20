package IRCTC_Test_Page;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IRCTCPage{
	WebDriver driver;
	private By Flight = By.xpath("//*[@id='bluemenu']/ul/li[5]/a");
	//private By Oneway = By.xpath("//input[@name='tripType' and @value='One way']");
	//private By RoundTrip = By.xpath("//div[@class='roundtripradio']/input[@name='tripType']");
	private By Value1 = By.xpath("//input[@id='origin']");
	private By Value1Click = By.xpath("//a[contains(text(),'Delhi (New Delhi),DEL')]");
	private By Value2 = By.xpath("//input[@id='destination']");
	private By Value2Click = By.xpath("//a[contains(text(),'Goa,GOI')]");
	private By CalButton = By.xpath("//input[@id='departDate']/following-sibling::img");
	private By CalDate = By.xpath("//a[contains(text(),'20')]");
	private By AdultClick = By.xpath("//select[@id='noOfAdult']/option[@value='2']");
	private By ChildClick = By.xpath("//select[@id='noOfChild']/option[@value='1']");
	private By Search = By.xpath("//div[@onclick='submitSearch();']");

    public IRCTCPage(WebDriver driver)
	{
    	this.driver = driver;
	}
	public void ClickFlight()
	{
	 driver.findElement(Flight).click();	
	}
	public void Enter_Source()
	{
		driver.findElement(Value1).sendKeys("Delhi");
	}
	public void Click_Source()
	{
		driver.findElement(Value1Click).click();
	}
    public void Enter_Destination()
    {
    	driver.findElement(Value2).sendKeys("Goa");
    }
    public void Click_Destination()
    {
    	driver.findElement(Value2Click).click();
    }
    public void Click_Calendar()
    {
    	driver.findElement(CalButton).click();
    }
    public void Enter_Date()
    {
    	driver.findElement(CalDate).click();
    }
    public void Select_Adult()
    {
    	driver.findElement(AdultClick).click();
    }
    public void Select_Child()
    {
    	driver.findElement(ChildClick).click();
    }
    public void ClickSearch()
    {
    	driver.findElement(Search).click();
    }
    public void SwitchWindow()
    {
    	String pw = driver.getWindowHandle();
    	Set<String> allwin = driver.getWindowHandles();
    	for(String s : allwin)
    	{
    		if(s.equals(pw)==false)
    		{
    		driver.switchTo().window(s);
    		
    		break;
    		}
    		
    	}
    	System.out.println("Current url"+driver.getCurrentUrl());
    }
    
    public void TotalFlights()
    {
    	List<WebElement> alllist = driver.findElements(By.xpath("//div[@class='onewayflightinfo']"));
    	System.out.println("Number of count "+alllist.size());
    }
    
    
    
    
    
    
    
    

}