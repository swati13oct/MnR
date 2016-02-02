package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class SelectDosagePage extends UhcDriver {

	@FindBy(className = "borderBtmGrey")
	List<WebElement> drugDosages;

	@FindBy(name = "Quantity")
	WebElement quantityField;

	@FindBy(linkText = "Continue")
	WebElement continueButton;

	public SelectDosagePage(WebDriver driver) {
		super(driver);
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public SelectGenericPage selectDosage(String drugDosage,
			String drugQuantity, String drugFrequency, String packages) {

		for (WebElement dosage : drugDosages) {
			if (dosage.getText().equalsIgnoreCase(drugDosage)) {

				if (!dosage.findElement(By.xpath("//input")).isSelected()) {

					dosage.findElement(By.name("labelName")).click();
					System.out.println("not selected");
					selectPackage(packages);

				} else {
					selectPackage(packages);

				}

			}

		}

		quantityField.click();
		quantityField.clear();
		quantityField.sendKeys(drugQuantity);

		String frequencyXPath = "//div[@id='dcemodal']/div/div/div[7]/form/div[6]/select/*[. = '"
				+ drugFrequency + "']";
		driver.findElement(By.xpath(frequencyXPath)).click();

		continueButton.click();

		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new SelectGenericPage(driver);
		} else {
			return null;
		}

	}

	private void selectPackage(String packages) {
		if (null != packages) {
			for (WebElement pack : drugDosages) {
				if (pack.getText().equalsIgnoreCase(packages)) {
					if (!pack.findElement(By.xpath("//input")).isSelected()) {

						pack.findElement(By.name("packageDisplayName")).click();
						System.out.println("not selected");

					}
				}
			}
		}

	}
	
	@Override
	public void openAndValidate() {
		

	}

}
