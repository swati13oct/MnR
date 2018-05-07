$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("profileAndPreferences/My Profile and Preferences-UMS.feature");
formatter.feature({
  "line": 2,
  "name": "C1.2To test Profile and Preferences page .",
  "description": "",
  "id": "c1.2to-test-profile-and-preferences-page-.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@codeMonkeys1"
    }
  ]
});
formatter.scenarioOutline({
  "line": 275,
  "name": "To test end to end regression scenario for account profile page",
  "description": "",
  "id": "c1.2to-test-profile-and-preferences-page-.;to-test-end-to-end-regression-scenario-for-account-profile-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 274,
      "name": "@regressionProfAndPref"
    }
  ]
});
formatter.step({
  "line": 276,
  "name": "login with following details logins in the member portal and validate elements",
  "rows": [
    {
      "cells": [
        "User Type",
        "\u003cuserType\u003e"
      ],
      "line": 277
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 278,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 279,
  "name": "I click the HEALTHSAFE ID PASSWORD link and validate username and password",
  "keyword": "And "
});
formatter.step({
  "line": 280,
  "name": "I should see the breadcrumb  in the upper left side of the page",
  "keyword": "Then "
});
formatter.step({
  "line": 281,
  "name": "clicking the link should lead me back to the Account Settings page of the member site",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 282,
      "value": "#And the user validates the Email section in UMS site"
    }
  ],
  "line": 283,
  "name": "the user validates the Phone section",
  "keyword": "And "
});
formatter.step({
  "line": 284,
  "name": "the user Clicks on the the Edit phone Link and validates the elements",
  "keyword": "And "
});
formatter.step({
  "line": 285,
  "name": "the user validates Communication Preferences section",
  "keyword": "Then "
});
formatter.step({
  "line": 286,
  "name": "the user clicks on edit preferences link",
  "keyword": "And "
});
formatter.step({
  "line": 287,
  "name": "the user clicks on profile \u0026 preferences link to go back to Account settings page",
  "keyword": "And "
});
formatter.step({
  "line": 288,
  "name": "the user validates permanent address section",
  "keyword": "And "
});
formatter.step({
  "line": 289,
  "name": "the user validates the temporary address section",
  "keyword": "And "
});
formatter.step({
  "line": 290,
  "name": "the user validates the fields and Buttons of temp address section",
  "keyword": "And "
});
formatter.step({
  "line": 291,
  "name": "the user validates the Presence of edit button in Mailing Address section",
  "keyword": "And "
});
formatter.step({
  "line": 292,
  "name": "the user validates the fields under add mailing address button",
  "keyword": "Then "
});
formatter.examples({
  "line": 293,
  "name": "",
  "description": "",
  "id": "c1.2to-test-profile-and-preferences-page-.;to-test-end-to-end-regression-scenario-for-account-profile-page;",
  "rows": [
    {
      "cells": [
        "userType"
      ],
      "line": 294,
      "id": "c1.2to-test-profile-and-preferences-page-.;to-test-end-to-end-regression-scenario-for-account-profile-page;;1"
    },
    {
      "comments": [
        {
          "line": 295,
          "value": "#      | AARP    |"
        }
      ],
      "cells": [
        "UHC"
      ],
      "line": 296,
      "id": "c1.2to-test-profile-and-preferences-page-.;to-test-end-to-end-regression-scenario-for-account-profile-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 10847983,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 295,
      "value": "#      | AARP    |"
    }
  ],
  "line": 296,
  "name": "To test end to end regression scenario for account profile page",
  "description": "",
  "id": "c1.2to-test-profile-and-preferences-page-.;to-test-end-to-end-regression-scenario-for-account-profile-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 274,
      "name": "@regressionProfAndPref"
    },
    {
      "line": 1,
      "name": "@codeMonkeys1"
    }
  ]
});
formatter.step({
  "line": 276,
  "name": "login with following details logins in the member portal and validate elements",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "User Type",
        "UHC"
      ],
      "line": 277
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 278,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 279,
  "name": "I click the HEALTHSAFE ID PASSWORD link and validate username and password",
  "keyword": "And "
});
formatter.step({
  "line": 280,
  "name": "I should see the breadcrumb  in the upper left side of the page",
  "keyword": "Then "
});
formatter.step({
  "line": 281,
  "name": "clicking the link should lead me back to the Account Settings page of the member site",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 282,
      "value": "#And the user validates the Email section in UMS site"
    }
  ],
  "line": 283,
  "name": "the user validates the Phone section",
  "keyword": "And "
});
formatter.step({
  "line": 284,
  "name": "the user Clicks on the the Edit phone Link and validates the elements",
  "keyword": "And "
});
formatter.step({
  "line": 285,
  "name": "the user validates Communication Preferences section",
  "keyword": "Then "
});
formatter.step({
  "line": 286,
  "name": "the user clicks on edit preferences link",
  "keyword": "And "
});
formatter.step({
  "line": 287,
  "name": "the user clicks on profile \u0026 preferences link to go back to Account settings page",
  "keyword": "And "
});
formatter.step({
  "line": 288,
  "name": "the user validates permanent address section",
  "keyword": "And "
});
formatter.step({
  "line": 289,
  "name": "the user validates the temporary address section",
  "keyword": "And "
});
formatter.step({
  "line": 290,
  "name": "the user validates the fields and Buttons of temp address section",
  "keyword": "And "
});
formatter.step({
  "line": 291,
  "name": "the user validates the Presence of edit button in Mailing Address section",
  "keyword": "And "
});
formatter.step({
  "line": 292,
  "name": "the user validates the fields under add mailing address button",
  "keyword": "Then "
});
formatter.match({
  "location": "HSIDStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 90084600070,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 6137842100,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.i_click_the_HEALTHSAFE_ID_PASSWORD_link()"
});
formatter.result({
  "duration": 14395741453,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page()"
});
formatter.result({
  "duration": 294607384,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site()"
});
formatter.result({
  "duration": 9436923540,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.UserValidatesPhoneSection()"
});
formatter.result({
  "duration": 670739631,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"phoneCardHeight\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.116.84\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 308 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U0CND7075S37\u0027, ip: \u002710.137.94.11\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d42080882d8794787b3ecac8e44d26416, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 42080882d8794787b3ecac8e44d26416\n*** Element info: {Using\u003did, value\u003dphoneCardHeight}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy23.getText(Unknown Source)\r\n\tat atdd.framework.UhcDriver.scrollToView(UhcDriver.java:415)\r\n\tat atdd.framework.UhcDriver.validateNew(UhcDriver.java:499)\r\n\tat pages.regression.profileandpreferences.ProfileandPreferencesPage.validatePhoneElements(ProfileandPreferencesPage.java:865)\r\n\tat acceptancetests.memberredesign.Profileandpreferences.ProfileandPreferencesUMSStepDefinition.UserValidatesPhoneSection(ProfileandPreferencesUMSStepDefinition.java:489)\r\n\tat ✽.And the user validates the Phone section(profileAndPreferences/My Profile and Preferences-UMS.feature:283)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"phoneCardHeight\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.116.84\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U0CND7075S37\u0027, ip: \u002710.137.94.11\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8124471532679337012webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8124471532679337012webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8124471532679337012webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8124471532679337012webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8124471532679337012webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.UserClicksEditPhoneSection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescommunicationpreferncessection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.userClicksOnEditPrefLink()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.navigateBackToAccountSettingsPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatespermanentaddresssection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.tempaddress()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.UserClicksEdittempaddressSection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.UserValidatesMailAddEditNokia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.validateElementsInAddMailingAddress()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1219670520,
  "status": "passed"
});
formatter.after({
  "duration": 4514833,
  "status": "passed"
});
});