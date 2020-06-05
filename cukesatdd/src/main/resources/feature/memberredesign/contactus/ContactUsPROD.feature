@contactUsPROD @CodeTranformer 
Feature: 1.16 Prod Member Contact us Page 

#TestCase1
@regressionMemberPROD
Scenario Outline: TID: <TID> -Plan Type: <plantype> Verify labels and telephone numbers on contactUs page 
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then On contactUs page the user should see Help With This Website and Help With Your Plan sections
    | PlanType | <planType> |
    Examples:   
    | UID        | username | password | member            | planType |
	| TestCase1  | jkuma14  | Brock@02 | LMHOCHSCHILD11    |	MAPD  |
	
	  