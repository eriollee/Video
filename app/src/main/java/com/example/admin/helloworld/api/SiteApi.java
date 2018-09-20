package com.example.admin.helloworld.api;

import android.content.Context;

import com.example.admin.helloworld.model.Channel;
import com.example.admin.helloworld.model.Site;

/**
 * Created by admin on 2018-09-20.
 */

public class SiteApi {
    public void onGetChannelAlbums(Context context, int pageNo, int pageSize, int siteId, int channelId, OnGetChannelAlbumListener listener){
        switch (siteId){
            case Site.LETV:
                new LetvApi().onGetChannelAlbum(new Channel(channelId,context),pageNo,pageSize,listener);
                break;
            case Site.SOHU:
                new SohuApi().onGetChannelAlbum(new Channel(channelId,context),pageNo,pageSize,listener);
                break;
        }
    };
}

