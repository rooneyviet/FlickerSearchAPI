package jp.ventures.stv.stv19skilltest2018_flicker.Model.Object;

import com.google.gson.annotations.SerializedName;

public class Photos {
    @SerializedName("total")
    private String total;

    @SerializedName("page")
    private String page;

    @SerializedName("pages")
    private String pages;

    @SerializedName("photo")
    private Photo[] photo;

    @SerializedName("perpage")
    private String perpage;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getPages ()
    {
        return pages;
    }

    public void setPages (String pages)
    {
        this.pages = pages;
    }

    public Photo[] getPhoto ()
    {
        return photo;
    }

    public void setPhoto (Photo[] photo)
    {
        this.photo = photo;
    }

    public String getPerpage ()
    {
        return perpage;
    }

    public void setPerpage (String perpage)
    {
        this.perpage = perpage;
    }
}
