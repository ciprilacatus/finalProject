package org.example;

import PageObjects.*;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StepDefinitions {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    MainPage mainPage;
    InPerson inPerson;
    VirtualPage virtualPage;
    PersonalInformationPage personalInformationPage;
    ContactInformationPage contactInformationPage;
    CourseOptionPage courseOptionPage;



    public StepDefinitions() {
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        inPerson = new InPerson(driver);
        virtualPage = new VirtualPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        contactInformationPage = new ContactInformationPage(driver);
        courseOptionPage = new CourseOptionPage(driver);
    }

    ///////////////////////////////@Given////////////////////////////////
    @Given("I am on Course Option page")
    public void i_am_on_course_option_page() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/routes/enrollment.html");
        contactInformationPage.fillInContactInformationWithValidData();
    }

    @Given("I am on Personal Information page")
    public void i_am_on_personal_information_page() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/routes/enrollment.html");
    }
    @Given("I am Contact Information page")
    public void  i_am_on_contact_information_page(){
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/routes/enrollment.html");
        personalInformationPage.fillInPersonalInformationWithValidData();
    }

    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/index.html");
    }


    @Given("I am on the Frequently Asking Question from the Home Page")
    public void frequently_asking_question() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/index.html#questions");
    }

    @Given("I am at the end of the Main Page")
    public void end_of_page() {
        driver.get("/html/body/footer");
    }

    @Given("I am on In Person page")
    public void i_am_on_in_person_page() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/routes/in_person.html");
    }

    @Given("I am on Virtual Page")
    public void i_am_on_virtual_page() {
        driver.get("file:///C:/Users/cipri/Documents/azimutVison/Testing-Env-master/Testing-Env-master/routes/virtual.html");
    }

    ///////////////////////////////////////////////////////@When/////////////////////

    @When("the contact information email value of {string} is inputted")
    public void input_email(String string) {
        contactInformationPage.contactInformation_EmailField(string);
    }

    @When("the contact information phone value of {string} is inputted")
    public void input_phone(String string) {
        contactInformationPage.contactInformation_PhoneField(string);
    }

    @When("the first name value of {string} is inputted")
    public void input_first_name(String string) {
        personalInformationPage.inputValueInFirstNameField(string);
    }

    @When("the last name value of {string} is inputted")
    public void input_last_name(String string) {
        personalInformationPage.inputValueInLastNameField(string);
    }

    @When("the username value of {string} is inputted")
    public void input_username(String string) {
        personalInformationPage.inputValueInUsernameField(string);
    }

    @When("the password value of {string} is inputted")
    public void input_password(String string) {
        personalInformationPage.inputValueInPasswordField(string);
    }

    @When("the confirm password value of {string} is inputted")
    public void input_confirm_password(String string) {
        personalInformationPage.inputValueConfirmPassword(string);
    }


    @When("i click on Question expand button")
    public void question_expand_button() {
        Utils.scrollToElement(driver, mainPage.getScrolToQuestionHeader());
        mainPage.clickOnQuestionExpandButton();
    }


    @When("i click on acces Questions button")
    public void click_on_question_button() {
        mainPage.clickOnQuestionButton();
    }

    @When("The email value of {string} is inputted")
    public void input_email_to_field(String string) {
        mainPage.inputValueInEmailField(string);
    }

    @When("The submit button is clicked")
    public void click_submit_button() {
        mainPage.clickOnSubmitButton();
    }

    @When("i click on read more button from In Person")
    public void click_Read_More_In_Person() {
        Utils.scrollToElement(driver, mainPage.getScrolToReadMoreInPerson());
        mainPage.clickReadMoreInPerson();
    }

    @When("i click on return to main page button")
    public void click_on_return_button() {
        inPerson.clickOnReturnToMainButton();
    }

    @When("i click on back to top button")
    public void click_on_back_to_top_button() {
        Utils.scrollToElement(driver, mainPage.getScrolToBottom());
        mainPage.clickBackToTopButton();

    }

    @When("i click on enrollment button")
    public void enrollment_button() {
        mainPage.clickOnEnrollmentButton();
    }

    ////////////////////////////////@And//////////////////////////////////////
    @And("i click on next button from personal information page")
    public void click_next_button_personal_information() {
        personalInformationPage.clickNextButtonFromPersonalInformationStep();
    }
    @And("the country value of {string} is inputted")
    public void input_country(String string) {
        contactInformationPage.contactInformation_CountryField(string);
    }
    @And("the city value of {string} is inputted")
    public void input_city(String string) {
        contactInformationPage.contactInformation_CityField(string);
    }
    @And("the post code value of {string} is inputted")
    public void input_post_code(String string) {
        contactInformationPage.contactInformation_PostCodeField(string);
    }
    @And("i click on next button from contact information page")
    public void click_on_next_button_contact_information_page(){
        contactInformationPage.contactInformation_ClickNextButton();
    }

//    @After
//    public  void cleanUp() {
//        driver.quit();
//    }

}