package pages.regression.needHelp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/** methods used by Need Help section validation page */
public class NeedHelpWebElements extends UhcDriver  {

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	protected List<WebElement> comboTabs;	

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechSupp;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechSupp_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechSupp_ph;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechSupp_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechSupp_wkndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GenQue;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GenQue_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GenQue_ph;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GenQue_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GenQue_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GenQue_wkndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupp;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupp_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupp_ph;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupp_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupp_wkndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupp;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupp_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupp_ph;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupp_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupp_wkdyHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	public NeedHelpWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

}