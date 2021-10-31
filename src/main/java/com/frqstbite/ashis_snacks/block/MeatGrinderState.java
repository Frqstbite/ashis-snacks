package com.frqstbite.ashis_snacks.block;

import net.minecraft.util.StringRepresentable;

public enum MeatGrinderState implements StringRepresentable {
    EMPTY("empty"),
    BUCKET("bucket"),
    FILLED("filled");

    private final String name;

    MeatGrinderState(String name) {
        this.name = name;
    }

    public String getSerializedName() { return this.name; }
}
