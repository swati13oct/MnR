/**
 * 
 */
package pages.member.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacyResultPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath = "//a[text()='產生 PDF 檔']")
	private WebElement chinesepdfurl;
	
	@FindBy(xpath = "//a[text()='Crear PDF']")
	private WebElement spanishpdfurl;
	
	@FindBy(xpath = "//a[text()='Create PDF']")
	private WebElement uspdfurl;
	
	@FindBy(xpath = "(//div[@class='startedsearchtop headingtop1'])[2]/h2")
	private WebElement preferredMailWidgetDisplayed;

    @FindBy(xpath = "(//div[@class='startedsearchtop headingtop1'])[3]/h2")
	private WebElement contactOptumRxWidgetDisplayed;
    
    boolean ballonflagvalue=true;
	
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

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,String expectedObjectkey) {
        System.out.println(expectedDataMap);
		/* get PHARMACY RESULT expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject pharmacyResultExpectedJson = null;
		try {
			pharmacyResultExpectedJson = (JSONObject) expectedDataMap
					.get(CommonConstants.PHARMACY_RESULT).get(expectedObjectkey);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pharmacyResultExpectedJson = CommonUtility.mergeJson(
				pharmacyResultExpectedJson,globalExpectedJson);

		return pharmacyResultExpectedJson;

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
  public boolean checkRightRailWidgets()
  {
	  preferredMailWidgetDisplayed.getText();
	  contactOptumRxWidgetDisplayed.getText();
	  if(preferredMailWidgetDisplayed.isDisplayed() && contactOptumRxWidgetDisplayed.isDisplayed())
	  {
	   return true;
	  }  
	  else
	  {
	  return false;
	  }
  }

public String getChinesePdfUrl() {
	// TODO Auto-generated method stub
	chinesepdfurl.click();
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	String getCurrentUrl= driver.getCurrentUrl();
	driver.close();
	//driver.switchTo().defaultContent();
	return getCurrentUrl;
}
public String getSpanishPdfUrl() {
	// TODO Auto-generated method stub
	spanishpdfurl.click();
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	String getCurrentUrl= driver.getCurrentUrl();
	//driver.close();
	//driver.switchTo().defaultContent();
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
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	String getCurrentUrl= driver.getCurrentUrl();
	driver.close();
	//driver.switchTo().defaultContent();
	return getCurrentUrl;
	
}
public  boolean validateBallonMappers() {
	String  BallonColor=driver.findElement(By.xpath("//div[@class='pub_mid']/p[1]/img[1]")).getAttribute("src");
	String CorrespondingPharmacyName=driver.findElement(By.xpath("//div[@class='pub_mid']/p[1]")).getText();
	CorrespondingPharmacyName=CorrespondingPharmacyName.replaceAll("\\s+","");
	String CorrespondingPharmacyNames[]=CorrespondingPharmacyName.split("=");
	System.out.println(CorrespondingPharmacyNames[1]);
	System.out.println(CorrespondingPharmacyNames[2]);
	System.out.println("Ballon color is"+BallonColor);
	System.out.println("Corresponding Pharmacy Name"+CorrespondingPharmacyName);
	if(BallonColor.contains("blue"))
    {
 	 if(CorrespondingPharmacyNames[2].equalsIgnoreCase("StandardNetworkPharmacy"))
 	 {
 		 ballonflagvalue=true;
 		// continue;
 	 }
 	 else
 	 {
 		 ballonflagvalue=false;
 	 }
  }
  else if(BallonColor.contains("red"))
  {
 	 if(CorrespondingPharmacyNames[1].equalsIgnoreCase("PharmacySaverTMProgram"))
 	 {
 		 ballonflagvalue=true;
 		 // continue;
 	 }
 	 else
 	 {
 		 ballonflagvalue=false;
 	 }
  }
  else
  {
 	 ballonflagvalue=false;
		 
  }
	 return ballonflagvalue;
	// TODO Auto-generated method stub
	 /*WebElement table=driver.findElement(By.id("currentRowObject"));
	    int rows=table.findElements(By.xpath("//table[@id='currentRowObject']/tbody/tr")).size();
	    System.out.println(rows);
	    for(int i=1;i<=rows;i++)
	    {
	    	String BallonColor=driver.findElement(By.xpath("//table[@id='currentRowObject']/tbody/tr[" + i + "]/td[1]/div[1]/div[1]")).getAttribute("style");
	    	String CorrespondingPharmacyName=driver.findElement(By.xpath("//table[@id='currentRowObject']/tbody/tr[" + i + "]/td[2]/div/ul/li")).getText();
	        System.out.println(BallonColor);
	        System.out.println(CorrespondingPharmacyName);
	    	if(BallonColor.contains("blue"))
	       {
	    	 if(CorrespondingPharmacyName.equalsIgnoreCase("Standard Network Pharmacy"))
	    	 {
	    		 ballonflagvalue=true;
	    		// continue;
	    	 }
	    	 else
	    	 {
	    		 ballonflagvalue=false;
	    		 break;
	    	 }
	     }
	     else if(BallonColor.contains("red"))
	     {
	    	 if(CorrespondingPharmacyName.equalsIgnoreCase("Pharmacy Saver™ Program"))
	    	 {
	    		 ballonflagvalue=true;
	    		 // continue;
	    	 }
	    	 else
	    	 {
	    		 ballonflagvalue=false;
	    		 break;
	    		 
	    	 }
	     }
	     else
	     {
	    	 ballonflagvalue=false;
			 break; 
	     }
	    }
	    return ballonflagvalue;
}*/
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
}

