package web.webTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CreateUserTest extends TestBase {
    private static Random rand = new Random();
    String fullName = "FinalQA"+rand.nextInt(10000);
    String email = "qa"+rand.nextInt(10000)+"@gmail.com";
    String psw = "priset123";
    @Test
    public void verifyCreateUser() throws InterruptedException {
        //Create Account
        mainPage.signUpButton.click();
        signUpPage.fullNameTextBox.setText(fullName);
        signUpPage.emailTextBox.setText(email);
        signUpPage.passwordTextBox.setText(psw);
        signUpPage.acceptTermsButton.click();
        signUpPage.signUpButton.click();
        Assertions.assertTrue(centralSection.openSettingsButton.isControlDisplayed(), "ERROR! El usuario no se creo correctamente.");

        //Logout Account
        menuSection.logoutButton.click();
        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed(), "ERROR! El logout fallo");

        //Create Account wit same credentials
        mainPage.signUpButton.click();
        signUpPage.fullNameTextBox.setText(fullName);
        signUpPage.emailTextBox.setText(email);
        signUpPage.passwordTextBox.setText(psw);
        signUpPage.acceptTermsButton.click();
        signUpPage.signUpButton.click();
        Assertions.assertEquals("Account with this email address already exists!", mainPage.errorMessage.getTextValue(), "ERROR! No se encontro el mensaje de cuenta existente.");

        Thread.sleep(2000);
    }
}
