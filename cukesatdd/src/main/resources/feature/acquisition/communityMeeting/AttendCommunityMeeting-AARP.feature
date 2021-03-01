@BAT_CommunityMeetings @attendCommunity @fixedTestCaseTest
Feature:1.14-VBF-Acq-To test attend community meeting flow in AARP site (GATED)
@communityMeeting_AARP
Scenario Outline: Verify attend community meeting flow in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information page in AARP site and validates
Then the user navigates to community meeting page on AARP site and validates
Examples:
| placeholder | 
| none      |