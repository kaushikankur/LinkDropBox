package com.example.chirag.linkappbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxIOException;

/**
 * Created by Chirag on 22-04-2016.
 */
public class ListFiles extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        DropboxAPI<AndroidAuthSession> mDBApi = (DropboxAPI<AndroidAuthSession>)i.getSerializableExtra("sampleObject");
        try {
            DropboxAPI.Account existingEntry = mDBApi.accountInfo();
            Log.i("chal ja dada", "kfbkafhkaf" + existingEntry.displayName);
            // do stuff with the Entry
        } catch (DropboxIOException e) {
            Log.i("Something went wrong1: " ,"vhgcgcvgccc");
        } catch (DropboxException e) {
            Log.i("Something went wrong2: " ,"vhgvgvgvjjjjj");
        }

    }
}
