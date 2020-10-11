package com.antondepoot.zzz.web;

public enum ViewName {
    HOME("home");

    private final String name;

    ViewName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
