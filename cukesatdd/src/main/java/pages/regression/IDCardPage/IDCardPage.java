/**
 * 
 */
package pages.regression.IDCardPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author bnaveen4
 *
 */
public class IDCardPage extends UhcDriver{

	@FindBy(id="modal-header")
	private WebElement heading;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;
	
	@FindBy(css="ul.coverage-details li:first-child dl>dd")
	private WebElement planName;
	
	@FindBy(css="ul.coverage-details li:nth-child(2) dd")
	private WebElement id;
	
	@FindBy(css=".member-name.ng-binding")
	private WebElement name;
	
	@FindBy(css=".member-type-dob.ng-binding")
	private WebElement dateOfBirth;
	
	@FindBy(css=".coverage-value.ng-binding")
	private WebElement start;
	
	@FindBy(xpath="//div[@translate='COVERAGE_STATUS_ACTIVE']")
	private WebElement status;
	
	@FindBy(css="button.modal-close-btn")
	private WebElement closeIDcard;
	
	@FindBy(css=".card-actions>button")
	private WebElement printIDCard;
	
	@FindBy(css=".inline-buttons>button")
	private WebElement btnViewBack;
	
	@FindBy(css=".inline-buttons>a")
	private WebElement mailIDCard;
	
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	
	public IDCardPage(WebDriver driver) {
		super(driver);
		try {
			Thread.sleep(8000);
			if (validate(iPerceptionPopUp)) {
	            iPerceptionPopUp.click();
	            System.out.println("iPerception Pop Up displayed");
			}
			PageFactory.initElements(driver, this);
			CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_30);
			openAndValidate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openAndValidate() {
		validate(heading);
	}

	/**
	 * This method is used to validate the all the fields on ID card page
	 * @param givenAttributes
	 */
	public void validateIDCardPage(DataTable givenAttributes){
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalPlan = memberAttributesMap.get("Medical Plan");
		String memberId = memberAttributesMap.get("Member Id");
		String memberName = memberAttributesMap.get("Member Name");
		String dob = memberAttributesMap.get("Scubscriber DOB");
		String covergaeStart = memberAttributesMap.get("Coverage Start");
		String coverageStatus = memberAttributesMap.get("Coverage Status");
		
		/**
		 * Validates the details of the member
		 */
		Assert.assertEquals(medicalPlan, planName.getText().trim());
		Assert.assertEquals(memberId, id.getText().trim());
		Assert.assertEquals(memberName, name.getText().trim());
		Assert.assertEquals(dob, dateOfBirth.getText().trim());
		Assert.assertEquals(covergaeStart, start.getText().trim());
		Assert.assertEquals(coverageStatus, status.getText().trim());
		
		/**
		 * Validate the links below the ID card
		 */
		Assert.assertEquals("MAIL ID CARD", mailIDCard.getText().trim());
		Assert.assertEquals("VIEW BACK", btnViewBack.getText().trim());
		Assert.assertEquals("PRINT ID CARD", printIDCard.getText().trim());
		
		closeIDcard.click();
	}
	
	public void validateCoverageStatus(String coverageStatus){
		Assert.assertEquals(coverageStatus, status.getText().trim());
	}
}
