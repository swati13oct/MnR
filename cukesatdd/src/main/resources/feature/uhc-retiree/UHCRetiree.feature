@RallytoolUHCRetiree
Feature:To launch Rally tool from UHC Retiree  Page
Scenario:Verify Rally link from UHC Retiree Home Page 
Given user navigates to the UHCRetiree Home Page
Then user clicks on the Look up my provider link and site opens new provider search tool in a new window

Scenario:To launch Rally Rally tool from Verizon Find Physician Page
And user navigates to the Verizon find a Provider Page
Then user clicks on the Find a physician link and site opens new provider search tool in a new window

Scenario: To launch Rally Rally tool from Verizon Home Page
And user navigates to the Verizon Home Page
Then user clicks on the Find a provider link and site opens new provider search tool in a new window

Scenario:To launch Rally Rally tool from Verizon Site Map Page
And user navigates to the Verizon Site Map Page
Then user clicks on the Find a provider link on verizon site map page and site opens new provider search tool in a new window 

Scenario: To launch rally tool page from Uhcretiree Calpers Pages
Given user navigates to UHC Retiree Calpers Home Page
And user clicks on the Find a Provider link on Calpers Home Page and rally tool opens in new tab
Then user switches back to the Calpers Home Page
And user clicks on the Find a Provider tab
Then user clicks on the Find a Physician Medical Group Clinic or Facility link on Calpers Provider Page and Rally tool opens
Then user again switches back to Calpers Home page
And user clicks on site map on Calpers Home page
Then user clicks on find a provider link on Calpers Site Map Page and rally provider tool opens
