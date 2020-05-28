package pages.mobile.member.blayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstantsMobile;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard_deprecated.member.blayer.PaymentHistoryPage;

/**
 * @author pnampall
 *
 */

public class BenefitsSummaryPage extends UhcDriver{
	
	@FindBy(xpath = "//a[text()='Set Up Automatic Payments']")
	private WebElement setupAutomaticPayments;
	
	@FindBy(xpath= "//span[text()='Payment Method:']/../following-sibling::div[1]")
	private WebElement validatePaymentMethod;
	
	
	@FindBy(css="a.menu-open-button.add-class")
	private WebElement menuButton;
	
	@FindBy(xpath = "//div[@class='menu-container']/a")
	private WebElement logout;
	
	@FindBy(xpath = "//h3[text()='My Drug Benefits']/following::span[text()='VIEW DETAILS']")
	public WebElement viewdetailsbutton;
	
	@FindBy(xpath = "//h3[text()='My Preferred Drug Benefits']/following::a[1]")
	public WebElement lnk_viewdetails_PreferredDrugs;
	
	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/div[1]/a")
	private WebElement benefitDetails;
	
	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[2]")
	private WebElement customerService;
	
	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[3]")
	private WebElement pharmacyLocator;
	
	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[4]")
	private WebElement providerService;
	
	@FindBy(className = "menu-container")
	private WebElement menuContainer;

	@FindBy(xpath="//a[@ng-show='hasIDCard']")
	private static WebElement viewIDCard;
	
	@FindBy(xpath="//span[contains(.,'View Card Back')]")
	private static WebElement viewCardBack;
	

	@FindBy(xpath="/html/body/div[2]/a")
	private WebElement menu;
	
	@FindBy(xpath="//div[2]/a[3]")
	private WebElement pharamcyLocatorLink;

	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[2]/div/div/div[1]/div[5]/div/div[1]/a")
	private WebElement visualizeMyPlanBenefits;
	
	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[2]/div/div/div[1]/div[5]/div/div[2]/div/a")
	private WebElement visualizeMyDrugBenefits;

	
	@FindBy(xpath="//div[text()='List View']")
	private WebElement listView;
	
	@FindBy(xpath="//div[text()='Map View']")
	private WebElement mapView;


	
	@FindBy(linkText = "Map View")
	private WebElement mapview;

	@FindBy(linkText = "List View")
	private WebElement listview;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	
	private PageData benefitsSummary;

	public JSONObject benefitsSummaryJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	
	public BenefitsSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstantsMobile.BENEFITS_SUMMARY_PAGE_DATA;
		benefitsSummary = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(menuButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		benefitsSummaryJson = jsonObject;
		
		System.out.println("benefitsSummaryJson----->"+benefitsSummaryJson);
	}
	
	public MyPlanBenefitDetailsPage getMyPlanBenefitsPage(){
		visualizeMyPlanBenefits.click();
		
		if(currentUrl().contains("mobile/uhcm/home/visualize-plans.html"))
		{
			return new MyPlanBenefitDetailsPage(driver);
		}
		return null;
	}
	
	public MyDrugBenefitDetailsPage getMyDrugBenefitDetails(){
		visualizeMyDrugBenefits.click();
		
		if(currentUrl().contains("mobile/uhcm/home/visualize-plans.html"))
		{
			return new MyDrugBenefitDetailsPage(driver);
		}
		return null;
	}
	
	public PharmacyLocatorPage getPharmacyLocator(){
		menuButton.click();
		pharmacyLocator.click();
		
		if(currentUrl().contains("mobile/home/pharmacy-search.html"))
		{
			return new PharmacyLocatorPage(driver);
		}
		return null;
	}
	/**
	 * Get Pharmacy Locator page with required view
	 * @param pharmacyLocatorView -> Map View\List View
	 * @return
	 */
	public PharmacyLocatorPage getPharmacyLocator(String pharmacyLocatorView){
		menuButton.click();
		pharmacyLocator.click();
		
		if(pharmacyLocatorView.equals("List View")){
			listView.click();
		}else{
			mapView.click();
		}
		
		/*switch (pharmacyLocatorView) {
		case "List View":
			listView.click();
			break;
		case "Map View":
			mapView.click();
			break;
		}*/
		
		if(currentUrl().contains("mobile/home/pharmacy-search.html"))
		{
			return new PharmacyLocatorPage(driver);
		}
		return null;
	}
	
