package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.PageTitleConstants;

public class PharmacySelectorPage {

	@FindBy(xpath = "//div[@class='pharmacyListScroll']")
	WebElement pharmacyTable;

	private WebDriver driver;

	public PharmacySelectorPage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void selectPharmacyType(String pharmacyType, String distance) {

		String pharmacyPath = "//div[@id='dcemodal']/div/div/form/div[5]/div[12]/select[1]/*[. = '"
				+ pharmacyType + "']";
		WebElement pharmacyTypeSelected = driver.findElement(By
				.xpath(pharmacyPath));
		if (!pharmacyTypeSelected.isSelected()) {
			pharmacyTypeSelected.click();
		}

		String distancePath = "//div[@id='dcemodal']/div/div/form/div[5]/div[12]/select[2]/*[. = '"
				+ distance + "']";
		WebElement distanceSelected = driver
				.findElement(By.xpath(distancePath));
		if (!distanceSelected.isSelected()) {
			distanceSelected.click();
		}

	}

	public String getPharmacyList() {

		return pharmacyTable.getText();
	}

	public AddDrugPage selectPharmacy(String pharmacyName) {
/*
		WebElement pharmacyTable = driver.findElement(By
				.xpath("//div[@class='pharmacyListScroll']"));*/
		List<WebElement> allRows = pharmacyTable.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			WebElement pharmacyNameElement = cells.get(0);
			String[] pharmacyArray = pharmacyNameElement.getText().split("\\n");
			if (pharmacyArray[1].equalsIgnoreCase(pharmacyName)) {
				WebElement selectLink = cells.get(1);
				selectLink.getText();
				selectLink.findElement(By.linkText("Select")).click();
				System.out.println("clicked");
				break;
				/*selectLink.findElement(By.xpath("//*[contains(text(), 'Select')]")).click();*/
			}
		}
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}
	}

}
