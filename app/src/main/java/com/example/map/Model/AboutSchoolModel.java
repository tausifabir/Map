package com.example.map.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AboutSchoolModel {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_report")
    @Expose
    private String errorReport;
    @SerializedName("menu")
    @Expose
    private List<AboutSchoolListModel> menu = null;
    private final static long serialVersionUID = 2062952793201599761L;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<AboutSchoolListModel> getSchoolAbout() {
        return menu;
    }

    public void setMenu(List<AboutSchoolListModel> menu) {
        this.menu = menu;
    }
}
