Feature:
Scenario: add to cart
Given launch url
When login home page
When search any item anf add it to cart
Then verify add successful
When checkout with information
|First name	|Last name	|Company	|address 1	| address 2	|City	|post code	|country	|region	|
|Man				|Tran				|HCL tech	|PVD HN			|PVD HN BTL	|HaNoi|590000			|Viet Nam	|Ha Noi	|
Then verify checkout successful
