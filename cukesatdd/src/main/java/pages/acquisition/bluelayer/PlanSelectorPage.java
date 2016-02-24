/**
 * 
 */
package pages.acquisition.bluelayer;


import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import acceptancetests.atdd.data.PageData;

/**
 * @author rkodumur
 *
 */
public class PlanSelectorPage extends GlobalFooterWebElements{
	
	
	public PlanSelectorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Boolean validate_textField() {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.click();
		zipcodeField.sendKeys("90210");
		String zip = zipcodeField.getAttribute("value");
		if(zip.equalsIgnoreCase("90210")){
			return true;
		}
		return false;
		
	}

		
}
