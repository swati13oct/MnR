@registrationAdditionalInfoErrors
Feature: To test additional information section in dashboard registration flow

  Scenario Outline: To verify member is navigated to plan info in registration Additional Information Section using valid Zip/First/Last name
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name is displayed
      | Plan name | <planname> |
    And correct member ID value is displayed
      | Plan Member ID | <planMemberId> |
    And correct Member name value is displayed
      | Member name | <membername> |
    And correct Member date of birth value is displayed
      | Date of birth | <dateOfBirth> |
    And Previous button is displayed
    And Next button is displayed

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName | planname                           | membername   |
      | 920748371-00 | 03-02-1940  |   03855 | AABE      | BEAAEEF  | AARP MedicareComplete Plan 3 (HMO) | AABE BEAAEEF |
  #|    008666811 | 02-22-1951  |   95380 | BCDBC     | DBDE     |          |
  # |   0186083571 | 05-27-1951  |   24524 | CDABDAF   | FFACFEFC |          |


    Scenario Outline: To verify member is navigated to plan info in registration Additional Information Section using Medicare number
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter Medicare id in additional information
      | Medicare Id | <medicareID> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name is displayed
      | Plan name | <planname> |
    And correct member ID value is displayed
      | Plan Member ID | <planMemberId> |
    And correct Member name value is displayed
      | Member name | <membername> |
    And correct Member date of birth value is displayed
      | Date of birth | <dateOfBirth> |
    And Previous button is displayed
    And Next button is displayed

    Examples: 
      | planMemberId | dateOfBirth | medicareID | planname                           | membername   |
      | 920748371-00 | 03-02-1940  | 007384412B | AARP MedicareComplete Plan 3 (HMO) | AABE BEAAEEF |
     # |    008666811 | 02-22-1951  | 565880668A |                                    |
     # |   0186083571 | 05-27-1951  | 213564180A |                                    |  



Scenario Outline: To verify error message is displayed if incorrect Medicare ID is passed in registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter Medicare id in additional information
      | Medicare Id | <medicareID> |
    When member click Next
    Then member will get error message for incorrect Medicare id
    

    Examples: 
      | planMemberId | dateOfBirth | medicareID |
      |    920748371 | 03-02-1940  |      03855 |
      |    008666811 | 02-22-1951  |      95380 |
      |   0186083571 | 05-27-1951  |      24524 |


  Scenario Outline: To verify error message is displayed if incorrect Zip/First/Last name is passed in registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for incorrect Zip/First/Last name
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |   03854 | AABEC     | BEAAEEFG |
     # |    008666811 | 02-22-1951  |   95381 | BCDB     | DBDEC     |
     # |   0186083571 | 05-27-1951  |   24523 | CDABDF   | FFACFEAFC |

      Scenario Outline: To verify error message is displayed if first name is left blank on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |   03855 |           | BEAAEEF  |
     # |    008666811 | 02-22-1951  |   95380 |           | DBDE     |
     # |   0186083571 | 05-27-1951  |   24524 |           | FFACFEFC |
     
     
       Scenario Outline: To verify error message is displayed if last name is left blank on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |   03855 | AABE      |          |
      #|    008666811 | 02-22-1951  |   95380 | BCDBC     |          |
      #|   0186083571 | 05-27-1951  |   24524 | CDABDAF   |          |
     
  Scenario Outline: To verify error message is displayed if zip code is left blank on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
   

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |         | AABE      | BEAAEEF  |
      #|    008666811 | 02-22-1951  |         | BCDBC     | DBDE     |
      #|   0186083571 | 05-27-1951  |         | CDABDAF   | FFACFEFC |
     
  Scenario Outline: To verify error message is displayed if only zip code is entered on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |   03855 |           |          |
      |    008666811 | 02-22-1951  |   95380 |           |          |
      |   0186083571 | 05-27-1951  |   24524 |           |          |

  Scenario Outline: To verify error message is displayed if only first name is entered on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |         | AABE      |          |
      |    008666811 | 02-22-1951  |         | BCDBC     |          |
      |   0186083571 | 05-27-1951  |         | CDABDAF   |          |

  Scenario Outline: To verify error message is displayed if only last name is entered on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |         |           | BEAAEEF  |
      |    008666811 | 02-22-1951  |         |           | DBDE     |
      |   0186083571 | 05-27-1951  |         |           | FFACFEFC |

  Scenario Outline: To verify error message is displayed if all fields are left blank on registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
    When member click Next
    Then member will get error message for all required field needed
    

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      |    920748371 | 03-02-1940  |         |           |          |
      |    008666811 | 02-22-1951  |         |           |          |
      |   0186083571 | 05-27-1951  |         |           |          |

