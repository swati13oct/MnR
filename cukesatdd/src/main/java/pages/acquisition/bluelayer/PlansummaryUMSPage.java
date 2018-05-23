/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author gumeshna
 *
 */
public class PlansummaryUMSPage {
	
	@FindBy(id = "maplans_container")
	private WebElement MAcontainer;
	
	@FindBy(id = "pdpplans_container")
	private WebElement PDPcontainer;
	
	@FindBy(id = "snpplans_container")
	private WebElement SNPcontainer;
	
	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div")
	private WebElement MAplantypefield;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div")
	private WebElement PDPplantypefield;

	@FindBy(xpath = "//div[@class='snpplans_planbutton']/div[2]/div[2]/div")
	private WebElement SNPplantypefield;

	//@FindBy(xpath = "//div[@class='section plancardwidgetbox']/div[1]/div[1]")
	
	//"//div[1]/div[1]/div[@class='vppcardwidget ng-scope']""
	
	@FindBy(xpath = "//div[@class='vppcardwidget ng-scope']")
	List<WebElement> planElement;

	private WebDriver driver;

	public PlansummaryUMSPage(WebDriver driver) {
		this.driver = driver;

		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public PlansummaryUMSPage viewplans(String plantype) {

		if (plantype.contains("PDP")) {
			PDPplantypefield.click();
		} else {

			if (plantype.contains("SNP")) {
				SNPplantypefield.click();
			} else {
				MAplantypefield.click();
			}
		}

		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new PlansummaryUMSPage(driver);
		}
		return null;
	}

	public PlandetailsUMSPage navigateToPlanDetails(String planName,
			String plantype) {
	
		for (WebElement plan : planElement) {
			
			//String planName1 =plan.findElement(By.xpath("//div[@class='vppplanheading ng-binding']")).getText();
			if (plan.getText().contains(planName)) {

				plan.findElement(By.id("viewDetails" + plantype)).click();
				CommonUtility.checkPageIsReady(driver);
				break;

			}
		}
		if (driver.getTitle().equalsIgnoreCase("Plan Details") || driver.getTitle().equalsIgnoreCase("Plan Detail")) {
			return new PlandetailsUMSPage(driver);
		}

		return null;

	}
	
	
	public String getContent(String plantype) {
		
		if (plantype.contains("PDP")) {
			 return PDPcontainer.getText();
		}
		if (plantype.contains("SNP")) {
				return SNPcontainer.getText();
		} 
		if (plantype.contains("MA")){
				return MAcontainer.getText();
		}
		return null;

	}
}
