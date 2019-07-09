@smokeTest @MemberVBF
Feature: 1.03-VBF-MemRedesign-To test contact us page

  @smokeTest_contactusInd @rallyDashboard @testharness @vbfGate
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Federal member
    Given login with following details logins in the member portal and validate elements
       | Member Type | <memberType> |
       | Plan Type | <planType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click
     	| Phone Number | <phoneNumber> |
     Then user validates cancel click on secure email widget in redesign contact us page
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |

    Examples: 
      | memberType | planType | phoneNumber | newEmail       | newConfirmEmail |
      | UhcMapdIndContactUs | MAPD |9999999999|test@optum.com | test@optum.com  |

  @smokeTest_contactusGrp @rallyDashboard @testharness @vbfGate
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Group member
   Given login with following details logins in the member portal and validate elements
       | Member Type | <memberType> |
       | Plan Type | <planType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click
    	| Phone Number | <phoneNumber> |
    Then user validates cancel click on secure email widget in redesign contact us page
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |
    Examples: 
      | memberType       | planType |phoneNumber | newEmail       | newConfirmEmail |
      | GroupRetireeMapdContactUs |MAPD   |9999999999|test@optum.com | test@optum.com  |
