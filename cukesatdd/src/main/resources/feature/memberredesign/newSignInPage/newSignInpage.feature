@theSpartans
Feature: To validate the new changes related to new SignIn page  on the member redesigned site
@signInErrorMessages1 
  Scenario Outline: To Verify Error Messages In Both username and password fields
  Given I am a  member on the sign-in page
   When I have not entred any thing in both username and password fields
Then I should get the error message on both fields 

 Examples:
 |url                                                                                  |
 |https://stage-medicare.uhc.com/  | 
 |https://stage-medicare.uhc.com/|
 |https://stage-mymedicareaccount.uhc.com/medica|
 
 
 
@signInErrorMessages2
 Scenario Outline: To Verify Error Messages In username field 
  Given I am a  member on the sign-in page
  | URL | <url> |
When I have not entred any thing in  username  field
Then I should get the error message on username field 
 Examples:
  |url                                                                                  |
 |https://stage-medicare.uhc.com/  | 
 |https://stage-medicare.uhc.com/|
 |https://stage-mymedicareaccount.uhc.com/medica|
 
 
@signInErrorMessages3
 Scenario Outline: To Verify Error Messages In password field 
 Given I am a  member on the sign-in page
  | URL | <url> |
When I have not entred any thing in password field 
Then I should get the error message on password field 
 Examples:
 |url                                                                                  |
 |https://stage-medicare.uhc.com/  | 
 |https://stage-medicare.uhc.com/|
 |https://stage-mymedicareaccount.uhc.com/medica|

 
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
 |https://stage-medicare.uhc.com/                                                       | AARP   |
 |https://stage-medicare.uhc.com/                                                       | UHCM   |
 |https://stage-mymedicareaccount.uhc.com/medica                                        |MYPCP   |


@registerbutton
 Scenario Outline: To Verify The New Memebr  Registration Page
  Given I am a  member on the sign-in page
  | URL | <url> |
  When the user click on registration page 
  Then I should be taken to the new Registration page 
  And I should see the SiteID that i have passed on the New Registration page
  | RegSiteID | <regsiteID> | 
   Examples:
  |url                                                                                   | siteID |
 |https://stage-medicare.uhc.com/                                                       | AARP   |
 |https://stage-medicare.uhc.com/                                                       | UHCM   |
 |https://stage-mymedicareaccount.uhc.com/medica                                        |MYPCP   |
 
 
 