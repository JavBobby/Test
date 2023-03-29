Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui @db
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page AG
    And the user navigates to "Books" page AG
    When the librarian click to add book AG
    And the librarian enter book name "<Book Name>" AG
    When the librarian enter ISBN "<ISBN>" AG
    And the librarian enter year "<Year>" AG
    When the librarian enter author "<Author>" AG
    And the librarian choose the book category "<Book Category>" AG
    And the librarian click to save changes AG
    Then verify "The book has been created." message is displayed AG
    And verify "<Book Name>" information must match with DB AG
    Examples:
      | Book Name                | ISBN     | Year | Author       | Book Category        |
      | Clean Code AG            | 12112021 | 2021 | Kathy Sierra | Fantasy              |
      | Head First Java AG       | 10112021 | 2021 | Kathy Sierra | Action and Adventure |
      | The Scrum Field Guide AG | 11112021 | 2006 | Mitch Lacey  | Short Story          |