
package pages.acquisition.dceredesign;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class DCEStepHeader extends UhcDriver {

	@FindBy(xpath = "//*[contains(@class, 'uhc-steps__list')]")
	public WebElement StepHeader;

	@FindBy(xpath = "//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'get started')]")
	public WebElement StepHeader_Step1;

	@FindBy(xpath = "//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'build your drug list') or contains(@dtmname, 'edit your drug  list')]")
	public WebElement StepHeader_Step2;

	@FindBy(xpath = "//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'review drug costs') ]")
	public WebElement StepHeader_Step3;

	public DCEStepHeader(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		/*else
			checkModelPopup(driver, 10);*/
		validateNew(StepHeader);
		validateNew(StepHeader_Step1);
		validateNew(StepHeader_Step2);
		validateNew(StepHeader_Step3);
	}

	/**
	 * Step Header Flags as follows
	 * C - Current
	 * E - Enabled
	 * D - Disabled
	 * @param stepHeaderFlag
	 */
	public void validateStepHeader(String stepHeaderFlag) {
		String[] Flags = stepHeaderFlag.split(":");
		int i=0;
		for (String Flag : Flags) {
			System.out.println("Current Flag Being Validated --> "+Flags[i]+" ; for Step --> "+(i+1));

			if (Flag.equalsIgnoreCase("C")) {
				System.out.println("Validating for Flag C for Current tab for Step : "+(i+1));
				if (i == 0){
					WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'get started') and contains(@aria-current, 'true') and (@disabled)]"));
					validateNew(Step1_Current);
				}
				else if (i==1){
					WebElement Step2_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[(contains(@dtmname, 'build your drug list') or contains(@dtmname, 'edit your drug  list')) and contains(@aria-current, 'true') and (@disabled)]"));
					validateNew(Step2_Current);
				}
				else{
					WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'review drug costs') and contains(@aria-current, 'true') and (@disabled)]"));
					validateNew(Step1_Current);
				}
			}
			if (Flag.equalsIgnoreCase("E")) {
				System.out.println("Validating for Flag E for Enabled tab for Step : "+(i+1));
				if (i == 0){
					WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'get started') and not(@disabled)]"));
					validateNew(Step1_Current);
				}
				else if (i==1){
					WebElement Step2_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[(contains(@dtmname, 'build your drug list') or contains(@dtmname, 'edit your drug  list')) and not(@disabled)]"));
					validateNew(Step2_Current);
				}
				else{
					WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'review drug costs') and not(@disabled)]"));
					validateNew(Step1_Current);
				}
			}
			if (Flag.equalsIgnoreCase("D")) {
				System.out.println("Validating for Flag D for Disabled tab for Step : "+(i+1));
					if (i == 0){
						WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'get started') and contains(@disabled, '')]"));
						validateNew(Step1_Current);
					}
					else if (i==1){
						WebElement Step2_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[(contains(@dtmname, 'build your drug list') or contains(@dtmname, 'edit your drug  list')) and contains(@disabled, '')]"));
						validateNew(Step2_Current);
					}
					else{
						WebElement Step1_Current = driver.findElement(By.xpath("//*[contains(@class, 'uhc-steps__list')]//button[contains(@dtmname, 'review drug costs') and contains(@disabled, '')]"));
						validateNew(Step1_Current);
					}
			}
			i++;
		}
	}

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[(@id= 'search')]")
	public WebElement SearchBtn;

	public BuildYourDrugList ClickStep2_NavigateDrugListPage() {
		validateNew(StepHeader_Step2);
		jsClickNew(StepHeader_Step2);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		if (validateNew(EnterDrugNameTxt) && validateNew(SearchBtn)) {
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	@FindBy(xpath = "//*[contains(@id,'changePharmacyLink')]")
	public WebElement DrugDetails_ChangePharmacyLnk;

	public DrugDetailsPage ClickStep3_NavigateDrugDetailsPage() {
		validateNew(StepHeader_Step3);
		jsClickNew(StepHeader_Step3);
		waitForPageLoadSafari();
		threadsleep(2000);
		//CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 20);
		if(validateNew(DrugDetails_ChangePharmacyLnk))
		{
			return new DrugDetailsPage(driver);
		} else {
			Assertion.fail("Drug Details is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPage ClickStep3_NavigateDrugSummaryPage() {
		validateNew(StepHeader_Step3);
		jsClickNew(StepHeader_Step3);
		waitForPageLoadSafari();
		threadsleep(2000);
		CommonUtility.waitForPageLoadNew(driver, reviewDrugCostPageHeading, 20);
		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPage(driver);
		} else {
			Assertion.fail("Drug Summary Page is not loaded");
			return null;
		}
	}
}

