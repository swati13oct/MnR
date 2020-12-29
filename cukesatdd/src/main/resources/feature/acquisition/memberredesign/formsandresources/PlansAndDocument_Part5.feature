 @PlansAndDocument_Part5 @PlansAndDocuments @VelocityDasher @regressionMember
Feature: 1.06.5 Member Plans and Documents Page Part 5

						# This feature File consist of Scenario 21 to 25.
	
	 @PlansAndDocument21 @shipscenario @PD_Part5_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    
    Examples: 
      | TID   | planType            | memberType         | benefitstable  | planoverview  | outlineofcoverage   |
      | 15119 | SHIP_FromsResources | IndPharmacyShipFnR | Benefits Table | Plan Overview | Outline of Coverage |

  @PlansAndDocument22 @memberauthfnrpagevalidation @PD_Part5_Regression
  Scenario Outline: TID: <TID> -Username: <username> - To validate the forms and resources page through Member auth.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user Clicks on the Pop up displayed and checks payment link

    Examples: 
      | TID   | username  | password  | member          |
      | 00000 | qavgogine | qavgogine | q2_jun_aarp0055 |

  @PlansAndDocument23 @pcpMedicaValidationOfProviderSearch @PD_Part5_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for PCP medica members Provider search link
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And User clicks on Provider search link and checks if the find care page opens up

    Examples: 
      | TID   | planType | memberType               |
      | 00001 | MAPD     | PCP_FromsandResources    |
      | 00002 | MAPD     | MEDICA_FromsandResources |

  #Need a ship Active member with New pre effective plan
  @PlansAndDocument24 @ShipActiveShipPre @regressionMember @release_june_2019 @PD_Part5_Regression
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    Then verifies Ship EOB field is displayed for effecitve plan
    Then verify Preeffective plan name and Coverage Date for preeffective plan
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan

    Examples: 
      | FID     | planType | memberType           | benefitstable  | planoverview  | outlineofcoverage   | ShipPreEffePlan               | CoverageDate               |
      | F282605 | SHIP     | ShipActievNewPreShip | Benefits Table | Plan Overview | Outline of Coverage | AARP MEDICARE SELECT PLAN CS1 | Coverage Starts 08/01/2019 |

  #Need a ship Terminated member with New pre effective plan
  @PlansAndDocument25 @ShipTerminatedShipPre @regressionMember @release_june_2019 @PD_Part5_Regression
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    Then verifies Ship EOB field is displayed for effecitve plan
    Then verify Preeffective plan name and Coverage Date for preeffective plan
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan

    Examples: 
      | FID     | planType | memberType        | benefitstable  | planoverview  | outlineofcoverage   | ShipPreEffePlan                   | CoverageDate               |
      | F282605 | SHIP     | ShipTerNewPreShip | Benefits Table | Plan Overview | Outline of Coverage | AARP MEDICARE SUPPLEMENT PLAN K01 | Coverage Starts 08/01/2019 |
	