/**
 * 
 */
package pages.member.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class ReviewOneTimePaymentsPage extends UhcDriver{
	
	@FindBy(xpath="//div[@id='atdd_reviewonetime_label']/div[3]/div[2]/span")
	private WebElement amountPayed;
	
	@FindBy(xpath="//div[@id='atdd_reviewonetime_label']/div[4]/div[2]/span")
	private WebElement routingNumber;
	
	private PageData reviewOneTime;
	
	public JSONObject reviewOneTimeJson;
	
	
	public ReviewOneTimePaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(amountPayed);
		validate(routingNumber);
	}

	
	public JSONObject reviewOneTimeValues() {
		String fileName = CommonConstants.REVIEW_ONE_TIME_PAGE_DATA;
		reviewOneTime = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : reviewOneTime.getExpectedData().keySet()) {
			WebElement element = findElement(reviewOneTime.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		reviewOneTimeJson = jsonObject;

		return reviewOneTimeJson;
	}

}
