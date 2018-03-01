$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("dce/DCE-ACQ-UHC.feature");
formatter.feature({
  "line": 2,
  "name": "1.24-VBF-Acq-Drug Cost Estimator (DCE) - To test DCE flows on UMS acq site",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@acq_dce_UHC"
    }
  ]
});
formatter.scenarioOutline({
  "line": 93,
  "name": "To go through dce from homepage and validate drug is still there when going to dce from vpp",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-go-through-dce-from-homepage-and-validate-drug-is-still-there-when-going-to-dce-from-vpp",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 92,
      "name": "@defect1662"
    }
  ]
});
formatter.step({
  "line": 94,
  "name": "the user is on blayer medicare acq site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 95,
  "name": "I access the acquisition DCE tool from home page on ums site",
  "keyword": "When "
});
formatter.step({
  "line": 96,
  "name": "I have added a drug to my drug list on ums site",
  "rows": [
    {
      "cells": [
        "Drug",
        "\u003cdrug\u003e"
      ],
      "line": 97
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 98,
  "name": "the user selects the pharmacy tab information",
  "rows": [
    {
      "cells": [
        "Zipcode",
        "\u003czipcode\u003e"
      ],
      "line": 99
    },
    {
      "cells": [
        "Radius",
        "\u003cradius\u003e"
      ],
      "line": 100
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "I select the first pharmacy on there",
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "I click on the return link",
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "I access the vpp page using below zipcode on ums site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 104
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 105,
  "name": "I access the DCE tool after adding drug",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplantype\u003e"
      ],
      "line": 106
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 107,
  "name": "I verify that the drug is still there",
  "rows": [
    {
      "cells": [
        "Drug",
        "\u003cdrug\u003e"
      ],
      "line": 108
    }
  ],
  "keyword": "Then "
});
formatter.examples({
  "line": 110,
  "name": "",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-go-through-dce-from-homepage-and-validate-drug-is-still-there-when-going-to-dce-from-vpp;",
  "rows": [
    {
      "cells": [
        "drug",
        "zipcode",
        "radius",
        "plantype"
      ],
      "line": 111,
      "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-go-through-dce-from-homepage-and-validate-drug-is-still-there-when-going-to-dce-from-vpp;;1"
    },
    {
      "cells": [
        "Lipitor TAB 10MG",
        "90210",
        "15miles",
        "MA"
      ],
      "line": 112,
      "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-go-through-dce-from-homepage-and-validate-drug-is-still-there-when-going-to-dce-from-vpp;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 12293007,
  "status": "passed"
});
formatter.scenario({
  "line": 112,
  "name": "To go through dce from homepage and validate drug is still there when going to dce from vpp",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-go-through-dce-from-homepage-and-validate-drug-is-still-there-when-going-to-dce-from-vpp;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@acq_dce_UHC"
    },
    {
      "line": 92,
      "name": "@defect1662"
    }
  ]
});
formatter.step({
  "line": 94,
  "name": "the user is on blayer medicare acq site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 95,
  "name": "I access the acquisition DCE tool from home page on ums site",
  "keyword": "When "
});
formatter.step({
  "line": 96,
  "name": "I have added a drug to my drug list on ums site",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Drug",
        "Lipitor TAB 10MG"
      ],
      "line": 97
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 98,
  "name": "the user selects the pharmacy tab information",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Zipcode",
        "90210"
      ],
      "line": 99
    },
    {
      "cells": [
        "Radius",
        "15miles"
      ],
      "line": 100
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "I select the first pharmacy on there",
  "keyword": "And "
});
formatter.step({
  "line": 102,
  "name": "I click on the return link",
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "I access the vpp page using below zipcode on ums site",
  "matchedColumns": [
    1
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 104
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 105,
  "name": "I access the DCE tool after adding drug",
  "matchedColumns": [
    3
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 106
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 107,
  "name": "I verify that the drug is still there",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Drug",
        "Lipitor TAB 10MG"
      ],
      "line": 108
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.the_user_is_on_UMS_medicare_site_landing_page()"
});
formatter.result({
  "duration": 35311511597,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_access_the_DCE_tool_home_page()"
});
formatter.result({
  "duration": 8876143624,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_have_added_a_drug_to_my_drug_list(DataTable)"
});
formatter.result({
  "duration": 51859370475,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.navigate_drugcostestimator_pharmacytab(DataTable)"
});
formatter.result({
  "duration": 768159938,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_select_the_drug()"
});
formatter.result({
  "duration": 20414263597,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.clickOnReturnLink()"
});
formatter.result({
  "duration": 6434657863,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_access_the__vpp_page(DataTable)"
});
formatter.result({
  "duration": 15745948756,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.accessDCEToolAfterDrugAdded(DataTable)"
});
formatter.result({
  "duration": 18855478195,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.verifyDrugIsStillThere(DataTable)"
});
formatter.result({
  "duration": 56113972,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4420583218,
  "status": "passed"
});
});