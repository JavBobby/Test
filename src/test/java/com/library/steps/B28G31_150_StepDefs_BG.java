package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class B28G31_150_StepDefs_BG {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    String bookName;

    List<String> borrowedBookList = new ArrayList<>();

    @Given("the {string} on the home page - BG")
    public void the_on_the_home_page(String userType) {
        loginPage.login(userType);
    }

    @Given("the user navigates to {string} page - BG")
    public void the_user_navigates_to_page(String string) {
        bookPage.navigateModule(string);
    }

    @Given("the user searches for {string} book - BG")
    public void the_user_searches_for_book(String bookName) {
        this.bookName = bookName;
        bookPage.search.sendKeys(bookName);
    }

    @When("the user clicks Borrow Book - BG")
    public void the_user_clicks_borrow_book() {
        BrowserUtil.waitForClickablility(bookPage.borrowBook(bookName), 3);
        bookPage.borrowBook(bookName).click();
    }

    @Then("verify that book is shown in {string} page - BG")
    public void verify_that_book_is_shown_in_page(String moduleName) {
        bookPage.navigateModule(moduleName);

        for (WebElement eachBook : borrowedBooksPage.notReturnedBooks) {
            borrowedBookList.add(eachBook.getText());
        }
    }

    @Then("verify logged student has same book in database - BG")
    public void verify_logged_student_has_same_book_in_database() {

        String query = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "      inner join book_borrow bb on u.id = bb.user_id\n" +
                "      inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 5' and name='" + bookName + "'\n" +
                "order by 3 desc";
        DB_Util.runQuery(query);
        String expectedResult = DB_Util.getCellValue(1, 2);
        Assert.assertTrue(borrowedBookList.contains(expectedResult));
       // borrowedBooksPage.returnBooks();
    }
}
