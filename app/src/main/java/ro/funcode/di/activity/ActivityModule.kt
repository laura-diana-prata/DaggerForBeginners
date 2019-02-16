package ro.funcode.di.activity

import android.content.Context
import dagger.Module
import dagger.Provides
import ro.funcode.di.ActivityContext
import ro.funcode.di.PerActivity

@Module
class ActivityModule(val context: Context) {
    @Provides
    @ActivityContext
    @PerActivity
    fun provideContext(): Context = context

}
