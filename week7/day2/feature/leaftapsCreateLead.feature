Feature: Leaftaps automation

Scenario Outline: TC001-Create Lead 

Given launch the browser
And Login with valid credentials username as <username> and password as <password>
And click on create lead
And enter company name as <cname> first name as <fname> and last name as <lname>
And click submit button

Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|cname|fname|lname|
|'AOI'|'Kyathi'|'S'|