@registrationStepThreeErrormessages @Gladiators
Feature: To test the error messages on create account page in redesign portal

  Scenario Outline: To verify correct error message appears if username field is left blank or incorrectly on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for blank username field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
      | PDP      |    000022829  | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE |            | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      

  Scenario Outline: To verify correct error message appears if username field is filled incorrectly on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for incorrect username field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |      
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Us1@  | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |   930096952  | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | User@  | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | 13645@  | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
     # | PDP      |    829072104 | 09-03-1942  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | @1user  | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |    930096952 | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | user 12@  | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      
      
  #  Scenario Outline: To verify correct error message appears if username used is already existing one
   # Given the member is on registration page of new portal part of redesign
   # When the member enter the member ID into Member ID field
  #    | Plan Member ID | <planMemberId> |
  #  And member enter date of birth in the date of birth dropdown
   #   | Date of birth | <dateOfBirth> |
   # When member click Next
   # Then member will be navigated to registration plan information page
   # When member clicks on next button
   # Then The member land on create account enters the valid data to create account
    #  | CREATE_ACCOUNT_USER_NAME        | <userName>        |
    #  | CREATE_ACCOUNT_PASSWORD         | <password>        |
     # | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      #| CREATE_ACCOUNT_EMAIL            | <email>           |
      #| CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    #And click on confirm registration 
   # Then error message for username not unique appears

   # Examples: 
      #dev-c and team-h
    #  | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
    #  | PDP      |    829072104 | 09-03-1942  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE |  Username         | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
     
  Scenario Outline: To verify correct error message appears if password field is left blank on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for blank password field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Somya@01 |            |        Password@1         | member@uhc.com | member@uhc.com |

        Scenario Outline: To verify correct error message appears if password is entered in a wrong format
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for incorrect password field appears
    
    
    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | password   | userName   | confirmPassword | email          | confirmEmail   |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Us1@       | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |   930096952  | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | User@      | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | 13645@     | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |   930096952  | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | @1user     | Password@1 | Password@1      | member@uhc.com | member@uhc.com |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | user 12@   | Password@1 | Password@1      | member@uhc.com | member@uhc.com |

  
   Scenario Outline: To verify correct error message appears if confirm password field is left blank or entered incorrectly on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for confirm password field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Username@1 | Password@1 |                 | member@uhc.com | member@uhc.com |
      | PDP      |    930096952 | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Username@1 | Password@1 | Password        | member@uhc.com     | member@uhc.com |
  
   Scenario Outline: To verify correct error message appears if confirm password field is left blank or entered incorrectly on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for email field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email         | confirmEmail   |
      | PDP      |    000022829 | 06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Username@1 | Password@1 | Password@1      |               | member@uhc.com |
      | PDP      |    930096952 | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Username@1 | Password@1 | Password@1      | member@uhc    | member@uhc.com |
     
   Scenario Outline: To verify correct error message appears if confirm email field is left blank or entered incorrectly on create account page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    When member clicks on next button
    Then The member land on create account enters the valid data to create account
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
    And click on confirm registration 
    Then error message for confirm email field appears

    Examples: 
      #dev-c and team-h
      | Plantype | planMemberId | dateOfBirth | planname                                       | membername      | userName   | password   | confirmPassword | email          | confirmEmail   |
      | PDP      |    000022829 |06-13-1943    | UnitedHealthcare MedicareComplete Plan 1 (HMO) | DFADC BBCBEFCEE | Username@1 | Password@1 | Password@1      | member@uhc.com |                |
      | PDP      |    930096952 | 08-05-1950  | UnitedHealthcare MedicareComplete Plan 1 (HMO)     | DFADC BBCBEFCEE | Username@1 | Password@1 | Password@1      | member@uhc.com | member@uhc     |
