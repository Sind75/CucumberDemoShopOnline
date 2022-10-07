Feature:
Scenario: register account
Given launch register url
When provide valid info to input fields
|First Name	|Last Name	|E-mail					|phone			|Password		|Re-password	|
|Aka				|Maru				|abc.@gmail.com	|0353537714	|abc.123@		|Abc.123@			|
Then verify account registed