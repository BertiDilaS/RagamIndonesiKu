package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LiveCycleTag";
    private static int splashInterval = 2000;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);

                this.finish();
            }

            private void finish() {


            }
        }, splashInterval);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);


    }
}

