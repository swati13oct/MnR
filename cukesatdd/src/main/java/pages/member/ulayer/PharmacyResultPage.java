/**
 * 
 */
package pages.member.ulayer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
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
 * @author pperugu
 *
 */
public class PharmacyResultPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//div[@class='pharmacymid']/p")
	private WebElement pharmacyTypesicondescription;

	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/thead/tr/th[@class='colPhar2']/div/span")
	private WebElement servicesTooltip;

	@FindBy(xpath = "//div[@class='tooltipinner']/ul/li")
	private List<WebElement> tooltipDetails;

	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td[3]/div/ul/li[2]/a")
	private WebElement viewMaplink;

	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td/ul/li")
	private List<WebElement> pharmacyDetails;

	@FindBy(xpath = "//div[@class='mapContainer']/div/div/div/div/div[4]/div[4]/div/div[2]/div/div/p")
	private List<WebElement> viewMapresult;

	@FindBy(xpath = "//a[@id='find_searchagainbtn']")
	private WebElement searchAgainButton;

	@FindBy(linkText = "Create PDF")
	private WebElement createPDFlink;

	
	private PageData pharmacyResult;

	public JSONObject pharmacyResultJson;

	public PharmacyResultPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PHARMACY_RESULT_PAGE_DATA;
		pharmacyResult = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(logOut);
		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacyResult.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(pharmacyResult
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
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

		System.out.println("pharmacyResultJson----->"+pharmacyResultJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject pharmacyResultExpectedJson = expectedDataMap
				.get(CommonConstants.PHARMACY_RESULT);
		pharmacyResultExpectedJson = CommonUtility.mergeJson(
				pharmacyResultExpectedJson, globalExpectedJson);
		return pharmacyResultExpectedJson;
	}

	public boolean validategeneralPharmacyResultpage(JSONObject jsonObject, String zipcode, String planName){
		boolean flag = true;
		try {
			if(zipcode == null && planName == null){
				if(!jsonObject.get("pharmacyTitleText").toString().contains("Pharmacies close to "))	
					flag = false;
			}else{
				if(!jsonObject.get("pharmacyTitleText").toString().contains("Pharmacies close to " +zipcode+" for "+planName))
					flag = false;
			}

			if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience "
					+ "delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail "
					+ "service pharmacy. You could pay less for the same medications.\nLearn more about the OptumRx Preferred "
					+ "Mail Service Pharmacy\nContact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee "
					+ "Mission, KS\n66201-1375\nCall: 1-877-266-4832,\n24 hours a day, 7 days a week.\nTTY users, call 711.\n "))
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
		return flag;
	}

	public boolean validatelanguageSpecificPharmacyResultpage(JSONObject jsonObject, String zipcode, String planName, String language){

		boolean flag = true;
		try {
			if(language.equals("Spanish")){
				if(zipcode == null && planName == null){
					if(!jsonObject.get("pharmacyTitleText").toString().contains("Farmacias cerca de "))	
						flag = false;
				}else{
					if(!jsonObject.get("pharmacyTitleText").toString().contains("Farmacias cerca de " +zipcode+" para "+planName))
						flag = false;
				}

				if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience "
						+ "delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail "
						+ "service pharmacy. You could pay less for the same medications.\nLearn more about the OptumRx Preferred "
						+ "Mail Service Pharmacy\nContact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee "
						+ "Mission, KS\n66201-1375\nCall: 1-877-266-4832,\n24 hours a day, 7 days a week.\nTTY users, call 711.\n "))
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
				if(zipcode == null && planName == null){
					if(!jsonObject.get("pharmacyTitleText").toString().contains("附近的 "))	
						flag = false;
				}else{
					if(!jsonObject.get("pharmacyTitleText").toString().contains(zipcode+" 附近的 "+planName+" 藥房"))
						flag = false;
				}

				if(!jsonObject.get("pageRight").toString().contains("Preferred Mail Service Pharmacy\nGet savings and convenience "
						+ "delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail "
						+ "service pharmacy. You could pay less for the same medications.\nLearn more about the OptumRx Preferred "
						+ "Mail Service Pharmacy\nContact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\nShawnee "
						+ "Mission, KS\n66201-1375\nCall: 1-877-266-4832,\n24 hours a day, 7 days a week.\nTTY users, call 711.\n "))
					flag = false;

				if(!jsonObject.get("pharmacyNameheader").toString().contains("藥房名稱"))
					flag = false;

				if(!jsonObject.get("servicesHeader").toString().contains("服務"))
					flag = false;

				if(!jsonObject.get("distnaceHeader").toString().contains("距離"))
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
		return flag;

	}
}
