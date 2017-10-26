@stepOneMemberErrorPage

Feature: To validate member errors on the registration page


Scenario Outline: To verify registration member id required field error message
Given the member is on registration page of new portal part of redesign
And member enter date of birth in the date of birth dropdown
| Date of birth | <dateOfBirth> |
When member click Next
Then the member validate member id required error message
    
Examples:
| dateOfBirth |
#team-h and dev-c    
| 12-12-1920  |
    
    
Scenario Outline: To verify registration dob required field error message
Given the member is on registration page of new portal part of redesign
When the member enter the member ID into Member ID field
| Plan Member ID | <planMemberId> |
When member click Next
Then the member validate dob required error message
    
Examples:
| planMemberId |
#team-h and dev-c    
| 897948810    |
    
    
   
Scenario Outline: To verify registration dob fields 13 years or younger error message
Given the member is on registration page of new portal part of redesign
When the member enter the member ID into Member ID field
| Plan Member ID | <planMemberId> |
And member enter date of birth in the date of birth dropdown
| Date of birth | <dateOfBirth> |
When member click Next
Then the member validate dob fields 13 years or younger error message
    
Examples: 
| planMemberId | dateOfBirth |
#team-h and dev-c
| 897948810    | 12-12-2016  |
      
Scenario Outline: To verify registration snp error message
Given the member is on registration page of new portal part of redesign
When the member enter the member ID into Member ID field
| Plan Member ID | <planMemberId> |
And member enter date of birth in the date of birth dropdown
| Date of birth | <dateOfBirth> |
When member click Next
Then the member validate snp error message

Examples: 
| planMemberId | dateOfBirth |
#team-h and dev-c
| 910454755    | 12-31-1957  |
