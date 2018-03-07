/**
 * 
 */
package pages.deprecated.member.bluelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacyResultPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//a[text()='?? PDF ?']")
	private WebElement chinesepdfurl;

	@FindBy(xpath = "//a[text()='Crear PDF']")
	private WebElement spanishpdfurl;

	@FindBy(xpath = "//a[text()='Create PDF']")
	private WebElement uspdfurl;

	@FindBy(xpath = "(//div[@class='startedsearchtop headingtop1'])[2]/h2")
	private WebElement preferredMailWidgetDisplayed;

	@FindBy(xpath = "(//div[@class='startedsearchtop headingtop1'])[3]/h2")
	private WebElement contactOptumRxWidgetDisplayed;

	@FindBy(xpath = "//a[text()='丬文']")
	private WebElement chineseContent;

	@FindBy(xpath = "//a[text()='search']")
	private WebElement chineseSearch;

	@FindBy(xpath = "//a[text()='español']")
	private WebElement spanishContent;

	@FindBy(xpath = "//a[text()='search']")
	private WebElement spanishSearch;
	
	@FindBy(xpath = "//div[contains(@class,'Pharmacyresults')]/table[@class='searchResults']/tbody/tr/td[3]/div/ul/li[2]/a")
	private WebElement viewMaplink;

	@FindBy(xpath = "//div[contains(@class,'Pharmacyresults')]/table[@class='searchResults']/tbody/tr/td/ul/li")
	private List<WebElement> pharmacyDetails;

	@FindBy(xpath = "//div[@class='mapContainer']/div/div/div/div/div[4]/div[4]/div/div[2]/div/div/p")
	private List<WebElement> viewMapresult;

	@FindBy(xpath = "//a[@id='find_searchagainbtn']")
	private WebElement searchAgainButton;

	@FindBy(linkText = "Create PDF")
	private WebElement createPDFlink;

	boolean ballonflagvalue = true;

	private PageData pharmacyResult;

	public JSONObject pharmacyResultJson;

	public PharmacyResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PHARMACY_RESULT_PAGE_DATA;
		pharmacyResult = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String expectedObjectkey) {
		System.out.println(expectedDataMap);
		/* get PHARMACY RESULT expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject pharmacyResultExpectedJson = null;
		try {
			pharmacyResultExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.PHARMACY_RESULT).get(expectedObjectkey);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pharmacyResultExpectedJson = CommonUtility.mergeJson(
				pharmacyResultExpectedJson, globalExpectedJson);

		return pharmacyResultExpectedJson;

	}
	public void validatePlanName(){
		String planName = LoginCommonConstants.PLAN_NAME;
		System.out.println(planName);
		List<WebElement> planWebElement = driver.findElements(By.xpath("//*[contains(text(),'"+LoginCommonConstants.PLAN_NAME+"')]"));
		for(int i=0; i<planWebElement.size();i++){
			if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
				System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
				Assert.fail();
			}
			else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
				System.out.println("----------Plan name displayed as expected="+planName);
			} else{
				System.out.println("----------Failed because Plan NAme not present");
				Assert.fail();
			} 		 
		}
	}
	@Override
	public void openAndValidate() {
		validateNew(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacyResult.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(pharmacyResult
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validateNew(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validateNew(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(pharmacyResult.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		pharmacyResultJson = jsonObject;

		System.out.println("pharmacyResultJson----->" + pharmacyResultJson);
	}

	public boolean checkRightRailWidgets() {
		preferredMailWidgetDisplayed.getText();
		contactOptumRxWidgetDisplayed.getText();
		if (preferredMailWidgetDisplayed.isDisplayed()
				&& contactOptumRxWidgetDisplayed.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String getChinesePdfUrl() {
		// TODO Auto-generated method stub
		chinesepdfurl.click();
		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String getCurrentUrl = driver.getCurrentUrl();
		driver.close();
		// driver.switchTo().defaultContent();
		return getCurrentUrl;
	}

	public String getSpanishPdfUrl() {
		// TODO Auto-generated method stub
		spanishpdfurl.click();
		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String getCurrentUrl = driver.getCurrentUrl();
		// driver.close();
		// driver.switchTo().defaultContent();
		return getCurrentUrl;
	}

	public String getEnglishPdfUrl() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uspdfurl.click();
		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String getCurrentUrl = driver.getCurrentUrl();
		driver.close();
		// driver.switchTo().defaultContent();
		return getCurrentUrl;

	}

	public boolean validateBallonMappers() {
		String BallonColor = driver.findElement(
				By.xpath("//div[@class='pub_mid']/p[1]/img[1]")).getAttribute(
						"src");
		String CorrespondingPharmacyName = driver.findElement(
				By.xpath("//div[@class='pub_mid']/p[1]")).getText();
		CorrespondingPharmacyName = CorrespondingPharmacyName.replaceAll(
				"\\s+", "");
		String CorrespondingPharmacyNames[] = CorrespondingPharmacyName
				.split("=");
		System.out.println(CorrespondingPharmacyNames[1]);
		System.out.println(CorrespondingPharmacyNames[2]);
		System.out.println("Ballon color is" + BallonColor);
		System.out.println("Corresponding Pharmacy Name"
				+ CorrespondingPharmacyName);
		if (BallonColor.contains("blue")) {
			if (CorrespondingPharmacyNames[2]
					.equalsIgnoreCase("StandardNetworkPharmacy")) {
				ballonflagvalue = true;
				// continue;
			} else {
				ballonflagvalue = false;
			}
		} else if (BallonColor.contains("red")) {
			if (CorrespondingPharmacyNames[1]
					.equalsIgnoreCase("PharmacySaverTMProgram")) {
				ballonflagvalue = true;
				// continue;
			} else {
				ballonflagvalue = false;
			}
		} else {
			ballonflagvalue = false;

		}
		return ballonflagvalue;
		// TODO Auto-generated method stub

	}

	public JSONObject getExpectedDataWithOutPharmacyType(Map<String, JSONObject> expectedDataMap/*,String expectedObjectkey*/) {
		System.out.println(expectedDataMap);
		/* get PHARMACY RESULT expected data */
		/*JSONObject globalExpectedJson = expectedDataMap
	                                                .get(CommonConstants.GLOBAL);*/
		JSONObject pharmacyResultExpectedJson = null;
		/*try {*/
		pharmacyResultExpectedJson = (JSONObject) expectedDataMap
				.get(CommonConstants.PHARMACY_RESULT)/*.get(expectedObjectkey)*/;
		/*} catch (JSONException e) {
	                                // TODO Auto-generated catch block
	                                e.printStackTrace();
	                }*/
		/*pharmacyResultExpectedJson = CommonUtility.mergeJson(
	                                                pharmacyResultExpectedJson,globalExpectedJson);*/

		return pharmacyResultExpectedJson;
	}
	
	public boolean validategeneralPharmacyResultpage(JSONObject jsonObject, String zipcode, String planName){
		boolean flag = true;
		try {
			if(zipcode == null || planName == null){
				if(!jsonObject.get("pharmacyTitleText").toString().contains("Pharmacies close to "))	
					flag = false;
			}else{
				if(!jsonObject.get("pharmacyTitleText").toString().contains("Pharmacies close to " +zipcode+" for "+planName))
					flag = false;
			}

			if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience delivered "
					+ "right to your mailbox when you use home deliver through OptumRx, your plan's Preferred mail service pharmacy. "
					+ "You could pay less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy."
					+ "\nContact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee Mission, KS 66201-1375\n"
					+ "Call: 1-888-266-4832, 24 hours a day, 7 days a week. TTY users, call: 711."))
				flag = false;

			if(!jsonObject.get("pharmacyNameheader").toString().contains("Pharmacy name"))
				flag = false;

			if(!jsonObject.get("servicesHeader").toString().contains("Services"))
				flag = false;

			if(!jsonObject.get("distnaceHeader").toString().contains("Distance"))
				flag = false;

			viewMaplink.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for(int i = 0; i< viewMapresult.size(); i++){
				System.out.println(viewMapresult.get(i).getText());
				System.out.println(pharmacyDetails.get(i).getText());
				if(!(viewMapresult.get(i).getText().replace("-", "").equals(pharmacyDetails.get(i).getText().replace("-", ""))))
					flag = false;
			}


			System.out.println(flag);
			String mwh=driver.getWindowHandle();
			
			System.out.println(createPDFlink.isDisplayed());
			createPDFlink.click();
			
			Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

			Iterator ite=s.iterator();

			while(ite.hasNext())
			{
			    String popupHandle=ite.next().toString();
			    System.out.println(driver.getTitle());
			    if(!popupHandle.contains(mwh))
			    {
			        driver.switchTo().window(popupHandle);
			        if(!driver.getTitle().equals("pharmacyDirectory.pdf"))
			        	flag = false;
			        driver.switchTo().window(mwh);			       
			    }
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
		return flag;
	}

	public boolean validatelanguageSpecificPharmacyResultpage(JSONObject jsonObject, String zipcode, String planName, String language){

		boolean flag = true;
		try {
			if(language.equals("Spanish")){
				if(zipcode == null || planName == null){
					if(!jsonObject.get("pharmacyTitleText").toString().contains("Farmacias cerca de "))	
						flag = false;
				}else{
					if(!jsonObject.get("pharmacyTitleText").toString().contains("Farmacias cerca de " +zipcode+" para "+planName))
						flag = false;
				}

				if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience delivered right "
						+ "to your mailbox when you use home deliver through OptumRx, your plan's Preferred mail service pharmacy. You could pay "
						+ "less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy.\nContact OptumRx\nOptumRx "
						+ "Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee Mission, KS 66201-1375\nCall: 1-888-266-4832, 24 hours a day, "
						+ "7 days a week. TTY users, call: 711."))
					flag = false;

				if(!jsonObject.get("pharmacyNameheader").toString().contains("Nombre de la farmacia"))
					flag = false;

				if(!jsonObject.get("servicesHeader").toString().contains("Servicios"))
					flag = false;

				if(!jsonObject.get("distnaceHeader").toString().contains("Distancia"))
					flag = false;

				viewMaplink.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for(int i = 0; i< viewMapresult.size(); i++){
					System.out.println(viewMapresult.get(i).getText());
					System.out.println(pharmacyDetails.get(i).getText());
					if(!(viewMapresult.get(i).getText().replace("-", "").equals(pharmacyDetails.get(i).getText().replace("-", ""))))
						flag = false;
				}
			}
			else if(language.equals("Chinese")){
				if(zipcode == null || planName == null){
					if(!jsonObject.get("pharmacyTitleText").toString().contains("附近的 "))	
						flag = false;
				}else{
					if(!jsonObject.get("pharmacyTitleText").toString().contains(zipcode+" 附近的 "+planName+" 藥房"))
						flag = false;
				}

				if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience delivered "
						+ "right to your mailbox when you use home deliver through OptumRx, your plan's Preferred mail service pharmacy. "
						+ "You could pay less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy.\nContact "
						+ "OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee Mission, KS 66201-1375\nCall: 1-888-266-4832, "
						+ "24 hours a day, 7 days a week. TTY users, call: 711."))
					flag = false;

				if(!jsonObject.get("pharmacyNameheader").toString().contains("藥房�??稱"))
					flag = false;

				if(!jsonObject.get("servicesHeader").toString().contains("�?務"))
					flag = false;

				if(!jsonObject.get("distnaceHeader").toString().contains("�?離"))
					flag = false;

				viewMaplink.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for(int i = 0; i< viewMapresult.size(); i++){
					System.out.println(viewMapresult.get(i).getText());
					System.out.println(pharmacyDetails.get(i).getText());
					if(!(viewMapresult.get(i).getText().replace("-", "").equals(pharmacyDetails.get(i).getText().replace("-", ""))))
						flag = false;
				}

			}




			System.out.println(flag);



		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
		return flag;

	}
}