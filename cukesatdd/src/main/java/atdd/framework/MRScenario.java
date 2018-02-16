package atdd.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import acceptancetests.data.CommonConstants;

/**
* 
 * @author schak38
*
*/

@Component
public class MRScenario {

               private Map<String, Object> scenarioObjectMap = new HashMap<String, Object>();

               private static Map<String, List<String>> ampMemberAttributesMap = new LinkedHashMap<String, List<String>>();

               private static Map<String, List<String>> umsMemberAttributesMap = new LinkedHashMap<String, List<String>>();

               private static List<String> userNamesAddedList = new ArrayList<String>();

               private static Map<String, String> props = new HashMap<String, String>();

               private static Map<String, Map<String, JSONObject>> expectedDataMapUlayer = new LinkedHashMap<String, Map<String, JSONObject>>();

               private static Map<String, Map<String, JSONObject>> expectedDataMapBluelayer = new LinkedHashMap<String, Map<String, JSONObject>>();
               public static String environment;
               public static String environmentMedicare;
               
               public static String domain;

               private static final String DIRECTORY = "/src/main/resources/";

               private static final String SQL_COMMIT = "COMMIT";

               public static int count = 0;

               
               public static final String USERNAME = "ucpadmin";

               public static final String ACCESS_KEY ="2817affd-616e-4c96-819e-4583348d7b37";
               

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
                              
                              if(environment.equals("awe-test-a")){
                            	  environmentMedicare ="test-a";
                              }else if(environment.equals("awe-stage")){
                            	  environmentMedicare ="stage";
                              }else{
                            	  environmentMedicare =environment;
                              }
                       
                              
                                 if(props.containsKey("Domain")) {
                                        domain = props.get("Domain");
                                 } else {
                                        domain = null;
                                 }
                              
                              // Setting permission to the scripts , so that jenkins server can access
                              File shellScript  =  new File("src/main/resources/pdfReportGenerator.sh");
                              File groovyScript  =  new File("src/main/resources/pdfReporter.groovy");
                              
                              shellScript.setReadable(true);
                              shellScript.setWritable(true);
                              shellScript.setExecutable(true);
                              
                              groovyScript.setReadable(true);
                              groovyScript.setWritable(true);
                              groovyScript.setExecutable(true);

                              /* Set up DB */
//                           Connection con = getDBConnection(props);

                              /* Default Schema */
///                         String defaultSchema = props.get(CommonConstants.DB_SCHEMA);
                              String line = "";
                              String cvsSplitBy = ",";
               //            String userName = null;
/*
                              InputStream massRegisStream = ClassLoader.class
                                                            .getResourceAsStream("/database/mass-registration.csv");
                              BufferedReader massRegisStreamReader = new BufferedReader(
                                                            new InputStreamReader(massRegisStream));

                              String line = "";
                              String cvsSplitBy = ",";
                              String userName = null;

                              try {
                                             while ((line = massRegisStreamReader.readLine()) != null) {
                                                            String[] massRegisStreamAttributes = line.split(cvsSplitBy);
                                                            pperugu: To skip the first line in CSV file 
                                                            if (!(massRegisStreamAttributes[0].equalsIgnoreCase("USERNAME"))) {
                                                                           userName = massRegisStreamAttributes[0];
                                                                           
                                                                           * pperugu ::Approach followed :: to remove the already
                                                                           * registered member and register the members again
                                                                           
                                                                           if (checkMemberFound(userName, con, defaultSchema)) {
                                                                                          removeMemberFound(userName, con, defaultSchema);
                                                                           }
                                                                           addMember(userName, con, defaultSchema,
                                                                                                         massRegisStreamAttributes);
                                                                           userNamesAddedList.add(userName);
                                                            }
                                             }
                              } catch (IOException e1) {
                                             // TODO Auto-generated catch block
                                             e1.printStackTrace();
                              }
*/
                              BufferedReader memberAmpTypeReader = null;
                              BufferedReader memberUmsTypeReader = null;

