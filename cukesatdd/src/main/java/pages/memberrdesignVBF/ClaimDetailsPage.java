package pages.memberrdesignVBF;

/**
 * 
 */
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

@SuppressWarnings("deprecation")
public class ClaimDetailsPage extends UhcDriver {

	@FindBy(id = "claimDetailsHeader")
	private WebElement claimDetailPageHeader;

	@FindBy(css = ".claimDetTableMainSection")
	public WebElement claimDetTableMainSection;

	@FindBy(css = ".claimsTotalTable")
	public WebElement claimstotalTable;

	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
	}

	@Override
	public void openAndValidate() {
		validateNew(claimDetailPageHeader);
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
