@chatFeature
Feature: To test chat feature in UMS site

  @proactiveChatOnVPPSummarypage
  Scenario Outline: Verify plan summary in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    Then user validates plan count for all plan types on plan summary page in UMS site
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the available plans for selected plan types in UMS site
    And the user validates the plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    When user clicks on yes button on proactive chat
    Then the proactive chat should display

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO) |

  @reactiveChatOnVPPSummarypage
  Scenario Outline: Verify plan summary in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    Then user validates plan count for all plan types on plan summary page in UMS site
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the available plans for selected plan types in UMS site
    And the user validates the plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    When user clicks on Chat Now button  
    Then the reactive chat should display

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 3 (HMO) |
