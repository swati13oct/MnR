package pages.acquisition.uhcretiree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class DrugCoverageOptionsPage extends UhcDriver {

	@FindBy(id = "drugNameFilter")
	private WebElement inputFilter;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div[4]/div[1]/div/div[1]/div[1]/p[1]/a")
	private WebElement seeIfMyMedicationLink;
	
	public DrugCoverageOptionsPage(WebDriver driver) {
		super(driver);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validate(seeIfMyMedicationLink);
		
	}

	public EnterDrugPage clickSeeIfMyMedicationLink() {
		driver.findElement(By.linkText("See if my medication is covered")).click();
		CommonUtility.waitForPageLoad(driver, inputFilter, 3);
		if (getTitle().contains(
				"Drug Search")) {
			return new EnterDrugPage(driver);
		}
		return null;
	}

}
