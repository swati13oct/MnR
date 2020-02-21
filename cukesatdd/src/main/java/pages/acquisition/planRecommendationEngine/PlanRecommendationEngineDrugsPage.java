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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.mobile.acquisition.planrecommendationengine.WerallyMobilePage;

public class PlanRecommendationEngineDrugsPage extends UhcDriver {

                public PlanRecommendationEngineDrugsPage(WebDriver driver) {
                                super(driver);
                                PageFactory.initElements(driver, this);
                }
                
                @Override
                public void openAndValidate() {
                                checkModelPopup(driver);
                                clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
                                waitTillFrameAvailabeAndSwitch(iframePst, 45);
                }
                
                String page = "Drug Costs";
                
                PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
                
                @FindBy(id = "planSelectorTool")
                private WebElement iframePst;

// Drugs page Elements

                @FindBy(xpath = "//*[@class='progress-bar-title']/h1")
                private WebElement planSelectorPageTilte;

                @FindBy(xpath = "//*[@class='progress-bar-info']/h2")
                private WebElement pageStepsNumberName;
                
                @FindBy(xpath = "//*[@class='progress-bar-info']/p")
                private WebElement pageProgressPercentage;
                
                @FindBy(css = "div.progress-bar-value-background")
            	private WebElement progressbar;
                
                @FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex")
                private WebElement drugTitle;
                
                @FindBy(xpath = "//button[contains(text(),'Continue')]")
                private WebElement continueBtn;
                
                @FindBy(xpath = "//button[contains(text(),'Previous')]")
                private WebElement previousBtn;
                
             // --- Common elements Ends above ---                
                
                @FindBy(css = "p.all-fields-marked-wi")
                private WebElement pageRequiredInfo;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
                private WebElement yesOption;
                
                @FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
                private WebElement noOption;
                
                @FindBy(css = "#errorMessage>div:nth-child(2)")
                private WebElement errorMessage;
                
                @FindBy(css = "#errorMessage")
                private WebElement errorMessageMainpage;
                
                @FindBy(xpath = "//*[contains(@class,'radio-checked')]")
                private WebElement radioselect;
                
// Build Your Prescription Drugs page Elements
                
                @FindBy(css = "uhc-temp-display>div.container div>div>h2")
            	private WebElement drugsearchbuildpres;
            	
            	@FindBy(css = "uhc-temp-display>div.container div>div>p")
            	private WebElement drugsearchdescription;
                
                @FindBy(css = "h2.primary-question-tex")
                private WebElement buildYourPrescriptionTitle;
                
                @FindBy(css = "div>p.description-text:nth-child(2)")
                private WebElement buildYourPrescriptionInnerContent;
                
                @FindBy(css = "#drug-label")
                private WebElement addDrug;
                
                @FindBy(css = "input#drug")
            	private WebElement drugsearchBox;
                
                @FindBy(css = "uhc-autocomplete button")
            	private WebElement drugsearchButton;
            	
            	@FindBy(css = "uhc-alert")
            	private WebElement drugsearchError;
            	
            	@FindBy(css = "uhc-autocomplete uhc-menu-item")
            	private List<WebElement> drugsAutoList;
                
// drugs Page Modal popup
            	
            	@FindBy(css = "#modal uhc-radio[class*='checked']")
            	private WebElement modalSelcetedDrug;
            	
            	@FindBy(css = "#modal uhc-radio-group uhc-radio")
            	private List<WebElement> modalSelcetedDrugsList;

            	@FindBy(css = "#modal div>button[class*='primary button']")
            	private WebElement modalcontinue;

            	@FindBy(css = "#modal div[class*='modal-footer'] button[class*='secondary']")
            	private WebElement modalBackCancel;

            	@FindBy(css = "#modal #modal-label")
            	private WebElement modalTitle;

            	@FindBy(css = "#modal #dosage-select")
            	private WebElement modalDosageSelect;

            	@FindBy(css = "#modal #package-select")
            	private WebElement modalPackageSelect;
            	
            	@FindBy(css = "#modal #Quantity")
            	private WebElement modalQuantity;
            	
