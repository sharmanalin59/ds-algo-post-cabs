
import java.util.*;

import algo.SushiOrderManager;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author nalin.sharma on 12/08/21
 */
public class SushiOrderManagerTest {

        @Test
        public void itShouldWorkAsAnIteratorWithASingleRequest() {
            Queue<SushiOrderManager.SushiItem> expected = queueify(new SushiOrderManager.SushiItem[] {
                    new SushiOrderManager.SushiItem(1, "tuna"),
                    new SushiOrderManager.SushiItem(2, "salmon"),
                    new SushiOrderManager.SushiItem(3, "avocado"),
                    new SushiOrderManager.SushiItem(1, "california"),
                    new SushiOrderManager.SushiItem(2, "tuna"),
                    new SushiOrderManager.SushiItem(1, "avocado"),
                    new SushiOrderManager.SushiItem(2, "crab"),
                    new SushiOrderManager.SushiItem(2, "scallop")
            });
            ArrayList<SushiOrderManager.SushiOrder> request = new ArrayList<>(
                    Arrays.asList(
                            new SushiOrderManager.SushiOrder(1, // seatId for this order
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {
                                                    // menuItemIds for this order
                                                    "tuna", "california", "avocado"
                                            }
                                    ))
                            ),
                            new SushiOrderManager.SushiOrder(3,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"avocado"}
                                    ))
                            ),
                            new SushiOrderManager.SushiOrder(2,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {
                                                    "salmon", "tuna", "crab", "scallop"
                                            }
                                    ))
                            )
                    )
            );

            SushiOrderManager manager = new SushiOrderManager();
            addOrder(manager, request);

            for (int i = 0; i < 8; i++) {
                assertNextItem(manager, expected.poll());
            }
        }

        @Test
        public void itShouldWorkWhenOrdersAndItemDeliveriesAreInterleaved() {
            Queue<SushiOrderManager.SushiItem> expected = queueify(new SushiOrderManager.SushiItem[] {
                    new SushiOrderManager.SushiItem(1, "avocado"),
                    new SushiOrderManager.SushiItem(2, "dragon"),
                    new SushiOrderManager.SushiItem(1, "dynamite"),
                    new SushiOrderManager.SushiItem(1, "mushroom"),
                    null
            });
            ArrayList<SushiOrderManager.SushiOrder> request = new ArrayList<>(
                    Arrays.asList(
                            new SushiOrderManager.SushiOrder(2,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"dragon"}
                                    ))
                            ),
                            new SushiOrderManager.SushiOrder(1,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"avocado", "dynamite"}
                                    ))
                            )
                    )
            );
            SushiOrderManager manager = new SushiOrderManager();

            addOrder(manager, request);
            assertNextItem(manager, expected.poll());

            request = new ArrayList<>(
                    Arrays.asList(
                            new SushiOrderManager.SushiOrder(1,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"mushroom"}
                                    ))
                            )
                    )
            );
            addOrder(manager, request);

            for (int i = 0; i < 4; i++) {
                assertNextItem(manager, expected.poll());
            }
        }

        @Test
        public void itShouldHandleRoundsAndGroups() {
            Queue<SushiOrderManager.SushiItem> expected = queueify(new SushiOrderManager.SushiItem[] {
                    new SushiOrderManager.SushiItem(13, "rainbow"),
                    new SushiOrderManager.SushiItem(13, "\"tuna\""),
                    new SushiOrderManager.SushiItem(1, "cucumber")
            });

            SushiOrderManager manager = new SushiOrderManager();

            ArrayList<SushiOrderManager.SushiOrder> request = new ArrayList<>(
                    Arrays.asList(
                            new SushiOrderManager.SushiOrder(13,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"rainbow", "\"tuna\""}
                                    ))
                            )
                    )
            );

            addOrder(manager, request);
            assertNextItem(manager, expected.poll());

            request = new ArrayList<>(
                    Arrays.asList(
                            new SushiOrderManager.SushiOrder(1,
                                    new ArrayList<>(Arrays.asList(
                                            new String[] {"cucumber"}
                                    ))
                            )
                    )
            );

            addOrder(manager, request);
            assertNextItem(manager, expected.poll());
            assertNextItem(manager, expected.poll());
        }

        private static void assertNextItem(
                SushiOrderManager manager, SushiOrderManager.SushiItem expected
        ) {
            SushiOrderManager.SushiItem item = manager.nextItem();
            System.out.println("<LOG::-Next Item>" + item);
            assertEquals(expected, item);
        }

        private static void addOrder(
                SushiOrderManager manager,
                ArrayList<SushiOrderManager.SushiOrder> request
        ) {
            System.out.println("<LOG::-Add Order>" + request);
            manager.addOrder(request);
        }

        private static Queue<SushiOrderManager.SushiItem> queueify(SushiOrderManager.SushiItem[] steps) {
            Queue<SushiOrderManager.SushiItem> result = new LinkedList<>();

            for (SushiOrderManager.SushiItem step : steps) {
                result.offer(step);
            }

            return result;
        }

}
