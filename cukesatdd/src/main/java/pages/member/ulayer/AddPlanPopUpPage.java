package pages.member.ulayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class AddPlanPopUpPage extends UhcDriver{
	
	@FindBy(id = "addPlanMemberId.id")
	private WebElement memberIdfield;
	
	@FindBy(id = "addPlanMemberId.extension")
	private WebElement memberIdExtensionfield;
	
	@FindBy(linkText = "continue")
	private WebElement continueButton;

	public AddPlanPopUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ConfirmPlanDetailsPage addNewPlan(String newPlanMemberId) {

		String[] memberIdArray = newPlanMemberId.split("-");
		memberIdfield.click();
		memberIdfield.clear();
		memberIdfield.sendKeys(memberIdArray[0]);
		if(memberIdArray.length>1)
		{
			memberIdExtensionfield.click();
			memberIdExtensionfield.clear();
			memberIdExtensionfield.sendKeys(memberIdArray[1]);
		}		
		
		continueButton.click();
		System.out.println("AddPlanPopUpPage"+driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Plan Summary"))
		{
			return  new ConfirmPlanDetailsPage(driver);
		}
		else
		{
			return null;
		}
			
	}

	@Override
	public void openAndValidate() {
		validate(memberIdfield);
		validate(memberIdExtensionfield);
		validate(continueButton);
		
	}

}
