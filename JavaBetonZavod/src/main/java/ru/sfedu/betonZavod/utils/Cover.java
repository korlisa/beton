package ru.sfedu.betonZavod.utils;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Lists")
public class Cover<T> {

    @ElementList(inline = true, required = false)
    public List<T> list;

    public Cover() {}
    public Cover(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
