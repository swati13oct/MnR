package atdd.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.Scenario;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.FlagsmithLoginPage;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

/**
 * @author schak38
 */

@Component
public class MRScenario {

	private Map<String, String> ampMemberAttributesMap = new LinkedHashMap<String, String>();

	private Map<String, String> umsMemberAttributesMap = new LinkedHashMap<String, String>();
	private Map<String, String> memberRedesignVbfAttributesMap = new LinkedHashMap<String, String>();

	private List<String> userNamesAddedList = new ArrayList<String>();

	private static Map<String, String> props = new HashMap<String, String>();

	private Map<String, Map<String, JSONObject>> expectedDataMapUlayer = new LinkedHashMap<String, Map<String, JSONObject>>();

	private Map<String, Map<String, JSONObject>> expectedDataMapBluelayer = new LinkedHashMap<String, Map<String, JSONObject>>();
	private static Map<String, String> loginCreds = new HashMap<String, String>();

	public static String environment = System.getProperty("environment");
	// public static String environment = "prod";
	public static String browsername = "chrome";
	public static String browserName;
	public static String isTestHarness;
	public static String environmentMedicare;
	public static String UserName = null;
	public static String formattedMemberString = null;
	public static String domain;
	public static String line = "";
	public static final String cvsSplitBy = ",";
	public static String compositeDesiredAttributes;
	public static String attributeMapToUse = "";
	private static final String DIRECTORY = "/src/main/resources/";
	private static final ThreadLocal<String> sessionId = new ThreadLocal<String>();
	private static final ThreadLocal<String> JobURL = new ThreadLocal<String>();
	private static final ThreadLocal<String> JobURLVD = new ThreadLocal<String>();
	public static boolean isSauceLabSelected = false;
	public static int count = 0;
	public static String sauceLabsTunnelIdentifier;
	public static String browserVersion;
	static BufferedReader memberAmpTypeReader = null;
	static BufferedReader memberUmsTypeReader = null;
	static BufferedReader memberRedesignVbfTypeReader = null;
	public static String sauceLabsMobileTunnelIdentifier;
	public static String appiumVersion;
	public static String mobileDeviceName = "";
	public static String mobileDeviceOSName = "";
	public static String mobileDeviceOSVersion = "";
	public static boolean AEP = false;
	public static boolean flagSmith = false;
	public static String flagSmithUser = "";
	public static String planYear = "";
	public static String desktopBrowserName;
//	public AppiumDriver mobileDriver;
	public String mobileSessionTimeout = "900000";
//	public static String runnerFiles = "";
	public static String mobileDeviceType;

	private static final ThreadLocal<String> runnerFileName = new ThreadLocal<>();

	public static String getRunnerFileName() {
		return runnerFileName.get();
	}

	public static void setRunnerFileName(String runnerFile) {
		runnerFileName.set(runnerFile);
	}

	public static String getTagLists() {
		GlobalBeforeHook beforeHook = new GlobalBeforeHook();
		List<String> tagsList = beforeHook.getTagsList();
		StringBuilder strbul = new StringBuilder();
		for (String str : tagsList) {
			strbul.append(str);
		}
		String tagsLists = strbul.toString();
		return tagsLists;
	}

	public static void setTagList(String tagName) {
		runnerFileName.set(tagName);
	}

	public static final String USERNAME = "gpdadmin1";

	public static final String ACCESS_KEY = "e4345a14-7675-429a-a93c-0d9bbd8409cc";

	public static String TESTOBJECTAPIKEY = "";

	public final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public final String RealDeviceURL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.us-west-1.saucelabs.com/wd/hub";

	public final String VirtualDeviceURL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.us-west-1.saucelabs.com/wd/hub";

	private static final ThreadLocal<WeakHashMap<String, Object>> scenarioObjectMap = new ThreadLocal<WeakHashMap<String, Object>>() {
		@Override
		protected WeakHashMap<String, Object> initialValue() {
			return new WeakHashMap<>();
		}
	};

	public synchronized void saveBean(String id, Object object) {
		scenarioObjectMap.get().put(id, object);
	}

	public synchronized void flushBeans() {
		if (!scenarioObjectMap.get().isEmpty()) {
//			scenarioObjectMap.get().clear();
			Iterator<Map.Entry<String, Object>> iterator = scenarioObjectMap.get().entrySet().iterator();

			// Iterate over the HashMap
			while (iterator.hasNext()) {
				// Get the entry at this iteration
				Map.Entry<String, Object> entry = iterator.next();

				// Get the object reference for the key and assign null, to make it eligible for
				// gc.
//	            Object objectReference = entry.getValue();
// 	            objectReference = objectReference != null ? null : objectReference;

				// Remove this entry from HashMap
				iterator.remove();
			}
			scenarioObjectMap.remove();
		}
	}

