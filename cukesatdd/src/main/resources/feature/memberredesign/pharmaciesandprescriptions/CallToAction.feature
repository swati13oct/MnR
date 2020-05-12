
Feature: Call To Action


  @CallToAction @F436319 @US2498888 @TestA
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R P&P page I must see P&P notifications when that option is turned on only on P&P page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When a P&P notification is activated
    Then I must see that message at the top of the P&P page
    When user navigate to any other page
    Then P&P notification will not be displayed on other pages
    When user navigates back to P&P page
    Then this message will only appear on the main P&P page

    Examples: 
      | FID     | planType | memberType             | expectLink |
      | F436319 | MAPD     | AARP_Individual_PnP_rx | yes        |

