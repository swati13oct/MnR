Feature: MVP - Call to Action
  I am a user of the M&R Portal with Rx benefits I must have access to PnP notifications and call to action cards

  @CallToAction @F436319 @US2498888   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify PnP notifications displayed only on PnP page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page
    When user navigate to Pharmacy Locator page
    Then PnP notification will not be displayed on Pharmacy Locator page
    When user navigates back to PnP page
    Then PnP notification will only appear on the main PnP page

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498888   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify persist of PnP notifications until user log out
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page
    When user click the cross icon to close the notification
    Then the PnP notification will be removed from the PnP page
    And that removal will persist until member logs out

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498888   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify image, title and description for each call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    Then user view Order Prescription Call To Action
    Then user validates an image for Order Prescription Call To Action
    Then user validates a title for Order Prescription Call To Action
    Then user validates a description for Order Prescription Call To Action
    Then user view Drug Cost Summary To Action
    Then user validates an image for Drug Cost Summary Call To Action
    Then user validates a title for Drug Cost Summary Call To Action
    Then user validates a description for Drug Cost Summary Call To Action

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498888   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify position of each call to action tile on P&P page
  Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates the Drug Lookup text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Order Prescription text content displayed third within that section
    Then user validates the Drug Cost Summary text content displayed fourth within that section

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498888   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify position of each call to action tile on P&P page for SEIB User
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates the Drug Lookup text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Order Prescription text content DID NOT display third within that section
    Then user validates the Drug Cost Summary text content displayed third within that section

    Examples: 
      | FID     | planType | memberType       |
      | F436319 | MAPD     | AARP_SEIB_PnP_rx |

  @CallToAction @F479445 @US2752085   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify indidiviual user redirected to DET Rally page when click Drug Lookup Call to Action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F479445 @US2752085    
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify group user redirected to DET Rally page when click Drug Lookup Call to Action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally

    Examples: 
      | FID     | planType | memberType        |
      | F436319 | MAPD     | AARP_Group_PnP_rx |

  @CallToAction @F479445 @US2752083    
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user redirected to Choose a plan year page when click on Pharmacy Locator call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498945   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user redirected to OptumRx manage prescriptions page on new tab when click on Refill Home Delivery Call to Action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user click on the Order Prescription call to action
    Then user will SSO to OptumRx manage prescriptions page on new tab

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @CallToAction @F436319 @US2498865   
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify LIS (1-4 ) user dont see Drug Cost Summary call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user will NOT see the Drug Cost Summary call to action

    Examples: 
      | FID     | planType | memberType       |
      | F436319 | MAPD     | AARP_LIS1_PnP_rx |

  @CallToAction @F436319 @US2498865    
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify LIS 0 user see Drug Cost Summary call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user will see the Drug Cost Summary call to action

    Examples: 
      | FID     | planType | memberType       |
      | F436319 | MAPD     | AARP_LIS0_PnP_rx |

  @CallToAction @F436319 @US2498865  
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify LIS 0 user when click on Drug Cost Summary call to action will be redirected to OptumRx benefits information page on new tab
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user clicks on Drug Cost Summary call to action
    Then user will SSO to OptumRx benefits information page on new tab

    Examples: 
      | FID     | planType | memberType       |
      | F436319 | MAPD     | AARP_LIS0_PnP_rx |
