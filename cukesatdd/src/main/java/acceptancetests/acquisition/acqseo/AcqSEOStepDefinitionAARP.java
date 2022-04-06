package acceptancetests.acquisition.acqseo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

/**
 *Functionality: Acquisition SEO for AARP
 */
public class AcqSEOStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}	
	
	/**
	 *@toDo: login with user details
	 */
	@Given("^load the AARP Ulayer medicare acquisition site page url$")
	public void user_Login(DataTable Url) 
	{
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		Map<String, String> urlAttributesMap = new HashMap<String, String>();
		/*List<DataTableRow> AttributesRow = Url.getGherkinRows();
		
		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}*/
		
		urlAttributesMap = DataTableParser.readDataTableAsMaps(Url);
		String url = urlAttributesMap.get("URL");
		
       try{
    	   fetchRedirectURL(url) ;
       }catch(Exception ex){
              ex.printStackTrace();
       }
	}

	/**
	 *@toDo: fetch direct url
	 */
	public String fetchRedirectURL(String url) throws IOException {
		
		String resultUrl = url;
	    HttpURLConnection connection = null;
	    int iRedirectionCounter = 0;
	    try {
	    	trustmanager(url);
	        connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setInstanceFollowRedirects(false);
	        connection.connect();
	        int responseCode = connection.getResponseCode();
	        System.out.println("Response Code -------> "+responseCode);
	        if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
				String locationUrl = connection.getHeaderField("Location");
				System.out.println("Redirect URL -------> " + locationUrl);
				iRedirectionCounter++;
				/*if (locationUrl != null && locationUrl.trim().length() > 0) {
	            	connection.disconnect();
					resultUrl = fetchRedirectURL(locationUrl);
					System.out.println(iRedirectionCounter);*/
					if (iRedirectionCounter <= 3)
						Assertion.assertTrue("Number of redirection urls " + iRedirectionCounter, true);
					else
						Assertion.assertTrue("Number of redirection urls " + iRedirectionCounter, false);
				}
			//}
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    } 
	    finally {
	     connection.disconnect();
	    }
	    return resultUrl;
	}  

	/**
	 *@toDo: Install the all-trusting trust manager
	 */
	public static void trustmanager(String url)
	{
	
			TrustManager[] trustAllCerts = new TrustManager[]{
			    new X509TrustManager() {
			        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			            return null;
			        }
			        public void checkClientTrusted(
			            java.security.cert.X509Certificate[] certs, String authType) {
			        }
			        public void checkServerTrusted(
			            java.security.cert.X509Certificate[] certs, String authType) {
			        }
			    }
			};

			// Install the all-trusting trust manager
			try {
			    SSLContext sc = SSLContext.getInstance("SSL");
			    sc.init(null, trustAllCerts, new java.security.SecureRandom());
			    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			    HostnameVerifier hv = new HostnameVerifier() {
			    	@Override
		            public boolean verify(String urlHostName, SSLSession session) {
		                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
		                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
		                }
		                return true;
		            }
			    };
		        HttpsURLConnection.setDefaultHostnameVerifier(hv);
			    
			} catch (Exception e) {
			}
			
	}
}