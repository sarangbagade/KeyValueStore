package com.example;

import com.example.controller.StoreController;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static StoreController storeController;

    public static void main(String[] args) {
	// write your code here
        storeController = new StoreController();

        List<Pair<String, Object>> attrList = new ArrayList<>();
        attrList.add(new Pair<>("title", "SDE-Bootcamp"));
        attrList.add(new Pair<>("price", 30000.00D));
        attrList.add(new Pair<>("enrolled", false));
        System.out.println(storeController.keys());
        storeController.add("sde_bootcamp", attrList);

        System.out.println(storeController.get("sde_bootcamp"));
        System.out.println(storeController.keys());
        attrList = new ArrayList<>();
        attrList.add(new Pair<>("title", "SDE-Kickstart"));
        attrList.add(new Pair<>("price", 4000));
        attrList.add(new Pair<>("enrolled", true));
        attrList.add(new Pair<>("estimated_time", 8));
        storeController.add("sde_kickstart", attrList);

        System.out.println(storeController.get("sde_kickstart"));
        System.out.println(storeController.keys());

        attrList = new ArrayList<>();
        attrList.add(new Pair<>("title", "SDE-Kickstart"));
        attrList.add(new Pair<>("price", 3000));
        attrList.add(new Pair<>("enrolled", true));
        attrList.add(new Pair<>("estimated_time", 8));
        storeController.add("sde_kickstart", attrList);

        System.out.println(storeController.get("sde_kickstart"));
        System.out.println(storeController.keys());
        storeController.delete("sde_bootcamp");
        System.out.println(storeController.get("sde_bootcamp"));
        System.out.println(storeController.keys());
    }
}
