Feature: 1.15 Member pre-effective functionality

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

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
      | IndMA           | preeffectiveIndMA     | NON LIS       | 1-888-980-8125 |       000 |
      | IndMAPD         | preeffectiveIndMAPD   | NON LIS       | 1-888-980-8125 |       000 |
      | IndPDP          | preeffectiveIndPDP    | NON LIS       | 1-888-980-8125 |       000 |
      | GroupMA         | preeffectiveGroupMA   | NON LIS       | 1-888-980-8125 |       000 |
      | GroupMAPD       | preeffectiveGroupMAPD | NON LIS       | 1-888-980-8125 |       000 |
      | GroupSSUP       | preeffectiveGroupSSUP | NON LIS       | 1-888-980-8125 |       000 |
      | GroupPDP        | preeffectiveGroupPDP  | NON LIS       | 1-888-980-8125 |       000 |
      | SHIPPreffective | preeffectiveSHIPOnly  | NON LIS       | 1-866-254-3132 |       000 |
  #   | IndMAPD         | preeffectiveIndMAPD_002   | NON LIS       | 1-888-980-8125| 002       |



# Enable this test script if Fed+SHIP Preffective member is available  
 @regressionMember2
  Scenario Outline: -planType: <planType> - Member Type - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And user clicks on SHIP Plan Tab on Benefits and Coverage tab
    And verify that correct SHIP phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN SHIP | <technicalTFNSHIP> |
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
    And user clicks on SHIP Plan Tab on Payments page
    And verify that correct SHIP phone number is displayed in technical support section of payments page
      | Technical TFN SHIP | <technicalTFNSHIP> |

    Examples: 
      | planType | memberType               | copayCategory | technicalTFN   | segmentId | username | password | member     | planstartdate | technicalTFNSHIP |
      | IndPDP   | preeffectivePDPSHIPCOMBO | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | Shephard09 | 06/01/2020    | 1-866-254-3132   |

  @regressionMember
  Scenario Outline: -planType: <planType> - Member Type - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And user clicks on SSUP Plan Tab on Benefits and Coverage tab
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that correct phone number is displayed in technical support section of forms and resources page
      | Technical TFN | <technicalTFN> |
    And user clicks on SSUP Plan Tab on forms and resources tab
    And verify that correct phone number is displayed in technical support section of forms and resources page
      | Technical TFN | <technicalTFN> |
      
    Examples: 
      | planType     | memberType                    | copayCategory | technicalTFN   | segmentId | username | password | member         | planstartdate | 
      | GroupPDPSSUP | preeffectiveGROUPPDPSSUPCOMBO | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | tomwindsor1955 | 06/01/2020    | 
  
  
  @regressionMember2
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