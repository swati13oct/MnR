package pages.regression.pharmaciesandprescriptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class OrderConfirmationWebElements extends UhcDriver{

	public OrderConfirmationWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void openAndValidate() {
	}
}
