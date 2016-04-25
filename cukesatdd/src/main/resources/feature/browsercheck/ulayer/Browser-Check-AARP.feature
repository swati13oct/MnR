@browsercheck
Feature: To test Browser check on AARP site
Scenario: To Verify the Pages of widefullwidth template in the browser
Given the user is on the AARP site landing page
When the user is on the AARP home page
Then the user validates error message on the browser of AARP site

Scenario: To Verify the Pages of wideRightRail template in the browser
Given the user is on the AARP site landing page
When the user is on the AARP home page
And the user clicks on contact us link
Then the user validates error message on the browser of AARP site

Scenario: To Verify the Pages of VPPWidefullwidth template in the browser
Given the user is on the AARP site landing page
When the user is on the AARP home page
And the user clicks on Planselector link
Then the user validates error message on the browser of AARP site