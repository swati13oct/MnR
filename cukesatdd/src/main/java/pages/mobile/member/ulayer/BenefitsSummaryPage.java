/**
 * 
 */
package pages.mobile.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstantsMobile;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard_deprecated.member.ulayer.PaymentHistoryPage;

/**
 * @author pjaising
 *
 */
public class BenefitsSummaryPage extends UhcDriver{
	
	@FindBy(xpath="//div[@class='site-header']/a")
	private WebElement menuButton;
	
	@FindBy(xpath = "//div[@class='menu-container']/a")
	private WebElement logout;
	
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
	
	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[2]/div/div/div[1]/div[5]/div/div[2]/div/a/span")
	public WebElement viewdetailsbutton;
	
	@FindBy(xpath = "//h3[contains(text(),'Preferred')]/following::a[1]")
	public WebElement lnk_viewdetails_PreferredDrugs;
	
	@FindBy(xpath = "//a[text()='Set Up Automatic Payments']")
	private WebElement setupAutomaticPayments;

	@FindBy(xpath = "//span[text()='Payment Method:']/../following-sibling::div[1]")
	private WebElement validatePaymentMethod;
	
	@FindBy(id = "makeOneTimePayment")
	private WebElement makeOneTimePayment;
	
	@FindBy(xpath=".//*[@id='wrapper']/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[5]/div[1]/a/span")			
	        private WebElement hospitalstay;
	
	@FindBy(xpath=".//*[@id='wrapper']/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[6]/div[1]/a/span")			
	    private WebElement medicalcarelink;

	 //@FindBy(id="VIEW DETAILS")			
	      @FindBy(xpath=".//*[@id='wrapper']/div[1]/div[2]/div/div/div[1]/div[5]/div/div/a/span")			
	      private WebElement viewdetailsbuttonship;
	      
	      @FindBy(xpath=".//*[@id='wrapper']/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[7]/div[1]/a/span")			
	      	        			
	      	        private WebElement skilledfacilitylink;
	
	private PageData benefitsSummary;

	public JSONObject benefitsSummaryJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/h1")
	private WebElement paymentsHeading;

	public BenefitsSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstantsMobile.BENEFITS_SUMMARY_PAGE_DATA;
		benefitsSummary = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_ULAYER_MEMBER);
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

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject benefitsSummaryExpectedJson = expectedDataMap
				.get(acceptancetests.data.CommonConstants.BENEFITS_SUMMARY);
		
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

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstantsMobile.MOBILE_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_ULAYER_MEMBER);

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



	/*public boolean changeUrlToNewPaymentHistoryPage() {

		String NewPayHistoryUrl = "content/aarpm/home/my-plans/payments/PaymentsOverview-DashBoard.html";
		String url = driver.getCurrentUrl();
		url = url.replace("home/my-account-home.html", NewPayHistoryUrl);
		driver.get(url);

		if (currentUrl().contains("PaymentsOverview-DashBoard.html")) {
			return true;
		}
		return false;
	}*/


	public pages.dashboard_deprecated.member.ulayer.PaymentHistoryPage navigateToNewPaymentHistoryPage() {
		String NewPayHistoryUrl = "content/dashboard/home/Payments.html";
		String url = driver.getCurrentUrl();
		url = url.replace("mobile/home/my-benefit-summary.html",
				NewPayHistoryUrl);
		driver.get(url);
		if (paymentsHeading.getText().contains("Premium Payments Overview")) {
			return new pages.dashboard_deprecated.member.ulayer.PaymentHistoryPage(driver);
		}
		return null;
	}
	
	public pages.mobile.member.ulayer.ContactUsPage navigateToContactusRedesignPage() {
		// TODO Auto-generated method stub
		String url = "https://member.team-e-aarpmedicareplans.uhc.com/content/aarpm/home/contact.html";
		driver.get(url);
		if (driver.getTitle().equals("Contact Us")) {
			return new pages.mobile.member.ulayer.ContactUsPage(driver);

		}
		return null;
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
	
	public void navigateToPharamcyPage(){
		menu.click();
		pharamcyLocatorLink.click();
	 }
	public PaymentHistoryPage changeUrlToNewPaymentHistoryPage() {

		String NewPayHistoryUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/payments.html";
		
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
		String NewPayHistoryUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/payments.html";
		
		driver.get(NewPayHistoryUrl);
		try {
			Thread.sleep(10000);
			if (setupAutomaticPayments.getText().equalsIgnoreCase("Set Up Automatic Payments")
					&& validatePaymentMethod.getText().equalsIgnoreCase("CMS-SSA/RRB")) {
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

	public boolean validateOneTimePaymentDtmValues() {
		// TODO Auto-generated method stub
		String NewPayHistoryUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/payments.html";
		
		driver.get(NewPayHistoryUrl);

		try {
			Thread.sleep(10000);
			if (makeOneTimePayment.getAttribute("dtmid").equalsIgnoreCase("cta_payments") && makeOneTimePayment
					.getAttribute("dtmname").equalsIgnoreCase("payments:fed:monthly billing:make one time payment")) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean validateSetupPaymentDtmValues() {
		// TODO Auto-generated method stub
		String NewPayHistoryUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/payments.html";
		
		driver.get(NewPayHistoryUrl);

		try {
			Thread.sleep(10000);
			if (setupAutomaticPayments.getAttribute("dtmid").equalsIgnoreCase("cta_payments")
					&& setupAutomaticPayments.getAttribute("dtmname")
							.equalsIgnoreCase("payments:fed:monthly billing:set up automatic payments")) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public BenefitDetailsPage viewdetailsclick() {
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter method");
			validate(viewdetailsbuttonship);
			viewdetailsbuttonship.click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 hospitalstay.click();
			 
			 try {
					Thread.sleep(25000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (getTitle().equalsIgnoreCase(
					"Visualize Plans")) {
			
				System.out.println("Visualize Plans");
				return new BenefitDetailsPage(driver);
			}
		// TODO Auto-generated method stub
		return null;
	}

	public BenefitDetailsPage viewdetailsmedicalcareclick() {
		
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter method");
		validate(viewdetailsbuttonship);
		viewdetailsbuttonship.click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			medicalcarelink.click();
			 
			 try {
					Thread.sleep(25000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (getTitle().equalsIgnoreCase(
					"Visualize Plans")) {
			
				System.out.println("Visualize Plans");
				return new BenefitDetailsPage(driver);
			}
	
		// TODO Auto-generated method stub
		return null;
	}

	public BenefitDetailsPage viewdetailsskilledclick() {
		
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter method");
		validate(viewdetailsbuttonship);
		viewdetailsbuttonship.click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			skilledfacilitylink.click();
			 
			 try {
					Thread.sleep(25000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (getTitle().equalsIgnoreCase(
					"Visualize Plans")) {
			
				System.out.println("Visualize Plans");
				return new BenefitDetailsPage(driver);
			}

		// TODO Auto-generated method stub
		return null;
	}
}


