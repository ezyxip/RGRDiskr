package com.ezyxip.graph;

import com.ezyxip.graph.menu.MenuItem;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class InputItem extends MenuItem {
    HashMap<String, Object> context;
    public InputItem(HashMap<String, Object> context){
        super("Установка файла с вводимыми значениями (по умолчанию - input.txt)");
        addJob(this::exec);
        this.context = context;
    }

    void exec(){
        System.out.print("Введите путь до файла: ");
        String input = new Scanner(System.in).nextLine();
        File inputFile = new File(input);
        if(!inputFile.exists()) throw new RuntimeException("Нет доступа к файлу");
        context.put("input", inputFile);
    }
}
