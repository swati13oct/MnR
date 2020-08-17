package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrepareForNextYearTimelineIndividual extends PrepareForNextYearBase {

	public PrepareForNextYearTimelineIndividual(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}

	/** 
	 * GROUP user has no timeline box
	 * @return
	 */
	public List<String> validateNoTimeLineBoxContent() {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		note.add("\tValidate Timeline...");
		String targetItem="NO Time line section";
		WebElement targetElement=tl_section;
		note.addAll(validateDontHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		/* tbd 
		targetItem="NO Time line box header";
		targetElement=tl_sectionHeader;
		Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);
		*/
		return note;
	}
	
	public List<String> validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3, boolean expNoBlue_t4, boolean expNoBlue_t5) {
		checkModelPopup(driver,5);
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		note.add("\tValidate Timeline...");
		String targetItem="Time line section";
		WebElement targetElement=tl_section;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		/* tbd 
		targetItem="Time line box header";
		targetElement=tl_sectionHeader;
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(tbd_tl_sectionHeader));
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);
		*/

		//note: milestone1 - Sept 15 ----------------------------------
		String dateStr="September 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone1Line_ind;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone1Dot_noBlue_ind;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone1Dot_blue_ind;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone1Date_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone1Date;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);


		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone1Text_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone1Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		String targetActText=targetElement.getText();
		String targetExpText="Your Annual Notice of Changes and plan documents for next year will start to be available.";
		Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
				+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);

		//note: milestone2 - Oct 1 ----------------------------------
		dateStr="October 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone2Line_ind;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone2Dot_noBlue_ind;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone2Dot_blue_ind;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone2Date_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone2Date;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone2Text_ind;
		//TODO - remove the tbd one eventually
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(tbd_tl_milestone2Text));
		//targetActText=targetElement.getText();
		//targetExpText="You'll be able to compare next year's plan with your current plan to find out how your coverage may change.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);


		//note: milestone3 - Oct 15 ----------------------------------
		dateStr="October 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone3Line_ind;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone3Dot_noBlue_ind;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone3Dot_blue_ind;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone3Date_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone3Date;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone3Text_ind;
		//TODO - remove the tbd one eventually
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(tbd_tl_milestone3Text));
		//targetActText=targetElement.getText();
		//targetExpText="If your needs have changed and you want a different plan for next year, you can switch to a new plan.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);


		//note: milestone4 - Dec 7 ----------------------------------
		dateStr="December 7";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone4Line_ind;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone4Dot_noBlue_ind;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone4Dot_blue_ind;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone4Date_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone4Date;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone4Text_ind;
		//TODO - remove the tbd one eventually
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(tbd_tl_milestone4Text));
		//targetActText=targetElement.getText();
		//targetExpText="This is the last day you can join a new plan for next year.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);


		//note: milestone5 - Jan 1 ----------------------------------
		dateStr="January 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone5Line_ind;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone5Dot_noBlue_ind;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone5Dot_blue_ind;
		}
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone5Date_ind;
		//tbd if (MRScenario.environment.equalsIgnoreCase("stage")) 
		//tbd 	targetElement=tbd_tl_milestone5Date;
		note.addAll(validateHaveItem(targetItem, targetElement));
		//tbd Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//tbd note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone5Text_ind;
		//TODO - remove the tbd one eventually
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement) || noWaitValidate(tbd_tl_milestone5Text));
		//targetActText=targetElement.getText();
		//targetExpText="Your 2021 plan coverage starts today.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);
		return note;
	}
	

}