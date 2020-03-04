@hsid 
Feature: To test HSID registration flow

 
   @hsid1 @US968241 @hsidregistration 
   Scenario Outline:Verify HSID registration.
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
    #And the user deregister from M&R LDAP
       #| Username  | <userName>  |
    And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter first name, last name, date of birth, zip code, member id and click continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
   #And user is navigated to step two:create account page
   And enter username, password, re-enter password, email, re-enter email
      | userName   | <userName>   |
      | password   | <password>   |
      | email      | <email>   	|
   And select the security type as "Security questions"
   And select security question1 as "What was your first phone number?"
   And select security answer1 as "number1"
   And select security question2 as "What is your best friend's name?"
   And select security answer2 as "name1"
   And select security question3 as "What is your favorite color?"
  And select security answer3 as "color1"
  And check the terms and click on create my ID button
  And user is navigated to Confirm email page
  And user should see a latest unread mail recieved in provided email address
  Then user should copy the confirm email url to browser
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  And user should be at Sign In page
       | userName   | <userName>   |  
       | password   | <password>   |
  #Then user should see a latest unread mail recieved  in mail server
   Examples:
   | planType|  memberType  | copayCategory | firstname | lastname    |   dob 	         | memberid 	  | zipcode  | userName 	        | password   |   email	  			          | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS      | KIL   | GONZALIS        | 08/31/1950      | 016792516-1  | 11420	 | q1_feb_uhc04290       | Password@1 | codetransformertesting@gmail.com     | number1   | name1     | color1    |
   | PDP     |  Individual  |  NON LIS      | LAT   | HENKE           | 08/19/1992       | 018229742-1 | 51346	 | q3_sep_UAT4_AARP004        | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | SHIP    |  Individual  |  NON LIS      | STVTBQ  | WKYX         | 01/01/1941     | 321006300-11    | 07747	 | shipgogreen227      | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | Combo   |  Individual  |  NON LIS      | XAVIERA      | PIELOCH   | 08/15/1942     | 970507442-1 | 84158	 | q2_june_combo0015    | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | MA      |  Individual  |  NON LIS      | SHER    | SHUTTERS      | 06/24/1939    | 810387190-1    | 84310	 | q2_jun_aarp0039      | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | Medica  |  Individual  |  NON LIS      | THEADORE   | NIKOCEVIC  | 01/03/1942          | 912020922-1 | 33190	 | q2_jun_sofl0005 | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | PCP     |  Individual  |  NON LIS      | SIDNEY      | HULME      | 06/28/1952    | 971404385-1  | 33189	 | q3_Sep_UAT4_Sofl001      | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |
   | Termed<12 |  Individual |  NON LIS      | NICOLETTE      | HINT      | 08/19/1950 | 019743661-1  | 60454	 | q3_sep_UAT4_AARP266      | Password@1 | codetransformertesting@gmail.com      | number1   | name1     | color1    |


    	@hsid3 @validateStep1 @US968241 @hsidregistrationErrorMsg @hsidregistration
    Scenario Outline:Verify feilds in HSID registration Step 1 page.
    Given the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And I click on Continue button
    And I should see error message "You have 5 field(s) that need to be corrected"
    And I should see error message "First name is required" for first name
    And I should see error message "Last name is required" for last name
    And I should see error message "Date of birth is required" for date of birth
    And I should see error message "Zip code is required" for zip code
    And I should see error message "Plan Member ID number is required" for member id

