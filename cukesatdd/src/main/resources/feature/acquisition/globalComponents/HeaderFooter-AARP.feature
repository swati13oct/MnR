@globalHeader
Feature: 2.04--Acq-To test global footer links in AARP site

  @globalfooterULayer
  Scenario: To verify links displayed in the global footer of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When user accesses global footer of the AARP Medicare Plans home page
    And user vaidates the state drop down link on home page
    And user clicks on View all disclaimer information link on home page
    And user verifies visit aarp.org link on home page ulayer
    And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
    And user clicks on contactus link of aboutus page
    And user clicks on sitemap link of contactus page
    And user clicks on privacypolicy link of sitemap page
    And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms&conditions page
    And user clicks on agents&brokers link of disclaimers page
    And user verifies and clicks on home link of agents&brokers page ulayer
    Then user clicks on back to top link on home page

  @globalheaderULayer
  Scenario: To verify links displayed in the global header of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When user accesses global header of the AARP Medicare Plans home page
    And user verifies the AARP logo on home page
    And user clicks on Sign in link on home page in aarp
    And user clicks on register link on home page in aarp
    Then user validates visitor profile on home page in aarp

  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the AARP Medicare Plans home page
    When user accesses global footer of the AARP Medicare Plans All page
    Then the USer validates Shop for a Plan Navigation links
    Then the user validates Medicare Education Navigation links
    Then the user validates TFN on page
    | TFNxpath | <tfnXpath> |
#    Then the user validates Pro-active Chat
     Then the user validates SAM Call Icon
     Then the user validates SAM re-active Chat

    Examples: 
      | path                    | pageName      | tfnXpath |
      | medicare-education.html | MedEd Landing | //*[@class='amp']//a[contains(@href, 'callto')] | 
      
     
