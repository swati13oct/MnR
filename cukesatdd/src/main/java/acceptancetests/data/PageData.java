/**
 * 
 */
package acceptancetests.data;

import java.util.Map;

/**
 * @author pjaising
 *
 */
public class PageData {
	
	String url;
	
	Map<String, ElementData> expectedData;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, ElementData> getExpectedData() {
		return expectedData;
	}

	public void setExpectedData(Map<String, ElementData> expectedData) {
		this.expectedData = expectedData;
	}
	

}
