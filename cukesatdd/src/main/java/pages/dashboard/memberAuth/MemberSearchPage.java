package pages.dashboard.memberAuth;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;
import pages.member.ulayer.TestHarness;

public class MemberSearchPage extends UhcDriver {
	
	
	public JSONObject loginPageJson;
	

	
	@FindBy(id = "userName")
	private WebElement username;
	
	@FindBy(xpath = "//span[@class='btn btn--primary findFacilityBtn']")
	private WebElement search;
	
	@FindBy(css ="div.searchResults table.resultsTable")
	private WebElement memberAuthSearchResultsTable;
	
	@FindBy(xpath = "//*[contains(text(),'Login as member')]")
	private WebElement loginasmember;
	
	private static String MEMBER_AUTH = MRConstants.MEMBER_AUTH;
	
	public MemberSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	

	public void memblogin(String member){
		WebDriverWait wait = new WebDriverWait(driver,30);
	     wait.until(ExpectedConditions.visibilityOf(username));
		validate(username);
		username.sendKeys(member);
	search.click();
	try {
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(memberAuthSearchResultsTable));
	     //JavascriptExecutor js = (JavascriptExecutor)driver;
	     WebElement memberusername = driver.findElement(By.cssSelector("html/body/div[4]/div/div/div[3]/div/div[3]"));
	     validate(memberusername);
	     //js.executeScript("arguments[0].click();", memberAuthSearchResultsTable);
	     //Thread.sleep(8000);
	     memberusername.click();
	     Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public TestHarness loginAsMember(){
		WebDriverWait wait = new WebDriverWait(driver,120);
	     wait.until(ExpectedConditions.visibilityOf(loginasmember));
		validate(loginasmember);
		loginasmember.click();
		switchToNewTab();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TestHarness(driver);
	}
	
	}

