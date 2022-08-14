package ru.job4j.early;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PasswordValidatorTest {
    @Test
    void checkPasswordHasLengthLess8() {
        assertThatThrownBy(() -> PasswordValidator.validate("ret"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordHasLengthMore32() {
        assertThatThrownBy(() -> PasswordValidator.validate("wjdi12TT[rmcjfdousfketpcrhwabcjuedkye"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWithOnlyUpperCase() {
        assertThatThrownBy(() -> PasswordValidator.validate("TYDHF12[]YDS"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWithOnlyLowerCase() {
        assertThatThrownBy(() -> PasswordValidator.validate("fgsjruf46jf[ye"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWithoutDigit() {
        assertThatThrownBy(() -> PasswordValidator.validate("jfsjghyYG{yf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWithoutSpecialCharacters() {
        assertThatThrownBy(() -> PasswordValidator.validate("jfsj12ghyYGyf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWhenContainsQwerty() {
        assertThatThrownBy(() -> PasswordValidator.validate("retQwerty12[ret"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWhenContains12345() {
        assertThatThrownBy(() -> PasswordValidator.validate("retQrty123456[ret"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWhenContainsPassword() {
        assertThatThrownBy(() -> PasswordValidator.validate("12Password[]45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWhenContainsAdmin() {
        assertThatThrownBy(() -> PasswordValidator.validate("34adminRRR[]U"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPasswordWhenContainsUser() {
        assertThatThrownBy(() -> PasswordValidator.validate("wert67uSer{3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkValidPassword() {
        Assertions.assertEquals(
                PasswordValidator.validate("hfy45-UHsdf"), "hfy45-UHsdf");
    }

}