$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VPP_PlanSummary-AARP.feature");
formatter.feature({
  "line": 2,
  "name": "To test VPP Plan Summary Page in AARP Site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "TID: \u003cTID\u003e -plan type: \u003cplantype\u003e - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "\u003cisMultutiCounty\u003e"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "\u003ccounty\u003e"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplantype\u003e"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Name",
        "\u003cplanName\u003e"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "rows": [
    {
      "cells": [
        "Plan Name",
        "\u003cplanName\u003e"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "\u003cmonthlyPremium\u003e"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "\u003cprimaryCarePhysician\u003e"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "\u003cspecialist\u003e"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "\u003creferralRequired\u003e"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "\u003coutOfPocketMaximum\u003e"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "\u003cprescriptionDrugsTier1\u003e"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "\u003cmonthlyPremium\u003e"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        "\u003cannualDeductible\u003e"
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "\u003cprescriptionDrugsTier1\u003e"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.examples({
  "line": 43,
  "name": "",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;",
  "rows": [
    {
      "cells": [
        "TID",
        "zipcode",
        "isMultutiCounty",
        "county",
        "plantype",
        "planName",
        "monthlyPremium",
        "primaryCarePhysician",
        "specialist",
        "referralRequired",
        "outOfPocketMaximum",
        "prescriptionDrugsTier1",
        "annualDeductible"
      ],
      "line": 44,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;1"
    },
    {
      "cells": [
        "15545",
        "90210",
        "NO",
        "Los Angeles County",
        "MAPD",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)",
        "$0",
        "$0  copay",
        "$0  copay",
        "Yes",
        "$3,400.00",
        "$4  copay",
        ""
      ],
      "line": 45,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;2"
    },
    {
      "cells": [
        "15546",
        "28105",
        "YES",
        "Mecklenburg County",
        "SNP",
        "UnitedHealthcare Dual Complete (HMO SNP)",
        "$0",
        "$0  copay",
        "$0  copay",
        "No",
        "$0 - $6,700.00",
        "$0, $1.25, $3.40 copay, or 15% coinsurance",
        "",
        ""
      ],
      "line": 46,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;3"
    },
    {
      "cells": [
        "15551",
        "90210",
        "NO",
        "Los Angeles County",
        "MA",
        "AARP MedicareComplete SecureHorizons Essential (HMO)",
        "$0",
        "$5  copay",
        "$10  copay",
        "Yes",
        "$4,900.00",
        "No drug coverage",
        ""
      ],
      "line": 47,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;4"
    },
    {
      "cells": [
        "15552",
        "90210",
        "NO",
        "Los Angeles County",
        "PDP",
        "AARP MedicareRx Walgreens (PDP)",
        "$0",
        "",
        "",
        "",
        "",
        "$0  copay",
        "$0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5"
      ],
      "line": 48,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 27542177,
  "status": "passed"
});
formatter.before({
  "duration": 20714274,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "TID: 15545 -plan type: MAPD - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$3,400.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_on_aarp_medicareplans_Site()"
});
formatter.result({
  "duration": 86184088356,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 15064075129,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 4740430556,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_available_plans_aarp()"
});
formatter.result({
  "duration": 95471257,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_plan_summary(DataTable)"
});
formatter.result({
  "duration": 958342119,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_marketingBullets()"
});
formatter.result({
  "duration": 692155645,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_addtocompare_aarp()"
});
formatter.result({
  "duration": 837846021,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_views_plandetails_selected_plan_aarp(DataTable)"
});
formatter.result({
  "duration": 3053415018,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site()"
});
formatter.result({
  "duration": 8570531340,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_inAARP(DataTable)"
});
formatter.result({
  "duration": 626140412,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 125949,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_premium0_validateText_inAARP()"
});
formatter.result({
  "duration": 728784188,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_annualDeductible_inAARP()"
});
formatter.result({
  "duration": 73436,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP()"
});
formatter.result({
  "duration": 4442342517,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp()"
});
formatter.result({
  "duration": 18069044569,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 679955020,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesPopup_learnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 659836439,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 215872177,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 6212001815,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 7139590269,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4508522264,
  "status": "passed"
});
formatter.before({
  "duration": 313026,
  "status": "passed"
});
formatter.before({
  "duration": 16522681,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "TID: 15546 -plan type: SNP - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "28105"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "YES"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "Mecklenburg County"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "SNP"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "No"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$0 - $6,700.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_on_aarp_medicareplans_Site()"
});
formatter.result({
  "duration": 85221540694,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 22843124384,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 10205698630,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_available_plans_aarp()"
});
formatter.result({
  "duration": 259311803,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_plan_summary(DataTable)"
});
formatter.result({
  "duration": 948982522,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_marketingBullets()"
});
formatter.result({
  "duration": 432879945,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_addtocompare_aarp()"
});
formatter.result({
  "duration": 44307,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_views_plandetails_selected_plan_aarp(DataTable)"
});
formatter.result({
  "duration": 3772045761,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site()"
});
formatter.result({
  "duration": 15084775865,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_inAARP(DataTable)"
});
formatter.result({
  "duration": 954998116,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 95589,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_premium0_validateText_inAARP()"
});
formatter.result({
  "duration": 60718,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_annualDeductible_inAARP()"
});
formatter.result({
  "duration": 74667,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP()"
});
formatter.result({
  "duration": 8520900119,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp()"
});
formatter.result({
  "duration": 28612788195,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 30293006599,
  "error_message": "java.lang.AssertionError: The element is not  found\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat atdd.framework.UhcDriver.validateNew(UhcDriver.java:526)\r\n\tat pages.acquisition.ulayer.VPPPlanSummaryPage.validateAndClickLearnMoreAboutExtraHelpInAARP(VPPPlanSummaryPage.java:1569)\r\n\tat acceptancetests.acquisition.vpp.VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp(VppPlanSummaryStepDefinitionAARP.java:752)\r\n\tat ✽.Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site(VPP_PlanSummary-AARP.feature:36)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesPopup_learnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 4641663296,
  "status": "passed"
});
formatter.before({
  "duration": 869745,
  "status": "passed"
});
formatter.before({
  "duration": 16604321,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "TID: 15546 -plan type: SNP - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "28105"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "YES"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "Mecklenburg County"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "SNP"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "No"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$0 - $6,700.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_on_aarp_medicareplans_Site()"
});
formatter.result({
  "duration": 87866461429,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 199328986937,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//div[@id\u003d\u0027selectCounty\u0027]//a[text()\u003d\u0027Mecklenburg County\u0027]\"}\n  (Session info: chrome\u003d73.0.3683.103)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 10.04 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LHTU05CG74017N6\u0027, ip: \u002710.194.24.220\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:53105}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\y16\\AppData\\Local\\Temp\\scoped_dir37976_28686}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d73.0.3683.103, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 4d42397f84b620defb04e8e84ba1fea8\n*** Element info: {Using\u003dxpath, value\u003d//div[@id\u003d\u0027selectCounty\u0027]//a[text()\u003d\u0027Mecklenburg County\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat pages.acquisition.ulayer.AcquisitionHomePage.searchPlans(AcquisitionHomePage.java:367)\r\n\tat acceptancetests.acquisition.vpp.VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(VppPlanSummaryStepDefinitionAARP.java:86)\r\n\tat ✽.When the user does plan search using the following information in the AARP site(VPP_PlanSummary-AARP.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_available_plans_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_plan_summary(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_marketingBullets()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_addtocompare_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_views_plandetails_selected_plan_aarp(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_inAARP(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_premium0_validateText_inAARP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_annualDeductible_inAARP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesPopup_learnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "duration": 4546288448,
  "status": "passed"
});
formatter.before({
  "duration": 5071184,
  "status": "passed"
});
formatter.before({
  "duration": 74585087,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "TID: 15551 -plan type: MA - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$5  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$10  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$4,900.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_on_aarp_medicareplans_Site()"
});
formatter.result({
  "duration": 85150218379,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 13479681214,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 3821272059,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_available_plans_aarp()"
});
formatter.result({
  "duration": 79724783,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_plan_summary(DataTable)"
});
formatter.result({
  "duration": 718774333,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_marketingBullets()"
});
formatter.result({
  "duration": 514950577,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_addtocompare_aarp()"
});
formatter.result({
  "duration": 806969688,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_views_plandetails_selected_plan_aarp(DataTable)"
});
formatter.result({
  "duration": 5127376104,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site()"
});
formatter.result({
  "duration": 5852721110,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_inAARP(DataTable)"
});
formatter.result({
  "duration": 535725978,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 80000,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_premium0_validateText_inAARP()"
});
formatter.result({
  "duration": 681218611,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_annualDeductible_inAARP()"
});
formatter.result({
  "duration": 68102,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP()"
});
formatter.result({
  "duration": 72205,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp()"
});
formatter.result({
  "duration": 57846,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 1059369074,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesPopup_learnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 54154,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 415372648,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 6964493509,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 4984846757,
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png");
formatter.after({
  "duration": 4997347280,
  "status": "passed"
});
formatter.before({
  "duration": 4709748,
  "status": "passed"
});
formatter.before({
  "duration": 97553721,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "TID: 15552 -plan type: PDP - Verify plan cards on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-aarp-site;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on the AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 9
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user views plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "PDP"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates available plans for selected plan types in the AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user validates plan summary for the below plan in AARP site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareRx Walgreens (PDP)"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the user validates marketing bullets of the plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in AARP site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareRx Walgreens (PDP)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        ""
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        ""
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        ""
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        ""
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0  copay"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        "$0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5"
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0  copay"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_on_aarp_medicareplans_Site()"
});
formatter.result({
  "duration": 85459964275,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 15905519922,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 3941682004,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_available_plans_aarp()"
});
formatter.result({
  "duration": 68780364,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_plan_summary(DataTable)"
});
formatter.result({
  "duration": 908454899,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_marketingBullets()"
});
formatter.result({
  "duration": 303482095,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_addtocompare_aarp()"
});
formatter.result({
  "duration": 904693255,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_views_plandetails_selected_plan_aarp(DataTable)"
});
formatter.result({
  "duration": 4455459656,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_BackToPlansLink_and_validates_redirection_in_AARP_site()"
});
formatter.result({
  "duration": 6290675111,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_inAARP(DataTable)"
});
formatter.result({
  "duration": 117744,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 197517701,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_premium0_validateText_inAARP()"
});
formatter.result({
  "duration": 39385,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.toolTip_annualDeductible_inAARP()"
});
formatter.result({
  "duration": 508920622,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.the_user_clicks_enterDrugInformation_validates_dceHomePage_AARP()"
});
formatter.result({
  "duration": 6836050327,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_aarp()"
});
formatter.result({
  "duration": 10996250664,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 1066930517,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validatesPopup_learnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 733951371,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 54564,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_IsMyProviderCoveredLink_aarp()"
});
formatter.result({
  "duration": 50052,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 6296425269,
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png");
formatter.after({
  "duration": 4483503576,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 52,
  "name": "TID: \u003cTID\u003e -plan type: \u003cplantype\u003e - Verify right rail on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 51,
      "name": "@rightRailRegression"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "the user is on AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "the user does plan search using the following information in the AARP site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 55
    },
    {
      "cells": [
        "Is Multi County",
        "\u003cisMultutiCounty\u003e"
      ],
      "line": 56
    },
    {
      "cells": [
        "County Name",
        "\u003ccounty\u003e"
      ],
      "line": 57
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "the user views the plans of the below plan type in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplantype\u003e"
      ],
      "line": 59
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "the user validates the right rail in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "the user validates the Need Help Section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "the user validates the TFN in the Need Help Section in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the user validates and clicks on Find an agent in your area link in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "the user validates Get a free medicare Guide section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "the user enters the following information in the Get a free medicare Guide section in aarp Site",
  "rows": [
    {
      "cells": [
        "First Name",
        "\u003cfirstName\u003e"
      ],
      "line": 66
    },
    {
      "cells": [
        "Last Name",
        "\u003clastName\u003e"
      ],
      "line": 67
    },
    {
      "cells": [
        "Email Address",
        "\u003cemailAddress\u003e"
      ],
      "line": 68
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 69,
      "value": "# Then the user validates Need More Information section in the right rail in aarp Site"
    },
    {
      "line": 70,
      "value": "# Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site"
    }
  ],
  "line": 71,
  "name": "the user validates Plan Selector Tool section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site",
  "keyword": "Then "
});
formatter.examples({
  "line": 74,
  "name": "",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site;",
  "rows": [
    {
      "cells": [
        "TID",
        "zipcode",
        "isMultutiCounty",
        "county",
        "plantype",
        "firstName",
        "lastName",
        "emailAddress"
      ],
      "line": 75,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site;;1"
    },
    {
      "cells": [
        "15550",
        "90210",
        "NO",
        "Los Angeles County",
        "MAPD",
        "test",
        "test",
        "test@test.com"
      ],
      "line": 76,
      "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 377026,
  "status": "passed"
});
formatter.before({
  "duration": 23668942,
  "status": "passed"
});
formatter.scenario({
  "line": 76,
  "name": "TID: 15550 -plan type: MAPD - Verify right rail on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 51,
      "name": "@rightRailRegression"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "the user is on AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 55
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 56
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 57
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "the user views the plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 59
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "the user validates the right rail in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "the user validates the Need Help Section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "the user validates the TFN in the Need Help Section in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the user validates and clicks on Find an agent in your area link in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "the user validates Get a free medicare Guide section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "the user enters the following information in the Get a free medicare Guide section in aarp Site",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "rows": [
    {
      "cells": [
        "First Name",
        "test"
      ],
      "line": 66
    },
    {
      "cells": [
        "Last Name",
        "test"
      ],
      "line": 67
    },
    {
      "cells": [
        "Email Address",
        "test@test.com"
      ],
      "line": 68
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 69,
      "value": "# Then the user validates Need More Information section in the right rail in aarp Site"
    },
    {
      "line": 70,
      "value": "# Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site"
    }
  ],
  "line": 71,
  "name": "the user validates Plan Selector Tool section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site",
  "keyword": "Then "
});
formatter.match({
  "location": "VppStepDefinitionUpdatedAARP.the_user_on_aarp_medicaresolutions_Site()"
});
formatter.result({
  "duration": 85392883605,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 18145196427,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUpdatedAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 3961229097,
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Element \u003ca tabindex\u003d\"0\" aria-label\u003d\"Medicare Advantage (Part C) Plans: ...\" class\u003d\"trigger-closed\" dtmname\u003d\"Plans Landing:Plan Box:MA:View Plans\" dtmid\u003d\"cta_acq_plans_landing\" ng-hide\u003d\"planModel.maPlans.length \u003d\u003d 0\"\u003eView Plans\u003c/a\u003e is not clickable at point (466, 182). Other element would receive the click: \u003cdiv id\u003d\"overlay\" style\u003d\"background-color: rgb(0, 0, 0) !important;\"\u003e\u003c/div\u003e\n  (Session info: chrome\u003d73.0.3683.103)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 823 milliseconds\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LHTU05CG74017N6\u0027, ip: \u002710.194.24.220\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:54188}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\y16\\AppData\\Local\\Temp\\scoped_dir53872_23321}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d73.0.3683.103, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 53e8f29769063bb7323da9fd0e8e07ba\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:85)\r\n\tat sun.reflect.GeneratedMethodAccessor17.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy24.click(Unknown Source)\r\n\tat pages.acquisition.ulayer.VPPPlanSummaryPage.viewPlanSummary(VPPPlanSummaryPage.java:594)\r\n\tat acceptancetests.acquisition.vpp.VppStepDefinitionUpdatedAARP.user_performs_planSearch_in_aarp_site(VppStepDefinitionUpdatedAARP.java:138)\r\n\tat ✽.And the user views the plans of the below plan type in AARP site(VPP_PlanSummary-AARP.feature:58)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_rightRail()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_needHelp_rightRail()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_TFN_inRIghtRail_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validateAndClick_findAgentInYourArea_RightRail()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_freeMedicareGuide_rightRail()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_planSelectorTool_rightRail()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validate_planSelectorPage_inaarpSite()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded5.png");
formatter.after({
  "duration": 7905857154,
  "status": "passed"
});
formatter.before({
  "duration": 468514,
  "status": "passed"
});
formatter.before({
  "duration": 19356734,
  "status": "passed"
});
formatter.scenario({
  "line": 76,
  "name": "TID: 15550 -plan type: MAPD - Verify right rail on plan summary page in AARP site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-aarp-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-aarp-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 51,
      "name": "@rightRailRegression"
    }
  ]
});
formatter.step({
  "line": 53,
  "name": "the user is on AARP medicare acquisition site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "the user does plan search using the following information in the AARP site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 55
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 56
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 57
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "the user views the plans of the below plan type in AARP site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 59
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "the user validates the right rail in AARP Site",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "the user validates the Need Help Section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "the user validates the TFN in the Need Help Section in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the user validates and clicks on Find an agent in your area link in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "the user validates Get a free medicare Guide section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 65,
  "name": "the user enters the following information in the Get a free medicare Guide section in aarp Site",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "rows": [
    {
      "cells": [
        "First Name",
        "test"
      ],
      "line": 66
    },
    {
      "cells": [
        "Last Name",
        "test"
      ],
      "line": 67
    },
    {
      "cells": [
        "Email Address",
        "test@test.com"
      ],
      "line": 68
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 69,
      "value": "# Then the user validates Need More Information section in the right rail in aarp Site"
    },
    {
      "line": 70,
      "value": "# Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site"
    }
  ],
  "line": 71,
  "name": "the user validates Plan Selector Tool section in the right rail in aarp Site",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site",
  "keyword": "Then "
});
formatter.match({
  "location": "VppStepDefinitionUpdatedAARP.the_user_on_aarp_medicaresolutions_Site()"
});
formatter.result({
  "duration": 86174689374,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 17219782744,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUpdatedAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 4295290499,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validates_rightRail()"
});
formatter.result({
  "duration": 363569529,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_needHelp_rightRail()"
});
formatter.result({
  "duration": 589780997,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_TFN_inRIghtRail_aarp()"
});
formatter.result({
  "duration": 355670035,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validateAndClick_findAgentInYourArea_RightRail()"
});
formatter.result({
  "duration": 24805345481,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_freeMedicareGuide_rightRail()"
});
formatter.result({
  "duration": 2157526283,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable)"
});
formatter.result({
  "duration": 13734479782,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.validate_planSelectorTool_rightRail()"
});
formatter.result({
  "duration": 1382307185,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionAARP.user_validate_planSelectorPage_inaarpSite()"
});
formatter.result({
  "duration": 20554300763,
  "status": "passed"
});
formatter.embedding("image/png", "embedded6.png");
formatter.after({
  "duration": 4618238456,
  "status": "passed"
});
formatter.uri("VPP_PlanSummary-UHC.feature");
formatter.feature({
  "line": 2,
  "name": "To test VPP Plan Summary Page in UMS Site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "TID: \u003cTID\u003e -plan type: \u003cplantype\u003e - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "\u003ccounty\u003e"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "\u003cisMultutiCounty\u003e"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplantype\u003e"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "rows": [
    {
      "cells": [
        "Plan Name",
        "\u003cplanName\u003e"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "rows": [
    {
      "cells": [
        "Plan Name",
        "\u003cplanName\u003e"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "\u003cmonthlyPremium\u003e"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "\u003cprimaryCarePhysician\u003e"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "\u003cspecialist\u003e"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "\u003creferralRequired\u003e"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "\u003coutOfPocketMaximum\u003e"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "\u003cprescriptionDrugsTier1\u003e"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "\u003cmonthlyPremium\u003e"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        "\u003cannualDeductible\u003e"
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "\u003cprescriptionDrugsTier1\u003e"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.examples({
  "line": 42,
  "name": "",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;",
  "rows": [
    {
      "cells": [
        "TID",
        "zipcode",
        "isMultutiCounty",
        "county",
        "plantype",
        "planName",
        "monthlyPremium",
        "primaryCarePhysician",
        "specialist",
        "referralRequired",
        "outOfPocketMaximum",
        "prescriptionDrugsTier1",
        "annualDeductible"
      ],
      "line": 43,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;1"
    },
    {
      "cells": [
        "15553",
        "90210",
        "NO",
        "Los Angeles County",
        "MAPD",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)",
        "$0",
        "$0  copay",
        "$0  copay",
        "Yes",
        "$3,400.00",
        "$4  copay",
        ""
      ],
      "line": 44,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;2"
    },
    {
      "cells": [
        "15554",
        "28105",
        "YES",
        "Mecklenburg County",
        "SNP",
        "UnitedHealthcare Dual Complete (HMO SNP)",
        "$0",
        "$0  copay",
        "$0  copay",
        "No",
        "$0 - $6,700.00",
        "$0, $1.25, $3.40 copay, or 15% coinsurance",
        ""
      ],
      "line": 45,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;3"
    },
    {
      "cells": [
        "15542",
        "90210",
        "NO",
        "Los Angeles County",
        "MA",
        "AARP MedicareComplete SecureHorizons Essential (HMO)",
        "$0",
        "$5  copay",
        "$10  copay",
        "Yes",
        "$4,900.00",
        "No drug coverage",
        ""
      ],
      "line": 46,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;4"
    },
    {
      "cells": [
        "15543",
        "90210",
        "NO",
        "Los Angeles County",
        "PDP",
        "AARP MedicareRx Walgreens (PDP)",
        "$0",
        "",
        "",
        "",
        "",
        "$0  copay",
        "$0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5"
      ],
      "line": 47,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 380308,
  "status": "passed"
});
formatter.before({
  "duration": 18546887,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "TID: 15553 -plan type: MAPD - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$3,400.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 54004671593,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 12930558302,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 3713496380,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "duration": 837474328,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "duration": 1236801015,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "duration": 80821,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "duration": 1217415973,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "duration": 4687264974,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "duration": 9348513517,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "duration": 715393407,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 118564,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "duration": 600233928,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "duration": 100513,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "duration": 5525808021,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "duration": 14731923062,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 30551233683,
  "error_message": "java.lang.AssertionError: The element is not  found\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat atdd.framework.UhcDriver.validateNew(UhcDriver.java:526)\r\n\tat pages.acquisition.bluelayer.VPPPlanSummaryPage.validateAndClickLearnMoreAboutExtraHelpInUMS(VPPPlanSummaryPage.java:1881)\r\n\tat acceptancetests.acquisition.vpp.VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp(VppPlanSummaryStepDefinitionUHC.java:771)\r\n\tat ✽.Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site(VPP_PlanSummary-UHC.feature:36)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded7.png");
formatter.after({
  "duration": 9288660340,
  "status": "passed"
});
formatter.before({
  "duration": 259692,
  "status": "passed"
});
formatter.before({
  "duration": 15608628,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "TID: 15553 -plan type: MAPD - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Plan 1 (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$3,400.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$4  copay"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 54278546690,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 17963468688,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 5181276046,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "duration": 817415235,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "duration": 1003765747,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "duration": 65641,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "duration": 670882602,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "duration": 3230049830,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "duration": 9174371835,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "duration": 573546317,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 107077,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "duration": 631455287,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "duration": 64000,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "duration": 8397501865,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "duration": 17100537519,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 718250846,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "duration": 1011949138,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "duration": 398067608,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "duration": 7054591634,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 10991804711,
  "status": "passed"
});
formatter.embedding("image/png", "embedded8.png");
formatter.after({
  "duration": 4538969058,
  "status": "passed"
});
formatter.before({
  "duration": 375795,
  "status": "passed"
});
formatter.before({
  "duration": 24094789,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "TID: 15554 -plan type: SNP - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "28105"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Mecklenburg County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "YES"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "SNP"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "UnitedHealthcare Dual Complete (HMO SNP)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$0  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$0  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "No"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$0 - $6,700.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0, $1.25, $3.40 copay, or 15% coinsurance"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 55580132169,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 23719767975,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 11158435412,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "duration": 1053622198,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "duration": 38154,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "duration": 10162613877,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "duration": 552249889,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "duration": 5150181046,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "duration": 15909198284,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "duration": 772580326,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 73026,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "duration": 58667,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "duration": 60718,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "duration": 5888577550,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "duration": 29485547065,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 873226153,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "duration": 853665931,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "duration": 199968574,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "duration": 7334705915,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 7660318080,
  "status": "passed"
});
formatter.embedding("image/png", "embedded9.png");
formatter.after({
  "duration": 7101858956,
  "status": "passed"
});
formatter.before({
  "duration": 559590,
  "status": "passed"
});
formatter.before({
  "duration": 109749834,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "TID: 15542 -plan type: MA - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$5  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$10  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$4,900.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 59409411617,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 23449786626,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 2449460061,
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Element \u003ca tabindex\u003d\"0\" aria-label\u003d\"Medicare Advantage (Part C) Plans: ...\" class\u003d\"trigger-closed\" dtmname\u003d\"Plans Landing:Plan Box:MA:View Plans\" dtmid\u003d\"cta_acq_plans_landing\" ng-hide\u003d\"planModel.maPlans.length \u003d\u003d 0\"\u003eView Plans\u003c/a\u003e is not clickable at point (466, 182). Other element would receive the click: \u003cdiv id\u003d\"overlay\" style\u003d\"background-color: rgb(0, 0, 0) !important;\"\u003e\u003c/div\u003e\n  (Session info: chrome\u003d73.0.3683.103)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 95 milliseconds\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LHTU05CG74017N6\u0027, ip: \u002710.194.24.220\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:50030}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\y16\\AppData\\Local\\Temp\\scoped_dir1760_4695}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d73.0.3683.103, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: e6ad8155f4088eef7c89daf7e015d6bf\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:85)\r\n\tat sun.reflect.GeneratedMethodAccessor17.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy24.click(Unknown Source)\r\n\tat pages.acquisition.bluelayer.VPPPlanSummaryPage.viewPlanSummary(VPPPlanSummaryPage.java:818)\r\n\tat acceptancetests.acquisition.vpp.VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(VppStepDefinitionUHC.java:362)\r\n\tat ✽.And user views plans of the below plan type in UMS site(VPP_PlanSummary-UHC.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded10.png");
formatter.after({
  "duration": 7286544235,
  "status": "passed"
});
formatter.before({
  "duration": 534154,
  "status": "passed"
});
formatter.before({
  "duration": 20572325,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "TID: 15542 -plan type: MA - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareComplete SecureHorizons Essential (HMO)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        "$5  copay"
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        "$10  copay"
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        "Yes"
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        "$4,900.00"
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        ""
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "No drug coverage"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 58167688753,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 17953056782,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 4033938900,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "duration": 1085520480,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "duration": 1604286855,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "duration": 44718,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "duration": 444759340,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "duration": 15302831018,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "duration": 8375650359,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "duration": 1073250111,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 164103,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "duration": 813216667,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "duration": 59077,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "duration": 54564,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "duration": 45539,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 10053869993,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "duration": 47590,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "duration": 642494886,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "duration": 8967103563,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 12310687845,
  "status": "passed"
});
formatter.embedding("image/png", "embedded11.png");
formatter.after({
  "duration": 4664942084,
  "status": "passed"
});
formatter.before({
  "duration": 651488,
  "status": "passed"
});
formatter.before({
  "duration": 66451336,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "TID: 15543 -plan type: PDP - Verify plan cards on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-plan-cards-on-plan-summary-page-in-ums-site;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegression"
    },
    {
      "line": 4,
      "name": "@fastandfurious"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 4,
      "name": "@vppPlanCardsRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "PDP"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user validates plan summary for the below plan in UMS site",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareRx Walgreens (PDP)"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user validates Add to compare checkbox is not present for DSNP Plans in UMS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user validates marketing bullets of the plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the user view plan details of the above selected plan in UMS site and validate",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Plan Name",
        "AARP MedicareRx Walgreens (PDP)"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans",
  "matchedColumns": [
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 22
    },
    {
      "cells": [
        "Primary Care Physician",
        ""
      ],
      "line": 23
    },
    {
      "cells": [
        "Specialist",
        ""
      ],
      "line": 24
    },
    {
      "cells": [
        "Referral Required",
        ""
      ],
      "line": 25
    },
    {
      "cells": [
        "Out Of Pocket Maximum",
        ""
      ],
      "line": 26
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0  copay"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans",
  "matchedColumns": [
    6,
    11,
    12
  ],
  "rows": [
    {
      "cells": [
        "Monthly Premium",
        "$0"
      ],
      "line": 29
    },
    {
      "cells": [
        "Annual Deductible",
        "$0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5"
      ],
      "line": 30
    },
    {
      "cells": [
        "Prescription Drugs, Tier 1",
        "$0  copay"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 62135689137,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 22480523471,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 5558487843,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_plan_summary_ums(DataTable)"
});
formatter.result({
  "duration": 440893900,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_addtocompare_ums()"
});
formatter.result({
  "duration": 1317449696,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.addToCompareNotPresentForDSNP()"
});
formatter.result({
  "duration": 50872,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_marketingBullets()"
});
formatter.result({
  "duration": 501910565,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_views_plandetails_selected_plan_ums(DataTable)"
});
formatter.result({
  "duration": 15457409606,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_BackToPlansLink_and_validates_redirection_in_UMS_site()"
});
formatter.result({
  "duration": 8833092376,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_inUMS(DataTable)"
});
formatter.result({
  "duration": 90257,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_planBenefitValues_PDP_AARP(DataTable)"
});
formatter.result({
  "duration": 332257504,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_premium0_validateText_inUMS()"
});
formatter.result({
  "duration": 63590,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.toolTip_annualDeductible_inUMS()"
});
formatter.result({
  "duration": 578969501,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_clicks_enterDrugInformation_validates_dceHomePage_UMS()"
});
formatter.result({
  "duration": 9296064653,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.User_clicks_returnToPlanSummary_validates_redirection_PlanSummary_ums()"
});
formatter.result({
  "duration": 14546318397,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesAndClickslearnMoreAboutExtraHelp_aarp()"
});
formatter.result({
  "duration": 906563205,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validatesPopup_learnMoreAboutExtraHelp_ums()"
});
formatter.result({
  "duration": 596368490,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_IsMyProviderCoveredLink_UMS()"
});
formatter.result({
  "duration": 66462,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_IsMyProviderCoveredLink_ums()"
});
formatter.result({
  "duration": 53744,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_clicks_enrollInPlan_validates_welcomeOLE()"
});
formatter.result({
  "duration": 12801753683,
  "status": "passed"
});
formatter.embedding("image/png", "embedded12.png");
formatter.after({
  "duration": 4553444557,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 50,
  "name": "TID: \u003cTID\u003e -plan type: \u003cplantype\u003e - Verify right rail on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-ums-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 49,
      "name": "@rightRailRegression"
    },
    {
      "line": 49,
      "name": "@rightRailRegressionUHC"
    }
  ]
});
formatter.step({
  "line": 51,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 52,
  "name": "the user does plan search using the following information in UMS site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 53
    },
    {
      "cells": [
        "Is Multi County",
        "\u003cisMultutiCounty\u003e"
      ],
      "line": 54
    },
    {
      "cells": [
        "County Name",
        "\u003ccounty\u003e"
      ],
      "line": 55
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "user views plans of the below plan type in UMS site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplantype\u003e"
      ],
      "line": 57
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the user validates the right rail in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 59,
  "name": "the user validates the Need Help Section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "the user validates the TFN in the Need Help Section in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "the user validates and clicks on Find an agent in your area link in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "the user validates Get a free medicare Guide section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the user enters the following information in the Get a free medicare Guide section in ums Site",
  "rows": [
    {
      "cells": [
        "First Name",
        "\u003cfirstName\u003e"
      ],
      "line": 64
    },
    {
      "cells": [
        "Last Name",
        "\u003clastName\u003e"
      ],
      "line": 65
    },
    {
      "cells": [
        "Email Address",
        "\u003cemailAddress\u003e"
      ],
      "line": 66
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 67,
  "name": "the user validates Plan Selector Tool section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 68,
  "name": "the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 69,
      "value": "# Then the user validates Need More Information section in the right rail in ums Site"
    },
    {
      "line": 70,
      "value": "# Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in ums Site"
    }
  ],
  "line": 72,
  "name": "",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-ums-site;",
  "rows": [
    {
      "cells": [
        "TID",
        "zipcode",
        "isMultutiCounty",
        "county",
        "plantype",
        "firstName",
        "lastName",
        "emailAddress"
      ],
      "line": 73,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-ums-site;;1"
    },
    {
      "cells": [
        "15549",
        "90210",
        "NO",
        "Los Angeles County",
        "MAPD",
        "test",
        "test",
        "test@test.com"
      ],
      "line": 74,
      "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-ums-site;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 606769,
  "status": "passed"
});
formatter.before({
  "duration": 41799008,
  "status": "passed"
});
formatter.scenario({
  "line": 74,
  "name": "TID: 15549 -plan type: MAPD - Verify right rail on plan summary page in UMS site",
  "description": "",
  "id": "to-test-vpp-plan-summary-page-in-ums-site;tid:-\u003ctid\u003e--plan-type:-\u003cplantype\u003e---verify-right-rail-on-plan-summary-page-in-ums-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 49,
      "name": "@rightRailRegressionUHC"
    },
    {
      "line": 1,
      "name": "@vppPlanSummary"
    },
    {
      "line": 49,
      "name": "@rightRailRegression"
    }
  ]
});
formatter.step({
  "line": 51,
  "name": "the user is on uhcmedicaresolutions site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 52,
  "name": "the user does plan search using the following information in UMS site",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "rows": [
    {
      "cells": [
        "Zip Code",
        "90210"
      ],
      "line": 53
    },
    {
      "cells": [
        "Is Multi County",
        "NO"
      ],
      "line": 54
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 55
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "user views plans of the below plan type in UMS site",
  "matchedColumns": [
    4
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MAPD"
      ],
      "line": 57
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the user validates the right rail in UMS Site",
  "keyword": "Then "
});
formatter.step({
  "line": 59,
  "name": "the user validates the Need Help Section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "the user validates the TFN in the Need Help Section in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 61,
  "name": "the user validates and clicks on Find an agent in your area link in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "the user validates Get a free medicare Guide section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the user enters the following information in the Get a free medicare Guide section in ums Site",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "rows": [
    {
      "cells": [
        "First Name",
        "test"
      ],
      "line": 64
    },
    {
      "cells": [
        "Last Name",
        "test"
      ],
      "line": 65
    },
    {
      "cells": [
        "Email Address",
        "test@test.com"
      ],
      "line": 66
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 67,
  "name": "the user validates Plan Selector Tool section in the right rail in ums Site",
  "keyword": "Then "
});
formatter.step({
  "line": 68,
  "name": "the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site",
  "keyword": "Then "
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.the_user_on_uhc_medicareplans_Site()"
});
formatter.result({
  "duration": 54651996433,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.zipcode_details_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 16873841948,
  "status": "passed"
});
formatter.match({
  "location": "VppStepDefinitionUHC.user_performs_planSearch_in_UMS_site(DataTable)"
});
formatter.result({
  "duration": 5358508601,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validates_rightRail()"
});
formatter.result({
  "duration": 504708106,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_needHelp_rightRail()"
});
formatter.result({
  "duration": 397130172,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_TFN_inRIghtRail_aarp()"
});
formatter.result({
  "duration": 403118279,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validateAndClick_findAgentInYourArea_RightRail()"
});
formatter.result({
  "duration": 22132208108,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_freeMedicareGuide_rightRail()"
});
formatter.result({
  "duration": 2191476670,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_enters_necessaryInformation_inGetFreeMedicareGuideSection(DataTable)"
});
formatter.result({
  "duration": 11451978217,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.validate_planSelectorTool_rightRail()"
});
formatter.result({
  "duration": 1381207697,
  "status": "passed"
});
formatter.match({
  "location": "VppPlanSummaryStepDefinitionUHC.user_validate_planSelectorPage_inaarpSite()"
});
formatter.result({
  "duration": 53683927946,
  "status": "passed"
});
formatter.embedding("image/png", "embedded13.png");
formatter.after({
  "duration": 5603643982,
  "status": "passed"
});
});