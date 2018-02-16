@theSpartans
Feature: To validate the new changes related to new SignIn page  on the member redesigned site

  @signInErrorMessages1
  Scenario Outline: To Verify Error Messages In Both username and password fields
    Given I am a  member on the sign-in page
      | URL | <url> |
    When I have not entred any thing in both username and password fields
    Then I should get the error message on both fields

    Examples: 
      | url                                            |
      | https://stage-medicare.uhc.com/                |
      | https://stage-medicare.uhc.com/                |
      | https://stage-mymedicareaccount.uhc.com/medica |

  @signInErrorMessages2
  Scenario Outline: To Verify Error Messages In username field
    Given I am a  member on the sign-in page
      | URL | <url> |
    When I have not entred any thing in  username  field
    Then I should get the error message on username field

    Examples: 
      | url                                            |
      | https://stage-medicare.uhc.com/                |
      | https://stage-medicare.uhc.com/                |
      | https://stage-mymedicareaccount.uhc.com/medica |

  @signInErrorMessages3
  Scenario Outline: To Verify Error Messages In password field
    Given I am a  member on the sign-in page
      | URL | <url> |
    When I have not entred any thing in password field
    Then I should get the error message on password field

    Examples: 
      | url                                            |
      | https://stage-medicare.uhc.com/                |
      | https://stage-medicare.uhc.com/                |
      | https://stage-mymedicareaccount.uhc.com/medica |

 