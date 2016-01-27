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


public class ConfirmPlanDetailsPage extends UhcDriver{

	@FindBy(className = "btnaddplannew")
	private WebElement addNewPlanButton;
	
	@FindBy(linkText = "Go to my account home")
	private WebElement homepageLink;

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	public ConfirmPlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public AccountHomePage confirm() {
		addNewPlanButton.click();
		continueButton.click();
		homepageLink.click();
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | My Account Home"))
		{	
			return new AccountHomePage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(addNewPlanButton);
	}

}
