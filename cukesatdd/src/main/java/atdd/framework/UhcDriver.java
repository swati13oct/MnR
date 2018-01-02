/**
 * 
 */
package atdd.framework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author pjaising
 *
 */
public abstract class UhcDriver {

	public static WebDriver driver;

	public void start(String url) {
		System.out.println("**************** "+driver.getCurrentUrl());
		driver.get(url);
		System.out.println("++++++++++++++++ "+driver.getCurrentUrl());
		//driver.manage().window().maximize();
	}

	public UhcDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5000L);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public WebDriver switchToNewIframe(String iframeName) {
		return driver.switchTo().frame(iframeName);

	}

	public WebDriver switchToNewIframe(WebElement iframeElement) {
		return driver.switchTo().frame(iframeElement);

	}

	public boolean elementFound(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
				return false;
			}

		} catch (Exception e) {
			driver.quit();
			System.out.println("Element not found/not visible");
		}
		return false;
	}

	public void sendkeys(WebElement element, String message) {
		element.click();
		element.clear();
		element.sendKeys(message);

	}

	public void select(WebElement element, String message) {
		element.click();
		element.sendKeys(message);
	}

	public void selectFromDropDown(List<WebElement> elementList, String value) {
		for (WebElement element : elementList) {
			if (element.getText().contains(value)) {
				element.click();
				break;
			}
		}

	}

	public boolean validate(WebElement element) {

		// this.waitforElement(element);

		if (element.isDisplayed()) {
			System.out.println("The element" + element.getText() + "is found");
			return true;
		} else {
			Assert.fail("The element " + element.getText() + "is not found");
		}
		return false;
	}

	public boolean validateNew(WebElement element) {

		// this.waitforElement(element);
		try {
		//	this.waitforElement(element);
Thread.sleep(3000);			if (element.isDisplayed()) {

				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				actions.perform();
				System.out.println("@@@The element " + element.getText() + "is found@@@");

			}
		} catch (Exception e) {

	Assert.fail("The element " + element.getText() + "is not  found");

		}		return false;
	}

	public WebElement findElement(ElementData elementData) {
		WebElement element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				element = driver.findElement(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.name(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.tagName(elementData.getElementName()));
			}

			return element;
		} catch (Exception e) {
			return null;
		}

	}

	public WebElement findChildElement(ElementData elementData, WebElement parentElement) {
		WebElement element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.linkText(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.name(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.tagName(elementData.getElementName()));

			}
			return element;
		} catch (Exception e) {
			return element;
		}
	}

	
