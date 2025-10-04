package com.protocomplete.etamagotchi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity {

    RenderView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create RenderView programmatically to guarantee it renders
        view = new RenderView(this);
        setContentView(view);

        // Add buttons programmatically (optional) or via XML
        // Example if using XML: R.id.feedButton, R.id.careButton, etc.
        // Make sure you call view.feedMonster() and view.careMonster() on click
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }
}