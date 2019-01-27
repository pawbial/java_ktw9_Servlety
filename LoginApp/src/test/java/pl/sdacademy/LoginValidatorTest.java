package pl.sdacademy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginValidatorTest {


    private LoginValidator loginValidatorTest;

    @Before
    public void setup () {
        loginValidatorTest = new LoginValidator();
    }

    @Test
    public void shouldReturnFalseWhenUserNameIsEmpty() {
    // Given
    String userName = "";

    // When
    boolean result  = loginValidatorTest.isValid(userName,"SDA2019");
    // Then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsEmpty() {
        // Given
        String password = "";

        // When
        boolean result  = loginValidatorTest.isValid("123456", password);
        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenUserNameLengthLessThan6() {
        // Given
        String userName = "12345";

        // When
        boolean result  = loginValidatorTest.isValid(userName,"SDA2019");
        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenPasswordLengthLessThan6() {
        // Given
        String password = "12345";

        // When
        boolean result  = loginValidatorTest.isValid("123456",password);
        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenPasswordAndUserNameAreAsBelow() {
    // Given
    String password = "SDA2019";
    String userName = "JavaKTW9";
    // When
        boolean result  = loginValidatorTest.isValid(userName,password);
    // Then
    Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWithLowerCaseInUserName() {
        // Given
        String password = "SDa2019";
        String userName = "JavaKTW9";
        // When
        boolean result  = loginValidatorTest.isValid(userName,password);
        // Then
        Assert.assertFalse(result);
    }



}
