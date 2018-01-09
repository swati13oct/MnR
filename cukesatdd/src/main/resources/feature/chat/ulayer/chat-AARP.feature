@chatFeature
Feature: To test chat feature in AARP site

  @proactivechatOnVPPSummarypage
  Scenario Outline: Verify chat feature on plan summary in AARP site
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    Then user validates plan count for all plan types on plan summary page in AARP site
    When the user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user validates the available plans for selected plan types in AARP site
    And the user validates the plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    When user clicks on yes button on proactive chat  
    Then the proactive chat should display

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @reactivechatOnVPPSummarypage
  Scenario Outline: Verify chat feature on plan summary in AARP site
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    Then user validates plan count for all plan types on plan summary page in AARP site
    When the user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user validates the available plans for selected plan types in AARP site
    And the user validates the plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    When user clicks on Chat Now button  
    Then the reactive chat should display

    Examples: 
      | zipcode | county             | plantype | planName                                          |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
