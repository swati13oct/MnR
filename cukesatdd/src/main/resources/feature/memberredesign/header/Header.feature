@theIncredibles
@member_redesign
Feature:Header/Navigation for Member Site Redesign

@member_redesign_header @IncrediblesHeader
Scenario Outline:As an authenticated member on the new Member site, I want to check the L1 and L2 tabs and its navigation.
Given I am a authenticated member on the member redesign site Header
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop Header
And I view the global navigation Header
Then I should be able to see and use the Home tab Header
Then I should be able to see and use the Find Care & Costs tab Header
Then I should be able to see and use the Claims tab Header
And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
And then click the Claims Summary tab and I should be directed to the Claims Summary Page Header
And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
Then I should be able to see and use the Coverage & Benefits tab Header
And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header
And then click the Benefits Summary tab and I should be directed to the Benefits Summary Page Header
And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header
And then click the Order Materials tab and I should be directed to the Order Materials Page Header
#Then I should be able to see and use the Premium Payments tab Header
Then I should be able to see and use the help button Header
Then I should be able to see and use the Account/Profile dropdown and its options Header

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |

 
 