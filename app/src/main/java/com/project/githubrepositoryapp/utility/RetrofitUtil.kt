package com.project.githubrepositoryapp.utility

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.project.githubrepositoryapp.BuildConfig
import com.project.githubrepositoryapp.data.Url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtil {

    val authApiService: AuthApiService by lazy { getGithubAuthRetrofit().create(AuthApiService::class.java) }

    private fun getGithubAuthRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.GITHUB_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .client(buildOKHttpClient())
            .build()
    }

    val githubApiService: GithubApiService by lazy { getGithubAuthRetrofit().create(GithubApiService::class.java) }

    private fun getGithubRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.GITHUB_API_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .client(buildOKHttpClient())
            .build()
    }

    private fun buildOKHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

}