package ru.toywar.homework.models;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class News {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("text")
    private String text;

    @SerializedName("publicationDate")
    private Map<String, Long> date;

    @SerializedName("bankInfoTypeId")
    private Integer bankTypeID;

    public News() {

    }

    public News(Integer id, String name, String text, Map<String, Long> date, Integer bankTypeID) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.bankTypeID = bankTypeID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Map<String, Long> getDate() {
        return date;
    }

    public Integer getBankTypeID() {
        return bankTypeID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Map<String, Long> date) {
        this.date = date;
    }

    public void setBankTypeID(Integer bankTypeID) {
        this.bankTypeID = bankTypeID;
    }
}