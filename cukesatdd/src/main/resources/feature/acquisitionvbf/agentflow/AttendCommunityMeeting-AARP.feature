@attendCommunity
@fixedTestCaseTest
Feature:1.13-VBF-Acq-To test attend community meeting flow in AARP site
@communityMeeting_AARP
Scenario Outline: Verify attend community meeting flow in AARP site
Given the user is on AARP medicare acquisition site landing page
Then the user navigates to request more help and information page in AARP site and validates

Examples:
	| placeholder | 
	| 75044       |
	