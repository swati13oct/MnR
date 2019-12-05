$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PlanSelectorHeaderFooter.feature");
formatter.feature({
  "line": 2,
  "name": "Plan Selector Tool flow - Verify header and footer page in plan selector page",
  "description": "",
  "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@PlanSelector"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "- To validate landing Page in Plan Recommendation Engie",
  "description": "",
  "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page;--to-validate-landing-page-in-plan-recommendation-engie",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@PRE"
    },
    {
      "line": 4,
      "name": "@planrecommandonation"
    },
    {
      "line": 4,
      "name": "@headerfooter"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on UHC medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#    When user validate elements on landing page of Plan Recommendation Engine"
    },
    {
      "line": 8,
      "value": "#    Then user validate Header and Footer elements of Plan Recommendation Engine"
    }
  ],
  "line": 9,
  "name": "user validate Header and Footer Functionality of Plan Recommendation Engine",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003cZipcode\u003e"
      ],
      "line": 10
    },
    {
      "cells": [
        "EMail",
        "\u003cEMail\u003e"
      ],
      "line": 11
    },
    {
      "cells": [
        "Search Key",
        "\u003cSearchKey\u003e"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page;--to-validate-landing-page-in-plan-recommendation-engie;",
  "rows": [
    {
      "cells": [
        "Zipcode",
        "EMail",
        "SearchKey"
      ],
      "line": 15,
      "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page;--to-validate-landing-page-in-plan-recommendation-engie;;1"
    },
    {
      "cells": [
        "90201",
        "abc@domain.com",
        "plan for recommandations"
      ],
      "line": 16,
      "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page;--to-validate-landing-page-in-plan-recommendation-engie;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 63464800,
  "status": "passed"
});
formatter.before({
  "duration": 25062600,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "- To validate landing Page in Plan Recommendation Engie",
  "description": "",
  "id": "plan-selector-tool-flow---verify-header-and-footer-page-in-plan-selector-page;--to-validate-landing-page-in-plan-recommendation-engie;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@planrecommandonation"
    },
    {
      "line": 1,
      "name": "@PlanSelector"
    },
    {
      "line": 4,
      "name": "@headerfooter"
    },
    {
      "line": 4,
      "name": "@PRE"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on UHC medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#    When user validate elements on landing page of Plan Recommendation Engine"
    },
    {
      "line": 8,
      "value": "#    Then user validate Header and Footer elements of Plan Recommendation Engine"
    }
  ],
  "line": 9,
  "name": "user validate Header and Footer Functionality of Plan Recommendation Engine",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90201"
      ],
      "line": 10
    },
    {
      "cells": [
        "EMail",
        "abc@domain.com"
      ],
      "line": 11
    },
    {
      "cells": [
        "Search Key",
        "plan for recommandations"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "PlanSelectorStepDefinition.the_user_on_uhc_medicaresolutions_Site()"
});
formatter.result({
  "duration": 52835353000,
  "status": "passed"
});
formatter.match({
  "location": "PlanSelectorStepDefinition.user_check_header_footer_Actions_Plan_Selector_tool(DataTable)"
});
formatter.result({
  "duration": 8558992500,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat org.testng.Assert.assertTrue(Assert.java:52)\r\n\tat pages.acquisition.planSelectorEngine.PlanSelectorHeaderAndFooter.zipcodeFunctionInShopforaplan(PlanSelectorHeaderAndFooter.java:406)\r\n\tat acceptancetests.acquisition.PlanSelector.PlanSelectorStepDefinition.user_check_header_footer_Actions_Plan_Selector_tool(PlanSelectorStepDefinition.java:224)\r\n\tat ✽.Then user validate Header and Footer Functionality of Plan Recommendation Engine(PlanSelectorHeaderFooter.feature:9)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.embedding("text/html", "\u003cstrong\u003eSauceLabs video link\u003c/strong\u003e\u003cbr /\u003e\u003ca href\u003dhttps://saucelabs.com/jobs/3bc10fbd34ce4aa3810a692f9400ba21?auth\u003d6a509efe47b644a95501d7fc6822a5b3 \u003eGo to video\u003c/a\u003e");
formatter.after({
  "duration": 5264215700,
  "status": "passed"
});
formatter.after({
  "duration": 12038500,
  "status": "passed"
});
formatter.after({
  "duration": 11935100,
  "status": "passed"
});
});