	public void getProviderSearch(){
		menuButton.click();
		providerService.click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
	}
	
	public CustomerServicePage getCustomerService(){
		menuButton.click();
		customerService.click();
		
		if(currentUrl().contains("mobile/home/customerservice.html"))
		{
			return new CustomerServicePage(driver);
		}
		return null;
	}
	
	public BenefitDetailsPage getMyBenefitDetails(){
		menuButton.click();
		benefitDetails.click();
		
		if(currentUrl().contains("insuredPlanId"))
		{
			return new BenefitDetailsPage(driver);
		}
		return null;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject benefitsSummaryExpectedJson = expectedDataMap
				.get(acceptancetests.data.CommonConstants.BENEFITS_SUMMARY_BLAYER);
		
		return benefitsSummaryExpectedJson;
	}

	public void logout()
	{
		menuButton.click();
		if(validate(menuContainer))
		{
			logout.click();
		}
		else
		{
			System.out.println("logout button not found on page");
		}
	}

	 public void navigateToPharamcyPage(){
		menu.click();
		pharamcyLocatorLink.click();
	 }
	public PharmacyLocatorPage navigateToPharmacyLocatorPage(){
		 menu.click();
		 pharamcyLocatorLink.click();
		 if(getTitle().equalsIgnoreCase("Pharmacy Search")){
			 return new PharmacyLocatorPage(driver);
		 }
		 else{
			 return null;
		 }
	 }

	public void Validate_pharmacy_locator() {
		boolean present;
		try {
			mapview.isDisplayed();
			listview.isDisplayed();
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if(present)
		System.out.println("@@@@@@@@@ Able to find mapview and listview @@@@@@@@@");
		else
		System.out.println("@@@@@@@@@ No option for views @@@@@@@@@");
		
	}

 	public static void clickOnViewIDCard() {
		viewIDCard.click();
		
	}
	
	public static void clickOnViewCardBack(){
		viewCardBack.click();
	}

	 
		 
	 public JSONObject getBrowserCheck() {
	
		String fileName = CommonConstantsMobile.MOBILE_BROWSER_CHECK_DATA_BLUELAYER;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}

	public BenefitDetailsPage clickviewdrugdetails() {
		
		validate(viewdetailsbutton);
		viewdetailsbutton.click();
		validate(viewdetailsbutton);
		
		if (getTitle().equalsIgnoreCase("Visualize Plans")) {
			return new BenefitDetailsPage(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	public PreferredDrugBenefitsDetailPage clickPreferredDrugViewDetails() {
		
		validate(lnk_viewdetails_PreferredDrugs);
		lnk_viewdetails_PreferredDrugs.click();
		validate(lnk_viewdetails_PreferredDrugs);
		
		if (getTitle().equalsIgnoreCase("Visualize Plans")) {
			return new PreferredDrugBenefitsDetailPage(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}
	public PaymentHistoryPage changeUrlToNewPaymentHistoryPage() {

		String NewPayHistoryUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/payments.html";
		
		driver.get(NewPayHistoryUrl);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PaymentHistoryPage(driver);
		}

	public boolean validateSetupAutomaticPayments() {

		try {
			Thread.sleep(10000);
			if (setupAutomaticPayments.getText().equalsIgnoreCase("Set Up Automatic Payments")
					&& validatePaymentMethod.getText().equalsIgnoreCase("Monthly Bill")) {
				System.out.println("setupAutomaticPayments and Payment methods exists" + setupAutomaticPayments
						+ validatePaymentMethod);
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public pages.dashboard_deprecated.member.blayer.PaymentHistoryPage navigateToNewPaymentHistoryPage() {
		String NewPayHistoryUrl = "content/dashboard/home/Payments.html";
		String url = driver.getCurrentUrl();
		url = url.replace("mobile/home/my-benefit-summary.html",
				NewPayHistoryUrl);
		driver.get(url);
		if (paymentsHeading.getText().contains("Premium Payments Overview")) {
			return new pages.dashboard_deprecated.member.blayer.PaymentHistoryPage(driver);
		}
		return null;
	}
	public pages.mobile.member.blayer.ContactUsPage navigateToContactusRedesignPage() {
		// TODO Auto-generated method stub
		String url = "https://member.team-e-uhcmedicaresolutions.uhc.com/content/uhcm/home/contact.html";
		driver.get(url);
		if (driver.getTitle().equals("Contact Us")) {
			return new pages.mobile.member.blayer.ContactUsPage(driver);

		}
		return null;
	}

}
