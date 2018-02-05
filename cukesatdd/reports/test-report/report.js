$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ProviderSearchAcq/Providersearch.feature");
formatter.feature({
  "line": 3,
  "name": "1.15-VBF-Acq-To test Provider Search Flow  in UMS site",
  "description": "",
  "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 2,
      "name": "@BlayerProviderSearch"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verify Provider Search  in UMS site",
  "description": "",
  "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site;verify-provider-search--in-ums-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user is on UMS medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user performs plan search using following information in the UMS site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 7
    },
    {
      "cells": [
        "County Name",
        "\u003ccounty\u003e"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the user Click on Show Plans link",
  "rows": [
    {
      "cells": [
        "PlanType",
        "\u003cplantype\u003e"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user Click on Is my Provider covered link",
  "rows": [
    {
      "cells": [
        "PlanName",
        "\u003cplanname\u003e"
      ],
      "line": 12
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify X out of Y provider covered information is displayed on Plan Summary page",
  "rows": [
    {
      "cells": [
        "PlanName",
        "\u003cplanname\u003e"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site;verify-provider-search--in-ums-site;",
  "rows": [
    {
      "cells": [
        "zipcode",
        "county",
        "plantype",
        "planname"
      ],
      "line": 16,
      "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site;verify-provider-search--in-ums-site;;1"
    },
    {
      "cells": [
        "90210",
        "Los Angeles County",
        "MA",
        "AARP MedicareComplete SecureHorizons Plan 2 (HMO)"
      ],
      "line": 17,
      "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site;verify-provider-search--in-ums-site;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9624308,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify Provider Search  in UMS site",
  "description": "",
  "id": "1.15-vbf-acq-to-test-provider-search-flow--in-ums-site;verify-provider-search--in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 2,
      "name": "@BlayerProviderSearch"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the user is on UMS medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user performs plan search using following information in the UMS site",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 7
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the user Click on Show Plans link",
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "PlanType",
        "MA"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user Click on Is my Provider covered link",
  "matchedColumns": [
    3
  ],
  "rows": [
    {
      "cells": [
        "PlanName",
        "AARP MedicareComplete SecureHorizons Plan 2 (HMO)"
      ],
      "line": 12
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify X out of Y provider covered information is displayed on Plan Summary page",
  "matchedColumns": [
    3
  ],
  "rows": [
    {
      "cells": [
        "PlanName",
        "AARP MedicareComplete SecureHorizons Plan 2 (HMO)"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ProviderSearchUmsStepDefinition.user_UMS_Medicare()"
});
formatter.result({
  "duration": 27847807292,
  "status": "passed"
});
formatter.match({
  "location": "ProviderSearchUmsStepDefinition.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 17342299587,
  "status": "passed"
});
formatter.match({
  "location": "ProviderSearchUmsStepDefinition.clickonshowplans(DataTable)"
});
formatter.result({
  "duration": 33913578865,
  "status": "passed"
});
formatter.match({
  "location": "ProviderSearchUmsStepDefinition.clickonProvidercoveredlink(DataTable)"
});
