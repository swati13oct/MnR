package pages.UHCCP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//*[contains(@class,'filter-section')]")
	private WebElement filterSection;

	@FindBy(xpath = "//*[contains(@id,'benefits-features')]")
	private WebElement BenefitsSection;

	public PlanSummaryPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		validateNew(filterSection);
		validateNew(BenefitsSection);

	}

	public PlanDetailsPage navigateToPlanDetails(String planName) throws InterruptedException {

		List<WebElement> listOfPlans = driver.findElements(
				By.xpath("//div[@class='c-plan-results-card js-plan-results__card']//h2[@class='unity-type-h6']"));

		for (WebElement plan : listOfPlans) {
			String avlPlans = plan.getText();
			WebElement planDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + avlPlans + "')]"));

			CommonUtility.waitForPageLoadNew(driver, planDetailsLink, 5);
			System.out.println(avlPlans.replaceAll("[^ A-Za-z0-9:.()-]", ""));
			if (avlPlans.replaceAll("[^ A-Za-z0-9:.()-]", "").equalsIgnoreCase(planName)) {
				jsClickNew(planDetailsLink);
				break;
			}
		}
		System.out.println("View Plan Details Link is clicked for: " + planName);
		CommonUtility.checkPageIsReadyNew(driver);
		return new PlanDetailsPage(driver);
	}

}
