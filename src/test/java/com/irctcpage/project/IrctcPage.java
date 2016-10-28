package com.irctcpage.project;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcPage{
	WebDriver driver;
	private By Flight = By.xpath("//*[@id='bluemenu']/ul/li[5]/a");
	private By Value1 = By.xpath("//input[@id='origin']");
	//private By Value1Click = By.xpath("//a[contains(text(),'Delhi (New Delhi),DEL')]");
	private By Value2 = By.xpath("//input[@id='destination']");
	//private By Value2Click = By.xpath("//a[contains(text(),'Goa,GOI')]");
	private By CalButton = By.xpath("//input[@id='departDate']/following-sibling::img");
	private By CalDate = By.xpath("//a[contains(text(),'20')]");
	private By AdultClick = By.xpath("//select[@id='noOfAdult']/option[@value='2']");
	private By ChildClick = By.xpath("//select[@id='noOfChild']/option[@value='1']");
	private By Search = By.xpath("//div[@onclick='submitSearch();']");

    public IrctcPage(WebDriver driver)
	{
    	this.driver = driver;
	}
	public void ClickFlight()
	{
	 driver.findElement(Flight).click();	
	}
	public void Enter_Source( String source) throws InterruptedException
	{
		driver.findElement(Value1).sendKeys(source);
		Thread.sleep(2000);
		driver.findElement(Value1).sendKeys(Keys.TAB);
	}
	
    public void Enter_Destination(String Desti) throws InterruptedException
    {
    	driver.findElement(Value2).sendKeys(Desti);
    	Thread.sleep(2000);
    	driver.findElement(Value2).sendKeys(Keys.TAB);
    	
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