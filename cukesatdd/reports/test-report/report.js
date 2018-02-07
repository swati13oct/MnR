$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("enrollinplan/EnrollInPlan-AARP.feature");
formatter.feature({
  "line": 3,
  "name": "1.12-VBF-Acq-To test enroll in plan on AARP site",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 2,
      "name": "@enrollInPlanulayer"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Verify enroll in plan in AARP site for federal plan type member  for MA or MAPD plan",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--for-ma-or-mapd-plan",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@OLE_MA"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on AARP medicare site landing page OLE",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user performs plan search using following information in AARP site OLE",
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
        "\u003ccountyName\u003e"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user views plans of the below plan type in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user enrolls for the below plan in AARP site OLE",
  "rows": [
    {
      "cells": [
        "\u003cplanName\u003e"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user navigates to introduction information step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user fill following information in introduction information step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "First Name",
        "\u003cfirstName\u003e"
      ],
      "line": 16
    },
    {
      "cells": [
        "Middle Initial",
        "\u003cmiddleInitial\u003e"
      ],
      "line": 17
    },
    {
      "cells": [
        "Last Name",
        "\u003clastName\u003e"
      ],
      "line": 18
    },
    {
      "cells": [
        "Medicare Claim Number",
        "\u003cmedicareClaimNumber\u003e"
      ],
      "line": 19
    },
    {
      "cells": [
        "Hospital (Part A) Effective Date",
        "\u003chospitalEffectiveDate\u003e"
      ],
      "line": 20
    },
    {
      "cells": [
        "Medical (Part B) Effective Date",
        "\u003cmedicalEffectiveDate\u003e"
      ],
      "line": 21
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the user navigates to beneficiary information step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "the user fill following information in beneficiary information step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Email Address",
        "\u003cemailAddress\u003e"
      ],
      "line": 24
    },
    {
      "cells": [
        "Main Phone Number",
        "\u003cmainPhoneNumber\u003e"
      ],
      "line": 25
    },
    {
      "cells": [
        "Other Phone Number",
        "\u003cotherPhoneNumber\u003e"
      ],
      "line": 26
    },
    {
      "cells": [
        "Birth Date",
        "\u003cbirthDate\u003e"
      ],
      "line": 27
    },
    {
      "cells": [
        "Gender",
        "\u003cselectedGender\u003e"
      ],
      "line": 28
    },
    {
      "cells": [
        "Language Preference",
        "\u003clanguagePreference\u003e"
      ],
      "line": 29
    },
    {
      "cells": [
        "Address",
        "\u003caddress\u003e"
      ],
      "line": 30
    },
    {
      "cells": [
        "Apartment",
        "\u003capartment\u003e"
      ],
      "line": 31
    },
    {
      "cells": [
        "City",
        "\u003ccity\u003e"
      ],
      "line": 32
    },
    {
      "cells": [
        "Same Mailing Address",
        "Yes"
      ],
      "line": 33
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "the user navigates to sep step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 35,
      "value": "#And the user select no for Special Election Period"
    },
    {
      "line": 36,
      "value": "#\t| Plan Type | \u003cplanType\u003e |"
    }
  ],
  "line": 37,
  "name": "the user select yes for Special Election Period OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 38
    },
    {
      "cells": [
        "SEP1",
        "\u003csep1\u003e"
      ],
      "line": 39
    },
    {
      "cells": [
        "SEP2",
        "\u003csep2\u003e"
      ],
      "line": 40
    },
    {
      "cells": [
        "SEP3",
        "\u003csep3\u003e"
      ],
      "line": 41
    },
    {
      "cells": [
        "SEP4",
        "\u003csep4\u003e"
      ],
      "line": 42
    },
    {
      "cells": [
        "SEP5",
        "\u003csep5\u003e"
      ],
      "line": 43
    },
    {
      "cells": [
        "SEP6",
        "\u003csep6\u003e"
      ],
      "line": 44
    },
    {
      "comments": [
        {
          "line": 45,
          "value": "#\t | SEP8 \t\t\t| \u003csep8\u003e \t\t\t|"
        },
        {
          "line": 46,
          "value": "#\t | SEP9 \t\t\t| \u003csep9\u003e \t\t\t|"
        }
      ],
      "cells": [
        "SEPOther",
        "\u003csepOther\u003e"
      ],
      "line": 47
    },
    {
      "cells": [
        "SEPDate1",
        "\u003csepDate1\u003e"
      ],
      "line": 48
    },
    {
      "cells": [
        "SEPDate2",
        "\u003csepDate2\u003e"
      ],
      "line": 49
    },
    {
      "cells": [
        "SEPDate4",
        "\u003csepDate4\u003e"
      ],
      "line": 50
    },
    {
      "cells": [
        "SEPDate5",
        "\u003csepDate5\u003e"
      ],
      "line": 51
    },
    {
      "cells": [
        "SEPDate6",
        "\u003csepDate6\u003e"
      ],
      "line": 52
    },
    {
      "cells": [
        "SEPOtherReason",
        "\u003csepOtherReason\u003e"
      ],
      "line": 53
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "the user navigates to esrd step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "the user fill following information in esrd information step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "esrdradiooption",
        "\u003cesrdradiooption\u003e"
      ],
      "line": 56
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "the user navigates to prescription drug coverage step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the user fill following information in prescription drug coverage step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "pdcradiooption",
        "\u003cpdcradiooption\u003e"
      ],
      "line": 59
    },
    {
      "cells": [
        "pdchealthinsurname",
        "\u003cpdchealthinsurname\u003e"
      ],
      "line": 60
    },
    {
      "cells": [
        "pdcgroupidnumber",
        "\u003cpdcgroupidnumber\u003e"
      ],
      "line": 61
    },
    {
      "cells": [
        "pdcmemberidnumber",
        "\u003cpdcmemberidnumber\u003e"
      ],
      "line": 62
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "the user navigates to long term care step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "the user fill following information in long term care step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 65
    },
    {
      "cells": [
        "ltcradiooption",
        "\u003cltcradiooption\u003e"
      ],
      "line": 66
    },
    {
      "cells": [
        "ltcname",
        "\u003cltcname\u003e"
      ],
      "line": 67
    },
    {
      "cells": [
        "ltcstreetaddr",
        "\u003cltcstreetaddr\u003e"
      ],
      "line": 68
    },
    {
      "cells": [
        "ltcapt",
        "\u003cltcstreetaddr\u003e"
      ],
      "line": 69
    },
    {
      "cells": [
        "ltccity",
        "\u003cltccity\u003e"
      ],
      "line": 70
    },
    {
      "cells": [
        "ltcphonenum",
        "\u003cltcphonenum\u003e"
      ],
      "line": 71
    },
    {
      "cells": [
        "ltcdatemoved",
        "\u003cltcdatemoved\u003e"
      ],
      "line": 72
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "the user navigates to medicaid step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "the user fill following information in medicaid step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 75
    },
    {
      "cells": [
        "medicaidradiooption",
        "\u003cmedicaidradiooption\u003e"
      ],
      "line": 76
    },
    {
      "cells": [
        "medicaidnum",
        "\u003cmedicaidnum\u003e"
      ],
      "line": 77
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "the user navigates to other health insurance step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "the user fill following information in other health insurance step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "othradiooption",
        "\u003cothradiooption\u003e"
      ],
      "line": 80
    },
    {
      "cells": [
        "othnameofhealthinsur",
        "\u003cothnameofhealthinsur\u003e"
      ],
      "line": 81
    },
    {
      "cells": [
        "othgroupid",
        "\u003cothgroupid\u003e"
      ],
      "line": 82
    },
    {
      "cells": [
        "othmemberid",
        "\u003cothmemberid\u003e"
      ],
      "line": 83
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "the user navigates to primary care provider step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "the user navigates to plan payment options step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 86,
      "value": "#And the user fill following information in plan payment options step in AARP site"
    },
    {
      "line": 87,
      "value": "#  | Plan Type | \u003cplanType\u003e |"
    },
    {
      "line": 88,
      "value": "#  | planpaymentoption |\u003cplanpaymentoption\u003e|"
    }
  ],
  "line": 89,
  "name": "the user navigates to optional Riders step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "the user fill following information in optional Riders step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "optradiooption",
        "\u003coptradiooption\u003e"
      ],
      "line": 91
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "the user navigates to proposed effective date page OLE",
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "the user selects proposed effective date OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 94
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 95,
  "name": "the user navigates to review and submit application step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 96
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 97,
  "name": "the user reviews the information on review and submit application step in AARP site OLE",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 98
    },
    {
      "cells": [
        "agreeStmtUnderstanding",
        "\u003cagreeStmtUnderstanding\u003e"
      ],
      "line": 99
    },
    {
      "cells": [
        "authRepresent",
        "\u003cauthRepresent\u003e"
      ],
      "line": 100
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "the user navigates to Confirmation Page OLE",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 102,
      "value": "#And the user clicks on print this page button"
    }
  ],
  "line": 103,
  "name": "",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--for-ma-or-mapd-plan;",
  "rows": [
    {
      "cells": [
        "zipcode",
        "countyName",
        "planType",
        "planName",
        "firstName",
        "middleInitial",
        "lastName",
        "medicareClaimNumber",
        "hospitalEffectiveDate",
        "medicalEffectiveDate",
        "emailAddress",
        "mainPhoneNumber",
        "otherPhoneNumber",
        "birthDate",
        "selectedGender",
        "languagePreference",
        "address",
        "city",
        "apartment",
        "sep1",
        "sep2",
        "sep3",
        "sep4",
        "sep5",
        "sep6",
        "sepOther",
        "sepDate1",
        "sepDate2",
        "sepDate4",
        "sepDate5",
        "sepDate6",
        "sepOtherReason",
        "esrdradiooption",
        "pdcradiooption",
        "pdchealthinsurname",
        "pdcgroupidnumber",
        "pdcmemberidnumber",
        "ltcradiooption",
        "ltcname",
        "ltcstreetaddr",
        "ltcapt",
        "ltccity",
        "ltcphonenum",
        "ltcdatemoved",
        "medicaidradiooption",
        "medicaidnum",
        "othradiooption",
        "othnameofhealthinsur",
        "othgroupid",
        "othmemberid",
        "planpaymentoption",
        "optradiooption",
        "agreeStmtUnderstanding",
        "authRepresent"
      ],
      "line": 104,
      "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--for-ma-or-mapd-plan;;1"
    },
    {
      "cells": [
        "90210",
        "Los Angeles County",
        "MA",
        "AARP MedicareComplete SecureHorizons Plan 2 (HMO)",
        "First",
        "m",
        "last",
        "112-11-1117-A",
        "07/01/1988",
        "07/01/1988",
        "test@uhc.com",
        "999-991-1111",
        "999-991-1111",
        "12-20-1950",
        "Male",
        "Spanish",
        "1234",
        "Colorado",
        "UHG",
        "No",
        "Yes",
        "No",
        "No",
        "No",
        "No",
        "No",
        "02/15/2016",
        "02/15/2016",
        "02/15/2016",
        "02/15/2016",
        "02/15/2016",
        "Test",
        "No",
        "Yes",
        "abc",
        "abc",
        "123",
        "Yes",
        "first",
        "123",
        "1",
        "abc",
        "666-666-6666",
        "12-20-1982",
        "Yes",
        "12",
        "Yes",
        "insurname",
        "12",
        "13246",
        "Yes",
        "Yes",
        "Agree",
        "Agree"
      ],
      "line": 105,
      "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--for-ma-or-mapd-plan;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 16281797,
  "status": "passed"
});
formatter.scenario({
  "line": 105,
  "name": "Verify enroll in plan in AARP site for federal plan type member  for MA or MAPD plan",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--for-ma-or-mapd-plan;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@fixedTestCaseTest"
    },
    {
      "line": 4,
      "name": "@OLE_MA"
    },
    {
      "line": 2,
      "name": "@enrollInPlanulayer"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on AARP medicare site landing page OLE",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user performs plan search using following information in AARP site OLE",
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
      "line": 8
    },
    {
      "cells": [
        "County Name",
        "Los Angeles County"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the user views plans of the below plan type in AARP site OLE",
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user enrolls for the below plan in AARP site OLE",
  "matchedColumns": [
    3
  ],
  "rows": [
    {
      "cells": [
        "AARP MedicareComplete SecureHorizons Plan 2 (HMO)"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user navigates to introduction information step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "the user fill following information in introduction information step in AARP site OLE",
  "matchedColumns": [
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "First Name",
        "First"
      ],
      "line": 16
    },
    {
      "cells": [
        "Middle Initial",
        "m"
      ],
      "line": 17
    },
    {
      "cells": [
        "Last Name",
        "last"
      ],
      "line": 18
    },
    {
      "cells": [
        "Medicare Claim Number",
        "112-11-1117-A"
      ],
      "line": 19
    },
    {
      "cells": [
        "Hospital (Part A) Effective Date",
        "07/01/1988"
      ],
      "line": 20
    },
    {
      "cells": [
        "Medical (Part B) Effective Date",
        "07/01/1988"
      ],
      "line": 21
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the user navigates to beneficiary information step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "the user fill following information in beneficiary information step in AARP site OLE",
  "matchedColumns": [
    16,
    17,
    18,
    10,
    11,
    12,
    13,
    14,
    15
  ],
  "rows": [
    {
      "cells": [
        "Email Address",
        "test@uhc.com"
      ],
      "line": 24
    },
    {
      "cells": [
        "Main Phone Number",
        "999-991-1111"
      ],
      "line": 25
    },
    {
      "cells": [
        "Other Phone Number",
        "999-991-1111"
      ],
      "line": 26
    },
    {
      "cells": [
        "Birth Date",
        "12-20-1950"
      ],
      "line": 27
    },
    {
      "cells": [
        "Gender",
        "Male"
      ],
      "line": 28
    },
    {
      "cells": [
        "Language Preference",
        "Spanish"
      ],
      "line": 29
    },
    {
      "cells": [
        "Address",
        "1234"
      ],
      "line": 30
    },
    {
      "cells": [
        "Apartment",
        "UHG"
      ],
      "line": 31
    },
    {
      "cells": [
        "City",
        "Colorado"
      ],
      "line": 32
    },
    {
      "cells": [
        "Same Mailing Address",
        "Yes"
      ],
      "line": 33
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "the user navigates to sep step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 35,
      "value": "#And the user select no for Special Election Period"
    },
    {
      "line": 36,
      "value": "#\t| Plan Type | \u003cplanType\u003e |"
    }
  ],
  "line": 37,
  "name": "the user select yes for Special Election Period OLE",
  "matchedColumns": [
    2,
    19,
    20,
    21,
    22,
    23,
    24,
    25,
    26,
    27,
    28,
    29,
    30,
    31
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 38
    },
    {
      "cells": [
        "SEP1",
        "No"
      ],
      "line": 39
    },
    {
      "cells": [
        "SEP2",
        "Yes"
      ],
      "line": 40
    },
    {
      "cells": [
        "SEP3",
        "No"
      ],
      "line": 41
    },
    {
      "cells": [
        "SEP4",
        "No"
      ],
      "line": 42
    },
    {
      "cells": [
        "SEP5",
        "No"
      ],
      "line": 43
    },
    {
      "cells": [
        "SEP6",
        "No"
      ],
      "line": 44
    },
    {
      "comments": [
        {
          "line": 45,
          "value": "#\t | SEP8 \t\t\t| \u003csep8\u003e \t\t\t|"
        },
        {
          "line": 46,
          "value": "#\t | SEP9 \t\t\t| \u003csep9\u003e \t\t\t|"
        }
      ],
      "cells": [
        "SEPOther",
        "No"
      ],
      "line": 47
    },
    {
      "cells": [
        "SEPDate1",
        "02/15/2016"
      ],
      "line": 48
    },
    {
      "cells": [
        "SEPDate2",
        "02/15/2016"
      ],
      "line": 49
    },
    {
      "cells": [
        "SEPDate4",
        "02/15/2016"
      ],
      "line": 50
    },
    {
      "cells": [
        "SEPDate5",
        "02/15/2016"
      ],
      "line": 51
    },
    {
      "cells": [
        "SEPDate6",
        "02/15/2016"
      ],
      "line": 52
    },
    {
      "cells": [
        "SEPOtherReason",
        "Test"
      ],
      "line": 53
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "the user navigates to esrd step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "the user fill following information in esrd information step in AARP site OLE",
  "matchedColumns": [
    32
  ],
  "rows": [
    {
      "cells": [
        "esrdradiooption",
        "No"
      ],
      "line": 56
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "the user navigates to prescription drug coverage step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "the user fill following information in prescription drug coverage step in AARP site OLE",
  "matchedColumns": [
    33,
    34,
    35,
    36
  ],
  "rows": [
    {
      "cells": [
        "pdcradiooption",
        "Yes"
      ],
      "line": 59
    },
    {
      "cells": [
        "pdchealthinsurname",
        "abc"
      ],
      "line": 60
    },
    {
      "cells": [
        "pdcgroupidnumber",
        "abc"
      ],
      "line": 61
    },
    {
      "cells": [
        "pdcmemberidnumber",
        "123"
      ],
      "line": 62
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "the user navigates to long term care step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 64,
  "name": "the user fill following information in long term care step in AARP site OLE",
  "matchedColumns": [
    2,
    37,
    38,
    39,
    41,
    42,
    43
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 65
    },
    {
      "cells": [
        "ltcradiooption",
        "Yes"
      ],
      "line": 66
    },
    {
      "cells": [
        "ltcname",
        "first"
      ],
      "line": 67
    },
    {
      "cells": [
        "ltcstreetaddr",
        "123"
      ],
      "line": 68
    },
    {
      "cells": [
        "ltcapt",
        "123"
      ],
      "line": 69
    },
    {
      "cells": [
        "ltccity",
        "abc"
      ],
      "line": 70
    },
    {
      "cells": [
        "ltcphonenum",
        "666-666-6666"
      ],
      "line": 71
    },
    {
      "cells": [
        "ltcdatemoved",
        "12-20-1982"
      ],
      "line": 72
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "the user navigates to medicaid step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "the user fill following information in medicaid step in AARP site OLE",
  "matchedColumns": [
    2,
    44,
    45
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 75
    },
    {
      "cells": [
        "medicaidradiooption",
        "Yes"
      ],
      "line": 76
    },
    {
      "cells": [
        "medicaidnum",
        "12"
      ],
      "line": 77
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "the user navigates to other health insurance step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "the user fill following information in other health insurance step in AARP site OLE",
  "matchedColumns": [
    48,
    49,
    46,
    47
  ],
  "rows": [
    {
      "cells": [
        "othradiooption",
        "Yes"
      ],
      "line": 80
    },
    {
      "cells": [
        "othnameofhealthinsur",
        "insurname"
      ],
      "line": 81
    },
    {
      "cells": [
        "othgroupid",
        "12"
      ],
      "line": 82
    },
    {
      "cells": [
        "othmemberid",
        "13246"
      ],
      "line": 83
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 84,
  "name": "the user navigates to primary care provider step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 85,
  "name": "the user navigates to plan payment options step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 86,
      "value": "#And the user fill following information in plan payment options step in AARP site"
    },
    {
      "line": 87,
      "value": "#  | Plan Type | \u003cplanType\u003e |"
    },
    {
      "line": 88,
      "value": "#  | planpaymentoption |\u003cplanpaymentoption\u003e|"
    }
  ],
  "line": 89,
  "name": "the user navigates to optional Riders step in AARP site OLE",
  "keyword": "And "
});
formatter.step({
  "line": 90,
  "name": "the user fill following information in optional Riders step in AARP site OLE",
  "matchedColumns": [
    51
  ],
  "rows": [
    {
      "cells": [
        "optradiooption",
        "Yes"
      ],
      "line": 91
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 92,
  "name": "the user navigates to proposed effective date page OLE",
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "the user selects proposed effective date OLE",
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 94
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 95,
  "name": "the user navigates to review and submit application step in AARP site OLE",
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 96
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 97,
  "name": "the user reviews the information on review and submit application step in AARP site OLE",
  "matchedColumns": [
    2,
    52,
    53
  ],
  "rows": [
    {
      "cells": [
        "Plan Type",
        "MA"
      ],
      "line": 98
    },
    {
      "cells": [
        "agreeStmtUnderstanding",
        "Agree"
      ],
      "line": 99
    },
    {
      "cells": [
        "authRepresent",
        "Agree"
      ],
      "line": 100
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "the user navigates to Confirmation Page OLE",
  "keyword": "Then "
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_on_UHC_Medicaresolutions_Site()"
});
formatter.result({
  "duration": 32305440297,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.zipcode_details_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 66530550059,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_performs_planSearch_in_aarp_site(DataTable)"
});
formatter.result({
  "duration": 346359537,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_enrolls_for_plan(DataTable)"
});
formatter.result({
  "duration": 22486695740,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_into_information_step_aarp()"
});
formatter.result({
  "duration": 1240047290,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_introduction_information_aarp(DataTable)"
});
formatter.result({
  "duration": 12643269847,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_beneficiary_information_step_aarp()"
});
formatter.result({
  "duration": 11999571736,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_beneficiary_information_aarp(DataTable)"
});
formatter.result({
  "duration": 1987021654,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_navigates_to_sep_step()"
});
formatter.result({
  "duration": 5056618534,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_selects_yes_for_SEPQuestion(DataTable)"
});
formatter.result({
  "duration": 610964688,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_esrd_information_step_aarp()"
});
formatter.result({
  "duration": 202344126,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_esrd_information_aarp(DataTable)"
});
formatter.result({
  "duration": 411124507,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_prescription_drug_coverage_information_step_aarp()"
});
formatter.result({
  "duration": 219546033,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_prescription_drug_coverage_aarp(DataTable)"
});
formatter.result({
  "duration": 1236873055,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_long_term_care_information_step_aarp()"
});
formatter.result({
  "duration": 149889673,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_long_term_care_aarp(DataTable)"
});
formatter.result({
  "duration": 1878392110,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_to_medicaid_aarp_information_step_aarp()"
});
formatter.result({
  "duration": 201341153,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_medicaid_aarp_step_aarp(DataTable)"
});
formatter.result({
  "duration": 737786806,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_to_other_health_insurance_aarp_information_step_aarp()"
});
formatter.result({
  "duration": 253269302,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_other_health_insurance_aarp_step_aarp(DataTable)"
});
formatter.result({
  "duration": 960000049,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_to_primary_care_provider_aarp_information_step_aarp()"
});
formatter.result({
  "duration": 602259130,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_to_plan_payment_options_aarp_information_step_aarp()"
});
formatter.result({
  "duration": 3016118122,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.the_user_navigates_to_optional_riders_aarp_information_step_aarp()"
});
formatter.result({
  "duration": 108420336,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_fill_information_optional_riders_aarp_step_aarp(DataTable)"
});
formatter.result({
  "duration": 301726221,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_navigates_to_proposed_effective_date_page()"
});
formatter.result({
  "duration": 2546643569,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_selects_proposed_effective_date(DataTable)"
});
formatter.result({
  "duration": 21215192843,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_navigates_review_and_submit_application_aarp(DataTable)"
});
formatter.result({
  "duration": 637307389,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_reviews_the_information_review_and_submit_applcation_aarp(DataTable)"
});
formatter.result({
  "duration": 10895714209,
  "status": "passed"
});
formatter.match({
  "location": "EnrollInPlanStepDefinitionAARP.user_navigates_to_Confirmation_Page()"
});
formatter.result({
  "duration": 1081748643,
  "error_message": "java.lang.AssertionError: Error in validating the Confirmation Page\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.acquisitionvbf.enrollinplan.EnrollInPlanStepDefinitionAARP.user_navigates_to_Confirmation_Page(EnrollInPlanStepDefinitionAARP.java:1014)\r\n\tat ✽.Then the user navigates to Confirmation Page OLE(enrollinplan/EnrollInPlan-AARP.feature:101)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 6047490866,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 108,
  "name": "Verify enroll in plan in AARP site for federal plan type member  PDP member",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--pdp-member",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 107,
      "name": "@OLE_PDP"
    }
  ]
});
formatter.step({
  "line": 109,
  "name": "the user is on AARP medicare site landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 110,
  "name": "user performs plan search using following information in AARP site",
  "rows": [
    {
      "cells": [
        "Zip Code",
        "\u003czipcode\u003e"
      ],
      "line": 111
    },
    {
      "cells": [
        "County Name",
        "\u003ccountyName\u003e"
      ],
      "line": 112
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 113,
  "name": "the user views plans of the below plan type in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 114
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 115,
  "name": "the user enrolls for the below plan in AARP site",
  "rows": [
    {
      "cells": [
        "\u003cplanName\u003e"
      ],
      "line": 116
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 117,
  "name": "the user navigates to introduction information step in AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 118,
  "name": "the user fill following information in introduction information step in AARP site",
  "rows": [
    {
      "cells": [
        "First Name",
        "\u003cfirstName\u003e"
      ],
      "line": 119
    },
    {
      "cells": [
        "Middle Initial",
        "\u003cmiddleInitial\u003e"
      ],
      "line": 120
    },
    {
      "cells": [
        "Last Name",
        "\u003clastName\u003e"
      ],
      "line": 121
    },
    {
      "cells": [
        "Medicare Claim Number",
        "\u003cmedicareClaimNumber\u003e"
      ],
      "line": 122
    },
    {
      "cells": [
        "Hospital (Part A) Effective Date",
        "\u003chospitalEffectiveDate\u003e"
      ],
      "line": 123
    },
    {
      "cells": [
        "Medical (Part B) Effective Date",
        "\u003cmedicalEffectiveDate\u003e"
      ],
      "line": 124
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 125,
  "name": "the user navigates to beneficiary information step in AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 126,
  "name": "the user fill following information in beneficiary information step in AARP site",
  "rows": [
    {
      "cells": [
        "Email Address",
        "\u003cemailAddress\u003e"
      ],
      "line": 127
    },
    {
      "cells": [
        "Main Phone Number",
        "\u003cmainPhoneNumber\u003e"
      ],
      "line": 128
    },
    {
      "cells": [
        "Other Phone Number",
        "\u003cotherPhoneNumber\u003e"
      ],
      "line": 129
    },
    {
      "cells": [
        "Birth Date",
        "\u003cbirthDate\u003e"
      ],
      "line": 130
    },
    {
      "cells": [
        "Gender",
        "\u003cselectedGender\u003e"
      ],
      "line": 131
    },
    {
      "cells": [
        "Language Preference",
        "\u003clanguagePreference\u003e"
      ],
      "line": 132
    },
    {
      "cells": [
        "Address",
        "\u003caddress\u003e"
      ],
      "line": 133
    },
    {
      "cells": [
        "Apartment",
        "\u003capartment\u003e"
      ],
      "line": 134
    },
    {
      "cells": [
        "City",
        "\u003ccity\u003e"
      ],
      "line": 135
    },
    {
      "cells": [
        "Same Mailing Address",
        "Yes"
      ],
      "line": 136
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 137,
  "name": "the user navigates to sep step in AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 138,
  "name": "the user select no for Special Election Period",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 139
    }
  ],
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 140,
      "value": "#And the user select yes for Special Election Period"
    },
    {
      "line": 141,
      "value": "#     | Plan Type        | \u003cplanType\u003e |"
    },
    {
      "line": 142,
      "value": "#     | SEP1 \t\t\t| \u003csep1\u003e \t\t\t|"
    },
    {
      "line": 143,
      "value": "#\t | SEP2 \t\t\t| \u003csep2\u003e \t\t\t|"
    },
    {
      "line": 144,
      "value": "#\t | SEP4 \t\t\t| \u003csep4\u003e\t\t\t|"
    },
    {
      "line": 145,
      "value": "#\t | SEP5 \t\t\t| \u003csep5\u003e \t\t\t|"
    },
    {
      "line": 146,
      "value": "#\t | SEP6 \t\t\t| \u003csep6\u003e \t\t\t|"
    },
    {
      "line": 147,
      "value": "#\t | SEP7 \t\t\t| \u003csep7\u003e \t\t\t|"
    },
    {
      "line": 148,
      "value": "#\t | SEP8 \t\t\t| \u003csep8\u003e \t\t\t|"
    },
    {
      "line": 149,
      "value": "#\t | SEP9 \t\t\t| \u003csep9\u003e \t\t\t|"
    },
    {
      "line": 150,
      "value": "#\t | SEPOther \t\t| \u003csepOther\u003e \t\t|"
    },
    {
      "line": 151,
      "value": "#\t | SEPDate1 \t\t| \u003csepDate1\u003e \t\t|"
    },
    {
      "line": 152,
      "value": "#\t | SEPDate2 \t\t| \u003csepDate2\u003e \t\t|"
    },
    {
      "line": 153,
      "value": "#\t | SEPDate5 \t\t| \u003csepDate5\u003e \t\t|"
    },
    {
      "line": 154,
      "value": "#\t | SEPDate6 \t\t| \u003csepDate6\u003e \t\t|"
    },
    {
      "line": 155,
      "value": "#\t | SEPOtherReason\t| \u003csepOtherReason\u003e  |"
    }
  ],
  "line": 156,
  "name": "the user navigates to prescription drug coverage step in AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 157,
  "name": "the user fill following information in prescription drug coverage step in AARP site",
  "rows": [
    {
      "cells": [
        "pdcradiooption",
        "\u003cpdcradiooption\u003e"
      ],
      "line": 158
    },
    {
      "cells": [
        "pdchealthinsurname",
        "\u003cpdchealthinsurname\u003e"
      ],
      "line": 159
    },
    {
      "cells": [
        "pdcgroupidnumber",
        "\u003cpdcgroupidnumber\u003e"
      ],
      "line": 160
    },
    {
      "cells": [
        "pdcmemberidnumber",
        "\u003cpdcmemberidnumber\u003e"
      ],
      "line": 161
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 162,
  "name": "the user navigates to long term care step in AARP site",
  "keyword": "And "
});
formatter.step({
  "line": 163,
  "name": "the user fill following information in long term care step in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 164
    },
    {
      "cells": [
        "ltcradiooption",
        "\u003cltcradiooption\u003e"
      ],
      "line": 165
    },
    {
      "cells": [
        "ltcname",
        "\u003cltcname\u003e"
      ],
      "line": 166
    },
    {
      "cells": [
        "ltcstreetaddr",
        "\u003cltcstreetaddr\u003e"
      ],
      "line": 167
    },
    {
      "cells": [
        "ltcapt",
        "\u003cltcstreetaddr\u003e"
      ],
      "line": 168
    },
    {
      "cells": [
        "ltccity",
        "\u003cltccity\u003e"
      ],
      "line": 169
    },
    {
      "cells": [
        "ltcphonenum",
        "\u003cltcphonenum\u003e"
      ],
      "line": 170
    },
    {
      "cells": [
        "ltcdatemoved",
        "\u003cltcdatemoved\u003e"
      ],
      "line": 171
    }
  ],
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 172,
      "value": "#And the user navigates to plan payment options step in AARP site"
    }
  ],
  "line": 173,
  "name": "the user fill following information in plan payment options step in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 174
    },
    {
      "cells": [
        "planpaymentoption",
        "\u003cplanpaymentoption\u003e"
      ],
      "line": 175
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 176,
  "name": "the user navigates to proposed effective date page",
  "keyword": "And "
});
formatter.step({
  "line": 177,
  "name": "the user selects proposed effective date",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 178
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 179,
  "name": "the user navigates to review and submit application step in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 180
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 181,
  "name": "the user reviews the information on review and submit application step in AARP site",
  "rows": [
    {
      "cells": [
        "Plan Type",
        "\u003cplanType\u003e"
      ],
      "line": 182
    },
    {
      "cells": [
        "agreeStmtUnderstanding",
        "\u003cagreeStmtUnderstanding\u003e"
      ],
      "line": 183
    },
    {
      "cells": [
        "authRepresent",
        "\u003cauthRepresent\u003e"
      ],
      "line": 184
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 185,
  "name": "the user navigates to Confirmation Page",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 186,
      "value": "#And the user clicks on print this page button"
    }
  ],
  "line": 187,
  "name": "",
  "description": "",
  "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--pdp-member;",
  "rows": [
    {
      "cells": [
        "zipcode",
        "countyName",
        "planType",
        "planName",
        "firstName",
        "middleInitial",
        "lastName",
        "medicareClaimNumber",
        "hospitalEffectiveDate",
        "medicalEffectiveDate",
        "emailAddress",
        "mainPhoneNumber",
        "otherPhoneNumber",
        "birthDate",
        "selectedGender",
        "languagePreference",
        "address",
        "city",
        "apartment",
        "sep1",
        "sep2",
        "sep4",
        "sep5",
        "sep6",
        "sep7",
        "sep8",
        "sep9",
        "sepOther",
        "sepDate1",
        "sepDate2",
        "sepDate5",
        "sepDate6",
        "sepOtherReason",
        "esrdradiooption",
        "pdcradiooption",
        "pdchealthinsurname",
        "pdcgroupidnumber",
        "pdcmemberidnumber",
        "ltcradiooption",
        "ltcname",
        "ltcstreetaddr",
        "ltcapt",
        "ltccity",
        "ltcphonenum",
        "ltcdatemoved",
        "planpaymentoption",
        "agreeStmtUnderstanding",
        "authRepresent"
      ],
      "line": 188,
      "id": "1.12-vbf-acq-to-test-enroll-in-plan-on-aarp-site;verify-enroll-in-plan-in-aarp-site-for-federal-plan-type-member--pdp-member;;1"
    }
  ],
  "keyword": "Examples"
});
});