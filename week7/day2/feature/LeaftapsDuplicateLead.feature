Feature: Leaftaps Duplicate Lead

Scenario Outline: TC003: Duplicate Lead

Given launch the browser
And Login with valid credentials username as <username> and password as <password>
And click on leads and find leads
And click on phone and enter phone number as <phone>
And click on find leads button.
And click on Duplicate lead.
And click on dubmit button.

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|phone|
|'99'|
