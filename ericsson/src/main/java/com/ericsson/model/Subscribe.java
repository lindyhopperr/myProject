package com.ericsson.model;

public class Subscribe {
    private String id;
    private String name;
    private String msisdn;

    public Subscribe(String id, String name, String msisdn) {
        this.id = id;
        this.name = name;
        this.msisdn = msisdn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", msisdn='" + msisdn + '\''
                ;
    }
}
