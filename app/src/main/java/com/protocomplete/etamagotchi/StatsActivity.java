package com.protocomplete.etamagotchi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class StatsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        TextView statsText = findViewById(R.id.statsText);
        Button backButton = findViewById(R.id.backButton);

        String data = getIntent().getStringExtra("data");

        if (data != null && !data.isEmpty()) {
            statsText.setText(data);
        } else {
            statsText.setText("No stats available yet.\n\nYour monster is just getting started!");
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}