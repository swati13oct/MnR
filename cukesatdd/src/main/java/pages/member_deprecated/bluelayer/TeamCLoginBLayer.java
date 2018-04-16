package pages.member_deprecated.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.member_deprecated.ulayer.AccountHomePage;
import pages.member_deprecated.ulayer.TerminatedHomePage;

public class TeamCLoginBLayer extends UhcDriver {

	// Page URL
	//private static String PAGE_URL = MRConstants.AARPM_URL;
	//BL url
	
	private static String PAGE_URL = MRConstants.TeamH_BLayer_Member_URL;

	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

	@FindBy(id = "loginPOPUPuser")
	private WebElement userNameField;

	@FindBy(id = "loginPOPUPpass")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='fd_userPassSection']/button")
	private WebElement signInButton;

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;
	

	private PageData browserCheckData;

	private JSONObject browserCheckJson;


	public TeamCLoginBLayer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Object loginWith(String username, String password) {
		loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		signInButton.click();
		

		if(MRScenario.environment.equals("team-h") || MRScenario.environment.equals("team-c")) {
			try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			}catch(Exception e)		{
				System.out.println("No Such alert displayed");
			}
			/*if (!(MRScenario.environment.equals("awe-dev-b") || MRScenario.environment.equals("dev-c") || MRScenario.environment.equals("team-b"))){
				Alert alert2 = driver.switchTo().alert();
				alert2.accept();
			}*/
			
		}else
			
/*
		if ( MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("dev-c")
		|| MRScenario.environment.equals("team-a")) {
		Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();        
        	if (!MRScenario.environment.equals("dev-c")){
        		Alert alert2 = driver.switchTo().alert();
        		alert2.accept();
 			}

 		}*/
            
		
		if(currentUrl().contains("home/my-account-home.html"))

		{
			return new AccountHomePage(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver); 
		}
		return null;
	}

	public LoginAssistancePage navigateToLoginAssistance() {
		loginIn.click();
		forgotUsernamePasswordLink.click();
		CommonUtility.waitForPageLoad(driver, userNameCheckBox, 5);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}

		return null;

	}	


	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(loginIn);

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



}
