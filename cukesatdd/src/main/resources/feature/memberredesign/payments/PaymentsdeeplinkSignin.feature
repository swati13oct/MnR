@deeplinkSignin
Feature: To test member Signin from new and old payment's Deeplinks

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

  @regressionMember @paymentDeeplink @CodeTransformers
  Scenario Outline: Verify <UserType> Member lands on the payment page after signing in from payment overview.htlm deeplink.
    Given user login with payment Overview link
    And the payments deeplink page is displayed with all the fields
    And on payment deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the paymentDeeplink page

    Examples: 
    | UserType         | username | password   |
    | Federal          | premiumpayment007 | Password@1 |
    | Federal +Fedral  | preeffective_pdp_ssup_03 | Password@1 |
    | SHIP             | PaymentShipOct010 | Password@1 |
    | Combo            | augustcombo001 | Password@1 |

      
   @regressionMember @paymentDeeplink @CodeTransformers
  Scenario Outline: Verify <UserType> Member lands on the payment page after signing in from payments overview-new.html deeplink.
    Given Member login with payment Overview-new link
    And the payments deeplink page is displayed with all the fields
    And on payment deeplink page I enter the member details and click continue
      | User Name | <username> |
      | Password  | <password> |
    And user is navigated to the paymentDeeplink page

    Examples: 
    | UserType         | username                  | password   |
    | Federal          | premiumpayment007         | Password@1 |
    | Federal +Fedral  | preeffective_pdp_ssup_03  | Password@1 |
    
    
    
    
    
    
    
    
    