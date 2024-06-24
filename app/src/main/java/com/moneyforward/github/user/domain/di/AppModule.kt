package com.moneyforward.github.user.domain.di

import com.moneyforward.github.user.BuildConfig
import com.moneyforward.github.user.data.service.GithubService
import com.moneyforward.github.user.data.service.RepoRemoteDataSource
import com.moneyforward.github.user.data.service.RepoRemoteDataSourceImpl
import com.moneyforward.github.user.data.service.UserRemoteDataSource
import com.moneyforward.github.user.data.service.UserRemoteDataSourceImpl
import com.moneyforward.github.user.data.repository.RepoRepository
import com.moneyforward.github.user.data.repository.RepoRepositoryImpl
import com.moneyforward.github.user.data.repository.UserRepository
import com.moneyforward.github.user.data.repository.UserRepositoryImpl
import com.moneyforward.github.user.domain.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named("http-header-interceptor")
    fun provideHttpHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader(Constants.HEADER_AUTHORIZATION, "${Constants.HEADER_BEARER} ${BuildConfig.PERSONAL_ACCESS_TOKEN}")
                .build()

            chain.proceed(request)
        }
    }

    @Provides
    @Named("http-logging-interceptor")
    fun provideHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    fun provideOkHttpClient(
        @Named("http-header-interceptor") httpHeaderInterceptor: Interceptor,
        @Named("http-logging-interceptor") httpLoggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpHeaderInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideGithubService(okHttpClient: OkHttpClient): GithubService {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.HTTP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }

    @Provides
    fun provideRepoRepository(repoRepositoryImpl: RepoRepositoryImpl): RepoRepository {
        return repoRepositoryImpl
    }

    @Provides
    fun provideUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource {
        return userRemoteDataSourceImpl
    }

    @Provides
    fun provideRepoRemoteDataSource(repoRemoteDataSourceImpl: RepoRemoteDataSourceImpl): RepoRemoteDataSource {
        return repoRemoteDataSourceImpl
    }
}
