import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author nalin.sharma on 02/09/21
 */
public class ThreadPoolService {

    static class ThreadPool {

        /*static List<WrapperConnection> objs;
        static List<WrapperConnection> usedObjs;
        static class WrapperConnection extends Object {
            WrapperConnection(Object o) {

            }
            Object o;
            Object closeConnectionObj() {
                synchronized (objs){
                    if(usedObjs.remove(this)) {
                        objs.add(this);
                    }
                }
            }

        }
        Object getConnectionObj() {
            synchronized (objs){
                WrapperConnection obj = objs.get(objs.size() - 1);
                usedObjs.add(obj);
                return obj;
            }
        }*/

        static class A { //implements Runnable {

            /*A(Queue<Thread> q) {
               this.q = q;
            }
            Queue<Thread> q;
            void m1() throws InterruptedException {
                synchronized(mutex) {
                    Thread t = Thread.currentThread();
                *//*if(Thread.currentThread().getName().equals("T1")) {
                    Thread.sleep(10000);
                }*//*
                    //mutex.wait();
                    while(true) {
                        if (q.peek() != t) {
                            mutex.wait();
                            continue;
                        } else {
                            q.remove();
                            doSomething();
                            mutex.notifyAll();
                            break;
                        }
                    }
                }
            }
            @Override
            public void run() {
                try {

                    m1();

                }catch (InterruptedException e) {

                }
            }*/
        }
    }

    public static void main(String[] args) throws InterruptedException { ;
        Queue<Thread> q = new LinkedList<>();
        Object mutex;
        /*ThreadPool.A a = new ThreadPool.A(q);
        Thread t1 = new Thread(a, "T1");
        Thread.sleep(5000);
        Thread t2 = new Thread(a, "T2");
        t2.start();
        Thread t3 = new Thread(a, "T3");
        t3.start();

        Thread.sleep(10000);
        t1.start();*/
    }
}
