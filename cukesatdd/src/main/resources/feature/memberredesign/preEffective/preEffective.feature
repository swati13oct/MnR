@preEffective @codetransformers
Feature: 1.15 Member pre-effective functionality

  @preEffective1 @regressionMember @codetransformers
  Scenario Outline: -planType: <planType> -Segment ID: <segmentId> - Verify that correct links and messages are displayed on Dashboard and Secondary Pages for pre-effective members.
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
      | Member Type | <memberType> |
    And verify that correct preeffective message is displayed on claims page
    And verify segment ID on claims page
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Segment ID     | <segmentId>    |
    And verify that correct phone number is displayed in technical support section of claims page
     | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on Claims Page
      | Member Type | <memberType> |
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |

    Examples: 
      | planType		| memberType                | copayCategory | technicalTFN  | segmentId |
      | IndMA           | preeffectiveIndMA         | NON LIS       | 1-888-980-8125| 000       |
      | IndMAPD         | preeffectiveIndMAPD       | NON LIS       | 1-888-980-8125| 000       |
      | IndPDP          | preeffectiveIndPDP        | NON LIS       | 1-888-980-8125| 000       |
      | GroupMA         | preeffectiveGroupMA       | NON LIS       | 1-888-980-8125| 000       |
      | GroupMAPD       | preeffectiveGroupMAPD     | NON LIS       | 1-888-980-8125| 000       |
      | GroupSSUP       | preeffectiveGroupSSUP     | NON LIS       | 1-888-980-8125| 000       |
      | GroupPDP        | preeffectiveGroupPDP      | NON LIS       | 1-888-980-8125| 000       |
      | SHIPPreffective | preeffectiveSHIPOnly      | NON LIS       | 1-866-254-3132| 000       |
#     | IndMAPD         | preeffectiveIndMAPD_002   | NON LIS       | 1-888-980-8125| 002       |
      
      
      
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
      | planType  | memberType          | copayCategory |
      | IndPDP          | preeffectiveIndPDP        | NON LIS       |
      

  @preEffective3 @preffectiveRegistration
  Scenario Outline: Verify HSID registration.
    Given the preuser is on medicare sign in page
    When the preuser clicks on Register now link
    # And HSID registration page is displayed with all the fields
    And the pre enter first name, last name, date of birth, zip code, member id and click continue
      | firstName | <firstname> |
      | lastName  | <lastname>  |
      | dob       | <dob>       |
      | memberid  | <memberid>  |
      | zipcode   | <zipcode>   |
    And preuser is navigated to step two:create account page
    When preuser enter username, password, re-enter password, email, re-enter email
      | userName | <userName> |
      | password | <password> |
      | email    | <email>    |
    And select the security type as "Security questions"
    And select security question1 as "What was your first phone number?"
    And select security answer1 as "number1"
    And select security question2 as "What is your best friend's name?"
    And select security answer2 as "name1"
    And select security question3 as "What is your favorite color?"
    And select security answer3 as "color1"
    And check the terms and click on create my ID button
    And user is navigated to Confirm email page
    And user should see a latest unread mail recieved in provided email address
    Then user should copy the confirm email url to browser
    And user after landing on sign in page get navigated to the go green splash page
      | userName | <userName> |
      | password | <password> |
    And Preffective user lands on the splash page & clicks on Save Prefrences
    And the Preffective member lands on the dashboard

    Examples: 
      | planType | memberType | copayCategory | firstname | lastname | dob        | memberid    | zipcode | userName      | password   | email                      | question1 | question2 | question3 |
      | PDP      | Individual | NON LIS       | LEDFORD       | MUZZY     | 11/05/1940 | 917036696-1  |   85080 | q1_feb_uhc042 | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |

  # | PDP     |  Individual  |  NON LIS      | FBDDE     | BCCDF           | 11/05/1948          | 018948860-1 | 01702	 |q1_feb_uhc042        | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
  # | SHIP    |  Individual  |  NON LIS      | EQNBXLQQ  | BNSXXZJU        | 02/01/1939          | 373488822-11| 89125	 |q2_jun_ship0084      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
  #  | Combo   |  Individual  |  NON LIS      | DCCB      | AEFAD           | 05/22/1927          | 014429204-11| 82009	 |q2_june_combo0015    | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
  #  | MA      |  Individual  |  NON LIS      | CBFAEB    | BFACA           | 01/12/1948          | 007652063-1 | 91803	 |q2_jun_aarp0039      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
  #| Medica  |  Individual  |  NON LIS      | CBCCA     | FECBC           | 01/01/1942          | 912020922-1 | 33125	 |q2_jun_sofl0005      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
  # | PCP     |  Individual  |  NON LIS      | ECCFF     | DBCAADBCAE      | 04/07/1952          | 965421538-1 | 33435	 |q2_jun_sofl0009      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
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

  @preEffective4 @fastandfurious @F296012 @May2_Release
  Scenario Outline: UID: <UID> - Member Type type: <memberType> Verify that correct Technical Support TFNs are displayed on Contact Us and Secondary Pages Need Help Section for pre-effective members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that preeffective message is displayed on the home page or test harness page
    #    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
    #        | Member Type | <memberType> |
    And user clicks on the benefits and coverage tab on the dashboard home page or test harness page
    #    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message and plan documents button are displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And user clicks on claims tab from Forms and Resources page
    And verify that subnavigation is supressed on the claims page
      | Member Type | <memberType> |
    And verify that correct preeffective message is displayed on claims page
    And verify that correct phone number is displayed in technical support section of claims page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on Claims Page
      | Member Type | <memberType> |
    #    And verify that payment tab is displayed to Preeffective member from secondary pages
    #      | Member Type   | <memberType>   |
    And user clicks on the Contact Us link in Need help Section of Claims Page
    And verity that correct phone number is displayed in Technical Support section of Contact Us Page
      | Technical TFN | <technicalTFN> |

    Examples: 
      | UID       | planType        | memberType            | copayCategory | technicalTFN   |
      | US1735715 | IndMA           | preeffectiveIndMA     | NON LIS       | 1-888-980-8125 |
      | US1735715 | IndMAPD         | preeffectiveIndMAPD   | NON LIS       | 1-888-980-8125 |
      | US1735715 | IndPDP          | preeffectiveIndPDP    | NON LIS       | 1-888-980-8125 |
      | US1735715 | GroupMA         | preeffectiveGroupMA   | NON LIS       | 1-888-980-8125 |
      | US1735715 | GroupMAPD       | preeffectiveGroupMAPD | NON LIS       | 1-888-980-8125 |
      | US1735715 | GroupSSUP       | preeffectiveGroupSSUP | NON LIS       | 1-888-980-8125 |
      | US1735715 | GroupPDP        | preeffectiveGroupPDP  | NON LIS       | 1-888-980-8125 |
      | US1737398 | SHIPPreffective | preeffectiveSHIPOnly  | NON LIS       | 1-866-254-3132 |
