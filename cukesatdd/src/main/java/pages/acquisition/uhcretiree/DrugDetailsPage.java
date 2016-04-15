package pages.acquisition.uhcretiree;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class DrugDetailsPage  extends UhcDriver {

	public DrugDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

}