                              try {
                                             InputStream memberTypeStream = ClassLoader.class
                                                                           .getResourceAsStream("/database/AMP-Member-Type.csv");
                                             memberAmpTypeReader = new BufferedReader(new InputStreamReader(
                                                                           memberTypeStream));

                                             while ((line = memberAmpTypeReader.readLine()) != null) {
                                                            // use comma as separator
                                                            String[] memberAttributes = line.split(cvsSplitBy);
                                                            List<String> attrList = Arrays.asList(memberAttributes)
                                                                                          .subList(1, memberAttributes.length);
                                                            String ampUserName = null;
                                                            if (memberAttributes[0].contains("/")) {
                                                                           String[] memberAttributArr = memberAttributes[0].split("/");
                                                                           ampUserName = memberAttributArr[0];

                                                            } else {
                                                                           ampUserName = memberAttributes[0];
                                                            }

                              //                           if (userNamesAddedList.contains(ampUserName)) {
                                                                           ampMemberAttributesMap.put(ampUserName, attrList);
                                             //            }
                                             }

                                             InputStream memberTypeStream1 = ClassLoader.class
                                                                           .getResourceAsStream("/database/UMS-Member-Type.csv");
                                             memberUmsTypeReader = new BufferedReader(new InputStreamReader(
                                                                           memberTypeStream1));

                                             while ((line = memberUmsTypeReader.readLine()) != null) {
                                                            // use comma as separator
                                                            String[] memberAttributes = line.split(cvsSplitBy);
                                                            List<String> attrList = Arrays.asList(memberAttributes)
                                                                                          .subList(1, memberAttributes.length);
                                                            String uhcUserName = null;
                                                            if (memberAttributes[0].contains("/")) {
                                                                           String[] memberAttributArr = memberAttributes[0].split("/");
                                                                           uhcUserName = memberAttributArr[0];

                                                            } else {
                                                                           uhcUserName = memberAttributes[0];
                                                            }
                                                            //if (userNamesAddedList.contains(uhcUserName)) {
                                                                           umsMemberAttributesMap.put(uhcUserName, attrList);
                                                            //}

                                             }
                              } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              }

               }

               private static boolean checkMemberFound(String userName, Connection con,
                                             String defaultSchema) {

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

                                             if (rs.next()) {
                                                            return true;
                                             } else {
                                                            System.out.println(userName + ": Not found in database");
                                             }
                              } catch (SQLException e) {
                                             e.printStackTrace();
                              }
                              return false;
               }

               private static void removeMemberFound(String userName, Connection con,
                                             String defaultSchema) {

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

               }

               private static void addMember(String userName, Connection con,
                                             String defaultSchema, String[] massRegisStreamAttributes) {

                              Statement stmt;
                              ResultSet rs = null;

                              String individualID = massRegisStreamAttributes[5];
                              String accountID = massRegisStreamAttributes[6];
                              String businessType = massRegisStreamAttributes[7];

                              /* Creating Database entry */

                              /*
                              * Sample Queries ::::: INSERT INTO portal_user ( PORTAL_USER_ID,
                              * USER_NAME,EMAIL_OPT_IN_IND,GUID,UPDATE_NU,CREATED_BY
                              * ,CREATION_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE ) VALUES ( (SELECT
                              * MAX(PORTAL_USER_ID) FROM portal_user)+1,
                              * 'ATDD_ULAYER_MAPD_01','N','367c9a44d9076499:-2cd46151:1599308a8fb:-7fdb',8,'portaladmin','13-JAN-17
                              * 08.01.56.509000000 PM','portaladmin','15-JAN-17 11.47.14.428000000
                              * PM'); INSERT INTO portal_user_Account(PORTAL_USER_ACCOUNT_ID
                              * ,PORTAL_USER_ID,INDIVIDUAL_ID
                              * ,ACCOUNT_ID,BUSINESS_TYPE,GUID,UPDATE_NU
                              * ,CREATED_BY,CREATION_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE )
                              * VALUES(((SELECT MAX(PORTAL_USER_ACCOUNT_ID) FROM
                              * portal_user_Account)+1),(SELECT MAX(PORTAL_USER_ID) FROM
                              * portal_user),600030162506,10030183001,
                              * 'GOVT','c7429fee012cdd44:-347aba25:1597345cc63:-6a7e',0,'portaladmin','16-JAN-17
                              * 05.28.36.998000000 AM','portaladmin','16-JAN-17 05.28.36.998000000
                              * AM'); commit;
                              */
                              try {
                                             stmt = con.createStatement();
                                             String portalUserEntryQuery = "INSERT INTO "
                                                                           + defaultSchema
                                                                           + ".PORTAL_USER ( PORTAL_USER_ID,USER_NAME,EMAIL_OPT_IN_IND,GUID,UPDATE_NU,CREATED_BY,CREATION_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE ) VALUES ( (SELECT MAX(PORTAL_USER_ID) FROM portal_user)+1,'"
                                                                           + userName
                                                                           + "','N','367c9a44d9076499:-2cd46151:1599308a8fb:-7fdb',8,'portaladmin','13-JAN-17 08.01.56.509000000 PM','portaladmin','15-JAN-17 11.47.14.428000000 PM')";
                                             String portalUserAccountEntryQuery = "INSERT INTO "
                                                                           + defaultSchema
                                                                           + ".PORTAL_USER_ACCOUNT(PORTAL_USER_ACCOUNT_ID,PORTAL_USER_ID,INDIVIDUAL_ID,ACCOUNT_ID,BUSINESS_TYPE,GUID,UPDATE_NU,CREATED_BY,CREATION_DATE,LAST_MODIFIED_BY,LAST_MODIFIED_DATE )  VALUES(((SELECT MAX(PORTAL_USER_ACCOUNT_ID) FROM portal_user_Account)+1),(SELECT MAX(PORTAL_USER_ID) FROM portal_user),"
                                                                           + individualID
                                                                           + ","
                                                                           + accountID
                                                                           + ",'"
                                                                           + businessType
                                                                           + "','c7429fee012cdd44:-347aba25:1597345cc63:-6a7e',0,'portaladmin','16-JAN-17 05.28.36.998000000 AM','portaladmin','16-JAN-17 05.28.36.998000000 AM')";
                                             rs = stmt.executeQuery(portalUserEntryQuery);
                                             rs = stmt.executeQuery(portalUserAccountEntryQuery);
                                             rs = stmt.executeQuery(SQL_COMMIT);

                                             System.out.println(userName
                                                                           + " Entry Created in DATABASE successfully");

                              } catch (SQLException e) {
                                             System.out.println("ERROR:: Creating " + userName + " in DATABASE");
                                             e.printStackTrace();
                              }

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

               private static Map<String, String> getProperties() {
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

               public Map<String, String> getAMPMemberWithDesiredAttributes(
                                             List<String> desiredAttributes) {
                              Map<String, String> loginCreds = new HashMap<String, String>();
                              for (Entry<String, List<String>> currEntry : ampMemberAttributesMap
                                                            .entrySet()) {
                                             if (currEntry.getValue().equals(desiredAttributes)) {
                                                            if (currEntry.getKey().contains("/")) {
                                                                           String[] keyArr = currEntry.getKey().split("/");
                                                                           loginCreds.put("user", keyArr[0]);
                                                                           loginCreds.put("pwd", keyArr[1]);
                                                                           return loginCreds;
                                                            } else {
                                                                           loginCreds.put("user", currEntry.getKey());
                                                                           loginCreds.put("pwd", "Password@1");
                                                                           return loginCreds;
                                                            }

                                             }
                              }
                              // No match found
                              return null;
               }

               public Map<String, String> getUMSMemberWithDesiredAttributes(
                                             List<String> desiredAttributes) {
                              Map<String, String> loginCreds = new HashMap<String, String>();
                              for (Entry<String, List<String>> currEntry : umsMemberAttributesMap
                                                            .entrySet()) {
                                             if (currEntry.getValue().equals(desiredAttributes)) {
                                                            if (currEntry.getKey().contains("/")) {
                                                                           String[] keyArr = currEntry.getKey().split("/");
                                                                           loginCreds.put("user", keyArr[0]);
                                                                           loginCreds.put("pwd", keyArr[1]);
                                                                           return loginCreds;
                                                            } else {
                                                                           loginCreds.put("user", currEntry.getKey());
                                                                           loginCreds.put("pwd", "Password@1");
                                                                           return loginCreds;
                                                            }

                                             }
                              }
                              // No match found
                              return null;
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
                                             stream = new FileInputStream(parentDirectory + DIRECTORY
                                                                           + directory + fileName);
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
                              /* String response = Charset.defaultCharset().decode(bb).toString(); */
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

/*           public WebDriver getWebDriver() {

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

/*                                         String phantomjs = System.getProperty("phantomjs");
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
               }

               public WebDriver getWebDriver() {
                              File pathToBinary = new File("C:\\firefox 29\\firefox.exe");
                              FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
                              FirefoxProfile firefoxProfile = new FirefoxProfile();       
                              webDriver = new FirefoxDriver(ffBinary,firefoxProfile);
                              webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                              //webDriver.manage().window().maximize();
                              return webDriver;
               }
*/           
               public WebDriver getWebDriver() {
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
               return webDriver;
               }
               
               public WebDriver getIEDriver() {
                              System.setProperty("webdriver.ie.driver",
                                                            "C:/Users/pgupta15/Downloads/IEDriverServer_x64_2.27.0/IEDriverServer.exe");
                              DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
                              ieCaps.setCapability(
                                                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
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

               public void nullifyWebDriver() {
                              if (null != webDriver) {
                                             webDriver.close();
                                             webDriver = null;
                              }

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
            	   webDriver.quit();
               }
               
               
}
