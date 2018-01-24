$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("profileAndPreferences/My Profile and Preferences-UMS.feature");
formatter.feature({
  "line": 2,
  "name": "To test Profile and Preferences page .",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "rows": [
    {
      "cells": [
        "\u003cplanType\u003e"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;",
  "rows": [
    {
      "cells": [
        "planType"
      ],
      "line": 15,
      "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;1"
    },
    {
      "cells": [
        "MAPD"
      ],
      "line": 16,
      "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;2"
    },
    {
      "cells": [
        "MA"
      ],
      "line": 17,
      "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 24341827,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 446426117549,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 894237333,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.116.110\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 523 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003daf8c7fe6aeb04887a9dc66166c08e195, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: af8c7fe6aeb04887a9dc66166c08e195\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.116.110\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2449577822627242162webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2449577822627242162webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2449577822627242162webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2449577822627242162webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2449577822627242162webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 5395327725,
  "status": "passed"
});
formatter.before({
  "duration": 249420,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 438153365774,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 895299009,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.38.192\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 524 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d4e3a1d238daa4f9d883ff305dcdb0204, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 4e3a1d238daa4f9d883ff305dcdb0204\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.38.192\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous6845892857504072428webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous6845892857504072428webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous6845892857504072428webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous6845892857504072428webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous6845892857504072428webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 6083430558,
  "status": "passed"
});
formatter.before({
  "duration": 231370,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 433763634820,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 911814464,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.50.107\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 538 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d221800eb4e614ace9c66d68689ca49dc, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 221800eb4e614ace9c66d68689ca49dc\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.50.107\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous4380525861702928776webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous4380525861702928776webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous4380525861702928776webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous4380525861702928776webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous4380525861702928776webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "duration": 4637980502,
  "status": "passed"
});
formatter.before({
  "duration": 186655,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MA"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 438398084471,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 900746044,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.37.73\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 533 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d58b65401f87f44e48a43ed522b217dbf, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 58b65401f87f44e48a43ed522b217dbf\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.37.73\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous7032872200564960496webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous7032872200564960496webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous7032872200564960496webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous7032872200564960496webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous7032872200564960496webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded3.png");
formatter.after({
  "duration": 4662743635,
  "status": "passed"
});
formatter.before({
  "duration": 203884,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MA"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 441728357077,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 943930973,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.27.17\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 552 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d9501c42f952a4d5dba46bfbd1853e824, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 9501c42f952a4d5dba46bfbd1853e824\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.27.17\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2797517504072624022webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2797517504072624022webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2797517504072624022webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2797517504072624022webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2797517504072624022webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded4.png");
formatter.after({
  "duration": 5953763369,
  "status": "passed"
});
formatter.before({
  "duration": 230139,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "To verify the edit functionality in Account Profile section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-the-edit-functionality-in-account-profile-section-in-ums-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@CMNeedhelp"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MA"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user validates the need help section",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user validates see more ways to contact us section",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user validates on clicking contact us link it should route to contact us page",
  "keyword": "And "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 446597813227,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 931004211,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.58.71\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 555 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003dd2d525ee79614e19928c79d1fa2db2c8, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: d2d525ee79614e19928c79d1fa2db2c8\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.When the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:9)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.58.71\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous5351953052125159453webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous5351953052125159453webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous5351953052125159453webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous5351953052125159453webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous5351953052125159453webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.Uservalidatesneedhelpsection()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.uservalidatescontactuslink()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded5.png");
formatter.after({
  "duration": 6351450738,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 18,
      "value": "# |PDP       |"
    },
    {
      "line": 19,
      "value": "# |SHIP      |"
    }
  ],
  "line": 23,
  "name": "To verify Plan Name, Member name, Member ID and account section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@CMValidatePlanNamemembernameIDAccountSectionUMS"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "registered member with following details for Profile and Preferences flow",
  "rows": [
    {
      "cells": [
        "\u003cplanType\u003e"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the user validates the Plan Name, Member name, Member ID and account section in UMS site",
  "keyword": "Then "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;",
  "rows": [
    {
      "cells": [
        "planType"
      ],
      "line": 30,
      "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;1"
    },
    {
      "cells": [
        "MAPD"
      ],
      "line": 31,
      "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;2"
    },
    {
      "cells": [
        "MA"
      ],
      "line": 32,
      "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 194039,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "To verify Plan Name, Member name, Member ID and account section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@CMValidatePlanNamemembernameIDAccountSectionUMS"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the user validates the Plan Name, Member name, Member ID and account section in UMS site",
  "keyword": "Then "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 435274680267,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 946077707,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.17.145\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 570 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003db503e601ca0340be8a5a955086b8f5eb, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: b503e601ca0340be8a5a955086b8f5eb\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.Then the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:26)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.17.145\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8835188321062850950webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8835188321062850950webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8835188321062850950webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8835188321062850950webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous8835188321062850950webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded6.png");
formatter.after({
  "duration": 5212993548,
  "status": "passed"
});
formatter.before({
  "duration": 434844,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "To verify Plan Name, Member name, Member ID and account section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@CMValidatePlanNamemembernameIDAccountSectionUMS"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the user validates the Plan Name, Member name, Member ID and account section in UMS site",
  "keyword": "Then "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
formatter.result({
  "duration": 438722087940,
  "status": "passed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage()"
});
formatter.result({
  "duration": 897798541,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.58.127\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 535 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003dd1f0de320d0b49eeb51f848042b5f260, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: d1f0de320d0b49eeb51f848042b5f260\n*** Element info: {Using\u003dxpath, value\u003d//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]}\r\n\tat sun.reflect.GeneratedConstructorAccessor17.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy22.click(Unknown Source)\r\n\tat pages.member.bluelayer.DashboardPage.navigateDirectToProfilePage(DashboardPage.java:78)\r\n\tat acceptancetests.memberrdesign.ProfileandPreferencesUMSStepDefinition.user_navigate_toProfileandPreferencespage(ProfileandPreferencesUMSStepDefinition.java:126)\r\n\tat ✽.Then the user navigates to Profile and Preferences page(profileAndPreferences/My Profile and Preferences-UMS.feature:26)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[@id\u003d\u0027dropdown toggle  1\u0027]/span[contains(text(),\u0027Profile\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u0027172.20.58.127\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6260H7X\u0027, ip: \u002710.198.85.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_51\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2099837949326060058webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2099837949326060058webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2099837949326060058webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2099837949326060058webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous2099837949326060058webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded7.png");
formatter.after({
  "duration": 5854179179,
  "status": "passed"
});
formatter.before({
  "duration": 190757,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "To verify Plan Name, Member name, Member ID and account section in UMS site",
  "description": "",
  "id": "to-test-profile-and-preferences-page-.;to-verify-plan-name,-member-name,-member-id-and-account-section-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@CMValidatePlanNamemembernameIDAccountSectionUMS"
    },
    {
      "line": 1,
      "name": "@codeMonkeys"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "registered member with following details for Profile and Preferences flow",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "MAPD"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "the user navigates to Profile and Preferences page",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "the user validates the Plan Name, Member name, Member ID and account section in UMS site",
  "keyword": "Then "
});
formatter.match({
  "location": "ProfileandPreferencesUMSStepDefinition.login_with_member(DataTable)"
});
