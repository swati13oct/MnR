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



public class TeamHLoginUlayer extends UhcDriver{
	
	private static String PAGE_URL = MRConstants.TeamH_ULayer_Member_URL;
	
	@FindBy(id = "fd_memberSignInButton")
	private WebElement loginIn;

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

	

	public Object loginWith(String username, String password) throws InterruptedException {
		//loginIn.click();	
		sendkeys(userNameField,username);
		sendkeys(passwordField,password);
		signInButton.click();
		System.out.println("Sign In clicked");
		

		 
			try{
			System.out.println();
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
		          
		Thread.sleep(20000);
		if(currentUrl().contains("/dashboard"))

		{
			return new RallyDashboard(driver);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver); 
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
