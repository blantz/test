/**
 * Coder beware: this code is not warranted to do anything.
 *
 * Copyright Dec 12, 2009 Carlos Valcarcel
 */
package com.hiddenclause.jwebunit.example;
 
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
 
import org.junit.Before;
import org.junit.Test;
 
 
/**
 * @author carlos
 *
 */
public class UseCaseRegistrationTest {
    private WebTester _webTester;
 
    @Before
    public void setUp() {
        _webTester = new WebTester();
        _webTester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
         
        _webTester.setBaseUrl("http://localhost:8080/hiddenclause"); //$NON-NLS-1$
    }
 
    @Test
    public void testScenario1EverythingWorks() {
        _webTester.beginAt("/login.jsp");
         
        _webTester.assertTitleEquals("Welcome! Register here!");
 
        String username = "Paul Revere";
        String password = "OneIfByLand";
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
         
        _webTester.submit();
         
        _webTester.assertTitleEquals("Confirm Registration Information");
         
        _webTester.assertTextPresent(username);
        _webTester.assertTextPresent(password);
         
        _webTester.submit();
         
        _webTester.assertTitleEquals("Success!");
        _webTester.assertTextPresent("Thanks for registering!");
    }
     
    @Test
    public void testScenario1EmptyInputFields() {
        _webTester.beginAt("/login.jsp");
         
        _webTester.submit();
         
        assertLoginPageWithErrorMessage("All fields are required! Try again! Don't make me go back there!");
    }
     
    /*
     * The code for these methods is the same. Refactored them.
     */
    @Test
    public void testScenario1InvalidNameInputNumeric() {
        assertFieldNumericErrorFound("thx1138", "hi", "Yo! The username can only contain letters!");
    }
     
    @Test
    public void testScenario1InvalidPasswordInputNumeric() {
        assertFieldNumericErrorFound("Paul Revere", "thx1138", "Yo! The password can only contain letters!");
    }
     
    private void assertFieldNumericErrorFound(String username, String password,
                                    String errMsg) {
        _webTester.beginAt("/login.jsp");
         
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
        _webTester.submit();
         
        assertLoginPageWithErrorMessage(errMsg);
    }
 
    /*
     * The code for these methods is the same. Refactored them.
     */
    @Test
    public void testScenario1InvalidNameInputLength() {
        assertFieldLengthErrorFound("abcdefghijklmnopqrstuvwxyzABCDE", "hi", "Yo! The username can only be 30 letters or less!");
    }
     
    @Test
    public void testScenario1InvalidPasswordInputLength() {
        assertFieldLengthErrorFound("Paul Revere", "abcdefghijklmnopqrstuvwxyzABCDE", "Yo! The password can only be 30 letters or less!");
    }
     
    private void assertFieldLengthErrorFound(String username, String password,
                                             String errMsg) {
        _webTester.beginAt("/login.jsp");
         
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
        _webTester.submit();
         
        assertLoginPageWithErrorMessage(errMsg);
    }
     
    @Test
    public void testScenario1UnknownErrorOnSubmit() {
        _webTester.beginAt("/login.jsp");
         
        String username = "Force an error";
        String password = "VeryBad";
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
 
        _webTester.submit();
         
        assertLoginPageWithErrorMessage("I'm sorry, but we seem to have encountered an error. Please try again later or contact Hidden Clause customer support.");
    }
     
    @Test
    public void testScenario2UserReEntersRegistrationInformation() {
        _webTester.beginAt("/login.jsp");
         
        String username = "Paul Revere";
        String password = "OneIfByLand";
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
        _webTester.submit();
         
        _webTester.assertTitleEquals("Confirm Registration Information");
        _webTester.submit("edit");
         
        _webTester.assertTitleEquals("Welcome! Register here!");
        _webTester.assertTextFieldEquals("username", username);
        _webTester.assertTextFieldEquals("password", password);
    }
 
    @Test
    public void testScenario3SystemErrorOnConfirm() {
        _webTester.beginAt("/login.jsp");
         
        String username = "Confirmation error";
        String password = "OneIfByLand";
        _webTester.setTextField("username", username);
        _webTester.setTextField("password", password);
        _webTester.submit();
         
        _webTester.assertTitleEquals("Confirm Registration Information");
        _webTester.submit();
 
        assertLoginPageWithErrorMessage("I'm sorry, but we seem to have encountered an error. Please try again later or contact Hidden Clause customer support.");
    }
     
    private void assertLoginPageWithErrorMessage(String errorMessage) {
        _webTester.assertTitleEquals("Welcome! Register here!");
        _webTester.assertTextPresent(errorMessage);
    }
 
}

