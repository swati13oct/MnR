package pages.member.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import atdd.framework.UhcDriver;

public class Rallytool_Page extends UhcDriver{

	@FindBy(id="user")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//tr[5]/td[2]/table/tbody/tr/td[2]/a")
	private WebElement login;
	
	@FindBy(xpath="//tr[2]/td[1]/div/ul/li[3]/a")
	private WebElement findDoctor;
	
	@FindBy(xpath="//*[text()='Find a Provider']")
	private WebElement findProvider;
	
	public Rallytool_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
  public void navigateToRallyPageSSO(){
 		  userName.sendKeys("claimletter007");
		  password.sendKeys("test2day");
		  login.click();
		  //findDoctor.click();
		  switchToNewTab(findDoctor);
		  if(currentUrl().contains("werally.in")){
			  System.out.println("Rally Tool Launched Succesfully");
		  }else{
			  System.out.println("-----------Failed as rally not visible---------");
			  Assert.fail();
		  }
	  }
  
	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		}
    
}
