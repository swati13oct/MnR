package pages.member.bluelayer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.acquisition.bluelayer.LoginAssistancePage;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;


public class MemberAuthPage extends UhcDriver {

	private static String PAGE_URL = MRConstants.MEM_AUTH_URL;
	
	@FindBy(xpath = ".//*[@id='loginusername']")
	private WebElement userField;
	
	@FindBy(xpath = ".//*[@id='loginpassword']")
	private WebElement passField;
	
	@FindBy(xpath = ".//*[@id='find_searchbtn']")
	private WebElement loginBtn;
	
	@FindBy(xpath = ".//*[@id='userName']")
	private WebElement username;
	
	@FindBy(xpath = ".//*[@id='memAuthLoginBox']/div/div/div/div/div[2]/form/div[1]/button")
	private WebElement searchBtn;
	
	@FindBy(xpath = ".//*[@id='memAuthLoginBox']/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[1]/a")
	private WebElement memberUsernameLink;
	
	@FindBy(xpath = "html/body/div[4]/div/div/div[3]/div/div[3]/div/a[1]")
	private WebElement logMeAsMemberBtn;
	
	public MemberAuthPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		start(PAGE_URL);
		validate(userField);
		validate(passField);
		validate(loginBtn);
	}
	
	public void login(String user, String pass){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userField.sendKeys(user);
		passField.sendKeys(pass);
		loginBtn.click();
	}
	
	public void searchMember(String user){
		username.sendKeys(user);
		searchBtn.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MemberRedesignPage navigateToRally(){
		memberUsernameLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		logMeAsMemberBtn.click();
		return new MemberRedesignPage(driver);
	}

}
