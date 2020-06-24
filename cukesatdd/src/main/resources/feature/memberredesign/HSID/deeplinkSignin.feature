@deeplinkSignin
Feature: To test member Signin from various Deeplinks

  @paymentDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the payment page after signing in from payment deeplink.
    Given member lands on the payment deeplink page
    And the payments deeplink page is displayed with all the fields
    And on payment deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the paymentDeeplink page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

  @claimsDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the claims page after signing in from claims deeplink.
    Given member lands on the claims deeplink page
    And the calims deeplink page is displayed with all the fields
    And on claims deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the claimsDeeplink page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

  @eobDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the eob page after signing in from eob deeplink.
    Given member lands on the eob deeplink page
    And the eob deeplink page is displayed with all the fields
    And on eob deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the eobDeeplink page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

  @accountProfileDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the account Profile page after signing in from account profile deeplink.
    Given member lands on the accountProfile deeplink page
    And the accountProfile deeplink page is displayed with all the fields
    And on accountProfile deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the accountProfile deep link page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

  @coverageandBenefitsDeeplink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the coverageandBenefits page after signing in from coverageandBenefits deeplink.
    Given member lands on the coverageandBenefits deeplink page
    And the coverageandBenefits deeplink page is displayed with all the fields
    And on coverageandBenefits deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the coverageandBenefits deep link page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

  @healthwellnessDeepLink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given member lands on the healthwellness deeplink page
    And the healthwellness deeplink page is displayed with all the fields
    And on healthwellness deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the healthwellness deep link page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |

       @myDocumentsDeepLink @CodeTransformers @deepLink @regressionMember
  Scenario Outline: Verify Member lands on the healthwellness page after signing in from healthwellness deeplink.
    Given member lands on the myDocuments deeplink page
    And the myDocuments deeplink page is displayed with all the fields
    And on myDocuments deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the myDocuments deep link page

    Examples: 
      | username            | password   |
      | q3_sep_UAT4_AARP008 | Password@1 |
      
   