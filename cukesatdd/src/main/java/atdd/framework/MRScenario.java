package atdd.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
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
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.Scenario;
import java.security.*;
import javax.crypto.*;

/**
 * 
 * @author schak38
 *
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
	public static String browsername = "chrome";
	public static String browserName;
	public static String isTestHarness;
	public static String environmentMedicare;
	public static String isHSIDCompatible;
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

	public static final String USERNAME = "ucpadmin";

	public static final String ACCESS_KEY = "2817affd-616e-4c96-819e-4583348d7b37";

	public static String TESTOBJECTAPIKEY = "";

	public static final String HSID_ENV = "PDB_STAGE";
	public static final String HSIDDB_USERNAME = "njain112";
	public static final String HSIDDB_PASSWORD = "aK6-VBYn";
	public static final String HSIDDB_URL = "jdbc:mysql://dbsls0495:3306/ogns";

	// public final String USERNAME = System.getenv("SAUCE_USERNAME");

	// public final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	public final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public final String RealDeviceURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com/wd/hub";
	public final String VirtualDeviceURL = "http://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.saucelabs.com:80/wd/hub";

	
	private static final ThreadLocal<WeakHashMap<String, Object>> scenarioObjectMap = new ThreadLocal<WeakHashMap<String, Object>>() {
		@Override
		protected WeakHashMap<String, Object> initialValue() {
			return new WeakHashMap<>();
		}
	};
	
	public void saveBean(String id, Object object) {
		scenarioObjectMap.get().put(id, object);
	}

	public synchronized void flushBeans() {
		if (!scenarioObjectMap.get().isEmpty()) {
//			scenarioObjectMap.get().clear();
			Iterator<Map.Entry<String, Object>>
					iterator = scenarioObjectMap.get().entrySet().iterator();

			// Iterate over the HashMap
			while (iterator.hasNext()) {
				// Get the entry at this iteration
				Map.Entry<String, Object>
						entry = iterator.next();

				//Get the object reference for the key and assign null, to make it eligible for gc.
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
	
	public static synchronized WebDriver getThreadSafeDriver() {
		return threadSafeDriver.get();
	}
	
	public void flushThreadSafeDriver() {
		threadSafeDriver.remove();
	}
	
	
	private static final ThreadLocal<AppiumDriver> threadSafeMobileDriver = new ThreadLocal<>();
	
	public synchronized AppiumDriver getThreadSafeMobileDriver() {
		return threadSafeMobileDriver.get();
	}
	
	public void flushThreadSafeMobileDriver() {
		threadSafeMobileDriver.remove();
	}
	
	
	public void flushSessionID() {
		sessionId.remove();
	}
	
	public void flushJobUrl() {
		JobURL.remove();
	}
	
	public void flushRunnerFileName() {
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
			isHSIDCompatible = props.get("isHSIDCompatible");
			TESTOBJECTAPIKEY = props.get("SaucelabsTestObjectAPIKey");
			mobileDeviceName = props.get("SaucelabsDeviceName");
			mobileDeviceOSName = props.get("SaucelabsDeviceOSName");
			mobileDeviceOSVersion = props.get("SaucelabsDeviceOSVersion");
			// appiumVersion = props.get(CommonConstants.APPIUM_VERSION);
			mobileDeviceType = props.get("MOBILE_DEVICE_TYPE");
		} else { // running from Jenkins will use this logic
			isTestHarness = (null == System.getProperty(CommonConstants.IS_TESTHARNESS) ? "Yes"
					: System.getProperty(CommonConstants.IS_TESTHARNESS));
			isHSIDCompatible = (null == System.getProperty(CommonConstants.IS_HSID_COMPATIBLE) ? "Yes"
					: System.getProperty(CommonConstants.IS_HSID_COMPATIBLE));
			environmentMedicare = environment;
			/*
			 * appiumVersion = (null == System.getProperty(CommonConstants.APPIUM_VERSION) ?
			 * CommonConstants.APPIUM_DEFAULT_VERSION :
			 * System.getProperty(CommonConstants.APPIUM_VERSION));
			 */
			mobileDeviceType = (null == System.getProperty(CommonConstants.MOBILE_DEVICE_TYPE)
					? CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT
					: System.getProperty(CommonConstants.MOBILE_DEVICE_TYPE));

		}

		sauceLabsTunnelIdentifier = (null == System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER)
				? CommonConstants.SAUCELABS_DEFAULT_TUNNEL
				: System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER));

		sauceLabsMobileTunnelIdentifier = (null == System
				.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER)
						? CommonConstants.SAUCELABS_DEFAULT_MOBILE_TUNNEL
						: System.getProperty(CommonConstants.SAUCELABS_MOBILE_TUNNEL_IDENTIFIER));

		appiumVersion = mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)
				? CommonConstants.APPIUM_DEFAULT_VERSION
				: (null == props ? System.getProperty(CommonConstants.APPIUM_VERSION)
						: props.get(CommonConstants.APPIUM_VERSION));

	

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

	public void loadCSV() {
		// GlobalBeforeHook.beforeGlobal(scenario);
		String csvName = getCsvName();
		System.out.println(csvName);
		putCsv(csvName);

	}

	private void putCsv(String csvName) {
		InputStream memberTypeStream1 = ClassLoader.class.getResourceAsStream("/database/" + csvName);
		memberUmsTypeReader = new BufferedReader(new InputStreamReader(memberTypeStream1));
		System.out.println("Inside ..........." + csvName);
		try {
			while ((line = memberUmsTypeReader.readLine()) != null) {
				formattedMemberString = formatMemberData(line, formattedMemberString);
				umsMemberAttributesMap.put(formattedMemberString, UserName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getTagList() {
		GlobalBeforeHook beforeHook = new GlobalBeforeHook();
		List<String> tagsList = beforeHook.getTagsList();
		return tagsList;
	}

	public String getCsvName() {
		GlobalBeforeHook beforeHook = new GlobalBeforeHook();
		String csvName = null;
		List<String> tagsList = beforeHook.getTagsList();
		System.out.println(tagsList.size());
		Iterator<String> it = tagsList.iterator();
		while (it.hasNext()) {

			String tagName = it.next();

			if (environment.contains("mnr-acq-ci")) {
				csvName = "MemberRedesign-VBF-Teamci.csv";

			} else if ((environment.equalsIgnoreCase("team-e")) || (environment.equalsIgnoreCase("team-f"))
					|| (environment.equalsIgnoreCase("team-g")) || (environment.equalsIgnoreCase("team-c"))
					|| (environment.equalsIgnoreCase("team-acme")) || (environment.equalsIgnoreCase("team-voc"))
					|| (environment.equalsIgnoreCase("team-t"))

					|| (environment.equalsIgnoreCase("team-chargers"))
					|| (environment.equalsIgnoreCase("team-avengers-plm"))
					|| (environment.equalsIgnoreCase("chargers-qa")) || (environment.equalsIgnoreCase("team-uhc-rx"))) {
				csvName = "MemberRedesign-UUID.csv";
			} else if (tagName.equalsIgnoreCase("@MemberVBF") && environment.contains("stage")) {
				csvName = "MemberRedesign-VBF.csv";
			} else if (environment.equalsIgnoreCase("team-h") || environment.equalsIgnoreCase("team-atest")) {
				csvName = "UMS-Member-Type.csv";
			} /*
				 * 
				 * 
				 * note: Dec2018 - comment out because this section caused stage run not to use
				 * UMS-Member-Type.csv else{ if
				 * (tagName.equalsIgnoreCase("@benefitsAndCoverage")) { csvName =
				 * "benefitsAndCoverage.csv"; }
				 * 
				 * else if (tagName.equalsIgnoreCase("@profileAndPreferences")) { csvName =
				 * "profileAndPreferences.csv"; }
				 * 
				 * else if (tagName.equalsIgnoreCase("@claimsSummary")) { csvName =
				 * "claimsSummary.csv"; }
				 * 
				 * }
				 */
		}
		if (csvName != null)
			return csvName;
		else
			csvName = "UMS-Member-Type.csv";
		return csvName;

	}

	public String formatMemberData(String line, String formattedMemberString) {
		formattedMemberString = "";
		String[] memberAttributes = line.split(cvsSplitBy);

		/*
		 * for (int i = 0; i <= memberAttributes.length - 2; i++) { if (2 ==
		 * memberAttributes.length || i == memberAttributes.length - 2) {
		 * formattedMemberString = formattedMemberString.concat(memberAttributes[i]); }
		 * else { if (i != memberAttributes.length - 2) formattedMemberString =
		 * formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy); } }
		 */
		for (int i = 1; i <= memberAttributes.length - 1; i++) {
			if (2 == memberAttributes.length || i == memberAttributes.length - 1) {
				formattedMemberString = formattedMemberString.concat(memberAttributes[i]);
			} else {
				if (i != memberAttributes.length - 1)
					formattedMemberString = formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
			}
		}
		// System.out.println("formattedMemberString---" + formattedMemberString);
		UserName = null;
		// UserName = memberAttributes[memberAttributes.length - 1];
		UserName = memberAttributes[0];
		return formattedMemberString;
	}

	public String formatMemberData(String line) {
		String formattedMemberString = "";
		String[] memberAttributes = line.split(cvsSplitBy);

		/*
		 * for (int i = 0; i <= memberAttributes.length - 2; i++) { if (2 ==
		 * memberAttributes.length || i == memberAttributes.length - 2) {
		 * formattedMemberString = formattedMemberString.concat(memberAttributes[i]); }
		 * else { if (i != memberAttributes.length - 2) formattedMemberString =
		 * formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy); } }
		 */
		for (int i = 1; i <= memberAttributes.length - 1; i++) {
			if (2 == memberAttributes.length || i == memberAttributes.length - 1) {
				formattedMemberString = formattedMemberString.concat(memberAttributes[i]);
			} else {
				if (i != memberAttributes.length - 1)
					formattedMemberString = formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
			}
		}
		// System.out.println("formattedMemberString---" + formattedMemberString);
		UserName = null;
		// UserName = memberAttributes[memberAttributes.length - 1];
		UserName = memberAttributes[0];
		return formattedMemberString;
	}

	private Connection getDBConnection(Map<String, String> props) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(props.get(CommonConstants.DB_URL),
					props.get(CommonConstants.DB_USERNAME), props.get(CommonConstants.DB_PASSWORD));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public Connection getPDBDBConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		/*
		 * String env = props.get(CommonConstants.HSID_ENV); String user =
		 * props.get(CommonConstants.HSIDDB_USERNAME); String pwd =
		 * props.get(CommonConstants.HSIDDB_PASSWORD); String url =
		 * props.get(CommonConstants.HSIDDB_URL);
		 */
		String env = HSID_ENV;
		String user = HSIDDB_USERNAME;
		String pwd = HSIDDB_PASSWORD;
		String url = HSIDDB_URL;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Con established*********");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Connected to: " + env.toUpperCase() + " database");

		return con;

	}

	public void getRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
		// Connection con = getPDBDBConnection(props);
		Connection con = getPDBDBConnection();
		Statement stmt = null;
		stmt = con.createStatement();
		String sql;
		ResultSet rs1 = null;
		try {
			sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName
					+ "'";
			rs1 = stmt.executeQuery(sql);
			rs1.first();
			String HLTHSF_ID = rs1.getString("HLTHSF_ID");
			System.out.println(HLTHSF_ID);
		} catch (Exception e) {
			System.out.println("Already data not available in the mbr DB");
		} finally {
			rs1.close();
			stmt.close();
			con.close();
		}

	}

	public void deleteRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
		// Connection con = getPDBDBConnection(props);
		Connection con = getPDBDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();
		try {
			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '"
					+ lastName + "'");
			int initialrowcount = 0;
			while (rs.next()) {
				initialrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr table are: " + initialrowcount);
			stmt.executeUpdate(
					"delete from mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");

			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '"
					+ lastName + "'");
			int finalrowcount = 0;
			while (rs.next()) {
				finalrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr table are: " + finalrowcount);
			if (finalrowcount == 0) {
				System.out.println("Records deleted successfully from table: mbr");
			} else {
				System.out.println("Still Records exist in the table: mbr");
			}
		} catch (Exception e) {
			System.out.println("Nothing to delete from the mbr DB");
		}
	}

	public void deleteRecordsFrom_mbr_prtl_table(String firstName, String lastName) throws SQLException {

		// The following steps will return no. of selected records based on
		// first name and last name
		// Connection con = getPDBDBConnection(props);
		Connection con = getPDBDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();
		try {
			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
					+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
			int initialrowcount = 0;
			while (rs.next()) {
				initialrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr_prtl table are: " + initialrowcount);

			stmt.executeUpdate("delete from mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
					+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
					+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
			int finalrowcount = 0;
			while (rs.next()) {
				finalrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr_prtl table are: " + finalrowcount);
			if (finalrowcount == 0) {
				System.out.println("Records deleted successfully from table: mbr_prtl");
			} else {
				System.out.println("Still Records exist in the table: mbr_prtl");
			}

		} catch (Exception e) {
			System.out.println("Nothing to delete from the mbr_portal DB");
		}

	}

	public void deleteRecordsFrom_mbr_extrm_scl_dtl_table(String firstName, String lastName) throws SQLException {
		// The following steps will return no. of selected records based on
		// first name and last name
		// Connection con = getPDBDBConnection(props);
		Connection con = getPDBDBConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();
		String sql;
		try {
			sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName
					+ "'";
			ResultSet rs1 = stmt.executeQuery(sql);
			rs1.first();
			String HLTHSF_ID = rs1.getString("HLTHSF_ID");
			System.out.println(HLTHSF_ID);
			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
			int initialrowcount = 0;
			while (rs.next()) {
				initialrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr_extrm_scl_dtl table are: " + initialrowcount);
			stmt.executeUpdate("delete from mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
			rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
			int finalrowcount = 0;
			while (rs.next()) {
				finalrowcount = rs.getInt(1);
			}
			System.out.println("Total selected records to delete from mbr_extrm_scl_dtl table are: " + finalrowcount);
			if (finalrowcount == 0) {
				System.out.println("Records deleted successfully from table: mbr_extrm_scl_dtl");
			} else {
				System.out.println("Still Records exist in the table: mbr_extrm_scl_dtl");
			}
		} catch (Exception e) {
			System.out.println("Nothing to delete from the DB");
		}

	}

	public void removeMember() {

		Map<String, String> props = getProperties();

		// Set up DB
		Connection con = getDBConnection(props);

		// Default Schema
		String defaultSchema = props.get(CommonConstants.DB_SCHEMA);

		Statement stmt;
		ResultSet rs = null;
		for (String userName : userNamesAddedList) {
			try {
				stmt = con.createStatement();
				String query = "select * from " + defaultSchema + ".PORTAL_USER where USER_NAME='" + userName + "'";
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				/* Checking in DataBase */
				if (rs.next()) {
					stmt = con.createStatement();

					String query = "DELETE FROM " + defaultSchema
							+ ".PORTAL_USER_ACCOUNT where PORTAL_USER_ID in (select PORTAL_USER_ID from "
							+ defaultSchema + ".PORTAL_USER where USER_NAME='" + userName + "')";
					String query1 = "DELETE FROM " + defaultSchema + ".PORTAL_USER where USER_NAME='" + userName + "'";
					rs = stmt.executeQuery(query);
					rs = stmt.executeQuery(query1);

					System.out.println("USERNAME " + userName + " :: deleted from PORTAL_USER table");

				} else {

					System.out.println("USERNAME " + userName + " :: member not found in database");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			/* Closing database connection */
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

			propertyFilePath.append("/").append(propertiesFileToPick).append("/")
					.append(CommonConstants.PROPERTY_FILE_NAME);
			InputStream is = ClassLoader.class.getResourceAsStream(propertyFilePath.toString());
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
			else if (environment.contains("stage") || environment.equals("stage-aarp")
					|| environment.equals("offline-stage-aarp"))
				domain = "uhc.com";
			else if (environment.contains("mnr-acq-ci") || environment.equals("team-atest")
					|| environment.equals("team-e") || environment.equals("team-t") || environment.equals("team-v1")
					|| environment.equals("team-acme") || environment.equals("team-voc")
					|| environment.equals("team-acme") || environment.contains("digital-uat")
					|| environment.equals("team-chargers") || environment.contains("chargers")
					|| environment.equals("team-avengers-plm") || environment.contains("team-avengers-plm")
					|| environment.contains("chargers-qa") || environment.contains("team-uhc-rx"))

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

	public Map<String, String> getAMPMemberWithDesiredAttributes(List<String> desiredAttributes) {
		formCompositeDesiredAttributes(desiredAttributes);
		attributeMapToUse = "ampMemberAttributesMap";
		returnLoginCredentials();

		return loginCreds;
	}

	public Map<String, String> getUMSMemberWithDesiredAttributes(List<String> desiredAttributes) {
		formCompositeDesiredAttributes(desiredAttributes);
		attributeMapToUse = "umsMemberAttributesMap";
		returnLoginCredentials();

		return loginCreds;
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
		}

		else {
			System.out.println("Expected data not set for : " + user);
			return null;
		}
	}

	public WebDriver getWebDriver() {

		isSauceLabSelected = true;
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setCapability("platform", "Windows 7");
		capabilities.setCapability("version", "66.0");
		capabilities.setCapability("screenResolution", "1920x1080");
		// capabilities.setCapability("parent-tunnel", "sauce_admin");
		capabilities.setCapability("parent-tunnel", "optumtest");
		capabilities.setCapability("tunnelIdentifier", sauceLabsTunnelIdentifier);
		// capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
		// capabilities.setCapability("name", "MRATDD-TestSuite");
		// capabilities.setCapability("tunnelIdentifier", "Optum-Prd");
		capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
		String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  "
				+ System.getProperty("environment") + " environment";
		capabilities.setCapability("name", jobName);
		capabilities.setCapability("recordMp4", true);
		try {
//			webDriver = new RemoteWebDriver(new URL(URL), capabilities);
			//sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
			threadSafeDriver.set(new RemoteWebDriver(new URL(URL), capabilities));
			sessionId.set(((RemoteWebDriver) getThreadSafeDriver()).getSessionId().toString());
			System.out.println("Session ID:" + getThreadLocalSessionId());
			getJobURL(getThreadLocalSessionId());
		} catch (MalformedURLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return webDriver;
		return getThreadSafeDriver();

		/*
		 * File pathToBinary = new
		 * File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		 * Map<String, Object> chromeOptions = new HashMap<String, Object>();
		 * chromeOptions.put("binary", pathToBinary); DesiredCapabilities capabilities =
		 * DesiredCapabilities.chrome();
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		 * ChromeOptions options = new ChromeOptions();
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:/Users/kgupta44/drivers/chromedriver.exe");
		 * options.setExperimentalOption("useAutomationExtension", false); webDriver =
		 * new ChromeDriver(options); webDriver.manage().window().maximize(); return
		 * webDriver;
		 */

	}

	public WebDriver getIEDriver() {
		System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
		DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
		ieCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCaps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//		webDriver = new InternetExplorerDriver(ieCaps);
		threadSafeDriver.set(new InternetExplorerDriver(ieCaps));
//		webDriver.manage().window().maximize();
		getThreadSafeDriver().manage().window().maximize();
//		return webDriver;
		return getThreadSafeDriver();

	}

	public WebDriver getMobileWebDriver() {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", props.get(CommonConstants.DEVICE_NAME));
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		System.setProperty("webdriver.chrome.driver", props.get(CommonConstants.CHROME_DRIVER));
//		webDriver = new ChromeDriver(capabilities);
		threadSafeDriver.set(new ChromeDriver(capabilities));
//		return webDriver;
		return getThreadSafeDriver();
	}

	public void removeMember(String userName) {

		System.out.println("Removing members in registration flow");

		Map<String, String> props = getProperties();

		// Set up DB
		Connection con = getDBConnection(props);

		// Default Schema
		String defaultSchema = props.get(CommonConstants.DB_SCHEMA);

		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String query = "select * from " + defaultSchema + ".PORTAL_USER where USER_NAME='" + userName + "'";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			/* Checking in DataBase */
			if (rs.next()) {
				stmt = con.createStatement();
				String query = "DELETE FROM " + defaultSchema
						+ ".PORTAL_USER_ACCOUNT where PORTAL_USER_ID in (select PORTAL_USER_ID from " + defaultSchema
						+ ".PORTAL_USER where USER_NAME='" + userName + "')";
				String query1 = "DELETE FROM " + defaultSchema + ".PORTAL_USER where USER_NAME='" + userName + "'";
				rs = stmt.executeQuery(query);
				rs = stmt.executeQuery(query1);

				System.out.println("USERNAME " + userName + " :: deleted from PORTAL_USER table");

			} else {

				System.out.println("USERNAME " + userName + " :: member not found in database");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			/* Closing database connection */
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Removing members in registration flow:: Complete");

	}

	public void DriverQuit()

	{
		// webDriver.quit();
	}

	/*
	 * public Map<String, String>
	 * getmemberRedesignVbfWithDesiredAttributes(List<String> desiredAttributes) {
	 * formCompositeDesiredAttributes(desiredAttributes); attributeMapToUse =
	 * "memberRedesignVbfAttributesMap"; returnLoginCredentials(); return
	 * loginCreds; }
	 */
	public void formCompositeDesiredAttributes(List<String> desiredAttributes) {
		compositeDesiredAttributes = "";
		for (int i = 0; i < desiredAttributes.size(); i++) {
			if (i == desiredAttributes.size() - 1) {
				compositeDesiredAttributes = compositeDesiredAttributes.concat(desiredAttributes.get(i));
			} else {
				compositeDesiredAttributes = compositeDesiredAttributes.concat(desiredAttributes.get(i)).concat(",");
			}
		}
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

	public void returnLoginCredentials() {
		loginCreds.clear();
		for (Entry<String, String> currEntry : returnMemberAttributeMap().entrySet()) {
			if (currEntry.getKey().equals(compositeDesiredAttributes)) {
				if (currEntry.getValue().contains("/")) {
					String[] valArr = currEntry.getValue().split("/");
					loginCreds.put("user", valArr[0]);
					loginCreds.put("pwd", valArr[1]);
				} else {
					loginCreds.put("user", currEntry.getValue());
					loginCreds.put("pwd", "Password@1");
				}
				break;
			}
		}
	}

	public void CaptureScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
		System.out.println("Screenshot captured!!!");
		// To get the report embedded in the report
//		scenario.embed(screenshot, "image/png");
		scenario.attach(screenshot, "image/png", "Screenshot");

	}

	public void nullifyWebDriverNew() {
		if (null != webDriver) {
			// webDriver.quit();
			webDriver = null;
		}

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
		if (browser.equalsIgnoreCase(CommonConstants.JENKINS_BROWSER_PHANTOMJS)) {
			// otherwise if we have a Jenkins browser defined, we use it.
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, pathToBinary);
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
					new String[] { "--web-security=no", "--ignore-ssl-errors=yes", "--ssl-protocol=any" });

			// end from jarvis
//			webDriver = new PhantomJSDriver(caps);
//			webDriver.manage().window().setSize(new Dimension(1400, 1000));
//			webDriver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			threadSafeDriver.set(new PhantomJSDriver(caps));
			getThreadSafeDriver().manage().window().setSize(new Dimension(1400, 1000));
			getThreadSafeDriver().manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase(CommonConstants.FIREFOX_BROWSER)) {

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
			//System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Chrome_driver_80.0.3987.16\\chromedriver.exe");
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

		} else if (browser.equalsIgnoreCase(CommonConstants.IE_BROWSER)) {
			System.setProperty("webdriver.ie.driver", pathToBinary);
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//			webDriver = new InternetExplorerDriver(ieCaps);
//			webDriver.manage().window().maximize();
			threadSafeDriver.set(new InternetExplorerDriver(ieCaps));
			getThreadSafeDriver().manage().window().maximize();


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
				capabilities.setCapability("parent-tunnel", "optumtest");
				capabilities.setCapability("tunnelIdentifier", sauceLabsTunnelIdentifier);
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
//					webDriver = new RemoteWebDriver(new URL(URL), capabilities);
					threadSafeDriver.set(new RemoteWebDriver(new URL(URL), capabilities));
//					setThreadSafeDriver(webDriver);
//					setThreadSafeDriver(new RemoteWebDriver(new URL(URL), capabilities));
					//sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
					sessionId.set(((RemoteWebDriver) getThreadSafeDriver()).getSessionId().toString());
					System.out.println("Session ID:" + getThreadLocalSessionId());
					getJobURL(getThreadLocalSessionId());
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

	public synchronized String getThreadLocalSessionId() {
		//return sessionId;
		return sessionId.get();
	}

	public synchronized String returnJobURL() {
//		return JobURL;
		if (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_VIRTUAL) && 
				getThreadSafeMobileDriver() != null) {
			return JobURLVD.get();
		} else {
			return JobURL.get();
		}
		
	}

	public void getJobURL(String jobID) {
		String digest = hmacDigest(jobID, USERNAME + ":" + ACCESS_KEY, "HmacMD5");
//		JobURL = "https://saucelabs.com/jobs/" + jobID + "?auth=" + digest;
//		System.out.println("JobURL ---" + JobURL);
		JobURL.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
		System.out.println("JobURL ---" + returnJobURL());
	}

	public void getVDJobURL(String jobID) {
		String digest = hmacDigest(jobID, USERNAME + ":" + ACCESS_KEY, "HmacMD5");
//		JobURLVD = "https://saucelabs.com/tests/" + jobID + "?auth=" + digest;
//		System.out.println("JobURL ---" + JobURLVD);
		JobURLVD.set("https://saucelabs.com/jobs/" + jobID + "?auth=" + digest);
		System.out.println("JobURL ---" + returnJobURL());
	}

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
		//capabilities.setCapability("AUTOMATION_NAME", "XCUITest");
		capabilities.setCapability("commandTimeout" , 600);
		capabilities.setCapability("maxDuration", 10000);
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
		try {

			String SauceLabsURL = (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)
					? RealDeviceURL
					: VirtualDeviceURL);

			if (mobileDeviceOSName.equalsIgnoreCase("Android")) {
				capabilities.setCapability("browserName", "Chrome");
				browserName="Chrome";
//				mobileDriver = new AndroidDriver(new URL(SauceLabsURL), capabilities);
				threadSafeMobileDriver.set(new AndroidDriver(new URL(SauceLabsURL), capabilities));

			} else {
				capabilities.setCapability("browserName", "Safari");
				browserName="Safari";
//				mobileDriver = new IOSDriver(new URL(SauceLabsURL), capabilities);
				threadSafeMobileDriver.set(new IOSDriver(new URL(SauceLabsURL), capabilities));
			}
//			System.out.println("Session ID --- " + mobileDriver.getSessionId());
			System.out.println("Session ID --- " + getThreadSafeMobileDriver().getSessionId().toString());

			if (mobileDeviceType.equalsIgnoreCase(CommonConstants.MOBILE_DEVICE_TYPE_DEFAULT)) {
				/*JobURL= (String) mobileDriver.getCapabilities().getCapability("testobject_test_report_url");
				System.out.println(mobileDeviceName + " JobURL  --- " + JobURL);*/
				
				JobURL.set((String) getThreadSafeMobileDriver().getCapabilities().getCapability("testobject_test_report_url"));
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
				System.out.println("Session ID:" + getThreadLocalSessionId());
//				getVDJobURL(((mobileDriver).getSessionId()).toString());
				getVDJobURL(getThreadLocalSessionId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return mobileDriver;
		return getThreadSafeMobileDriver();
	}

	public Connection getGPSuat3Connection() throws SQLException {

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("for class run");

			String env = HSID_ENV;
			String user = "UHG_000611921";
			String pwd = "Passy&0f";

			// Below is GPS UAT URL (enable/disable based on GPS env that you want to
			// connect)
			// String url =
			// "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0039.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=gpsts14svc.uhc.com)))";
			// Below is GPS UAT2 URL (enable/disable based on GPS env that you want to
			// connect)
			// String url =
			// "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0041.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=gpsts20svc.uhc.com)))";
			// Below is GPS UAT3 URL (enable/disable based on GPS env that you want to
			// connect)

			// PLEASE DO NOT CHANGE THIS CODE BELOW WITHOUT INFORMING CT TEAM (JITESH AND
			// KAPIL)

			String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0102)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=gpsts18)))";

			// Below is GPS UAT4 URL (enable/disable based on GPS env that you want to
			// connect)

			// String url =
			// "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0103)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=gpsts19)))";

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Oracle Database Connection established**********");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Oracle Database Connection not established");
		}

		// System.out.println("Connected to: " + env.toUpperCase() + " database");

		return con;

	}

	public static Map<String, String> getProps() {
		return props;
	}

}
