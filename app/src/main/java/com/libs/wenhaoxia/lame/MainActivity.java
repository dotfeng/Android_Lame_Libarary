package com.libs.wenhaoxia.lame;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBindViews();
        final LameLib l = new LameLib(new LameLib.Callback() {
            @Override
            public void onStart() {

            }

            @Override
            public void onProgressChange(long progress, long total) {

            }

            @Override
            public void onError(int errorCode, String errorMessage) {

            }

            @Override
            public void onFinished() {

            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File wavFile = new File(Environment.getExternalStorageDirectory(), "testcase.wav");
                File mp3File = new File(Environment.getExternalStorageDirectory(), "testcase.mp3");

                if (wavFile.exists()) {
                    l.convertWav2Mp3(wavFile.getPath(), mp3File.getPath());
                }

            }
        });

        convertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, l.version(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void onBindViews() {
        convertButton = (Button) findViewById(R.id.btn_center);
    }

}
