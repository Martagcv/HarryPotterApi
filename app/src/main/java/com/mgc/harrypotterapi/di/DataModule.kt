package com.mgc.harrypotterapi.di

import android.content.Context
import androidx.room.Room
import com.mgc.harrypotterapi.BuildConfig
import com.mgc.harrypotterapi.data.CharacterRepository
import com.mgc.harrypotterapi.data.CharacterRepositoryImpl
import com.mgc.harrypotterapi.data.local.CharacterDao
import com.mgc.harrypotterapi.data.local.CharacterDatabase
import com.mgc.harrypotterapi.data.local.LocalDataSource
import com.mgc.harrypotterapi.data.local.LocalDataSourceImpl
import com.mgc.harrypotterapi.data.remote.HarryPotterApi
import com.mgc.harrypotterapi.data.remote.RemoteDataSource
import com.mgc.harrypotterapi.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

//import com.mgc.harrypotterapi.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseUrl = BuildConfig.BASE_URL
//val baseUrl = "https://hp-api.onrender.com/api/characters"

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    //HarryPotterApi en data remote
    single<HarryPotterApi> {
        getHarryPotterApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesCharacterDao(get())
    }

}

private fun getHarryPotterApi(retrofit: Retrofit) =
    retrofit.create(HarryPotterApi::class.java)

private fun getDatabase(context: Context) : CharacterDatabase =
    Room.databaseBuilder(
        context,
       CharacterDatabase::class.java, "harrypotter-db"
    ).build()

private fun providesCharacterDao(db: CharacterDatabase) : CharacterDao =
    //en data local CharacterDatabase, cambiar nombre?
    db.characterDao()
