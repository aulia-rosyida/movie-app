package com.dicoding.auliarosyida.moviesapp.utils

import com.dicoding.auliarosyida.moviesapp.R
import com.dicoding.auliarosyida.moviesapp.model.MovieEntity
import com.dicoding.auliarosyida.moviesapp.model.source.remotesource.response.MovieResponse

object DataMovies {

    private val movieId = arrayOf("m1",
            "m2",
            "m3",
            "m4",
            "m5",
            "m6",
            "m7",
            "m8",
            "m9",
            "m10")

    private val moviePosters = arrayOf("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h5XilerWmJbM5kiBtWML8vvHbkH.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3cZn1k8x0bikrDKEy9ZKJ6Vdj30.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vEj13Ro7d2qjgeHI0eyqb7wMjvO.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u5QrKhSCGoFsB8aAvZZJ1b53k16.jpg")

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

    fun generateMovies(): List<MovieResponse> {

        val listMovieData = ArrayList<MovieResponse>()

        for (position in moviePosters.indices) {
            val movie = MovieResponse()
            movie.id = movieId[position]
            movie.poster = moviePosters[position]
            movie.title = movieTitles[position]
            movie.quote = movieQuotes[position]
            movie.overview = movieOverviews[position]
            movie.releaseYear = movieReleaseYears[position]
            movie.genre = movieGenres[position]
            movie.duration = movieDurations[position]
            movie.status = "Released"
            movie.originalLanguage = "English"
            listMovieData.add(movie)
        }
            return listMovieData
    }

    private val tvShowId = arrayOf("t1",
            "t2",
            "t3",
            "t4",
            "t5",
            "t6",
            "t7",
            "t8",
            "t9",
            "t10")

    private val tvShowPosters = arrayOf(
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uYHdIs5O8tiU5p6MvUPd2jElOH6.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mgOZSS2FFIGtfVeac1buBw3Cx5w.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gskv297rlbyzLaTU1XZf8UBbxp0.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zfOb5lRt9SekVyl0gLfrXikQfxn.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg")

    private val tvShowTitles = arrayOf("Naruto Shippūden",
        "Fairy Tail",
        "The Simpsons",
        "The Umbrella Academy",
        "Grey's Anatomy",
        "Gotham",
        "Riverdale",
        "Arrow",
        "Doom Patrol",
        "Marvel's Iron Fist")

    private val tvShowQuotes = arrayOf("Naruto Shippūden",
        "Fairy Tail",
        "On your marks, get set, d'oh!",
        "Super. Dysfunctional. Family.",
        "The life you save may be your own.",
        "Before Batman, there was Gotham.",
        "Small town. Big secrets.",
        "Heroes fall. Legends rise.",
        "Doom Patrol",
        "Marvel's Iron Fist")

    private val tvShowOverviews = arrayOf("Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
        "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.")

    private val tvShowReleaseYears = arrayOf("2007",
        "2009",
        "1989",
        "2019",
        "2005",
        "2014",
        "2017",
        "2012",
        "2019",
        "2017")

    private val tvShowGenres = arrayOf("Animation, Action & Adventure, Sci-Fi & Fantasy",
        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
        "Family, Animation, Comedy",
        "Action & Adventure, Sci-Fi & Fantasy, Drama",
        "Drama",
        "Drama, Crime, Sci-Fi & Fantasy",
        "Mystery, Drama, Crime",
        "Crime, Drama, Mystery, Action & Adventure",
        "Sci-Fi & Fantasy, Comedy, Drama",
        "Action & Adventure, Drama, Sci-Fi & Fantasy")

    private val tvShowDurations = arrayOf("25m",
        "25m",
        "22m",
        "55m",
        "43m",
        "43m",
        "45m",
        "42m",
        "49m",
        "55m")

    private val tvShowStatus = arrayOf("Ended",
        "Ended",
        "Returning Series",
        "Returning Series",
        "Returning Series",
        "Ended",
        "Returning Series",
        "Ended",
        "Returning Series",
        "Canceled")

    private val tvShowOriginalLanguages = arrayOf("Japanese",
        "Japanese",
        "English",
        "English",
        "English",
        "English",
        "English",
        "English",
        "English",
        "English")

    fun generateTvShows(): List<MovieResponse> {
        val listTvShowData = ArrayList<MovieResponse>()
        for (position in tvShowPosters.indices) {
            val tvshow = MovieResponse()
            tvshow.id = tvShowId[position]
            tvshow.poster = tvShowPosters[position]
            tvshow.title = tvShowTitles[position]
            tvshow.quote = tvShowQuotes[position]
            tvshow.overview = tvShowOverviews[position]
            tvshow.releaseYear = tvShowReleaseYears[position]
            tvshow.genre = tvShowGenres[position]
            tvshow.duration = tvShowDurations[position]
            tvshow.status = tvShowStatus[position]
            tvshow.originalLanguage = tvShowOriginalLanguages[position]
            listTvShowData.add(tvshow)
        }
        return listTvShowData
    }
}