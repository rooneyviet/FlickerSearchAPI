package jp.ventures.stv.stv19skilltest2018_flicker.Model.Object;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("isfamily")
    private String isfamily;

    @SerializedName("farm")
    private String farm;
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("ispublic")
    private String ispublic;
    @SerializedName("owner")
    private String owner;
    @SerializedName("secret")
    private String secret;
    @SerializedName("server")
    private String server;
    @SerializedName("isfriend")
    private String isfriend;

    public String getIsfamily ()
    {
        return isfamily;
    }

    public void setIsfamily (String isfamily)
    {
        this.isfamily = isfamily;
    }

    public String getFarm ()
    {
        return farm;
    }

    public void setFarm (String farm)
    {
        this.farm = farm;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getIspublic ()
    {
        return ispublic;
    }

    public void setIspublic (String ispublic)
    {
        this.ispublic = ispublic;
    }

    public String getOwner ()
    {
        return owner;
    }

    public void setOwner (String owner)
    {
        this.owner = owner;
    }

    public String getSecret ()
    {
        return secret;
    }

    public void setSecret (String secret)
    {
        this.secret = secret;
    }

    public String getServer ()
    {
        return server;
    }

    public void setServer (String server)
    {
        this.server = server;
    }

    public String getIsfriend ()
    {
        return isfriend;
    }

    public void setIsfriend (String isfriend)
    {
        this.isfriend = isfriend;
    }
}
