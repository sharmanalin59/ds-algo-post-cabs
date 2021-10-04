package algo.sna.lad;

import java.util.List;

public class Snake extends MultiSteps {
    public Snake(String name, String image, Color color, int from, int to, List<Integer> route, int size) throws RuntimeException {
        super(name, MultiStepsType.snake, image, color, from, to, route, size);
        if(from < to) {
            throw new RuntimeException("Snake should go down..");
        }
    }
}
