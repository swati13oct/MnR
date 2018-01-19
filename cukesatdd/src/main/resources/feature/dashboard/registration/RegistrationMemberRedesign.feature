Feature: To test registration flow in redesign portal
@Sanity_registrationRedesign
  Scenario Outline: To verify member with no additional plan is navigated to Create Account after clicking next button on Plan Information
    Given the member is on registration page of redesign portal
      | CREATE_ACCOUNT_USER_NAME        | <userName>        |
      | CREATE_ACCOUNT_PASSWORD         | <password>        |
      | CREATE_ACCOUNT_CONFIRM_PASSWORD | <confirmPassword> |
      | CREATE_ACCOUNT_EMAIL            | <email>           |
      | CREATE_ACCOUNT_CONFIRM_EMAIL    | <confirmEmail>    |
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
    Then Verify that correct information is displayed on Account Confirmation page
  	  | FIRST_NAME     					    | <firstname>        |
      | LAST_NAME    			        | <lastname>        |
	  |   CREATE_ACCOUNT_USER_NAME		| <userName> 		|
      | CREATE_ACCOUNT_EMAIL            | <email>           |
	  |	Date of birth 		 			| <dateOfBirth>		|
	And User successfully navigates to RallyDasboard page
    Examples: 
      #dev-c and team-h
      | planMemberId | dateOfBirth | 	       planname     					| userName       | password   | confirmPassword 	| email          		| confirmEmail   |
  	#  |    949291584 | 02-17-1952  | Preferred Choice Palm Beach (HMO)   		| Username@1 	 | Password@1 | Password@1 		| member@uhc.com 		| member@uhc.com |
	 |    961861481 | 09-22-1949  | UnitedHealthcare The Villages MedicareComplete 1 (HMO)   		| q1_feb_uhc185 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com 		| uhcmnrportals@gmail.com |
	 |    979920703 | 08-20-1931  | UnitedHealthcare Group Medicare Advantage (PPO)   		| GroupRetiree01 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com 		| uhcmnrportals@gmail.com |
	 |    960769855 | 06-20-1942  | AARP MedicareComplete Plan 3 (HMO)   		| q4_dec_aarp567 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com		| uhcmnrportals@gmail.com |


  Scenario Outline: To verify member is navigated to the registeration plan Information page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name is displayed
      | Plan name | <planname> |

    Examples: 
      | Plantype           | planMemberId | dateOfBirth | planname                                             |
    #team-h and dev-c
      | MAPD COSMOS     | 930096952    | 08-05-1950  | AARP MedicareComplete Choice (PPO)| AAEDBF DAADCDAFA |
     # | MAPD COSMOS        | 935442812    | 03-03-1952  | UnitedHealthcare MedicareComplete Plan 1 (HMO)       |
      #| MA NICE            | 001605069    | 09-06-1935  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      #| MA COSMOS          | 944089527    | 09-16-1945  | AARP MedicareComplete Essential (HMO)                |
      #| MAPD NICE          | 006916255    | 08-13-1931  | Sharp SecureHorizons Plan by UnitedHealthcare (HMO)  |
      # | PDP                | 0018651611   | 05-20-1935  | AARP MedicareRx Preferred (PDP)                      |
      #team-h and dev-c
      #| PCP                | 949291584    | 02-17-1952  | Preferred Choice Palm Beach (HMO)                    |
     # | MEDICA             | 954480470    | 03-01-1952  | Medica HealthCare Plans MedicareMax (HMO)            |
     # | SHIP/MED SUPP      | 365348555-11 | 03-01-1949  | AARP MEDICARE SUPPLEMENT PLAN                        |
     # | 50-64              | 375682722-11 | 03-01-1964  | AARP PERSONAL HEALTH INSURANCE COMPREHENSIVE PLAN    |
     # | SHIP MedSupp + PDP | 1011277011   | 05-13-1929  | AARP MedicareRx Saver Plus (PDP)                     |
     # | SHIP MedSupp + PDP | 101127701-11 | 05-13-1929  | AARP MEDICARE SUPPLEMENT PLAN                        |
     #team-h and dev-c
     # | SHIP 50-64 + MA    | 006880152    | 05-09-1934  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      #| SHIP 50-64 + MA    | 006880152-11 | 05-09-1934  | AARP GROUP HOSPITAL PLAN                             |
     # | SHIP 50-64 + MAPD  | 006969409    | 03-16-1953  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
     # | SHIP 50-64 + MAPD  | 006969409-11 | 03-16-1953  | AARP GROUP HOSPITAL PLAN                             |
     # | SHIP 50-64 + PDP   | 1012231271   | 10-28-1942  | AARP MedicareRx Preferred (PDP)                      |
      #| SHIP 50-64 + PDP   | 101223127-11 | 10-28-1942  | AARP GROUP HOSPITAL PLAN                             |
      #| Group MAPD NICE    | 007399823    | 05-18-1946  | UnitedHealthcare Group Medicare Advantage (HMO)      |
     # | Group MAPD COSMOS  | 927159089    | 06-21-1923  | UnitedHealthcare Group Medicare Advantage (PPO)      |
     # | Group MA COSMOS    | 968438341    | 01-04-1918  | UnitedHealthcare Group Medicare Advantage (PPO)      |
     # | Group MA NICE      | 004145183    | 01-20-1923  | UnitedHealthcare Group Medicare Advantage (HMO)      |
     # | Group SSUP         | 975499851    | 11-12-1930  | UnitedHealthcare Senior Supplement                   |
     # | Group SSRD         | 915897367    | 10-13-1946  | UnitedHealthcare Senior Supplement                   |
     # | Group PDP          | 0130686931   | 03-12-1948  | UnitedHealthcare MedicareRx for Groups (PDP)         |
