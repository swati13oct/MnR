package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.ManageDrugPage;
import atdd.framework.UhcDriver;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;

public class PharmacySearchPage extends UhcDriver{

	@FindBy(xpath = "//div[@class='pharmacyListScroll']")
	private WebElement pharmacyTable;
	
	@FindBys(value = { @FindBy(xpath = "//select[@class='pharmacyDropDown']/option") })
	private List<WebElement> pharmacyDropDowmElements;

	@FindBys(value = { @FindBy(xpath = "//select[@class='milesDropDown']/option") })
	private List<WebElement> milesDropDownElements;
	

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
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
		for (WebElement element : pharmacyRows) {
			if (element.getText().contains(pharmacyName)) {
				ElementData elementData = new ElementData("className",
						"dceBlueBtn");
				WebElement selectLink = findChildElement(elementData, element);
				selectLink.click();
				break;
			}
		}
		try {
			if (pharmacyTable.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, pharmacyTable,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("pharmacyTable not found");
		} catch (TimeoutException ex) {
			System.out.println("pharmacyTable not found");
		} catch (Exception e) {
			System.out.println("pharmacyTable not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}
	}

	/*public AddDrugPage selectPharmacy(String pharmacyName) {

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
			}
		}
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}
	}*/


	public PharmacySearchPage searchPharmacies(String pharmacyType,
			String distance) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ElementData pharmacyTypeElement = new ElementData("select:className",
				"pharmacyDropDown");
		List<WebElement> pharmacyTypeOptions = findElements(pharmacyTypeElement);
*/
		for (WebElement pharmacyTypeOption : pharmacyDropDowmElements) {
			if (pharmacyTypeOption.getText().equalsIgnoreCase(pharmacyType)) {
				pharmacyTypeOption.click();
			}
		}
/*
		ElementData distanceElement = new ElementData("select:className",
				"milesDropDown");
		List<WebElement> distanceOptions = findElements(distanceElement);*/

		for (WebElement distanceOption : milesDropDownElements) {
			if (distanceOption.getText().equalsIgnoreCase(distance)) {
				distanceOption.click();
			}
		}
		return new PharmacySearchPage(driver);
	}
	
	@Override
	public void openAndValidate() {

	}
	
	

}
