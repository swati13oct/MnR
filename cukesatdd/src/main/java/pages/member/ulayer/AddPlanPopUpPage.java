package pages.member.ulayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
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
		ElementData elementData = new ElementData("id", "progress");
		WebElement element = findElement(elementData);
		
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			
		} catch (NoSuchElementException e) {
			System.out.println("progress not found");
		} catch (TimeoutException ex) {
			System.out.println("progress not found");
		} catch (Exception e) {
			System.out.println("progress not found");
		}
		
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
