package pages.acquisition.commonpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PlanRecommendationEngineDrugsPage extends GlobalWebElements {

	public PlanRecommendationEngineDrugsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Drug";

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	ArrayList<String> DrugsInDCE;
	public static ArrayList<String> DCEDrugsList = new ArrayList<String>();
	public static ArrayList<String> drugNames = new ArrayList<String>();
	public static ArrayList<String> drugNamesStartOver = new ArrayList<String>();
	public static ArrayList<String> drugNamesinPRE = new ArrayList<String>();

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;
	
	// Drugs page Elements
	
	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
    private WebElement yesOption;
	
	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
    private WebElement noOption;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueBtn;
	
	// Build Your Prescription Drugs page Elements
	
	@FindBy(css = "input#drug")
	private WebElement drugsearchBox;
	
	@FindBy(css = "uhc-autocomplete button")
	private WebElement drugsearchButton;
	
	@FindBy(css = "uhc-autocomplete uhc-menu-item")
	private List<WebElement> drugsAutoList;
	
	@FindBy(css = "uhc-list-item .list-item-content")
	private List<WebElement> drugNameList;
	
	// drugs Page Modal popup
	
	@FindBy(css = "#modal uhc-radio[class*='checked']")
	private WebElement modalSelcetedDrug;
	
	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalcontinue;
	
	@FindBy(css = "#modal #dosage-select")
	private WebElement modalDosageSelect;
	
	@FindBy(css = "#modal #package-select")
	private WebElement modalPackageSelect;
	
	@FindBy(css = "#modal #Quantity")
	private WebElement modalQuantity;
	
	@FindBy(css = "#modal #frequency-select")
	private WebElement modalFrequencySelect;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label")
	private WebElement modalGenericSwitchLabel;
	
	//Generic modal
	
	@FindBy(css = "#modal legend")
	private WebElement modalGenericDrug;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
	private WebElement modalGenericSwitch;
	
	@FindBy(css = "uhc-list uhc-list-item")
	private List<WebElement> drugsList;
	
	@FindBy(css = "uhc-temp-display p[role='alert']")
	private WebElement modaldrugsCount;
	
	
	// Selecting drug options in Drug Costs Page
    public void drugpageOptions(String drug) {
        System.out.println("Drugs Page Functional Operations");
        if (drug.equalsIgnoreCase("Yes")) {
                        validate(yesOption);
                        jsClickNew(yesOption);
                        System.out.println("Prescription Type "+ drug +" Clicked");
        }else if (drug.equalsIgnoreCase("No")) {
                        validate(noOption);
                        jsClickNew(noOption);
                        System.out.println("Prescription Type "+ drug +" Clicked");
        }                                    
    }
    
  //Skip the Drug Page to Pharmacy Page
    
    public void skipDrugs(String drugsSelection) {
    	drugpageOptions(drugsSelection);
//    	continueBtn.click();
    	jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase() + "skip");
	}
    
	//Drug option selects in Drug page 
    public void drugsInitiate(String drugSelection) {
    	drugpageOptions(drugSelection);
    	jsClickNew(continueBtn);
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
//		checkRemove(drugslist.length);
		validateResultsCount();
		
	}
    
  //Adding Drug Functionality
    
    public void addDrugbySearch(String drugName, boolean searchButtonClick,String dosage, String packageName, String count,
			boolean threeeMonthfrequency, boolean GenericDrug,boolean switchGeneric) {
		try {
			validate(drugsearchBox,30);
			threadsleep(2000);
			drugsearchBox.clear();
			drugsearchBox.sendKeys(drugName);
			if(searchButtonClick) 
			{
//				drugsearchButton.click();
				jsClickNew(drugsearchButton);
				threadsleep(6000);
				validate(modalSelcetedDrug,30);
				threadsleep(2000);
				Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),"Drug name is not Matched :"+drugName);
				//Select modal
				threadsleep(2000);
//				modalcontinue.click();
				jsClickNew(modalcontinue);
				threadsleep(2000);
			}
			else {
//				drugsAutoList.get(0).click();
				jsClickNew(drugsAutoList.get(0));
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
			
			threadsleep(4000);
//			modalcontinue.click();
			jsClickNew(modalcontinue);
			if (GenericDrug) {
				validate(modalGenericDrug,30);
				threadsleep(2000);
				//Generic modal
				if(switchGeneric) {
					clickSwitchdrug();
					drugName = modalGenericDrug.getText();
				}
				threadsleep(2000);
//				modalcontinue.click();
				jsClickNew(modalcontinue);
			}
			
			validateAddedDrugname(drugName);
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
    
 // Clicking Switch Drug Model
    
    public void clickSwitchdrug() {
//		modalGenericSwitchLabel.click();
		jsClickNew(modalGenericSwitchLabel);
		threadsleep(2000);
//		jsClickMobile(modalGenericSwitch);
		jsClickNew(modalGenericSwitch);
	}
    
  //Validate Added Drug Name
    
    public void validateAddedDrugname(String drugName) {
		Assert.assertTrue(drugsList.get(0).getText().toUpperCase().contains(drugName.toUpperCase()),"Added drug name Mistmatch from selected one : "+drugName);
	}
    
  //Validating Result Count
    public void validateResultsCount() {
		int confirmationSize = Integer.parseInt(modaldrugsCount.getText().trim().split(" ")[2]);
		if (drugsList.size() == confirmationSize) {
			System.out.println("Results and Count matched");
		} else {
			System.out.println("Results and Count mismatch");
			Assert.assertTrue(false);
		}
	}
    
 // Continue Function
    
    public void continueNextpage() {
		validate(drugsearchBox,30);
		threadsleep(2000);
		drugnamesList();
//		continueBtn.click();
		jsClickNew(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}
    
  //Drug name List
    
    public ArrayList<String> drugnamesList() {
    	int count = drugNameList.size();
    	drugNames = new ArrayList<String>();
    	for (int i = count-1; i >= 0; i--) {
			threadsleep(1000);
			drugNames.add(drugNameList.get(i).findElement(By.cssSelector("p:nth-child(1)")).getText().trim().toUpperCase() +" "
					+drugNameList.get(i).findElement(By.cssSelector("p:nth-child(2)")).getText().trim().toUpperCase());
			}
    	Collections.sort(drugNames);
		System.out.println("Drugs Name list is : "+drugNames);
		return drugNames;
    }

}