            	@FindBy(css = "#modal #frequency-select")
            	private WebElement modalFrequencySelect;
            	
            	@FindBy(css = "#modal uhc-alert")
            	private WebElement modalError;
            	
//Generic modal
            	
            	@FindBy(css = "#modal uhc-alert")
            	private WebElement modalGenericDescription;
            	
            	@FindBy(css = "#modal legend")
            	private WebElement modalGenericDrug;
            	
            	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content")
            	private WebElement modalGenericKeep;
            	
            	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
            	private WebElement modalGenericSwitch;
            	

            	@FindBy(css = "uhc-temp-display p[role='alert']")
            	private WebElement modaldrugsCount;

            	@FindBy(css = "uhc-list uhc-list-item")
            	private List<WebElement> drugsList;

            	// Find drug element and lookup for name
            	@FindBy(css = ".list-item-content")
            	private WebElement drugName;
			          	

//Drugs Page Element Verification Method 
                
                                public void drugspage() {
                                                System.out.println("Validating Drugs Page: ");
                                                String currentPageUrl = driver.getCurrentUrl(); 
                                                currentPageUrl.contains("/plan-recommendation-engine.html/");
                                                validate(planSelectorPageTilte);
                                                Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
                                                validate(pageStepsNumberName, 30);
                                                Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug Costs"));
                                                validate(pageProgressPercentage, 30);
                                                Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
                                                validate(pageRequiredInfo);
                                                Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
                                                validate(drugTitle);
                                                Assert.assertTrue(drugTitle.getText().contains("prescription "));
                                                validate(yesOption, 30);
                                                Assert.assertTrue(yesOption.getText().contains("Yes"));
                                                validate(noOption, 30);
                                                Assert.assertTrue(noOption.getText().contains("No"));
                                                previousBtn.click();
                                                System.out.println("Validating "+page+" page Previous button functionality");
                                                desktopCommonUtils.previouspageValidation(page.toUpperCase());
                                }
                                
//Drugs Search Page Element Verification Method
                            	public void drugsSearchpageElements() {
                            			System.out.println("Drugs Search Validating Page: ");
                            			String currentPageUrl = driver.getCurrentUrl();
                            			currentPageUrl.contains("/plan-recommendation-engine.html/");
                            			validate(planSelectorPageTilte);
                            			validate(pageStepsNumberName, 30);
                            			Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
                            			validate(pageProgressPercentage, 30);
                            			Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
                            			validate(progressbar);
                            			validate(drugsearchbuildpres);
                            			validate(drugsearchdescription);
                            			Assert.assertTrue(drugsearchdescription.getText().contains("drug"));
                            			validate(drugsearchBox);
                            			validate(drugsearchButton);
                            			validate(continueBtn);
                            			previousBtn.click();
                            			Assert.assertTrue(yesOption.getText().contains("add"));
                            			continueBtn.click();
                            		}
                            	
//Drugs Search Generic Element Verification Method
                            	public void genericElements() {
                            		validate(modalGenericDescription, 30);
                            		Assert.assertTrue(modalGenericDescription.getText().contains("switching to a generic drug"));
                            		validate(modalGenericDrug, 30);
                            		Assert.assertTrue(modalGenericDrug.getText().contains("TAB"));
                            		validate(modalGenericKeep, 30);
                            		Assert.assertTrue(modalGenericKeep.getText().contains("Keep"));
                            		validate(modalGenericSwitch, 30);
                            		Assert.assertTrue(modalGenericSwitch.getText().contains("Switch"));
                            	}                            	
                                
// Selecting drug options in Drug Costs Page
                                
                                public void drugpageOptions(String drug) {
                                    System.out.println("Drugs Page Functional Operations");
                                    if (drug.equalsIgnoreCase("Yes")) {
                                                    validate(yesOption);
                                                    yesOption.click();
                                                    System.out.println("Prescription Type "+ drug +" Clicked");
                                    }else if (drug.equalsIgnoreCase("No")) {
                                                    validate(noOption);
                                                    noOption.click();
                                                    System.out.println("Prescription Type "+ drug +" Clicked");
                                    }                                    
                                } 
                                
//Skip the Drug Page to Pharmacy Page
                                
