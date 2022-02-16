package com.epam.esm.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class GiftCertificate {
    private String name;

    private String description;

    private float price;

    private int duration;

    private final String createDate;

    private String lastUpdateDate;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    private Set<Tag> tags = new HashSet<>();

    //Configuring DateFormat
    static
    {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    //No-param constructor
    public GiftCertificate() {
        createDate = DATE_FORMAT.format(new Date());
        lastUpdateDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public GiftCertificate(String name, String description, float price, int duration) {
        createDate = DATE_FORMAT.format(new Date());
        lastUpdateDate = createDate;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
