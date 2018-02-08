@addPlan
Feature: To test the addPlan flow in AARP site
Scenario Outline: Verify plans added with existing plans in AARP site
Given the user is on the AARP medicare site registration page
When the user registers in AARP site with following details
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in AARP site
When the user confirms the plan details in AARP site
And the user performs add no other plan in AARP site
And the user registers with following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in AARP site
When the user navigates to homepage in AARP site
Then the user validates account home page in AARP site
When the user navigates to myPlans in AARP site
#Then the user validates plan summary page in AARP site
And the user adds the plan with following details in AARP site
   | <newPlanMemberId> |
Then the user validates the plan names of both the plan added   

Examples:
| planMemberId | dateOfBirth | userName     | password    | confirmPassword | email                   | confirmEmail            | newPlanMemberId   |
| 1011277011   | 05-13-1929  | apr_combo001 | Password@1  | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | 101127701-11      |
#| 935608413-01 | 07-05-1935  | q4combo_001 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |935608413-11|
#| 0042899181 | 07-16-1940  | q4combo_015 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |004289918-11|
#| 001307636-01 | 07-17-1947  | q4combo_024 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |001307636-11|
#| 802256623-01 | 04-10-1939 | q4combo_033 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |802256623-11|
#| 802121442 | 05-28-1945 | q4combo_032| Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |802121442-1|