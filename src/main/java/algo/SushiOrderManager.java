package algo;

import java.util.*;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 12/08/21
 */
public class SushiOrderManager {
    public static class SushiItem {
        int seatId;
        String menuItemId;
        public SushiItem(int seatId, String menuItemId) {
            this.seatId = seatId;
            this.menuItemId = menuItemId;
        }

        public int getSeatId() {
            return seatId;
        }
        public String getMenuItemId() {
            return menuItemId;
        }
        public String toString(){
            return "";
        }
        public boolean equals(Object o) {
            return true;
        }
    }

    public static class SushiOrder {
        int seatId;
        ArrayList<String> menuItemIds;
        public SushiOrder(int seatId, ArrayList<String> menuItemIds) {
            this.seatId = seatId;
            this.menuItemIds = menuItemIds;
        }
        public int getSeatId() {
            return seatId;
        }
        public ArrayList<String> getMenuItemIds() {
            return menuItemIds;
        }
        public String toString() {
            return "";
        }
    }
        private int currOrderSeat = 1;
        private int totalMenuIds;
        private int currentMenuIds = 1;
        private int N = 16; //total seats
        private ArrayList<Queue<String>> currOrder = null;
        private List<ArrayList<Queue<String>>> orderQueue;
        private int orderQueueInd = 0;
        private HashSet<Integer> seatIds = new HashSet<>();
        //private Queue<Integer> orderMenuItemSizeQueue;

        public SushiOrderManager() {
        /*
        currentSeat = 0;
        totalSeats = 16;
        seats = new ArrayList<>();

        for (int i = 0; i < totalSeats; i++) {
            seats.add(new LinkedList<SushiItem>());
        }
        */
            orderQueue = new java.util.LinkedList<>();
            //orderMenuItemSizeQueue = new LinkedList<>();
        }

        public void addOrder(ArrayList<SushiOrder> request) {
      /*
        for (SushiOrder order : request) {
            for (String roll : order.getMenuItemIds()) {
                seats.get(order.getSeatId() - 1).offer(
                    new SushiItem(order.getSeatId(), roll)
                );
            }
        }
        */
      /*
     if(orderQueue.size() > 0) {
        do {
            if(currOrderSeat == N + 1) {
                 currOrderSeat = 1;
                 if(orderQueueInd < seatIds.size()) {
                   orderQueueInd++;
                 }
                 else {
                   // next round
                   orderQueueInd = 0;
                   currOrderSeat = 1;
                   break;
                 }
             }

          currOrderSeat++;
        } while(orderQueue.get(orderQueueInd).get(currOrderSeat).isEmpty()
             ||
             seatIds.contains(currOrderSeat));
     }
      */
            //add
            int totalMenuItemsPerOrder = 0;
            ArrayList<Queue<String>> createOrder = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                createOrder.add(new LinkedList<>());
            }
            for (SushiOrder order : request) {
                createOrder.get(order.getSeatId()).addAll(order.getMenuItemIds());
                totalMenuItemsPerOrder += order.getMenuItemIds().size();
            }
            orderQueue.add(createOrder);
            totalMenuIds += totalMenuItemsPerOrder;
        }

        public SushiItem nextItem() {
      /*
      int start = currentSeat;

        do {
            SushiItem item = seats.get(currentSeat).poll();
            currentSeat = ++currentSeat % totalSeats;

            if (item != null) {
                return item;
            }
        } while (currentSeat != start);

        return null;
        */
            // last round seatIds

            this.goToNextItemOrNewRound();
            SushiItem sushiItem = this.getNextItem();
            this.goToNextItemOrNewRound();
            return sushiItem;
        }
        public void goToNextItemOrNewRound() {
            do {
                if(currOrderSeat == N + 1) {
                    currOrderSeat = 1;
                    orderQueueInd++;
                    if(orderQueueInd == orderQueue.size()) {
                        // next round
                        orderQueueInd = 0;
                        break;
                    }
                }

                if(!orderQueue.get(orderQueueInd).get(currOrderSeat).isEmpty()
                        &&
                        !seatIds.contains(currOrderSeat)) {
                    break;
                }

                currOrderSeat++;
            } while(!(orderQueueInd == 0 && currOrderSeat == 1));
        }

        public SushiItem getNextItem() {
            do {

                if (currOrderSeat == N + 1) {
                    currOrderSeat = 1;
                    orderQueueInd++;
                    seatIds.clear();
                    if (orderQueueInd == orderQueue.size()) {
                        // next round
                        orderQueueInd = 0;
                    }
                }

                if (!orderQueue.get(orderQueueInd).get(currOrderSeat).isEmpty()
                        &&
                        !seatIds.contains(currOrderSeat)) {
                    currentMenuIds++;
                    SushiItem sushiItem = new SushiItem(currOrderSeat, orderQueue.get(orderQueueInd).get(currOrderSeat).remove());

                    seatIds.add(currOrderSeat);
                    currOrderSeat++;

                    return sushiItem;
                }

                currOrderSeat++;
            } while (currentMenuIds <= totalMenuIds);
            return null;
        }
}
