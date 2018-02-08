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
  "line": 5,
  "name": "To verify DCE flow from Blayer home page",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-verify-dce-flow-from-blayer-home-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@acq_drug_cost_estimator_blayer_flow"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on blayer medicare acq site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I access the acquisition DCE tool from home page on ums site",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I have added a drug to my drug list on ums site",
  "rows": [
    {
      "cells": [
        "Drug",
        "\u003cdrug\u003e"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I navigate to step2 page on ums site",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user selects the pharmacy tab information",
  "rows": [
    {
      "cells": [
        "Zipcode",
        "\u003czipcode\u003e"
      ],
      "line": 12
    },
    {
      "cells": [
        "Radius",
        "\u003cradius\u003e"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I select the first pharmacy on there",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I navigate to step3 page and validate the drug info",
  "rows": [
    {
      "cells": [
        "Drug",
        "\u003cdrug\u003e"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-verify-dce-flow-from-blayer-home-page;",
  "rows": [
    {
      "cells": [
        "drug",
        "zipcode",
        "radius"
      ],
      "line": 19,
      "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-verify-dce-flow-from-blayer-home-page;;1"
    },
    {
      "cells": [
        "Lipitor TAB 10MG",
        "90210",
        "15miles"
      ],
      "line": 20,
      "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-verify-dce-flow-from-blayer-home-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11693966,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "To verify DCE flow from Blayer home page",
  "description": "",
  "id": "1.24-vbf-acq-drug-cost-estimator-(dce)---to-test-dce-flows-on-ums-acq-site;to-verify-dce-flow-from-blayer-home-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@acq_dce_UHC"
    },
    {
      "line": 4,
      "name": "@acq_drug_cost_estimator_blayer_flow"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on blayer medicare acq site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I access the acquisition DCE tool from home page on ums site",
  "keyword": "When "
});
formatter.step({
  "line": 8,
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
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I navigate to step2 page on ums site",
  "keyword": "And "
});
formatter.step({
  "line": 11,
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
      "line": 12
    },
    {
      "cells": [
        "Radius",
        "15miles"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I select the first pharmacy on there",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I navigate to step3 page and validate the drug info",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Drug",
        "Lipitor TAB 10MG"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.the_user_is_on_UMS_medicare_site_landing_page()"
});
formatter.result({
  "duration": 37404856029,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_access_the_DCE_tool_home_page()"
});
formatter.result({
  "duration": 9222109459,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_have_added_a_drug_to_my_drug_list(DataTable)"
});
formatter.result({
  "duration": 52036108663,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_navigate_to_step2_page()"
});
formatter.result({
  "duration": 5351855992,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.navigate_drugcostestimator_pharmacytab(DataTable)"
});
formatter.result({
  "duration": 610476944,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_select_the_drug()"
});
formatter.result({
  "duration": 20283126715,
  "status": "passed"
});
formatter.match({
  "location": "DCEAcqStepDefinitionUHC.I_navigate_to_step_page(DataTable)"
});
formatter.result({
  "duration": 16392612378,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4215932459,
  "status": "passed"
});
});