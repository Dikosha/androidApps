package com.example.lab3ex2;

public class Item {
    private int image;
    private String name;
    private String sibling;

    public Item(int image, String name, String sibling){
        this.image = image;
        this.name = name;
        this.sibling = sibling;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSibling() {
        return sibling;
    }
}
