@fixedTestCaseTest
@globalfooter
@globalfooterAARP
Feature:2.04-VBF-Acq-To test global footer links in AARP site (GATED)
Scenario:To verify links displayed in the global footer of AARP site
Given user is on acquisition home page of AARP Site
When user accesses global footer of the AARP Medicare Plans home page 
And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
And user clicks on contactus link of aboutus page
And user clicks on sitemap link of contactus page
And user clicks on privacypolicy link of sitemap page
And user clicks on termsOfuse link of privacypolicy page
And user clicks on disclaimers link of terms&conditions page
And user clicks on agents&brokers link of disclaimers page
And user verifies home link of agents&brokers page ulayer
And user clicks on home link of agents&brokers page