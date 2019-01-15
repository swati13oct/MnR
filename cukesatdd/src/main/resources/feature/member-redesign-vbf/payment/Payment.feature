@smokeTest @MemberVBF
Feature: 1.11-VBF-MemRedesign-To test the payment history (GATED)

  @smokeTest_Payment @rallyDashboard @testharness
  Scenario Outline: Validate that member view Payment history table
    Given I am a authenticated member on the member redesign site for Direct Login
     | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates Premium Payment from Rally Dashboard Page
    And User validates Premium Payment table
   # And the user navigates to One Time Payments page
    #And the user enters details and click on continue button on One Time Payments Page for Dashboard
    
    Examples: 
      | memberType    | friendname | favcolor | phonenumber |

     # | AARPIndMAPDPayments | name1      | color1   | number1     |
      #| GroupRetireePayment      |name1      | color1   | number1     |
			| UhcIndMAPDPayments      |name1      | color1   | number1     |
