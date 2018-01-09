/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class SecondPlanInfoPopupPage extends UhcDriver{
	
	@FindBy(linkText = "continue")
	WebElement continueButton;
	
	@FindBy(className = "gotomyaccounthome_btn")
	WebElement goToAccountHome;

	public SecondPlanInfoPopupPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(goToAccountHome);
		
	}
	
	public AccountHomePage navigateToAccountHome()
	{
		goToAccountHome.click();
		ElementData elementData = new ElementData("id", "progress");
		WebElement element = findElement(elementData);
		
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			
		} catch (NoSuchElementException e) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (TimeoutException ex) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (Exception e) {
			System.out.println("closeAndApplyChangesLink not found");
		}
		}
		
		if(currentUrl().contains("home/my-account-home.html"))
		{	
			return new AccountHomePage(driver);
		}
		return null;
	}
	

}
