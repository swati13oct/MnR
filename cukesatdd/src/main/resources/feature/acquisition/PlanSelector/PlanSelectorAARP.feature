@PlanSelectorAARP
Feature: 1.12-Plan Selector Tool flow - Verify back to plan options navigation to plan selector page

  @UlayerPST @Spartans @planSelectorRegression @pstULayerSmoke
  Scenario Outline: TID: 15474 - To validate Plan selector flow in AARP site
    Given the user is on Acquisition AARP medicare site landing page
    When user goes to ours plan tab and click on Plan Selector button
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select my Response and go to Next Questionnaire
    And I select my second Response and go directly to results page
    And I click plan detail button
    Then the user clicks on both top and bottom back to plan options link and validates its redirection

    Examples: 
      | zipcode | isMultutiCounty | county      |
      |   90210 | NO              | Los Angeles |

  @ulayerPSTPlanSummary @Spartans @planSelectorRegression
  Scenario Outline: TID: 15475 -To validate Plan selector flow from Plan Summary Page in AARP site
    Given the user is on Acquisition AARP medicare site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    When user scrolls down to Plan selector on VPP page on right rail widget
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>         |
      | CountyDropDown  | <countyDropDown>  |
      | Is Multi County | <isMultutiCounty> |
    And I select my Response and go to Next Questionnaire
    And I select my second Response and go directly to results page
    And I click plan detail button
    Then the user clicks on both top and bottom back to plan options link and validates its redirection

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | countyDropDown |
      |   78006 | YES             | Bexar County | MA       | Bexar, TX      |

  @ulayerPSTPlanDetails @Spartans @planSelectorRegression
  Scenario Outline: TID: 15476 -To validate Plan selector flow from Plan Details Page in AARP site
    Given the user is on Acquisition AARP medicare site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site for DST
      | Plan Name | <planName> |
    When user scrolls down to Plan selector on VPP detail page on right rail widget
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>         |
      | CountyDropDown  | <countyDropDown>  |
      | Is Multi County | <isMultutiCounty> |
    And I select my Response and go to Next Questionnaire
    And I select my second Response and go directly to results page
    And I click plan detail button
    Then the user clicks on both top and bottom back to plan options link and validates its redirection

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | countyDropDown | planName                                   |
      |   78006 | YES             | Bexar County | MA       | Bexar, TX      | AARP MedicareComplete SecureHorizons (HMO) |
