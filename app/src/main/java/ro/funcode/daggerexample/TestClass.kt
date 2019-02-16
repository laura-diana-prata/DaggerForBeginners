package ro.funcode.daggerexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ro.funcode.di.Email
import ro.funcode.di.Password
import ro.funcode.validators.Validator
import javax.inject.Inject

open class TestClass
@Inject constructor(@Email private val emailValidator: Validator,
                    @Password private val passwordValidator: Validator)  {

    fun test() {
        Log.e("test class", "emailValidator from Test = " + emailValidator.isValid("diana@test.com"))
    }
}
