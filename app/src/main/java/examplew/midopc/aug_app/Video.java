package examplew.midopc.aug_app;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView vid=(VideoView)findViewById(R.id.vid);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.screenBrightness=1.0f;
        getWindow().setAttributes(lp);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        String uri="android.resource://examplew.midopc.aug_app/raw/vi";
        Uri uri1=Uri.parse(uri);
        vid.setVideoURI(uri1);
        vid.setMediaController(new MediaController(this));
        vid.requestFocus();

        vid.start();
    }

}
