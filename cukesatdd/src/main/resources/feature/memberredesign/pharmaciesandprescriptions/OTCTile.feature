@F512668
Feature: P&P - OTC Tile
  As an M&R member on P&P page with the Solutran OTC benefit, I must see the OTC tile and be able to click on it to SSO to the authenticated Solutran site. 

  @F512668 @US2961053
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify image for OTC call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view OTC Call To Action
    And user validates an image for OTC Call To Action

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_OTC |

  @F512668 @US2961053
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify title for OTC call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view OTC Call To Action
    And user validates a title for OTC Call To Action

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_OTC |

  @F512668 @US2961053
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify description for OTC call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view ANOC Call To Action
    And user validates a description for OTC Call To Action

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_OTC |

  @F512668 @US2961053
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify HealthyBenefits Web Page Open in New Tab
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view ANOC Call To Action
    When user clicks on OTC CTA
    Then user will see the authenticated healthybenefits web page open in a new tab

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_OTC |

  @F512668 @US2961053
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OTC Tile not available for Group Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user wont see the OTC Tile

    Examples: 
      | FID     | planType | memberType                     |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_No_OTC |

  @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OTC Tile Functionality
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view OTC Call To Action
    And user validates an image for OTC Call To Action
    And user validates a title for OTC Call To Action
    And user validates a description for OTC Call To Action
    When user clicks on OTC CTA
    Then user will see the authenticated healthybenefits web page open in a new tab

    Examples: 
      | FID     | planType | memberType                  |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_OTC |
