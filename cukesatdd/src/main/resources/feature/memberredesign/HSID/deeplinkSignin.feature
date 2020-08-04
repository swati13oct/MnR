@deeplinkSignin
Feature: To test member Signin from various Deeplinks

  @paymentDeeplink @CodeTransformers @deepLink @regressionMember @p1
  Scenario Outline: Verify Member lands on the payment page after signing in from payment deeplink.
    Given member lands on the payment deeplink page
    And the payments deeplink page is displayed with all the fields
    And on payment deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the paymentDeeplink page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @claimsDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the claims page after signing in from claims deeplink.
    Given member lands on the claims deeplink page
    And the calims deeplink page is displayed with all the fields
    And on claims deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the claimsDeeplink page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @eobDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the eob page after signing in from eob deeplink.
    Given member lands on the eob deeplink page
    And the eob deeplink page is displayed with all the fields
    And on eob deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the eobDeeplink page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @accountProfileDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the account Profile page after signing in from account profile deeplink.
    Given member lands on the accountProfile deeplink page
    And the accountProfile deeplink page is displayed with all the fields
    And on accountProfile deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the accountProfile deep link page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @coverageandBenefitsDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the coverageandBenefits page after signing in from coverageandBenefits deeplink.
    Given member lands on the coverageandBenefits deeplink page
    And the coverageandBenefits deeplink page is displayed with all the fields
    And on coverageandBenefits deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the coverageandBenefits deep link page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @healthwellnessDeepLink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given member lands on the healthwellness deeplink page
    And the healthwellness deeplink page is displayed with all the fields
    And on healthwellness deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the healthwellness deep link page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @myDocumentsDeepLink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given member lands on the myDocuments deeplink page
    And the myDocuments deeplink page is displayed with all the fields
    And on myDocuments deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the myDocuments deep link page

    Examples: 
      | username        | password   |
      | q2_jun_aarp0126 | Password@1 |

  @regressionMember @deepLink @F444247
  Scenario Outline: Verify that user is able to navigate to member pages from Ping Federate Test Harness Page for canopy
    Given User lands on the ping federate SSO test harness page
    And testharness page is displayed with all the fields
    And User enter details on ping federate test harness page
      | SAML_SUBJECT  | <samlsubject>   |
      | First Name    | <firstName>     |
      | Last Name     | <lastName>      |
      | DOB           | <dateOfBirth>   |
      | MBI           | <mbi>           |
      | APPLANDINGURLSTAGE | <applandingurlStage> |
      | APPLANDINGURLTEAHH | <applandingurlteamh> |
      | APPLANDINGURLOFFLINESTAGE | <applandingurlofflinestage> |
      | UHC_ID        | <uhcid>         |
    And user clicks on submit button on the Ping Federate Test Harness Page
    Then user should be navigated to below page of member portal
      | <navigatedPage> |

    Examples: 
      | samlsubject   | firstName | lastName | dateOfBirth | mbi         | applandingurlStage                                             			   | navigatedPage 	   | uhcid | applandingurlteamh | applandingurlofflinestage |
      | canopyhealth  | KASEEB 	  | GAULDEN  | 12071947	   | 2QM2NK2XP19 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/pharmacy          | pharmacy 		   |       |  |  |
      | canopyhealth  | KASEEB 	  | GAULDEN  | 12071947    | 2QM2NK2XP19 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/payments          | payment 		   |       |  |  |
      | canopyhealth  | KASEEB 	  | GAULDEN  | 12071947    | 2QM2NK2XP19 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/order-materials   | order-materials   |       |  |  |
      | canopyhealth  | KASEEB 	  | GAULDEN  | 12071947    | 2QM2NK2XP19 | https://stage-medicare.uhc.com/sso/inbound/canopy?target=/benefits-coverage | benefits-coverage |       |  |  |
      