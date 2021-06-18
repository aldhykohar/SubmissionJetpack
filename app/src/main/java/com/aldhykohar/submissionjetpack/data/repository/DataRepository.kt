package com.aldhykohar.submissionjetpack.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldhykohar.submissionjetpack.data.model.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.RemoteRepository
import com.aldhykohar.submissionjetpack.data.repository.remote.response.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.DetailMovieResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.GenresItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.MoviesItem
import com.aldhykohar.submissionjetpack.data.repository.remote.response.TvShowsItem
import javax.inject.Inject


/**
 * Created by aldhykohar on 5/26/2021.
 */
class DataRepository
@Inject
constructor(private val remoteRepository: RemoteRepository) : Repository {
    override fun getMovies(): LiveData<List<MoviesItem>> {
        val movieResult = MutableLiveData<List<MoviesItem>>()

        remoteRepository.getMovies(object : RemoteRepository.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<MoviesItem>?) {
                val movieList = ArrayList<MoviesItem>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MoviesItem(
                                overview,
                                originalLanguage,
                                originalTitle,
                                video,
                                title,
                                genreIds,
                                posterPath,
                                backdropPath,
                                releaseDate,
                                popularity,
                                voteAverage,
                                id,
                                adult,
                                voteCount
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
                            runtime,
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
                            23,
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

}