public void jsClick(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}public List<WebElement> findChildElements(ElementData elementData,
			WebElement parentElement) {		List<WebElement> element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.name(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.tagName(elementData.getElementName()));
			}
			return element;
		} catch (Exception e) {
			return element;
		}
	}

	public List<WebElement> findElements(ElementData elementData) {
		List<WebElement> element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElements(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElements(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElements(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = driver.findElements(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = driver.findElements(By.name(elementData.getElementName()));
			} else if (elementData.getIdentifier().contains("select:")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				String[] identifierArr = elementData.getIdentifier().split(":");
				if (identifierArr[1].equalsIgnoreCase("className")) {
					WebElement selectElement = driver.findElement(By.className(elementData.getElementName()));
					Select select = new Select(selectElement);
					element = select.getOptions();
				} else if (identifierArr[1].equalsIgnoreCase("id")) {
					WebElement selectElement = driver.findElement(By.id(elementData.getElementName()));
					Select select = new Select(selectElement);
					element = select.getOptions();
				}
			}
			return element;
		} catch (Exception e) {
			return element;
		}
	}

	public WebElement findDynamicElement(By locator) {
		WebElement element = null;
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("base.timeout", "1")))
				.withTimeout(Long.parseLong(System.getProperty("base.timeout", "1")), TimeUnit.SECONDS);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return element;
		}

		return element;
	}

	public String currentUrl() {
		System.out.println("******************"+driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Cookie getCookieName(String cookieName) {
		return driver.manage().getCookieNamed(cookieName);
	}

	public abstract void openAndValidate() throws InterruptedException;

	/*
	 * Generic method to capture the dtm data both static and dynamic. The
	 * variable dtm files are kept under page-objects/dtm-common-data/ Currently
	 * only member and aquisition files are there. More foles can be added if
	 * required. Input params are fileName: Json file name containing the web
	 * elements names and id, so that they can be read from current page.
	 * filePath: Path to the folder containing fileName dtmFilePath: Json file
	 * name containing the dynamic dtm tags variable and their path dtmDir: Path
	 * to the dtmFilePath
	 */
	public JSONObject getDTMPageJson(String fileName, String filePath, String dtmFilePath, String dtmDir) {
		PageData pageData = CommonUtility.readPageData(fileName, filePath);
		JSONObject jsonObject = new JSONObject();
		for (String key : pageData.getExpectedData().keySet()) {
			WebElement element = findElement(pageData.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {

					JSONObject dtmObject = new JSONObject();
					if (element.getAttribute("dtmname") != null && element.getAttribute("dtmid") != null) {
						try {
							dtmObject.put("dtmid", element.getAttribute("dtmid"));
							dtmObject.put("dtmname", element.getAttribute("dtmname"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						try {
							jsonObject.put(key, dtmObject);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("DTM id or DTM name was not found for Element:" + key);
					}

				} else {
					System.out.println("Validation failed for element::" + key);
				}
			}
		}

		try {
			jsonObject.put("dtmPageData", CommonUtility.checkForVariable(driver, dtmFilePath, dtmDir));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	public static HashMap<String, String> read_excel(String filepath, int sheetnumber) {
		String key = null;
		String value = null;
		List<String> keyList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		Cell cell = null;
		HashMap<String, String> map = new HashMap<String, String>();
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(filepath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		HSSFSheet sheet = workbook.getSheetAt(sheetnumber);
		Row row = sheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				// System.out.print(cell.getBooleanCellValue() + "\t\t");
				key = Boolean.toString(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				// System.out.print(cell.getNumericCellValue() + "\t\t");
				key = Double.toString(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				// System.out.print(cell.getStringCellValue() + "\t\t");
				key = cell.getStringCellValue();
				break;

			}
			keyList.add(key);
		}
		int len = keyList.size();
		row = sheet.getRow(1);
		cellIterator = row.cellIterator();
		for (int i = 0; i < len; i++) {
			cell = row.getCell(i);
			try {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					// System.out.print(cell.getBooleanCellValue() + "\t\t");
					value = Boolean.toString(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// System.out.print(cell.getNumericCellValue() + "\t\t");
					value = Double.toString(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					// System.out.print(cell.getStringCellValue() + "\t\t");
					value = cell.getStringCellValue();
					break;

				}
				valueList.add(value);
			} catch (java.lang.NullPointerException e) {
				valueList.add(null);
			}
		}
		for (int i = 0; i < keyList.size(); i++) {
			map.put(keyList.get(i), valueList.get(i));
			System.out.println(keyList.get(i) + "==>" + valueList.get(i));
		}
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static HashMap<String, String> read_excel(String filepath, int sheetnumber, int rowNumber) {
		String key = null;
		String value = null;
		List<String> keyList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		Cell cell = null;
		HashMap<String, String> map = new HashMap<String, String>();
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(filepath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		HSSFSheet sheet = workbook.getSheetAt(sheetnumber);
		Row row = sheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				// System.out.print(cell.getBooleanCellValue() + "\t\t");
				key = Boolean.toString(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				// System.out.print(cell.getNumericCellValue() + "\t\t");
				key = Double.toString(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				// System.out.print(cell.getStringCellValue() + "\t\t");
				key = cell.getStringCellValue();
				break;

			}
			keyList.add(key);
		}
		int len = keyList.size();
		row = sheet.getRow(rowNumber);
		cellIterator = row.cellIterator();
		for (int i = 0; i < len; i++) {
			cell = row.getCell(i);
			try {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					// System.out.print(cell.getBooleanCellValue() + "\t\t");
					value = Boolean.toString(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					// System.out.print(cell.getNumericCellValue() + "\t\t");
					value = Double.toString(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					// System.out.print(cell.getStringCellValue() + "\t\t");
					value = cell.getStringCellValue();
					break;

				}
				valueList.add(value);
			} catch (java.lang.NullPointerException e) {
				valueList.add(null);
			}
		}
		for (int i = 0; i < keyList.size(); i++) {
			map.put(keyList.get(i), valueList.get(i));
			System.out.println(keyList.get(i) + "==>" + valueList.get(i));
		}

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

}
