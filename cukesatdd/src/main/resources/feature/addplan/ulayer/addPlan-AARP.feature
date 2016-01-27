@addPlanTest
Feature: To test the addPlan flow in AARP site
Scenario Outline: Verify plans added with existing plans in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
When the user confirms the plan details in AARP site
And the user performs add no other plan in AARP site
And the user registers with following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
And the user navigates to homepage in AARP site
And the user navigates to myPlans in AARP site
And the user adds the plan with following details in AARP site
   | <newPlanMemberId> |
Then the user validates the plan names of both the plan added   

Examples:
| planMemberId | dateOfBirth | userName    | password    | confirmPassword | email              | confirmEmail       | newPlanMemberId   |
| 0018620421   | 10-31-1960  | q4combo_014 | Password@1  | Password@1      | SNZRBU86@BNXVD.EWN | SNZRBU86@BNXVD.EWN | 001862042-11|
#| 935608413-01 | 07-05-1935  | q4combo_001 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |935608413-11|
#| 0042899181 | 07-16-1940  | q4combo_015 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |004289918-11|
#| 001307636-01 | 07-17-1947  | q4combo_024 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |001307636-11|
#| 802256623-01 | 04-10-1939 | q4combo_033 | Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |802256623-11|
#| 802121442 | 05-28-1945 | q4combo_032| Password@1 | Password@1	 | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |802121442-1|