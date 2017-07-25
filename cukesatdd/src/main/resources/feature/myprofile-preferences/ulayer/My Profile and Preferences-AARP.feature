@profileandpreferences
Feature: To test My Profile & Preferences in AARP site

  Scenario Outline: To verify My Profile in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | <planType> |
    When the user view My Profile & Preferences in AARP Site
    Then the user validates my profile and preferences in AARP Site
    And the user navigates to My Preferences in AARP site
    Then the user validates displayed document name and delivery preferences for a plan in AARP site

    Examples: 
      | planType |

  ##	| PDP      |
  #	| MAPD     |
  #	| MA       |
  #	| MS       |
  #	| HIP      |
  Scenario Outline: To verify My Profile and edit profile in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | Plan Type | <plantype> |
    When the user view My Profile & Preferences in AARP Site
    Then the user edits and saves account profile information in AARP Site
      | Current password      | <currentpassword>     |
      | New password          | <newpassword>         |
      | Confirm password      | <confirmpassword>     |
      | New email address     | <newemailaddress>     |
      | Confirm email address | <confirmemailaddress> |
    And the user edits and saves plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | Daytime phone   | <daytimephone>   |
      | Evening phone   | <eveningphone>   |
    And the user edits and saves alternate address in plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | City            | <city>           |
      | State           | <state>          |
      | Zip Code        | <zipcode>        |
      | Country         | <country>        |
      | Start Date      | <startdate>      |
      | End Date        | <enddate>        |
    And the user edits and saves mailing address in plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | City            | <city>           |
      | State           | <state>          |
      | Zip Code        | <zipcode>        |
      | Country         | <country>        |
      | Start Date      | <startdate>      |
      | End Date        | <enddate>        |

    Examples: 
      | plantype | currentpassword | newpassword | confirmpassword | newemailaddress | confirmemailaddress | daytimephone | eveningphone | streetaddress | streetaddress2 | city | state | zipcode | country | startdate | enddate |

  #	| PDP      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MAPD     | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MA       | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MS       | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | HIP      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  Scenario Outline: To verify My Preferences in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | Plan Type | <plantype> |
    When the user view My Profile & Preferences in AARP Site
    And the user navigates to My Preferences in AARP Site
    Then the user validates displayed document name and delivery preferences for a plan in AARP Site
      | Document Name        |
      | Delivery Preferences |

    Examples: 
      | plantype |

  #	| PDP      |
  #	| MAPD     |
  #	| MA       |
  #       | MS       |
  #       | HIP      |
  Scenario Outline: To verify My Preferences and edit preferences in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | <planType> |
    When the user view My Profile & Preferences in AARP Site
    Then the user validates my profile and preferences in AARP Site
    And the user navigates to My Preferences in AARP Site
    And the user updates preferences by changing delivery preferences for corresponding document name in AARP Site
      | <documentname:preferences> |
    Then the user validates the updated preferences in AARP site

    Examples: 
      | planType | documentname:preferences                                                      |
      | PDP      | Annual Notice Of Changes Documents:Online,Annual Pharmacy Directory:U.S. Mail |

  #	| MAPD     | Prescription Drug Explanation of Benefits (EOB):Online				|
  #	| MA       | Claims-Online									|
  #       | MS       | Claims-Online									|
  #       | HIP      | Claims-Online									|
  ##- working examples
  
  #@@@@@@@@@@@@@@@@@@memberRedesignPage@@@@@@@@@@@@@@@@@@@@@
  
  @ValidatePlanNamemembernameID
  Scenario Outline: To verify Plan Name, Member name, Member ID section in AARP site
    Given registered AMP with following details for profile and preferences flow in AARP site
      | <planType> |
    Then the user navigate to Profile and Preference page
    Then the user validates the Plan Name, Member name, Member ID section in AARP site

       Examples: 
      | planType |
      | PDP     |