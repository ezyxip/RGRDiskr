package com.ezyxip.graph;

import com.ezyxip.graph.menu.MenuItem;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class OutputItem  extends MenuItem {
    HashMap<String, Object> context;
    public OutputItem(HashMap<String, Object> context){
        super("Установка выходного файла (по умолчанию output.txt");
        this.context = context;
        addJob(this::exec);
    }

    void exec(){
        System.out.print("Введите путь до файла: ");
        String output = new Scanner(System.in).nextLine();
        File inputFile = new File(output);
        if(!inputFile.exists()) throw new RuntimeException("Нет доступа к файлу");
        context.put("output", inputFile);
    }
}
