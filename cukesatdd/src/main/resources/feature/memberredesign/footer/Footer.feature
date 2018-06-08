@theIncredibles
@member_redesign_footer
Feature:I1.2Footer for Member Site Redesign

@member_redesign_footer @IncrediblesFooter
Scenario Outline: an authenticated member on the new Member site, I want to check Footer section.
 Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
Then the user navigates to payment history
Then the user navigates to the footer section
And the user validates the footer section

Examples:
 | planType  | memberType  |
 | MAPD      |IndividualFooter |