	private WebDriver webDriver;

	private static final ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

	public synchronized void setThreadSafeDriver(WebDriver driver) {
		threadSafeDriver.set(driver);
	}

	private static synchronized WebDriver getThreadSafeDriver() {
		return threadSafeDriver.get();
	}

	private synchronized void flushThreadSafeDriver() {
		threadSafeDriver.remove();
	}

	private static final ThreadLocal<AppiumDriver> threadSafeMobileDriver = new ThreadLocal<>();

	public synchronized void setThreadSafeMobileDriver(AppiumDriver driver) {
		threadSafeMobileDriver.set(driver);
	}

	private static synchronized AppiumDriver getThreadSafeMobileDriver() {
		return threadSafeMobileDriver.get();
	}

	private void flushThreadSafeMobileDriver() {
		threadSafeMobileDriver.remove();
	}

	private void flushSessionID() {
		sessionId.remove();
	}

	private void flushJobUrl() {
		JobURL.remove();
	}

	private void flushRunnerFileName() {
		runnerFileName.remove();
	}

	public void flushThreadLocals() {
		flushThreadSafeDriver();
		flushThreadSafeMobileDriver();
		flushSessionID();
		flushJobUrl();
		flushRunnerFileName();
	}

	public synchronized Object getBean(String id) {
		Object result = scenarioObjectMap.get().get(id);
		if (result == null) {
			System.out.println("Object not initialized - " + id);
		}
		return result;

	}

	public synchronized Object getBean(String id, Object defaultValue) {
		Object result = getBean(id);

		if (result == null) {
			return defaultValue;
		}
		return result;

	}

	static {
		props = getProperties();

		if (!(props == null)) { // when running on local this logic will be used
			System.out.println("before accessing props");
			environment = props.get("Environment");
			System.out.println("after accessing props");
			environmentMedicare = environment;
			browsername = props.get("BrowserName");
			isTestHarness = props.get("isTestHarness");
			TESTOBJECTAPIKEY = props.get("SaucelabsTestObjectAPIKey");
			mobileDeviceName = props.get("SaucelabsDeviceName");
			mobileDeviceOSName = props.get("SaucelabsDeviceOSName");
			mobileDeviceOSVersion = props.get("SaucelabsDeviceOSVersion");
			// appiumVersion = props.get(CommonConstants.APPIUM_VERSION);
			mobileDeviceType = props.get("MOBILE_DEVICE_TYPE");
		} else { // running from Jenkins will use this logic
			isTestHarness = (null == System.getProperty(CommonConstants.IS_TESTHARNESS) ? "Yes"
					: System.getProperty(CommonConstants.IS_TESTHARNESS));
			environmentMedicare = environment;
			/*
			 * appiumVersion = (null == System.getProperty(CommonConstants.APPIUM_VERSION) ?
			 * CommonConstants.APPIUM_DEFAULT_VERSION :
			 * System.getProperty(CommonConstants.APPIUM_VERSION));
			 */
			mobileDeviceType = (null == System.getProperty(CommonConstants.MOBILE_DEVICE_TYPE)
					? CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT
					: System.getProperty(CommonConstants.MOBILE_DEVICE_TYPE));
			
			sauceLabsMobileTunnelIdentifier = (null == System
					.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER)
					&& (environment.equalsIgnoreCase("stage") | environment.equalsIgnoreCase("offline"))
							| environment.equalsIgnoreCase("prod") 
					?  System.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER)
					: CommonConstants.SAUCELABS_DEFAULT_MOBILE_TUNNEL);

		}

		sauceLabsTunnelIdentifier = (null == System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER)
				? CommonConstants.SAUCELABS_DEFAULT_TUNNEL
				: System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER));

//		sauceLabsMobileTunnelIdentifier = (null == System
//				.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER)
//				&& (environment.equalsIgnoreCase("stage") | environment.equalsIgnoreCase("offline"))
//						| environment.equalsIgnoreCase("prod") 
//				?  System.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER)
//				: CommonConstants.SAUCELABS_DEFAULT_MOBILE_TUNNEL);

		appiumVersion = mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)
				? CommonConstants.APPIUM_DEFAULT_VERSION
				: (null == props ? System.getProperty(CommonConstants.APPIUM_VERSION)
						: props.get(CommonConstants.APPIUM_VERSION));

		flagSmith = null != System.getProperty(CommonConstants.FLAGSMITH)
				? Boolean.parseBoolean(System.getProperty(CommonConstants.FLAGSMITH))
				: null != props ? Boolean.parseBoolean(props.get(CommonConstants.FLAGSMITH)) : false;
		System.out.println("Flagsmith flag is " + flagSmith);

		flagSmithUser = null != System.getProperty(CommonConstants.FLAGSMITH_USER)
				? System.getProperty(CommonConstants.FLAGSMITH_USER)
				: null != props ? props.get(CommonConstants.FLAGSMITH_USER) : "";
		System.out.println("Flagsmith user is " + flagSmithUser);

		// If planYear is empty or null, it will be set in openApplicationURL
		planYear = null != System.getProperty(VPPCommonConstants.PLAN_YEAR)
				? System.getProperty(VPPCommonConstants.PLAN_YEAR)
				: null != props ? props.get(VPPCommonConstants.PLAN_YEAR) : "";

		/*
		 * appiumVersion = (null == System.getProperty(CommonConstants.APPIUM_VERSION) ?
		 * CommonConstants.APPIUM_DEFAULT_VERSION :
		 * System.getProperty(CommonConstants.APPIUM_VERSION));
		 */
//		runnerFiles = System.getenv("RUNNER_NAME");

		// Setting permission to the scripts , so that jenkins server can access
		File shellScript = new File("src/main/resources/pdfReportGenerator.sh");
		File groovyScript = new File("src/main/resources/pdfReporter.groovy");

		shellScript.setReadable(true);
		shellScript.setWritable(true);
		shellScript.setExecutable(true);

		groovyScript.setReadable(true);
		groovyScript.setWritable(true);
		groovyScript.setExecutable(true);

	}

	public List<String> getTagList() {
		GlobalBeforeHook beforeHook = new GlobalBeforeHook();
		List<String> tagsList = beforeHook.getTagsList();
		return tagsList;
	}

	public static Map<String, String> getProperties() {
		Map<String, String> props = new HashMap<String, String>();
		Properties prop = new Properties();
		String propertiesFileToPick = environment;
		System.out.println("Using properties for environment ...." + propertiesFileToPick);
		if (StringUtils.isBlank(propertiesFileToPick)) {
			System.out.println("Using CI as default since environment was not passed in !!!");
			propertiesFileToPick = CommonConstants.DEFAULT_ENVIRONMENT_CI;

			// Read properties from classpath
			StringBuffer propertyFilePath = new StringBuffer(CommonConstants.PROPERTY_FILE_FOLDER);
			System.out.println("@@@propertyFilePath@@" + propertyFilePath);
			propertyFilePath.append("/").append(propertiesFileToPick).append("/")
					.append(CommonConstants.PROPERTY_FILE_NAME);
			InputStream is = ClassLoader.class.getResourceAsStream(propertyFilePath.toString());
			System.out.println("@@@IS@@" + is);
			try {
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (String key : prop.stringPropertyNames()) {
				String value = prop.getProperty(key);
				props.put(key, value);
			}

			if (props.containsKey("Domain")) {
				domain = props.get("Domain");
			} else {
				domain = null;
			}
			return props;
		} else {

			if (environment.contains("stage-0"))
				domain = "ocp-elr-dmz-nonprod.optum.com";
			else if (environment.equals("stage") || environment.equals("stage-aarp")
					|| environment.equals("offline-stage-aarp") || environment.equals("offline-stage"))
				domain = "uhc.com";
			else if (environment.contains("mnr-acq-ci") || environment.equals("team-atest")
					|| environment.equals("team-e") || environment.equals("team-t") || environment.equals("team-v1")
					|| environment.equals("team-acme") || environment.equals("team-voc")
					|| environment.equals("team-acme") || environment.contains("digital-uat")
					|| environment.equals("team-chargers") || environment.contains("chargers")
					|| environment.contains("chargers-qa") || environment.contains("team-uhc-rx")
					|| environment.contains("digital-dev"))

				domain = "ocp-elr-core-nonprod.optum.com";
			else if (environment.contains("mnr-acq"))
				domain = "origin-elr-dmz.optum.com";
			else
				domain = "ocp-ctc-dmz-nonprod.optum.com";
			System.out.println("env chosen is: " + environment);
			System.out.println("domain chosen is: " + domain);

			return null;
		}
	}

	public static JSONObject readExpectedJson(String fileName, String directory) {

		if (fileName.contains("/")) {
			fileName = fileName.replaceAll("/", "_");
		}
		fileName = fileName + ".json";
		JSONObject jsonObject = null;
		String parentDirectory = null;
		try {
			parentDirectory = new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(parentDirectory + DIRECTORY + directory + fileName);
		} catch (FileNotFoundException e) {
			return jsonObject;
		}

		FileChannel fc = stream.getChannel();
		MappedByteBuffer bb = null;

		try {
			bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] bytes;
		if (bb.hasArray()) {
			bytes = bb.array();
		} else {
			bytes = new byte[bb.remaining()];
			bb.get(bytes);
		}
		String response = new String(bytes, Charset.forName("UTF-8"));
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Need to update here a method to replace special characters with
		// \special Characters
		try {
			if (!response.isEmpty()) {
				jsonObject = new JSONObject(response);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

	public Map<String, JSONObject> getExpectedJson(String user) {

		if (null != user && expectedDataMapUlayer.containsKey(user)) {
			return expectedDataMapUlayer.get(user);
		}

		if (null != user && expectedDataMapBluelayer.containsKey(user)) {
			return expectedDataMapBluelayer.get(user);
		} else {
			System.out.println("Expected data not set for : " + user);
			return null;
		}
	}

	public void DriverQuit() {
		// webDriver.quit();
	}

	public Map<String, String> returnMemberAttributeMap() {
		if (attributeMapToUse.equalsIgnoreCase("memberRedesignVbfAttributesMap"))
			return memberRedesignVbfAttributesMap;
		else if (attributeMapToUse.equalsIgnoreCase("ampMemberAttributesMap"))
			return ampMemberAttributesMap;
		else if (attributeMapToUse.equalsIgnoreCase("umsMemberAttributesMap"))
			return umsMemberAttributesMap;
		else
			return null;
	}

	public void CaptureScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
		System.out.println("Screenshot captured!!!");
		// To get the report embedded in the report
//		scenario.embed(screenshot, "image/png");
		scenario.attach(screenshot, "image/png", "Screenshot");

	}

	public WebDriver getWebDriverNew() {

		// !!!!! ATTENTION !!!!!
		/// If you're changing this code to get a browser to work the you're
		// doing it wrong
		// You should be able to configure a browser in whatever
		// config.preoperties file
		// you're using. You shouldn't have to change code.

		// Is system propery exists defining JENKINS_BROWSER, we're running in
		// JENKINS and
		// will prefer those browser properties.

		/*
		 * the following logic was added to determine the environment and domain to use
		 * from a single logic instead of using multiple config properties files and
		 * folders to manage the same logic The logic is if the environment is passed in
		 * from the System (when running from Jenkins) then based on the environment it
		 * associates the appropriate domain.
		 */

		String browser = (null == System.getProperty(CommonConstants.JENKINS_BROWSER)
				? props.get(CommonConstants.DESKTOP_WEBDRIVER)
				: System.getProperty(CommonConstants.JENKINS_BROWSER));

		// if the browsername is passed in from Jenkins then use that, otherwise use the
		// one from the CI config properties file
		browserName = (null == System.getProperty(CommonConstants.BROWSER_NAME) ? browsername
				: System.getProperty(CommonConstants.BROWSER_NAME));

		// if the browser version is passed in from Jenkins then use that, otherwise use
		// latest version by default
		String browserVersion = (null == System.getProperty(CommonConstants.BROWSER_VERSION) ? "latest"
				: System.getProperty(CommonConstants.BROWSER_VERSION));
		System.out.println("browser version after " + browserVersion);

		String screenResolution = (null == System.getProperty(CommonConstants.SCREEN_RESOLUTION) ? "1920x1080"
				: System.getProperty(CommonConstants.SCREEN_RESOLUTION));

		// Again, Jenkins takes precedent.
		String pathToBinary = (null == System.getProperty("phantomjs") ? "null" : System.getProperty("phantomjs"));

		System.out.println("getWebDriver: returning driver for " + browser);
		// if webDriver is null, create one, otherwise send the existing one
		// back.
		// This has to happen to preserve the state of webDriver so that we can
		// take screenshots at the end.
		// if (null == webDriver) {
		System.out.println("New WebDriver CREATED");

		// Choose your browser based on name. The name value is what is in
		// CommonConstants.
		// If the browser isn't configured (null) or it's set to HTMLUNIT,
		// use HTMLUNIT.
		// This is the default browser when I checked out the code, so it's
		// the default
		if (browser.equalsIgnoreCase(CommonConstants.FIREFOX_BROWSER)) {

			System.setProperty("webdriver.gecko.driver", "pathToBinary");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
//			webDriver = new FirefoxDriver(capabilities);
			threadSafeDriver.set(new FirefoxDriver(capabilities));

//			webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			getThreadSafeDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//			webDriver.get("google.com");
			getThreadSafeDriver().get("google.com");

		} else if (browser.equalsIgnoreCase(CommonConstants.CHROME_BROWSER)) {
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			// chromeOptions.put("binary", pathToBinary);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			// System.setProperty("webdriver.chrome.driver", pathToBinary);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hahire\\Downloads\\driver\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\ProgramData\\Chrome_driver_80.0.3987.16\\chromedriver.exe");
//			webDriver = new ChromeDriver();
			threadSafeDriver.set(new ChromeDriver());
			saveBean(CommonConstants.WEBDRIVER, getThreadSafeDriver());
			// return webDriver;

		} else if (browser.equalsIgnoreCase(CommonConstants.CHROME_BROWSER)) {
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("binary", pathToBinary);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			System.setProperty("webdriver.chrome.driver", pathToBinary);
//			webDriver = new ChromeDriver();
			threadSafeDriver.set(new ChromeDriver());
			saveBean(CommonConstants.WEBDRIVER, getThreadSafeDriver());
			// return webDriver;

		} else if (browser.equalsIgnoreCase(CommonConstants.MOBILE_BROWSER)) {
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", props.get(CommonConstants.DEVICE_NAME));
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			System.setProperty("webdriver.chrome.driver", props.get(CommonConstants.CHROME_DRIVER));
//			webDriver = new ChromeDriver(capabilities);
			threadSafeDriver.set(new ChromeDriver(capabilities));
			// return webDriver;
		} else if (browser.equalsIgnoreCase(CommonConstants.SAUCE_BROWSER_WEB)) {
			System.out.println("Execution is Going to Start on SauceLabs Web.....!!!!!");
			isSauceLabSelected = true;
			DesiredCapabilities capabilities = null;
			if (browserName.equalsIgnoreCase("firefox")) {
				System.out.println("Inside firefox");
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("version", browserVersion);
				capabilities.setCapability("screenResolution", "1440x900");
				capabilities.setCapability("maxDuration", "3600");
			} else if (browserName.equalsIgnoreCase("IE")) {
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("version", browserVersion);
				capabilities.setCapability("screenResolution", "1920x1080");
				capabilities.setCapability("maxDuration", "3600");
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.out.println("Inside chrome");
				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("version", browserVersion);
				capabilities.setCapability("screenResolution", "1920x1080");
				capabilities.setCapability("recordMp4", true);
				capabilities.setCapability("maxDuration", "10000");
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.out.println("Inside Edge");
				capabilities = DesiredCapabilities.edge();
				capabilities.setCapability("platform", "Windows 10");
				capabilities.setCapability("version", browserVersion);
				capabilities.setCapability("screenResolution", "1920x1080");
				capabilities.setCapability("maxDuration", "3600");
			} else if (browserName.equalsIgnoreCase("safari")) {
				System.out.println("Inside safari");
				capabilities = DesiredCapabilities.safari();

				MutableCapabilities sauceOptions = new MutableCapabilities();
				sauceOptions.setCapability("screenResolution", "1920x1440");
				sauceOptions.setCapability("maxDuration", 7200);
				sauceOptions.setCapability("idleTimeout", 200);

				SafariOptions browserOptions = new SafariOptions();
				browserOptions.setCapability("platformName", "macOS 11.00");
				browserOptions.setCapability("browserVersion", browserVersion);
				browserOptions.setCapability("sauce:options", sauceOptions);
				capabilities.merge(browserOptions);
			}
			if (!(null == capabilities)) {
				capabilities.setCapability("autoAcceptsAlerts", true);
				// capabilities.setCapability("parent-tunnel", "sauce_admin");
				if (environment.equals("stage") || environment.equals("offline") || environment.equals("prod")) {
					capabilities.setCapability("parent-tunnel", "");
					capabilities.setCapability("tunnelIdentifier", "");
				}

				else {
					capabilities.setCapability("parent-tunnel", "optumtest");
					capabilities.setCapability("tunnelIdentifier", sauceLabsTunnelIdentifier);
				}

				// capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
				capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));

				// ---begin - enable logging - needed by predators - do not remove this portion
				// note: commandTimeout=how long to run a command (unit second, default 300)
				// capabilities.setCapability("commandTimeout", "400");
				// note: idleTimeout=how long to wait before sending next command (unit second,
				// default 90)
				capabilities.setCapability("idleTimeout", "200");
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
				capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				// ---end - enable logging

				String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  "
						+ System.getProperty("environment") + " environment";
				capabilities.setCapability("name", jobName);
				try {
					RemoteWebDriver webDriver = new RemoteWebDriver(new URL(URL), capabilities);
//					threadSafeDriver.set(new RemoteWebDriver(new URL(URL), capabilities));
					setThreadSafeDriver(webDriver);
//					setThreadSafeDriver(new RemoteWebDriver(new URL(URL), capabilities));
					// sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
//					sessionId.set(((RemoteWebDriver) getThreadSafeDriver()).getSessionId().toString());
					setThreadLocalSessionId(webDriver);
					System.out.println("Session ID:" + getThreadLocalSessionId());
//					getJobURL(getThreadLocalSessionId());
					setJobURL(getThreadLocalSessionId());
//					saveBean(CommonConstants.WEBDRIVER, webDriver);
				} catch (MalformedURLException e) {
					Assert.fail("Invalid Sauce URL: [" + URL + "]");
				}
			} else
				Assert.fail(
						"Error in setting capabilities due to unidentified browser. Check your browser and/or Jenkins job pipeline script to make sure browser is added in the build command");
		}
		// return webDriver;
		return getThreadSafeDriver();
	}

	private synchronized void setThreadLocalSessionId(RemoteWebDriver driver) {
		sessionId.set(driver.getSessionId().toString());
	}

	public synchronized String getThreadLocalSessionId() {
		// return sessionId;
		return sessionId.get();
	}

	public synchronized String returnJobURL() {
//		return JobURL;
		if (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_VIRTUAL)
				&& getThreadSafeMobileDriver() != null) {
			return JobURLVD.get();
		} else {
			return JobURL.get();
		}

	}

	public synchronized void setJobURL(String jobID) {
		String digest = hmacDigest(jobID, USERNAME + ":" + ACCESS_KEY, "HmacMD5");
		if (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_VIRTUAL)
				&& getThreadSafeMobileDriver() != null) {
			JobURLVD.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
		} else {
			JobURL.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
		}
		System.out.println("JobURL --- " + returnJobURL());
	}

	/*
	 * public void getJobURL(String jobID) { String digest = hmacDigest(jobID,
	 * USERNAME + ":" + ACCESS_KEY, "HmacMD5"); // JobURL =
	 * "https://saucelabs.com/jobs/" + jobID + "?auth=" + digest; //
	 * System.out.println("JobURL ---" + JobURL);
	 * JobURL.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
	 * System.out.println("JobURL ---" + returnJobURL()); }
	 *
	 * public void getVDJobURL(String jobID) { String digest = hmacDigest(jobID,
	 * USERNAME + ":" + ACCESS_KEY, "HmacMD5"); // JobURLVD =
	 * "https://saucelabs.com/tests/" + jobID + "?auth=" + digest; //
	 * System.out.println("JobURL ---" + JobURLVD);
	 * JobURLVD.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
	 * System.out.println("JobURL ---" + returnJobURL()); }
	 */

	public String hmacDigest(String msg, String keyString, String algo) {
		String digest = null;
		try {
			SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
			Mac mac = Mac.getInstance(algo);
			mac.init(key);

			byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

			StringBuffer hash = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			}
			digest = hash.toString();
		} catch (UnsupportedEncodingException e) {
		} catch (InvalidKeyException e) {
		} catch (NoSuchAlgorithmException e) {
		}
		return digest;
	}

	/**
	 * @author Murali - mmurugas This method will invoke the Appium driver for
	 *         Mobile automation
	 */
	public AppiumDriver getMobileDriver() {
		if (props == null) {
			TESTOBJECTAPIKEY = System.getenv("SAUCSLABS_TESTOBJECT_APIKEY");
			mobileDeviceName = System.getenv("DEVICE_NAME");
			mobileDeviceOSName = System.getenv("DEVICE_OS_NAME");
			mobileDeviceOSVersion = System.getenv("DEVICE_OS_VERSION");
			mobileDeviceType = System.getenv(CommonConstants.MOBILE_DEVICE_TYPE);
			appiumVersion = System.getenv(CommonConstants.APPIUM_VERSION);
			if (System.getenv(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER) != null)
				sauceLabsMobileTunnelIdentifier = System.getenv(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER);
		}

		System.out.println("Launching Device : " + mobileDeviceName);
		isSauceLabSelected = true;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("testobject_api_key", TESTOBJECTAPIKEY);
		capabilities.setCapability("privateDevicesOnly", "true");
		capabilities.setCapability("noReset", "false");
		// max 30 mins for device allocation - mobileSessionTimeout
		capabilities.setCapability("testobject_session_creation_timeout", mobileSessionTimeout);
		// capabilities.setCapability("testobject_suite_name", "PRE");
		// capabilities.setCapability("testobject_test_name", mobileTestName);
		// Either Optum-Prd or Optum-Stage tunnels to be used
		System.out.println("sauceLabsMobileTunnelIdentifier : " + sauceLabsMobileTunnelIdentifier);
		capabilities.setCapability("parentTunnel", "optumtest");
		capabilities.setCapability("tunnelIdentifier", sauceLabsMobileTunnelIdentifier);
		capabilities.setCapability("nativeWebTap", true);
		capabilities.setCapability("deviceName", mobileDeviceName);
		capabilities.setCapability("platformName", mobileDeviceOSName);
		capabilities.setCapability("platformVersion", mobileDeviceOSVersion);
//		capabilities.setCapability("locationContextEnabled", "false");
		// capabilities.setCapability("AUTOMATION_NAME", "XCUITest");
		capabilities.setCapability("commandTimeout", 600);
		capabilities.setCapability("maxDuration", 10800);
		capabilities.setCapability("idleTimeout", 1000);
		capabilities.setCapability("priority", 0);
		capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
		String jobName = System.getProperty("user.name") + " Mobile Execution - Using " + mobileDeviceName + " in  "
				+ sauceLabsMobileTunnelIdentifier + " environment";
		capabilities.setCapability("name", jobName);
		capabilities.setCapability("recordMp4", true);
		capabilities.setCapability("appiumVersion", appiumVersion);
		capabilities.setCapability("forceMjsonwp", true);
		// capabilities.setCapability("autoAcceptAlerts", true);
//		if (environment.equals("stage") || environment.equals("offline") || environment.equals("prod")) {
//			capabilities.setCapability("parentTunnel", "");
//			capabilities.setCapability("tunnelIdentifier", "");
//		}
//
//		else {
//			capabilities.setCapability("parentTunnel", "optumtest");
//			capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
//		}

		try {

			String SauceLabsURL = (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)
					? RealDeviceURL
					: VirtualDeviceURL);

			if (mobileDeviceOSName.equalsIgnoreCase("Android")) {
				capabilities.setCapability("browserName", "Chrome");
				capabilities.setCapability("enablePerformanceLogging", true);
				browserName = "Chrome";
//				mobileDriver = new AndroidDriver(new URL(SauceLabsURL), capabilities);

				AppiumDriver mobileDriver = new AndroidDriver(new URL(SauceLabsURL), capabilities);
				// Adding the below condition to debug NPE for driver
				if (mobileDriver == null) {
					Assertion.fail("Android driver was not created !");
				} else {
					setThreadSafeMobileDriver(mobileDriver);
				}

			} else {
				capabilities.setCapability("browserName", "Safari");
				capabilities.setCapability("autoAcceptAlerts", "true");
				capabilities.setCapability("safariAllowPopups", "true");
				capabilities.setCapability("locationServicesEnabled", "true");
				capabilities.setCapability("locationServicesAuthorized", "true");
				// capabilities.setCapability("webviewConnectTimeout", "90000");
				// capabilities.setCapability("enablePerformanceLogging", true); This capability
				// was required for deep link validation but for iOS it not working so
				// commenting out
				browserName = "Safari";
//				mobileDriver = new IOSDriver(new URL(SauceLabsURL), capabilities);
				AppiumDriver mobileDriver = new IOSDriver(new URL(SauceLabsURL), capabilities);
				// Adding the below condition to debug NPE for driver
				if (mobileDriver == null) {
					Assertion.fail("iOS driver was not created !");
				} else {
					setThreadSafeMobileDriver(mobileDriver);
				}
			}
//			System.out.println("Session ID --- " + mobileDriver.getSessionId());
			System.out.println("Session ID --- " + getThreadSafeMobileDriver().getSessionId().toString());

			if (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)) {
				/*
				 * JobURL= (String)
				 * mobileDriver.getCapabilities().getCapability("testobject_test_report_url");
				 * System.out.println(mobileDeviceName + " JobURL  --- " + JobURL);
				 */

				JobURL.set((String) getThreadSafeMobileDriver().getCapabilities()
						.getCapability("testobject_test_report_url"));
				System.out.println(mobileDeviceName + " JobURL  --- " + returnJobURL());
				// System.out.println("JobReportURL ---
				// "+mobileDriver.getCapabilities().getCapability("testobject_test_live_view_url"));
				// System.out.println("APIURL ---
				// "+mobileDriver.getCapabilities().getCapability("testobject_test_report_api_url"));
//				System.out.println(mobileDriver.getContext());
				System.out.println(getThreadSafeMobileDriver().getContext());
			} else {

				// JobURLVD = ("https://app.saucelabs.com/tests/"
				// + mobileDriver.getSessionId());
				// System.out.println("SEE TEST EXECUTION HERE:***" +JobURLVD);
				//
//				System.out.println("Session ID:" + ((mobileDriver).getSessionId()).toString());
				sessionId.set(getThreadSafeMobileDriver().getSessionId().toString());
//				System.out.println("Session ID:" + getThreadLocalSessionId());
//				getVDJobURL(((mobileDriver).getSessionId()).toString());
//				getVDJobURL(getThreadLocalSessionId());
				setJobURL(getThreadLocalSessionId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return mobileDriver;
		return getThreadSafeMobileDriver();
	}

	public static Map<String, String> getProps() {
		return props;
	}

	private String getFlagsmithApplicationUrl(String site) {
		switch (MRScenario.environment.toLowerCase()) {
		case "stage-0":
			return site.equalsIgnoreCase("AARP") ? MRConstants.FLAGSMITH_STAGE0_AARP_URL
					: MRConstants.FLAGSMITH_STAGE0_UHC_URL;
		case "offline":
			return site.equalsIgnoreCase("AARP") ? MRConstants.FLAGSMITH_OFFLINE_PROD_AARP_URL
					: MRConstants.FLAGSMITH_OFFLINE_PROD_UHC_URL;
		case "prod":
			return site.equalsIgnoreCase("AARP") ? MRConstants.FLAGSMITH_PROD_AARP_URL
					: MRConstants.FLAGSMITH_PROD_UHC_URL;
		default:
			return site.equalsIgnoreCase("AARP") ? MRConstants.FLAGSMITH_AARP_URL : MRConstants.FLAGSMITH_UHC_URL;
		}
	}

	private FlagsmithLoginPage openFlagSmithLoginPage(WebDriver driver, String site) {
		String flagSmithURL = getFlagsmithApplicationUrl(site);
		driver.get(flagSmithURL);
		return new FlagsmithLoginPage(driver);
	}

	public String getSystemDateForAEP(String systemDateUrl) {
		String systemDate = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(systemDateUrl);
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
				JSONObject responseJson = new JSONObject(responseString);

				JSONObject dataObj = responseJson.getJSONObject("data");
				systemDate = dataObj.get("systemDate").toString().split(" ")[0];
				/*
				 * int lastIndex = systemDate.lastIndexOf("/"); systemDate =
				 * systemDate.substring(0, lastIndex);
				 */
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return systemDate;
	}

	private String getSystemAPIUrl(String site) {
		switch (MRScenario.environment.toLowerCase()) {
		case "stage-0":
			return site.equalsIgnoreCase("AARP") ? MRConstants.STAGE0_AARP_SYSTEM_DATE_URL
					: MRConstants.STAGE0_UHC_SYSTEM_DATE_URL;
		case "offline":
			return site.equalsIgnoreCase("AARP") ? MRConstants.OFFLINE_PROD_AARP_SYSTEM_DATE_URL
					: MRConstants.OFFLINE_PROD_UHC_SYSTEM_DATE_URL;
		case "prod":
			return site.equalsIgnoreCase("AARP") ? MRConstants.PROD_AARP_SYSTEM_DATE_URL
					: MRConstants.PROD_UHC_SYSTEM_DATE_URL;
		default:
			return site.equalsIgnoreCase("AARP") ? MRConstants.AARP_SYSTEM_DATE_URL : MRConstants.UHC_SYSTEM_DATE_URL;
		}
	}

	private String getPlanYear(String site) {
		String planYear;

		String systemDateUrl = getSystemAPIUrl(site);
		String systemDate = getSystemDateForAEP(systemDateUrl);
		String systemYear = systemDate.substring(systemDate.lastIndexOf("/"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		LocalDate currentSystemDate = LocalDate.parse(systemDate, formatter);
		LocalDate JAN_1 = LocalDate.parse(MRConstants.SERVER_DATE_JAN_1 + systemYear, formatter);
		LocalDate SEP_30 = LocalDate.parse(MRConstants.SERVER_DATE_SEP_30 + systemYear, formatter);
		LocalDate OCT_15 = LocalDate.parse(MRConstants.SERVER_DATE_OCT_15 + systemYear, formatter);

		planYear = currentSystemDate.isBefore(OCT_15) ? "current" : "next";
		AEP = currentSystemDate.isAfter(SEP_30) || currentSystemDate.isBefore(JAN_1) ? true : false;
//		saveBean(VPPCommonConstants.PLAN_YEAR, planYear);
		return planYear;
	}

	public Object openApplicationURL(WebDriver driver, String site) {

		// Commenting for now
		/*
		 * if (StringUtils.isEmpty(planYear)) { planYear = getPlanYear(site); }
		 * System.out.println("Plan Year selected " + planYear);
		 */

		if (flagSmith) {
			FlagsmithLoginPage flagsmithLoginPage = openFlagSmithLoginPage(driver, site);
			return flagsmithLoginPage.startFlagSmithUserTest(flagSmithUser);
		} else {
			String driverType = driver.getClass().toString().toUpperCase();
			return driverType.contains("IOS") || driverType.contains("ANDROID")
					? new AcquisitionHomePageMobile(driver, site)
					: new AcquisitionHomePage(driver, site);
		}
	}

}