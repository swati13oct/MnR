@RallytoolUHCSAcquisition
Feature:To launch Rally tool from UHC Acquisition Pages
Scenario:Rally Connect Tool should be launched from MA Enrollment Information Tab
Given user navigates to MA Enrollment Information Tab of Blue Layer Acquisition site
And click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up


Scenario:Rally Connect Tool should be launched from MA PLAN INFORMATION AND FORMS
Given user navigates to MA PLAN INFORMATION AND FORMS of Blue Layer Acquisition site
And click on the Look up my provider link on MA PLAN INFORMATION AND FORMS and rally tool opens up

Scenario: To Verify Rally tool from B-Layer Acquisition  
Given the user is on the UHC Medicaresolutions Home page
When user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
Then user clicks on the Search for Provider/Facility link and site opens new provider search tool in a new window