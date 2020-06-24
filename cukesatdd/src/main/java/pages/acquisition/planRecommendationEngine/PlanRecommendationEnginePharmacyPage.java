/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class PlanRecommendationEnginePharmacyPage extends UhcDriver {

                public PlanRecommendationEnginePharmacyPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                }
                
                @Override
                public void openAndValidate() {
                                checkModelPopup(driver);
                                clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
                                waitTillFrameAvailabeAndSwitch(iframePst, 45);
                }
                
                String page = "Pharmacy";
                
                PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
                
                @FindBy(id = "planSelectorTool")
                private WebElement iframePst;

// Drugs page Elements

                @FindBy(css = "#progress-bar-title")
                private WebElement planSelectorPageTilte;

                @FindBy(xpath = "//*[@class='progress-bar-info']/h2")
                private WebElement pageStepsNumberName;
                
                @FindBy(xpath = "//*[@class='progress-bar-info']/p")
                private WebElement pageProgressPercentage;
                
                @FindBy(css = "div legend.primary-question-tex")
                private WebElement pharmacyTitle;
                
                @FindBy(css = "div legend.primary-question-tex span>sup")
            	private WebElement pharmacyPagePrimaryQuestionMark;
                
                @FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex>span:nth-child(3)")
                private WebElement pharmacyTitleInfo;
                
                @FindBy(xpath = "//button[contains(text(),'Continue')]")
                private WebElement continueBtn;
                
                @FindBy(xpath = "//button[contains(text(),'Previous')]")
                private WebElement previousBtn;
                
             // --- Common elements Ends above ---                
                
                @FindBy(css = "p.all-fields-marked-wi")
                private WebElement pageRequiredInfo;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
                private WebElement onlinePharmacy;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
                private WebElement retailPharmacy;
                
                @FindBy(css = "#errorMessage")
                private WebElement errorMessage;
                
                @FindBy(xpath = "//*[contains(@class,'radio-checked')]")
                private WebElement radioselect;			          	

//Pharmacy Page Element Verification Method 
                
                                public void pharmacypage() {
                                                System.out.println("Validating Pharmacy Page: ");
                                                String currentPageUrl = driver.getCurrentUrl(); 
                                                currentPageUrl.contains("/plan-recommendation-engine.html/");
                                                validate(planSelectorPageTilte);
//                                                Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
                                                validate(pageStepsNumberName, 30);
                                                validate(pageProgressPercentage, 30);
                                                desktopCommonUtils.currentPageValidation(page.toUpperCase());
                                                validate(pageRequiredInfo);
//                                                Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
                                                validate(pharmacyTitle);
//                                                Assert.assertTrue(pharmacyTitle.getText().contains("pharmacy"));
                                                validate(pharmacyPagePrimaryQuestionMark);
                                                validate(onlinePharmacy, 30);
//                                                Assert.assertTrue(onlinePharmacy.getText().contains("Online"));
                                                validate(retailPharmacy, 30);
//                                                Assert.assertTrue(retailPharmacy.getText().contains("Retail"));
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previousPageValidation(page.toUpperCase());
                                }
                                
                                
// Selecting Pharmacy options in Pharmacy Page
                                
                                public void pharmacypageOptions(String pharmacyoption) {
                                	System.out.println("Pharmacy option selection in Pharmacy Page");
                                    if (pharmacyoption.equalsIgnoreCase("Online")) {
                                                    validate(onlinePharmacy);
                                                    onlinePharmacy.click();
                                                    System.out.println("Pharmacy Type "+ pharmacyoption +" Clicked");
                                    }else if (pharmacyoption.equalsIgnoreCase("Retail")) {
                                                    validate(retailPharmacy);
                                                    retailPharmacy.click();
                                                    System.out.println("Pharmacy Type "+ pharmacyoption +" Clicked");
                                    } 
                                }
// Selecting Pharmacy options and processed to Addtional Service Page
                                
                                public void doctorspageFunctional(String pharmacy) {
                                	System.out.println("Pharmacy Page Functional Operations");
                                	pharmacypageOptions(pharmacy);
                                    continueBtn.click();
                                    System.out.println("Validating " + page + " page Continue button functionality");
                                    desktopCommonUtils.nextPageValidation(page.toUpperCase());
                                }  
                                
//Pharmacy Page Function Verification     
                                
                                public void pharmacypageerror() {
                                                System.out.println("Pharmacy type not selected - Error Scenario in Pharmacy Page");
                                                continueBtn.click();
                                                desktopCommonUtils.desktopErrorValidation(page);
                                }                                
                                
                                
//Pharmacy page - Select Pharmacy Type and click on Previous Button              
                                
                                public void pharmacypagePreviousButton(String pharmacy) {
                                                System.out.println("Pharmacy Page Previous Button Functionality");
                                                pharmacypageOptions(pharmacy);
                                                if(radioselect.isDisplayed()) {
                                                                validate(pageProgressPercentage, 30);
                                                                Assert.assertTrue(pageProgressPercentage.getText().contains("60% Complete"));
                                                }else {
                                                                System.out.println("Pharmacy Type not selected in Doctors Page");
                                                }
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previousPageValidation(page.toUpperCase());
                                }
                                
                public void browserBack() {

                                driver.navigate().back();
                }
}
