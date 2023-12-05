package com.android.movieapp

class MoviesData {
    companion object {
        private val movieTitles = arrayOf(
            "Kimi wo Aishita Hitori no Boku e",
            "Boku ga Aishita Subete no Kimi e",
            "Shingeki no Kyojin",
            "Jujutsu Kaisen",
            "Kimetsu no Yaiba",
            "Spy x Family"
        )

        private val movieDescriptions = arrayOf(
            "With the divorce of his parents, seven-year-old Koyomi Hidaka makes the important decision to live with his father. As a researcher at the Japanese Institute of Virtual Science, Koyomi's father is involved in the investigation of the phenomenon of parallel worlds. Through his father's job, the young boy meets Shiori Satou, the daughter of another divorced researcher. Soon becoming friends, the two spend much of their childhood together.",
            "Koyomi Takasaki, who lives with his mother following his parents' divorce, enrolls in a local university prep school. Due to the atmosphere concentrated on studies and his social awkwardness, Koyomi is unable to make friends. One day, he is suddenly approached by his classmate Kazune Takigawa, who tells him that she has travelled from the 85th world where she and Koyomi are lovers.",
            "Centuries ago, mankind was slaughtered to near extinction by monstrous humanoid creatures called Titans, forcing humans to hide in fear behind enormous concentric walls. What makes these giants truly terrifying is that their taste for human flesh is not born out of hunger but what appears to be out of pleasure.",
            "Idly indulging in baseless paranormal activities with the Occult Club, high schooler Yuuji Itadori spends his days at either the clubroom or the hospital, where he visits his bedridden grandfather.",
            "Ever since the death of his father, the burden of supporting the family has fallen upon Tanjirou Kamado's shoulders. Though living impoverished on a remote mountain, the Kamado family are able to enjoy a relatively peaceful and happy life. One day, Tanjirou decides to go down to the local village to make a little money selling charcoal. On his way back, night falls, forcing Tanjirou to take shelter in the house of a strange man, who warns him of the existence of flesh-eating demons that lurk in the woods at night.",
            "Corrupt politicians, frenzied nationalists, and other warmongering forces constantly jeopardize the thin veneer of peace between neighboring countries Ostania and Westalis. In spite of their plots, renowned spy and master of disguise \"Twilight\" fulfills dangerous missions one after another in the hope that no child will have to experience the horrors of war.")

        private val moviePosterImages = intArrayOf(
            R.drawable.movie_1,
            R.drawable.movie_2,
            R.drawable.movie_3,
            R.drawable.movie_4,
            R.drawable.movie_5,
            R.drawable.movie_6
        )

        fun getMovies(): ArrayList<Movie> {
            val movies = ArrayList<Movie>()
            for (i in movieTitles.indices) {
                val movie = Movie()
                movie.setTitle(movieTitles[i])
                movie.setDescription(movieDescriptions[i])
                movie.setPosterImage(moviePosterImages[i])
                movies.add(movie)
            }
            return movies
        }
    }
}
