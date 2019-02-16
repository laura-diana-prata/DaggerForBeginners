package ro.funcode.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ro.funcode.daggerexample.AndroidApplication
import ro.funcode.validators.EmailValidator
import ro.funcode.validators.PasswordValidator
import ro.funcode.validators.Validator
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @ApplicationContext
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    @Email
    fun provideEmailValidator(dataSource: EmailValidator): Validator = dataSource

    @Provides
    @Singleton
    @Password
    fun providePasswordValidator(dataSource: PasswordValidator): Validator = dataSource
}
