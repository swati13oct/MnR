@hsid 
Feature:To Test member Sign in

 
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
   And user is navigated to step two:create account page
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
  Then user should see a latest unread mail recieved  in mail server
   
   Examples:
 
    | planType|  memberType  | copayCategory | firstname | lastname        |   dob 	            | memberid 	  | zipcode  | userName 	         | password   |   email	  			          | question1 | question2 | question3 |
    | MAPD    |  Individual  |  NON LIS      | AFAFBBF   | AECFEC          | 05/15/1950          | 954668573-1 | 78501	 |q1_feb_uhc042        | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | PDP     |  Individual  |  NON LIS      | FBDDE     | BCCDF           | 11/05/1948          | 018948860-1 | 01702	 |q1_feb_uhc042        | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | SHIP    |  Individual  |  NON LIS      | EQNBXLQQ  | BNSXXZJU        | 02/01/1939          | 373488822-11| 89125	 |q2_jun_ship0084      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | Combo   |  Individual  |  NON LIS      | DCCB      | AEFAD           | 05/22/1927          | 014429204-11| 82009	 |q2_june_combo0015    | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | MA      |  Individual  |  NON LIS      | CBFAEB    | BFACA           | 01/12/1948          | 007652063-1 | 91803	 |q2_jun_aarp0039      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | Medica  |  Individual  |  NON LIS      | CBCCA     | FECBC           | 01/01/1942          | 912020922-1 | 33125	 |q2_jun_sofl0005      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    | PCP     |  Individual  |  NON LIS      | ECCFF     | DBCAADBCAE      | 04/07/1952          | 965421538-1 | 33435	 |q2_jun_sofl0009      | Password@1 | codetransformers@gmail.com      | number1   | name1     | color1    |
    
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
   | MAGroup |  Individual  |  NON LIS      |
   | MAPDGroup|  Individual  |  NON LIS      | 
   | MA        |  Individual  |  NON LIS      |
   | PDP       |  Individual  |  NON LIS      |   
   | PDPGroup  |  Group       |  NON LIS      |   
   | SHIP      |  ShipOnly    |  NON LIS      | 
   | COMBO     | FedShip      |  NON LIS      |
   | SSUPGroup |Group         |  NON LIS      |
   | MAPre-effective       |  Individual  |  NON LIS      |
   | GovtTermless       |  Individual  |  NON LIS      |
   
		@hsid3 @validateStep1 @US968241
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
      
      
       @hsid7 @regressionMember @Login
  Scenario Outline: -memberType: <memberType> - Validate that member is successfully getting logged in to Rally Dashboard for memberType <memberType>
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in 
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
   Then member should navigate to Home pag  
   Then User should be able to validate Dashboard elemt    
 
 	@hsid7a
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | MAIndividualCOSMOS_ProfilePref  | name1      | color1   | number1     |
       | MAPDNICE_ProfilePref            | name1      | color1   | number1     |
       | MANICE_ProfilePref              | name1      | color1   | number1     |
       | MAPDCOSMOS_ProfilePref          | name1      | color1   | number1     |

 	@hsid7b
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | AARPPDP_ProfilePref             | name1      | color1   | number1     |
       | ACTIVEPCP_ProfilePref           | name1      | color1   | number1     |
       | ACTIVEMedica_ProfilePref        | name1      | color1   | number1     |
       | GROUPMA_ProfilePref             | name1      | color1   | number1     |

 	@hsid7c
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | GROUPMAPD_ProfilePref           | name1      | color1   | number1     |
       | GROUPDP_ProfilePref             | name1      | color1   | number1     |
       |  GROUPSSUP_ProfilePref          | name1      | color1   | number1     |
       |  GROUPDPSSUP_ProfilePref        | name1      | color1   | number1     |

 	@hsid7d
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       |  PREACTIVEGRP_ProfilePref       | name1      | color1   | number1     |
       | ACTIVEGOVTSHIPCOMBO_ProfilePref | name1      | color1   | number1     |
       |  MULTIGOVPRETERM_ProfilePref    | name1      | color1   | number1     |
       |  ACTIVEPRESHIP_ProfilePref      | name1      | color1   | number1     |

 	@hsid7e
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       |  ACTIVESHIP_ProfilePref         | name1      | color1   | number1     |
       |  PRESHIP_ProfilePref            | name1      | color1   | number1     |
       |ACTIVETERMFEDSHIPCOMBO_ProfilePref | name1    | color1   | number1     |
       |  MICROMULTIFEDSHIP_ProfilePref  | name1      | color1   | number1     |

 	@hsid7f
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | MULTIFEDACTIVE_ProfilePref      | name1      | color1   | number1     |         
       | FEDSHIPPREEFFECTIVE_ProfilePref | name1      | color1   | number1     |    
       |  MAPREFFECTIVE_ProfilePref      | name1      | color1   | number1     |
       |  MAPDPREFFECTIVE_ProfilePref    | name1      | color1   | number1     |

 	@hsid7g
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | PDPPREFFECTIVE_ProfilePref      | name1      | color1   | number1     |  
       | GRPMAPREFFECTIVE_ProfilePref    | name1      | color1   | number1     |  
       | GRPMAPDPREFFECTIVE_ProfilePref  | name1      | color1   | number1     |  
       |  SSUPPREFFECTIVE_ProfilePref    | name1      | color1   | number1     |  

 	@hsid7h
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       |  GRPPDPPREFFECTIVE_ProfilePref  | name1      | color1   | number1     |  
       |  GRPDPSSUP_ProfilePref          | name1      | color1   | number1     |  
  
