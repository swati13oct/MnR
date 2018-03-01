package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class AddPlanPopUpPage extends UhcDriver {

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

	
	@Override
	public void openAndValidate() {
		validate(memberIdfield);
		validate(memberIdExtensionfield);
		validate(continueButton);

	}

}
