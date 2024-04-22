package com.ezyxip.graph;

import com.ezyxip.graph.menu.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CalcItem extends MenuItem {
    HashMap<String, Object> context;

    public CalcItem(HashMap<String, Object> context) {
        super("Вычислить кратчайший путь между вершинами, которыми имеет наибольшую длину");
        this.context = context;
        addJob(this::exec);
    }

    void exec(){
        File input = (File) context.get("input");
        File output = (File) context.get("output");
        if(!input.exists()) throw new RuntimeException("Не найдены файл для ввода");
        try {
            Scanner scanner = new Scanner(input);
            int countOfVertex = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[countOfVertex][];
            for(int i = 0; i < countOfVertex; i++){
                matrix[i] = new int[countOfVertex];
                String[] line = scanner.nextLine().split(" ");
                for(int j = 0; j < countOfVertex; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Algorithm algorithm = new Algorithm(matrix);
            System.out.println(algorithm.getDiameter());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
