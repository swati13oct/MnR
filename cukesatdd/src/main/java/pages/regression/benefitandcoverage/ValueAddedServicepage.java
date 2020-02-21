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
	
	@FindBy(xpath = "//h2[contains(text(),'At Your Best by UnitedHealthcare™')]")
	private WebElement atYourBestTile;
	
	@FindBy(xpath = "//h2[contains(text(),'Hearing Care Program by HearUSA')]")
	private WebElement hearingCareProgramByHearUSATile;
	   
	public ValueAddedServicepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();	
		}
	
	public void validatenurseHealthLine() {
		validateNew(nurseHealthLine);
	}
	public void validatesilverSneaker() {
		validateNew(silverSneaker);
	}
	public void validatemyCarePath() {
		validateNew(mycarepath);
	}
	public void validatevisionDiscount() {
		validateNew(visionDiscount);
	}
	
	public void validatevasheadertext() {
		validateNew(vasheader);
		validateNew(vastext);
		validateNew(vastext2);
	}
	
	public void validateviewmorelink() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		validateNew(viewmore);
	}
	
	/**
	 * @toDo : Validates the vas tiles on vas page
	 */
	public void vastiles()
	{
		validateNew(atYourBestTile);
		validateNew(hearingCareProgramByHearUSATile);
		//validateNew(driver.findElement(By.xpath("(.//*[@id='servccontroller']/div/section/div/div/div/div)[1]")));
		//validateNew(driver.findElement(By.xpath("(.//*[@id='servccontroller']/div/section/div/div/div/div)[6]")));
	}
	
	public void validateviewmorelinkexpand() {
		viewmore.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		validateNew(disclaimers);
		disclaimers.click();
	}
	
	public void fedtabledata()
	{
	}
	
	public void healthlink() 
	{
		Healthlink.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
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
