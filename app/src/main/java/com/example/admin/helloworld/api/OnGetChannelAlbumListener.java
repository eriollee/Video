package com.example.admin.helloworld.api;

import com.example.admin.helloworld.model.AlbumList;
import com.example.admin.helloworld.model.ErrorInfo;

/**
 * Created by admin on 2018-09-20.
 */

public interface OnGetChannelAlbumListener {

      void onGetChannelAlbumSuccess(AlbumList albumList);
      void onGetChannelAlbumFailed(ErrorInfo info);
}
