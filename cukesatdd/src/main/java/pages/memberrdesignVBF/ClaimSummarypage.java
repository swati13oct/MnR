package pages.memberrdesignVBF;

import java.util.List;

import org.openqa.selenium.By;
/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ClaimSummarypage extends UhcDriver {

	@FindBy(css = ".claim-results")
	private WebElement ClaimsSummaryPage;

	@FindBy(xpath = "//div[@class='medical-claims']//h2[@ng-bind-html='planName']/parent::div//*[@id='document-date']//option[contains(@value,'24 months')]")
	private WebElement last24months;

	@FindBy(xpath = "//select[@id='fed-document-date' and not(contains(@ng-hide,'todate'))]")
	private WebElement viewClaimsFrom;

	@FindBy(xpath = "//select[@id='document-date' and contains(@ng-hide,'todate')]")
	private WebElement viewClaimsFromShip;

	@FindBy(id = "medical")
	private WebElement claimsTableMedical;

	@FindBy(id = "claim-type")
	private WebElement claimsType;

	@FindBy(id = "prescriptionDrug")
	private WebElement claimsTablePrescriptionDrug;

	@FindBy(id = "ship")
	private WebElement claimsTableSHIP;

	@FindBy(xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//span[text()='Medical EOB']/parent::a[contains(@class,'btn btn--secondary')]")
	private WebElement medicalEobText;

	@FindBy(xpath = "//div[@class='summaryParsys parsys']/div/div[not (contains(@class,'ng-hide'))][1]//p[text()='Prescription Drug EOB']/following::a[contains(@class,'btn btn--secondary')][1]")
	private WebElement PrescriptionEobText;

	@FindBy(xpath = "//span[text()='Ship EOB']/parent::a")
	private WebElement ShipClaimsEobText;

	@FindBy(className = "downloadLink")
	private WebElement downloadmydatabutton;

	@FindBy(id = "siteleaving-popup-overlay")
	private WebElement proceedToDownloadPopUp;

	@FindBy(id = "cancelbtn")
	private WebElement cancelButtonDownloadPopUp;

	@FindBy(xpath = "//div[@class='claim-results']//table[not (contains(@class,'ng-hide'))]//tbody//tr[2]//a[text()='MORE INFO']")
	private WebElement claimstablemoreinfolink;

	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	private List<WebElement> medicalTableRow;

	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))]")
	private List<WebElement> shipTableRow;

	@FindBy(xpath = "//table[@id='medical']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='medical']/tbody/tr/th/p[contains(text(),'Provider Name')]/parent::th/preceding-sibling::th)+1]")
	private WebElement providerNameValue;

	@FindBy(xpath = "//table[@id='ship']/tbody/tr[2]/td[not (contains(@class,'hidden-lg'))][count(//table[@id='ship']/tbody/tr/th/p[text() ='Provider']/parent::th/preceding-sibling::th)+1]")
	private WebElement shipProviderNameValue;

	@FindBy(xpath = "//table[@id='prescriptionDrug']/tbody/tr[2]/td[not (contains(@class,'ng-hide'))][not (contains(@class,'hidden-lg'))]")
	private List<WebElement> drugTableRow;

	public ClaimSummarypage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		checkModelPopup(driver);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		try {
			if (CommonStepDefinition.getMemberAttributeMap().get("ClaimSystem").equalsIgnoreCase("SHIPCLAIMS")) {
				System.out.println("Claim System - Ship");
				CommonUtility.waitForPageLoadNew(driver, viewClaimsFromShip, 60);

			} else {
				CommonUtility.waitForPageLoadNew(driver, viewClaimsFrom, 60);
			}
		} catch (NullPointerException excption) {
			System.out.println("!!!ClaimsSystem not specified!!!");
		} catch (ClassCastException exception) {
			Assert.fail("ClaimSystem is of an inappropriate type");
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	/***
	 * 
	 * @param domain
	 * @param plantype
	 * @return
	 */
	public boolean validateEobfordifferentDomainType(String domain, String plantype) {

		if (domain.equals("COSMOS") && plantype.equals("MAPD")) {
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "
					+ (medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed()));
			return medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed();

		} else if (domain.equals("NICE") && plantype.equals("MAPD")) {
			System.out.println(
					"for MAPD NICE prescription drug EOB's are displayed ===>" + (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		} else if ((domain.equals("COSMOS") && plantype.equals("MA"))) {
			System.out.println("for MA medical Eob is diplayed ====>" + (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		} else if ((domain.equals("NICE") && plantype.equals("MA"))) {
			System.out.println("Medical EOB is not Displayed for MA NICE member");
			return true;
		}
		// SHIP CLAIMS EOB
		else if ((domain.equals("NA") && plantype.equals("SHIP"))) {
			System.out.println("for SHIP Eob is diplayed ====>" + (ShipClaimsEobText.isDisplayed()));
			return ShipClaimsEobText.isDisplayed();

		} else {
			System.out.println(
					"for PDP prescription drug EOB's are diaplayed ====> " + (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();

		}

	}

	/***
	 * 
	 * @param planType
	 * @param claimPeriod
	 */
	public void searchClaimsByTimePeriod(String planType, String claimPeriod, String claimSystem) {

		if (planType.contains("SHIP")) {

			last24months = driver.findElement(By.xpath(
					"//div[@class='medical-claims shipCompSection']//div//*[@id='document-date']//option[contains(@value,'24 months')]"));
			Select dateDropdown = new Select(viewClaimsFromShip);
			dateDropdown.selectByVisibleText(claimPeriod);
		} else {
			if(validate(claimsType)){
				Select claimTypeDropdown = new Select(claimsType);
				if (claimSystem.equalsIgnoreCase("RxCLAIMS")) {
					claimTypeDropdown.selectByValue("drug");
				} else {
					claimTypeDropdown.selectByValue("medical");
				}
			}
			Select dateDropdown = new Select(viewClaimsFrom);
			dateDropdown.selectByVisibleText(claimPeriod);
		}

		if (loadingImages.size() > 0) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTable() {
		CommonUtility.waitForPageLoadNew(driver, ClaimsSummaryPage, 60);
		scrollToView(ClaimsSummaryPage);
		if (claimsTableMedical.isDisplayed() || claimsTablePrescriptionDrug.isDisplayed()
				|| claimsTableSHIP.isDisplayed()) {
			System.out.println("!!!!!!!!! Able to find the claims table !!!!!!!!!");
			int counter = 0;
			if (claimsTableMedical.isDisplayed()) {

				int columnSize = medicalTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = medicalTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(providerNameValue);
			} else if (claimsTablePrescriptionDrug.isDisplayed()) {
				int columnSize = drugTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = drugTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
			} else if (claimsTableSHIP.isDisplayed()) {

				int columnSize = shipTableRow.size();
				for (int columnNum = 1; columnNum < columnSize; columnNum++) {
					String columnActualText = shipTableRow.get(columnNum).getText();
					if (!columnActualText.isEmpty())
						counter++;
				}
				Assert.assertTrue("Claims table gets displayed", counter > 0);
				validateNew(shipProviderNameValue);
			}
		}else{
			System.out.println("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
			Assert.fail("!!!!!!!!! NOT Able to find the claim table !!!!!!!!!");
			
		}
	}

	/***
	 * 
	 */
	public void validateDownloadMyData() {
		scrollToView(downloadmydatabutton);
		CommonUtility.waitForPageLoadNew(driver, downloadmydatabutton, 60);
		if (downloadmydatabutton.isDisplayed()) {
			downloadmydatabutton.click();

			waitforElementNew(proceedToDownloadPopUp);
			System.out.println("Proceed button is displayed ===>" + (proceedToDownloadPopUp.isDisplayed()));
			validateNew(cancelButtonDownloadPopUp);
			cancelButtonDownloadPopUp.click();
		} else {
			System.out.println("Downlaod my data button is not displayed ");

		}
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public pages.memberrdesignVBF.ClaimDetailsPage navigateToClaimDetailsPage() throws InterruptedException {
		scrollToView(claimstablemoreinfolink);
		jsClickNew(claimstablemoreinfolink);
		int counter = 0;
		do {
			if (counter <= 12)
				Thread.sleep(5000);
			else
				return null;
			counter++;
		} while (!(driver.getCurrentUrl().contains("/details")));
		if (driver.getCurrentUrl().contains("/details")) {
			return new pages.memberrdesignVBF.ClaimDetailsPage(driver);

		}
		return null;
	}

}
