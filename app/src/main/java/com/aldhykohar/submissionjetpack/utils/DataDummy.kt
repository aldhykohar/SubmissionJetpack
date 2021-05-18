package com.aldhykohar.submissionjetpack.utils

import com.aldhykohar.submissionjetpack.R
import com.aldhykohar.submissionjetpack.data.model.MoviesModel


/**
 * Created by aldhykohar on 5/2/2021.
 */
object DataDummy {
    fun generateDummyMovie(): List<MoviesModel> {

        val movies = ArrayList<MoviesModel>()

        movies.add(
            MoviesModel(
                "100", "Alita: Battle Angel",
                R.drawable.poster_alita,
                "7.2",
                "14/02/2019",
                "Aksi, Cerita Fiksi, Petualangan",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "2h 2m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "101",
                "Cold Pursuit",
                R.drawable.poster_cold_persuit,
                "5.7",
                "08/02/2019",
                "Aksi, Kejahatan, Cerita Seru",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "1h 59m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "102",
                "Fantastic Beast: Crimes Grindelwald",
                R.drawable.poster_crimes,
                "6.9",
                "16/11/2018",
                "Petualangan, Fantasi, Drama",
                "Gellert Grindelwald telah melarikan diri dari penjara dan telah mulai mengumpulkan pengikut ke tujuannya - meninggikan penyihir di atas semua makhluk non-magis. Satu-satunya yang bisa menghentikannya adalah penyihir yang pernah disebutnya sebagai sahabat terdekatnya, Albus Dumbledore. Namun, Dumbledore akan perlu mencari bantuan dari penyihir yang telah menggagalkan Grindelwald sebelumnya, mantan muridnya, Newt Scamander, yang setuju untuk membantu, tidak menyadari bahaya yang ada di depan. Garis-garis digambar saat cinta dan kesetiaan diuji, bahkan di antara teman-teman dan keluarga sejati, di dunia sihir yang semakin terbagi.",
                "2m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "103",
                "Glass",
                R.drawable.poster_glass,
                "6.7",
                "18/01/2019",
                "Cerita Seru, Drama, Cerita Fiksi",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2h 9m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "104",
                "Mary Queen of Scots",
                R.drawable.poster_marry_queen,
                "6.6",
                "21/12/2018",
                "Drama, Sejarah",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "2h 4m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "105",
                "Overlord",
                R.drawable.poster_overlord,
                "6.7",
                "09/11/2018",
                "Kengerian, Kejahatan, Cerita Fiksi",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "1h 50m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "106",
                "T34",
                R.drawable.poster_t34,
                "6.9",
                "01/01/2019",
                "Kejahatan, Aksi, Drama, Sejarah",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "2h 19m",
                "RU"
            )
        )
        movies.add(
            MoviesModel(
                "107",
                "Spider-Man: Into the Spider-Verse",
                R.drawable.poster_spiderman,
                "8.4",
                "14/12/2018",
                "Aksi, Petualangan, Animasi, Cerita Fiksi",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "1h 57m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "108",
                "Ralph Breaks the Internet",
                R.drawable.poster_ralph,
                "7.2",
                "21/11/2018",
                "Keluarga, Animasi, Komedi, Petualangan",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "1h 52m",
                "US"
            )
        )
        movies.add(
            MoviesModel(
                "109",
                "How to Train Your Dragon",
                R.drawable.poster_how_to_train,
                "7.8",
                "09/01/2019",
                "Animasi, Keluarga, Petualangan",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "1h 38m",
                "US"
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<MoviesModel> {

        val tvshow = ArrayList<MoviesModel>()

        tvshow.add(
            MoviesModel(
                "200",
                "Fairy Tail",
                R.drawable.poster_fairytail,
                "7.8",
                "2009",
                " Animasi, Komedi, Sci-fi",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "25m",
                "JPG"
            )
        )
        tvshow.add(
            MoviesModel(
                "201",
                "Dragon Ball GT",
                R.drawable.poster_dragon_ball,
                "7.7",
                "1996",
                "Animasi, Aksi, Sci-fi, Fantasy",
                "Ten years have passed since Goku left his friends and family to hone his skills. But Goku soon finds himself helpless against the mystical power of the Dragon Balls and an accidental wish made by the devious Emperor Pilaf. The wish; that Goku once again become a child! Goku, together with Trunks, and his own granddaughter Pan, blast off into the outer reaches of space in search of the mysterious Blackstar Dragon Balls. But these Dragon Balls have a fatal secret: if not collected within one year Earth will be destroyed.",
                "25m",
                "JPG"
            )
        )
        tvshow.add(
            MoviesModel(
                "202",
                "The Flash",
                R.drawable.poster_flash,
                "7.7",
                "2014",
                "Drama, Sci-fi, Fantasy",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                "44m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "203",
                "Arrow",
                R.drawable.poster_arrow,
                "6.6",
                "2012",
                "Kejahatan, Misteri, Aksi",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "42m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "204",
                "Gotham",
                R.drawable.poster_gotham,
                "7.5",
                "2014",
                "Drama, Kejahatan, Sci-fi",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "43m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "205",
                "Naruto Shippuden",
                R.drawable.poster_naruto_shipudden,
                "8.6",
                "2007",
                "Animasi, Aksi, Petualangan",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "25m",
                "JPG"
            )
        )
        tvshow.add(
            MoviesModel(
                "206",
                "NCIS",
                R.drawable.poster_ncis,
                "7.4",
                "2003",
                "Kejahatan, Aksi, Petualangan",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "45m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "207",
                "The Walking Dead",
                R.drawable.poster_the_walking_dead,
                "8.1",
                "2010",
                "Aksi, Petualangan, Drama",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "42m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "208",
                "Supernatural",
                R.drawable.poster_supernatural,
                "8.2",
                "2005",
                "Drama, Misteri, Sci-fi",
                "Dua bersaudara mencari ayah mereka yang hilang, pria yang melatih mereka untuk menjadi prajurit melawan kejahatan supernatural",
                "45m",
                "US"
            )
        )
        tvshow.add(
            MoviesModel(
                "209",
                "Greys Anatomy",
                R.drawable.poster_grey_anatomy,
                "8.2",
                "2005",
                "Drama",
                "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                "43m",
                "US"
            )
        )

        return tvshow
    }

}