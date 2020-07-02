package com.spiraldev.cryptoticker.core.di.components

import android.app.Application
import com.spiraldev.cryptoticker.MyApp
import com.spiraldev.cryptoticker.core.di.modules.ActivityBuilderModule
import com.spiraldev.cryptoticker.core.di.modules.ApiModule
import com.spiraldev.cryptoticker.core.di.modules.AppModule
import com.spiraldev.cryptoticker.core.di.modules.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        ApiModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
