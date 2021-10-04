package algo.sna.lad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Executor {

    /*static class Z {
        int i = 10;
        double s = 20.0;
    }*/

    void move(List<User> users, Grid grid) throws InterruptedException {
        Random rn = new Random();

        boolean open [] = new boolean[users.size()];
        int i = 0;
        for(User user : users) {
            Thread.sleep(1000);
            int dice = rn.nextInt(6 - 1 + 1) + 1;
            System.out.println("user "+user.name+" got "+ dice);
            if(!open[i] && dice == 1) {
                open[i] = true;
                grid.addUsers(user, 1);
            }
            else {
                grid.addUsers(user, 1);
            }
        }

    }
    public static void main(String[] args) throws CloneNotSupportedException {

        /*List<Z> z = new ArrayList<>();
        z.add(new Z());
        z.add(new Z());
        System.out.println(z.toString());*/

        Grid grid = new Grid(100);
        User a = User.subscribe("Nalin",grid);
        User b = User.subscribe("Nipun",grid);
        User c = User.subscribe("Nipun",grid);

        List<User> users = new ArrayList<>();
        users.add(a);
        users.add(b);
        users.add(c);

        MultiSteps blackSnake = new Snake("blackSnake","",Color.black,40, 20, null, grid.size);
        grid.addMultiSteps(blackSnake);
        MultiSteps blueSnake = new Snake("blueSnake","",Color.blue,61, 10, null, grid.size);
        grid.addMultiSteps(blueSnake);

        MultiSteps blackLadder = new Ladder("blackLadder","",Color.black,22, 60, null, grid.size);
        grid.addMultiSteps(blackLadder);
        MultiSteps blueLadder = new Ladder("blueLadder","",Color.blue,70, 90, null, grid.size);
        grid.addMultiSteps(blueLadder);

        //start game

    }
}
