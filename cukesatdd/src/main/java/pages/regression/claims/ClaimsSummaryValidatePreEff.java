package pages.regression.claims;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * Functionality : validations for pre-effective members for claims summary page
 */
public class ClaimsSummaryValidatePreEff extends ClaimsSummaryBase{

	public ClaimsSummaryValidatePreEff(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/** 
	 * Validate Claims Support in Need Help section not display for SHIP Pre-effective member
	 * @throws InterruptedException
	 */
	public void verifyClaimSuppInNeedHelpNotDispForShipPreEffMem() throws InterruptedException {
		System.out.println("Now checking for Claim Support Header in Need Help Section for SHIP Pre-effective members");
		try {
			preEffClaimsSuppHeader.isDisplayed();
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support in Need Help Sectionr for SHIP Pre-effective members was displayed, "
					+ "Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was NOT displayed, "
					+ "Test step is passed due to it");
		}
	}

	/**
	 * Validate Claims Support Number in Need Help section not display for SHIP pre-effective member 
	 * @throws InterruptedException
	 */
	public void verifyClaimSuppNumNotDisForShipPreEffMem() throws InterruptedException {
		System.out.println("Now checking for Claim Support Number for SHIP Pre-effective members");
		try {
			preEffClaimsSuppNum.isDisplayed();                            	  
			System.out.println("Claim Support Number for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Number for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Number for SHIP Pre-effective members was NOT displayed, "
					+ "Test step is passed due to it");
		}
	}

	/**
	 * Validate message display on claims summary page for pre-effective member
	 * @throws InterruptedException
	 */
	public void verifyCorrectMsgForPreEffMem() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, preEffMsg, 5);
		System.out.println("Now checking for message on Claims Page for Pre-effective members");
		System.out.println("The message displayed on screen is "+preEffMsg.getText());
		String expText="When your plan starts,";
		Assert.assertTrue("PROBLEM - Correct message is not displayed. "
				+ "Expected msg contains '"+expText+"' | Actual='"+preEffMsg.getText()+"'", 
				preEffMsg.getText().contains(expText));
		System.out.println("Assert for preeffective message on claims page was passed");
	}

	/**
	 * Validate tech support number for pre-effective member testing
	 * @param technicalPhNo
	 * @throws InterruptedException
	 */
	public void verifyCorrectTechSuppNumForPreEffMem(String technicalPhNo) throws InterruptedException {
		System.out.println("Now checking for Tech Support Number for Pre-effective members on claims page");
		System.out.println("The Tech Support phone number displayed on screen is "+preEffTechSuppNum.getText());
		Assert.assertEquals("PROBLEM - not getting expected phone#.  "
				+ "Expected='"+technicalPhNo+"' | Actual='"+preEffTechSuppNum.getText()+"'", 
				preEffTechSuppNum.getText(),technicalPhNo);
		System.out.println("Assert for correct Tech Suppport Phone Number on claims summary page was passed");
	}

	/** 
	 * Validate payment table display on claims summary page for pre-effective member 
	 * @throws InterruptedException
	 */
	public void verifyPymtTbDispForPreEffMem() throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate Payment tab",pymtTabTopMenu.isDisplayed());
		System.out.println("Premium Payment tab was displayed on Claims summary page");
	}
	
	/**
	 * Validate that Claims Summary Sub Navigation Link under Claims is NOT displayed for pre-effective member
	 */
	public void verifyClaimsSummSubNavNotDispForPreEffMem() throws InterruptedException {
		System.out.println("Now checking for claims summary sub navigation of Claims");
		Dimension size = claimsTabTopMenu.getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0) {
			System.out.println("Claims Summary Sub Navigation Link under Claims was NOT displayed");
		} else {
			System.out.println("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");
			Assert.fail("Claims Summary Sub Navigation Link under Claims was displayed, Test step is failed due to it");	
		}
	}	

	/**
	 * Validate EOB sub navigation suppressed on claims summary page for pre-effective member
	 * @throws InterruptedException
	 */
	public void verifyExpOfBenSubNavNotDispForPreEffMem() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, eob_claims, 5);
		System.out.println("Now checking for Explanation of benefits sub navigation of Claims");

		Dimension size = eob_claims.getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		Assert.assertTrue("Explanation of Benefits Sub Navigation Link under Claims was displayed, Test step is failed due to it",(height == 0));	
		System.out.println("Explanation of Benefits Sub Navigation Link under Claims was NOT displayed");
	}	
}
