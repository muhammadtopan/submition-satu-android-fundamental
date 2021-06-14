package id.topan.administrasisistemjaringan

import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class VideoPageActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    var item = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_page)

        AndroidNetworking.initialize(this)

        val yt_pv: YouTubePlayerView = findViewById(R.id.yt_pv)
        yt_pv.initialize(getString(R.string.GOOGLE_API_KEY), this)
        item = intent.getStringExtra("link") as Nothing?

    }


    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
//        showShortToast("Youtube Api Initialization Success")

        getVideo(wasRestored, player)

    }

    private fun getVideo(wasRestored: Boolean, player: YouTubePlayer?) {

            if (!wasRestored) {
                player?.cueVideo(
                    item
                )
            }

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }


}