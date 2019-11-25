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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
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
import org.springframework.stereotype.Component;

import acceptancetests.data.CommonConstants;
import cucumber.api.Scenario;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author schak38
 *
 */

@Component
public class MRScenario {

	private Map<String, Object> scenarioObjectMap = new HashMap<String, Object>();

	private static Map<String, String> ampMemberAttributesMap = new LinkedHashMap<String, String>();

	private static Map<String, String> umsMemberAttributesMap = new LinkedHashMap<String, String>();
	private static Map<String, String> memberRedesignVbfAttributesMap = new LinkedHashMap<String, String>();

	private static List<String> userNamesAddedList = new ArrayList<String>();

	private static Map<String, String> props = new HashMap<String, String>();

	private static Map<String, Map<String, JSONObject>> expectedDataMapUlayer = new LinkedHashMap<String, Map<String, JSONObject>>();

	private static Map<String, Map<String, JSONObject>> expectedDataMapBluelayer = new LinkedHashMap<String, Map<String, JSONObject>>();
	private static Map<String, String> loginCreds = new HashMap<String, String>();
	public static String environment;
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
	private static String sessionId;
	private static String JobURL = null;
	public static boolean isSauceLabSelected = false;
	public static int count = 0;
	public static String sauceLabsTunnelIdentifier;
	static BufferedReader memberAmpTypeReader = null;
	static BufferedReader memberUmsTypeReader = null;
	static BufferedReader memberRedesignVbfTypeReader = null;
	

	public static final String USERNAME = "ucpadmin";

	public static final String ACCESS_KEY = "2817affd-616e-4c96-819e-4583348d7b37";

	//public static final String USERNAME = System.getenv("SAUCE_USERNAME");

	//public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.saucelabs.com:443/wd/hub";

	public void saveBean(String id, Object object) {
		scenarioObjectMap.put(id, object);
	}

	public void flushBeans() {
		if (!scenarioObjectMap.isEmpty()) {
			scenarioObjectMap.clear();
		}
	}

	static WebDriver webDriver;

	public Object getBean(String id) {
		Object result = scenarioObjectMap.get(id);
		if (result == null) {
			System.out.println("Object not initialized");
		}
		return result;

	}

	static {

		props = getProperties();

		/* Set acqusisition and member urls */
		environment = props.get("Environment");

		if (environment.equals("awe-test-a")) {
			environmentMedicare = "test-a";
		} else if (environment.equals("awe-stage")) {
			environmentMedicare = "stage";
		} else {
			environmentMedicare = environment;
		}

		if (props.containsKey("Domain")) {
			domain = props.get("Domain");
		} else {
			domain = null;
		}
		isTestHarness = (null == System.getProperty(CommonConstants.IS_TESTHARNESS) ? props.get("isTestHarness")
				: System.getProperty(CommonConstants.IS_TESTHARNESS));
		isHSIDCompatible = (null == System.getProperty(CommonConstants.IS_HSID_COMPATIBLE)
				? props.get("isHSIDCompatible") : System.getProperty(CommonConstants.IS_HSID_COMPATIBLE));
		
		sauceLabsTunnelIdentifier = (null == System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER) ? CommonConstants.SAUCELABS_DEFAULT_TUNNEL
				: System.getProperty(CommonConstants.SAUCELABS_TUNNEL_IDENTIFIER));

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
	
	

	public static void loadCSV() {
		// GlobalBeforeHook.beforeGlobal(scenario);
		String csvName = getCsvName();
		System.out.println(csvName);
		putCsv(csvName);

	}

