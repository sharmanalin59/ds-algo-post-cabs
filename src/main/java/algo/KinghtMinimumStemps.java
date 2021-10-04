package algo;

import java.util.LinkedList;
import java.util.Queue;

public class KinghtMinimumStemps {

    static class Coor {
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
        Coor pre;
    }
    public static void main(String[] args) {
        boolean [][] arr = {
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false}

        };
        int sX = 1, sY = 1, eX = 1, eY = 2;

        sol(arr, sX, sY, eX, eY);
    }

    private static void sol(boolean[][] arr, int sX, int sY, int eX, int eY) {
        Queue<Coor> q = new LinkedList<>();
        Coor next, temp, start, found = null;
        start = new Coor(sX,sY);
        q.add(start);
        while(!q.isEmpty()) {
            Coor current = q.remove();
            int cX = current.x;
            int cY = current.y;
            if(arr[cX][cY]) {
                continue;
            }
            //top
            if(cX - 2 >= 0 && cY - 1 >= 0 && !arr[cX-2][cY-1]) {
                next = new Coor(cX-2,cY-1);
                next.pre = current;
                q.add(next);
            }
            if(cX - 2 >= 0 && cY + 1 < 8 && !arr[cX-2][cY+1]) {
                next = new Coor(cX-2,cY+1);
                next.pre = current;
                q.add(next);
            }
            //bottom
            if(cX + 2 < 8 && cY + 1 < 8 && !arr[cX+2][cY+1]) {
                next = new Coor(cX+2,cY+1);
                next.pre = current;
                q.add(next);
            }
            if(cX + 2 < 8 && cY - 1 >= 0 && !arr[cX+2][cY-1]) {
                next = new Coor(cX+2,cY-1);
                next.pre = current;
                q.add(next);
            }
            //left
            if(cX - 1 >= 0 && cY - 2 >= 0 && !arr[cX-1][cY-2]) {
                next = new Coor(cX-1,cY-2);
                next.pre = current;
                q.add(next);
            }
            if(cX + 1 < 8 && cY - 2 >= 0 && !arr[cX+1][cY-2]) {
                next = new Coor(cX+1,cY-2);
                next.pre = current;
                q.add(next);
            }
            //right
            if(cX + 1 < 8 && cY + 2 < 8 && !arr[cX+1][cY+2]) {
                next = new Coor(cX+1,cY+2);
                next.pre = current;
                q.add(next);
            }
            if(cX - 1 >= 0 && cY + 2 < 8 && !arr[cX-1][cY+2]) {
                next = new Coor(cX-1,cY+2);
                next.pre = current;
                q.add(next);
            }
            arr[cX][cY] = true;
            if(cX == eX && cY == eY) {
                found = current;
                break;
            }
        }
        if(found != null) {
            temp = found;
            while(temp != null) {
                System.out.println("x:"+temp.x+" y:"+temp.y);
                temp = temp.pre;
            }
        }
    }

}
