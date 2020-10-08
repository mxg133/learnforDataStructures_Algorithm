package _10horse.my;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 孟享广
 * @date 2020-10-08 1:44 下午
 * @description
 */
public class HorseChessboard {
    public static void main(String[] args) {
        X = Y = 8;
        int row = 1;
        int colum = 1;
        int cheseboard[][] = new int[X][Y];

        visited = new boolean[X * Y];

        long l1 = System.currentTimeMillis();
        traversalCheseboard(cheseboard, row - 1, colum - 1, 1);
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1 + " ms");

        for (int arr[]: cheseboard) {
            for (int step: arr) {
                System.out.println(step + "\t");
            }
            System.out.println();
        }

    }

    private static int X;//列数
    private static int Y;//行数

    private static boolean visited[];
    private static boolean finished;

    public static void traversalCheseboard(int cheseboard[][], int row, int column, int step) {
        cheseboard[row][column] = step;
        visited[row * X + column] = true;//开始位置
        ArrayList<Point> ps = next(new Point(column, row));

        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                traversalCheseboard(cheseboard, p.y, p.x, step + 1);
            }
        }

        if (step <= X*Y && !finished) {
            cheseboard[row][column] = 0;
            visited[row * X + column] = false;
        }else {
            finished = true;
        }

    }

    //根据当前的位置，计算🐎还能走哪些位子，放入ArrayList中
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x + 1) <= X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x + 2) <= X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x + 2) <= X && (p1.y = curPoint.y + 1) <= Y) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x + 1) <= X && (p1.y = curPoint.y + 2) <= Y) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) <= Y) {
            ps.add(new Point(p1));
        }

        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) <= Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }

}
