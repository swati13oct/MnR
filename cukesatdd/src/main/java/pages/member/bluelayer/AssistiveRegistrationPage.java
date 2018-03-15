/**
 * 
 */
package pages.member.bluelayer;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author njain112
 *
 */
public class AssistiveRegistrationPage extends UhcDriver {

    @FindBy(id="username")
	private WebElement usernameField;


	
	public AssistiveRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	

	
	@Override
	public void openAndValidate() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(usernameField);
	}
	
	public void usernameautofill(String username)
	{
		System.out.println(usernameField.getAttribute("value"));
		if (usernameField.getAttribute("value").equalsIgnoreCase(username))
				{
			Assert.assertTrue(true);
				}
		else
		{
			Assert.fail("usernameField.getText() >>"+ usernameField.getText());	
					}
	}
}
