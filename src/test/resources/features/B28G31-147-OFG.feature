@B28G31-153 @ui
Feature: Default

	Background:
		#@B28G31-151

		Given the "librarian" on the home page - OFG
		

	#As a data consumer, I want UI and DB book information are match.
	@B28G31-152 @db
	Scenario: US1AC1 Verify book information with DB - OFG
		When the user navigates to "Books" page - OFG
		And the user searches for "farukgoc" book - OFG
		And the user clicks edit book button - OFG
		Then book information must match the Database - OFG