package pages.memberrdesignVBF;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

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
		CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 40);
		Assert.assertTrue(claimDetTableMainSection.isDisplayed());

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
