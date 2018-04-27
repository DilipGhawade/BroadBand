package com.broadband.www.broadband;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.broadband.www.broadband.Util.Utils;

public class SplashActivity extends AppCompatActivity {
  ImageView img;
  Thread splash_Thread;
  LinearLayout layout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    img = findViewById(R.id.splash_img);
    img.setScaleType(ImageView.ScaleType.FIT_XY);
    layout = findViewById(R.id.lin_layout);

    Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
    anim.reset();
    layout.clearAnimation();
    layout.startAnimation(anim);

    anim = AnimationUtils.loadAnimation(this,R.anim.translate);
    anim.reset();
    img.clearAnimation();
    img.startAnimation(anim);

    splash_Thread = new Thread()
    {
      @Override
      public void run() {
        try {
          int waited = 0;
          // Splash screen pause time
          while (waited < 3500) {
            sleep(100);
            waited += 100;
          }
          if (Utils.isConnectedToInternet(SplashActivity.this)) {
            Intent intent = new Intent(SplashActivity.this,
              MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            SplashActivity.this.finish();
          }
          else
          {
            Intent i = new Intent(SplashActivity.this,ConnectionFailedActivity.class);
            startActivity(i);
            finish();
          }
        } catch (InterruptedException e) {
          // do nothing
        } finally {
          SplashActivity.this.finish();
        }
      }
    };
    splash_Thread.start();

  }
}
