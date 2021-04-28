package com.dicoding.auliarosyida.moviesapp.utils

import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity

object DataMovies {

    private val moviePosters = intArrayOf(R.drawable.poster_how_to_train,
        R.drawable.poster_ralph,
        R.drawable.poster_robin_hood,
        R.drawable.poster_spiderman,
        R.drawable.poster_infinity_war,
        R.drawable.poster_aquaman,
        R.drawable.poster_alita,
        R.drawable.poster_mortal_engines,
        R.drawable.poster_cold_persuit,
        R.drawable.poster_crimes)

    private val movieTitles = arrayOf("How to Train Your Dragon: The Hidden World",
        "Ralph Breaks the Internet",
        "Robin Hood",
        "Spider-Man: Into the Spider-Verse",
        "Avengers: Infinity War",
        "Aquaman",
        "Alita: Battle Angel",
        "Mortal Engines",
        "Cold Pursuit",
        "Fantastic Beasts: The Crimes of Grindelwald")

    private val movieQuotes = arrayOf("The friendship of a lifetime",
        "Who Broke the Internet?",
        "The legend you know. The story you don't.",
        "More Than One Wears the Mask",
        "An entire universe. Once and for all.",
        "Home Is Calling",
        "An angel falls. A warrior rises.",
        "Some scars never heal",
        "Meet Nels Coxman. Citizen of the Year.",
        "Fate of One. Future of All.")

    private val movieOverviews = arrayOf("As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
        "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
        "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
        "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
        "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.")

    private val movieReleaseYears = arrayOf("2019",
        "2018",
        "2018",
        "2018",
        "2018",
        "2018",
        "2019",
        "2018",
        "2019",
        "2018")

    private val movieGenres = arrayOf("Animation, Family, Adventure",
        "Family, Animation, Comedy, Adventure",
        "Adventure, Action, Thriller",
        "Action, Adventure, Animation, Science Fiction, Comedy",
        "Adventure, Action, Science Fiction",
        "Action, Adventure, Fantasy",
        "Action, Science Fiction, Adventure",
        "Adventure, Science Fiction",
        "Action, Crime, Thriller",
        "Adventure, Fantasy, Drama")


    private val movieDurations = arrayOf("1h 44m",
        "1h 52m",
        "1h 56m",
        "1h 57m",
        "2h 29m",
        "2h 23m",
        "2h 2m",
        "2h 9m",
        "1h 59m",
        "2h 14m")

    val listMovieData: ArrayList<MovieEntity>
        get() {
            val list = arrayListOf<MovieEntity>()
            for (position in moviePosters.indices) {
                val movie = MovieEntity()
                movie.poster = moviePosters[position]
                movie.title = movieTitles[position]
                movie.quote = movieQuotes[position]
                movie.overview = movieOverviews[position]
                movie.releaseYear = movieReleaseYears[position]
                movie.genre = movieGenres[position]
                movie.duration = movieDurations[position]
                movie.status = "Released"
                movie.originalLanguage = "English"
                list.add(movie)
            }
            return list
        }
}