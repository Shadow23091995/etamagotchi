package com.protocomplete.etamagotchi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class RenderView extends SurfaceView {

    private Bitmap eggBitmap;
    private Bitmap monsterBitmap;
    private Paint paint = new Paint();
    private boolean isEgg = true;
    private int feedCount = 0;
    private int careCount = 0;
    private Handler handler = new Handler();

    public RenderView(Context context) {
        super(context);
        init();
    }

    public RenderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        eggBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.egg); // put egg.png in res/drawable
        monsterBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monster); // put monster.png in res/drawable

        // Simple auto-hatch after 30 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isEgg = false;
                invalidate(); // redraw to show monster
            }
        }, 30000); // 30 seconds
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (canvas == null) return;

        // Clear background
        canvas.drawRGB(255, 255, 255);

        // Draw egg or monster
        if (isEgg) {
            if (eggBitmap != null) {
                canvas.drawBitmap(eggBitmap, 100, 100, paint);
            }
        } else {
            if (monsterBitmap != null) {
                canvas.drawBitmap(monsterBitmap, 100, 100, paint);
            }
        }

        // Draw simple feed/care status
        paint.setTextSize(40);
        paint.setARGB(255, 0, 0, 0);
        canvas.drawText("Feed: " + feedCount, 50, 500, paint);
        canvas.drawText("Care: " + careCount, 50, 550, paint);
    }

    public boolean isEgg() {
        return isEgg;
    }

    public void feedMonster() {
        if (!isEgg) {
            feedCount++;
            invalidate();
        }
    }

    public void careMonster() {
        if (!isEgg) {
            careCount++;
            invalidate();
        }
    }

    public void hostBattle() {
        // Placeholder: implement network battle
    }

    public void joinBattle(String ip) {
        // Placeholder: implement network battle
    }

    public void train() {
        // Placeholder: implement training
    }

    public String getStatusInfo() {
        return "Feed count: " + feedCount + "\nCare count: " + careCount +
                "\nState: " + (isEgg ? "Egg" : "Monster");
    }

    public void saveMonster() {
        // Placeholder: save persistent state
    }

    public void onResume() {
        invalidate(); // refresh when returning
    }

    public void onPause() {
        saveMonster();
    }

    public static String getLocalIpAddress() {
        // Keep your original code
        try {
            for (java.util.Enumeration<java.net.NetworkInterface> en = java.net.NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements(); ) {
                java.net.NetworkInterface intf = en.nextElement();
                for (java.util.Enumeration<java.net.InetAddress> enumIpAddr = intf.getInetAddresses();
                     enumIpAddr.hasMoreElements(); ) {
                    java.net.InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() &&
                            inetAddress.getAddress().length == 4) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}