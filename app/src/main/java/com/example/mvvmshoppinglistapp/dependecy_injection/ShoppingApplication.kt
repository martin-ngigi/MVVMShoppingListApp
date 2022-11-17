package com.example.mvvmshoppinglistapp.dependecy_injection

import android.app.Application
import com.example.mvvmshoppinglistapp.data.db.ShoppingDatabase
import com.example.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglistapp.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class ShoppingApplication: Application(), KodeinAware {
    /**
     * This will help in instantiating our objects here instead of instantiating objects in the main
     * activity, which is a bad practice.
     */

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton {
            ShoppingRepository(
                instance()
            )
        }
        bind() from provider {
            ShoppingViewModelFactory(
                instance()
            )
        }
    }
}


/**
class ShoppingApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton {
            ShoppingRepository(
                instance()
            )
        }
        bind() from provider {
            ShoppingViewModelFactory(
                instance()
            )
        }
    }
}
 */