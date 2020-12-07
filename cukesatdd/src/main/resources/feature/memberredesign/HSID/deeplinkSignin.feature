@deeplinkSignin
Feature: To test member Signin from various Deeplinks

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

  @regressionMember @paymentDeeplink @CodeTransformers
  Scenario Outline: Verify Member lands on the payment page after signing in from payment deeplink.
    Given member lands on the payment deeplink page
    And the payments deeplink page is displayed with all the fields
    And on payment deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the paymentDeeplink page

    Examples: 
      | username              | password   |
      | q3_sept_UAT4_AARP_025 | Password@1 |

  @regressionMember @claimsDeeplink @CodeTransformers
  Scenario Outline: Verify Member lands on the claims page after signing in from claims deeplink.
    Given member lands on the claims deeplink page
    And the calims deeplink page is displayed with all the fields
    And on claims deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the claimsDeeplink page

    Examples: 
      | username   | password   |
      | q2_pay_002 | Password@1 |

  @regressionMember @eobDeeplink @CodeTransformers
  Scenario Outline: Verify Member lands on the eob page after signing in from eob deeplink.
    Given member lands on the eob deeplink page
    And the eob deeplink page is displayed with all the fields
    And on eob deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the eobDeeplink page

    Examples: 
      | username   | password   |
      | q2_pay_002 | Password@1 |

  @regressionMember @accountProfileDeeplink @CodeTransformers
  Scenario Outline: Verify Member lands on the account Profile page after signing in from account profile deeplink.
    Given member lands on the accountProfile deeplink page
    And the accountProfile deeplink page is displayed with all the fields
    And on accountProfile deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the accountProfile deep link page

    Examples: 
      | username   | password   |
      | q2_pay_002 | Password@1 |

  @regressionMember @coverageandBenefitsDeeplink @CodeTransformers
  Scenario Outline: Verify Member lands on the coverageandBenefits page after signing in from coverageandBenefits deeplink.
    Given member lands on the coverageandBenefits deeplink page
    And the coverageandBenefits deeplink page is displayed with all the fields
    And on coverageandBenefits deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the coverageandBenefits deep link page

    Examples: 
      | username		  | password   |
      | premiumpayment011 | Password@1 |

  @regressionMember @healthwellnessDeepLink @CodeTransformers
  Scenario Outline: Verify Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given member lands on the healthwellness deeplink page
    And the healthwellness deeplink page is displayed with all the fields
    And on healthwellness deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the healthwellness deep link page

    Examples: 
      | username              | password   |
      | q3_sept_UAT4_AARP_025 | Password@1 |

  @regressionMember @myDocumentsDeepLink @CodeTransformers
  Scenario Outline: Verify Member lands on the my documents page after signing in from my documents deeplink.
    Given member lands on the myDocuments deeplink page
    And the myDocuments deeplink page is displayed with all the fields
    And on myDocuments deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the myDocuments deep link page

    Examples: 
      | username   | password   |
      | q2_pay_002 | Password@1 |

  @regressionMember @deepLink @F444247
  Scenario Outline: Verify that user is able to navigate to member pages from Ping Federate Test Harness Page for canopy
    Given User lands on the ping federate SSO test harness page
    And testharness page is displayed with all the fields
    And User enter details on ping federate test harness page
      | SAML_SUBJECT              | <samlsubject>               |
      | First Name                | <firstName>                 |
      | Last Name                 | <lastName>                  |
      | DOB                       | <dateOfBirth>               |
      | MBI                       | <mbi>                       |
      | APPLANDINGURLSTAGE        | <applandingurlStage>        |
      | APPLANDINGURLTEAHH        | <applandingurlteamh>        |
      | APPLANDINGURLOFFLINESTAGE | <applandingurlofflinestage> |
      | UHC_ID                    | <uhcid>                     |
    And user clicks on submit button on the Ping Federate Test Harness Page
    Then user should be navigated to below page of member portal
      | <navigatedPage> |

    Examples: 
      | samlsubject  | firstName | lastName  | dateOfBirth | mbi         | applandingurlStage                                                          | navigatedPage     | uhcid | applandingurlteamh | applandingurlofflinestage |
      | canopyhealth | MARYBETH  | NEUBURGER | 05281938    | 2EE1V96VD04 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/pharmacy          | pharmacy          |       |                    |                           |
      | canopyhealth | MARYBETH  | NEUBURGER | 05281938    | 2EE1V96VD04 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/payments          | payment           |       |                    |                           |
      | canopyhealth | MARYBETH  | NEUBURGER | 05281938    | 2EE1V96VD04 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/order-materials   | order-materials   |       |                    |                           |
      | canopyhealth | MARYBETH  | NEUBURGER | 05281938    | 2EE1V96VD04 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/benefits-coverage | benefits-coverage |       |                    |                           |

  @regressionMember @codeWarriors @F477221
  Scenario Outline: Verify SHIP Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given I am an M&R SHIP member
    And the page is displayed with all the fields
    And I Sign on to the M&R Member Portal
      | User Name | <username> |
      | Password  | <password> |
    And I will land on the Talix page for At Your Best

    Examples: 
      | username    | password   |
      | q4_Ship_023 | Password@1 |

  @regressionMember @codeWarriors @F477221
  Scenario Outline: Verify members lands on the pharmacy page after signing in from pharmacy deeplink.
    Given member lands on the pharmacy deeplink page
      | <brand> |
    And the pharmacy deeplink login page is displayed with all the fields
    And on pharmacy deeplink login page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the pharmacy deep link page

    Examples: 
      | username            | password   | brand  |
      | q3_Sep_UAT4_Sofl073 | Password@1 | PCP    |
      | q3_Sep_UAT4_Sofl015 | Password@1 | Medica |
      | q2_apr_aarp0250     | Password@1 | AARP   |
      | mapdtest1           | Password@1 | UHC    |

  @regressionMember @codeWarriors @F477221
  Scenario Outline: Verify members lands on the virtual visit page after signing in from virtual visit deeplink.
    Given member lands on the virtual visit deeplink page
      | <brand> |
    And the virtual visit deeplink login page is displayed with all the fields
    And on virtual visit deeplink login page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the virtual visit deep link page

    Examples: 
      | username            | password   | brand  |
      | q3_Sep_UAT4_Sofl073 | Password@1 | PCP    |
      | q2_june_Medica_010  | Password@1 | Medica |
      | q2_apr_aarp0250     | Password@1 | AARP   |
      | mapdtest1           | Password@1 | UHC    |
      
        @regressionMember @codeWarriors @F392073
  Scenario Outline: Verify Member lands on the documents page after signing in from edelivery deeplink.
    Given member lands on the myDocuments edelivery deeplink page
    And the myDocuments edelivery deeplink page is displayed with all the fields
    And on myDocuments edelivery deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the myDocuments edelivery deep link page

    Examples: 
      | username            | password   |
      | q3_Sep_TexasPCD_015 | Password@1 |
      
  @regressionMember @codeWarriors @F513871
  Scenario Outline: Verify Member lands on the Talix page for the Dentegra Dental Discount article after signing in from dental vanity URL.
    Given member lands on dentegra dental deeplink page
    And the page is displayed with all the fields
    And I Sign on to the M&R Member Portal
      | User Name | <username> |
      | Password  | <password> |
    And I will land on the Talix page for the Dentegra Dental Discount article

    Examples: 
      | username    | password   |
      | q4_Ship_023 | Password@1 |