package com.example.map.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutSchoolListModel {
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Detail")
    @Expose
    private String detail;
    private final static long serialVersionUID = 8706932075597762243L;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
