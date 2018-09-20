package com.example.admin.helloworld.api;

import com.example.admin.helloworld.model.Channel;

/**
 * Created by admin on 2018-09-20.
 */

public abstract class BaseSiteApi {
    public abstract void onGetChannelAlbum(Channel channel,int pageNo,int pageSize,OnGetChannelAlbumListener listener);
}
