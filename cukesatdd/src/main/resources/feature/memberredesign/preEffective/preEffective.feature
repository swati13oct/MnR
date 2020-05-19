@preEffective @codetransformers
Feature: 1.15 Member pre-effective functionality

  @preEffective1 @regressionMember @codetransformers
  Scenario Outline: -planType: <planType> -Segment ID: <segmentId> - Member Type - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
    And user clicks on the benefits and coverage tab on the dashboard home page or test harness page
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message and plan documents button are displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And user clicks on claims tab from Forms and Resources page
    And verify that subnavigation is supressed on the claims page
    And verify that correct preeffective message is displayed on claims page
    And verify segment ID on claims page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Segment ID  | <segmentId>  |
    And verify that correct phone number is displayed in technical support section of claims page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on Claims Page
      | Member Type | <memberType> |
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |

    Examples: 
      | planType        | memberType            | copayCategory | technicalTFN   | segmentId |
      | IndMA           | preeffectiveIndMA     | NON LIS       | 1-888-980-8125 |       000 |
      | IndMAPD         | preeffectiveIndMAPD   | NON LIS       | 1-888-980-8125 |       000 |
      | IndPDP          | preeffectiveIndPDP    | NON LIS       | 1-888-980-8125 |       000 |
      | GroupMA         | preeffectiveGroupMA   | NON LIS       | 1-888-980-8125 |       000 |
      | GroupMAPD       | preeffectiveGroupMAPD | NON LIS       | 1-888-980-8125 |       000 |
      | GroupSSUP       | preeffectiveGroupSSUP | NON LIS       | 1-888-980-8125 |       000 |
      | GroupPDP        | preeffectiveGroupPDP  | NON LIS       | 1-888-980-8125 |       000 |
      | SHIPPreffective | preeffectiveSHIPOnly  | NON LIS       | 1-866-254-3132 |       000 |

  #   | IndMAPD         | preeffectiveIndMAPD_002   | NON LIS       | 1-888-980-8125| 002       |
 
 
  @preEffective2 @regressionMember @regression_Pre-Effective_AccountSettings_Page @codetransformers
  Scenario Outline: Verify that a preffective member is able to see the Account settings page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    And preuser is navigated to Account Settings page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    Then the user validates HEALTHSAFE ID PASSWORD & HEALTHSAFE ID ACCOUNT RECOVERY & SECURITY links
    Then the email address section should be verified
    Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates Communication Preferences section
    And the user validates sign up today link
    Then the user validates the presence of Back to Profile and Preferences links
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples: 
      | planType | memberType             | copayCategory |
      | IndPDP   | preeffectiveIndPDP     | NON LIS       |
      | GrpMAPD  | preeffectiveIndMAPD001 | NON LIS       |

  #The below scenario is used for VBF in gating.
  @preEffectiveVBF @MemberVBF
  Scenario Outline: Verify that correct links and messages are displayed on Dashboard and Secondary Pages for pre-effective members through Test harness
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    And verify that preeffective message is displayed on the test harness page
    And verify that payment tab is displayed to Preeffective member on test harness page
    And user goes to payments page and verifies that correct view is displayed
    And user clicks on the benefits and coverage tab from Payments page
    And verify that correct preeffective message and plan documents button are displayed on coverage and benefits page
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And user clicks on claims tab from Forms and Resources page
    And verify that subnavigation is supressed on the claims page
      | Member Type | <memberType> |
    And verify that correct preeffective message is displayed on claims page
    #    And verify that correct phone number is displayed in technical support section of claims page
    #  | Technical TFN | <technicalTFN> |
    And the user clicks on Account Profile tab & selects Account Settings from the drop down from claims page
    And verify that the pre effecctive member can access the account settings page to view security and sign-in preferences

    Examples: 
      | memberType      | friendname | favcolor | phonenumber | technicalTFN   |
      | PreEffectivePDP | name1      | color1   | number1     | 1-888-980-8125 |
