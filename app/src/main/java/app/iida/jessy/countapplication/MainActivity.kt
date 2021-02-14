package app.iida.jessy.countapplication

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var mSoundPool : SoundPool
    private  lateinit var mSoundID :Array<Int?>

    private val mSoundResource = arrayOf(
        R.raw.donsound,
        R.raw.paasound
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //(R.layout.activity_main)


        //テキストボタンで文字を出す　https://liginc.co.jp/489910

        textView.text = ""

        donButton.setOnClickListener {

            textView.text = textView.text as String +  "ドン"

        }

        paaButton.setOnClickListener {

            textView.text = textView.text as String +  "パッ"

        }

        clear.setOnClickListener {

            textView.text = ""

        }

    }

    override fun onResume(){
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(mSoundResource.size)
            .build()

        mSoundID = arrayOfNulls(mSoundResource.size)

        for(i in 0..(mSoundResource.size - 1)){
            mSoundID[i] = mSoundPool.load(applicationContext,mSoundResource[i],0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mSoundPool.release()
    }

    fun don(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[0] as Int,1.0F,1.0F,0,0,1.0F)
        }

    }
    fun paaSound(view:View){
        if(mSoundID[1] != null){
            mSoundPool.play(mSoundID[1] as Int,1.0F,1.0F,0,0,1.0F)
        }
    }
}
