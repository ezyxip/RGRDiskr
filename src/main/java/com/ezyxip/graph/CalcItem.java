package com.ezyxip.graph;

import com.ezyxip.graph.menu.MenuItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            int res = algorithm.getDiameter();
            System.out.printf("Ответ - %d\n", res);
            if(!output.exists()) {
                boolean isCreate = output.createNewFile();
                if(!isCreate) throw new RuntimeException("Не удаётся создать файл для записи ответа");
            }
            try(FileWriter writer = new FileWriter(output)){
                writer.write(String.valueOf(res));
                System.out.println("Ответ записан в файл");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
