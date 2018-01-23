package pages.member.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;



public class TeamHLoginUlayer extends UhcDriver{
	
	private static String PAGE_URL = MRConstants.TeamH_ULayer_Member_URL;
	// Commenting code
/*	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;*/

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id="sign-in-btn")
	private WebElement signInButton;
	
	private PageData browserCheckData;

	private JSONObject browserCheckJson;


	public TeamHLoginUlayer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	

	


	@Override
	public void openAndValidate() {
		System.out.println("URL:"+PAGE_URL);
		start(PAGE_URL);
		validate(signInButton);
		//validate(loginIn);

	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARPM_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

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

//Updated loginWith to include RallyDashboard navigation
	public Object loginWith(String username, String password) throws InterruptedException {
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		signInButton.click();
		System.out.println("Sign In clicked");
			/*try{
			System.out.println();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			}catch(Exception e)		{
				System.out.println("No Such alert displayed");
			}*/
		CommonUtility.checkPageIsReady(driver);
		int counter =0;
		do{
			if(counter<=15)
			Thread.sleep(5000);
			else
				return null;
			counter++;
			if(driver.getTitle().contains("Internal Error") || driver.getTitle().contains("Sign In"))
				return null;
		}
		while(!(driver.getTitle().contains("Home")));
				
		
		System.out.println("Current URL: "+currentUrl());
		/*if(currentUrl().contains("member/testharness.html"))
		{
			return new TestHarness(driver);
		}*/
		if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver); 
		}
		else if (currentUrl().contains("/dashboard")) {
			return new RallyDashboardPage(driver); 
		}
		return null;
	}

}
