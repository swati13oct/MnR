@NewSignInPage
Feature: To validate the new changes related to new SignIn page  on the member redesigned site
@signInErrorMessages1 
  Scenario Outline: To Verify Error Messages In Both username and password fields
  Given I am a  member on the sign-in page
  | URL | <url> |
When I have not entred any thing in both username and password fields
Then I should get the error message on both fields 
 Examples:
 |url                                                                                  |
 |https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/guest/signin.html  |  
 |https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/guest/signin.html|
 |https://www.team-b-mypcpmedicare.uhc.com/content/dashboard/guest/signin.html|
@signInErrorMessages2
 Scenario Outline: To Verify Error Messages In username field 
  Given I am a  member on the sign-in page
  | URL | <url> |
When I have not entred any thing in  username  field
Then I should get the error message on username field 
 Examples:
 |url                                                                                  |
 |https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/guest/signin.html  | 
 |https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/guest/signin.html|
 |https://www.team-b-mypcpmedicare.uhc.com/content/dashboard/guest/signin.html|
@signInErrorMessages3
 Scenario Outline: To Verify Error Messages In password field 
 Given I am a  member on the sign-in page
  | URL | <url> |
When I have not entred any thing in password field 
Then I should get the error message on password field 
 Examples:
 |url                                                                                  |
 |https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/guest/signin.html  | 
 |https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/guest/signin.html|
 |https://www.team-b-mypcpmedicare.uhc.com/content/dashboard/guest/signin.html|

 
@forgotusernamepasswordlink
 Scenario Outline: To verify that password assistance page is opened on clicking the forgot your username and password link on signin page 
 Given I am a  member on the sign-in page
  | URL | <url> |
When I click on the forgot your username and password link on signin page 
Then I should be taken to Username and Password Assistance page
And siteID should be passed to the URL of Username and Password Assistance page
| SiteID | <siteID> |
 Examples:
 |url                                                                                   | siteID |
 |https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/guest/signin.html   | AARP   |
 |https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/guest/signin.html|UHCM   |
 |https://www.team-b-mypcpmedicare.uhc.com/content/dashboard/guest/signin.html          |MYPCP|


@registerbutton
 Scenario Outline: To Verify The New Memebr  Registration Page
  Given I am a  member on the sign-in page
  | URL | <url> |
  When the user click on registration page 
  Then I should be taken to the new Registration page 
  And I should see the SiteID that i have passed on the New Registration page
  | RegSiteID | <regsiteID> | 
   Examples:
 |url                                                                                   | regsiteID |
 |https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/guest/signin.html   |     AARP  |
 |https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/guest/signin.html|     UHCM  |
 |https://www.team-b-mypcpmedicare.uhc.com/content/dashboard/guest/signin.html          |     MYPCP |
 
 