@regression_06_06_18 
@velocityDashers
Feature: V1.1To This test scenario is to validate that ID card is accessible for all the members

  @regressionIDCards
  Scenario Outline: Verify the fields in ID card page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user clicks on View and Print Member ID cards link
    Then user validates Coverage Status as of Today
      | Coverage Status | <coverageStatus> |
    And validate the headers
      | Medical Plan    | <medicalPlan>    |
      | Member Id       | <memberId>       |
      | Member Name     | <memberName>     |
      | Scubscriber DOB | <dob>            |
      | Coverage Start  | <covergaeStart>  |
      | Coverage Status | <coverageStatus> |

    Examples: 
      | plantype | memberType   | medicalPlan                                                    | memberId     | memberName       | dob                         | covergaeStart | coverageStatus |
      | MAPD     | IDCardmember | UnitedHealthcare MedicareComplete Choice Plan 1 (Regional PPO) | 858720673-00 | Abcfda Adfa | Subscriber - DOB 04/11/1934 | 01/01/18      | Active         |
      | PDP      | IDCardmember | AARP MedicareRx Preferred (PDP)                                |   0019185151 | Fdcfd Cbfddec    | Subscriber - DOB 10/11/1934 | 01/01/06      | Active         |
      | MA       | IDCardmember | AARP MedicareComplete Essential (HMO)               			 |  949014883-00 | Adad Fafcdcf  | Subscriber - DOB 09/05/1947 | 01/01/18      | Active         |
