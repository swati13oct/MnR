package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class VPPTestHarnessPage extends UhcDriver{

		@FindBy(xpath="//h3[text()='Enter ZIP Code']/parent::div//input[@id='vpp-zip-search']")
		public WebElement enterVppzipcode;
		
		@FindBy(xpath="//h3[text()='Enter ZIP Code']/parent::div//button[text()='Go']")
		public WebElement enterVppGoButton;
		
		@FindBy(xpath="//a[@id='showLookupZIPformlink']")
		public WebElement lookupZipcodeLink;
		
		@FindBy(xpath="//input[@id='address']")
		public WebElement addressInput;
		
		@FindBy(xpath="//input[@id='city']")
		public WebElement cityInput;
		
		@FindBys(value = { @FindBy(xpath = "//select[@id='state_select']/option") })
		private List<WebElement> stateDropDownValues;
		
		@FindBy(xpath="//button[@id='searchzip']")
		public WebElement lookupSearchButton;
		
		
		@FindBy(xpath="//h3[text()='VPP to OLE']/parent::div//input[@id='vpp-zip-search']")
		public WebElement enterOleZip;
		
		@FindBy(xpath="//h3[text()='VPP to OLE']/parent::div//button[text()='Load Plans']")
		public WebElement loadPlansButton;
		
		@FindBys(value = { @FindBy(xpath = "//select[@id='js-ole-plan-select']/option") })
		private List<WebElement> olePlanSelectValues;
		
		@FindBy(xpath="//button[text()='Set OLE Cookies Information']")
		public WebElement setOLECookieButton;
		
		@FindBy(xpath = "//div[@class='modal-title']")
		private WebElement countyModal;
		
		@FindBy(xpath = "//div[contains(@class,'overview-main')]/h2")
		private WebElement vppTop;
		
		@FindBy(xpath="//input[@id='zipcode']")
		private WebElement shopForAPlanOptionZipcodeFieldBox;
		
		@FindBy(xpath="//button[text()='Go']")
		private WebElement shopForAPlanOptionFindPlanButton;

		
		@FindBy(xpath="//input[@name='planSummaryZIP']")
		private WebElement planSummaryZIP;
		
		@FindBy(xpath="//button[contains(@ng-click,'plansummary') and not (contains(@ng-click,'email'))]")
		private WebElement planSummaryCreateButton;
		
		@FindBy(xpath="//a[@class='custom_deeplink_anchor' and attribute::href]")
		private WebElement createDeepLinkURL;
		
		public VPPTestHarnessPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			//CommonUtility.waitForPageLoad(driver, ZipCode, 10);
			try {
				openAndValidate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		@Override
		public void openAndValidate() throws InterruptedException {
			//validateNew(ZipCode);
			//validateNew(ZipSearch);
		}


		public void enterVppZipcode(String zipcode){
			validateNew(enterVppzipcode);
			sendkeys(enterVppzipcode, zipcode);
			enterVppGoButton.click();
		}
		
		public void enterAddressDetails(String address, String city, String state) {
			validateNew(lookupZipcodeLink);
			lookupZipcodeLink.click();
			validateNew(addressInput);
			sendkeys(addressInput, address);
			sendkeys(cityInput, city);
			selectFromDropDown(stateDropDownValues, state.toUpperCase());
			lookupSearchButton.click();
			validateNew(enterVppGoButton);
			enterVppGoButton.click();

		}
		
		public void SelectCounty(String countyName) {
			if (validate(countyModal)) {
				CommonUtility.waitForPageLoad(driver, countyModal, 45);
				System.out.println("County should be selected : " + countyName);
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
				CommonUtility.waitForPageLoadNew(driver, vppTop, 35);

			} else {
				System.out.println("No County to be selected ");
			}
			
		}
		
		public VPPPlanSummaryPage navigateToVPP(){
			validateNew(vppTop);
			CommonUtility.waitForPageLoad(driver, vppTop, 30);
			return new VPPPlanSummaryPage(driver);
		}

		public VPPPlanSummaryPage navigateToShopPlanenterZipcodeToVPP(String zipcode, String countyName, String isMultiCounty) {
			validateNew(enterVppzipcode);
			enterVppGoButton.click();
			CommonUtility.waitForPageLoadNew(driver, shopForAPlanOptionZipcodeFieldBox, 35);
			validateNew(shopForAPlanOptionZipcodeFieldBox);
			shopForAPlanOptionZipcodeFieldBox.sendKeys(zipcode);
			shopForAPlanOptionFindPlanButton.click();
			SelectCounty(countyName);
			if(driver.findElement(By.xpath("//*[contains(text(),'"+zipcode+" "+countyName+"')]")).isDisplayed()) {
				return new VPPPlanSummaryPage(driver);
			}
			return null;
		}
		
		public void enterZipcodeforPlanSummaryDeepLink(String zipcode){
			validateNew(planSummaryZIP);
			sendkeys(planSummaryZIP, zipcode);
			validateNew(planSummaryCreateButton);
			jsClickNew(planSummaryCreateButton);
			validateNew(createDeepLinkURL);
			System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
			jsClickNew(createDeepLinkURL);
		}


}
