package ro.funcode.validators

import java.util.regex.Pattern
import javax.inject.Inject

class EmailValidator
@Inject constructor() : Validator {
    override fun isValid(text: String): Boolean {
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(text)

        return matcher.matches()
    }

    companion object {
        const val EMAIL_PATTERN: String = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+\\']{1,256}\\" +
                "@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    }
}
