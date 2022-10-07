Feature:
Scenario Outline: Login
Given launch login url
When login with "<username>" and "<password>"
Then verify login
Examples:
|username										|password	|
|mantran.10012000@gmail.com	|123123		|