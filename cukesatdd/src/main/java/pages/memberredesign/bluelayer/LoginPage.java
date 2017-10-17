package pages.memberredesign.bluelayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.TerminatedHomePage;

public class LoginPage extends UhcDriver {
	
	private static String PAGE_URL_TEST_HARNESS = MRConstants.UHCM_URL_TEAMB_TESTHARNESS;
	

	@FindBy(id = "username")
	private WebElement thUserName;
	
	@FindBy(id = "password")
	private WebElement thPassword;
	
	@FindBy(id = "sign-in-btn")
	private WebElement thSignIn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		start(PAGE_URL_TEST_HARNESS);
		validate(thUserName);
		validate(thPassword);
		validate(thSignIn);
		
	}
	
	public Object thloginWith(String username, String password, String category) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*WebElement loginInEle= this.driver.findElement(By.id("fd_memberSignInButton"));
		loginInEle.click();*/
		sendkeys(thUserName, username);
		sendkeys(thPassword, password);
		thSignIn.click();

		
		if (MRScenario.environment.equals("dev-a") || MRScenario.environment.equals("team-a")) {
			while (!isAlertPresent());
        }


		if (MRScenario.environment.equals("dev-a"))  {

			while (!isAlertPresent());
		}
		if ( MRScenario.environment.equals("team-c") || MRScenario.environment.equals("team-b")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        //Alert alert1 = driver.switchTo().alert();
	        //alert1.accept();
	        } 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Group") || currentUrl().contains("/guest/home.html") || currentUrl().contains("/login.html"))

		{
			return new AccountHomePage(driver,category);
		}
		else if(currentUrl().contains("home/my-account-home.html") && category.equalsIgnoreCase("Individual") || currentUrl().contains("/login.html") ) {
			return new AccountHomePage(driver, category);
		}
		else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		}
		return null;
	}
	
	public boolean isAlertPresent(){ 
	    try{ 
	        Alert a = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	        if(a!=null){
	            System.out.println("Alert is present = " + a.getText());
	            driver.switchTo().alert().accept();
	            return true;
	        }else{
	            //throw new Throwable();
	        	System.out.println("alert is not present 1");
	        	return false;
	        }
	    } 
	    catch (Throwable e) {
	        System.err.println("Alert isn't present!!");
	        return false; 
	    } 

	} 
	
	public static boolean isAlertPresent(WebDriver wd) {
		try {
			Alert alert = wd.switchTo().alert();
			alert.dismiss();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		} catch (UnsupportedCommandException e) {
			System.out.println("WebDriver doesn't support switchTo() method");
			return false;
		}
	}

}
