@theIncredibles
@member_redesign_footer
Feature:Footer for Member Site Redesign

@member_redesign_footer
Scenario Outline:As an authenticated member on the new Member site, I want to check Footer section.
Given I am a authenticated member on the member redesign site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I am on the member page then I should be able to see the footer sections 
And Member Support and links under it should be displayed
And Quick links and links under it should be displayed
And I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |