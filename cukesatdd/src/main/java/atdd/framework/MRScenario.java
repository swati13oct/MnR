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
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.stereotype.Component;

import acceptancetests.atdd.data.CommonConstants;


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

       private static Map<String, List<String>> ampRegistrationDataMap = new LinkedHashMap<String, List<String>>();

       private static Map<String, Map<String, JSONObject>> expectedDataMapUlayer = new LinkedHashMap<String, Map<String, JSONObject>>();

       private static Map<String, Map<String, JSONObject>> expectedDataMapBluelayer = new LinkedHashMap<String, Map<String, JSONObject>>();

       private static Map<String, List<String>> umsRegistrationDataMap = new LinkedHashMap<String, List<String>>();

       private static Map<String, String> props = new HashMap<String, String>();

       public static String environment, browser, TeamCEnvironment;

       private static final String DIRECTORY = "/src/main/resources/";
       public static int count = 0;

       public void saveBean(String id, Object object) {
              scenarioObjectMap.put(id, object);
       }

       public void flushBeans() {
              if (!scenarioObjectMap.isEmpty()) {
                     scenarioObjectMap.clear();
              }
       }

       WebDriver webDriver;

       public Object getBean(String id) {
              Object result = scenarioObjectMap.get(id);
              if (result == null) {
                     System.out.println("Object not initialized");
              }
              return result;

       }

       static {

              props = getProperties();
              browser = props.get("browser");
              /* Set acqusisition and member urls */
              environment = props.get("Environment");
              TeamCEnvironment=props.get("TeamCEnvironment");

              /* Set up DB */
              Connection con = getDBConnection(props);

              /* Get LDAP Context */
              DirContext ctx = getLdapContext(props);

              BufferedReader memberAmpTypeReader = null;
              BufferedReader memberUmsTypeReader = null;

              String line = "";
              String cvsSplitBy = ",";
              String defaultSchema = props.get(CommonConstants.DB_SCHEMA);

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
                           String userName = null;
                           if (memberAttributes[0].contains("/")) {
                                  String[] memberAttributArr = memberAttributes[0].split("/");
                                  userName = memberAttributArr[0];

                           } else {
                                  userName = memberAttributes[0];

                           }
                           boolean memberFound = true;
                           if (!ampMemberAttributesMap.isEmpty()) {
                                  boolean memberExists = false;
                                  for (String key : ampMemberAttributesMap.keySet()) {
                                         if (ampMemberAttributesMap.get(key).equals(attrList)) {
                                                memberExists = true;

                                         }
                                  }
                                  if (!memberExists) {
                                         // memberFound = checkMemberFound(userName, con, ctx,
                                         // defaultSchema);
                                  }
                           } else {
                                  // memberFound = checkMemberFound(userName, con, ctx,
                                  // defaultSchema);
                           }

                           if (memberFound) {
                                  ampMemberAttributesMap.put(memberAttributes[0], attrList);
                           }

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
                           String userName = null;
                           if (memberAttributes[0].contains("/")) {
                                  String[] memberAttributArr = memberAttributes[0].split("/");
                                  userName = memberAttributArr[0];

                           } else {
                                  userName = memberAttributes[0];

                           }
                           boolean memberFound = true;
                           if (!umsMemberAttributesMap.isEmpty()) {
                                  boolean memberExists = false;
                                  for (String key : umsMemberAttributesMap.keySet()) {
                                         if (umsMemberAttributesMap.get(key).equals(attrList)) {
                                                memberExists = true;

                                         }
                                  }
                                  if (!memberExists) {
                                         // memberFound = checkMemberFound(userName, con, ctx,
                                         // defaultSchema);
                                  }
                           } else {
                                  // memberFound = checkMemberFound(userName, con, ctx,
                                  // defaultSchema);
                           }

                           if (memberFound) {
                                  umsMemberAttributesMap.put(memberAttributes[0], attrList);
                           }

                     }
                     InputStream ampMemberTypeStream = ClassLoader.class
                                  .getResourceAsStream("/database/AMP-Registration-data.csv");
                     BufferedReader registermemberReader = new BufferedReader(
                                  new InputStreamReader(ampMemberTypeStream));
                     while ((line = registermemberReader.readLine()) != null) {
                           // use comma as separator
                           String[] memberAttributes = line.split(cvsSplitBy);
                           List<String> attrList = Arrays.asList(memberAttributes)
                                         .subList(1, memberAttributes.length);
                           String userName = memberAttributes[0];
                           ampRegistrationDataMap.put(userName, attrList);

                     }

                     InputStream umsMemberTypeStream = ClassLoader.class
                                  .getResourceAsStream("/database/UMS-Registration-data.csv");
                     BufferedReader umsRegistermemberReader = new BufferedReader(
                                  new InputStreamReader(umsMemberTypeStream));
                     while ((line = umsRegistermemberReader.readLine()) != null) {
                           // use comma as separator
                           String[] memberAttributes = line.split(cvsSplitBy);
                           List<String> attrList = Arrays.asList(memberAttributes)
                                         .subList(1, memberAttributes.length);
                           String userName = memberAttributes[0];
                           umsRegistrationDataMap.put(userName, attrList);

                     }
                     List<String> tempList = new ArrayList<String>();
                     tempList.add("MAPD_TestOnly");
                     tempList.add("Individual");
                     umsMemberAttributesMap.put("Dec_Sierra_001", tempList);
              } catch (IOException e) {
                     e.printStackTrace();
              } finally {
                     try {
                           if (memberAmpTypeReader != null) {
                                  memberAmpTypeReader.close();
                           }
                     } catch (IOException e) {
                           e.printStackTrace();
                     }
                     try {
                           con.close();
                     } catch (SQLException e1) {
                           e1.printStackTrace();
                     }
                     try {
                           ctx.close();
                     } catch (Exception e) {
                           e.printStackTrace();
                     }
              }

              populateExpectedDataMap();

       }

       private static boolean checkMemberFound(String userName, Connection con,
                     DirContext ctx, String defaultSchema) {
              Statement stmt;
              ResultSet rs = null;
              try {
                     stmt = con.createStatement();
                     String query = "select * from " + defaultSchema
                                  + ".PORTAL_USER where USER_NAME='" + userName + "'";
                     System.out.println("query--->" + query);
                     rs = stmt.executeQuery(query);
              } catch (SQLException e) {
                     e.printStackTrace();
              }

              try {

                     Object user = null;
                     try {
                           user = ctx.lookup(buildUserDistinguishedName(userName));
                     } catch (NamingException e) {
                           System.out.println("member not found in ldap");
                     }

                     if (rs.next() && user != null) {

                           return true;

                     } else {

                           System.out.println("member not found in database and ldap");

                     }
              } catch (SQLException e) {
                     e.printStackTrace();
              }

              return false;
       }

       private static DirContext getLdapContext(Map<String, String> props) {
              Hashtable<String, String> env = new Hashtable<String, String>();
              env.put(Context.INITIAL_CONTEXT_FACTORY,
                           "com.sun.jndi.ldap.LdapCtxFactory");
              env.put(Context.PROVIDER_URL, props.get(CommonConstants.LDAP_URL)
                           + props.get(CommonConstants.LDAP_BASE));
              env.put(Context.SECURITY_PRINCIPAL,
                           props.get(CommonConstants.LDAP_USER));
              env.put(Context.SECURITY_CREDENTIALS,
                           props.get(CommonConstants.LDAP_PASSWORD));
              DirContext ctx = null;
              try {
                     ctx = new InitialDirContext(env);
              } catch (NamingException e) {
                     e.printStackTrace();
              }
              return ctx;

       }

       private static Connection getDBConnection(Map<String, String> props) {
              try {
                     Class.forName("oracle.jdbc.driver.OracleDriver");
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
              Connection connection = null;
              try {
                     connection = DriverManager.getConnection(
                                  props.get(CommonConstants.DB_URL),
                                  props.get(CommonConstants.DB_USERNAME),
                                  props.get(CommonConstants.DB_PASSWORD));
              } catch (SQLException e) {
                     e.printStackTrace();
              }
              return connection;

       }

       public void removeMember() {

              Map<String, String> props = getProperties();

              /* Set up DB */
              Connection con = getDBConnection(props);

              /* Get LDAP Context */
              DirContext ctx = getLdapContext(props);

              /* Default Schema */
              String defaultSchema = props.get(CommonConstants.DB_SCHEMA);

              Statement stmt;
              ResultSet rs = null;

              for (String userName : umsRegistrationDataMap.keySet()) {

                     try {
                           stmt = con.createStatement();
                           String query = "select * from " + defaultSchema
                                         + ".PORTAL_USER where USER_NAME='" + userName + "'";
                           System.out.println("query--->" + query);
                           rs = stmt.executeQuery(query);
                     } catch (SQLException e) {
                           e.printStackTrace();
                     }

                     try {

                           Object user = null;
                           try {
                                  user = ctx.lookup(buildUserDistinguishedName(userName));
                           } catch (NamingException e) {
                                  System.out.println("member not found in ldap");
                           }

                           /* Checking in LDAP */
                           if (user != null) {
                                  ctx.unbind(buildUserDistinguishedName(userName));
                                  System.out.println("USERNAME " + userName
                                                + " removed from LDAP");

                           } else {
                                  System.out.println("member not found in ldap :: USERNAME "
                                                + userName + " NOT REGISTERED");
                           }

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
                                  System.out.println("query--->" + query);
                                  rs = stmt.executeQuery(query);
                                  System.out.println("query--->" + query1);
                                  rs = stmt.executeQuery(query1);

                                  System.out.println("USERNAME " + userName
                                                + " :: deleted from PORTAL_USER table");

                           } else {

                                  System.out.println("USERNAME " + userName
                                                + " :: member not found in database");
                           }

                     } catch (SQLException e) {
                           e.printStackTrace();
                     } catch (NamingException e) {
                           e.printStackTrace();
                     }

              }

              for (String userName : ampRegistrationDataMap.keySet()) {
                     try {
                           stmt = con.createStatement();
                           String query = "select * from " + defaultSchema
                                         + ".PORTAL_USER where USER_NAME='" + userName + "'";
                           System.out.println("query--->" + query);
                           rs = stmt.executeQuery(query);
                     } catch (SQLException e) {
                           e.printStackTrace();
                     }

                     try {

                           Object user = null;
                           try {
                                  user = ctx.lookup(buildUserDistinguishedName(userName));
                           } catch (NamingException e) {
                                  System.out.println("member not found in ldap");
                           }

                           /* Checking in LDAP */
                           if (user != null) {
                                  ctx.unbind(buildUserDistinguishedName(userName));
                                  System.out.println("USERNAME " + userName
                                                + " removed from LDAP");

                           } else {
                                  System.out.println("member not found in ldap :: USERNAME "
                                                + userName + " NOT REGISTERED");
                           }

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
                                  System.out.println("query--->" + query);
                                  rs = stmt.executeQuery(query);
                                  System.out.println("query--->" + query1);
                                  rs = stmt.executeQuery(query1);

                                  System.out.println("USERNAME " + userName
                                                + " :: deleted from PORTAL_USER table");

                           } else {

                                  System.out.println("USERNAME " + userName
                                                + " :: member not found in database");
                           }

                     } catch (SQLException e) {
                           e.printStackTrace();
                     } catch (NamingException e) {
                           e.printStackTrace();
                     }
              }
              try {
                     /* Closing database connection */
                     con.close();
              } catch (SQLException e) {
                     e.printStackTrace();
              }

              try {
                     /* Closing LDAP connection */
                     ctx.close();
              } catch (NamingException e) {
                     e.printStackTrace();
              }
       }

       private static Map<String, String> getProperties() {
              Map<String, String> props = new HashMap<String, String>();
              Properties prop = new Properties();
              String propertiesFileToPick = System.getProperty("environment");
              String webdriverpickup = System.getProperty("webdriver_browser");
              System.out.println("************* test which webdriver is picked up  **********"+webdriverpickup);
              System.out.println("Using properties for environment ...."
                           + propertiesFileToPick);
              if (StringUtils.isBlank(propertiesFileToPick)) {
                     System.out
                     .println("Using CI as default since environment was not passed in !!!");
                     propertiesFileToPick = CommonConstants.DEFAULT_ENVIRONMENT_CI; 
              }
              String configPropertyName = findBrowserTypeConfigurationFile(webdriverpickup);
              // Read properties from classpath
              StringBuffer propertyFilePath = new StringBuffer(
                           CommonConstants.PROPERTY_FILE_FOLDER);
              propertyFilePath.append("/").append(propertiesFileToPick).append("/").append(configPropertyName!=null?configPropertyName:CommonConstants.PROPERTY_FILE_NAME);
           //   .append(CommonConstants.PROPERTY_FILE_NAME);
              System.out.println("********** property file path is **************: "+ propertyFilePath);
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
       
       private static String findBrowserTypeConfigurationFile(String browserType){
    	   String configFile=null;
    	   if(browserType==null)
    		   return configFile;
    	   
    	   if(browserType.equalsIgnoreCase("saucelabs")){
    		   configFile = CommonConstants.PROPERTY_FILE_NAME;
    	   }else if(browserType.equalsIgnoreCase("saucelabs_firefox")){
    		   configFile = CommonConstants.FIREFOXPROPERTY_FILE_NAME;
    	   }else if(browserType.equalsIgnoreCase("saucelabs_android")){
    		   configFile = CommonConstants.ANDROIDPROPERTY_FILE_NAME;
    	   }else if(browserType.equalsIgnoreCase("saucelabs_chrome")){
    		   configFile = CommonConstants.CHROMEPROPERTY_FILE_NAME;
    	   }else if(browserType.equalsIgnoreCase("saucelabs_safari")){
    		   configFile = CommonConstants.SAFARIPROPERTY_FILE_NAME;
    	   }else if(browserType.equalsIgnoreCase("saucelabs_ie")){
    		   configFile = CommonConstants.IEPROPERTY_FILE_NAME;
    	   }      	       	       	   
    	   return configFile;    	   
       }

       private static Name buildUserDistinguishedName(String userName) {
              DistinguishedName dn = new DistinguishedName();
              dn.add(CommonConstants.UID, userName);
              return dn;
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

       private static void populateExpectedDataMap() {
              Set<String> ampKeySet = ampMemberAttributesMap.keySet();
              for (String ampKey : ampKeySet) {

                     if (ampKey.contains("/")) {
                           String arr[] = ampKey.split("/");
                           ampKey = arr[0];
                     }
                     Map<String, JSONObject> ampObjectMap = new HashMap<String, JSONObject>();
                     for (int i = 0; i < CommonConstants.PAGES.length; i++) {
                           JSONObject jsonObject = readExpectedJson(ampKey,
                                         CommonConstants.PAGES[i].getDirectory());
                           if (jsonObject != null) {
                                  ampObjectMap.put(CommonConstants.PAGES[i].getPageName(),
                                                jsonObject);
                           }
                     }
                     if (!ampObjectMap.isEmpty())
                           expectedDataMapUlayer.put(ampKey, ampObjectMap);

              }

              // setting expectedDataMap for ulayer and blue layer for registration
              Set<String> keySetAmp = ampRegistrationDataMap.keySet();
              for (String ampKey : keySetAmp) {
                     Map<String, JSONObject> ampObjectMap = new HashMap<String, JSONObject>();
                     for (int i = 0; i < CommonConstants.PAGES.length; i++) {
                           JSONObject jsonObject = readExpectedJson(ampKey,
                                         CommonConstants.PAGES[i].getDirectory());
                           if (jsonObject != null) {
                                  ampObjectMap.put(CommonConstants.PAGES[i].getPageName(),
                                                jsonObject);
                           }
                     }
                     if (!ampObjectMap.isEmpty())
                           expectedDataMapUlayer.put(ampKey, ampObjectMap);
              }

              Set<String> keySetUms = umsRegistrationDataMap.keySet();
              for (String umsKey : keySetUms) {               
                     Map<String, JSONObject> umsObjectMap = new HashMap<String, JSONObject>();
                     for (int i = 0; i < CommonConstants.PAGES_BLUELAYER.length; i++) {
                           JSONObject jsonObject = readExpectedJson(umsKey,
                                         CommonConstants.PAGES_BLUELAYER[i].getDirectory());
                           if (jsonObject != null) {
                                  umsObjectMap.put(
                                                CommonConstants.PAGES_BLUELAYER[i].getPageName(),
                                                jsonObject);
                           }
                     }
                     if (!umsObjectMap.isEmpty())
                           expectedDataMapBluelayer.put(umsKey, umsObjectMap);
              }

              Set<String> umsKeySet = umsMemberAttributesMap.keySet();
              for (String umsKey : umsKeySet) {

                     if (umsKey.contains("/")) {
                           String arr[] = umsKey.split("/");
                           umsKey = arr[0];
                     }
                     Map<String, JSONObject> umsObjectMap = new HashMap<String, JSONObject>();
                     for (int i = 0; i < CommonConstants.PAGES_BLUELAYER.length; i++) {
                           JSONObject jsonObject = readExpectedJson(umsKey,
                                         CommonConstants.PAGES_BLUELAYER[i].getDirectory());
                           if (jsonObject != null) {
                                  umsObjectMap.put(
                                                CommonConstants.PAGES_BLUELAYER[i].getPageName(),
                                                jsonObject);
                           }
                     }
                     if (!umsObjectMap.isEmpty())
                           expectedDataMapBluelayer.put(umsKey, umsObjectMap);

              }

              Set<String> registrationAmpKeySet = ampRegistrationDataMap.keySet();
              for (String registrationKey : registrationAmpKeySet) {
                     if (ampRegistrationDataMap.get(registrationKey).size() > 2) {
                           List<String> value = ampRegistrationDataMap
                                         .get(registrationKey);
                           List<String> subValue = value.subList(1, 3);
                           if (!subValue.isEmpty()) {
                                  String[] key = { value.get(0) + "_" + value.get(1),
                                                subValue.get(1) + "_" + subValue.get(0) };
                                  for (int j = 0; j < key.length; j++) {
                                         Map<String, JSONObject> pageObjectMap = new HashMap<String, JSONObject>();
                                         for (int i = 0; i < CommonConstants.PAGES_REGISTRATION_ULAYER.length; i++) {
                                                JSONObject jsonObject = readExpectedJson(
                                                              key[j],
                                                              CommonConstants.PAGES_REGISTRATION_ULAYER[i]
                                                                           .getDirectory());
                                                if (jsonObject != null) {
                                                       pageObjectMap
                                                       .put(CommonConstants.PAGES_REGISTRATION_ULAYER[i]
                                                                     .getPageName(), jsonObject);
                                                }

                                         }
                                         if (!pageObjectMap.isEmpty())
                                                expectedDataMapUlayer.put(key[j], pageObjectMap);
                                  }
                           }
                     } else {
                           String key = ampRegistrationDataMap.get(registrationKey).get(0)
                                         + "_"
                                         + ampRegistrationDataMap.get(registrationKey).get(1);
                           Map<String, JSONObject> pageObjectMap = new HashMap<String, JSONObject>();
                           for (int i = 0; i < CommonConstants.PAGES_REGISTRATION_ULAYER.length; i++) {
                                  JSONObject jsonObject = readExpectedJson(key,
                                                CommonConstants.PAGES_REGISTRATION_ULAYER[i]
                                                              .getDirectory());
                                  if (jsonObject != null) {
                                         pageObjectMap.put(
                                                       CommonConstants.PAGES_REGISTRATION_ULAYER[i]
                                                                     .getPageName(), jsonObject);
                                  }

                           }
                           if (!pageObjectMap.isEmpty())
                                  expectedDataMapUlayer.put(key, pageObjectMap);
                     }

              }

              Set<String> registrationUmsKeySet = umsRegistrationDataMap.keySet();
              for (String registrationKey : registrationUmsKeySet) {
                     if (umsRegistrationDataMap.get(registrationKey).size() > 2) {
                           List<String> value = umsRegistrationDataMap
                                         .get(registrationKey);
                           List<String> subValue = value.subList(1, 3);
                           if (!subValue.isEmpty()) {
                                  String[] key = { value.get(0) + "_" + value.get(1),
                                                subValue.get(1) + "_" + subValue.get(0) };
                                  for (int j = 0; j < key.length; j++) {
                                         Map<String, JSONObject> pageObjectMap = new HashMap<String, JSONObject>();
                                         for (int i = 0; i < CommonConstants.PAGES_REGISTRATION_BLUELAYER.length; i++) {
                                                JSONObject jsonObject = readExpectedJson(
                                                              key[j],
                                                              CommonConstants.PAGES_REGISTRATION_BLUELAYER[i]
                                                                           .getDirectory());
                                                if (jsonObject != null) {
                                                       pageObjectMap
                                                       .put(CommonConstants.PAGES_REGISTRATION_BLUELAYER[i]
                                                                     .getPageName(), jsonObject);
                                                }

                                         }
                                         if (!pageObjectMap.isEmpty())
                                                expectedDataMapBluelayer.put(key[j], pageObjectMap);
                                  }
                           }
                     } else {
                           String key = umsRegistrationDataMap.get(registrationKey).get(0)
                                         + "_"
                                         + umsRegistrationDataMap.get(registrationKey).get(1);
                           Map<String, JSONObject> pageObjectMap = new HashMap<String, JSONObject>();
                           for (int i = 0; i < CommonConstants.PAGES_REGISTRATION_BLUELAYER.length; i++) {
                                  JSONObject jsonObject = readExpectedJson(key,
                                                CommonConstants.PAGES_REGISTRATION_BLUELAYER[i]
                                                              .getDirectory());
                                  if (jsonObject != null) {
                                         pageObjectMap.put(
                                                       CommonConstants.PAGES_REGISTRATION_BLUELAYER[i]
                                                                     .getPageName(), jsonObject);
                                  }

                           }
                           if (!pageObjectMap.isEmpty())
                                  expectedDataMapBluelayer.put(key, pageObjectMap);
                     }
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
                     e.printStackTrace();
              }

              // Need to update here a method to replace special characters with
              // \special Characters
              try {
                     if (!response.isEmpty()) {
                           jsonObject = new JSONObject(response);
                     }
              } catch (JSONException e) {
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
           String browser = (null == System.getProperty(CommonConstants.JENKINS_BROWSER)
                           ? props.get("WebDriver") : System.getProperty(CommonConstants.JENKINS_BROWSER));
               System.out.println("getWebDriver, returning driver " + browser);
               String browserName = (null == System.getProperty(CommonConstants.BROWSER_NAME)
                           ? props.get("BrowserName") : System.getProperty(CommonConstants.BROWSER_NAME));
              if (null == webDriver) { 
                     System.out.println("New WebDriver CREATED");
                     // Again, Jenkins takes precedent. 
                      String pathToBinary = (null == System.getProperty("phantomjs") ? props.get("BrowserPathToBinary")
                                  : System.getProperty("phantomjs"));
                     System.out.println(pathToBinary);
                if (browser.trim().equalsIgnoreCase(CommonConstants.SAUCE_BROWSER_WEB.trim())) {
                            System.out.println("Execution is Going to Start on SauceLabs Web.....!!!!!");
                 DesiredCapabilities capabilities = null;
                 if(browserName.equalsIgnoreCase("firefox")){
                      System.out.println("Inside firefox");
                 capabilities = DesiredCapabilities.firefox();
                 capabilities.setCapability("platform", "Windows 7");
                 capabilities.setCapability("version", "45");
                 }if(browserName.equals("IE")){
                	 capabilities = DesiredCapabilities.internetExplorer();
                	 capabilities.setCapability("platform", "Windows 7");
                	 capabilities.setCapability("version", "11.0");
                 }if(browserName.equals("Chrome")){
                	 capabilities = DesiredCapabilities.chrome();
                	 capabilities.setCapability("platform", "Windows 7");
                	 capabilities.setCapability("version", "61.0");
                 }
                 capabilities.setCapability("autoAcceptsAlerts", true);
                 capabilities.setCapability("parent-tunnel", "sauce_admin");
                 capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
                 /*String USERNAME = "apriyad4";
                 String ACCESS_KEY = "6e1345f1-80ea-4863-8573-187bf3151ac0";*/
                 String USERNAME = "ucpadmin";
                 String ACCESS_KEY = "2817affd-616e-4c96-819e-4583348d7b37";
                 /*String USERNAME = "apriyad4";
                 String ACCESS_KEY = "6e1345f1-80ea-4863-8573-187bf3151ac0";*/
                 String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
                 String jobName = "MnR test Execution of [" +System.getProperty("test")  +":] - Using " + capabilities.getBrowserName() + " in  " + environment +" environment";
             	 capabilities.setCapability("name", jobName);
                 if (USERNAME == null || ACCESS_KEY == null) {
                        Assert.fail(
                                      "Missing value for environment variable(s) SAUCE_USERNAME or SAUCE_ACCESS_KEY.  Check environment configuration and try again");
                 }
                 try {
                        webDriver = new RemoteWebDriver(new URL(URL), capabilities);
                 } catch (MalformedURLException e) {
                        Assert.fail("Invalid Sauce URL: [" + URL + "]");
                 }
                 return webDriver;
                 }
                  //https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
                 
                 else if (browser.trim().equalsIgnoreCase(CommonConstants.SAUCE_BROWSER_MOBILE.trim())){
                 	System.out.println("Execution is Going to Start on SauceLabs Mobile.....!!!!!");
                 	DesiredCapabilities capabilities = null;
                 if(browserName.equalsIgnoreCase("Safari")){
                      capabilities = DesiredCapabilities.iphone();
                 }else{
                      capabilities = DesiredCapabilities.android();
                 }
                 System.out.println("CHECK THE VALUES************: "+props.get(CommonConstants.DEVICE_VERSION)+" "+props.get(CommonConstants.DEVICE_NAME)+" "
                            +""+props.get(CommonConstants.PLATFORM_VERSION)+" "+props.get(CommonConstants.PLATFORM_NAME)+" "+browserName);
                 //TODO: check the values
                 
                 capabilities.setCapability("appiumVersion", props.get(CommonConstants.DEVICE_VERSION).trim());
                 capabilities.setCapability("deviceName",props.get(CommonConstants.DEVICE_NAME).trim());
                 capabilities.setCapability("deviceOrientation", "portrait");
                 capabilities.setCapability("browserName", browserName.trim());
                 capabilities.setCapability("platformVersion", props.get(CommonConstants.PLATFORM_VERSION).trim());
                 capabilities.setCapability("platformName",props.get(CommonConstants.PLATFORM_NAME).trim());                          
                 capabilities.setCapability("autoAcceptsAlerts", true);
                 capabilities.setCapability("parent-tunnel", "sauce_admin");
                 capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
                 String jobName = "MnR test Execution of [" +System.getProperty("test")  +":] - Using " + capabilities.getBrowserName() + " in  " + environment +" environment";
             	 capabilities.setCapability("name", jobName);
                 String USERNAME = "ucpadmin";
                 String ACCESS_KEY = "2817affd-616e-4c96-819e-4583348d7b37";
             	 /*String USERNAME = "pdas101";
                 String ACCESS_KEY = "7b410de4-e6b2-4af6-98fc-2758bceba3f0";*/
                     String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
                     if (USERNAME == null || ACCESS_KEY == null) {
                            Assert.fail(
                                          "Missing value for environment variable(s) SAUCE_USERNAME or SAUCE_ACCESS_KEY.  Check environment configuration and try again");
                     }
                     try {
                            webDriver = new RemoteWebDriver(new URL(URL), capabilities);
                     } catch (MalformedURLException e) {
                            Assert.fail("Invalid Sauce URL: [" + URL + "]");
                     }
                 }else
                 	if (browser.trim().equalsIgnoreCase(CommonConstants.PERFECTO.trim())) {
        	              DesiredCapabilities capabilities = null;
        	              String host = props.get("PERFECTO_HOST");
        	              String perfectoUserNAme = props.get("PERFECTO_USERNAME");
        	              String PerfectoPassword = props.get("PERFECTO_PASSWORD");
        	              String URL = "https://" + host + "/nexperience/perfectomobile/wd/hub";
        	              String browserAny = "mobileOS";
        	              String deviceID;
        	              RemoteWebDriver remoteDriver = null;

        	              if (perfectoUserNAme == null || PerfectoPassword == null) {
        	                     Assert.fail(
        	                                  "Missing value for environment variable(s) cloudUser or cloudPw.  Check environment configuration and try again");
        	              }
        	              	 deviceID = getDeviceId(props.get("DeviceName"));
   	                     capabilities = new DesiredCapabilities(browserAny, "", Platform.ANY);

   	                     // define credentials for the CQ Lab connection
   	                     capabilities.setCapability("user", perfectoUserNAme);
   	                     capabilities.setCapability("password", PerfectoPassword);
   	                     capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   	                     capabilities.setCapability("outputReport", false);
   	                     capabilities.setCapability("outputVideo", false);
   	                     
   	                   

   	                     // Selecting Device By Device Id
   	                     capabilities.setCapability("deviceName", deviceID);
   	                     
   	                     try {
   	                    	 remoteDriver = new RemoteWebDriver(new URL(URL), capabilities);
        	                     
   	                    	 remoteDriver.manage().deleteAllCookies();
        	                     
        	              } catch (MalformedURLException e) {
        	            	  Assert.fail("Invalid Perfecto URL: [" + URL + "]"+ e);
        	              }
   	                    return remoteDriver;
        			}
               	}
              return webDriver;
       }
              
      
             
             
           /* if (null == webDriver) {                   
                 String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
                         // "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; LG-LU3000 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
                 File pathToBinary = new File("C:/Users/pdas101/AppData/Local/Mozilla Firefox/firefox.exe");
                 FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
                 FirefoxProfile firefoxProfile = new FirefoxProfile();
                 firefoxProfile.setPreference("general.useragent.override", userAgent);
                 webDriver = new FirefoxDriver(ffBinary, firefoxProfile);
                 webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
              }
             return webDriver;
       } */


     // } 	

public String getDeviceId(String deviceName){
	 Map<String ,String> devices = new HashMap<String, String>();
	 devices.put("iPadMini3", props.get("iPadMini3"));
	 devices.put("iphone_6", props.get("iphone_6"));
	 devices.put("iphone6Plus", props.get("iphone6Plus"));
	 devices.put("iPhone_7", props.get("iPhone_7"));
	 devices.put("iPhone_5s", props.get("iPhone_5s"));
	 devices.put("GalaxyS6", props.get("GalaxyS6"));
	 return devices.get(deviceName);
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
              //webDriver = new ChromeDriver();
              return webDriver;
       }

       public void nullifyWebDriver() {
              if (null != webDriver) {
                //     webDriver.close();
                     webDriver.quit();
                     webDriver = null;
              }

       }

}
