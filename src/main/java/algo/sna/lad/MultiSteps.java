package algo.sna.lad;

import java.util.List;

abstract public class MultiSteps implements Cloneable {
    public MultiSteps(String name, MultiStepsType type, String image, Color color,
                      int from, int to, List<Integer> route, int size) throws RuntimeException {
        if(!(to > 0 && to <= size)) {
            throw new RuntimeException("failed to initialized "+ type +" out of range..");
        }
        route.forEach(r-> {
            if(!(r > 0 && r <= size)) {
                throw new RuntimeException("failed to initialized "+ type +" out of range..");
            }
        });
        this.name = name;
        this.type = type;
        this.image = image;
        this.color = color;
        this.from = from;
        this.to = to;
        this.route = route;
    }

    String name;
    MultiStepsType type;
    String image;
    Color color;
    int from;
    int to;
    List<Integer> route;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
