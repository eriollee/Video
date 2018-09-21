package com.example.admin.helloworld.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by admin on 2018-09-21.
 */

public class AlbumList extends ArrayList<Album> {

    private static final String TAG = AlbumList.class.getSimpleName();

    public void debug(){
        for(Album a : this){
            Log.d(TAG,">> albumlist "+a.toString());
        }
    }
}
