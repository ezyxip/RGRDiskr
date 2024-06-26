package com.ezyxip.graph;

import com.ezyxip.graph.menu.MenuItem;

public class AboutItem  extends MenuItem {
    public AboutItem() {
        super("Описание программы");
        addJob(this::exec);
    }

    public void exec(){
        System.out.println("""
                            Дан ориентированный взвешенный граф, рёбрам которого приписаны некоторые неотрицательные веса (длины).
                            Требуется найти две вершины, кратчайший путь между которыми имеет наибольшую длину.
                            Формат входных данных
                            В первой строке входного файла задано число вершин N (3 ≤ N ≤ 50). Далее идёт матрица смежности графа, то есть N строк, в каждой из которых записано N чисел. j-ое число в i-ой строке матрицы смежности задает длину ребра, ведущего из i-й вершину в j-ую. Длины могут принимать любые значения от от 0 до 106. Гарантируется, что на главной диагонали матрицы стоят нули.
                            Формат выходных данных
                            В выходной файл выведите одно число – длину искомого пути."""
        );
    }
}
