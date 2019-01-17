/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class HealthAndWellnessPage extends UhcDriver {
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData healthAndWelless;

	public JSONObject healthAndWellessJson;

	public HealthAndWellnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.HEALTH_AND_WELLNESS_PAGE_DATA;
		healthAndWelless = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : healthAndWelless.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(healthAndWelless
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		healthAndWellessJson = jsonObject;
		
		System.out.println("healthAndWellessJson----->"+healthAndWellessJson);

	}
	
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject healthAndWellnessExpectedJson = expectedDataMap
				.get(CommonConstants.HEALTH_AND_WELLNESS);
		healthAndWellnessExpectedJson = CommonUtility.mergeJson(
				healthAndWellnessExpectedJson, globalExpectedJson);
		return healthAndWellnessExpectedJson;

	}

	public void logout() {
		logOut.click();
		
	}
	

	public void validateTabsAndContent() {

		WebElement largeWidget = driver.findElement(By.id("hl-div-threecol-body"));
		WebElement lifestyleTab = driver.findElement(By.id("life"));
		WebElement learningTab = driver.findElement(By.id("learn"));
		WebElement rewardsTab = driver.findElement(By.id("rwd"));
		
		WebElement renewLifestyleTab = driver.findElement(By.xpath(".//*[@id='hl-hw-buckets']/div/div[1]/a/img"));
		WebElement renewLearningTab = driver.findElement(By.xpath(".//*[@id='hl-hw-buckets']/div/div[2]/a/img"));
		WebElement renewRewardsTab = driver.findElement(By.xpath(".//*[@id='hl-hw-buckets']/div/div[3]/a/img"));

		Assert.assertTrue("Health & Wellness content is not displayed", largeWidget.isDisplayed());
		Assert.assertTrue("Life Style Tab is not displayed", lifestyleTab.isDisplayed());
		Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
		Assert.assertTrue("Rewards tab is not displayed", rewardsTab.isDisplayed());
		
		Assert.assertTrue("Renew Life Style Tab is not displayed", renewLifestyleTab.isDisplayed());
		Assert.assertTrue("Renew Learning tab is not displayed", renewLearningTab.isDisplayed());
		Assert.assertTrue("Renew Rewards tab is not displayed", renewRewardsTab.isDisplayed());
	}
	
	public void validateLifeStyleTab(){
		WebElement lifestyleTab =  driver.findElement(By.id("life"));
		lifestyleTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement lifeStyleContent = driver.findElement(By.className("hw-fc-list-container"));
		
		Assert.assertTrue("Life style tab content is not displayed", lifeStyleContent.isDisplayed());
	}
	
	
	public void validateLearningTab(){
		WebElement learningTab = driver.findElement(By.id("learn"));
		learningTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement learningContent = driver.findElement(By.className("hw-learning-main-content"));
		WebElement learningRightNav = driver.findElement(By.className("hw-learning-rightNav"));
		
		Assert.assertTrue("Learning tab content is not displayed", learningContent.isDisplayed());
		Assert.assertTrue("Learning tab right nav is not displayed", learningRightNav.isDisplayed());
	}
	
	public void validateRewardsTab(){
		WebElement rewardsTab = driver.findElement(By.id("rwd"));
		rewardsTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement rewardsContent = driver.findElement(By.id("hw-rewards-feedback"));
		WebElement rewardsBottomContent = driver.findElement(By.id("hl-hw-subscribe-rewards"));
		
		Assert.assertTrue("Rewards tab content is not displayed", rewardsContent.isDisplayed());
		Assert.assertTrue("Rewards tab right nav is not displayed", rewardsBottomContent.isDisplayed());
	}

	
	


}
