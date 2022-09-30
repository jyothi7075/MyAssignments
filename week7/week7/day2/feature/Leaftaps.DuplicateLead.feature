Feature: Leaftaps Duplicate Lead

Scenario Outline: TC003: Duplicate Lead

And Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on phone and enter phone number as <phone>
And click on find leads button
And Capture lead ID of First Resulting lead and click
And click on Duplicate lead
And click on submit button

Examples:
|username|password|phone|
|'Demosalesmanager'|'crmsfa'|'99'|

