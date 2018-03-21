@smokeTest
Feature: 1.15-VBF-MemRedesign-To test registration flow
@smokeTest_registrationRedesign @rallyDashboard @testharness
  Scenario Outline: Verify member with no additional plan is successfully registered and navigate to Home page
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
      | planMemberId | dateOfBirth | 	       planname     					| userName       | password   | confirmPassword 	| email          		| confirmEmail   |
  	#  |    949291584 | 02-17-1952  | Preferred Choice Palm Beach (HMO)   		| Username@1 	 | Password@1 | Password@1 		| member@uhc.com 		| member@uhc.com |
	 |    961861481 | 09-22-1949  | UnitedHealthcare The Villages MedicareComplete 1 (HMO)   		| q1_feb_uhc185 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com 		| uhcmnrportals@gmail.com |
	# |    979920703 | 08-20-1931  | UnitedHealthcare Group Medicare Advantage (PPO)   		| GroupRetiree01 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com 		| uhcmnrportals@gmail.com |
	# |    960769855 | 06-20-1942  | AARP MedicareComplete Plan 3 (HMO)   		| q1_aarp_feb566 	 | Password@1 | Password@1 		| uhcmnrportals@gmail.com		| uhcmnrportals@gmail.com |
