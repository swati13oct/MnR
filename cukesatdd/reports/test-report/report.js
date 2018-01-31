$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("payments/ulayer/MakeOneTimePayment-AARP.feature");
formatter.feature({
  "line": 2,
  "name": "To test the payment flow on AARP site",
  "description": "",
  "id": "to-test-the-payment-flow-on-aarp-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@payments"
    }
  ]
});
formatter.scenarioOutline({
  "line": 261,
  "name": "Verify the Timestamp on Automatic Payment Submitted page",
  "description": "",
  "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 260,
      "name": "@TeamHAuto"
    },
    {
      "line": 260,
      "name": "@theSpartans1"
    }
  ]
});
formatter.step({
  "line": 262,
  "name": "TimeStampTheSpartans the user is on the Team-H AARP medicare site login page",
  "keyword": "Given "
});
formatter.step({
  "line": 263,
  "name": "TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 264
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 265,
  "name": "TimeStampTheSpartans the user navigates to Stage PaymentOverview Page",
  "keyword": "And "
});
formatter.step({
  "line": 266,
  "name": "TimeStampTheSpartans the user navigates to Team H Automatic Payments page",
  "keyword": "And "
});
formatter.step({
  "line": 267,
  "name": "TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 268,
  "name": "TimeStampTheSpartans user lands on Review One time Payments Page and navigates to Review Submitted Page",
  "keyword": "And "
});
formatter.step({
  "line": 269,
  "name": "TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp",
  "keyword": "Then "
});
formatter.examples({
  "line": 271,
  "name": "",
  "description": "",
  "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page;",
  "rows": [
    {
      "cells": [
        "planType"
      ],
      "line": 272,
      "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page;;1"
    },
    {
      "cells": [
        "UHCFED"
      ],
      "line": 273,
      "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 14257197,
  "status": "passed"
});
formatter.scenario({
  "line": 273,
  "name": "Verify the Timestamp on Automatic Payment Submitted page",
  "description": "",
  "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 260,
      "name": "@TeamHAuto"
    },
    {
      "line": 1,
      "name": "@payments"
    },
    {
      "line": 260,
      "name": "@theSpartans1"
    }
  ]
});
formatter.step({
  "line": 262,
  "name": "TimeStampTheSpartans the user is on the Team-H AARP medicare site login page",
  "keyword": "Given "
});
formatter.step({
  "line": 263,
  "name": "TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "UHCFED"
      ],
      "line": 264
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 265,
  "name": "TimeStampTheSpartans the user navigates to Stage PaymentOverview Page",
  "keyword": "And "
});
formatter.step({
  "line": 266,
  "name": "TimeStampTheSpartans the user navigates to Team H Automatic Payments page",
  "keyword": "And "
});
formatter.step({
  "line": 267,
  "name": "TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 268,
  "name": "TimeStampTheSpartans user lands on Review One time Payments Page and navigates to Review Submitted Page",
  "keyword": "And "
});
formatter.step({
  "line": 269,
  "name": "TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp",
  "keyword": "Then "
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_TeamHlogin_page()"
});
formatter.result({
  "duration": 10009113300,
  "status": "passed"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_logs_inTeamH(DataTable)"
});
formatter.result({
  "duration": 599447992,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"username\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.24.219\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nCommand duration or timeout: 587 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6503PQC\u0027, ip: \u002710.192.29.87\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, hasMetadata\u003dtrue, databaseEnabled\u003dtrue, handlesAlerts\u003dtrue, version\u003d45.0, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003dfd852cc4fed540a887bd96282a65c400, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, takesScreenshot\u003dtrue, browserName\u003dfirefox, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: fd852cc4fed540a887bd96282a65c400\n*** Element info: {Using\u003did, value\u003dusername}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy23.click(Unknown Source)\r\n\tat atdd.framework.UhcDriver.sendkeys(UhcDriver.java:81)\r\n\tat pages.member.ulayer.TeamHLoginUlayer.loginWith(TeamHLoginUlayer.java:51)\r\n\tat acceptancetests.memberredesign.paymnts.OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_logs_inTeamH(OneTimePaymentAarpStepDefintion.java:577)\r\n\tat ✽.When TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site(payments/ulayer/MakeOneTimePayment-AARP.feature:263)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"username\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1\u0027, time: \u00272016-06-30 17:37:03\u0027\nSystem info: host: \u0027WIN-R1JBAO1CNPS\u0027, ip: \u002710.100.24.219\u0027, os.name: \u0027Windows Server 2008 R2\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U05CG6503PQC\u0027, ip: \u002710.192.29.87\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous351018315423376996webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous351018315423376996webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous351018315423376996webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous351018315423376996webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/ADMINI~1/AppData/Local/Temp/anonymous351018315423376996webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_navigates_to_TeamHPaymentOverview_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_validates_TeamHAuto_Payment_overview()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_clicks_AutoPay_and_navigates_to_Review_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_Review_OneTime_Payment_Navigation_to_ReviewSubmitted()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_OTP_SubmittedPage_Timestamp()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 869992608,
  "status": "passed"
});
formatter.after({
  "duration": 8957412,
  "status": "passed"
});
formatter.before({
  "duration": 251882,
  "status": "passed"
});
formatter.scenario({
  "line": 273,
  "name": "Verify the Timestamp on Automatic Payment Submitted page",
  "description": "",
  "id": "to-test-the-payment-flow-on-aarp-site;verify-the-timestamp-on-automatic-payment-submitted-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 260,
      "name": "@TeamHAuto"
    },
    {
      "line": 1,
      "name": "@payments"
    },
    {
      "line": 260,
      "name": "@theSpartans1"
    }
  ]
});
formatter.step({
  "line": 262,
  "name": "TimeStampTheSpartans the user is on the Team-H AARP medicare site login page",
  "keyword": "Given "
});
formatter.step({
  "line": 263,
  "name": "TimeStampTheSpartans the user logs in TeamH with a registered AMP with following details in AARP site",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "UHCFED"
      ],
      "line": 264
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 265,
  "name": "TimeStampTheSpartans the user navigates to Stage PaymentOverview Page",
  "keyword": "And "
});
formatter.step({
  "line": 266,
  "name": "TimeStampTheSpartans the user navigates to Team H Automatic Payments page",
  "keyword": "And "
});
formatter.step({
  "line": 267,
  "name": "TimeStampTheSpartans the user enters details and click on continue button on Automatic Payments Page for Dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 268,
  "name": "TimeStampTheSpartans user lands on Review One time Payments Page and navigates to Review Submitted Page",
  "keyword": "And "
});
formatter.step({
  "line": 269,
  "name": "TimeStampTheSpartans the user lands on OneTime Payment Submitted Page and validates Timestamp",
  "keyword": "Then "
});
formatter.match({
  "location": "OneTimePaymentAarpStepDefintion.TimeStampTheSpartans_user_TeamHlogin_page()"
});
