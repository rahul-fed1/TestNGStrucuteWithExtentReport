package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    SignInPage signInPage;
    FishPage fishPage;
    ShoppingCartPage cartPage;
    ConfirmationPage confirmationPage;


    @BeforeMethod
    public void setUp(){
        DriverManager.initDriver();
        ConfigReader.initConfigReader();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        signInPage = new SignInPage();
        fishPage = new FishPage();
        cartPage = new ShoppingCartPage();
        confirmationPage = new ConfirmationPage();
    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
