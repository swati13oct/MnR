@contactUsPROD @CodeTranformer 
Feature: 1.16 Member Contact us Page 


@contactUS1 @secureEmailWidgetCancel @regressionMemberPROD 
Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Widget section in contact us redesign page 
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
	When the user navigates to contact us page in UHC site 
	Then user should see Help With This Website and Help With Your Plan sections 
	Then user validates cancel click on secure email widget in redesign contact us page 
		| New Email        | <newEmail>        |
		| NewConfirm Email | <newConfirmEmail> |
		
	Examples: 
		| username | password | member                | newEmail       | newConfirmEmail | phoneNumber |
		| jkuma14  | Brock@02 | 2nancyreeves   | test@optum.com | test@optum.com  |  9999999999 |
	
@contactUS2 @SecureEmailSSOpage @regressionMember 
Scenario Outline: 
	UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Message Page from contact us redesign page 
	Given login with following details logins in the member portal and validate elements 
		| Plan Type   | <plantype>   |
		| Member Type | <memberType> |
	When the user navigates to contact us page in UHC site 
	Then user click on send a message in the secure email widget in redesign contact us page 
	Then the user validates that the SSO secure message Page opens in a new window 
	
	Examples: 
		| UID       | plantype | memberType    | newEmail       | newConfirmEmail |
		| US1742688 | MAPD     | 2nancyreeves  | test@optum.com | test@optum.com  |
		
@contactUS2 @SecureEmailSecondaryPage @regressionMember 
Scenario Outline: UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Message Page secondry pages via messengers link 
	Given login with following details logins in the member portal and validate elements 
		| Plan Type   | <plantype>   |
		| Member Type | <memberType> |
	When the user navigates to contact us page in UHC site 
	Then user click on account Profile dropdown and click the messages link 
	Then the user validates SSO secure message Page via messages link from secondry pages opens in a new window 
	
	Examples: 
		| UID       | plantype | memberType                          | newEmail       | newConfirmEmail |
		|	 152202   | MAPD     | Ind_ContactUs                       | test@optum.com | test@optum.com  |
		
	@contactUsPROD1 @secureEmailWidgetCancel @regressionMemberPROD 
	Scenario Outline: 
		TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Widget section in contact us redesign page 
		Given the user is on member auth login flow page 
		When the member is able to login with correct username and password 
			| Username | <username> |
			| Password | <password> |
		And Member Enters the Username he wants to search 
			| MemUsername | <member> |
		And user clicks on member to select 
		When the user navigates to contact us page in UHC site 
		Then user should see Help With This Website and Help With Your Plan sections 
		Then user validates cancel click on secure email widget in redesign contact us page 
			| New Email        | <newEmail>        |
			| NewConfirm Email | <newConfirmEmail> |
			
		Examples: 
			| username | password | member                | newEmail       | newConfirmEmail | phoneNumber |
			| jkuma14  | Brock@02 | skho@roadrunner.com   | test@optum.com | test@optum.com  |  9999999999 |
	@contactUs7 @regressionMember 
    Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page 
	Given login with following details logins in the member portal and validate elements 
		| Plan Type   | <plantype>   |
		| Member Type | <memberType> |
	When the user navigates to contact us page in UHC site 
	Then the user validates the labels and contact numebers on the page 
	Then user validates clickToCallButton display on contactUS redesign page 
	And user clicks on Request Confirmation Click 
		| Phone Number | <phoneNumber> |
	And UI should be replaced by a success confirmation display 
		| Format Phone Number | <formatPhoneNumber> |
		| Expected Message    | <expectedMessage>   |
		
			Examples: 
				| TID   | plantype | memberType  | phoneNumber | formatPhoneNumber | expectedMessage                                                                                                                                                      |
				| 152243 | PCP    | ContactUsPCP |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |
				| 15224 | MEDICA  | Individual_needHelp |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |
				
	@contactUs8 @validateLabelsonContactUsPage @regressionMember 
    Scenario Outline: 
	TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify View qquestion button and common questions on the contactUS redesign page 
	Given login with following details logins in the member portal and validate elements 
		| Plan Type   | <plantype>   |
		| Member Type | <memberType> |
	When the user navigates to contact us page in UHC site 
	And the user click on view questions button and validate the questions links 
		| Plan Type   | <plantype>   |
		
	Examples: 
		| TID     | plantype | memberType  | 
		| 152244 | PCP      | ContactUsPCP | 
		
		
		