                                public void skipDrugs(String drugsSelection) {
                                	drugpageOptions(drugsSelection);
                                	continueBtn.click();
                            		System.out.println("Validating " + page + " page Continue button functionality");
                            		desktopCommonUtils.nextPageValidation(page.toUpperCase());
                            	}
                                
//Drug option selects in Drug page
                                
                                public void drugsInitiate(String drugSelection) {
                                	drugpageOptions(drugSelection);
                                	continueBtn.click();
                            		validate(drugsearchBox);
                            	}
//Drug Adding details in Drug Page                                
                                
                                public void drugsHandlerWithdetails(String drugsDetails) {
                            		String drugName="";
                            		boolean searchButtonClick=false;
                            		String dosage="";
                            		String packageName="";
                            		String count="";
                            		boolean threeeMonthfrequency=false;
                            		boolean GenericDrug=false;
                            		boolean switchGeneric=false;
                            		
                            		String[] drugslist=drugsDetails.split(":");
                            		for(int i=0;i<drugslist.length;i++) {
                            			String drugInfo = drugslist[i];
                            			if(drugInfo.trim().length()>0) {
                            				String[] drugDetails=drugInfo.split(",");
                            				drugName = drugDetails[0];
                            				if(drugDetails[1].toUpperCase().equals("NO"))
                            					searchButtonClick = true;
                            				dosage=drugDetails[2];
                            				packageName=drugDetails[3];
                            				count=drugDetails[4];
                            				if(drugDetails[5].toUpperCase().equals("3"))
                            					threeeMonthfrequency = true;
                            				if(drugDetails[6].toUpperCase().equals("YES"))
                            					GenericDrug = true;
                            				if(drugDetails[7].toUpperCase().equals("YES"))
                            					switchGeneric = true;

                            				addDrugbySearch(drugName,searchButtonClick,dosage,packageName,count,threeeMonthfrequency,GenericDrug,switchGeneric);
                            			}
                            		}
                            		validateResultsCount();
                            		checkRemove(drugslist.length);
                            		validateResultsCount();
                            		
                            	}
                                
// Continue Function
                                
                                public void continueNextpage() {
                            		validate(drugsearchBox,30);
                            		threadsleep(2000);
                            		continueBtn.click();
                            		System.out.println("Validating " + page + " page Continue button functionality");
                            		desktopCommonUtils.nextPageValidation(page.toUpperCase());
                            	}
                                
//Validating Result Count
                                public void validateResultsCount() {
                            		int confirmationSize = Integer.parseInt(modaldrugsCount.getText().trim().split(" ")[2]);
                            		if (drugsList.size() == confirmationSize) {
                            			System.out.println("Resutls and Count matched");
                            		} else {
                            			System.out.println("Resutls and Count mismatch");
                            			Assert.assertTrue(false);
                            		}
                            	}
                                
                                
//Check Remove Count                                
                                public void checkRemove(int count){
                            		if (count > 2)
                            			removedrug();
                            	}
                                
//Remove Drug Function
                                
                                public void removedrug() {
                            		// By default removing 2nd drug
                            		int beforeRemove = drugsList.size();
                            		WebElement remove = drugsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
                            		remove.click();
                            		int afterRemove = drugsList.size();
                            		if (beforeRemove == afterRemove) {
                            			System.out.println("Remove Results Count mismatch");
                            			Assert.assertTrue(false);
                            		}
                            	}
//Canceling the Model in Drug Page                                
                                
