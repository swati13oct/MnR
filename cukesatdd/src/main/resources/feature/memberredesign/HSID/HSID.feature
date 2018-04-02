

Feature:To test HSID functionality on Medicare site

    @US968323
    Scenario Outline: Verify HSID login page
   
    Given the user connect to DB
    And the user select record from database
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from extreme scale
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr_portal
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user delete record from mbr
      | Firstname  | <firstname>  |
      | Lastname   | <lastname>   |
    And the user deregister from M&R LDAP
      | Username  | <username>  |
    And register with following details logins in the member portal and validate elements 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    And user deregisters from M&R
    When the user validate username autofill
    And the user enters password and confirm password field
    And the user enters email and confirm email field
    And the user clicks submit button
    When the user validate all fields on this page
    And  the user validate security questions option and user answer all security questions
      | Option  | <option>  |
      | Option1 | <option1> |
      | Option2 | <option2> |
      | Option3 | <option3> |
    And the user check checkboxes
    And the user clicks submit button
    
    
      Examples:
      
       | planType|  memberType  | copayCategory | option              | option1                          | option2                      | option3                          |firstname  | lastname  | username      |
       | MAPD    |  Individual  |  NON LIS      | Security questions  | What was your first phone number?| What is your favorite color? | What is your best friend's name? |EDEEB      | EAAFEF    | q1_feb_sfl035 |
       
       
   
   @CMDBConnect
    Scenario Outline: Verify DB Connection
    Given register with following details logins in the member portal and validate elements
    #Then user delete record from PDB
 