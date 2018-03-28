package pages.member.bluelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

public class ProfilePageHsid  extends UhcDriver {
	@FindBy(id = "hsidPwdLink")
	private WebElement hsidPasswordLink;
	
	@FindBy(xpath = "//*[@id='header']/h1/a")
	private WebElement breadCrumbToNavigateBack;
	
	@FindBy(id = "hsidRecLink")
	private WebElement hsidAccountLink;
	
	   @FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
       private List<WebElement> iPerceptionPopUp;
       

	public ProfilePageHsid(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
		if (iPerceptionPopUp.size()>0) {
            iPerceptionPopUp.get(0).click();
            System.out.println("iPerception Pop Up displayed");
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public void validateHealthSafeIdLink() throws InterruptedException {
		validateNew(hsidPasswordLink);
		hsidPasswordLink.click();
	
		Thread.sleep(10000);
		System.out.println("PageTitle "+driver.getTitle());
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("HealthSafe ID"));
		

	}

	public void validateBreadCrumb() throws InterruptedException {
		// TODO Auto-generated method stub
		
		validate(breadCrumbToNavigateBack);
		
	}

	@SuppressWarnings("deprecation")
	public void validateBreadCrumbClick() {
		// TODO Auto-generated method stub
		breadCrumbToNavigateBack.click();
		CommonUtility.waitForPageLoad(driver,hsidPasswordLink, 50);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Profile"));
	
	}

	public void validateHealthSafeAccountLink() throws InterruptedException {
		validate(hsidAccountLink);
		hsidAccountLink.click();
		Thread.sleep(10000);
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("HealthSafe ID"));

		
	}

}
