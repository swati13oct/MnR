@member_redesign
Feature:Header/Navigation for Member Site Redesign

@member_redesign_header_aarp
Scenario Outline:As an authenticated member on the new Member site, I want to check the L1 and L2 tabs and its navigation.
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop
And I view the global navigation
Then I should be able to see and use the Home tab
Then I should be able to see and use the Find Care & Costs tab
Then I should be able to see and use the Claims tab
And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation
And then click the Claims Summary tab and I should be directed to the Claims Summary Page
And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page
Then I should be able to see and use the Coverage & Benefits tab
And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation
And then click the Benefits Summary tab and I should be directed to the Benefits Summary Page
And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page
And then click the Order Materials tab and I should be directed to the Order Materials Page
#Then I should be able to see and use the Premium Payments tab
Then I should be able to see and use the help button
Then I should be able to see and use the Account/Profile dropdown and its options

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |