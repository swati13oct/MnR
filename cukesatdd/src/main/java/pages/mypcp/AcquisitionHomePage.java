package pages.mypcp;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import pages.acquisition.bluelayer.ZipcodeLookupHomePage;
import pages.acquisition.bluelayer.GlobalWebElements;
import pages.acquisition.bluelayer.PlanSelectorPage;
import pages.acquisition.bluelayer.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.MaViewPlansAndPricingPage;
import pages.acquisition.ulayer.MsViewPlansAndPricingPage;
import pages.acquisition.ulayer.PdpViewPlansAndPricingPage;

public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(id = "lookzip")
	private WebElement lookupZipcode;
       
	@FindBy(id = "takequizbtn")
	private WebElement takequizbtn;
    
	@FindBy(id = "compareplans")
	private WebElement compareplans;
	
	@FindBys(value = {@FindBy(xpath = "//ul[@id='topic-selectSelectBoxItOptions']/li")})
	private List<WebElement> topicDropDownValues;

	@FindBy(id = "topic-selectSelectBoxIt")
	private WebElement selectSelectBoxIt; 

	@FindBy(id = "picktopicbtn")
	private WebElement picktopicbtn; 

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	@FindBy(id = "zipcodebtn")
	private WebElement viewPlansButton;
	
	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;
	
	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;
	
	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;
	
	@FindBy(id = "dce")
	private WebElement prescriptionsLink;
	@FindBys(value = { @FindBy(xpath = "//table[@id='colhowdoesthiswork']/tbody/tr/td/span/span/a") })
	private List<WebElement> howdoesthiswork;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;
	
	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement pdpVppLink;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(id = "homefooter")
	private WebElement homefooter;
	
	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div/div/div[1]/p[2]/a/span")
	private WebElement ma_moreHelpInfoLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	@FindBy(linkText = "View all disclaimer information")
	private WebElement disclaimerViewLink;

	@FindBy(className = "disclaimer hideLink")
	private WebElement disclaimerHideLink;

	@FindBy(id = "medicareTitle")
	private WebElement medicareTitleText;
	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(linkText = "pharmacy")
	private WebElement pharmacyLink;
	
	@FindBy(id = "ghn_lnk_2")
	private WebElement ourPlans;
	
	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement maVppLink;
	
	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(xpath = "//div[@id='findazip_box']/div/div/div/h4")
	private WebElement zipCodeSearchPopupHeading;
	
	@FindBy(id = "cobrowse-disclaimer")
	private WebElement cobrowsemodelwindow;

	private PageData homePageDisclaimer;
	public JSONObject homePageDisclaimerJson;
	private PageData homePageDisclaimerHide;
	public JSONObject homePageDisclaimerHideJson;

	private PageData globalFooter;

	public JSONObject globalFooterJson;

	private PageData globalHeader;
	public JSONObject globalHeaderJson;

	private PageData alreadyPlanMember;
	public JSONObject alreadyPlanMemberJson;

	private PageData medicareEducationDropDown;
	public JSONObject medicareEducationDropDownJson;

	private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;
	
	private PageData browserCheckData;
	public JSONObject browserCheckJson;
	
	private PageData cobrowseData;
	public JSONObject cobrowseJson;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	


	public Boolean checkErrorMessage() {
		validate(signInButton);
		signInButton.click();
		validate(signInButton);
		return validate(alreadyMemberInvalidCredsErrorMessage);
	}

	public Boolean enterValidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer_001");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1blayer_001")
				&& pass.equalsIgnoreCase("Password@1")) {
			return true;
		}
		return false;
	}

	public AccountHomePage signInValid() {
		validate(signInButton);
		signInButton.click();
		// validate(signInButton);

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")) {
			return new AccountHomePage(driver);
		}

		return null;
	}

	public Boolean cookieValid() {
		validate(signInButton);
		signInButton.click();
		// validate(signInButton);
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validate(myPlansTab);
		if (getCookieName("membervisited") != null) {
			driver.switchTo().window(tabs.get(0));
			if (getCookieName("membervisited") != null) {
				return true;
			}
		}

		return false;
	}

	public Boolean alreadyMemberActiveValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				if (timer > 0) {
					return validate(signInButton);
				}
			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if (timer > 0) {
				return validate(signInButton);
			}

		}
		return false;

	}

	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie") || timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer * 1000;
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return validate(signInButton);
	}


	public Boolean stopTimerValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				timer = timer * 1000;
				usernameField.click();
				try {
					Thread.sleep(timer);
					return validate(signInButton);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			try {
				Thread.sleep(timer);
				return validate(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	
	
				public PlanSelectorPage planselector_click() {
					compareplans.click();
					if (getTitle().equalsIgnoreCase("Plan Selector")) {
						return new PlanSelectorPage(driver);
					}
					return null;
				}
				public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {

					Actions actions = new Actions(driver);
					actions.moveToElement(ourPlansHoverLink);
					actions.moveToElement(ma_moreHelpInfoLink);
					actions.click().build().perform();

					try {
						if (zipCodeField.isDisplayed()) {
							CommonUtility.waitForElementToDisappear(driver, zipCodeField,
									CommonConstants.TIMEOUT_30);
						}
					} catch (NoSuchElementException e) {
						System.out.println("zipCodeField not found");
					} catch (TimeoutException ex) {
						System.out.println("zipCodeField not found");
					} catch (Exception e) {
						System.out.println("zipCodeField not found");
					}
					if (currentUrl().contains(
							"medicare-advantage-plans/request-information.html")) {
						return new RequestHelpAndInformationPage(driver);
					}

					return null;
				}

				public void multiple_county(String zipcode)
				{
					System.out.println("Hi");
					sendkeys(zipCodeField, zipcode);
					System.out.println("Hi");
					viewPlansButton.click();
					if (countyModal.isDisplayed())
					{
						System.out.println("County model window appeared");
					}
					else
					{
						System.out.println("County model window not found");
					}
				}
			
				
				public JSONObject validatecobrowsemodelwindow()
				{
					String fileName=CommonConstants.COBROWSE_MODEL_WINDOW;
					cobrowseData=CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
					
					JSONObject jsonObject= new JSONObject();
					for (String key : cobrowseData.getExpectedData().keySet()) {
						WebElement element = findElement(cobrowseData.getExpectedData()
								.get(key));
						if (element != null) {
							if (validate(element)) {
								try {
									jsonObject.put(key, element.getText());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					cobrowseJson= jsonObject;
					return cobrowseJson;
				}


}

		