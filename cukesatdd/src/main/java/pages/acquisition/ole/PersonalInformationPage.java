/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PersonalInformationPage extends UhcDriver{


	public PersonalInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}


}