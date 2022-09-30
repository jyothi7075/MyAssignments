Feature: Leaf taps edit lead

Scenario Outline: TC002- Edit lead

And Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on phone and enter phone number as <phone>
And click on find leads button
And Capture lead ID of First Resulting lead and click
And click on edit lead
And update the company name as <cname>
And click on submit button

Examples:
|username|password|phone|cname|
|'Demosalesmanager'|'crmsfa'|'99'|'TCS'|

