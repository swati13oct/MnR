package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.MRScenario;

public class PrepareForNextYearTimelineSar extends PrepareForNextYearBase {

	public PrepareForNextYearTimelineSar(WebDriver driver) {
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
		Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="NO Time line box header";
		targetElement=tl_sectionHeader;
		Assert.assertTrue("PROBLEM - SHOULD NOT be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);
		return note;
	}
	
	public List<String> validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3) {
		checkModelPopup(driver,2);
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		note.add("\tValidate Timeline...");
		String targetItem="Time line section";
		WebElement targetElement=tl_section;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line box header";
		targetElement=tl_sectionHeader;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		//note: milestone1 - Oct 1 ----------------------------------
		String dateStr="October 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone1Line_sar;
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
			targetElement=tl_milestone1Dot_noBlue_sar;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone1Dot_blue_sar;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone1Date_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone1Text_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="You'll be able to compare next year's plan with your current plan to find out how your coverage may change.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);


		//note: milestone2 - Oct 15 ----------------------------------
		dateStr="October 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone2Line_sar;
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
			targetElement=tl_milestone2Dot_noBlue_sar;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone2Dot_blue_sar;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone2Date_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone2Text_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="If your needs have changed and you want a different plan for next year, you can switch to a new plan.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);

		//note: milestone3 - Jan 1 ----------------------------------
		dateStr="January 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone3Line_sar;
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
			targetElement=tl_milestone3Dot_noBlue_sar;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone3Dot_blue_sar;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone3Date_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone3Text_sar;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="Your 2021 plan coverage starts today.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\tPASSED - validation for "+targetItem);
		return note;
	}
	

}