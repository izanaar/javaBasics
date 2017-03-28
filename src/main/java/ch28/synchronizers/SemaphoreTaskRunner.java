package ch28.synchronizers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;

class SemaphoreTaskRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Runnable> tasks;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public SemaphoreTaskRunner(List<Runnable> tasks, Semaphore semaphore, CountDownLatch countDownLatch) {
        this.tasks = tasks;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    void executeTasks() throws InterruptedException {
        for (Runnable task : tasks) {
            semaphore.acquire();
            new Thread(task).start();
        }

        countDownLatch.await();
        logger.info("All tasks have been executed.");
    }


    static class TestTask implements Runnable {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        Supplier supplier;
        private int delay;
        private int id;

        public TestTask(Supplier supplier, int delay, int id) {
            this.supplier = supplier;
            this.delay = delay;
            this.id = id;
        }

        @Override
        public void run() {
            logger.info("Task " + id + " execution has started.");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Task " + id + " execution has ended.");
            supplier.get();
        }
    }


}
