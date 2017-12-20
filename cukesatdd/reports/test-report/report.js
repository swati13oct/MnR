$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('feature\forms-and-resources\bluelayer\FormsAndResource-UMS.feature');
formatter.feature({
  "line": 2,
  "name": "To test forms and resources in UMS site",
  "description": "",
  "id": "to-test-forms-and-resources-in-ums-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@formsandresources"
    }
  ]
});
formatter.scenario({
  "line": 81,
  "name": "Verify add plan tab on forms and resources page",
  "description": "",
  "id": "to-test-forms-and-resources-in-ums-site;verify-add-plan-tab-on-forms-and-resources-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@formsandresources"
    },
    {
      "line": 70,
      "name": "@formsandresourcesfnf"
    }
  ]
});
formatter.step({
  "line": 72,
  "name": "registered member for forms and resources in UMS Site",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 73
    },
    {
      "cells": [
        "Member Type",
        "Group"
      ],
      "line": 74
    },
    {
      "cells": [
        "Group Type",
        "ALPEEHIP"
      ],
      "line": 75
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 76,
  "name": "the user navigates to forms and resources in UMS site",
  "keyword": "When "
});
formatter.step({
  "line": 77,
  "name": "validates that add plans tab is not available",
  "keyword": "Then "
});
formatter.match({
  "location": "FormsandResourcesUmsStepDefinition.registered_member_formsandresources_ums(DataTable)"
});
formatter.result({
  "duration": 98370715273,
  "status": "passed"
});
formatter.match({
  "location": "FormsandResourcesUmsStepDefinition.views_forms_resources_Ums_site()"
});
formatter.result({
  "duration": 129745976305,
  "status": "passed"
});
formatter.match({
  "location": "FormsandResourcesUmsStepDefinition.validates_that_add_plans_tab_is_not_available()"
});
formatter.result({
  "duration": 113657172,
  "status": "passed"
});
formatter.embedding('image/png','embedded0.png');
});