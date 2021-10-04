package algo.thoughtspot;

import java.util.*;
import java.util.LinkedList;

public class Embibe {
    static class Cell {
        Cell(int row, int col) {
            r = row;
            c = col;
        }
        Cell(int row, int col, int s) {
            r = row;
            c = col;
            steps = s;
        }
        Cell(int row, int col, int gold, int s) {
            r = row;
            c = col;
            goldCnt = gold;
            steps = s;
        }
        int r,c, goldCnt = 0, steps;
        int rOld = -1, cOld = -1;
    }
    public static int minMoves(List<List<Integer>> maze, int x, int y) {
        // Write your code here
        int R = maze.size(), C = maze.get(0).size();
        int arr [][] = new int [R][C];

        for(int i = 0; i < R; i++) {
            List<Integer> row = maze.get(i);
            for(int j = 0; j < C; j++) {
                arr[i][j] = row.get(j);
            }
        }

        int totalGold = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == 2) {
                    totalGold++;
                }
            }
        }
        //totalGold

        //BFS
        int steps = -1;

        Queue<Cell> q = new LinkedList<>();
        if(arr[0][0] == 2) {
            q.add(new Cell(0,0,1,0));
        }
        else {
            q.add(new Cell(0,0,0));
        }

        while (!q.isEmpty()) {
            Cell removed = q.remove();
            int r = removed.r;
            int c = removed.c;
            int s = removed.steps;
            int g = removed.goldCnt;
            int rOld = removed.rOld;
            int cOld = removed.cOld;
            if(r == x && c == y && removed.goldCnt == totalGold) {
                steps = removed.steps;
                break;
            }

            if(r+1 < R && arr[r+1][c] != 1
                    && !(r+1 == rOld && c == cOld)) {
                Cell newCell = new Cell(r+1, c);
                newCell.rOld = r;
                newCell.cOld = c;
                newCell.steps = s + 1;
                if(arr[r+1][c] == 2) {
                    newCell.goldCnt = g + 1;
                }
                else {
                    newCell.goldCnt = g;
                }
                q.add(newCell);
            }

            if(r-1 >= 0 && arr[r-1][c] != 1
                    && !(r-1 == rOld && c == cOld)) {
                Cell newCell = new Cell(r-1, c);
                newCell.steps = s + 1;
                newCell.rOld = r;
                newCell.cOld = c;
                if(arr[r-1][c] == 2) {
                    newCell.goldCnt = g + 1;
                }
                else {
                    newCell.goldCnt = g;
                }
                q.add(newCell);
            }

            if(c+1 < C && arr[r][c+1] != 1
                    && !(r == rOld && c + 1 == cOld)) {
                Cell newCell = new Cell(r, c+1);
                newCell.rOld = r;
                newCell.cOld = c;
                newCell.steps = s + 1;
                if(arr[r][c+1] == 2) {
                    newCell.goldCnt = g + 1;
                }
                else {
                    newCell.goldCnt = g;
                }
                q.add(newCell);
            }

            if(c-1 >= 0 && arr[r][c-1] != 1
                    && !(r == rOld && c - 1 == cOld)) {
                Cell newCell = new Cell(r, c-1);
                newCell.rOld = r;
                newCell.cOld = c;
                newCell.steps = s + 1;
                if(arr[r][c-1] == 2) {
                    newCell.goldCnt = g + 1;
                }
                else {
                    newCell.goldCnt = g;
                }
                q.add(newCell);
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(0,2,0));
        l.add(Arrays.asList(1,1,2));
        l.add(Arrays.asList(1,0,0));
        System.out.println(minMoves(l,1,1));
    }
}
