package pages.member.bluelayer;

/*@sunya*/

import java.util.List;
import java.util.Map;

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

public class HealthAndWellnessPage extends UhcDriver {

	@FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
	private WebElement uhcMedicareCompleteChoicePPO;

	@FindBy(xpath = ".//*[@id='hl-hw-banner']/a")
	private WebElement healthAndWellnessBanner;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData healthAndWellness;

	public JSONObject myProfilesJson;
	public JSONObject accountHomeJson;

	public HealthAndWellnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		healthAndWellness = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(healthAndWellnessBanner);

		JSONObject jsonObject = new JSONObject();
		for (String key : healthAndWellness.getExpectedData().keySet()) {
			WebElement element = findElement(healthAndWellness.getExpectedData().get(key));
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
		accountHomeJson = jsonObject;

		System.out.println("accountHomeJson----->" + accountHomeJson);

	}

	public boolean validate(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible");

		}
		return false;
	}

	public void logOut() {
		logOut.click();
	}

	/**
	 * Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
	 * Added as part of commandos team
	 * 
	 * @return
	 */

	public void validateTabsAndContent() {

		WebElement largeWidget = driver.findElement(By.className("hl-hw-dashboard-container"));
		WebElement lifestyleTab = driver.findElement(By.xpath(".//*[@id='lifestyle']/span"));
		WebElement learningTab = driver.findElement(By.xpath(".//*[@id='learning']/span"));
		WebElement rewardsTab = driver.findElement(By.xpath(".//*[@id='rewards']/span"));
		
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
		WebElement lifestyleTab = driver.findElement(By.xpath(".//*[@id='lifestyle']/span"));
		lifestyleTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement lifeStyleContent = driver.findElement(By.className("hw-lifestyle-main-content"));
		WebElement lifeStyleRightNav = driver.findElement(By.className("hw-lifestyle-rightNav"));
		
		Assert.assertTrue("Life style tab content is not displayed", lifeStyleContent.isDisplayed());
		Assert.assertTrue("Life style tab right nav is not displayed", lifeStyleRightNav.isDisplayed());
	}
	
	
	public void validateLearningTab(){
		WebElement learningTab = driver.findElement(By.xpath(".//*[@id='learning']/span"));
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
		WebElement rewardsTab = driver.findElement(By.xpath(".//*[@id='rewards']/span"));
		rewardsTab.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement rewardsContent = driver.findElement(By.id("hl-hw-banner-rewards"));
		WebElement rewardsRightNav = driver.findElement(By.id("hl-hw-subscribe-rewards"));
		
		Assert.assertTrue("Rewards tab content is not displayed", rewardsContent.isDisplayed());
		Assert.assertTrue("Rewards tab right nav is not displayed", rewardsRightNav.isDisplayed());
	}

}
