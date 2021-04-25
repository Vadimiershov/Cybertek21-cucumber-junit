package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBear_OrderPage extends SmartBear_BasePage {


    @FindBy(css = "#ctl00_MainContent_username")
    public WebElement userNameInput;

    @FindBy(css = "#ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='login_info']")
    public WebElement welcomeLogo;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement orderLink;

    @FindBy(xpath = "//h2")
    public WebElement orderHeader;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardType;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDateInput;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(linkText = "View all orders")
    public WebElement allOrdersLink;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[2]//td[2]")
    public WebElement nameInOrder;
























}
