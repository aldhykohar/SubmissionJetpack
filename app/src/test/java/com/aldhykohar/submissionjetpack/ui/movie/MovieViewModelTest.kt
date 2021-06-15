package com.aldhykohar.submissionjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.BuildConfig
import com.aldhykohar.submissionjetpack.MainCoroutineRule
import com.aldhykohar.submissionjetpack.data.FakeRemoteRepository
import com.aldhykohar.submissionjetpack.data.api.ApiService
import com.aldhykohar.submissionjetpack.data.model.MoviesModel
import com.aldhykohar.submissionjetpack.data.repository.DataRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.MoviesResponse
import com.aldhykohar.submissionjetpack.utils.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by aldhykohar on 6/5/2021.
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner.Silent::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var fakeRemoteRepository: FakeRemoteRepository

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var remoteRepository: RemoteRepository

    private lateinit var apiService: ApiService

    @Mock
    var service: ApiService? = null

    @InjectMocks
    var repository: DataRepository? = null

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


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        apiService = provideRetrofit().create(ApiService::class.java)
        fakeRemoteRepository = FakeRemoteRepository()
        remoteRepository = RemoteRepository(apiService)
        dataRepository = DataRepository(remoteRepository)
        viewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getGenreMovies() {

    }

    @ExperimentalCoroutinesApi
    @Test
    fun getMovies() = runBlockingTest {
        val response = fakeRemoteRepository.getMovies2()


        val mock: MutableLiveData<Resource<MoviesModel>> =
            mock(MutableLiveData<Resource<MoviesModel>>()::class.java)
//        `when`(remoteRepository.getMovies()).thenReturn(response)
//        verify(remoteRepository).getMovies()
//        print(response.value?.data)
//        print(remoteRepository.getMovies().value?.data)
//        verify(response).postValue(mock)

        `when`(fakeRemoteRepository.getMovies2()).thenReturn(mock)
        println("Hasil  : " + fakeRemoteRepository.getGenreMovies())
        println("Hasil  : " + response.value)
        println("Hasil  : " + mock)

    }
}
