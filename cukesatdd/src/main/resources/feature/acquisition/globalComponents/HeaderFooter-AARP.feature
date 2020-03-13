@globalHeader
Feature: 2.04-VBF-Acq-To test global footer links in AARP site

@globalfooterULayer
Scenario: To verify links displayed in the global footer of AARP site
      Given the user is on AARP medicare acquisition site landing page
      When user accesses global footer of the AARP Medicare Plans home page 
      And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
      And user clicks on contactus link of aboutus page
      And user clicks on sitemap link of contactus page
      And user clicks on privacypolicy link of sitemap page
      And user clicks on termsOfuse link of privacypolicy page
      And user clicks on disclaimers link of terms&conditions page
      And user clicks on agents&brokers link of disclaimers page
      #And user clicks on Request Assistance and validates modal window ulayer
      And user verifies and clicks on home link of agents&brokers page ulayer
      And user vaidates the state drop down link on home page
      And user clicks on View all disclaimer information link on home page
      And user verifies visit aarp.org link on home page ulayer
      Then user clicks on back to top link on home page
      
      
      
@globalheaderULayer
Scenario: To verify links displayed in the global header of AARP site 
      Given the user is on AARP medicare acquisition site landing page
      When user accesses global header of the AARP Medicare Plans home page
     # And user verifies the AARP logo on home page
      And user clicks on Sign in link on home page in aarp
      And user clicks on register link on home page in aarp
    #  And user hovers over the heart icon and verifies the visitor profile section
     # And user clicks on visit aarp.org link in the ulayer header
	