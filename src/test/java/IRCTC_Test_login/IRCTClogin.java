package IRCTC_Test_login;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import IRCTC_Test_Page.IRCTCPage;

public class IRCTClogin
{
	
	@Test
	public void IrctcTest() throws InterruptedException, IOException
	{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	IRCTCPage ip = new IRCTCPage(driver);
	//Call function which wil click on flight
	ip.ClickFlight();
	Thread.sleep(5000);
    //Switch window
	ip.SwitchWindow();
	String s = driver.getCurrentUrl();
	Assert.assertTrue(s.contains("air"));
	//sending source key
	ip.Enter_Source();
	//click on source station
	ip.Click_Source();
	// sending destination key
	ip.Enter_Destination();
	// click on destination
	ip.Click_Destination();
	// click on calendar button
	ip.Click_Calendar();
	// click on selected date
	ip.Enter_Date();
	// Select no of Adults
	ip.Select_Adult();
	// Select no of childs
	ip.Select_Child();
	// click on search field
	ip.ClickSearch();
	// calculate no of Flights
	ip.TotalFlights();
	
//	List<WebElement> alllist = driver.findElements(By.xpath("//div[@class='onewayflightinfo']"));
//	Assert.assertTrue(alllist.size()>0 && alllist.size()<100);
//	System.out.println("Number of counts "+alllist.size());
//	
	Thread.sleep(5000);
	driver.close();

	}
}