
@velocityDashers
Feature: V1.1To This test scenario is to validate that ID card is accessible for all the members

  @regressionIDCards @regressionMember
  Scenario Outline: Verify the fields in ID card page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user clicks on View and Print Member ID cards link
    Then user validates Coverage Status as of Today
      | Coverage Status | <coverageStatus> |
    And validate the headers for Individual user
      | Medical Plan    | <medicalPlan>    |
      | Member Id       | <memberId>       |
      | Member Name     | <memberName>     |
      | Subscriber DOB  | <dob>            |
      | Coverage Start  | <covergaeStart>  |
      | Coverage Status | <coverageStatus> |
  # Added MAPD amd PDP user,  MA user was not provided  , also had to create a scenario for group user
    Examples: 
    | plantype  | memberType    | medicalPlan                                                    | memberId      | memberName       | dob                         | covergaeStart | coverageStatus |
    | PDP       | IDCardmember  | AARP MedicareRx Walgreens (PDP)                                | 0197340581    | Eabce Edecdb     | Subscriber - DOB 03/07/1953 | 04/01/18      | Active         |
    | MA        | IDCardmember  | AARP MedicareComplete Essential (HMO)                          | 949014883-00  | Adad Fafcdcf     | Subscriber - DOB 09/05/1947 | 01/01/18      | Active         |
	| MAPD      | IDCardmember  | UnitedHealthcare MedicareComplete Choice Plan 1 (Regional PPO) | 858720673-00  | Abcfda Adfa      | Subscriber - DOB 04/11/1934 | 01/01/18      | Active         | 
     
  @regressionIDCards_Group_User @regressionMember
  Scenario Outline: Verify the fields in ID card page for group user
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user clicks on View and Print Member ID cards link
    Then user validates Coverage Status as of Today
      | Coverage Status | <coverageStatus> |
    And validate the headers for Group User
      | Medical Plan    | <medicalPlan>    |
      | Member Id       | <memberId>       |
      | Member Name     | <memberName>     |
      | Subscriber DOB  | <dob>            |
      | Coverage Start  | <covergaeStart>  |
      | Coverage Status | <coverageStatus> |
 
    Examples: 
      | plantype | memberType       | medicalPlan                                      | memberId      | memberName       | dob                         | covergaeStart | coverageStatus |
      | MAPD     | IDCardmember_grp | UnitedHealthcare Group Medicare Advantage (PPO)  | 921325326-00  | Fcdafde Aafbcb   | Subscriber - DOB 01/24/1951 | 01/01/16      | Active         |
  
     