/**
 * 
 */
package acceptancetests.deprecated.data;

/**
 * @author pjaising
 *
 */
public class ElementData {
	
	String identifier;
	
	String elementName;

	public ElementData(String identifier, String elementName) {
		super();
		this.identifier = identifier;
		this.elementName = elementName;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	 public ElementData() {
	    }
	
}
