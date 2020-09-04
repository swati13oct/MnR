package pages.mobile.acquisition.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*@author pagarwa5*/

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;


public class AcquisitionHomePageMobile extends GlobalWebElementsMobile {
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;

	String CallSam = "Call a Licensed Insurance Agent";
	String ChatSam = "Chat with a Licensed Insurance Agent";
	String CallSamPopupTitle="Need Help? Call us.";
	String ChatSamPopupTitle="Please provide the following information";
	@FindBy(xpath = "//*[contains(@class,'activeChatBtn')]")
	private WebElement chatsam;

	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[2]/img")
	private WebElement callsam;

	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
	private WebElement callsamtooltip;

	/*
	 * @FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]") private
	 * WebElement CallSamTFN;
	 */

	@FindBy(xpath = "//*[@id='sam-call-modal']/div/div/div[1]/a")
	private WebElement CallSamTFNClose;

	@FindBy(xpath = "//*[@id='sam-button--chat']/div//a[@class='sam__button__text']")
	private WebElement chatSamTooltip;
	
	@FindBy(xpath = "//*[@id='sam-call-modal']//div[@class='modal-content']")
	private WebElement callSamPopup;
	
	@FindBy(xpath = "//*[@id='sam-call-modal']//h3[@id='sam-call-modal__title']")
	private WebElement callSamPopupTitle;
	
	@FindBy(xpath = "//div[@id='servicepatternsite-iframe-chat']//div[@id='agent-name']")
	private WebElement chatSamPopupTitle;
	
	@FindBy(xpath = "//*[@id='sp-chat-iframe']")
	private WebElement chatSamPopupFrame;

	public AcquisitionHomePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openPRE() {
		if (!(MRScenario.getProps() == null)) {// If running from local
			if (MRScenario.environment.equalsIgnoreCase("digital-uatv2-aarp")) {
				startNewMobile(
						AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp", "digital-uatv2").replace("www.", ""));
				// startNewMobile(AARP_ACQISITION_PAGE_URL.replace("digital-uatv2-aarp",
				// "digital-uatv2"));
			} else if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
				// startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("offline-stage-aarp", "offline-stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("stage-aarp")) {
				startNewMobile(AARP_ACQISITION_PAGE_URL.replace("stage-aarp", "stage"));
			} else if (MRScenario.environment.equalsIgnoreCase("stage")) {
				startNewMobile(UMS_ACQISITION_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod-aarp")) {
				startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("offline-prod")) {
				startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod-aarp")) {
				startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
			} else if (MRScenario.environment.equalsIgnoreCase("prod")) {
				startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
			}
		} else { // For jenkins job
			String jenkinsRunnerFiles = MRScenario.runnerFiles;
			if (MRScenario.environment.equalsIgnoreCase("digital-uatv2")
					|| MRScenario.environment.equalsIgnoreCase("stage")
					|| MRScenario.environment.equalsIgnoreCase("offline-stage")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
							startNewMobile(AARP_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(AARP_ACQISITION_PAGE_URL);
					}
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER")) {
						if (MRScenario.environment.equalsIgnoreCase("digital-uatv2"))
							startNewMobile(UMS_ACQISITION_PAGE_URL.replace("www.", ""));
						else
							startNewMobile(UMS_ACQISITION_PAGE_URL);
					}
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("offline")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_OFFLINE_PAGE_URL);
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_OFFLINE_PAGE_URL);
				}
			}
			if (MRScenario.environment.equalsIgnoreCase("prod")) {
				for (String rname : jenkinsRunnerFiles.split(",")) {
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("ULAYER"))
						startNewMobile(AARP_ACQISITION_PROD_PAGE_URL);
					if (rname.toUpperCase().contains("PLANRECOMMENDATIONENGINE")
							&& rname.toUpperCase().contains("BLAYER"))
						startNewMobile(UMS_ACQISITION_PROD_PAGE_URL);
				}
			}
		}
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());
	}

	public void fixPrivateConnectionMobile() {
		try {
			// String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText()
					.contains("Your connection is not private")) {
				driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				driver.findElement(By.cssSelector("a#proceed-link")).click();
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}

	/**
	 * @author Rathulya
	 * This method is used to open the URL on the mobile device
	 */
	public void openMobileURL() {
		startNewMobile(AARP_ACQISITION_PAGE_URL);
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());
	}

	
	/**
	 * @author Rathulya
	 * This method is used to navigate to the page/URL passed from the feature file examples
	 * @param page
	 * @return
	 */
	public AcquisitionHomePageMobile navigateToPage(String page) {
		String pageURL = driver.getCurrentUrl() + page;
		System.out.println("==pageURL==" + pageURL);
		driver.navigate().to(pageURL);
		return null;
	}
	
	public void navigateToPath(String page) {
		String pageURL = driver.getCurrentUrl() + page;
		System.out.println("==pageURL==" + pageURL);
		driver.navigate().to(pageURL);
		
	}

	public AcquisitionHomePageMobile validateCallSamOnTablet() throws InterruptedException {
		boolean present;
		try {
			validateNew(callsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public AcquisitionHomePageMobile validateCallSamContentOnTablet() throws InterruptedException {
		Actions action = new Actions(driver);
		// WebElement element = callsam;
		action.moveToElement(callsam).perform();
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");

		if (CallSam.equalsIgnoreCase(toolTipText)) {
			System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println(
					"No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
		return null;
	}

	public AcquisitionHomePageMobile validateCallpopupOnTablet() throws InterruptedException {
		boolean present;
		callsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");
		driver.switchTo().activeElement();
		// System.out.println(CallSamTFN.getText());
		String toolTipText = callSamPopupTitle.getText();
		try {
			validateNew(callSamPopup);
			}
			catch (NoSuchElementException e) {
				System.out.println("Call popup not displayed");
			}
		CallSamTFNClose.click();
		present = validateNew(callsam);
		if (present && (CallSamPopupTitle.equalsIgnoreCase(toolTipText))) {
			System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}

	public AcquisitionHomePageMobile validateChatSamOnTablet() throws InterruptedException {
		boolean present;
		try {
			validateNew(chatsam);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		if (present) {
			System.out.println("@@@@@@@@@ Able to find Chat widget @@@@@@@@@");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println("@@@@@@@@@ No Chat widget @@@@@@@@@");
		return null;
	}

	public AcquisitionHomePageMobile validateChatSamContentOnTablet() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(chatsam).perform();
		String toolTipText = chatSamTooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");

		if (ChatSam.equalsIgnoreCase(toolTipText)) {
			System.out.println(
					"Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
			return new AcquisitionHomePageMobile(driver);
		} else
			System.out.println(
					"No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
		return null;
	}

	public AcquisitionHomePageMobile verifyChatpopupOnTablet() {
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");
		return null;
	}

}
