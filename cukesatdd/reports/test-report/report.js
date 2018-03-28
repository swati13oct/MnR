$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HSID/HSID-registration.feature");
formatter.feature({
  "line": 2,
  "name": "To test HSID registration flow",
  "description": "",
  "id": "to-test-hsid-registration-flow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@aprilRelease2018"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Verify HSID registration.",
  "description": "",
  "id": "to-test-hsid-registration-flow;verify-hsid-registration.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@hsidregistration"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on medicare sign in page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user clicks on Register now link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "HSID registration page is displayed with all the fields",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "enter first name, last name, date of birth, zip code, member id and click continue",
  "rows": [
    {
      "cells": [
        "firstName",
        "\u003cfirstName\u003e"
      ],
      "line": 10
    },
    {
      "cells": [
        "lastName",
        "\u003clastName\u003e"
      ],
      "line": 11
    },
    {
      "cells": [
        "dob",
        "\u003cdob\u003e"
      ],
      "line": 12
    },
    {
      "cells": [
        "memberid",
        "\u003cmemberid\u003e"
      ],
      "line": 13
    },
    {
      "cells": [
        "zipcode",
        "\u003czipcode\u003e"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user is navigated to step two:create account page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "enter username, password, re-enter password, email, re-enter email",
  "rows": [
    {
      "cells": [
        "userName",
        "\u003cuserName\u003e"
      ],
      "line": 17
    },
    {
      "cells": [
        "password",
        "\u003cpassword\u003e"
      ],
      "line": 18
    },
    {
      "cells": [
        "email",
        "\u003cemail\u003e"
      ],
      "line": 19
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "select the security type as \"Security questions\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "select security question1 as \"What was your first phone number?\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "select security answer1 as \"number1\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "select security question2 as \"What is your best friend\u0027s name?\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "select security answer2 as \"name1\"",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "select security question3 as \"What is your favorite color?\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "select security answer3 as \"color1\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "check the terms and click on create my ID button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "user is navigated to Confirm email page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user should see a latest unread mail recieved in provided email address",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "user should copy the confirm email url to browser",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "user should be at Sign In page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user should see the email confirmation message \"Email confirmed: Please sign in with your new username and password.\" in Sign In form",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "user should see a latest unread mail recieved from \"myUHCMedicare.com - your HealthSafe ID registration is complete\" in mail server",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I should see a Username or email address label with textbox in Sign In page",
  "keyword": "And "
});
formatter.examples({
  "line": 37,
  "name": "",
  "description": "",
  "id": "to-test-hsid-registration-flow;verify-hsid-registration.;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "dob",
        "memberid",
        "zipcode",
        "userName",
        "password",
        "email",
        "question1",
        "question2",
        "question3"
      ],
      "line": 38,
      "id": "to-test-hsid-registration-flow;verify-hsid-registration.;;1"
    },
    {
      "cells": [
        "ACDBSDF",
        "ADFACBBD",
        "12/23/1934",
        "000971217-1",
        "99833",
        "q1_aarp_feb357",
        "Test2day",
        "bhavana.pilli@optum.com",
        "number1",
        "name1",
        "color1"
      ],
      "line": 39,
      "id": "to-test-hsid-registration-flow;verify-hsid-registration.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7253849,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Verify HSID registration.",
  "description": "",
  "id": "to-test-hsid-registration-flow;verify-hsid-registration.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@aprilRelease2018"
    },
    {
      "line": 4,
      "name": "@hsidregistration"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user is on medicare sign in page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user clicks on Register now link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "HSID registration page is displayed with all the fields",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "enter first name, last name, date of birth, zip code, member id and click continue",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "firstName",
        "ACDBSDF"
      ],
      "line": 10
    },
    {
      "cells": [
        "lastName",
        "ADFACBBD"
      ],
      "line": 11
    },
    {
      "cells": [
        "dob",
        "12/23/1934"
      ],
      "line": 12
    },
    {
      "cells": [
        "memberid",
        "000971217-1"
      ],
      "line": 13
    },
    {
      "cells": [
        "zipcode",
        "99833"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user is navigated to step two:create account page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "enter username, password, re-enter password, email, re-enter email",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "rows": [
    {
      "cells": [
        "userName",
        "q1_aarp_feb357"
      ],
      "line": 17
    },
    {
      "cells": [
        "password",
        "Test2day"
      ],
      "line": 18
    },
    {
      "cells": [
        "email",
        "bhavana.pilli@optum.com"
      ],
      "line": 19
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "select the security type as \"Security questions\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "select security question1 as \"What was your first phone number?\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "select security answer1 as \"number1\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "select security question2 as \"What is your best friend\u0027s name?\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "select security answer2 as \"name1\"",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "select security question3 as \"What is your favorite color?\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "select security answer3 as \"color1\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "check the terms and click on create my ID button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "user is navigated to Confirm email page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user should see a latest unread mail recieved in provided email address",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "user should copy the confirm email url to browser",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "user should be at Sign In page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user should see the email confirmation message \"Email confirmed: Please sign in with your new username and password.\" in Sign In form",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "user should see a latest unread mail recieved from \"myUHCMedicare.com - your HealthSafe ID registration is complete\" in mail server",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I should see a Username or email address label with textbox in Sign In page",
  "keyword": "And "
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.the_user_is_on_medicare_sign_in_page()"
});
formatter.result({
  "duration": 19286530427,
  "status": "passed"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.the_user_clicks_on_Register_now_link()"
});
formatter.result({
  "duration": 12023235952,
  "status": "passed"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.hsid_registration_page_is_displayed_with_all_the_fields()"
});
formatter.result({
  "duration": 171198309,
  "status": "passed"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.enter_first_name_last_name_date_of_birth_zip_code_member_id_and_click_continue(DataTable)"
});
formatter.result({
  "duration": 6469294796,
  "error_message": "java.lang.AssertionError: Errors in Registration Personal Info page and not navigated to Create Account page\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat pages.redesign.HsidRegistrationPersonalInformationPage.clickContinue(HsidRegistrationPersonalInformationPage.java:104)\r\n\tat acceptancetests.memberredesign.HSID.HsidRegistrationStepDefinition.enter_first_name_last_name_date_of_birth_zip_code_member_id_and_click_continue(HsidRegistrationStepDefinition.java:83)\r\n\tat ✽.And enter first name, last name, date of birth, zip code, member id and click continue(HSID/HSID-registration.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.user_is_navigated_to_step_two_create_account_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.enter_username_password_re_enter_password_email_re_enter_email(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Security questions",
      "offset": 29
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_the_security_type_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "What was your first phone number?",
      "offset": 30
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_question1_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "number1",
      "offset": 28
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_answer1_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "What is your best friend\u0027s name?",
      "offset": 30
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_question2_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "name1",
      "offset": 28
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_answer2_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "What is your favorite color?",
      "offset": 30
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_question3_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "color1",
      "offset": 28
    }
  ],
  "location": "HsidRegistrationStepDefinition.select_security_answer3_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.check_the_terms_and_click_on_create_my_ID_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.user_is_navigated_to_Confirm_email_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.user_should_see_a_latest_unread_mail_recieved_in_provided_email_address()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.user_should_copy_the_confirm_email_url_to_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.user_should_be_at_Sign_In_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Email confirmed: Please sign in with your new username and password.",
      "offset": 48
    }
  ],
  "location": "HsidRegistrationStepDefinition.user_should_see_the_email_confirmation_message_in_Sign_In_form(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "myUHCMedicare.com - your HealthSafe ID registration is complete",
      "offset": 52
    }
  ],
  "location": "HsidRegistrationStepDefinition.user_should_see_a_latest_unread_mail_recieved_from_in_mail_server(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HsidRegistrationStepDefinition.i_should_see_a_Username_or_email_address_label_with_textbox_in_Sign_In_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3479295,
  "status": "passed"
});
});