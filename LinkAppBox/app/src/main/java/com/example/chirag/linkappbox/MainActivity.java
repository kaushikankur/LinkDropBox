package com.example.chirag.linkappbox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dropbox.chooser.android.DbxChooser;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxIOException;
import com.dropbox.client2.session.AppKeyPair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static private String APP_KEY = "4ij45a56ql5szmq";
    final static private String APP_SECRET = "q5785yx33sgkkko";
    static final int DBX_CHOOSER_REQUEST = 0;
    private DropboxAPI<AndroidAuthSession> mDBApi=null;
    //private DbxChooser mChooser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mChooser = new DbxChooser(APP_KEY);
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        mDBApi.getSession().startOAuth2Authentication(MainActivity.this);

        Button demodrop=(Button)findViewById(R.id.mybutton);
        final EditText mEdit   = (EditText)findViewById(R.id.filename);

        demodrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                String text = mEdit.getText().toString();
                int duration = Toast.LENGTH_SHORT;
                Log.i("main", "ankky is here");
             // mChooser.forResultType(DbxChooser.ResultType.PREVIEW_LINK).launch(MainActivity.this, DBX_CHOOSER_REQUEST);
                //FileOutputStream outputStream = null;
                //for(result){
                  //  Log.d("main", "Link to selected file: " + result.getLink());
                //}

               // String path = getApplicationContext().getFilesDir() + "";
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Log.i("main", "ankky is here");

            }



    });
}

    protected void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();

            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }
}
