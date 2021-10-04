package algo.sna.lad;

import java.util.List;

public class Ladder extends MultiSteps {
    public Ladder(String name, String image, Color color, int from, int to, List<Integer> route, int size) throws RuntimeException {
        super(name, MultiStepsType.ladder, image, color, from, to, route, size);
        if(from > to) {
            throw new RuntimeException("Ladder should go up..");
        }
    }
}
