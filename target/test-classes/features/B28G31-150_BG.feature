
Feature: Books module
  As a students, I should be able to borrow book
@ui @db
  Scenario: Student borrow new book
    Given the "student" on the home page - BG
    And the user navigates to "Books" page - BG
    And the user searches for "Bobby Book" book - BG
    When the user clicks Borrow Book - BG
    Then verify that book is shown in "Borrowing Books" page - BG
    And  verify logged student has same book in database - BG