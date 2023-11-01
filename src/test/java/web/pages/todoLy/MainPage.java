package web.pages.todoLy;

import web.controls.Button;
import org.openqa.selenium.By;
import web.controls.ControlBase;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    public Button signUpButton = new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"));
    public ControlBase errorMessage = new ControlBase(By.id("ErrorMessageText"));
}
