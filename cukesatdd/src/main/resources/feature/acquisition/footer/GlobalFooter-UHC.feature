@fixedTestCaseTest
@globalfooter
Feature:2.03-VBF-Acq-To test Global Footer links in UMS site

@globalfooterBLayerSmoke @vbfGate
Scenario:To verify links displayed in Global footer section in UMS site
	Given the user is on the uhcmedicaresolutions site landing page
	When user accesses global footer UHC Medicaresolutions Site
	And the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site
	And the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site
	And the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
	And the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site
	And the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site
	And the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site
	And the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site
	#And user clicks on Request Assistance and validates modal window bluelayer
  And user verifies home link of agents&brokers page bluelayer
