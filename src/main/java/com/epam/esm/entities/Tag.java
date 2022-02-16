package com.epam.esm.entities;

import java.util.HashSet;
import java.util.Set;

public class Tag {

    private int id;

    private String name;

    private Set<GiftCertificate> giftCertificates = new HashSet<>();

    public Set<GiftCertificate> getGiftCertificates() {
        return giftCertificates;
    }

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
