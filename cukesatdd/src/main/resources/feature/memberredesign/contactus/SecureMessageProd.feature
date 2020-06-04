@contactUsPROD @CodeTranformer 
Feature: 1.16 Secure Messaging validation

#SecureMessageTestCase1
@SecureMessage1 @regressionMemberPROD12
Scenario Outline: TID: <TID> - Verify Secure Email Us Widget with Get Started button and cancel functionality 
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
	When the user navigates to contact us page in UHC site 
	Then prod user validates cancel click on secure email widget in redesign contact us page 
		| New Email        | <newEmail>        |
		| NewConfirm Email | <newConfirmEmail> |	
	Examples: 
	| UID     | username | password | member                | newEmail       | newConfirmEmail | phoneNumber |
	| 152201  | jkuma14  | Brock@02 | DBAR3322    | test@optum.com | test@optum.com  |  9999999999 |


#SecureMessageTestCase2
@SecureMessage2 @regressionMemberPROD
Scenario Outline: UID: <UID> - Verify Secure Email Us Message Page from contact us redesign page 
		Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
	When the user navigates to contact us page in UHC site 
	Then user click on send a message in the secure email widget in redesign contact us page 
	Then the user validates that the SSO secure message Page opens in a new window 
	Examples: 
	|   UID        | username | password | member         |
	|	 152202    | jkuma14  | Brock@02 | 2nancyreeves   |
	
	
#SecureMessageTestCase3
@SecureMessage3 @regressionMemberPROD
Scenario Outline: UID: <UID>  Verify Secure Email Us Message Page secondry pages via messengers link 
		Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
	When the user navigates to contact us page in UHC site  
	Then user click on account Profile dropdown and click the messages link 
	Then the user validates SSO secure message Page via messages link from secondry pages opens in a new window 
	Examples: 
	|  UID      | username | password | member        |
	| 152203  | jkuma14  | Brock@02 | 2nancyreeves   |
