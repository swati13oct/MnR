@theSpartans
Feature: S1.1 To test Member Auth Dashboard page.

  @memb
  Scenario Outline: To validate the error message for invalid user name and correct password or viseversa.
    Given the user is on member auth login page
    Then the member tries to login with invalid username and correct password and verify the error message
      | Username      | <username>     |
      | Password      | <password>     |
      | Error Message | <errormessage> |

    Examples: 
      | username  | password  | errormessage                                    |
      | qavgogine |           | Either your UserName or Password was incorrect. |
      | username  | qavgogine | Either your UserName or Password was incorrect. |

  Scenario Outline: To validate the contact us page through Member auth.
    Given the user is on member auth login page
      | Username | <username> |
      | Password | <password> |
    When I search for a member
      | Member | <member> |
    Then click on the member displayed in the search list
    And I will see the disclaimer text at top of the page
      | Disclaimer | <disclaimer> |
    And all SUBMIT buttons display message when clicked on contact us page
      | Message | <message> |

    Examples: 
      | username  | password  | member                               | disclaimer                                                                                                      | Message                          |
      | qavgogine | qavgogine | 4B152296-7C31-49C7-B49F-8739EB9A84A2 | You are viewing this site with member authorized read only access. Remember to LOGOUT at the end of the session | You are not authorized to submit |
      
      
      @regressionMemberAuth   
  Scenario Outline: To validate the error message for invalid user name and correct password or viseversa.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password 
   	  | Username | <username> |
      | Password | <password> |	
    And Member Enters the Username he wants to search
      | MemUsername   | <member> |
    And user clicks on member to select  
    Then the user click on EOB link and navigates to EOB page
    And the user slects the desired date range
  | Plan Type      |<planType>  |
  | Date Range     |<dateRange> |
  | EOB Type         |<eobType>   |
    Examples: 
      | username  | password  |member            |planType   | dateRange  | eobType 		 |
      | qavgogine | qavgogine |q2_jun_aarp0101	 | PDP       | 18 Months  |Prescription  |
 
 			@regressionMemberAuth     
  Scenario Outline: To validate save preference on profile and preference page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password 
   	  | Username | <username> |
      | Password | <password> |	
    And Member Enters the Username he wants to search
      | MemUsername   | <member> |
    And user clicks on member to select 
    Examples:
    | username  | password  |member            |  
    | qavgogine | qavgogine |q2_jun_uhc0008  	 |
