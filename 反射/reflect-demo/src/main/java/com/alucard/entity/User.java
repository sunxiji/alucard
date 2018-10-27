package com.alucard.entity;

import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 9:38 2018/10/27
 */
public class User {
    private Integer id;
    private String name;
    private List<Item> itemList;

    public User() {
    }

    public User(Integer id, String name, List<Item> itemList) {
        this.id = id;
        this.name = name;
        this.itemList = itemList;
    }

    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}

class Item{
    private Integer itemId;

    private String itemName;

    public Item() {
    }

    public Item(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
