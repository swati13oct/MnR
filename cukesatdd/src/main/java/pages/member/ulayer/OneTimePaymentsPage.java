/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class OneTimePaymentsPage extends UhcDriver{

	public OneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	

}
