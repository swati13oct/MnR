package pages.acquisition.uhcretiree;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class SalesforceSitePage extends UhcDriver { 
	
	@Override
	public void openAndValidate() {
		
	}	
	
	
	
	public SalesforceSitePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

}