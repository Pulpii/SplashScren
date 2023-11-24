package com.example.splashscreen;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class QuizSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView topLogo = (TextView) findViewById(R.id.TextViewTopTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        topLogo.startAnimation(fade1);

        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);

        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }

        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        fade2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(QuizSplashActivity.this,
                        MainActivity.class));
                QuizSplashActivity.this.finish();
            }

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        TextView topLogo = (TextView) findViewById(R.id.TextViewTopTitle);
        topLogo.clearAnimation();

        TextView bottomLogo = (TextView) findViewById(R.id.TextViewBottomTitle);
        bottomLogo.clearAnimation();

        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }
    }
}