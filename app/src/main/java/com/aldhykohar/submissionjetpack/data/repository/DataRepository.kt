package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.LocalRepository
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem
import com.aldhykohar.submissionjetpack.utils.AppExecutors
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
                                genreIds,
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

    override fun getTvShows(): LiveData<List<TvShowsItem>> {
        val tvShowResult = MutableLiveData<List<TvShowsItem>>()

        remoteRepository.getTvShow(object : RemoteRepository.LoadTvShowCallback {
            override fun onTvShowLoaded(tvShow: List<TvShowsItem>?) {
                val tvShowList = ArrayList<TvShowsItem>()
                if (tvShow != null) {
                    for (response in tvShow) {
                        with(response) {
                            val tvShows = TvShowsItem(
                                firstAirDate, overview, originalLanguage, genreIds,
                                posterPath, originCountry, backdropPath, originalName, popularity,
                                voteAverage, name, id, voteCount
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

    override fun getGenreMovies(): LiveData<List<GenresItem>> {
        val genreResult = MutableLiveData<List<GenresItem>>()

        remoteRepository.getGenreMovie(object : RemoteRepository.LoadGenreCallback {
            override fun onGenreLoaded(genres: List<GenresItem>?) {
                val genreList = ArrayList<GenresItem>()
                if (genres != null) {
                    for (response in genres) {
                        with(response) {
                            val genre = GenresItem(name, id)
                            genreList.add(genre)
                        }
                    }
                    genreResult.postValue(genreList)
                }
            }

        })
        return genreResult
    }

    override fun getGenreTvShow(): LiveData<List<GenresItem>> {
        val genreResult = MutableLiveData<List<GenresItem>>()

        remoteRepository.getGenreTvShow(object : RemoteRepository.LoadGenreCallback {
            override fun onGenreLoaded(genres: List<GenresItem>?) {
                val genreList = ArrayList<GenresItem>()
                if (genres != null) {
                    for (response in genres) {
                        with(response) {
                            val genre = GenresItem(name, id)
                            genreList.add(genre)
                        }
                    }
                    genreResult.postValue(genreList)
                }
            }

        })
        return genreResult
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

    fun getMovieFav(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getMovieFav(), config).build()
    }

}