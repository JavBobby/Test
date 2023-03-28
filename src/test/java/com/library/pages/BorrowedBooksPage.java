package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;



    @FindBy(xpath = "//tbody//td[.='NOT RETURNED ']/preceding-sibling::td[4]")
    public List<WebElement> notReturnedBooks;


    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm ']")
    public List<WebElement> returnBookButton;



    public void returnBooks(){
        Actions actions = new Actions(Driver.getDriver());
        for (WebElement each : new BorrowedBooksPage().returnBookButton) {
            actions.moveToElement(each);
            each.click();
        }
    }




}
