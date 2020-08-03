package pages.regression.planDocumentsAndResources;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import acceptancetests.util.CommonUtility;

public class PlanDocumentsAndResourcesNH extends PlanDocumentsAndResourcesBase  {
	
	public PlanDocumentsAndResourcesNH(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * Validate each section in Need Help section
	 * @param planType
	 */
	public String validateSectionInNeedHelp(String planType, String memberType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					planDocValidate(needHelp_SectionHeader));

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
					planDocValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					planDocValidate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReadyNew(driver);
			//note: handle combo tab
			//note: if specific scenario target combo user then flag if no combo, else just select right plan and move on
			if (memberType.toLowerCase().contains("combo")) { 
				System.out.println("This test is for combo plans, select the tab accordingly");
				goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
				goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
			} else {
				boolean flagNonCombo=false; //note: if user has combo then select the right plan
				goToSpecificComboTab(planType, flagNonCombo); 
				goToSpecificComboTab(planType, flagNonCombo); 
			}
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+" | New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			//note: handle combo tab
			//note: if specific scenario target combo user then flag if no combo, else just select right plan and move on
			if (memberType.toLowerCase().contains("combo")) {
				driver.get(originalUrl);
				goToSpecificComboTab(planType); 
			} else {
				driver.navigate().back();
				boolean flagNonCombo=false; //note: if user has combo then select the right plan
				goToSpecificComboTab(planType, flagNonCombo); 
			}
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					planDocValidate(needHelp_SectionHeader));

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
				planDocValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",
				planDocValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",
				planDocValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",
				planDocValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
				planDocValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
					planDocValidate(hrsOperationElement2));
		}
	}
}