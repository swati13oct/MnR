package pages.memberrdesignVBF;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ClaimDetailsPage extends UhcDriver {

	@FindBy(id = "claimDetailsHeaders")
	private WebElement claimDetailPageHeader;
	
	@FindBy(id = "claimDetailsHeader")
	private WebElement claimDetailPageHeaderShip;

	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;

	@FindBy(id = "shipPartBDetailsTable")
	public WebElement claimDetShipTableMainSection;

	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;

	@FindBy(id = "providerName")
	public WebElement providerName;

	@FindBy(id = "claimDynamicNum")
	public WebElement claimNumber;

	@FindBy(xpath = "//div[@class='claimDetTableMainSection']//div[@class='card-body']//div/p[contains(text(),'$')]")
	public List<WebElement> claimTableValues;

	@FindBy(xpath = "//div[@id='shipPartBDetailsTable']//div[@class='card-body']//div/p[contains(text(),'$')]")
	public List<WebElement> claimTableShipValues;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']//div[@class='col-md-2']/p[contains(text(),'$')]")
	public List<WebElement> shipClaimTotalValues;

	@FindBy(xpath = "//section[@id='cltotshippartb']//div[@class='card-body']")
	public WebElement ShipclaimstotalTable;

	public static String claimSystem;

	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {	
		claimSystem = CommonStepDefinition.getMemberAttributeMap().get("ClaimSystem");
		if (claimSystem.equalsIgnoreCase("COSMOSCLAIMS") || claimSystem.equalsIgnoreCase("NICECLAIMS")) {
			CommonUtility.waitForPageLoadNew(driver, claimDetailPageHeader, 60);
			validateNew(providerName);
		} else {
			CommonUtility.waitForPageLoadNew(driver, claimDetailPageHeaderShip, 60);
			Assert.assertTrue("Provider name not exists as claimType is SHIP", !providerName.isDisplayed());
		}
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsDetailsSection() {
		validateNew(claimNumber);
		String input = claimNumber.getText();
		Pattern pattern = Pattern.compile("^\\d+$");
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("claim number exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}

	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTableInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 60);
		Assert.assertTrue(claimDetTableMainSection.isDisplayed());
		int columSize = claimTableValues.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = claimTableValues.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^[-]?\\$\\d+.*\\.\\d{2}$");
			if (pattern.matcher(input).matches()) {
				Assert.assertTrue("value exists in column - " + columnNum, true);
			} else {
				throw new IllegalArgumentException("Invalid String");
			}
		}
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateShipClaimsTableInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimDetShipTableMainSection, 40);
		Assert.assertTrue(claimDetShipTableMainSection.isDisplayed());
		int columSize = claimTableShipValues.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = claimTableShipValues.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^\\$\\d+\\.\\d{2}$");
			if (pattern.matcher(input).matches()) {
				Assert.assertTrue("value exists in column - " + columnNum, true);
			} else {
				throw new IllegalArgumentException("Invalid String");
			}
		}
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateShipClaimsTotalInDetailsPage() {
		validateNew(ShipclaimstotalTable);
		int columSize = shipClaimTotalValues.size();
		for (int columnNum = 1; columnNum < columSize; columnNum++) {
			String input = shipClaimTotalValues.get(columnNum).getText();
			Pattern pattern = Pattern.compile("^\\$\\d+\\.\\d{2}$");
			if (pattern.matcher(input).matches()) {
				Assert.assertTrue("value exists in column - " + columnNum, true);
			} else {
				throw new IllegalArgumentException("Invalid String");
			}
		}
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTotalInDetailsPage() {
		validateNew(claimstotalTable);
		if (claimstotalTable.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
		}

	}

}
