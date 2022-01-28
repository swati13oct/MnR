/**
 * 
 */
package pages.acquisition.commonpages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

/**
 * @author rkodumur
 *
 */
public class PrivacyPolicyAARPPage extends GlobalWebElements{
 
	//@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	//@FindBy(xpath="//span[contains(@class,'heading-1')]")
	@FindBy(xpath="(//span[contains(@class,'heading-1')])[2]")
	public WebElement header;
	
	//@FindBy(xpath = "(//section[contains(@class,'meded-article-content')]//p)[1]")
	@FindBy(xpath="//h2//span[contains(@class,'paragraph')]")
	public WebElement pageContent_Para1;
	
	public PrivacyPolicyAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(pageContent_Para1);
	}

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
	private WebElement CallSamTFN;

	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'timezone')]")
	private WebElement CallSamTFNtimezone;

	@FindBy(xpath = "//div[@id='sam-call-modal']//p[contains(text(),'Already a member')]")
	private WebElement CallSamTFNMember;
	
	@FindBy(xpath = "//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
	private WebElement CallSamTFNClose;
	
	public void validateCallpopuponapage(String TFNXpath, String ExpecetdTFNNo) throws InterruptedException {
		// driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		threadsleep(3);
		WebElement ActualTFNelement = driver.findElement(By.xpath(TFNXpath));
		validateNew(ActualTFNelement);
		validate(ActualTFNelement);
		String ActualCallSAMTFN = ActualTFNelement.getText();
		System.out.println("TFN No displayed on the Page" + ActualCallSAMTFN);
		jsClickNew(ActualTFNelement);
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		validate(CallSamTFN);
		String ExpectedCallSAMTFN = CallSamTFN.getText();
		System.out.println("TFN No displayed on the Page" + ExpectedCallSAMTFN);
		/*if (ExpectedCallSAMTFN.contains(ActualCallSAMTFN)) {
			System.out
					.println("****************TFN number was  found macthing with the SAM call Popup  ***************");

			Assertion.assertTrue(true);
		} else {
			Assertion.fail("*****************TFN number was  not found macthing with the SAM call Popup ***************"
					+ ExpectedCallSAMTFN);
		}*/
		String ExpectedCallSamTFNtimezone = "Hours: 8 a.m. ï¿½ 8 p.m., 7 days a week.*\n*Alaska and Hawaii: 8 a.m. ï¿½ 8 p.m. Monday ï¿½ Friday, 8 a.m. ï¿½ 5 p.m. Saturday and Sunday.";
		validate(CallSamTFNtimezone);
		String ActualCallSamTFNtimezone = CallSamTFNtimezone.getText();
		System.out.println(ExpectedCallSamTFNtimezone);
		System.out.println(ActualCallSamTFNtimezone);
		if (ExpectedCallSamTFNtimezone.replace(" ", "").replace("\n", "")
				.equalsIgnoreCase(ActualCallSamTFNtimezone.replace(" ", "").replace("\n", ""))) {
			System.out.println(
					"****************TFN Timezone Content was  found macthing with the SAM call Popup  ***************");

		} else {
			System.out.println(
					"****************TFN Timezone Content was not found macthing with the SAM call Popup  ***************");
		}
		String ExpectedCallSamTFNMember = "Already a member? Call the number on the back of your member ID card.";
		// ActualCallSamTFNMember.replace("", " ");
		// WebElement strCallSamTFNMember=
		// driver.findElement(By.xpath("//p[contains(text(),'Already a member?')]"));
		validate(CallSamTFNMember);
		String ActualCallSamTFNMember = CallSamTFNMember.getText();
		System.out.println(ExpectedCallSamTFNMember);
		if (ExpectedCallSamTFNMember.equalsIgnoreCase(ActualCallSamTFNMember)) {
			System.out.println(
					"****************TFN Member Content was  found macthing with the SAM call Popup  ***************");
			Assertion.assertTrue(true);
		} else {
			Assertion.fail(
					"*****************TFN Member Content was not found macthing with the SAM call Popup  ***************"
							+ ActualCallSamTFNMember);
		}
		validate(CallSamTFNClose);
		jsClickNew(CallSamTFNClose);
		
	}
	
	@FindBy(xpath = "//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]")
	private WebElement samChatIcon;
	public void validateSamChatIcon() throws InterruptedException {
		boolean present;
		try {
			threadsleep(10);
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);
			fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver
							.findElement(By.xpath("//*[contains(@id,'LPMcontainer')]//*[contains(text(),'Chat Now')]"));
				}
			});
			validateNew(samChatIcon);
			present = true;
		} catch (Exception e) {
			present = false;
			if (driver.getCurrentUrl().contains("welcome"))
				;
			driver.navigate().refresh();
			present = validateNew(samChatIcon);
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to see Chat Icon @@@@@@@@@");

		} else
			System.out.println("@@@@@@@@@ Chat Icon not available @@@@@@@@@");

	}

}
