package pages.member.bluelayer;

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

import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class AddPlanPopUpPage extends UhcDriver {

	@FindBy(id = "addPlanMemberId.id")
	private WebElement memberIdfield;

	@FindBy(id = "addPlanMemberId.extension")
	private WebElement memberIdExtensionfield;

	@FindBy(linkText = "continue")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='add_anotherplan']/div[2]/div/div[2]/div[2]/h3[2]")
	private WebElement addNewPlansHeading;
	
	@FindBy(xpath = "//div[@id='add_anotherplan']/div[2]/div/div[2]/div[2]/p[2]")
	private WebElement addNewPlansHeadingMessage;

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