                                public void drugspageCancel(String drugInfo) {

                            		String drugName = drugInfo.split(",")[0];
                            		boolean generic = false;
                            		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
                            			generic = true;
                            		drugsSearchpageElements();

                            		System.out.println("Validating Modal Cancel functionalities");

                            		// Select modal cancel
                            		drugsearchBox.sendKeys(drugName);
                            		drugsearchButton.click();
                            		validate(modalSelcetedDrug,30);
                            		threadsleep(2000);
                            		modalBackCancel.click();
                            		threadsleep(2000);
                            		if (drugsearchBox.isDisplayed() == false) {
                            			System.out.println("Drug Select modal is not closed");
                            			Assert.assertTrue(false);
                            		}

                            		// Drug details modal cancel
                            		drugsearchBox.clear();
                            		drugsearchBox.sendKeys(drugName);
                            		drugsearchButton.click();
                            		validate(modalSelcetedDrug,30);
                            		threadsleep(2000);
                            		modalcontinue.click();
                            		threadsleep(2000);
                            		validate(modalDosageSelect,30);
                            		threadsleep(2000);
                            		modalBackCancel.click();
                            		threadsleep(2000);
                            		if (drugsearchBox.isDisplayed() == false) {
                            			System.out.println("Drug details modal is not closed");
                            			Assert.assertTrue(false);
                            		}

                            		// Generic modal back
                            		if (generic) {
                            			drugsearchBox.clear();
                            			drugsearchBox.sendKeys(drugName);
                            			drugsearchButton.click();
                            			validate(modalSelcetedDrug,30);
                            			threadsleep(2000);
                            			modalcontinue.click();
                            			threadsleep(2000);
                            			validate(modalDosageSelect,30);
                            			threadsleep(2000);
                            			modalcontinue.click();
                            			threadsleep(2000);
                            			genericElements();
                            			validate(modalGenericDrug,30);
                            			threadsleep(2000);
                            			modalBackCancel.click();
                            			threadsleep(2000);
                            			 if (modalQuantity.isDisplayed() == false) {
                            				System.out.println("Generic drug modal is not closed");
                            				Assert.assertTrue(false);
                            			}
                            		}
                            	}
                                
//Adding Drug Functionality
                                
                                public void addDrugbySearch(String drugName, boolean searchButtonClick,String dosage, String packageName, String count,
                            			boolean threeeMonthfrequency, boolean GenericDrug,boolean switchGeneric) {
                            		try {
                            			validate(drugsearchBox,30);
                            			threadsleep(2000);
                            			drugsearchBox.clear();
                            			drugsearchBox.sendKeys(drugName);
                            			if(searchButtonClick) {
                            			drugsearchButton.click();
                            			validate(modalSelcetedDrug,30);
                            			threadsleep(2000);
                            			Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),"Drug name is not Matched :"+drugName);
                            			//Select modal
                            			modalcontinue.click();
                            			threadsleep(2000);
                            			}
                            			else {
                            				drugsAutoList.get(0).click();
                            			}
                            			
                            			validate(modalDosageSelect,30);
                            			threadsleep(2000);
                            			Select dos = new Select(modalDosageSelect);
                            			Select freq = new Select(modalFrequencySelect);

                            			if (!dosage.isEmpty())
                            				dos.selectByVisibleText(dosage);
                            			if (!packageName.isEmpty()) {
                            				Select pack = new Select(modalPackageSelect);
                            				pack.selectByVisibleText(packageName);
                            			}
                            			if (!count.isEmpty()) {
                            				modalQuantity.clear();
                            				modalQuantity.sendKeys(count);
                            			}
                            			if (threeeMonthfrequency)
                            				freq.selectByVisibleText("Every 3 Months");
                            			modalcontinue.click();
                            			
                            			if (GenericDrug) {
                            				validate(modalGenericDrug,30);
                            				threadsleep(2000);
                            				//Generic modal
                            				if(switchGeneric) {
                            					modalGenericSwitch.click();
                            					drugName = modalGenericDrug.getText();
                            				}
                            				modalcontinue.click();
                            			}
                            			
                            			validateAddedDrugname(drugName);
                            		} catch (Exception e) {
                            			System.out.println("Unable to add drug");
                            		}
                            	}
                                
//Validate Added Drug Name
                                
                                public void validateAddedDrugname(String drugName) {
                            		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),"Added drug name Mistmatch from selected one : "+drugName);
                            	}
                                
