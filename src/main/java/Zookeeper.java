import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 20/10/21
 */
public class Zookeeper {

    static class Node {
        Node() {}
        public Node(String k, Object v) {
            key = k;
            val = v;
        }
        String key;
        Object val;
        Map<String, Node> map = new HashMap<>();
        //app1
    }

    static void create(Node start, String[] path, Object val) {
        int i = 0;
        Node tmp = start;
        while(i < path.length) {
            if(!tmp.map.containsKey(path[i])) {
                if(i < path.length - 1)
                    return;
                else
                    tmp.map.put(path[i], new Node(path[i], val));
            }
            tmp = tmp.map.get(path[i]);
            i++;
        }
    }

    static Object get(Node start, String[] path) {
        int i = 0;
        Node tmp = start;
        while(i < path.length) {
            if(!tmp.map.containsKey(path[i]) && i < path.length - 1) {
                return null;
            }
            tmp = tmp.map.get(path[i]);

            if(i == path.length - 1) {
                return tmp.val;
            }

            i++;
        }
        return null;
    }

    static Object update(Node start, String[] path, Object v) {
        int i = 0;
        Node tmp = start;
        while(i < path.length) {
            if(!tmp.map.containsKey(path[i]) && i < path.length - 1) {
                return null;
            }
            tmp = tmp.map.get(path[i]);

            if(i == path.length - 1) {
                return tmp.val = v;
            }

            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        Node start = new Node();
        String key[] = "app1".split("#");
        create(start, key,"val");
        key = "app1#p1".split("#");
        create(start, key,"val2");
        System.out.println(get(start,"app1#p1".split("#")));
        update(start, key,"val3");
        System.out.println(get(start,"app1#p1".split("#")));
    }
}
