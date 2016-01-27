@footerUlayer
Feature:To test global footer links in AARP site
Scenario:To verify links displayed in the global footer of AARP site
Given user is on the AARP Medicare Plans home page
When user accesses global footer of the AARP Medicare Plans home page 
And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
And user clicks on contactus link of aboutus page
And user clicks on sitemap link of contactus page
And user clicks on privacypolicy link of sitemap page
And user clicks on terms&conditions link of privacypolicy page
And user clicks on disclaimers link of terms&conditions page
And user clicks on agents&brokers link of disclaimers page
And user clicks on home link of agents&brokers page
Then the user validates all links in the global footer of AARP site
