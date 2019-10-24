@idCards @velocityDashers
Feature: 1.17 ID cards on Dashboard

 @idCards1 @regressionIDCards @regressionMember
  Scenario Outline: TID: <TID> -plan: <plantype> -memberType: <memberType> - Verify the fields in ID card page
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
      

    Examples: 
  | TID     | plantype  | memberType    | medicalPlan                                                        | memberId      | memberName      	 | dob                         | covergaeStart | coverageStatus |
  |  15110  | PDP       | IDCardmember  | AARP MedicareRx Preferred (PDP)                                    | 0031240691    | Syreeta Glowski   | Subscriber - DOB 06/26/1932 | 01/01/13      | Active         |
  |  15109  | MA        | IDCardmember  | UnitedHealthcare MedicareComplete Choice Essential (Regional PPO)  | 912634084-00  | Roger Muszar 	   | Subscriber - DOB 04/24/1935 | 06/01/19      | Active         |
  |	 15109  | MAPD      | IDCardmember  | UnitedHealthcare MedicareComplete Choice (PPO)                     | 908949511-00  | Kylene Pietzsch   | Subscriber - DOB 03/14/1948 | 01/01/19      | Active         | 
     
  @idCards2 @regressionIDCards_Group_User @regressionMember @tamzid
  Scenario Outline: TID: <TID> -plan: <plantype> -memberType: <memberType> - Verify the fields in ID card page for group user
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
    | TID   | plantype | memberType       | medicalPlan                                      | memberId      | memberName     | dob                         | covergaeStart | coverageStatus |
    | 15114 | MAPD     | IDCardmember_grp | UnitedHealthcare Group Medicare Advantage (PPO)  | 940456900-00  | Mufid Fellenbaum | Subscriber - DOB 05/20/1933 | 01/01/17      | Active         |
  
     