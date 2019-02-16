package ro.funcode.daggerexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ro.funcode.di.ApplicationComponent
import ro.funcode.di.Email
import ro.funcode.di.Password
import ro.funcode.di.activity.ActivityComponent
import ro.funcode.di.activity.ActivityModule
import ro.funcode.di.activity.DaggerActivityComponent
import ro.funcode.validators.EmailValidator
import ro.funcode.validators.PasswordValidator
import ro.funcode.validators.Validator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .applicationComponent(AndroidApplication.getComponent())
            .build()
    }

    @Inject
    lateinit var emailValidator: EmailValidator

    @Inject
    lateinit var testClass: TestClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)

        val isEmailValid = emailValidator.isValid("diana@test.com")

        Log.e("Email validation", "is Email from activity valid = $isEmailValid")

        testClass.test()
    }
}
