package ro.funcode.di.activity

import android.content.Context
import dagger.Component
import ro.funcode.daggerexample.MainActivity
import ro.funcode.di.*

@PerActivity
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    // Inject methods
    fun inject(mainActivity: MainActivity)

    // Expose methods to other dependent components
    @ActivityContext
    fun getActivity(): Context

}
