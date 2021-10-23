import java.util.*;

/**
 * @author nalin.sharma on 20/10/21
 */
public class MinSwapsToSortArr {
    static class Wrap {
        int val, ind;

        public Wrap(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public static void main(String[] args) {
        int arr [] = {3,5,4,1,2};
        int cnt = 0;
        List<Wrap> l = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++) {
            l.add(new Wrap(arr[i], i));
        }
        Collections.sort(l, (i1,i2)->Integer.compare(i1.val, i2.val));
        Set<Integer> visited = new HashSet<>();

        int cSize;
        for(int i = 0 ; i < l.size(); i++) {
            if(visited.contains(l.get(i).val) || l.get(i).ind == i)
                continue;
            cSize = 0;
            Wrap w = l.get(i);
            while(true) {
                if(visited.contains(w.val))
                    break;
                visited.add(w.val);
               w = l.get(w.ind);
                cSize++;
            }
            cnt += (cSize -1);
        }

        System.out.println(cnt);
    }
}
