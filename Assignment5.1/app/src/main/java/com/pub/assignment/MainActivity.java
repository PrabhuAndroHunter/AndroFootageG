package com.pub.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    private TextView mAnimTextTv;
    private Button mAnimButtonBtn;
    private Boolean animstarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAnimTextTv = (TextView) findViewById(R.id.textView_activitymain_animtext);
        mAnimButtonBtn = (Button) findViewById(R.id.button_activitymain_animbtn);

        mAnimButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animstarted) {
                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blinking_animation);
                    mAnimTextTv.startAnimation(startAnimation);
                    animstarted = true;
                    mAnimButtonBtn.setText("Stop Animation");
                    Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_SHORT).show();
                    mAnimButtonBtn.setTextColor(0xFFE10F0F);
                } else {
                    mAnimTextTv.clearAnimation();
                    animstarted = false;
                    mAnimButtonBtn.setText("Start Animation");
                    Toast.makeText(MainActivity.this, "Animation Stoped", Toast.LENGTH_SHORT).show();
                    mAnimButtonBtn.setTextColor(0xFF187B09);
                }
            }
        });
    }
}
