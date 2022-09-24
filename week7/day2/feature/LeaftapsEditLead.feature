Feature: Leaf taps edit lead

Scenario Outline: TC002- Edit lead

Given launch the browser
And Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on phone and enter phone number as <phone>
And click on find leads button.
And click on edit lead
And update the company name as <cname>
And click on submit button.

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|phone|cname|
|'99'|'TCS'|