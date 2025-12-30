package com.skillnext1;
import java.util.*;

public class InventoryList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> inventory = new ArrayList<>();
        System.out.println("Enter items (type 'done' to finish):");
        while(true){
            String item = sc.nextLine();
            if(item.equalsIgnoreCase("done")) break;
            inventory.add(item);
        }
        System.out.println("Inventory List:");
        for(String i : inventory) System.out.println("- " + i);
        sc.close();
    }
}
