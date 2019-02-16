package ro.funcode.validators

import java.util.regex.Pattern
import javax.inject.Inject

class PasswordValidator
@Inject constructor() : Validator {
    override fun isValid(text: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher = pattern.matcher(text)

        return matcher.matches()
    }

    companion object {
        const val PASSWORD_PATTERN: String = "^" +
                "(?=.*[0-9])" +         // at least 1 digit
                "(?=.*[a-z])" +         // at least 1 lower case letter
                "(?=.*[A-Z])" +         // at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      // any letter
                "(?=.*[!?@#$%^&*()-+|=}{/:;\",'\\]\\[_\\\\~<>€¥£•])" + // at least 1 special character
                "(?=\\S+$)" +           // no white spaces
                ".{8,}" +               // at least 4 characters
                "$"
    }
}