//Drugs Page Function Verification     
                                
                                public void drugspageerror() {
                                                System.out.println("Drugs type not selected - Error Scenario in Drugs Page");
                                                continueBtn.click();
                                                Assert.assertTrue(errorMessageMainpage.getText().contains("No"));
                                }                                
                                
// Drug Page Error
                                
                                public void drugpagesError(String drugInfo) {
                            		System.out.println("Drug pages Error validation");
                            		drugpageOptions("");
                            		drugpageOptions("Yes");
                            		continueBtn.click();
                            		validate(drugsearchBox, 30);
                            		drugsearchBox.sendKeys("lip");
                            		drugsearchButton.click();
                            		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
                            				"Expected Error Message not displayed");
                            		drugsearchBox.clear();
                            		drugsearchButton.click();
                            		Assert.assertTrue(drugsearchError.getText().toUpperCase().contains("CHARACTERS"),
                            				"Expected Error Message not displayed");

                            		// Modal Errors
                            		String drugName = drugInfo.split(",")[0];
                            		boolean generic = false;
                            		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
                            			generic = true;
                            		String count = drugInfo.split(",")[4];
                            		boolean GenericDrug = false;
                            		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
                            			GenericDrug = true;
                            		System.out.println("Validating Modal Error functionalities");

                            		// Select modal cancel
                            		drugsearchBox.sendKeys(drugName);
                            		drugsearchButton.click();
                            		validate(modalSelcetedDrug, 30);
                            		threadsleep(2000);
                            		modalcontinue.click();
                            		modalQuantity.clear();
                            		
                            		/* Not working in PRE but working in PROD
                            		modalcontinue.click();
                            		Assert.assertTrue(modalError.getText().toUpperCase().contains("QUANTITY"),
                            				"Expected Error Message is not displayed");
                            		*/
                            		modalQuantity.sendKeys(count);
                            		modalcontinue.click();
                            		if (GenericDrug) {
                            			validate(modalGenericDrug, 30);
                            			threadsleep(2000);
                            			modalcontinue.click();
                            		}
                            		validateAddedDrugname(drugName);
                            		drugsearchBox.clear();
                            		drugsearchBox.sendKeys(drugName);
                            		drugsearchButton.click();
                            		validate(modalSelcetedDrug, 30);
                            		threadsleep(2000);
                            		modalcontinue.click();
                            		modalQuantity.clear();
                            		modalQuantity.sendKeys(count);
                            		modalcontinue.click();
                            		Assert.assertTrue(modalError.getText().toUpperCase().contains("ALREADY"),
                            				"Expected Error Message is not displayed");

                            	}
                                
//Choosing Drug from Select Model Window                                
                                
                                public void drugChoose(String searchText, String drugInfo) {
                            		String drugName = drugInfo.split(",")[0];
                            		boolean generic = false;
                            		if (drugInfo.split(",")[6].toUpperCase().equals("YES"))
                            			generic = true;
                            		validate(drugsearchBox, 30);
                            		drugsearchBox.sendKeys(searchText);
                            		drugsearchButton.click();
                            		chooseDrug(drugName);
                            		modalcontinue.click();
                            		threadsleep(2000);
                            		validate(modalDosageSelect, 30);
                            		threadsleep(2000);
                            		modalcontinue.click();
                            		threadsleep(2000);
                            		if (generic) {
                            			validate(modalGenericDrug, 30);
                            			threadsleep(2000);
                            			modalcontinue.click();
                            		}

                            		validateAddedDrugname(drugName);
                            	}
                                
                                public void chooseDrug(String drugName) {
                            		boolean available=false;
                            		for(WebElement drug:modalSelcetedDrugsList) {
                            			if(drug.getText().trim().equalsIgnoreCase(drugName)) {
                            				drug.click();
                            				available=true;
                            				break;
                            			}
                            		}
                            		if(available==false) {
                            			System.out.println("Unable to find the given Drug name");
                            			Assert.assertTrue(false,"Unable to find the given Drug name");
                            		}
                            	}
                                

                public void browserBack() {

                                driver.navigate().back();
                }
}