Examples:
   | planType|  memberType    | copayCategory  | firstName | lastName        |   dob 	             | memberid 	  | zipcode  | userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS         | BBABFAD   | BEDD            | 09/17/1946            | 002238311-1    | 92024	 |AUTO_q2_apr_uhc100     | Password@1 | codetransformers@gmail.com     | number1   | name1     | color1    |
   
   	 @hsidregistrationErrorMsgForTerminatedMember @hsidregistration
    Scenario Outline:Verify Error messages in HSID registration page for terminated member
 	And the user is on medicare sign in page
    When the user clicks on Register now link
    And HSID registration page is displayed with all the fields
    And enter members first name, last name, date of birth, zip code, member id and click on continue
      | firstName   | <firstname>|
      | lastName    | <lastname> |
      | dob         | <dob>      |
      | memberid    | <memberid> |
      |zipcode 	    | <zipcode>  |
   And I should see error message "We're having trouble finding you in our records. Please check that your entries match the information on your health insurance ID card." for terminated member
   Examples:
    | planType|  memberType  | copayCategory | firstname | lastname        |   dob 	            | memberid 	  | zipcode  | userName 	        | password   |   email	  			          | question1 | question2 | question3 |
    | MAPD    |  Individual  |  NON LIS      | MAHMUDE   | GIALLORENZO     | 01/03/1974         | 000026695-1 | 84408	 |q2_jun_aarp0074       | Password@1 | codetransformertesting@gmail.com     | number1   | name1     | color1    |
   
    @hsid2 @AssistiveRegistration @US968323 
   Scenario Outline:Verify HSID assistive registration.
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
   And login with following details logins in the member portal and validate elements and route to assistive flow 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
   When the user validate username autofill
   And enter username, password, re-enter password, email, re-enter email
     | userName   | <userName>   |
     | password   | <password>   |
     | email      | <email>   	|
  And select the security type as "Security questions"
  And select security question1 as "What was your first phone number?"
  And select security answer1 as "number1"
  And select security question2 as "What is your best friend's name?"
  And select security answer2 as "name1"
  And select security question3 as "What is your favorite color?"
  And select security answer3 as "color1"
  And check the terms and click on create my ID button
  And user is navigated to Confirm email page
  And user should see a latest unread mail recieved in provided email address
  Then user should copy the confirm email url to browser
  And user should see the email confirmation message "Email confirmed: Please sign in with your new username and password." in Sign In form
  And user should be at Sign In page
  Then user should see a latest unread mail recieved  in mail server
   
    
   Examples:
 
   | planType|  memberType  | copayCategory  | userName 	         | password   |   email	  			           | question1 | question2 | question3 |
   | MAPD    |  Individual  |  NON LIS       |AUTO_q2_apr_uhc100   | Password@1 | codetransformers@gmail.com | number1   | name1     | color1    |
   
   
   @hsid6 @Login @US968315 @regressionMember
   Scenario Outline:Verify HSID login functionality.
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
   Then I validate that login is successfull     
      
   Examples:
   | planType|  memberType  | copayCategory | 
   | MAPD    |  Individual  |  NON LIS      |
   | PCP     |  Individual  |  NON LIS      |
   | Medica  |  Individual  |  NON LIS      |  
   | MAGroup |  Group       |  NON LIS      |
   | MAPDGroup | Group      |  NON LIS      | 
   | MA      |  Individual  |  NON LIS      |
   | PDP     |  Individual  |  NON LIS      |   
   | PDPGroup|  Group       |  NON LIS      |   
   | SHIP    |  ShipOnly    |  NON LIS      | 
   | COMBO   | FedShip      |  NON LIS      |
   | SSUPGroup |Group         |  NON LIS      |
   | MAPre-effective| Individual  |  NON LIS      |
   | GovtTermless | Individual  |  NON LIS      |
   

   
  @hsid4 @codetransformers
  Scenario Outline: To verify that iperception smiley survey is displayed on medicare.uhc.com signin pages
    Given User is on the sign-in page of medicare.uhc.com of the environment mentioned in config file
      | URL | <appendinURL> |
    Then Iperception smiley survey is displayed after waiting for 20 seconds
    And User is able to successfully submit the survey

    Examples: 
      | appendinURL |
      |             |
      | aarp        |
      | retiree     |

  @hsid5 @codetransformers
  Scenario Outline: To verify that iperception smiley survey is displayed on mymedicareaccount.uhc.com signin pages
    Given User is on the sign-in page of mymedicareaccount.uhc.com of the environment mentioned in config file
      | URL | <appendinURL> |
    Then Iperception smiley survey is displayed after waiting for 20 seconds
    And User is able to successfully submit the survey

    Examples: 
      | appendinURL |
      | pcp         |
      | medica      |
      
      
      