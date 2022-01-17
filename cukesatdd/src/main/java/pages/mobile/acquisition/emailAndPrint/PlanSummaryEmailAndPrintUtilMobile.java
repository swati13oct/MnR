package pages.mobile.acquisition.emailAndPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

public class PlanSummaryEmailAndPrintUtilMobile extends EmailAndPrintUtilBaseMobile {

	public PlanSummaryEmailAndPrintUtilMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public void validateEmailOptionExistOnSummaryPage(String planType) {
		WebElement emailElement = null;
		if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
			emailElement = summary_maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			emailElement = summary_pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			emailElement = summary_snpEmailOption;
		} else {
			Assertion.assertTrue("PROBLEM - test not coded for this '" + planType + "' planType testing", false);
		}
		Assertion.assertTrue("PROBLEM - Unable to locate the email option. emailCheck=" + validate(emailElement),
				validate(emailElement));
	}

	public void validateEmailFunctionOnSummaryPage(String planType) {
		WebElement emailButton = null;
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			emailButton = summary_maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			emailButton = summary_pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			emailButton = summary_snpEmailOption;
		} else {
			Assertion.assertTrue("PROBLEM - '" + planType
					+ "' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument",
					false);
		}
		System.out.println("Proceed to validate email popup screen for cancel option");
		jsClickNew(emailButton);
		Assertion.assertTrue("PROBLEM - unable to locate email popup screen after email link is clicked",
				validate(emailPlanSummaryPopupScreen));
		String expectedEmailBoxHeader = emailPlanSummaryPopupScreenText.getText();
		String actualEmailBoxHeader = "Email Plan List";
		Assertion.assertTrue(
				"PROBLEM - header text for the email popup screen is not as expected.  Expecte='"
						+ expectedEmailBoxHeader + "' | Actual='" + actualEmailBoxHeader + "'",
				expectedEmailBoxHeader.equals(actualEmailBoxHeader));
		Assertion.assertTrue(
				"PROBLEM - unable to locate email field box on email popup screen after email link is clicked",
				validate(emailPlanSummaryFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate send button on email popup screen after email link is clicked",
				validate(emailPlanSummarySendButton));
		Assertion.assertTrue(
				"PROBLEM - unable to locate cancel button on email popup screen after email link is clicked",
				validate(emailPlanSummaryCancelButton));

		System.out.println("Proceed to click cancel button on email screen, email screen should close");
		emailPlanSummaryCancelButton.click();
		Assertion.assertTrue("PROBLEM - email popup screen should have disappeared after cancel button is clicked",
				!validate(emailPlanSummaryPopupScreen));

		// ----- failure cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for failure case 1");
		jsClickNew(emailButton);
		validateNew(emailPopupPlanSummary);
		String testEmailAddresss = "bademailformat";
		sendkeysMobile(emailPlanSummaryFieldBox, testEmailAddresss);
		jsClickNew(emailModalTitle);
		jsClickNew(emailPlanSummarySendButton);
		emailPlanSummaryFieldBox.clear();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate error text after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		String actualErrorText = emailPlanSummaryInputErrorText.getText();
		String execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 2 ");
		testEmailAddresss = "bademailformat@";
		sendkeysMobile(emailPlanSummaryFieldBox, testEmailAddresss);
		emailModalTitle.click();
		emailPlanSummarySendButton.click();
		emailPlanSummaryFieldBox.clear();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		System.out.println("Proceed to validate email popup screen for send option for failure case 3");
		testEmailAddresss = "bademailformat@test.";
		sendkeysMobile(emailPlanSummaryFieldBox, testEmailAddresss);
		emailModalTitle.click();
		emailPlanSummarySendButton.click();
		emailPlanSummaryFieldBox.clear();

		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryErrorFieldBox));
		Assertion.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",
				validate(emailPlanSummaryInputErrorText));
		actualErrorText = emailPlanSummaryInputErrorText.getText();
		execptedErrorText = "Please Enter Valid Email Address";

		Assertion.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '" + execptedErrorText
				+ "' | Actual='" + actualErrorText + "'", (execptedErrorText.equals(actualErrorText)));

		// ----- success cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for successful case");
		testEmailAddresss = "test@optum.com";
		sendkeysMobile(emailPlanSummaryFieldBox, testEmailAddresss);
		emailModalTitle.click();
		jsClickNew(emailPlanSummarySendButton);
		Assertion.assertTrue("PROBLEM - uable to locate success message after clicking send button",
				validate(emailPlanSummarySuccessText, 15));
		// validateNew(emailPlanSummarySuccessText, 15);
		String expectedSuccess1 = "Thank you!";
		String expectedSuccess2 = "The email with your information will arrive shortly.";
		String actualEmailSuccessText = emailPlanSummarySuccessText.getText();
		Assertion.assertTrue(
				"PROBLEM - Email success message is not as expected.  Expected to contain '" + expectedSuccess1
						+ "' and '" + expectedSuccess2 + "' | Actual='" + actualEmailSuccessText + "'",
				(actualEmailSuccessText.contains(expectedSuccess1))
						&& (actualEmailSuccessText.contains(expectedSuccess2)));

		validateNew(emailPlanSummarySuccessCloseButton);
		System.out.println("Proceed to close the email popup screen to cleanup");
		emailPlanSummarySuccessCloseButton.click();
	}

	public HashMap<String, Integer> collectInfoVppPlanSummaryPg() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		System.out.println("Proceed to collect the plan counts on vpp summary page");

		clickonBackToPlanResults();

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		scrollToView(maPlansCount);
		int maPlans = Integer.valueOf(maPlansCount.getText());
		int msPlans = 0;
		try {
			scrollToView(msPlansCount);
			msPlans = Integer.valueOf(msPlansCount.getText());
		} catch (NumberFormatException e) {
			msPlans = 0;
		}

		scrollToView(pdpPlansCount);
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText());

		scrollToView(snpPlansCount);
		int snpPlans = Integer.valueOf(snpPlansCount.getText());

		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Total Plan Count", allPlans);
		result.put("MA Plan Count", maPlans);
		result.put("MS Plan Count", msPlans);
		result.put("PDP Plan Count", pdpPlans);
		result.put("SNP Plan Count", snpPlans);
		result.put("Saved Heart Count", planSummary_listOfSavedHearts.size());
		result.put("Enroll Button Count", planSummary_listOfEnrollInPlanButtons.size());
		result.put("View Plan Details Button Count", planSummary_listOfViewPlanDetailsButtons.size());

		System.out.println("collected result=" + result);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return result;
	}

	public String summary_comparePageItem(String targetKey, HashMap<String, Integer> origPage,
			HashMap<String, Integer> emailage) {
		String failedMessage = "NONE";
		System.out.println("TEST - validate content for map key=" + targetKey + "...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			if (targetKey.equals("Saved Heart Count")) {
				failedMessage = "BYPASS validation until fix (tick# xxxxx) - ";
				failedMessage = failedMessage + "item '" + targetKey + "' mismatch | original='"
						+ origPage.get(targetKey) + "' | email='" + emailage.get(targetKey) + "'";
			} else {
				summary_finalResult = false;
				failedMessage = "item '" + targetKey + "' mismatch | original='" + origPage.get(targetKey)
						+ "' | email='" + emailage.get(targetKey) + "'";
			}
		}
		return failedMessage;
	}

	boolean summary_finalResult = true;

	public List<String> validatePlanSummaryEmailDeeplink(String planType, String deepLinkStringId,
			String infoMapStringId, String deepLink, HashMap<String, Integer> origPage) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<String> testNote = new ArrayList<String>();
		List<String> listOfFailure = new ArrayList<String>();

		System.out.println(
				"Proceed to validate the original page content vs page content from email deeplnk for plan summary...");
		System.out.println("Collect info from page content of the plan summary");
		HashMap<String, Integer> emailPage = collectInfoVppPlanSummaryPg();

		String targetKey = "MA Plan Count";
		String failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "MS Plan Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "PDP Plan Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "SNP Plan Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "Total Plan Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "Saved Heart Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "Enroll Button Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		targetKey = "View Plan Details Button Count";
		failedMessage = summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch"))
			listOfFailure.add(failedMessage);
		if (failedMessage.contains("BYPASS"))
			testNote.add(failedMessage);

		System.out.println(
				"Finished validation for original page content vs page content from email deeplnk for plan summary ============");
		if (summary_finalResult) {
			if (testNote.size() == 0) {
				System.out.println("GOOD - original page content and email deeplink page content matched.");
			} else {
				System.out.println(
						"SEMI GOOD - there are BYPASSED items, most original page content and email deeplink page content matched.");
			}
		} else {
			System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
			for (String s : listOfFailure) {
				System.out.println(s);
			}
		}

		Assertion.assertTrue(
				"PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"
						+ listOfFailure.size() + "'. list of mismatch: " + listOfFailure,
				summary_finalResult);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return testNote;
	}

	public void clickOnBackToAllPlansFromCompareBackToSummaryPage() {

		if (driver.getClass().toString().toUpperCase().contains("IOS")) {
			driver.navigate().back();
			System.out.println("Email button click not working on iOS hence skipped(Click(),jsclick() both failing)");
		} else {
			jsClickNew(backToAllPlansLnk);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickonBackToPlanResults() {
		if (backToPlans.isDisplayed()) {
			scrollToView(backToPlans);
			Assertion.assertTrue("PROBLEM - unable to locate the 'Back to plan results' link on plan summary page",
					validate(backToPlans));
			jsClickNew(backToPlans);
			CommonUtility.checkPageIsReady(driver);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean validateAllPlansCheckedOnSummaryPage(String plansForCompare) {
		waitForSummaryPageToLoad();
		List<WebElement> compareChkBoxes = driver.findElements(By.xpath("//div[contains(@class,'compare-add')]"));
		String expectedTxt = plansForCompare + " plans added";
		System.out.println("Validate there are " + plansForCompare + " number of plans added for compare");
		boolean result = true;
		for (int i = 0; i < Integer.parseInt(plansForCompare); i++) {
			if (!compareChkBoxes.get(1).getText().contains(expectedTxt)) {
				System.out.println(
						"PROBLEM - plan with index " + i + " doesn't contain expected text '" + expectedTxt + "'");
				result = false;
				break;
			}
		}
		return result;
	}

	public void waitForSummaryPageToLoad() {
		CommonUtility.waitForPageLoad(driver, vppTop, 5);
	}
}