	private static void putCsv(String csvName) {
		InputStream memberTypeStream1 = ClassLoader.class.getResourceAsStream("/database/"+csvName);
		memberUmsTypeReader = new BufferedReader(new InputStreamReader(memberTypeStream1));
		System.out.println("Inside ..........."+csvName);
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
		
		public static List<String> getTagList() {
		List<String> tagsList = atdd.framework.GlobalBeforeHook.tagsList;
		return tagsList;
		}
		
		
		public static String getCsvName() {

			String csvName = null;
			List<String> tagsList = atdd.framework.GlobalBeforeHook.tagsList;
			System.out.println(tagsList.size());
			Iterator<String> it= tagsList.iterator();
			while(it.hasNext()){
				
				String tagName=it.next();
				
				
				  if  (environment.contains("team-ci")){
						csvName = "MemberRedesign-VBF-Teamci.csv";
								
				} else if ((environment.equalsIgnoreCase("team-a")|| (environment.equalsIgnoreCase("team-atest")||(environment.equalsIgnoreCase("team-h")) || (environment.equalsIgnoreCase("team-e")) || (environment.equalsIgnoreCase("team-f")) || (environment.equalsIgnoreCase("team-g")) || (environment.equalsIgnoreCase("team-c")) || (environment.equalsIgnoreCase("team-t"))))) {
					csvName= "MemberRedesign-UUID.csv";
				 }else  if(tagName.equalsIgnoreCase("@MemberVBF") && environment.contains("stage")){
							csvName = "MemberRedesign-VBF.csv";
				 }
				 /* note: Dec2018 - comment out because this section caused stage run not to use UMS-Member-Type.csv
					else{
				if (tagName.equalsIgnoreCase("@benefitsAndCoverage")) {
					csvName = "benefitsAndCoverage.csv";
				}

				else if (tagName.equalsIgnoreCase("@profileAndPreferences")) {
					csvName = "profileAndPreferences.csv";	
				}
				
				else if (tagName.equalsIgnoreCase("@claimsSummary")) {
					csvName = "claimsSummary.csv";	
				}
				
					}
					*/
			}
				if(csvName!=null)
					return csvName;
				else 
					csvName="UMS-Member-Type.csv";
					return  csvName;		

		}
		
		public static String formatMemberData(String line, String formattedMemberString) {
			formattedMemberString = "";
			String[] memberAttributes = line.split(cvsSplitBy);

			/*
			 * for (int i = 0; i <= memberAttributes.length - 2; i++) { if (2 ==
			 * memberAttributes.length || i == memberAttributes.length - 2) {
			 * formattedMemberString =
			 * formattedMemberString.concat(memberAttributes[i]); } else { if (i !=
			 * memberAttributes.length - 2) formattedMemberString =
			 * formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
			 * } }
			 */
			for (int i = 1; i <= memberAttributes.length - 1; i++) {
				if (2 == memberAttributes.length || i == memberAttributes.length - 1) {
					formattedMemberString = formattedMemberString.concat(memberAttributes[i]);
				} else {
					if (i != memberAttributes.length - 1)
						formattedMemberString = formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
				}
			}
			//System.out.println("formattedMemberString---" + formattedMemberString);
			UserName = null;
			// UserName = memberAttributes[memberAttributes.length - 1];
			UserName = memberAttributes[0];
			return formattedMemberString;
		}
		

	public static String formatMemberData(String line) {
		String formattedMemberString = "";
		String[] memberAttributes = line.split(cvsSplitBy);

		/*for (int i = 0; i <= memberAttributes.length - 2; i++) {
			if (2 == memberAttributes.length || i == memberAttributes.length - 2) {
				formattedMemberString = formattedMemberString.concat(memberAttributes[i]);
			} else {
				if (i != memberAttributes.length - 2)
					formattedMemberString = formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
			}
		}*/
		for (int i = 1; i <= memberAttributes.length - 1; i++) {
			if (2 == memberAttributes.length || i == memberAttributes.length - 1) {
				formattedMemberString = formattedMemberString.concat(memberAttributes[i]);
			} else {
				if (i != memberAttributes.length - 1)
					formattedMemberString = formattedMemberString.concat(memberAttributes[i]).concat(cvsSplitBy);
			}
		}
		//System.out.println("formattedMemberString---" + formattedMemberString);
		UserName = null;
		//UserName = memberAttributes[memberAttributes.length - 1];
		UserName = memberAttributes[0];
		return formattedMemberString;
	}
	

	private static Connection getDBConnection(Map<String, String> props) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					props.get(CommonConstants.DB_URL),
					props.get(CommonConstants.DB_USERNAME),
					props.get(CommonConstants.DB_PASSWORD));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static Connection getPDBDBConnection(Map<String, String> props) {

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		String env = props.get(CommonConstants.HSID_ENV);
		String user = props.get(CommonConstants.HSIDDB_USERNAME);
		String pwd = props.get(CommonConstants.HSIDDB_PASSWORD);
		String url = props.get(CommonConstants.HSIDDB_URL);
		try {
			con = DriverManager.getConnection(url,user,pwd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Connected to: " + env.toUpperCase() + " database");

		return con;

	}

	public static  void getRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
		Connection con = getPDBDBConnection(props);
		Statement stmt = null;

		stmt = con.createStatement();
		String sql;
		sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName
				+ "' and MDM_LST_NM = '" + lastName + "'";
		ResultSet rs1 = stmt.executeQuery(sql);
		rs1.first();
		String HLTHSF_ID  = rs1.getString("HLTHSF_ID");
		System.out.println(HLTHSF_ID);
		rs1.close();
		stmt.close();
		con.close();
	}



	public static void deleteRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
		Connection con = getPDBDBConnection(props);
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();   
		rs = stmt.executeQuery(
				"SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");
		int initialrowcount = 0;
		while (rs.next()) {
			initialrowcount = rs.getInt(1);
		}
		System.out.println("Total selected records to delete from mbr table are: " + initialrowcount);
		stmt.executeUpdate(
				"delete from mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");

		rs = stmt.executeQuery(
				"SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");
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

	} 

	public static void deleteRecordsFrom_mbr_prtl_table(String firstName, String lastName) throws SQLException {

		// The following steps will return no. of selected records based on
		// first name and last name
		Connection con = getPDBDBConnection(props);
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
				+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
		int initialrowcount = 0;
		while (rs.next()) {
			initialrowcount = rs.getInt(1);
		}
		System.out.println("Total selected records to delete from mbr_prtl table are: " + initialrowcount);


		stmt.executeUpdate("delete from mbr_prtl where MBR_PRTL_FST_NM = '" + firstName + "' and MBR_PRTL_LST_NM = '"
				+ lastName + "'");
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
	}

	public static void deleteRecordsFrom_mbr_extrm_scl_dtl_table(String firstName, String lastName) throws SQLException {
		// The following steps will return no. of selected records based on
		// first name and last name
		Connection con = getPDBDBConnection(props);
		Statement stmt = null;
		ResultSet rs = null;
		stmt = con.createStatement();
		String sql;
		sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName
				+ "' and MDM_LST_NM = '" + lastName + "'";
		ResultSet rs1 = stmt.executeQuery(sql);
		rs1.first();
		String HLTHSF_ID  = rs1.getString("HLTHSF_ID");
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
				String query = "select * from " + defaultSchema
						+ ".PORTAL_USER where USER_NAME='" + userName + "'";
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				/* Checking in DataBase */
				if (rs.next()) {
					stmt = con.createStatement();

					String query = "DELETE FROM "
							+ defaultSchema
							+ ".PORTAL_USER_ACCOUNT where PORTAL_USER_ID in (select PORTAL_USER_ID from "
							+ defaultSchema + ".PORTAL_USER where USER_NAME='"
							+ userName + "')";
					String query1 = "DELETE FROM " + defaultSchema
							+ ".PORTAL_USER where USER_NAME='" + userName + "'";
					rs = stmt.executeQuery(query);
					rs = stmt.executeQuery(query1);

					System.out.println("USERNAME " + userName
							+ " :: deleted from PORTAL_USER table");

				} else {

					System.out.println("USERNAME " + userName
							+ " :: member not found in database");
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
		String propertiesFileToPick = System.getProperty("environment");
		System.out.println("Using properties for environment ...."
				+ propertiesFileToPick);
		if (StringUtils.isBlank(propertiesFileToPick)) {
			System.out
			.println("Using CI as default since environment was not passed in !!!");
			propertiesFileToPick = CommonConstants.DEFAULT_ENVIRONMENT_CI;
		}
		// Read properties from classpath
		StringBuffer propertyFilePath = new StringBuffer(
				CommonConstants.PROPERTY_FILE_FOLDER);
		propertyFilePath.append("/").append(propertiesFileToPick).append("/")
		.append(CommonConstants.PROPERTY_FILE_NAME);
		InputStream is = ClassLoader.class.getResourceAsStream(propertyFilePath
				.toString());
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String key : prop.stringPropertyNames()) {
			String value = prop.getProperty(key);
			props.put(key, value);
		}
		return props;
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

	/*  public WebDriver getWebDriver() {*/

	/*
	 * 
	 * Below code excecutes if webdriver value is passed in build command ::
	 * either saucelabs or headless
	 */
	/*                          if (null != System.getProperty("webdriverhost")
                                                            && !(System.getProperty("webdriverhost").equalsIgnoreCase(""))) {

                                             if (System.getProperty("webdriverhost").equalsIgnoreCase(
                                                                           "saucelabs")) {
                                                            DesiredCapabilities capabilities = DesiredCapabilities
                                                                                          .firefox();
                                                            capabilities.setCapability("platform", "Windows 7");
                                                            capabilities.setCapability("version", "45.0");
                                                            capabilities.setCapability("parent-tunnel", "sauce_admin");
                                                            capabilities.setCapability("tunnelIdentifier",
                                                                                          "OptumSharedTunnel-Prd");
                                                            //capabilities.setCapability("name", "MRATDD-TestSuite");
                                                            capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
                                                            String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  " + System.getProperty("environment") +" environment";
                capabilities.setCapability("name", jobName);
                                                            try {
                                                                           webDriver = new RemoteWebDriver(new URL(URL), capabilities);
                                                            } catch (MalformedURLException e) {
                                                                           // TODO Auto-generated catch block
                                                                           e.printStackTrace();
                                                            }
                                             } else {
                                                            /*
	 * Below code snippet is for triggering HeadLess Browser
	 * (PhantomJS)
	 */
	/*                                                        String phantomjs = System.getProperty("phantomjs");
                                                            DesiredCapabilities caps = new DesiredCapabilities();
                                                            if (StringUtils.isBlank(phantomjs)) {
                                                                           caps.setCapability(
                                                                                                         PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                                                                                         props.get("HeadlessBrowserPath"));
                                                            } else {
                                                                           caps.setCapability(
                                                                                                         PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                                                                                         System.getProperty("phantomjs"));
                                                            }
                                                            caps.setJavascriptEnabled(true);
                                                            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                                                                                          new String[] { "--web-security=false",
                                                                                                                        "--ignore-ssl-errors=true",
                                                                                                                        "--ssl-protocol=any" });
                                                            String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
                                                            System.setProperty("phantomjs.page.settings.userAgent",
                                                                                          userAgent);
                                                            webDriver = new PhantomJSDriver(caps);
                                             }

                              } else {/*
	 * Below code excecutes if webdriver value is not passed in
	 * build command :: mostly running locally and triggering runner
	 * class directly
	 */
	/*
	 * TODO: pperugu :: Need to update the headless browser code below
	 * for local
	 */
	/*
                                         String phantomjs = System.getProperty("phantomjs");
                                             String agent = "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; LG-LU3000 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
                                             DesiredCapabilities caps = new DesiredCapabilities();
                                             if (StringUtils.isBlank(phantomjs)) {
                                                            caps.setCapability(
                                                                                          PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                                                                          props.get("HeadlessBrowserPath"));
                                             } else {
                                                            caps.setCapability(
                                                                                          PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                                                                          System.getProperty("phantomjs"));
                                             }
                                             caps.setCapability(
                                                                           PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX
                                                                                                         + "userAgent", agent);
                                             caps.setJavascriptEnabled(true);
                                             caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                                                                           new String[] { "--web-security=false",
                                                                                                         "--ignore-ssl-errors=true", "--ssl-protocol=any" });
                                             String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
                                             System.setProperty("phantomjs.page.settings.userAgent", userAgent);
                                             webDriver = new PhantomJSDriver(caps);

                              }
                              return webDriver;
               }*/

	public WebDriver getWebDriver() {


		isSauceLabSelected = true;
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setCapability("platform", "Windows 7");
		capabilities.setCapability("version", "66.0");
		capabilities.setCapability("screenResolution", "1920x1080");
		//capabilities.setCapability("parent-tunnel", "sauce_admin");
		capabilities.setCapability("parent-tunnel", "optumtest");
		capabilities.setCapability("tunnelIdentifier",
sauceLabsTunnelIdentifier);		
		//capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");		//capabilities.setCapability("name", "MRATDD-TestSuite");
		//capabilities.setCapability("tunnelIdentifier", "Optum-Prd");	
		capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
		String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  " + System.getProperty("environment") +" environment";
		capabilities.setCapability("name", jobName);
		capabilities.setCapability("recordMp4", true);
		try {
			webDriver = new RemoteWebDriver(new URL(URL), capabilities);
			MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
			System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
			getJobURL(getSessionId());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return webDriver;	
		
		/*File pathToBinary = new File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("binary", pathToBinary);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        ChromeOptions options=new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:/Users/y16/drivers/chromedriver_win32/chromedriver.exe");
        options.setExperimentalOption("useAutomationExtension", false);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
             
		return webDriver;
*/
	}
	


	public WebDriver getIEDriver() {
		System.setProperty("webdriver.ie.driver",
				"./IEDriverServer.exe");
		DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
		ieCaps.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		ieCaps.setCapability(
				InternetExplorerDriver.IGNORE_ZOOM_SETTING,
				true);
		webDriver = new InternetExplorerDriver(ieCaps);
		webDriver.manage().window().maximize();
		return webDriver;

	}

	public WebDriver getMobileWebDriver() {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName",
				props.get(CommonConstants.DEVICE_NAME));
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		System.setProperty("webdriver.chrome.driver",
				props.get(CommonConstants.CHROME_DRIVER));
		webDriver = new ChromeDriver(capabilities);
		return webDriver;
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
			String query = "select * from " + defaultSchema
					+ ".PORTAL_USER where USER_NAME='" + userName + "'";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			/* Checking in DataBase */
			if (rs.next()) {
				stmt = con.createStatement();
				String query = "DELETE FROM "
						+ defaultSchema
						+ ".PORTAL_USER_ACCOUNT where PORTAL_USER_ID in (select PORTAL_USER_ID from "
						+ defaultSchema + ".PORTAL_USER where USER_NAME='"
						+ userName + "')";
				String query1 = "DELETE FROM " + defaultSchema
						+ ".PORTAL_USER where USER_NAME='" + userName + "'";
				rs = stmt.executeQuery(query);
				rs = stmt.executeQuery(query1);

				System.out.println("USERNAME " + userName
						+ " :: deleted from PORTAL_USER table");

			} else {

				System.out.println("USERNAME " + userName
						+ " :: member not found in database");
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
		//webDriver.quit();
	}

	/*public Map<String, String> getmemberRedesignVbfWithDesiredAttributes(List<String> desiredAttributes) {
		formCompositeDesiredAttributes(desiredAttributes);
		attributeMapToUse = "memberRedesignVbfAttributesMap";
		returnLoginCredentials();
		return loginCreds;
	}
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

	public static Map<String, String> returnMemberAttributeMap() {
		if (attributeMapToUse.equalsIgnoreCase("memberRedesignVbfAttributesMap"))
			return memberRedesignVbfAttributesMap;
		else if (attributeMapToUse.equalsIgnoreCase("ampMemberAttributesMap"))
			return ampMemberAttributesMap;
		else if (attributeMapToUse.equalsIgnoreCase("umsMemberAttributesMap"))
			return umsMemberAttributesMap;
		else
			return null;
	}

	public static void returnLoginCredentials() {
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
		scenario.embed(screenshot, "image/png");
		
	}

	public void nullifyWebDriverNew() {
		if (null != webDriver) {
			//webDriver.quit();
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
		String browser = (null == System.getProperty(CommonConstants.JENKINS_BROWSER)
				? props.get(CommonConstants.DESKTOP_WEBDRIVER) : System.getProperty(CommonConstants.JENKINS_BROWSER));

		String browserName = (null == System.getProperty(CommonConstants.BROWSER_NAME) ? props.get("BrowserName")
				: System.getProperty(CommonConstants.BROWSER_NAME));
		// Again, Jenkins takes precedent.
		String pathToBinary = (null == System.getProperty("phantomjs") ? props.get("BrowserPathToBinary")
				: System.getProperty("phantomjs"));

		System.out.println("getWebDriver: returning driver for " + browser);
		// if webDriver is null, create one, otherwise send the existing one
		// back.
		// This has to happen to preserve the state of webDriver so that we can
		// take screenshots at the end.
	//	if (null == webDriver) {
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
				webDriver = new PhantomJSDriver(caps);
				webDriver.manage().window().setSize(new Dimension(1400, 1000));
				webDriver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase(CommonConstants.FIREFOX_BROWSER)) {

				System.setProperty("webdriver.gecko.driver", "pathToBinary");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				webDriver = new FirefoxDriver(capabilities);

				webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				webDriver.get("google.com");
				
				return webDriver;

			} else if (browser.equalsIgnoreCase(CommonConstants.CHROME_BROWSER)) {
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("binary", pathToBinary);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				System.setProperty("webdriver.chrome.driver", pathToBinary);
				webDriver = new ChromeDriver();
				saveBean(CommonConstants.WEBDRIVER, webDriver);
				return webDriver;

			} else if (browser.equalsIgnoreCase(CommonConstants.IE_BROWSER)) {
				System.setProperty("webdriver.ie.driver", pathToBinary);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				webDriver = new InternetExplorerDriver(ieCaps);
				webDriver.manage().window().maximize();

				return webDriver;
			} else if (browser.equalsIgnoreCase(CommonConstants.MOBILE_BROWSER)) {
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", props.get(CommonConstants.DEVICE_NAME));
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("mobileEmulation", mobileEmulation);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				System.setProperty("webdriver.chrome.driver", props.get(CommonConstants.CHROME_DRIVER));
				webDriver = new ChromeDriver(capabilities);
				return webDriver;
			} else if (browser.equalsIgnoreCase(CommonConstants.SAUCE_BROWSER_WEB)) {
				System.out.println("Execution is Going to Start on SauceLabs Web.....!!!!!");
				isSauceLabSelected = true;
				DesiredCapabilities capabilities = null;
				if (browserName.equalsIgnoreCase("firefox")) {
					System.out.println("Inside firefox");
					capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("platform", "Windows 10");
					capabilities.setCapability("version", "latest");
					capabilities.setCapability("maxDuration", "3600");
				} else if (browserName.equalsIgnoreCase("IE")) {
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability("platform", "Windows 10");
					capabilities.setCapability("version", "latest");
					capabilities.setCapability("screenResolution", "1024x768");	
					capabilities.setCapability("maxDuration", "3600");				
				} else if (browserName.equalsIgnoreCase("chrome")) {
					System.out.println("Inside chrome");
					capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability("platform", "Windows 10");
					capabilities.setCapability("version", "latest");
					capabilities.setCapability("screenResolution", "1920x1080");
					capabilities.setCapability("recordMp4", true);
					capabilities.setCapability("maxDuration", "3600");
				}
				 else if (browserName.equalsIgnoreCase("edge")) {
					System.out.println("Inside Edge");
					capabilities = DesiredCapabilities.edge();
					capabilities.setCapability("platform", "Windows 10");
					capabilities.setCapability("version", "latest");
					capabilities.setCapability("screenResolution", "1920x1080");
					capabilities.setCapability("maxDuration", "3600");
				 }
				capabilities.setCapability("autoAcceptsAlerts", true);
				//capabilities.setCapability("parent-tunnel", "sauce_admin");		
				capabilities.setCapability("parent-tunnel", "optumtest");						
				capabilities.setCapability("tunnelIdentifier", sauceLabsTunnelIdentifier);
				//capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
				capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));

				//---begin - enable logging
			    LoggingPreferences logPrefs  = new LoggingPreferences();
			    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				//---end - enable logging

				String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  " + System.getProperty("environment") +" environment";
				capabilities.setCapability("name", jobName);
				try {

					webDriver = new RemoteWebDriver(new URL(URL), capabilities);
					MRScenario.sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
					System.out.println("Session ID:" + (((RemoteWebDriver) webDriver).getSessionId()).toString());
					getJobURL(getSessionId());
					//webDriver.manage().deleteAllCookies();
				} catch (MalformedURLException e) {
					Assert.fail("Invalid Sauce URL: [" + URL + "]");
				}

			}
		//}
		return webDriver;

	}
	
	public String getSessionId() {
		return sessionId;
	}

	
	public static String returnJobURL() {
		return JobURL;
	}
	public void getJobURL(String jobID) {
		String digest = hmacDigest(jobID, USERNAME + ":" + ACCESS_KEY, "HmacMD5");
		JobURL = "https://saucelabs.com/jobs/" + jobID + "?auth=" + digest;
		System.out.println("JobURL ---" + JobURL);
	}

	public static String hmacDigest(String msg, String keyString, String algo) {
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
}
