package com.aldhykohar.submissionjetpack.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.BuildConfig
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.repository.Repository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenreResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by aldhykohar on 5/26/2021.
 */
class FakeRemoteRepository {

    private fun providesApiKey(): Interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request: Request = chain.request()
            val url: HttpUrl = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()
            request = request.newBuilder().url(url).build()
            return chain.proceed(request)
        }
    }

    private fun provideOkHttpClient(
        apiKey: Interceptor
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().apply {
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.addInterceptor(loggingInterceptor).addInterceptor(apiKey).build()
    }

    private fun provideRetrofit(
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(provideOkHttpClient(providesApiKey()))
            .build()

    private val apiService = provideRetrofit().create(ApiService::class.java)

    fun getMovies(): Call<MoviesResponse> = apiService.getMovies()

    fun getGenreMovies(): Call<GenreResponse> = apiService.getGenreMovies()

    fun getTvShows(): Call<TvShowsResponse> = apiService.getTvShows()

    fun getGenreTvShow(): Call<GenreResponse> = apiService.getGenreTvShow()

}