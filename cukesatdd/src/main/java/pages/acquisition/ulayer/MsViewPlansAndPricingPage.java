/**
 * 
 */
package pages.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class MsViewPlansAndPricingPage extends UhcDriver{
	
	
	
	@FindBy(xpath= "//div[@id='spaHeaderTFN']/div/p[2]")
	private WebElement tfnDisplayed;

	public MsViewPlansAndPricingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(tfnDisplayed);
		
	}
	
	public String getTfnDisplayed() {
		if(validate(tfnDisplayed))
		{
			return tfnDisplayed.getText();
		}
		return null;
		
	}

	public String getTfnExpected(String fileName, String directory,
			String searchEngine) {

		JSONObject maVppExpected = MRScenario.readExpectedJson(
				fileName, directory);
		try {
			String tfnExpected  = (String) ((JSONObject) maVppExpected.get(searchEngine)).get("MS");
			return tfnExpected;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
