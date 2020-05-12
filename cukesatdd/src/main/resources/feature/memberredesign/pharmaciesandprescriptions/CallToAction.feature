Feature: MVP - Call to Action
  I am a user of the M&R Portal with Rx benefits I must have access to PnP notifications and call to action cards

  
  @CallToAction @F436319 @US2498888 @TestA
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R PnP page I must see PnP notifications when that option is turned on only on PnP page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When a PnP notification is activated
    Then I must see that message at the top of the PnP page
    When user navigate to any other page
    Then PnP notification will not be displayed on other pages
    When user navigates back to PnP page
    Then this message will only appear on the main PnP page

    Examples: 
      | FID     | planType | memberType             | expectLink |
      | F436319 | MAPD     | AARP_Individual_PnP_rx | yes        |

  @CallToAction @F436319 @US2498888
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R PnP page I must see PnP notifications on top of the page and when I close the notification shall persist until user log's out.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When a PnP notification is activated
    Then I must see that message at the top of the PnP page
    When I click the cross icon to close the notification
    Then it will remove the notification from the top of the PnP page
    And that removal will persist until member logs out

    Examples: 
      | FID     | planType | memberType             | expectLink |
      | F436319 | MAPD     | AARP_Individual_PnP_rx | yes        |

  
  @CallToAction @F436319 @US2498888
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R PnP page I must see image title and description for each call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user view Find and Price Call To Action
    Then user validates an image for Find and Price Call To Action
    Then user validates a title for Find and Price Call To Action
    Then user validates a description for Find and Price Call To Action
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    Then user view Refill Home Delivery Call To Action
    Then user validates an image for Refill Home Delivery Call To Action
    Then user validates a title for Refill Home Delivery Call To Action
    Then user validates a description for Refill Home Delivery Call To Action
    Then user view Whats New Call To Action
    Then user validates an image for Whats New Call To Action
    Then user validates a title for Whats New Call To Action
    Then user validates a description for Whats New Call To Action

    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Individual_PnP_rx | yes        |

 
  @CallToAction @F436319 @US2498888
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R PnP page I must see each Call to actions in sequence
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user validates the Find and Price text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Refill Home Delivery text content displayed third within that section
    Then user validates the Whats New text content displayed fourth within that section

    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Individual_PnP_rx | yes        |

  @CallToAction @F436319 @US2498888
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of the M&R PnP page I must see each Call to actions in sequence but do not see Home Delivery Call to Action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    Then user validates the Find and Price text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Refill Home Delivery text content DID NOT display third within that section
    Then user validates the Whats New text content displayed fourth within that section

    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Individual_PnP_rx | yes        |

 
  @CallToAction @F436319 @US2498904
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of M&R PnP with indiviual plan I must be redirected to DET (current version) when i click on Find and Price Call to Action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user clicks on Find and Price Call To Action
    Then I will be directed to the Drug Estimator Tool current state version

    Examples: 
      | FID     | planType | memberType             | expectLink |
      | F436319 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @CallToAction @F436319 @US2498904
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of M&R PnP with group plan I must be redirected to Optum Rx Drug pricing page when I click on Find and Price Call to Action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When user clicks on Find and Price Call To Action
    Then user navigates to Optum Rx Drug pricing Page using Single Sign On SSO on new tab
    
    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Group_PnP_rx | yes        |
 

  @CallToAction @F436319 @US2498904
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of M&R PnP page I must be redirected to Pharmcy Locator tool when I click on Pharmacy Locator call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user Navigates to Pharmacy Locator tool current state version
    
    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Individual_PnP_rx | yes        |

  @CallToAction @F436319 @US2498945
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of M&R PnP page  when I click on Refill Home Delivery Call to Action I must be redirected to OptumRx Medicine Cabinet on new tab.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When I click on the Refill Home Delivery call to action
    Then I will SSO to OptumRx Medicine Cabinet on new tab
    
    Examples: 
      | FID     | planType | memberType             | expectLink |
      | F436319 | MAPD     | AARP_Individual_PnP_rx | yes        |


  @CallToAction @F436319 @US2498865 @TestB
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify that I am a user of M&R PnP page  when I click on Whats new Call to Action I must be redirected to Whats new Page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Expect Link | <expectLink> |
    When a PnP notification is activated
    Then I must see that message at the top of the PnP page
    When user clicks on Whats New call to action
    Then user will be directed to the Whats New page
    Then user validates the header on Whats New Page

    Examples: 
      | FID    | planType | memberType             | expectLink |
      | 313410 | MAPD     | AARP_Individual_PnP_rx | yes        |
      