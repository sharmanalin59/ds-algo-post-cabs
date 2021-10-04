import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author nalin.sharma on 30/08/21
 */
public class ElevatorDesign {
    static enum Direction {
        UP, DOWN
    }
    static enum State {
        MOVING, IDLE, NOT_WORKING
    }
    static class InternalRequest {
        public InternalRequest(int toFloor) {
            this.toFloor = toFloor;
        }
        int toFloor;

        @Override
        public String toString() {
            return "InternalRequest{" +
                    "toFloor=" + toFloor +
                    '}';
        }
    }
    static class ExternalRequest {
        public ExternalRequest(Direction direction, int atFloor) {
            this.direction = direction;
            this.atFloor = atFloor;
            this.atTime = LocalDateTime.now();
        }

        Direction direction;
        int atFloor;
        LocalDateTime atTime;

        @Override
        public String toString() {
            return "ExternalRequest{" +
                    "direction=" + direction +
                    ", atFloor=" + atFloor +
                    ", atTime=" + atTime +
                    '}';
        }
    }
    static class Request {
        public Request(Direction direction, int atFloor, int toFloor) {
            this.externalRequest = new ExternalRequest(direction, atFloor);
            this.internalRequest = new InternalRequest(toFloor);
        }

        ExternalRequest externalRequest;
        InternalRequest internalRequest;

        @Override
        public String toString() {
            return "Request{" +
                    "externalRequest=" + externalRequest +
                    ", internalRequest=" + internalRequest +
                    '}';
        }
    }

    static class RideManager {//implements Runnable {
        RideManager(int elevatorsNumber, int floor) {
            this.elevatorsNumber = elevatorsNumber;
            this.floor = floor;
            init();
        }

        int elevatorsNumber;
        private void init() {
            requests = new ConcurrentHashMap<>();
            for(int i = 0; i < elevatorsNumber; i++) {
                Elevator elevatorJob = new Elevator(floor, requests);
                Thread t = new Thread(elevatorJob, ""+i);
                elevatorThreadJob.put(elevatorJob, t);
                t.start();
            }
            ses.schedule(() -> {
                        LocalDateTime now = LocalDateTime.now();
                        List<Request> starvedRequests = requests.keySet().stream().filter((req) ->
                            req.externalRequest.atTime.getSecond() + (floor * 10)  > now.getSecond()
                        ).collect(Collectors.toList());
                        //elevatorThreadJob.
                    return "found "+starvedRequests.size()+" requests -> [ "+starvedRequests+" ]";
                        },
                    5,
                    TimeUnit.SECONDS
            );

        }

        int floor;
        ConcurrentHashMap<Request, Object> requests;
        Map<Elevator, Thread> elevatorThreadJob = new HashMap<>();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

        void addRequests(Request req) {
            requests.put(req,"");
        }

    }
    static class Elevator implements Runnable {

        boolean requestToServe(Direction toDirection) {
            if(state == State.IDLE) {
                direction = toDirection;
                state = State.MOVING;
                return true;
            }
            return false;
        }
        Elevator(int f, ConcurrentHashMap<Request, Object> requests) {
            floors = f;
            this.requests = requests;
        }
        final int floors;
        volatile Integer currentFloor = 1;
        volatile Direction direction = Direction.UP;
        volatile State state = State.MOVING;
        ConcurrentHashMap<Request, Object> requests;

        Map<Integer, List<Request>> servingReq = new HashMap<>();
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(3000);
                while(State.IDLE == state) {
                    Thread.sleep(1000);
                }
                    if(currentFloor == 1) {
                        direction = Direction.UP;
                    }
                    if(currentFloor == floors) {
                        direction = Direction.DOWN;
                    }
                    if(requests.size() == 0 && servingReq.size() == 0) {
                        state = State.IDLE;
                    }
                    //new requests
                    List<Request> attendRequests = requests.keySet().stream().filter(req ->
                            req.externalRequest.direction == direction &&
                                    req.externalRequest.atFloor == currentFloor)
                            .collect(Collectors.toList());
                    if(attendRequests.size() > 0) {
                        for (int i = 0; i < attendRequests.size(); i++) {
                            requests.remove(attendRequests.get(i));
                        }
                        System.out.println("picking.. at " + currentFloor + " by Elevator " + Thread.currentThread().getName() + " ");
                        for (int i = 0; i < attendRequests.size(); i++) {
                            if (!servingReq.containsKey(attendRequests.get(i).internalRequest.toFloor) ||
                                    servingReq.get(attendRequests.get(i).internalRequest.toFloor) == null) {
                                servingReq.put(attendRequests.get(i).internalRequest.toFloor, new ArrayList<>());
                            }
                            servingReq.get(attendRequests.get(i).internalRequest.toFloor).add(attendRequests.get(i));
                            System.out.print(requests.get(i) + " ");
                        }
                    }

                    //serve requests
                    if(servingReq.get(currentFloor) != null && servingReq.get(currentFloor).size() > 0) {
                        List<Request> served = servingReq.get(currentFloor);
                        servingReq.put(currentFloor, null);
                        System.out.println("served.. at "+currentFloor+" by Elevator "+ Thread.currentThread().getName()+" "+ served);
                    }

                    if(direction == Direction.UP) {
                        currentFloor++;
                    }
                    if(direction == Direction.DOWN) {
                        currentFloor--;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        RideManager rm = new RideManager(4, 10);
        rm.addRequests(new Request(Direction.UP, 3, 8));

        rm.addRequests(new Request(Direction.DOWN, 10, 9));
    }
}
