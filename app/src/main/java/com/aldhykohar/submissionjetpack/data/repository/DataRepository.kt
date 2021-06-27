package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.LocalRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem
import javax.inject.Inject


/**
 * Created by aldhykohar on 5/26/2021.
 */
class DataRepository
@Inject
constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : Repository {
    override fun getMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()

        remoteRepository.getMovies(object : RemoteRepository.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<MoviesItem>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MovieEntity(
                                id,
                                overview,
                                originalTitle,
                                title,
                                posterPath,
                                backdropPath,
                                releaseDate, voteAverage
                            )
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }

        })
        return movieResult
    }

    override fun getTvShows(): LiveData<List<TvShowsEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowsEntity>>()

        remoteRepository.getTvShow(object : RemoteRepository.LoadTvShowCallback {
            override fun onTvShowLoaded(tvShow: List<TvShowsItem>?) {
                val tvShowList = ArrayList<TvShowsEntity>()
                if (tvShow != null) {
                    for (response in tvShow) {
                        with(response) {
                            val tvShows = TvShowsEntity(
                                firstAirDate,
                                overview,
                                posterPath,
                                originalName,
                                voteAverage,
                                name,
                                id,
                                voteCount
                            )
                            tvShowList.add(tvShows)
                        }
                    }
                    tvShowResult.postValue(tvShowList)
                }
            }

        })
        return tvShowResult
    }

    override fun getDetailMovies(moviesId: Int): LiveData<DetailEntity> {
        val detailResult = MutableLiveData<DetailEntity>()

        remoteRepository.getDetailMovies(object : RemoteRepository.LoadDetailMovies {
            override fun onDetailMoviesLoaded(details: DetailMovieResponse?) {
                if (details != null) {
                    with(details) {
                        val listGenres = ArrayList<String>()

                        for (genre in genres) {
                            listGenres.add(genre.name)
                        }

                        val detailMovie = DetailEntity(
                            backdropPath,
                            genres,
                            id,
                            overview,
                            posterPath,
                            releaseDate,
                            status,
                            title,
                            voteAverage,
                            voteCount
                        )
                        detailResult.postValue(detailMovie)
                    }
                }
            }

        }, moviesId)
        return detailResult
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity> {
        val detailResult = MutableLiveData<DetailEntity>()

        remoteRepository.getDetailTvShow(object : RemoteRepository.LoadDetailTvShow {
            override fun onDetailTvShowLoaded(details: DetailTvShowResponse?) {
                if (details != null) {
                    with(details) {
                        val listGenres = ArrayList<String>()

                        for (genre in genres) {
                            listGenres.add(genre.name)
                        }

                        val detailMovie = DetailEntity(
                            backdropPath,
                            genres,
                            id,
                            overview,
                            posterPath,
                            firstAirDate,
                            status,
                            originalName,
                            voteAverage,
                            voteCount
                        )
                        detailResult.postValue(detailMovie)
                    }
                }
            }

        }, tvShowId)
        return detailResult
    }

    suspend fun setMovieFav(movie: MovieEntity) =
        localRepository.insertMovieFav(movie)

    suspend fun deleteMovieFav(movie: MovieEntity) =
        localRepository.deleteMovieFav(movie)

    fun getMovieFav(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getMovieFav(), config).build()
    }

    fun checkMovieFav(movieId: Int): LiveData<MovieEntity> = localRepository.checkMovieFav(movieId)

    suspend fun setTvShowFav(tvShows: TvShowsEntity) =
        localRepository.insertTvShowFav(tvShows)

    suspend fun deleteTvShowsFav(tvShows: TvShowsEntity) =
        localRepository.deleteTvShow(tvShows)

    fun getTvShowFav(): LiveData<PagedList<TvShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getTvShowFav(), config).build()
    }

    fun checkTvShow(tvShowId: Int): LiveData<TvShowsEntity> =
        localRepository.checkTvShowFav(tvShowId)

}