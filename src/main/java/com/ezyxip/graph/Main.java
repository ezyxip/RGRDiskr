package com.ezyxip.graph;

import com.ezyxip.graph.menu.ConsoleMenu;
import com.ezyxip.graph.menu.MenuItem;

import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object> context = new HashMap<>();
        File input = new File("input.txt");
        File output = new File("output.txt");
        context.put("input", input);
        context.put("output", output);
        if(!input.exists()){
            System.out.println("Внимание! Файл для ввода по умолчанию (input.txt) не найден!");
        }

        System.out.println("Введите help для получения справки");
        ConsoleMenu menu = new ConsoleMenu("graph::>");
        menu.add("author", new MenuItem("Об авторе", ()->
                System.out.println("Anton Zejdler, FIT-231")
        ));
        menu.add("about", new AboutItem());
        menu.add("input", new InputItem(context));
        menu.add("output", new OutputItem(context));
        menu.add("calc", new CalcItem(context));
        menu.run();
    }
}