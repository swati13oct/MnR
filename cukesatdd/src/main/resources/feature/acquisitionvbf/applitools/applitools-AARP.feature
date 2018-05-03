@fixedTestCaseTest
@applitools
@applitools_aarp
Feature:2.04-VBF-Acq-To test applitools in AARP site
Scenario Outline:To verify pages load correctly on AARP site
Given user is on acquisition home page applitool
When the user accesses the vpp page using below zipcode on aarp site applitools
	|Zip Code | <zipcode>|
And the user accesses the DCE tool from vpp page on aarp site applitools
	|Plan Type | <plantype> |
And the user has added a drug to the drug list applitools
	|Drug | <drug>|
And the user navigates to step2 page applitools
And the user selects the first pharmacy applitools
Then the user navigates to step3 page and validates applitools
	|Drug|<drug>|
Examples:
|zipcode|plantype    |drug            |
|90210  |  MA	     |Lipitor TAB 10MG|