package com.aldhykohar.submissionjetpack.utils

import com.aldhykohar.submissionjetpack.data.repository.local.entity.DetailEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.MovieEntity
import com.aldhykohar.submissionjetpack.data.repository.local.entity.TvShowsEntity
import com.aldhykohar.submissionjetpack.data.repository.remote.response.*
import com.aldhykohar.submissionjetpack.data.repository.remote.response.movie.*
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.DetailTvShowResponse
import com.aldhykohar.submissionjetpack.data.repository.remote.response.tvshow.TvShowsItem


/**
 * Created by aldhykohar on 5/2/2021.
 */
object DataDummy {

    fun generateDummyMovies(): List<MoviesItem> {
        val movies = ArrayList<MoviesItem>()

        movies.add(
            MoviesItem(
                508943,
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                "Luca",
                "Luca",
                "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg", "2021-06-17", 8.2
            )
        )
        return movies
    }

    fun generateDummyMoviesEntities(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                508943,
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                "Luca",
                "Luca",
                "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg", "2021-06-17", 8.2
            )
        )
        return movies
    }

    fun generateDummyDetailMovies(): DetailEntity {
        val genre = ArrayList<GenresItem>()
        genre.add(GenresItem("Comedy", 35))
        genre.add(GenresItem("Crime", 80))
        return DetailEntity(
            "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg", genre, 337404,
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg", "2021-05-26", "Realesed", "Cruella", 8.6, 2713
        )
    }

    fun generateDetailMoviesResponse(): DetailMovieResponse {
        return DetailMovieResponse(
            "en",
            "Cruella",
            "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
            genres = listOf(
                GenresItem("Comedy", 35),
                GenresItem("Crime", 80)
            ),
            3060.648,
            337404,
            2713,
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "Cruella",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
            "2021-05-26",
            8.6,
            "Released"
        )
    }

    fun generateDummyTvShow(): List<TvShowsItem> {

        val tvShow = ArrayList<TvShowsItem>()

        tvShow.add(
            TvShowsItem(
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "Loki",5664.164,
                8.1,
                "Loki",
                84958
            )
        )
        return tvShow
    }

    fun generateDummyTvShowEntities(): List<TvShowsEntity> {

        val tvShow = ArrayList<TvShowsEntity>()

        tvShow.add(
            TvShowsEntity(
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "Loki",
                8.1,
                "Loki",
                84958
            )
        )
        return tvShow
    }

    fun generateDummyDetailTvShow(): DetailEntity {
        val genre = ArrayList<GenresItem>()
        genre.add(GenresItem("Comedy", 35))
        genre.add(GenresItem("Crime", 80))
        return DetailEntity(
            "/ykElAtsOBoArgI1A8ATVH0MNve0.jpg",
            genres = listOf(
                GenresItem("Drama", 18),
                GenresItem("Sci-Fi & Fantasy", 10765)
            ), 84958,
            "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
            "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            "2021-06-09",
            "Returning Series",
            "Loki", 8.1, 2789
        )
    }

    fun generateDetailTvShowResponse(): DetailTvShowResponse {
        return DetailTvShowResponse(
            "2021-06-09",
            "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
            "en",
            "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            "/ykElAtsOBoArgI1A8ATVH0MNve0.jpg",
            genres = listOf(
                GenresItem("Drama", 18),
                GenresItem("Sci-Fi & Fantasy", 10765)
            ), "Loki", 6160.834, 8.1, "Loki", "Returning Series", 84958,
            true, "2021-06-16", 2789
        )
    }

}