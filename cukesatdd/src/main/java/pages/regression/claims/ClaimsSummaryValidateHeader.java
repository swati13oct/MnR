package pages.regression.claims;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Functionality : validation for header for claims summary page
 */
public class ClaimsSummaryValidateHeader extends ClaimsSummaryBase{

	public ClaimsSummaryValidateHeader (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 

	}

	/**
	 * Validate claims summary header section content
	 */
	public void validateHeaderSection(String planType, String memberType) {
		//note: validate page title
		String expPgTitle="Claims Summary";
		Assert.assertTrue("PROBLEM - not getting expected page title for claims summary page. "
				+ "Expected to contains="+expPgTitle+" | Actual="+driver.getTitle(), 
				driver.getTitle().contains(expPgTitle));
		System.out.println("The title of Claims page is-------->"+driver.getTitle());

		//note: validate header element
		String expPgHeadingTxt="Claims Summary";
		Assert.assertTrue("PROBLEM - unable to locate page header element on claims summary page", 
				claimsValidate(pgHeader));
		Assert.assertTrue("PROBLEM - not getting expected page header text on claims summary page. "
				+ "Expected="+expPgHeadingTxt+" | Actual="+pgHeader.getText(), 
				expPgHeadingTxt.equals(pgHeader.getText()));
		System.out.println("The header text-------->"+pgHeader.getText());

		if (planType.equalsIgnoreCase("SHIP")) {
			String expSubHeader="My Supplement Insurance Plan Claims";
			Assert.assertTrue("PROBLEM - unable to locate sub header element on claims summary page for SHIP user", 
					claimsValidate(ship_subPgHeader));
			Assert.assertTrue("PROBLEM - "+expSubHeader+"' label text is not as expected.  "
					+ "Expected="+expSubHeader+" | Actual="+ship_subPgHeader.getText(), 
					ship_subPgHeader.getText().equals(expSubHeader));

			//note: validate plan name element
			Assert.assertTrue("PROBLEM - unable to locate plan name element on claims summary page", claimsValidate(ship_planName));
			System.out.println("The Plan Name is ===>"+(ship_planName.getText()));

			//note: validate claims date range search dropdown options
			String expViewClaimsLblTxt="View Claims From:";
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLblTxt+"' label element on claims summary page", 
					claimsValidate(ship_viewClaimsFromLbl));
			Assert.assertTrue("PROBLEM - "+expViewClaimsLblTxt+"' label text is not as expected.  "
					+ "Expected="+expViewClaimsLblTxt+" | Actual="+ship_viewClaimsFromLbl.getText(), 
					ship_viewClaimsFromLbl.getText().equals(expViewClaimsLblTxt));
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLblTxt+"' dropdown element on claims summary page", 
					claimsValidate(ship_srchClaimsRngDropdown));

