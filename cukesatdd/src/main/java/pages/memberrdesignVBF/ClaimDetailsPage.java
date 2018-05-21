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

	@FindBy(id = "providerName")
	public WebElement providerName;

	@FindBy(id = "claimDynamicNum")
	public WebElement claimNumber;
	
	
	@FindBy(xpath = "//div[@class='claimDetTableMainSection']//div[@class='card-body']//div/p[contains(text(),'$')]")
	public List<WebElement> claimTableValues;
	
	public ClaimDetailsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//validateNew(claimDetailPageHeader);
		validateNew(providerName);
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
	     Assert.assertTrue("claim number exists",true);
	    }
	    else{
	     throw new IllegalArgumentException("Invalid String");
	    }

	}
	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTableInDetailsPage() {
		CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 40);
		Assert.assertTrue(claimDetTableMainSection.isDisplayed());
		int columSize = claimTableValues.size();
		for(int columnNum = 1; columnNum < columSize; columnNum++ ){
		String input = claimTableValues.get(columnNum).getText();
	     Pattern pattern = Pattern.compile("^\\$\\d+\\.\\d{2}$");
	    if (pattern.matcher(input).matches()) {
	     Assert.assertTrue("value exists in column - "+columnNum ,true);
	    }
	    else{
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
