@smokeTest
Feature: 1.06-To test Header Navigation functionality
@smokeTest_Header
Scenario Outline:Validate that member can check the L1 and L2 tabs and its navigation.
Given I am a authenticated member on the member redesign site for Header
| Member Type	  | <memberType> |
When the above plantype user logs in member redesign for Header
Then I should be able to see and use the Find Care & Costs tab
Then I should be able to see and use the Home tab
Then I should be able to see and use the Claims tab
And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation
And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page
Then I should be able to see and use the Coverage & Benefits tab
And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation
And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page
And then click the Order Materials tab and I should be directed to the Order Materials Page
Then upon clicking the Premium Payments tab I should navigate to the Premium Payments Overview Page
Then I should be able to see and use the help button
Then I should be able to see and use the Account/Profile dropdown and its options
Then I should be able to see and use Health and Wellness page
#And I am on the member page then I should be able to see the footer sections 
And Member Support and links under it should be displayed
And Quick links and links under it should be displayed
And I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links

Examples:
|   memberType  	   |
|  UhcMapdInd |
|  AARPMapdInd |
|  GroupRetireePayment |

 
 