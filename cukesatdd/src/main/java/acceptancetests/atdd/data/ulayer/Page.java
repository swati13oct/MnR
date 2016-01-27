/**
 * 
 */
package acceptancetests.atdd.data.ulayer;

/**
 * @author pjaising
 *
 */
public class Page {

	String pageName;
	
	String directory;
	
	public Page(String pageName, String directory) {
		super();
		this.pageName = pageName;
		this.directory = directory;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
}
