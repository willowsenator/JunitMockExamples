package com.willow.customMatcher;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class OSAssert extends AbstractAssert<OSAssert, OperatingSystem> {
    private OperatingSystem os;
    protected OSAssert(OperatingSystem os) {
        super(os, OSAssert.class);
        this.os = os;
    }

    public static OSAssert assertThat(OperatingSystem os){
        return new OSAssert(os);
    }

    public OSAssert is128bit(){
        Assertions.assertThat(os.getNbOfBits()).as("128 bit").isEqualTo(128);
        return this;
    }

    public OSAssert wasReleaseIn(int year){
        Assertions.assertThat(os.getReleaseYear()).as("Release").isEqualTo(year);
        return this;
    }

    public OSAssert hasVersion(String version){
        Assertions.assertThat(os.getVersion()).as("Version").isEqualTo(version);
        return this;
    }

    public OSAssert hasName(String name){
        isNotNull();
        Assertions.assertThat(os.getName()).as("Name").isEqualTo(name);
        return this;
    }

}
