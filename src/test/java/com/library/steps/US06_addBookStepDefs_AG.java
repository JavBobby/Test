package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.an.Y;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US06_addBookStepDefs_AG {

    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page AG")
    public void the_on_the_home_page_ag(String userType) {

        loginPage.login(userType);


    }

    @Given("the user navigates to {string} page AG")
    public void the_user_navigates_to_page_ag(String Books) {

        dashBoardPage.navigateModule(Books);
        BrowserUtil.waitFor(3);

    }

    @When("the librarian click to add book AG")
    public void the_librarian_click_to_add_book_ag() {

        bookPage.addBook.click();
        BrowserUtil.waitFor(3);
    }

    @When("the librarian enter book name {string} AG")
    public void the_librarian_enter_book_name_ag(String BookName) {
        bookPage.bookName.sendKeys(BookName);
        BrowserUtil.waitFor(2);

    }

    @When("the librarian enter ISBN {string} AG")
    public void the_librarian_enter_isbn_ag(String ISBN) {
        bookPage.isbn.sendKeys(ISBN);

    }

    @When("the librarian enter year {string} AG")
    public void the_librarian_enter_year_ag(String Year) {

        bookPage.year.sendKeys(Year);
    }

    @When("the librarian enter author {string} AG")
    public void the_librarian_enter_author_ag(String Author) {
        bookPage.author.sendKeys(Author);
    }

    @When("the librarian choose the book category {string} AG")
    public void the_librarian_choose_the_book_category_ag(String BookCategory) {

        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown, BookCategory);
        BrowserUtil.waitFor(2);


    }

    @When("the librarian click to save changes AG")
    public void the_librarian_click_to_save_changes_ag() {
        bookPage.saveChanges.click();

    }

    @Then("verify {string} message is displayed AG")
    public void verify_message_is_displayed_ag(String expectedMessage) {
        String actualMessage = bookPage.toastMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("verify {string} information must match with DB AG")
    public void verify_information_must_match_with_db_ag(String bookName) {


        DB_Util.runQuery("select name from books where name='"+bookName+"'");


        List<String> actualBookNames = DB_Util.getColumnDataAsList(1);
        System.out.println("actualBookNames = " + actualBookNames);

        Assert.assertTrue(actualBookNames.contains(bookName));
        


    }

}
