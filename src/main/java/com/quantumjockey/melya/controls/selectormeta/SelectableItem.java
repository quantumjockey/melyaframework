package com.quantumjockey.melya.controls.selectormeta;

public class SelectableItem<T> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private T content;
    private String tag;

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public T getContent(){
        return this.content;
    }

    public String getTag(){
        return this.tag;
    }

    /////////// Constructor(s) //////////////////////////////////////////////////////////////

    public SelectableItem(T content, String tag){
        this.content = content;
        this.tag = tag;
    }

}