			System.out.println("Validating provider dropdown options for planType="+planType+" scenario...");
			//note: All Providers or more depends on if claims...validate it has >=1
			String expClaimTypLblTxt="From Provider:";
			List<String> expTypeOptionsList=new ArrayList<String>();
			expTypeOptionsList.add("All Providers");
			int expNumTypOpt=expTypeOptionsList.size();
			Select ship_claimTypeSelect = new Select(ship_claimsTypDropdown);
			Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  "
					+ "Expected='"+expTypeOptionsList.get(0)+"' | Actual='"+ship_claimTypeSelect.getFirstSelectedOption().getText()+"'", 
					(expTypeOptionsList.get(0)).equals(ship_claimTypeSelect.getFirstSelectedOption().getText()));
			Assert.assertTrue("PROBLEM - number of '"+expClaimTypLblTxt+"' drop down optons is not as expected.  "
					+ "Expected="+expNumTypOpt+" | Actual="+ship_claimTypeSelect.getOptions().size(), 
					ship_claimTypeSelect.getOptions().size()>=expNumTypOpt);
			System.out.println("Due to user data often changed, will not validate list of available providers from the drop down.  "
					+ "Will only printout the list of providers");
			for(int i=0;i<ship_claimTypeSelect.getOptions().size();i++){
				System.out.println("Located dropdown option =>"+ship_claimTypeSelect.getOptions().get(i).getText());
			} 	
			//note: validate 'review your claims' element exists
			Assert.assertTrue("PROBLEM - Unable to locate the 'Review your claims...' element", claimsValidate(ship_reviewClaimsTxt));
		} else {
			//note: validate plan name element
			Assert.assertTrue("PROBLEM - unable to locate plan name element on claims summary page", claimsValidate(planName));
			System.out.println("The Plan Name is ===>"+(planName.getText()));

			//note: validate claims date range search dropdown options
			String expViewClaimsLblTxt="View Claims From:";
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLblTxt+"' label element on claims summary page", 
					claimsValidate(viewClaimsFromLbl));
			Assert.assertTrue("PROBLEM - "+expViewClaimsLblTxt+"' label text is not as expected.  "
					+ "Expected="+expViewClaimsLblTxt+" | Actual="+viewClaimsFromLbl.getText(), 
					viewClaimsFromLbl.getText().equals(expViewClaimsLblTxt));
			Assert.assertTrue("PROBLEM - unable to locate '"+expViewClaimsLblTxt+"' dropdown element on claims summary page",
					claimsValidate(srchClaimsRngDropdown));

			List<String> expOptLs=new ArrayList<String>();
			expOptLs.add("Last 30 days");
			expOptLs.add("Last 90 days");
			expOptLs.add("Last 6 months");
			expOptLs.add("Last 12 months");
			expOptLs.add("Last 24 months");
			expOptLs.add("Custom search");
			Select RangeSelect = new Select(srchClaimsRngDropdown);
			Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  "
					+ "Expected="+expOptLs.get(1)+" | Actual="+RangeSelect.getFirstSelectedOption().getText(), 
					(expOptLs.get(1)).equals(RangeSelect.getFirstSelectedOption().getText()));
			System.out.println("Default selected option is  =>" +RangeSelect.getFirstSelectedOption().getText());
			int expNumOpt=6;
			Assert.assertTrue("PROBLEM - number of '"+expViewClaimsLblTxt+"' drop down optons is not as expected.  "
					+ "Expected="+expNumOpt+" | Actual="+RangeSelect.getOptions().size(), 
					RangeSelect.getOptions().size()==expNumOpt);
			for(int i=0;i<RangeSelect.getOptions().size();i++){
				Assert.assertTrue("PROBLEM - dropdown option value/order is not as expected.  "
						+ "Expected="+expOptLs.get(i)+" | Actual="+RangeSelect.getOptions().get(i).getText(), 
						(expOptLs.get(i)).equals(RangeSelect.getOptions().get(i).getText()));
				System.out.println("Located dropdown option =>"+RangeSelect.getOptions().get(i).getText());
			} 	

			//note: validate claims type search dropdown options
			String expClaimTypLblTxt="Claim Type:";
			Assert.assertTrue("PROBLEM - unable to '"+expClaimTypLblTxt+"' label element on claims summary page", 
					claimsValidate(claimsTypLbl));
			Assert.assertTrue("PROBLEM - "+expClaimTypLblTxt+"' label text is not as expected.  "
					+ "Expected="+expClaimTypLblTxt+" | Actual="+claimsTypLbl.getText(), 
					claimsTypLbl.getText().equals(expClaimTypLblTxt));

			System.out.println("Validating claimType dropdown options for planType="+planType+" scenario...");
			if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("SSUP")) { //note: only Medical
				Assert.assertTrue("PROBLEM - unable to locate 'Medical' for Claim Type field on claims summary page", 
						claimsValidate(claimsTypMedicalOnly));
			} else if (planType.equalsIgnoreCase("PDP")) { //note: only Prescription drug
				Assert.assertTrue("PROBLEM - unable to locate 'Prescription drug' for Claim Type field on claims summary page", 
						claimsValidate(claimsTypDrugOnly));
			} else { //note: both Medical and Prescription drug
				Assert.assertTrue("PROBLEM - unable to locate '"+expClaimTypLblTxt+"' dropdown element on claims summary page", 
						claimsValidate(claimsTypDropdown));
				List<String> expTypOptLs=new ArrayList<String>();
				expTypOptLs.add("Medical");
				expTypOptLs.add("Prescription drug");
				int expNumTypOpt=expTypOptLs.size();
				Select claimTypSel = new Select(claimsTypDropdown);
				Assert.assertTrue("PROBLEM - default search claims date range dropdown option is not as expected.  "
						+ "Expected='"+expTypOptLs.get(0)+"' | Actual='"+claimTypSel.getFirstSelectedOption().getText()+"'", 
						(expTypOptLs.get(0)).equals(claimTypSel.getFirstSelectedOption().getText()));
				Assert.assertTrue("PROBLEM - number of '"+expClaimTypLblTxt+"' drop down optons is not as expected.  "
						+ "Expected="+expNumTypOpt+" | Actual="+claimTypSel.getOptions().size(), 
						claimTypSel.getOptions().size()==expNumTypOpt);
				for(int i=0;i<claimTypSel.getOptions().size();i++) {
					Assert.assertTrue("PROBLEM - dropdown option value/order is not as expected.  "
							+ "Expected='"+expTypOptLs.get(i)+"' | Actual='"+claimTypSel.getOptions().get(i).getText()+"'", 
							(expTypOptLs.get(i)).equals(claimTypSel.getOptions().get(i).getText()));
					System.out.println("Located dropdown option =>"+claimTypSel.getOptions().get(i).getText());
				} 	
			}
			//note: validate 'review your claims' element exists
			Assert.assertTrue("PROBLEM - Unable to locate the 'Review your claims...' element", 
					claimsValidate(reviewClaimsTxt));
		}
	}	

	/**
	 * Validate 'Review your claims...' text from claims header section on claims summary page
	 */
	public void validateHeaderCopyText(String planType) {
		String expText="Review your claims search";
		WebElement testElement=fed_clamsSummCpTxt;
		if (planType.equalsIgnoreCase("SHIP")) 
			testElement=ship_clamsSummCpTxt;
		Assert.assertTrue("PROBLEM - 'Review your claims search' is not displaying as expected. "
				+ "Expect to contain '"+expText+"' | Actual text='"+testElement.getText()+"'", 
				testElement.getText().contains(expText));
	}
}
