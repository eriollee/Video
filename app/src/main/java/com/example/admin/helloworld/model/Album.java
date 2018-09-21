package com.example.admin.helloworld.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.admin.helloworld.AppManager;

/**
 * Created by admin on 2018-09-20.
 */

public class Album implements Parcelable {
    private String albumId;
    private int videoTotal;
    private String title;
    private String subTitle;
    private String director;
    private String mainActor;
    private String verImgUrl;
    private String horImgUrl;
    private String albumDesc;
    private Site site;
    private String tip ;
    private boolean isCompleted;
    private String letvStyle;
    private Context context;

    public Album(int siteId,Context cxt){
        site = new Site(siteId,cxt);
        context = cxt;
    }

    protected Album(Parcel in) {
        this.albumId = in.readString();
        this.videoTotal = in.readInt();
        this.title = in.readString();
        this.subTitle = in.readString();
        this.director = in.readString();
        this.mainActor = in.readString();
        this.verImgUrl = in.readString();
        this.horImgUrl = in.readString();
        this.albumDesc = in.readString();
        this.tip = in.readString();
        this.site = new Site(in.readInt(),context);
        this.isCompleted = in.readByte() !=0;
        this.letvStyle = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(albumId);
        dest.writeInt(videoTotal);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(director);
        dest.writeString(mainActor);
        dest.writeString(verImgUrl);
        dest.writeString(horImgUrl);
        dest.writeString(albumDesc);
        dest.writeString(tip);
        dest.writeByte((byte)(isCompleted ? 1:0));
        dest.writeString(letvStyle);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String toJson(){
        String ret = AppManager.getGson().toJson(this);
        return ret;
    }

    public Album fromJson(String json){
        Album album = AppManager.getGson().fromJson(json,Album.class);
        return album;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", videoTotal=" + videoTotal +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", director='" + director + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", verImgUrl='" + verImgUrl + '\'' +
                ", horImgUrl='" + horImgUrl + '\'' +
                ", albumDesc='" + albumDesc + '\'' +
                ", site=" + site +
                ", tip='" + tip + '\'' +
                ", isCompleted=" + isCompleted +
                ", letvStyle='" + letvStyle + '\'' +
                ", context=" + context +
                '}';
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getVideoTotal() {
        return videoTotal;
    }

    public void setVideoTotal(int videoTotal) {
        this.videoTotal = videoTotal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getVerImgUrl() {
        return verImgUrl;
    }

    public void setVerImgUrl(String verImgUrl) {
        this.verImgUrl = verImgUrl;
    }

    public String getHorImgUrl() {
        return horImgUrl;
    }

    public void setHorImgUrl(String horImgUrl) {
        this.horImgUrl = horImgUrl;
    }

    public String getAlbumDesc() {
        return albumDesc;
    }

    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getLetvStyle() {
        return letvStyle;
    }

    public void setLetvStyle(String letvStyle) {
        this.letvStyle = letvStyle;
    }
}
