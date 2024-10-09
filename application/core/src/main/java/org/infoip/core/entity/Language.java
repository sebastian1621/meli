package org.infoip.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("native")
    private String nativeName;

    public Language() {}

    public Language(String code, String name, String nativeName) {
        this.code = code;
        this.name = name;
        this.nativeName = nativeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
}
