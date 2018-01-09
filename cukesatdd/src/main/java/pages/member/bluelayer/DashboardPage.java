package pages.member.bluelayer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.member.bluelayer.OrderplanmaterialsPage;
import pages.member.bluelayer.ContactUsPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.ProfilePreferencesPage;

public class DashboardPage extends UhcDriver {

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Find Care')])[1]")
	private WebElement panelFindCareCost;

	@FindBy(id = "premiumpayment")
	private WebElement panelPremiumPayment;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Home')])[1]")
	private WebElement panelHome;

	@FindBy(xpath = "(//nav[@id='main-nav']//a[contains(text(),'Claims')])[1]")
	private WebElement panelClaims;

	@FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;

	@FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;

	@FindBy(xpath = "//header//h1")
	private WebElement heading;

	@FindBy(xpath = "//div[@id='ui-view-page']//span[contains(text(),'Look up Drugs')]")
	private WebElement DCE_Dashboard;

	@FindBy(xpath = "//sticky[@id='sticky-nav']//nav[@id='main-nav']//a[contains(text(),'Coverage & Benefits')]")
	private WebElement BnClink;

	@FindBy(xpath = "(//nav[@id='utility-nav']//a/span[contains(text(),'Help')])[1]")
	private WebElement ContactUsLink;
	


	@Override
	public void openAndValidate() {

CommonUtility.waitForPageLoad(driver, panelHome, 60);
	System.out.println(driver.getCurrentUrl());
		validate(panelHome);
	}

	public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		accountToggleDropdown.click();
		validate(accountSettingOption);
		accountSettingOption.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			
			return new ProfilePreferencesPage(driver);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public BenefitsAndCoveragePage navigateDirectToBnCPag() {

		// driver.navigate().to(PAGE_URL);
		validate(BnClink);
		BnClink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}

}
