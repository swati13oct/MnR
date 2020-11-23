@vppBlayer @emailAndPrint @emailAndPrint_UHC
Feature: 2.04.ACQ-Print and email on VPP page on UMS

  @emailAndPrint_UHC1 @emailAndPrintplancompare @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline:TID: <TID> -plantype: <plantype> - Verify print and email for plan compare page in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type on test site
      | Plan Type | <plantype> |
      | Site      | <site>     |
    Then user saves first plan on plan summary page on test site
    Then I select multiple plans to compare for selected plan and click on compare plan link in the test site
      | plan type | <plantype> |
    Then the user validate the print link option in plan compare on test site
    Then the user validates the functionality of print button on the plan compare Page in test site
    Then the user validate the email link option in plan compare on test site
    Then the user validate thank you message in plan compare for selected plan in test site
    Then I click back to all plans button and verify that all plans are still selected on summary page on test site
    Then user loads page using email deeplink and validate vpp compare page content on test site

    Examples:
      | TID   | site   | zipcode | plantype | isMultiCounty |
      | 15523 | Blayer | 90210   | MA       | NO            |

  @prodRegression
    Examples:
      | TID   | site   | zipcode | plantype | isMultiCounty |
      | 15523 | Blayer | 90210   | PDP      | NO            |

  @emailAndPrint_UHC2 @emailAndPrintplanDetails @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline:TID: <TID> -plantype: <plantype> - Verify email and Print plan functionalities on Plan Details page in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type on test site
      | Plan Type | <plantype> |
      | Site      | <site>     |
    And the user selects plan year for the UMS site
      | Plan Year | <planyear> |
    Then the user view plan details of the first plan in the given plan type and perform validation in test site
    Then the user validate the print link on the plan Details Page on test site
    Then the user validates the functionality of print button on the plan Details Page in test site
    Then the user validate the email link on the plan Details Page on test site
    Then the user validates the functionality of email button on the plan Details Page in test site
    Then user loads page using email deeplink and validate vpp detail page content on test site

    Examples:
      | TID   | site   | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | Blayer | 80001   | MA       | No              | current  |
      | 15531 | Blayer | 80001   | PDP      | No              | current  |

  @prodRegression
    Examples:
      | TID   | site   | zipcode | plantype | isMultutiCounty | planyear |
      | 15531 | Blayer | 80001   | SNP      | No            | current  |


  @emailAndPrint_UHC3 @emailAndPrintplanSummary @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailUhc @predators @Apr_release_2019
  Scenario Outline: UID: <UID> -plantype: <plantype> - Verify user can invoke the email button and the print button on view plan preview page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type on test site
      | Plan Type | <plantype> |
      | Site      | <site>     |
    And the user selects plan year for the UMS site
      | Plan Year | <planyear> |
    Then user saves first plan on plan summary page on test site
    Then user validates print option for selected plan on plan summary page on test site
    Then user validates print functionality for selected plan on plan summary page on test site
    Then user validates email option for selected plan on plan summary page on test site
    Then user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site
    Then user loads page using email deeplink for plan and validate vpp summary page content on test site

    Examples:
      | UID     | site   | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | Blayer | PDP      | 80001   | NO            | Jefferson County | current  |
      | 1598166 | Blayer | SNP      | 80001   | NO            | Jefferson County | current  |

  @prodRegression
    Examples:
      | UID     | site   | plantype | zipcode | isMultiCounty | county           | planyear |
      | 1598166 | Blayer | MA       | 80001   | NO            | Jefferson County | current  |

