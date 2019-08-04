package com.appstreet.fitness.di

import android.app.Application
import android.content.Context
import com.appstreet.base.retrofit.NetworkBuilder
import com.appstreet.home.api.HomeApi
import com.appstreet.home.repository.HomeRepository
import com.appstreet.home.repository.HomeRepositoryImpl
import com.appstreet.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object Modules {
    private val applicationModules = module {
        /*single(name = "shortcut_list") { MockLauncher.getShortcutList() }*/
    }

    private val utilModule = module {
        /*single { Locale("id", "ID") }
        single(name = "general_time_formatter") { SimpleDateFormat("hh:mm a", get<Locale>()) }
        *//* single {
             get<Application>().let { app ->
                 app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)
             }
         }*//*
        single { LocationHelper(get()) }
        single { SecuredSharedPref(get()) }*/
        single {
            get<Application>().let { app ->
                app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)
            }
        }
    }

    private val viewModelModules = module {
        viewModel { HomeViewModel(get(), get()) }


    }

    private val networkModules = module {
        single<HomeApi> { NetworkBuilder.create(NetworkBuilder.BASE_URL, HomeApi::class.java) }
    }

    private val repoModules = module {
        single<HomeRepository> { HomeRepositoryImpl(get()) }


    }

    private val validatorModule = module {
        /*single<Validator>(name = "change_password") { ChangePasswordValidator() }*/
    }

    private val analyticModule = module {
        /*single { FirebaseAnalytics.getInstance(get()) }*/
    }

    fun getAll() = listOf(
        applicationModules,
        viewModelModules,
        networkModules,
        repoModules,
        validatorModule,
        utilModule,
        analyticModule
    )
}