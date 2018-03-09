package pages.acquisition.uhcretiree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class RetireesOfSelectedPlans extends UhcDriver {

	
	@FindBy(linkText = "Understand prescription drug coverage options")
	private WebElement coverageOptionsLink;
	
	public RetireesOfSelectedPlans(WebDriver driver) {
		super(driver);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		validate(coverageOptionsLink);
		
	}

	public DrugCoverageOptionsPage clickDrugCoverageOptionsLink() {
		CommonUtility.waitForPageLoad(driver, coverageOptionsLink, 3);
		driver.findElement(By.linkText("Understand prescription drug coverage options")).click();
//		coverageOptionsLink.click();
		String title = getTitle().toLowerCase();
		if (title.contains(
				"drug coverage")) {
			return new DrugCoverageOptionsPage(driver);
		}
		return null;
	}

	public DrugCoverageOptionsPage clickDrugCoverageOptionsTab() {
		CommonUtility.waitForPageLoad(driver, coverageOptionsLink, 3);								
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[4]/div/div")).click();
		String title = getTitle().toLowerCase();
		if (title.contains(
				"drug coverage")) {
			return new DrugCoverageOptionsPage(driver);
		}
		return null;
	}

}
