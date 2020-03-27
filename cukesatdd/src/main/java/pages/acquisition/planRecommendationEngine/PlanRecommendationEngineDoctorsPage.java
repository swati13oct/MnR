/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.mobile.acquisition.planrecommendationengine.WerallyMobilePage;

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
                
                String page = "Step 5: Doctors";
                
                PlanRecommendationEngineWerallyPage werally = new PlanRecommendationEngineWerallyPage(driver);
            	ArrayList<String> werallyResults = new ArrayList<String>();
            	ArrayList<String> confirmationResults = new ArrayList<String>();
                
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
                
             // --- Common elements Ends above ---                
                
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
                
// Doctors Page Modal popup
            	
            	@FindBy(css = "#modal div>button[class*='primary button']")
            	private WebElement modalFinddoctors;
            	
            	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
            	private WebElement modalCancel;
            	
            	@FindBy(css = "#modal #modal-label")
            	private WebElement modalTitle;

            	@FindBy(css = "#modal .modal-content")
            	private WebElement modalDescription;      
            	
//Doctors Page Confirmation Modal popup
            	

            	@FindBy(css = "#modal div>button[class*='primary button']")
            	private WebElement modalContinuedoctors;

            	@FindBy(css = "#modal .modal-content .row:nth-of-type(1) p")
            	private WebElement modalDoctorsCount;

            	@FindBy(css = "#modal .modal-content .row:nth-of-type(2) uhc-list-item")
            	private List<WebElement> modalDoctorsList;

            	//#modal .modal-content .row:nth-of-type(2) uhc-list-item button[class*='secondary']
            	//Find doctor element and lookup remove button
            	@FindBy(css = "button[class*='secondary']")
            	private List<WebElement> modalDoctorsRemovebutton;
			          	

//Doctors Page Element Verification Method 
                
                                public void doctorspage() {
                                                System.out.println("Validating Doctors Page: ");
                                                String currentPageUrl = driver.getCurrentUrl(); 
                                                currentPageUrl.contains("/plan-recommendation-engine.html/");
                                                validate(planSelectorPageTilte);
                                                Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
                                                validate(pageStepsNumberName, 30);
                                                validate(pageProgressPercentage, 30);
                                                desktopCommonUtils.currentPageValidation(page.toUpperCase());
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
                                                desktopCommonUtils.previousPageValidation(page.toUpperCase());
                                }
                                
// Selecting doctor options in Doctor Page
                                
                                public void doctorspageOptions(String doctor) {
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
                                }                                
                                
//Doctors Page Function Verification                      
                                
                                public void doctorspageFunctional(String doctor,String doctorsName,String multiDoctor) {
                                                System.out.println("Doctor Page Functional Operations");
                                                doctorspageOptions(doctor);
                                                continueBtn.click();
                                                if(doctor.equalsIgnoreCase("mydoctors")) {
                                                	if(multiDoctor.equalsIgnoreCase("YES"))
                                                		doctorModellookup(doctorsName,3);
                                    				else
                                    					doctorModellookup(doctorsName,1);
                                                }
                                                System.out.println("Validating "+page+" page Continue button functionality");
                                }
                                
//Doctors page - Select Doctor Type and click on Previous Button              
                                
                                public void doctorspagePreviousButton(String doctor) {
                                                System.out.println("Doctor Page Functional Operations");
                                                doctorspageOptions(doctor);
                                                if(radioselect.isDisplayed()) {
                                                                validate(pageProgressPercentage, 30);
                                                                Assert.assertTrue(pageProgressPercentage.getText().contains("32% Complete"));
                                                }else {
                                                                System.out.println("Doctor Type not selected in Doctors Page");
                                                }
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previousPageValidation(page.toUpperCase());
                                }
                                
//Doctors Page Function Verification                                      
                                public void doctorspageerror() {
                                                System.out.println("Doctor type not selected - Error Scenario in Doctors Page");
                                                continueBtn.click();
                                                Assert.assertTrue(errorMessage.getText().contains("No"));
                                }
                                
//Doctors Model Popup Window Verification                                
                                
                                public void doctorModellookup(String search,int count) {
                                	String curWindow = driver.getWindowHandle();
                                	validate(modalDescription);
                        			Assert.assertTrue(modalDescription.getText().contains("Save"));
                        			validate(modalTitle);
                        			Assert.assertTrue(modalTitle.getText().contains("browser"));
                        			validate(modalCancel);
                        			Assert.assertTrue(modalCancel.getText().contains("Cancel"));
                        			validate(modalFinddoctors);
                        			Assert.assertTrue(modalFinddoctors.getText().contains("Find Doctors"));
                        			modalFinddoctors.click();
                                	validateLinksanotherWindow(curWindow,"Doctors",search, count );
                                	threadsleep(5000);
                                	getConfimationPopupResults(count);
                                	verifyConfirmationmodalResults(count,werallyResults,confirmationResults);
//                                	doctorConfirmationModellookup();
                            		if(count>2)
                            			removeDoctors();
                            		modalContinuedoctors.click();
                            		
                            	}
                                
                                
