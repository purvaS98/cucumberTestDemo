Feature: User login

	Scenario: Succesful Login
		Given the user is on nopCommercelogin page
		When the user enters valid credentials (username: "test@gmail.com, password: "test@123")
		And the user clicks on the Login button
		Then the user should be redirected to the My Account Page
		And the user should see a welcome page