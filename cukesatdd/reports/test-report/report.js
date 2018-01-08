$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('feature\HICN-MBI\HICN-MBI.feature');
formatter.feature({
  "line": 3,
  "name": "ATDD implementation for HICN/MBI entry to Medicare ID field for Personal Identification Page in Registration Flow",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.scenario({
  "line": 37,
  "name": "Medicare ID filed should accept either HICN or MBI number for Server date 01 Apr 2018 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-01-apr-2018-without-error-for-personal-identification;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@HICN_MBI_Entry_Apr2018"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1522562400000"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 27
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 28
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "HICN"
      ],
      "line": 30
    },
    {
      "cells": [
        "Identification Value",
        "163344396A"
      ],
      "line": 31
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 22470324527,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 63875843259,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 11853579481,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 6146772019,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 35359783392,
  "status": "passed"
});
formatter.embedding('image/png','embedded0.png');
formatter.scenario({
  "line": 38,
  "name": "Medicare ID filed should accept either HICN or MBI number for Server date 01 Apr 2018 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-01-apr-2018-without-error-for-personal-identification;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@HICN_MBI_Entry_Apr2018"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1522562400000"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 27
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 28
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 30
    },
    {
      "cells": [
        "Identification Value",
        "2A22C22YK22"
      ],
      "line": 31
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 31096705418,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 106256890298,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 12768021998,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 6154107826,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 21904141428,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:33)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded1.png');
formatter.scenario({
  "line": 39,
  "name": "Medicare ID filed should accept either HICN or MBI number for Server date 01 Apr 2018 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-01-apr-2018-without-error-for-personal-identification;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@HICN_MBI_Entry_Apr2018"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1522562400000"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 27
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 28
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 30
    },
    {
      "cells": [
        "Identification Value",
        "1A11C11YK11"
      ],
      "line": 31
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 20555445563,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 62180175048,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 6519837261,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 300617069,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 22992101265,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:33)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded2.png');
formatter.scenario({
  "line": 57,
  "name": "Medicare ID filed should accept either HICN OR MBI number for Server date 31 Dec 2019 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-31-dec-2019-without-error-for-personal-identification;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@HICN_MBI_Entry_Dec2019"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577772000000"
      ],
      "line": 45
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 47
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 48
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "HICN"
      ],
      "line": 50
    },
    {
      "cells": [
        "Identification Value",
        "163344396A"
      ],
      "line": 51
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 38992069174,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 80650355350,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 5882877403,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 6912166264,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 23798842582,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:53)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded3.png');
formatter.scenario({
  "line": 58,
  "name": "Medicare ID filed should accept either HICN OR MBI number for Server date 31 Dec 2019 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-31-dec-2019-without-error-for-personal-identification;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@HICN_MBI_Entry_Dec2019"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577772000000"
      ],
      "line": 45
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 47
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 48
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 50
    },
    {
      "cells": [
        "Identification Value",
        "2A22C22YK22"
      ],
      "line": 51
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 33197057975,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 65519394017,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 12644911827,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 7053483810,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 17142202147,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:53)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded4.png');
formatter.scenario({
  "line": 59,
  "name": "Medicare ID filed should accept either HICN OR MBI number for Server date 31 Dec 2019 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-either-hicn-or-mbi-number-for-server-date-31-dec-2019-without-error-for-personal-identification;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@HICN_MBI_Entry_Dec2019"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577772000000"
      ],
      "line": 45
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 47
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 48
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 50
    },
    {
      "cells": [
        "Identification Value",
        "1A11C11YK11"
      ],
      "line": 51
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 41770786422,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 112894813287,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 6896721049,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 364858804,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 27322812888,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:53)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded5.png');
formatter.scenario({
  "line": 76,
  "name": "Medicare ID filed should accept MBI number for Server date 01 Jan 2020 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-mbi-number-for-server-date-01-jan-2020-without-error-for-personal-identification;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    },
    {
      "line": 61,
      "name": "@MBI_Entry_Jan2020"
    }
  ]
});
formatter.step({
  "line": 63,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577858460000"
      ],
      "line": 64
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 66
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 67
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 68,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 69
    },
    {
      "cells": [
        "Identification Value",
        "2A22C22YK22"
      ],
      "line": 70
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 24496707760,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 76811461831,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 6829585767,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 326362240,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 17111444237,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:72)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded6.png');
formatter.scenario({
  "line": 77,
  "name": "Medicare ID filed should accept MBI number for Server date 01 Jan 2020 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-accept-mbi-number-for-server-date-01-jan-2020-without-error-for-personal-identification;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    },
    {
      "line": 61,
      "name": "@MBI_Entry_Jan2020"
    }
  ]
});
formatter.step({
  "line": 63,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577858460000"
      ],
      "line": 64
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 66
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 67
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 68,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "MBI"
      ],
      "line": 69
    },
    {
      "cells": [
        "Identification Value",
        "1A11C11YK11"
      ],
      "line": 70
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 71,
  "name": "Validate that Continue button is enabled",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "User should successfully navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 32075556547,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 94037018453,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 633148108,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_enabled()"
});
formatter.result({
  "duration": 6083789791,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "duration": 23481004677,
  "error_message": "java.lang.AssertionError: ***** Create New Account - Plan Details Page is NOT Displayed *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.User_should_successfully_navigate_to_create_User_Account_Page(HICNtoMBIRegistrationFlowsStepDefinition.java:133)\r\n\tat ✽.And User should successfully navigate to create User Account Page(feature\\HICN-MBI\\HICN-MBI.feature:72)\r\n",
  "status": "failed"
});
formatter.embedding('image/png','embedded7.png');
formatter.scenario({
  "line": 94,
  "name": "Medicare ID filed should NOT accept HICN number for Server date 01 Jan 2020 without error for Personal identification",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-not-accept-hicn-number-for-server-date-01-jan-2020-without-error-for-personal-identification;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 79,
      "name": "@HICN_Entry_Jan2020"
    },
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 81,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1577858460000"
      ],
      "line": 82
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 83,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 84
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 85
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 86,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "HICN"
      ],
      "line": 87
    },
    {
      "cells": [
        "Identification Value",
        "163344396A"
      ],
      "line": 88
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "Validate that Continue button is Disabled",
  "keyword": "Then "
});
formatter.step({
  "line": 90,
  "name": "User should NOT be able navigate to create User Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 26857737823,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 93198887208,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 6258917743,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_Disabled()"
});
formatter.result({
  "duration": 7072772489,
  "error_message": "java.lang.AssertionError: ***** Continue Button is NOT DISABLED *****\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat acceptancetests.registration.Redesign.HICNtoMBIRegistrationFlowsStepDefinition.Continue_button_should_be_Disabled(HICNtoMBIRegistrationFlowsStepDefinition.java:147)\r\n\tat ✽.Then Validate that Continue button is Disabled(feature\\HICN-MBI\\HICN-MBI.feature:89)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_should_NOT_be_able_navigate_to_create_User_Account_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding('image/png','embedded8.png');
formatter.scenario({
  "line": 111,
  "name": "Medicare ID filed should NOT accept invalid HICN or MBI number for Server date 01 Apr 2018 and throw Error Message",
  "description": "",
  "id": "atdd-implementation-for-hicn/mbi-entry-to-medicare-id-field-for-personal-identification-page-in-registration-flow;medicare-id-filed-should-not-accept-invalid-hicn-or-mbi-number-for-server-date-01-apr-2018-and-throw-error-message;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TeamPredators"
    },
    {
      "line": 2,
      "name": "@F108803_HICN_MBI"
    },
    {
      "line": 96,
      "name": "@ErrorMessages_HICN_MBI"
    }
  ]
});
formatter.step({
  "line": 98,
  "name": "Server Date is set to the following date",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "Server Date",
        "1522562400000"
      ],
      "line": 99
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 100,
  "name": "User adds the following details in Registration Page and click on Continue Button",
  "matchedColumns": [
    1,
    2
  ],
  "rows": [
    {
      "cells": [
        "Member Number",
        "001742786"
      ],
      "line": 101
    },
    {
      "cells": [
        "Date Of Birth",
        "11/01/1939"
      ],
      "line": 102
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 103,
  "name": "User enters Following No in the Member ID field",
  "matchedColumns": [
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "Identification Type",
        "Invalid Value"
      ],
      "line": 104
    },
    {
      "cells": [
        "Identification Value",
        "163344396"
      ],
      "line": 105
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "The following Error Message should be Displayed",
  "matchedColumns": [
    5
  ],
  "rows": [
    {
      "cells": [
        "Error Message",
        "Your Medicare ID number was entered incorrectly. For help, call Customer Service at the number listed on the back of your member ID card (health insurance card)."
      ],
      "line": 107
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.Server_Date_is_set_to_the_following_date(DataTable)"
});
formatter.result({
  "duration": 21394520685,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable)"
});
formatter.result({
  "duration": 75768872619,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.User_enters_Following_No_in_the_Member_ID_field(DataTable)"
});
formatter.result({
  "duration": 6359424718,
  "status": "passed"
});
formatter.match({
  "location": "HICNtoMBIRegistrationFlowsStepDefinition.The_following_Error_Message_should_be_Displayed(DataTable)"
});
formatter.result({
  "duration": 11733243174,
  "status": "passed"
});
formatter.embedding('image/png','embedded9.png');
});