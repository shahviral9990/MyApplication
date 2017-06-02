package com.example.vru.einvato.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awidiyadew on 15/09/16.
 */
public class CustomDataProvider {

    private static final int MAX_LEVELS = 3;

    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;

    private static List<BaseItem> mMenu = new ArrayList<>();

    public static List<BaseItem> getInitialItems() {
        //return getSubItems(new GroupItem("root"));

        List<BaseItem> rootMenu = new ArrayList<>();

        /*
        * ITEM = TANPA CHILD
        * GROUPITEM = DENGAN CHILD
        * */
        rootMenu.add(new Item("Home"));
        rootMenu.add(new Item("Sent Invites"));
        rootMenu.add(new GroupItem("Public"));
        rootMenu.add(new GroupItem("Private"));
        rootMenu.add(new Item("FAQ"));
        rootMenu.add(new Item("Terms & Conditions"));
        rootMenu.add(new Item("Settings"));
        rootMenu.add(new Item("Contact us"));
        return rootMenu;
    }

    public static List<BaseItem> getSubItems(BaseItem baseItem) {

        List<BaseItem> result = new ArrayList<>();
        int level = ((GroupItem) baseItem).getLevel() + 1;
        String menuItem = baseItem.getName();

        if (!(baseItem instanceof GroupItem)) {
            throw new IllegalArgumentException("GroupItem required");
        }

        GroupItem groupItem = (GroupItem)baseItem;
        if(groupItem.getLevel() >= MAX_LEVELS){
            return null;
        }

        /*
        * HANYA UNTUK GROUP-ITEM
        * */
        switch (level){
            case LEVEL_1 :
                switch (menuItem.toUpperCase()){
                    case "PUBLIC" :
                        result = getListPublic();
                        break;
                    case "PRIVATE" :
                        result = getListPrivate();
                        break;
                }
                break;


        }

        return result;
    }

    public static boolean isExpandable(BaseItem baseItem) {
        return baseItem instanceof GroupItem;
    }

    private static List<BaseItem> getListPublic(){

        List<BaseItem> list = new ArrayList<>();

        // Setiap membuat groupItem harus di set levelnya
        GroupItem groupItem = new GroupItem("GROUP 1");
        groupItem.setLevel(groupItem.getLevel() + 1);

        list.add(new Item("College Fests"));
        list.add(new Item("Inaugurations"));
        list.add(new Item("Festivals"));
        list.add(new Item("Parties"));
        list.add(new Item("Others"));


        return list;
    }

    private static List<BaseItem> getListPrivate(){

        List<BaseItem> list = new ArrayList<>();
        GroupItem groupItem = new GroupItem("GROUP X");
        groupItem.setLevel(groupItem.getLevel() + 1);

        list.add(new Item("Wedding Invites"));
        list.add(new Item("Birthday Invites"));
        list.add(new Item("Business Invites"));
        list.add(new Item("Family Functions"));
        return list;
    }



}
