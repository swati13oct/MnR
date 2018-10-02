Feature: To test pre-effective functionality

  @regression  @codetransformers
  Scenario Outline: Verify that correct links and messages are displayed on Dashboard and Secondary Pages for pre-effective members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page
    And verify that payment tab is not displayed to Preeffective member on dashboard
    And user clicks on the benefits and coverage tab on the dashboard home page
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message and plan documents button are displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And user clicks on claims tab from Forms and Resources page
    And verify that subnavigation is supressed on the claims page
    And verify that correct preeffective message is displayed on claims page
    And verify that correct phone number is displayed in technical support section of claims page
    And verify that payment tab is not displayed to Preeffective member from secondary pages

    Examples: 
      | planType  | memberType            | copayCategory |
      | IndMA     | preeffectiveIndMA     | NON LIS       |
      | IndMAPD   | preeffectiveIndMAPD   | NON LIS       |
      | IndPDP    | preeffectiveIndPDP    | NON LIS       |
      | GroupMA   | preeffectiveGroupMA   | NON LIS       |
      | GroupMAPD | preeffectiveGroupMAPD | NON LIS       |
      | GroupSSUP | preeffectiveGroupSSUP | NON LIS       |
      | GroupPDP  | preeffectiveGroupPDP  | NON LIS       |

  @regression @regression_preeffective_account @codetransformers
  Scenario Outline: Verify that a preffective member is able to see the Account settings page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page
    And the user clicks on Account Profile tab & selects Account Settings from the drop down
    And user is navigated to Account Settings page
    And verify that the pre effecctive member can access the account settings page to view security and sign-in preferences

    Examples: 
      | planType | memberType         | copayCategory |
 #     | IndMA    | preeffectiveIndMA  | NON LIS       |
 #     | IndMAPD   | preeffectiveIndMAPD   | NON LIS       |
 #     | IndPDP   | preeffectiveIndPDP | NON LIS       |
       | GroupMA   | preeffectiveGroupMA   | NON LIS       |
   #   | GroupMAPD | preeffectiveGroupMAPD | NON LIS       |
  #    | GroupSSUP | preeffectiveGroupSSUP | NON LIS       |
   #   | GroupPDP  | preeffectiveGroupPDP  | NON LIS       |
