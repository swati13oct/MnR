/**
 * 
 */
package pages.regression.benefitandcoverage;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author pjaising
 */

public class ValueAddedServicepage extends UhcDriver {

	@FindBy(className= "atdd-vas-nurselineimage")
	private WebElement nurseHealthLine;
	
	@FindBy(id = "silverSneaker")
	private WebElement silverSneaker;
	
	@FindBy(id = "mycarePath")
	private WebElement mycarepath;
	
	@FindBy(id = "visionDiscount")
	private WebElement visionDiscount;
	
	@FindBy(className = "atdd-vas-title")
	private WebElement vasheader; 
	
	@FindBy(className = "atdd-vas-subtitle")
	private WebElement vastext;
	
	@FindBy(className = "atdd-vas-descrptiontext")
	private WebElement vastext2;
	
	@FindBy(xpath = ".//*[@id='servccontroller']/div/section/div/div/div/div/div/div/div/div/div[2]/div/a/span[1]")
	private WebElement viewmore;
	
	@FindBy(className = "atdd-vas-maincta-button")
	private WebElement maincta;
	
	@FindBy(id="collapseLargeCard1")
	private WebElement viewlinkexpand;
	
	@FindBy(xpath=".//*[@id='collapseLargeCard1']/div/div[1]/div/div/div/a")
	private WebElement disclaimers;
	
	@FindBy(xpath = ".//*[@id='collapseLargeCard1']/div/div[1]/p[5]/a")
	private WebElement Healthlink;
	
	//private PageData valueAddedservicePage; 

	public ValueAddedServicepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();	
		}
	
	public void validatenurseHealthLine() {
		// TODO Auto-generated method stub
		validate(nurseHealthLine);
	}
	public void validatesilverSneaker() {
		// TODO Auto-generated method stub
		validate(silverSneaker);
	}
	public void validatemyCarePath() {
		// TODO Auto-generated method stub
		validate(mycarepath);
	}
	public void validatevisionDiscount() {
		// TODO Auto-generated method stub
		validate(visionDiscount);
	}
	
	public void validatevasheadertext() {
		// TODO Auto-generated method stub
		validate(vasheader);
		validate(vastext);
		validate(vastext2);
	}
	
	public void validateviewmorelink() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		validate(viewmore);
		
		
	}
	

	
	public void validateviewmorelinkexpand() {
		// TODO Auto-generated method stub
		viewmore.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(disclaimers);
		disclaimers.click();
	}
	
	public void healthlink() 
	{
		Healthlink.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertThat(driver.getCurrentUrl(),containsString("www.healthyourway.com"));
		
		Actions builder = new Actions(driver);
		Action movetab = builder.keyDown(Keys.CONTROL)
		                 .sendKeys(Keys.TAB)
		                 .keyUp(Keys.CONTROL)
		                 .build();
		movetab.perform();
		
	}
	
	
	public void openAndValidate(){
		
	}
}







