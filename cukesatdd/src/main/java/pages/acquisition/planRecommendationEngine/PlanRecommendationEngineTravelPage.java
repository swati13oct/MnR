/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;

public class PlanRecommendationEngineTravelPage extends UhcDriver {

	public PlanRecommendationEngineTravelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	String page = "Step 4: Care Away From Home";
	
	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	
	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Special Needs Page Elements

	@FindBy(xpath = "//*[@class='progress-bar-title']/h1")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;
	
	@FindBy(css = "legend.primary-question-tex>span:nth-child(2)")
	private WebElement travelTitle;
	
	@FindBy(css = "legend.primary-question-tex>span:nth-child(2)>sup")
	private WebElement travelTitleRedAsterisk;
	
	@FindBy(css = "legend.primary-question-tex>span:nth-child(3)")
	private WebElement travelPara;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;
	
	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;
	
	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(2)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement travelWithin;
	
	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(3)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement travelAnotherpart;
	
	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(4)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement travelPrimary;
	
	@FindBy(css = "uhc-checkbox-group>fieldset>div:nth-child(5)>uhc-checkbox>label>span.checkbox-label-content>span.labelCheck")
	private WebElement travelNone;
	
	@FindBy(css = "#errorMessage>span:nth-child(2)")
	private WebElement errorMessage;


//Travel Page Element Verification Method 
	
		public void travelPageElement() {
			System.out.println("Travel Validating Page: ");
			String currentPageUrl = driver.getCurrentUrl();	
			currentPageUrl.contains("/plan-recommendation-engine.html/");
			validate(planSelectorPageTilte);
			Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
			validate(pageStepsNumberName, 30);
			validate(pageProgressPercentage, 30);
			desktopCommonUtils.currentPageValidation(page.toUpperCase());
			validate(pageRequiredInfo);
			Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
			validate(travelWithin);
			Assert.assertTrue(travelWithin.getText().contains("within"));
			validate(travelAnotherpart, 30);
			Assert.assertTrue(travelAnotherpart.getText().contains("another"));
			validate(travelPrimary, 30);
			Assert.assertTrue(travelPrimary.getText().contains("primary"));
			validate(travelNone, 30);
			Assert.assertTrue(travelNone.getText().contains("None"));
			previousBtn.click();
			System.out.println("Validationg "+page+" page Previous button functionality");
			desktopCommonUtils.previousPageValidation(page.toUpperCase());
		}
		
// Splitting the input options and selecting it and Clicking on Continue Button 		
		public void travelpage(String options,String status) {
			if(status.equals("Positive")) {
				String snpoptions[] = options.split(",");
				for(String option:snpoptions) {
					travelpageFunctional(option);

				}
				continueBtn.click();
			}else {
				if(options.isEmpty()){
					continueBtn.click();
					validate(errorMessage, 30);
					Assert.assertTrue(errorMessage.getText().contains("No"));
				}else if(options.contains("None")) {
					String snpoptions[] = options.split(",");
					for(String option:snpoptions) {
						travelpageFunctional(option);
					}
					continueBtn.click();
					validate(errorMessage, 30);
					Assert.assertTrue(errorMessage.getText().contains("Please"));
				}
			}			
		}
		
		
//Care Away Page Function Verification		
		
		public void travelpageFunctional(String TravelType) {
			System.out.println("SNP Option "+TravelType+ " Selection");
			if (TravelType.equalsIgnoreCase("within")) {
				validate(travelWithin);
				travelWithin.click();
				System.out.println("Plan Type "+TravelType +" Clicked");
			}else if (TravelType.equalsIgnoreCase("another")) {
				validate(travelAnotherpart);
				travelAnotherpart.click();
				System.out.println("Plan Type "+TravelType +" Clicked");
			}else if (TravelType.equalsIgnoreCase("primary")) {
				validate(travelPrimary);
				travelPrimary.click();
				System.out.println("Plan Type "+TravelType +" Clicked");
			}else if (TravelType.equalsIgnoreCase("None")) {
				validate(travelNone);
				travelNone.click();
				System.out.println("Plan Type "+TravelType +" Clicked");
			}			
			
		}

	public void browserBack() {

		driver.navigate().back();
	}
}
