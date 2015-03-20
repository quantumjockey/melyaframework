package com.quantumjockey.melya.controls.selectormeta;

import java.util.ArrayList;

public class SelectableLookup {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private ArrayList<SelectableCategory> categories;
    private ArrayList<SelectableItem> items;

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public ArrayList<SelectableCategory> getCategories(){
        return this.categories;
    }

    public ArrayList<SelectableItem> getItems(){
        return this.items;
    }

    /////////// Constructor(s) //////////////////////////////////////////////////////////////

    public SelectableLookup(){
        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // this object is a placeholder for an heirarchical dictionary - to represent a folder heirarchy and pockets of data
    // within it ...haven't figured out exactly how it will work yet

}
