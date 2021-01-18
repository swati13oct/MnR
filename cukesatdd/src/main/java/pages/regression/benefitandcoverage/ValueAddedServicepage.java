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
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.LoginCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
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
	
	@FindBy(xpath = "//h2[contains(text(),'At Your Best by UnitedHealthcare')]")
	private WebElement atYourBestTile;
	
	@FindBy(xpath = "//h2[contains(text(),'Browse your options')]")
	private WebElement browseYourOptions;
	
	@FindBy(xpath = "//h2[contains(text(),'Hearing Care Program by HearUSA')]")
	private WebElement hearingCareProgramByHearUSATile;
	
	@FindBy(xpath="//h2[normalize-space(text())='Dental Discount']")
	private WebElement dentalDiscountWidget;
	
	@FindBy(xpath="//h2[normalize-space(text())='Dental Discount']/following-sibling::p")
	private WebElement dentalDiscountPara;
	
	@FindBy(xpath="//h2[normalize-space(text())='Dental Discount']/following-sibling::a")
	private WebElement dentalDiscountShowmoreLnk;
	
	@FindBy(xpath="//h2[normalize-space(text())='Dental Discount']/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement dentalDiscountShowmorePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='Hearing Care Program by HearUSA'])[2]")
	private WebElement hearingCareProgramByHearUSAWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='Hearing Care Program by HearUSA'])[2]/following-sibling::p")
	private WebElement hearingCareProgramByHearUSAPara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='Hearing Care Program by HearUSA'])[2]/following-sibling::a")
	private WebElement hearingCareProgramByHearUSAShowMoreLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='Hearing Care Program by HearUSA'])[2]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement hearingCareProgramByHearUSAShowMorePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='SilverSneakers'])[2]")
	private WebElement silverSneakersWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='SilverSneakers'])[2]/following-sibling::p")
	private WebElement silverSneakersPara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='SilverSneakers'])[2]/following-sibling::a")
	private WebElement silverSneakersShowMoreLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='SilverSneakers'])[2]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement silverSneakersShowMorePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[3]")
	private WebElement aarpStayingSharpWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[3]/following-sibling::p")
	private WebElement aarpStayingSharpPara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[3]/following-sibling::a")
	private WebElement aarpStayingSharpShowMoreLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[3]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement aarpStayingSharpShowMorePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[4]")
	private WebElement aarpStayingSharpStageWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[4]/following-sibling::p")
	private WebElement aarpStayingSharpStagePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[4]/following-sibling::a")
	private WebElement aarpStayingSharpShowMoreStageLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[4]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement aarpStayingSharpShowMoreStagePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='24/7 Nurse line'])[2]")
	private WebElement nurseLineWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='24/7 Nurse line'])[2]/following-sibling::p")
	private WebElement nurseLinePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='24/7 Nurse line'])[2]/following-sibling::a")
	private WebElement nurseLineShowMoreLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='24/7 Nurse line'])[2]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement nurseLineShowMorePara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[5]")
	private WebElement aarpVisionDiscountsWidget;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[5]/following-sibling::p")
	private WebElement aarpVisionDiscountsPara;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[5]/following-sibling::a")
	private WebElement aarpVisionDiscountsShowMoreLnk;
	
	@FindBy(xpath="(//h2[normalize-space(text())='AARP'])[5]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement aarpVisionDiscountsShowMorePara;
	
	@FindBy(xpath="(//h2[contains(text(),'AARP Smart Driver')])[1]")
	private WebElement aarpSmartDriverWidget;
	
	@FindBy(xpath="(//h2[contains(text(),'AARP Smart Driver')])[1]/following-sibling::p")
	private WebElement aarpSmartDriverPara;
	
	@FindBy(xpath="(//h2[contains(text(),'AARP Smart Driver')])[1]/following-sibling::a")
	private WebElement aarpSmartDriverShowMoreLnk;
	
	@FindBy(xpath="(//h2[contains(text(),'AARP Smart Driver')])[1]/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement aarpSmartDriverShowMorePara;
	
	@FindBy(xpath="//h2[normalize-space(text())='Renew Active']")
	private WebElement renewActiveWidget;
	
	@FindBy(xpath="//h2[normalize-space(text())='Renew Active']/following-sibling::p")
	private WebElement renewActivePara;
	
	@FindBy(xpath="//h2[normalize-space(text())='Renew Active']/following-sibling::a")
	private WebElement renewActiveShowMoreLnk;
	
	@FindBy(xpath="//h2[normalize-space(text())='Renew Active']/../../../../../section[contains(@id,'collapseLargeCard')]")
	private WebElement renewActiveShowMorePara;
	
	@FindBy(xpath="//a[normalize-space(text())='Plan Benefits & Coverage']")
	private WebElement planBenifitsAndCoverageLnk;
	   
	public ValueAddedServicepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();	
	}
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
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
	 * @throws InterruptedException 
	 * @toDo : Validates the vas tiles on vas page
	 */
	
	//VAS widgets will display as per user plancode & statecode
	public void vastiles(String planCode, String stateCode) throws InterruptedException
	{
	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(planCode.equalsIgnoreCase("F01") && stateCode.equalsIgnoreCase("AR")) {
			validate(silverSneakersWidget);
			
			validate(silverSneakersPara);
			
			Assert.assertTrue(silverSneakersPara.getText().trim().contains("SilverSneakers is an exercise program for active older adults."));
			
			silverSneakersShowMoreLnk.click();
			
			Thread.sleep(2000);
			
			CommonUtility.waitForPageLoadNew(driver, silverSneakersShowMorePara, 20);
			
			Assert.assertTrue(silverSneakersShowMorePara.getText().contains("SilverSneakers gives you access to thousands of participating locations"));
			
			CommonUtility.waitForPageLoadNew(driver, silverSneakersShowMoreLnk, 20);
			
			silverSneakersShowMoreLnk.click();
			
			Thread.sleep(2000);
			
			Assert.assertTrue("'Renew ActiveTM by UnitedHealthcare' is not expected to display", !validate(renewActiveWidget));
			
		}else if(planCode.equalsIgnoreCase("G01") && stateCode.equalsIgnoreCase("LA")) {
			
			validate(renewActiveWidget);
			
			validate(renewActivePara);
			
			Assert.assertTrue(renewActivePara.getText().trim().contains("Gives you access to an extensive network of gyms and fitness locations near you"));
			
			renewActiveShowMoreLnk.click();
			
			Thread.sleep(2000);
			
			//CommonUtility.waitForPageLoadNew(driver, renewActiveShowMorePara, 20);
			scrollElementToCenterScreen(renewActiveShowMorePara);
			Assert.assertTrue(renewActiveShowMorePara.getText().contains("You will need a confirmation code to take advantage of these services."));
			
			CommonUtility.waitForPageLoadNew(driver, renewActiveShowMoreLnk, 20);
			
			renewActiveShowMoreLnk.click();
			
			Thread.sleep(2000);
			
			Assert.assertTrue("'silverSneakersWidget' is not expected to display", !validate(silverSneakersWidget));
			
		}
		WebElement widgets[] = {dentalDiscountWidget, hearingCareProgramByHearUSAWidget, aarpStayingSharpWidget, 
				nurseLineWidget, aarpVisionDiscountsWidget, aarpSmartDriverWidget};
		
		WebElement widgetsPara[] = {dentalDiscountPara, hearingCareProgramByHearUSAPara, aarpStayingSharpPara,
				nurseLinePara, aarpVisionDiscountsPara, aarpSmartDriverPara};
		
		String widgetsUIPara[] = {"You can receive discounts for dental services from in-network dentists through Dentegra.",
				"You have access to a discount on hearing aids and screenings by certified HearUSA hearing care providers.",
				"You have access to an online brain health program that helps support a healthy brain lifestyle.",
				"A registered nurse is available to discuss your concerns and answer questions over the phone anytime, day or night.",
				"You have access to savings on eye health services that include:",
				"helps participants brush up on rules of the road"};
		
		
		for(int i=0; i<widgets.length; i++) {
			validate(widgets[i]);
			validate(widgetsPara[i]);
			if(driver.getCurrentUrl().contains("stage") && i==2) {
				widgetsPara[i] = aarpStayingSharpStagePara;
			}
			
			Assert.assertTrue(widgetsPara[i].getText().trim().contains(widgetsUIPara[i]));
			
		}
		
		Assert.assertTrue("'BrowseYourOptions' is not expected to display", !browseYourOptions.isSelected());
		
		Assert.assertTrue("'AtYourBestTile' is not expected to display", !validate(atYourBestTile));
	
		dentalDiscountShowmoreLnk.click();
		
		Thread.sleep(2000);
		
		CommonUtility.waitForPageLoadNew(driver, dentalDiscountShowmorePara, 20);
		
		Assert.assertTrue(dentalDiscountShowmorePara.getText().contains("To take advantage of this offer"));
		
		CommonUtility.waitForPageLoadNew(driver, dentalDiscountShowmoreLnk, 20);
		
		dentalDiscountShowmoreLnk.click();
		
		Thread.sleep(2000);
		
		CommonUtility.waitForPageLoadNew(driver, hearingCareProgramByHearUSAShowMoreLnk, 20);
		
		hearingCareProgramByHearUSAShowMoreLnk.click();
		
		Thread.sleep(2000);
		
		CommonUtility.waitForPageLoadNew(driver, hearingCareProgramByHearUSAShowMorePara, 20);
		
		Assert.assertTrue(hearingCareProgramByHearUSAShowMorePara.getText().contains("To take advantage of the hearing program"));
		
		CommonUtility.waitForPageLoadNew(driver, hearingCareProgramByHearUSAShowMoreLnk, 20);
		
		hearingCareProgramByHearUSAShowMoreLnk.click();
		
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().contains("stage")) {
			aarpStayingSharpShowMoreStageLnk.click();
			
			Thread.sleep(2000);
			
			CommonUtility.waitForPageLoadNew(driver, aarpStayingSharpShowMoreStagePara, 20);
			
			Assert.assertTrue(aarpStayingSharpShowMoreStagePara.getText().contains("Get your code from the right column of your Health and Wellness page"));
			
			CommonUtility.waitForPageLoadNew(driver, aarpStayingSharpShowMoreStageLnk, 20);
			
			aarpStayingSharpShowMoreStageLnk.click();
			
			Thread.sleep(2000);
		}else {
			aarpStayingSharpShowMoreLnk.click();
			
			Thread.sleep(2000);
			
			CommonUtility.waitForPageLoadNew(driver, aarpStayingSharpShowMorePara, 20);
			
			Assert.assertTrue(aarpStayingSharpShowMorePara.getText().contains("To get started, go to Renew Active"));
			
			CommonUtility.waitForPageLoadNew(driver, aarpStayingSharpShowMoreLnk, 20);
			
			aarpStayingSharpShowMoreLnk.click();
			
			Thread.sleep(2000);
		}
		
		scrollElementToCenterScreen(nurseLineShowMoreLnk);
		CommonUtility.waitForPageLoadNew(driver, nurseLineShowMoreLnk, 20);
		nurseLineShowMoreLnk.click();
		Thread.sleep(2000);
		scrollElementToCenterScreen(nurseLineShowMorePara);
		//CommonUtility.waitForPageLoadNew(driver, nurseLineShowMorePara, 20);
		
		Assert.assertTrue(nurseLineShowMorePara.getText().contains("Just dial 1-888-543-5630 (TTY 711) any time, 24 hours a day, 7 days a week, and connect with a nurse."));
		
		CommonUtility.waitForPageLoadNew(driver, nurseLineShowMoreLnk, 20);
		
		scrollElementToCenterScreen(nurseLineShowMoreLnk);
		nurseLineShowMoreLnk.click();
		Thread.sleep(2000);
		
		
		aarpVisionDiscountsShowMoreLnk.click();
		Thread.sleep(2000);

		scrollToView(aarpVisionDiscountsShowMorePara);
	//	CommonUtility.waitForPageLoadNew(driver, aarpVisionDiscountsShowMorePara, 20);
		
		Assert.assertTrue(aarpVisionDiscountsShowMorePara.getText().contains("To benefit from the savings and service of this vision discount program"));
		
		CommonUtility.waitForPageLoadNew(driver, aarpVisionDiscountsShowMoreLnk, 20);
		
		scrollElementToCenterScreen(aarpVisionDiscountsShowMoreLnk);
		
		aarpVisionDiscountsShowMoreLnk.click();
		
		Thread.sleep(2000);		
	
		CommonUtility.waitForPageLoadNew(driver, aarpSmartDriverShowMoreLnk, 20);
		
		aarpSmartDriverShowMoreLnk.click();
		
		Thread.sleep(2000);
		
		scrollToView(aarpSmartDriverShowMorePara);
		CommonUtility.waitForPageLoadNew(driver, aarpSmartDriverShowMorePara, 20);
		
		scrollToView(aarpSmartDriverShowMorePara);
		
		Assert.assertTrue(aarpSmartDriverShowMorePara.getText().contains("Here’s how to Register:"));
		
		CommonUtility.waitForPageLoadNew(driver, aarpSmartDriverShowMoreLnk, 20);
		
		scrollElementToCenterScreen(aarpSmartDriverShowMoreLnk);
		aarpSmartDriverShowMoreLnk.click();
		
		Thread.sleep(2000);
		
		scrollElementToCenterScreen(planBenifitsAndCoverageLnk);
		//CommonUtility.waitForPageLoadNew(driver, planBenifitsAndCoverageLnk, 20);
		
		planBenifitsAndCoverageLnk.click();
		
		//TODO
		//Assert.assertTrue("PROBLEM - unable to locate element for 'At Your Best by UnitedHealthcare' or 'Browse your options'", 
				//validate(atYourBestTile) || validate(browseYourOptions));
		/* tbd 
		if(atYourBestTile!=null) {
			validateNew(atYourBestTile);
		}else {
			validateNew(browseYourOptions);
		} */
		//validateNew(hearingCareProgramByHearUSATile);
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
	
	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
	}
}
