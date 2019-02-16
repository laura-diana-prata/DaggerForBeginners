package ro.funcode.validators


interface Validator {
    fun isValid(text: String): Boolean
}
