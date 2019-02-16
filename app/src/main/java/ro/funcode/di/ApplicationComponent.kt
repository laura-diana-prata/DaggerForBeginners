package ro.funcode.di

import android.content.Context
import dagger.Component
import ro.funcode.daggerexample.AndroidApplication
import ro.funcode.daggerexample.MainActivity
import ro.funcode.validators.Validator
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    // Inject methods
    fun inject(application: AndroidApplication)

    // Expose methods to other dependent components in our case ActivityComponent
    @Email
    fun getEmailValidator(): Validator

    @Password
    fun getPasswordValidator(): Validator

    @ApplicationContext
    fun getContext(): Context
}
