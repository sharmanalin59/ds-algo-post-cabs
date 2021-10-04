package algo.sna.lad;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    static class Square {
        public Square(int number, String color, MultiSteps steps) {
            this.number = number;
            this.color = color;
            this.steps = steps;
        }

        int number;
        String color;
        MultiSteps steps;
        List<User> users;

        @Override
        public String toString() {
            String userString="";
            for(User user: users) {
                userString += user.name + ",";
            }
            return number +
                    ", steps=" + steps +
                    ", users=[" +
                    userString.substring(0,userString.length() - 1) + "]";
        }
    }

    final int size;
    final int squareSize = 2;

    public Grid(int s) {
        size = s;
        grid = new Square[size][size];
        init();
    }

    final Square [][] grid;

    void init() {
        int cnt = 1;
        for(int i = size - 1; i >= 0;) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = new Square(cnt++,"white",null);
            }
            i--;
            for(int j = size - 1; j >=0; j--) {
                grid[i][j] = new Square(cnt++,"white",null);
            }
            i--;
        }
        //snakes, ladders
    }

    void addUsers(User user, int at) {
        Coor coor = getCoor(at, size);
        if(grid[coor.row][coor.col].users== null) {
            grid[coor.row][coor.col].users = new ArrayList<>();
        }
        grid[coor.row][coor.col].users.add(user);
        user.at = at;
    }

    void removeUsers(User user, int from) {
        Coor coor = getCoor(from, size);
        List<User> l = grid[coor.row][coor.col].users;
        l.remove(user);
        if(l.size() == 0) {
            grid[coor.row][coor.col].users = null;
        }
    }

    static class Coor {
        int row;
        int col;
        Coor(int r, int c) {
            row = r;
            col = c;
        }
    }
    static Coor getCoor(int from, int size) {
        int s = size/10;
        int col = (from-1)%s;
        int row = (from+1)/s;
        int mod = ((from+1)/s)%2;
        if(mod == 1) {
            return new Coor(s-1-row, col);
        }
        else if(mod == 0) {
            return new Coor(s-1-row, s-1-col);
        }
        return null;
    }

    void addMultiSteps(MultiSteps multiSteps) throws CloneNotSupportedException {
        Coor coor = getCoor(multiSteps.from, size);
        grid[coor.row][coor.col].steps = multiSteps;
        MultiSteps stepsRoute = (MultiSteps)multiSteps.clone();
        stepsRoute.route = null;
        for (int i = 0; i < multiSteps.route.size(); i++) {
            coor = getCoor(multiSteps.route.get(i), size);
            grid[coor.row][coor.col].steps = stepsRoute;
        }
    }
}
