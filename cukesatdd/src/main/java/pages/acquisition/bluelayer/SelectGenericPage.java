package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class SelectGenericPage extends UhcDriver {
	
	/*@FindBy(name = "drug")
	List<WebElement> drugNames;*/
	
	@FindBy(linkText = "Continue")
	WebElement continueButton;
	
	public SelectGenericPage(WebDriver driver) {
		super(driver);
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public AddDrugPage selectGeneric(String drugDosage) {
		List<WebElement> elements = driver.findElements(By.name("drug"));
		for (WebElement dosage : elements) {		
				if (dosage.getText().equalsIgnoreCase(drugDosage) && !dosage.isSelected()) {

					dosage.click();
					System.out.println("not selected");

				}
		}
		
		continueButton.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}

		
		
	}
	@Override
	public void openAndValidate() {
		
	}

}
