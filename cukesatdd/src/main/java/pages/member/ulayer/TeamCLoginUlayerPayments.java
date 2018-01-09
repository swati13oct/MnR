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

public class TeamCLoginUlayerPayments extends UhcDriver {
	
		private static String PAGE_URL = MRConstants.TeamC_ULayer_Member_URL;
		
		@FindBy(id = "fd_memberSignInButton")
		private WebElement loginIn;

		@FindBy(id = "loginPOPUPuser")
		private WebElement userNameField;

		@FindBy(id = "loginPOPUPpass")
		private WebElement passwordField;

		@FindBy(xpath = ".//*[@id='fd_signInPanel']/div[2]/div[4]/button")
		private WebElement signInButton;
		
		private PageData browserCheckData;

		private JSONObject browserCheckJson;


		public TeamCLoginUlayerPayments(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}

		

		public Object loginWith(String username, String password) {
			loginIn.click();	
			sendkeys(userNameField,username);
			sendkeys(passwordField,password);
			signInButton.click();
			System.out.println("Sign In clicked");
			

			if(MRScenario.TeamCEnvironment.equals("team-c")) {
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
			
			if(currentUrl().contains("home/my-account-home.html"))

			{
				return new AccountHomePage(driver);
			}
			else if (currentUrl().contains("terminated-plan.html")) {
				return new TerminatedHomePage(driver); 
			}
			return new AccountHomePage(driver);
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
