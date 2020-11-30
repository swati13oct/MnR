Feature: 1.15 Member pre-effective functionality

  @regressionMember
  Scenario Outline: -planType: <planType> - Member Type: - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType | <planType> |
    And user clicks on the benefits and coverage tab on the dashboard home page or test harness page
    And verify that subnavigation is supressed on the coverage and benefits page
    #And verify that correct preeffective message is displayed on coverage and benefits page
    #And verify that correct phone number is displayed in technical support section of coverage and benefits page
    #  | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
    And user clicks on the Premium Payment tab from Forms and Resources Page
      | Member Type | <memberType> |
    And verify that correct phone number is displayed in technical support section of Payments page
      | Member Type   | <memberType>   |
      | Technical TFN | <technicalTFN> |

    Examples: 
      | planType        | memberType            | copayCategory | technicalTFN   | segmentId |
      | IndMAPD         | preeffectiveIndMAPD   | NON LIS       | 1-888-980-8125 |       000 |    
      | GroupPDP        | preeffectiveGroupPDP  | NON LIS       | 1-888-980-8125 |       000 |
 
