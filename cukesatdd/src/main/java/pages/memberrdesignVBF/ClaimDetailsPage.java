package pages.memberrdesignVBF;

/**
 * 
 */
import java.util.List;
import java.util.regex.Pattern;

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
	
	@FindBy(xpath = "//div[@class='claimDetTableMainSection']//div[@class='card-body']//div/p[contains(text(),'$')]")
	public List<WebElement> claimTableValues;
	
	@FindBy(xpath = "//*[@id='numDays1']/span[2]")
	private WebElement noclaims;
	
	
	@FindBy(xpath="//*[@id='claimDetailsHeaders']/p")
	private WebElement claimsheading;
	

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
	
			
			if(claimsheading.getText().contains("Details")){
				Assert.assertTrue("Claims Details Page",true);
			}else{
				if(noclaims.getText().contains("0")){
					Assert.assertTrue("There are no claims for this time period and therefore no table is there",true);
				}
				
			}
			/*CommonUtility.waitForPageLoadNew(driver, claimDetTableMainSection, 60);
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
			}*/
		
	
	}

	/***
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void validateClaimsTotalInDetailsPage() {
		if(noclaims.getText().contains("0")){
			Assert.assertTrue("There are no claims for this time period and therefore no table is there",true);
		}else{
			validateNew(claimstotalTable);
			if (claimstotalTable.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Claims Total is not present in Claims Details Page", false);
			}
		}

	}

}
