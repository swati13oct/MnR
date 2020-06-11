package pages.regression.needHelp;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/** methods used by Need Help section validation page */
public class NeedHelpPage extends NeedHelpWebElements  {

	public NeedHelpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	/**
	 * helper method to validate Need Help section content bases on input
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSection(String section, WebElement SectionElement, 
			WebElement imgElement, WebElement phoneElement, WebElement ttyElement, 
			WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",
				validate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",
				validate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",
				validate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",
				validate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
				validate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
					validate(hrsOperationElement2));
		}
	}

	
	/**
	 * Validate each section in Need Help section on claims summary page
	 * @param planType
	 */
	public String validateSectionInNeedHelp(String planType, String memberType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSection(validateSection, needHelp_TechSupp, 
					needHelp_TechSupp_img, needHelp_TechSupp_ph, 
					needHelp_TechSupp_tty, needHelp_TechSupp_wkdyHrs,
					needHelp_TechSupp_wkndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSection(validateSection, needHelp_GenQue, 
					needHelp_GenQue_img, needHelp_GenQue_ph, 
					needHelp_GenQue_tty, needHelp_GenQue_wkdyHrs,
					needHelp_GenQue_wkndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSection(validateSection, needHelp_ClaimsSupp, 
					needHelp_ClaimsSupp_img, needHelp_ClaimsSupp_ph, 
					needHelp_ClaimsSupp_tty, needHelp_ClaimsSupp_wkdyHrs,
					needHelp_ClaimsSupp_wkndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",
					validate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					validate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			if (memberType.toLowerCase().contains("combo")) {
				System.out.println("This test is for combo plans, select the tab accordingly");
				goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
				goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
			}
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+" | New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			if (memberType.toLowerCase().contains("combo")) {
				driver.get(originalUrl);
				goToSpecificComboTab(planType); 
			} else {
				driver.navigate().back();
			}
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSection(validateSection, needHelp_TechSupp, needHelp_TechSupp_img, 
					needHelp_TechSupp_ph, needHelp_TechSupp_tty, needHelp_TechSupp_wkdyHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSection(validateSection, needHelp_PlanSupp, needHelp_PlanSupp_img, 
					needHelp_PlanSupp_ph, needHelp_PlanSupp_tty, needHelp_PlanSupp_wkdyHrs, null);
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}

	/**
	 * Navigate to specific plan for combo user
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		WebElement tab=null;
		if (planType.equalsIgnoreCase("mapd")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(comboTab_MAPD));
			tab=comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("ship")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(comboTab_SHIP));
			tab=comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("pdp")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_PDP));
			tab=comboTab_PDP;
		} else if (planType.equalsIgnoreCase("ssup")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_SSUP));
			tab=comboTab_SSUP;
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
		tab.click();
	}


}