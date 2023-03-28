package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us03_StepDefs {

    BookPage bookPage = new BookPage();

    String actualResultOfDB;

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
      bookPage.navigateModule(moduleName);

    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
    actualResultOfDB = bookPage.categoryDropdown.getText();

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        String quary = "select name from book_categories";
        DB_Util.runQuery(quary);

        String expectedResultOfUI = DB_Util.getColumnDataAsList(1).toString();
        Assert.assertEquals(expectedResultOfUI,actualResultOfDB);


    }
}
