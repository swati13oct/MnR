package pages.member.ulayer;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class UNPWAssistancePage extends UhcDriver {

	@FindBy(xpath = ".//label[@for='select-username']")
	private WebElement UsenameBtn;

	@FindBy(xpath = ".//label[@for='select-password']")
	private WebElement pwdBtn;

	@FindBy(xpath = ".//label[@id='invalidmember-id'][@class='error']")
	private WebElement MemberIDError;

	@FindBy(id = "member-id")
	private WebElement MemberID;

	@FindBy(xpath = ".//label[@id='dobGroup'][@class='error']")
	private WebElement DOBerror;

	@FindBy(id = "date-mm")
	private WebElement DOBmm;

	@FindBy(id = "date-dd")
	private WebElement DOBdd;

	@FindBy(id = "date-yyyy")
	private WebElement DOByyyy;

	@FindBy(xpath = ".//label[@id='lastnameErr'][@class='error']")
	private WebElement LastNameError;

	@FindBy(xpath = ".//*[@class='error']")
	private WebElement ErrorinPage;

	@FindBy(id = "lastname")
	private WebElement LastName;

	@FindBy(xpath = ".//label[@id='invalidzipErr'][@class='error']")
	private WebElement ZIPerror;

	@FindBy(id = "zipcode")
	private WebElement ZIP;

	@FindBy(xpath = ".//span[@class='errmsg']")
	private WebElement Valid_email_error;

	@FindBy(xpath = ".//a[@class='btn btn--secondary'][contains(text(),'Cancel')]")
	private WebElement cancel;

	@FindBy(xpath = ".//button[@class='btn']")
	private WebElement ContinueButton;

	@FindBy(linkText = "BACK TO SIGN IN PAGE")
	private WebElement BackSignInPage;

	@FindBy(xpath = ".//div[@class='field error']")
	private WebElement MemNotFoundErr;

	private static String PAGE_URL = MRConstants.Stage_UNPWAssistancePage_URL;

	// private static String PAGE_URL = TeamC_UNPWAssistancePage_URL;

	public UNPWAssistancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
	}
	
	/** 
	 * @todo : Validate the page navigated is Username password page or not
	 */
	public void UNPWinfoMissing() throws InterruptedException {

		Thread.sleep(8000);
		if (!UsenameBtn.isDisplayed()) {
			Assert.fail("Username and password page not displayed!");
		}
		UsenameBtn.click();
		pwdBtn.click();
		Thread.sleep(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ContinueButton);
		Thread.sleep(5000);

		if (!MemberID.isDisplayed()) {
			Assert.fail("Username and password page not displayed!");

		}
	}
	
	/** 
	 * @todo : Fill all the details for validating the member
	 */
	public void FillDetails(String MemID, String DBmm, String DBdd,
			String DByyyy, String LstName, String ZP)
			throws InterruptedException {

		MemberID.sendKeys(MemID);

		DOBmm.sendKeys(DBmm);
		DOBdd.sendKeys(DBdd);
		DOByyyy.sendKeys(DByyyy);

		// Select DBmnth = new Select(DOBmm);
		// DBmnth.selectByIndex(Integer.parseInt(DBmm));

		// Select DBday = new Select(DOBdd);
		// DBday.selectByValue(DBdd);
		//
		// Select DByr = new Select(DOByyyy);
		// DByr.selectByVisibleText(DByyyy);

		LastName.sendKeys(LstName);
		ZIP.sendKeys(ZP);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,70)", "");

		ContinueButton.click();
		Thread.sleep(10000);

		boolean flag = false;

		try {
			flag = ErrorinPage.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}

		if (!(flag)) {

			try {
				flag = BackSignInPage.isDisplayed();
			} catch (Exception e) {
				flag = false;
			}
			boolean MemNotFoundErrFlag;
			try {
				MemNotFoundErrFlag = MemNotFoundErr.isDisplayed();
			} catch (Exception e) {
				MemNotFoundErrFlag = false;
			}

			if (flag) {
				System.out.println("Email will be triggered");
			} else if (MemNotFoundErrFlag) {
				System.out.println("Member not found!");
			} else {
				Assert.fail("something went wrong / Member details are incorrect!");
			}

		} else
			System.out.println("Member details contains errors!");
	}
}
