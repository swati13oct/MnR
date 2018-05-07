@theIncredibles
@member_redesign_footer
Feature:I1.2Footer for Member Site Redesign

@member_redesign_footer @IncrediblesFooter
Scenario Outline:As an authenticated member on the new Member site, I want to check Footer section.
Given I am a authenticated member on the member redesign site Footer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop Footer
And I am on the member page then I should be able to see the footer sections Footer
And Member Support and links under it should be displayed Footer
And Quick links and links under it should be displayed Footer
And I have access to the Rally Provider Search Tool and I see the Saved option under Quick Links Footer

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |