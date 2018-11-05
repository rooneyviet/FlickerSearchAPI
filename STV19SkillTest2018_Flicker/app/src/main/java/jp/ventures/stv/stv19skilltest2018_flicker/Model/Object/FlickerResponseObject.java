package jp.ventures.stv.stv19skilltest2018_flicker.Model.Object;

import com.google.gson.annotations.SerializedName;

public class FlickerResponseObject {

    @SerializedName("photos")
    private Photos photos;

    @SerializedName("stat")
    private String stat;

    public Photos getPhotos ()
    {
        return photos;
    }

    public void setPhotos (Photos photos)
    {
        this.photos = photos;
    }

    public String getStat ()
    {
        return stat;
    }

    public void setStat (String stat)
    {
        this.stat = stat;
    }
}
