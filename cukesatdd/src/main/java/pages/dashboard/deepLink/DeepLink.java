package pages.dashboard.deepLink;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;
import org.junit.Assert;
import pages.dashboard.eob.EOBPage;

public class DeepLink extends UhcDriver{

	public DeepLink(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
  
	public DeepLink enterDesiredURL(String deepLinkURL){
		start(deepLinkURL);
		if(driver.getTitle().equals("overview")){
			return new DeepLink(driver);
		}
		return null; 
	}
	
	public DeepLink loginToDashboardPage(String userName){
 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		System.out.println(userName);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		driver.findElement(By.id("sign-in-btn")).click();
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			/*Alert alert1 = driver.switchTo().alert();
			alert1.accept();*/
			}catch(Exception e)		{
				System.out.println("No Such alert displayed");
			}
		
		return new DeepLink(driver);
	}
	
	public DeepLink validateDeepLinkPage(String deepLinkPage){
		if(driver.getTitle().equals(deepLinkPage)){
			System.out.println("desire page displayed  "+deepLinkPage);
			Assert.assertTrue(true);
 		}else {
 			System.out.println("desire page not displayed "+deepLinkPage);
 			Assert.fail();
		}
		return null;
	}
}
