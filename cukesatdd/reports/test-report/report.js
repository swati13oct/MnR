$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('feature\ordermaterials\ulayer\OrderMaterials-Aarp.feature');
formatter.feature({
  "id": "to-test-order-materials-in-aarp-site",
  "tags": [
    {
      "name": "@ordermaterials",
      "line": 1
    }
  ],
  "description": "",
  "name": "To test order materials in AARP site",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "to-test-order-materials-in-aarp-site;verify-aarp-order-materials-page-header---all-combo-plan-types;;2",
  "tags": [
    {
      "name": "@ValidateHeaderTabs",
      "line": 89
    },
    {
      "name": "@ordermaterials",
      "line": 1
    }
  ],
  "description": "",
  "name": "Verify Aarp Order Materials Page Header - All Combo Plan Types",
  "keyword": "Scenario Outline",
  "line": 100,
  "type": "scenario"
});
formatter.step({
  "name": "registered AMP member with following attributes",
  "keyword": "Given ",
  "line": 91,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 92
    }
  ]
});
formatter.step({
  "name": "the user views order materials in AARP site",
  "keyword": "When ",
  "line": 93
});
formatter.step({
  "name": "user navigates to Order Materials page for all Plans",
  "keyword": "Then ",
  "line": 94,
  "matchedColumns": [
    1
  ],
  "rows": [
    {
      "cells": [
        "Combo Plans",
        "MA,HIP"
      ],
      "line": 95
    }
  ]
});
formatter.step({
  "name": "user Validates Page Header and Sub-Header text",
  "keyword": "And ",
  "line": 96
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.registered_member_orderplanmaterials_aarp(DataTable)"
});
formatter.result({
  "duration": 74069305447,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.views_order_materials_in_Ums_site()"
});
formatter.result({
  "duration": 3223547104,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_navigates_Plan_Tabs(DataTable)"
});
formatter.result({
  "duration": 513957253,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_validates_orderMaterialsHeader()"
});
formatter.result({
  "duration": 66497573,
  "status": "passed"
});
formatter.embedding('image/png','embedded0.png');
formatter.scenario({
  "id": "to-test-order-materials-in-aarp-site;verify-aarp-order-materials-page-header---all-combo-plan-types;;3",
  "tags": [
    {
      "name": "@ValidateHeaderTabs",
      "line": 89
    },
    {
      "name": "@ordermaterials",
      "line": 1
    }
  ],
  "description": "",
  "name": "Verify Aarp Order Materials Page Header - All Combo Plan Types",
  "keyword": "Scenario Outline",
  "line": 101,
  "type": "scenario"
});
formatter.step({
  "name": "registered AMP member with following attributes",
  "keyword": "Given ",
  "line": 91,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 92
    }
  ]
});
formatter.step({
  "name": "the user views order materials in AARP site",
  "keyword": "When ",
  "line": 93
});
formatter.step({
  "name": "user navigates to Order Materials page for all Plans",
  "keyword": "Then ",
  "line": 94,
  "matchedColumns": [
    1
  ],
  "rows": [
    {
      "cells": [
        "Combo Plans",
        "MAPD,HIP"
      ],
      "line": 95
    }
  ]
});
formatter.step({
  "name": "user Validates Page Header and Sub-Header text",
  "keyword": "And ",
  "line": 96
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.registered_member_orderplanmaterials_aarp(DataTable)"
});
formatter.result({
  "duration": 44922807059,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.views_order_materials_in_Ums_site()"
});
formatter.result({
  "duration": 1075012941,
  "status": "failed",
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[contains(text(),\u0027Go to Order plan materials\u0027)]\"}\nCommand duration or timeout: 1.07 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U0CND7090W3Z\u0027, ip: \u002710.37.117.181\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.7.0_71\u0027\n*** Element info: {Using\u003dxpath, value\u003d//a[contains(text(),\u0027Go to Order plan materials\u0027)]}\nSession ID: 6129399f-2451-4649-899e-90fa600ca150\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{platform\u003dWINDOWS, acceptSslCerts\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, databaseEnabled\u003dtrue, browserName\u003dfirefox, handlesAlerts\u003dtrue, nativeEvents\u003dfalse, webStorageEnabled\u003dtrue, rotatable\u003dfalse, locationContextEnabled\u003dtrue, applicationCacheEnabled\u003dtrue, takesScreenshot\u003dtrue, version\u003d45.0.1}]\r\n\tat sun.reflect.GeneratedConstructorAccessor16.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:526)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy19.click(Unknown Source)\r\n\tat pages.member.ulayer.AccountHomePage.navigateToOrderPlanMaterialsAarpPage(AccountHomePage.java:566)\r\n\tat acceptancetests.ordermaterials.ulayer.OrderPlanMaterialsAarpStepDefinition.views_order_materials_in_Ums_site(OrderPlanMaterialsAarpStepDefinition.java:152)\r\n\tat ✽.When the user views order materials in AARP site(feature\\ordermaterials\\ulayer\\OrderMaterials-Aarp.feature:93)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[contains(text(),\u0027Go to Order plan materials\u0027)]\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LH7U0CND7090W3Z\u0027, ip: \u002710.37.117.181\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.7.0_71\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/sdwaraka/AppData/Local/Temp/anonymous5650813397053455446webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.fxdriver.Timer.prototype.setTimeout/\u003c.notify(file:///C:/Users/sdwaraka/AppData/Local/Temp/anonymous5650813397053455446webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:625)\r\n"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_navigates_Plan_Tabs(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_validates_orderMaterialsHeader()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding('image/png','embedded1.png');
formatter.scenario({
  "id": "to-test-order-materials-in-aarp-site;verify-aarp-order-materials-page-header---all-combo-plan-types;;4",
  "tags": [
    {
      "name": "@ValidateHeaderTabs",
      "line": 89
    },
    {
      "name": "@ordermaterials",
      "line": 1
    }
  ],
  "description": "",
  "name": "Verify Aarp Order Materials Page Header - All Combo Plan Types",
  "keyword": "Scenario Outline",
  "line": 102,
  "type": "scenario"
});
formatter.step({
  "name": "registered AMP member with following attributes",
  "keyword": "Given ",
  "line": 91,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "PDP"
      ],
      "line": 92
    }
  ]
});
formatter.step({
  "name": "the user views order materials in AARP site",
  "keyword": "When ",
  "line": 93
});
formatter.step({
  "name": "user navigates to Order Materials page for all Plans",
  "keyword": "Then ",
  "line": 94,
  "matchedColumns": [
    1
  ],
  "rows": [
    {
      "cells": [
        "Combo Plans",
        "PDP,MedSupp"
      ],
      "line": 95
    }
  ]
});
formatter.step({
  "name": "user Validates Page Header and Sub-Header text",
  "keyword": "And ",
  "line": 96
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.registered_member_orderplanmaterials_aarp(DataTable)"
});
formatter.result({
  "duration": 74961834886,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.views_order_materials_in_Ums_site()"
});
formatter.result({
  "duration": 3202550911,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_navigates_Plan_Tabs(DataTable)"
});
formatter.result({
  "duration": 647486637,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_validates_orderMaterialsHeader()"
});
formatter.result({
  "duration": 61403227,
  "status": "passed"
});
formatter.embedding('image/png','embedded2.png');
formatter.scenario({
  "id": "to-test-order-materials-in-aarp-site;verify-aarp-order-materials-page-error-message;;2",
  "tags": [
    {
      "name": "@ordermaterials",
      "line": 1
    },
    {
      "name": "@ValidateErrorMessage",
      "line": 105
    }
  ],
  "description": "",
  "name": "Verify Aarp Order Materials Page Error Message",
  "keyword": "Scenario Outline",
  "line": 115,
  "type": "scenario"
});
formatter.step({
  "name": "registered AMP member with following attributes",
  "keyword": "Given ",
  "line": 107,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 108
    }
  ]
});
formatter.step({
  "name": "the user views order materials in AARP site",
  "keyword": "When ",
  "line": 109
});
formatter.step({
  "name": "the user click Submit without any selection",
  "keyword": "And ",
  "line": 110
});
formatter.step({
  "name": "the user validates error message in Order Materials page",
  "keyword": "Then ",
  "line": 111
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.registered_member_orderplanmaterials_aarp(DataTable)"
});
formatter.result({
  "duration": 68157394994,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.views_order_materials_in_Ums_site()"
});
formatter.result({
  "duration": 3006621931,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_submits_with_no_option_selected()"
});
formatter.result({
  "duration": 518810341,
  "status": "passed"
});
formatter.match({
  "location": "OrderPlanMaterialsAarpStepDefinition.user_validates_error_message()"
});
formatter.result({
  "duration": 32398345,
  "status": "passed"
});
formatter.embedding('image/png','embedded3.png');
});