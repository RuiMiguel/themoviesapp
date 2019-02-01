package com.gigigo.themoviesapp.base.di

import com.gigigo.themoviesapp.base.data.utils.ConnectionInterceptor
import com.gigigo.themoviesapp.base.data.utils.NetworkHandler
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@JvmField
val presentationModule: Module = module {

}

@JvmField
val domainModule: Module = module {

}

@JvmField
val dataModule: Module = module {
    single { getGson() } bind (Gson::class)
    single { NetworkHandler(androidApplication()) }

    single {
        provideLoggingInterceptor()
    } bind HttpLoggingInterceptor::class

    single("ConnectionInterceptor") {
        ConnectionInterceptor(networkHandler = get())
    } bind Interceptor::class

    single {
        createOkHttpClient(
            loggingInterceptor = get(),
            errorInterceptor = get("ConnectionInterceptor")
        )
    }

    single {
        createRetrofit(
            okHttpClient = get(),
            endpoint = getProperty(Property.API_URL)
        )
    }
}

object Property {
    const val API_URL = "API_URL"
    const val IMAGE_API_URL = "IMAGE_API_URL"
}

@JvmField
val baseModules = listOf(presentationModule, domainModule, dataModule)

fun getGson(): Gson = GsonBuilder().serializeNulls().create()

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}

fun createOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor,
    errorInterceptor: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(errorInterceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun createRetrofit(okHttpClient: OkHttpClient, endpoint: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(endpoint)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

inline fun <reified T> createApiService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)