//Doctors Confirmation Model Popup Window Verification                                
                                
                                public void doctorConfirmationModellookup() {
                                	validate(modalTitle);
                        			Assert.assertTrue(modalTitle.getText().contains("Your Doctors"));
                                	validate(modalDoctorsCount);
                        			Assert.assertTrue(modalDoctorsCount.getText().contains("doctor(s)"));
                        			validate(modalCancel);
                        			Assert.assertTrue(modalCancel.getText().contains("Cancel"));
                        			validate(modalContinuedoctors);
                        			Assert.assertTrue(modalContinuedoctors.getText().contains("Continue"));
                            	}                                
                                
//Switch to Werally Window Page
                                
                                public void validateLinksanotherWindow(String primaryWindow,String type,String search,int count) {
                            		threadsleep(2000);
                            		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
                            		System.out.println(windows);
                            		if (windows.size() == 2) {
                            			for (String window : windows) {
                        					if (!window.equals(primaryWindow)) {
                        						driver.switchTo().window(window);
                        						System.out.println(driver.getCurrentUrl());
                        						werallyResults = werally.werallySearch(type,search,count);
                        						System.out.println("werallyResults Size is : "+werallyResults.size());
                        						System.out.println("werallyResults Content is : "+werallyResults);
                            		}
                        					driver.switchTo().window(primaryWindow);
                            			}
                            		System.out.println(driver.getCurrentUrl());
                        			threadsleep(1000);
                        		} else {
                        			System.out.println("Unexpected windows opened");
                        			driver.switchTo().window(primaryWindow);
                        			threadsleep(1000);
                        			Assert.assertTrue(false);
                        		}
                            		threadsleep(5000);
                                }
                                
                                public void getConfimationPopupResults(int count) {
                            		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
                            		if(count==modalDoctorsList.size() && count==confirmationSize) {
                            			for (int i = count; i > 0; i--) {
                            				confirmationResults.add(driver.findElement(By.cssSelector("#modal .modal-content .row:nth-of-type(2) uhc-list-item:nth-child("+ i +") .list-item-content>div>strong")).getText().trim());
                            			}
                            			Collections.sort(confirmationResults);
                            			System.out.println("confirmationResults Size is : "+confirmationResults.size());
                            			System.out.println("confirmationResults Content is : "+confirmationResults);
                            		}
                            		else {
                            			System.out.println("Modal Results Count mismatch");
                            			Assert.assertTrue(false);
                            		}
                            	}        
                                
                                public void verifyConfirmationmodalResults(int count,ArrayList<String> werally,ArrayList<String> confirm) {

                            		if(werally.size()==confirm.size() && count==werally.size()) {
                            			if(equalsname(werally,confirm)) {
                            				System.out.println("Werally and Modal Result's Content matched");
                            			}
                            			else {
                            				System.out.println("Werally and Modal Result's Content mismatch");
                            				Assert.assertTrue(false);
                            			}
                            		}
                            		else {
                            			System.out.println("Werally and Modal Results Count mismatch");
                            			Assert.assertTrue(false);
                            		}
                            	}
                                
                                public boolean equalsname(ArrayList<String> werally,ArrayList<String> doctorsmodal) {
                            		boolean result=true;
                            		for(int i = 0;i<werally.size();i++) {
                            			String wname[] = werally.get(i).replace(",","").replace(".", "").split(" ");
                            			Arrays.sort(wname);
                            			for(int j=0;j<doctorsmodal.size();j++) {
                            				String dname[] = doctorsmodal.get(j).replace(",","").replace(".", "").split(" ");
                            				Arrays.sort(dname);
                            				System.out.println(Arrays.equals(wname, dname));
                            				if(Arrays.equals(wname, dname)) {
                            					result=true;
                            					break;
                            				}
                            				else {
                            					result=false;
                            				}
                            			}
                            		}
                            		System.out.println("Doctors Name validation Result "+result);
                            		return result;
                            	}
                                
                                public void removeDoctors() {
                            		// By default removing 2nd doctor
                            		int beforeRemove = modalDoctorsList.size();
                            		modalDoctorsList.get(1).findElement(By.cssSelector("button[class*='secondary']")).click();
                            		int afterRemove = modalDoctorsList.size();
                            		if(beforeRemove!=afterRemove) {
                            			System.out.println("Remove Results Count mismatch");                            		
                            		}else {
                            			System.out.println("Remove Results Count matching and Remove is not removed");
                            			Assert.assertTrue(false);
                            		}
                            	}

                public void browserBack() {

                                driver.navigate().back();
                }
}
