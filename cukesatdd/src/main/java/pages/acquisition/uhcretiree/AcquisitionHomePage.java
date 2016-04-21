package pages.acquisition.uhcretiree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class AcquisitionHomePage extends UhcDriver { 

	@Override
	public void openAndValidate() {

		start(UHCRETIREE_ACQISITION_PAGE_URL);

		validate(prescriptionsLink);
	}

	@FindBy(linkText = "Look up prescription drugs")
	private WebElement prescriptionsLink;
	
	@FindBy(id = "new_form_GroupSelector")
	private WebElement dropDownMenu;

	private static String UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.UHCRETIREE_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public SelectFormularyPage prescriptionsDrugLink() {
		validate(prescriptionsLink);
		prescriptionsLink.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Group Retiree – Search for a Drug")) {
			return new SelectFormularyPage(driver);
		}
		return null;
	}

	public RetireesOfSelectedPlans openDropDown(String groupName) {
		 validate(dropDownMenu);
		 Select dropdown = new Select(driver.findElement(By.id("new_form_GroupSelector")));
		 dropdown.selectByVisibleText("San Francisco");
		 System.out.println(getTitle());
		 return new RetireesOfSelectedPlans(driver);
//		return null;
	} 

}