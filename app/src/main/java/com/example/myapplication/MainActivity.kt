package com.example.myapplication


import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private var res = 0
    private var listOfCountVar = ArrayList<Int>()
    private lateinit var binding: ActivityMainBinding
    private  val adapter = VariantAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 4)
            rcView.adapter = adapter
        }
      calcul()
     init()

  }

    private fun init() = with(binding){


                btTx.setOnClickListener {
                resultTx.text = res.toString()
                resultTx.visibility = View.VISIBLE
                saluteSw.visibility = View.VISIBLE
                playSound()
            }



            btVar.setOnClickListener{
                val counter = Variant(R.drawable.zvezda, listOfCountVar[0])
                adapter.addCount(counter)
                val counter1 = Variant(R.drawable.zvezda, listOfCountVar[1])
                adapter.addCount(counter1)
                val counter2 = Variant(R.drawable.zvezda, listOfCountVar[2])
                adapter.addCount(counter2)
                val counter3 = Variant(R.drawable.zvezda, listOfCountVar[3])
                adapter.addCount(counter3)


            }
            btReload.setOnClickListener {
                val counter = Variant(R.drawable.zvezda, listOfCountVar[0])
             //   adapter.addCount(counter)
                val counter1 = Variant(R.drawable.zvezda, listOfCountVar[1])
              //  adapter.addCount(counter1)
                val counter2 = Variant(R.drawable.zvezda, listOfCountVar[2])
             //   adapter.addCount(counter2)
                val counter3 = Variant(R.drawable.zvezda, listOfCountVar[3])
             //   adapter.addCount(counter3)
                resultTx.text = ""
                saluteSw.visibility = View.GONE
                adapter.clearCount(counter)
                adapter.clearCount(counter1)
                adapter.clearCount(counter2)
                adapter.clearCount(counter3)


                listOfCountVar.clear()
              calcul()
           stopSound()
            }
        }




fun calcul() {
        var rnds1 = (0..10).random()
        var rnds2 = (0..10).random()
        res = rnds1 * rnds2
        binding.oneTx.text = rnds1.toString()
        binding.twoTx.text = rnds2.toString()
  listOfCountVar.add(res)
    listOfCountVar.add(res+2)
    listOfCountVar.add(res+10)
    listOfCountVar.add(res+1)
         var variableCount = (0..3).random()
          listOfCountVar[variableCount] = res
          when (variableCount) {
              0 -> {
                  listOfCountVar[1] = res+10
                  listOfCountVar[2] = res+1
                  listOfCountVar[3] = res+5
              }
              1 -> {
                  listOfCountVar[0] = res+3
                  listOfCountVar[2] = res+2
                  listOfCountVar[3] = res+1
              }
              2 -> {
                  listOfCountVar[1] = res+5
                  listOfCountVar[0] = res+1
                  listOfCountVar[3] = res+4
              }
              3 -> {
                  listOfCountVar[2] = res+16
                  listOfCountVar[1] = res + 2
                  listOfCountVar[0] = res + 7
              }
          }
    }
    // 1. Plays the sound
    fun playSound() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.sound)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }

    // 3. Stops playback
    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
   //  4. Destroys the MediaPlayer instance when the app is closed
        override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

}
