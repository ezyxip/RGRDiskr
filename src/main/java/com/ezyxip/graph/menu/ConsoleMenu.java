package com.ezyxip.graph.menu;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleMenu{

    private final HashMap<String, MenuItem> items;
    public String welcome;

    public ConsoleMenu(String welcome){
        items = new HashMap<>();
        this.welcome = welcome;
        items.put("help", new MenuItem("Display help", this::help));
        items.put("exit", new MenuItem("Exit menu", ()->{}));
    }

    private void help(){
        for(var i : items.entrySet()){
            System.out.printf("%s\t\t-\t\t%s%n", i.getKey(), i.getValue().description);
        }
    }

    public void add(String key, MenuItem item){
        items.put(key, item);
    }

    public void run(){
        while(true){
            System.out.print(welcome);
            String command = new Scanner(System.in).nextLine().trim();
            if(command.equals("exit")){
                break;
            }
            if(items.containsKey(command)){
                try{
                    items.get(command).run();
                } catch (Exception e){
                    System.out.printf("Error! - [%s]\n", e);
                }
            } else {
                System.out.println("Command not found");
            }
        }
    }
}