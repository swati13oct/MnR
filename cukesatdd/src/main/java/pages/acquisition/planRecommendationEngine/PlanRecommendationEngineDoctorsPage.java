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

public class PlanRecommendationEngineDoctorsPage extends UhcDriver {

                public PlanRecommendationEngineDoctorsPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                }
                
                @Override
                public void openAndValidate() {
                                checkModelPopup(driver);
                                clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
                                waitTillFrameAvailabeAndSwitch(iframePst, 45);
                }
                
                String page = "Doctors";
                
                PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
                
                @FindBy(id = "planSelectorTool")
                private WebElement iframePst;

// Doctors page Elements

                @FindBy(xpath = "//*[@class='progress-bar-title']/h1")
                private WebElement planSelectorPageTilte;

                @FindBy(xpath = "//*[@class='progress-bar-info']/h2")
                private WebElement pageStepsNumberName;
                
                @FindBy(xpath = "//*[@class='progress-bar-info']/p")
                private WebElement pageProgressPercentage;
                
                @FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex")
                private WebElement doctorsTitle;
                
                @FindBy(xpath = "//label[@class='radio-label']/input[contains(text(),'network')]")
                private WebElement SelectDoctors;
                
                @FindBy(xpath = "//button[contains(text(),'Continue')]")
                private WebElement continueBtn;
                
                @FindBy(xpath = "//button[contains(text(),'Previous')]")
                private WebElement previousBtn;
                
                @FindBy(css = "p.all-fields-marked-wi")
                private WebElement pageRequiredInfo;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
                private WebElement innetwork;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
                private WebElement outnetwork;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
                private WebElement mydoctors;
                
                @FindBy(css = "#errorMessage>div:nth-child(2)")
                private WebElement errorMessage;
                
                @FindBy(xpath = "//*[contains(@class,'radio-checked')]")
                private WebElement radioselect;

//Doctors Page Element Verification Method 
                
                                public void doctorspage() {
                                                System.out.println("Validating Doctors Page: ");
                                                String currentPageUrl = driver.getCurrentUrl(); 
                                                currentPageUrl.contains("/plan-recommendation-engine.html/");
                                                validate(planSelectorPageTilte);
                                                Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
                                                validate(pageStepsNumberName, 30);
                                                Assert.assertTrue(pageStepsNumberName.getText().contains("Step 5: Doctors"));
                                                validate(pageProgressPercentage, 30);
                                                Assert.assertTrue(pageProgressPercentage.getText().contains("32% Complete"));
                                                validate(pageRequiredInfo);
                                                Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
                                                validate(doctorsTitle);
                                                Assert.assertTrue(doctorsTitle.getText().contains("doctors"));
                                                validate(innetwork, 30);
                                                Assert.assertTrue(innetwork.getText().contains("network"));
                                                validate(outnetwork, 30);
                                                Assert.assertTrue(outnetwork.getText().contains("patients"));
                                                validate(mydoctors, 30);
                                                Assert.assertTrue(mydoctors.getText().contains("current doctors"));
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previouspageValidation(page.toUpperCase());
                                }
                                
//Doctors Page Function Verification                      
                                
                                public void doctorspageFunctional(String doctor) {
                                                System.out.println("Doctor Page Functional Operations");
                                                if (doctor.equalsIgnoreCase("innetwork")) {
                                                                validate(innetwork);
                                                                innetwork.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }else if (doctor.equalsIgnoreCase("outnetwork")) {
                                                                validate(outnetwork);
                                                                outnetwork.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }else if (doctor.equalsIgnoreCase("mydoctors")) {
                                                                validate(mydoctors);
                                                                mydoctors.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }
                                                continueBtn.click();
                                                System.out.println("Validating "+page+" page Continue button functionality");
                                                desktopCommonUtils.nextPageValidation(page.toUpperCase());
                                }
                                
//Doctors page - Select Doctor Type and click on Previous Button              
                                
                                public void doctorspagePreviousButton(String doctor) {
                                                System.out.println("Doctor Page Functional Operations");
                                                if (doctor.equalsIgnoreCase("innetwork")) {
                                                                validate(innetwork);
                                                                innetwork.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }else if (doctor.equalsIgnoreCase("outnetwork")) {
                                                                validate(outnetwork);
                                                                outnetwork.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }else if (doctor.equalsIgnoreCase("mydoctors")) {
                                                                validate(mydoctors);
                                                                mydoctors.click();
                                                                System.out.println("Doctors Type "+ doctor +" Clicked");
                                                }
                                                if(radioselect.isDisplayed()) {
                                                                validate(pageProgressPercentage, 30);
                                                                Assert.assertTrue(pageProgressPercentage.getText().contains("32% Complete"));
                                                }else {
                                                                System.out.println("Doctor Type not selected in Doctors Page");
                                                }
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previouspageValidation(page.toUpperCase());
                                }
                                
//Doctors Page Function Verification                                      
                                public void doctorspageerror() {
                                                System.out.println("Doctor type not selected - Error Scenario in Doctors Page");
                                                continueBtn.click();
                                                Assert.assertTrue(errorMessage.getText().contains("No"));
                                }

                public void browserBack() {

                                driver.navigate().back();
                }
}
