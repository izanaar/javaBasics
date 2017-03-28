package ch28.synchronizers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

public class SemaphoreTaskRunnerTest {

    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private SemaphoreTaskRunner semaphoreTaskRunner;

    @Before
    public void setUp() throws Exception {
        semaphore = new Semaphore(2);
        countDownLatch = new CountDownLatch(6);
        List<Runnable> semaphoreConsumers = IntStream.rangeClosed(1, 6).boxed().map(this::createTestTask).collect(Collectors.toList());
        semaphoreTaskRunner = new SemaphoreTaskRunner(semaphoreConsumers, semaphore, countDownLatch);
    }

    private SemaphoreTaskRunner.TestTask createTestTask(Integer id) {
        return new SemaphoreTaskRunner.TestTask(this::invoke, 1000, id);
    }

    private Object invoke() {
        semaphore.release();
        countDownLatch.countDown();
        return null;
    }

    @Test
    public void executionOrderTest() throws Exception {
        long startTime = System.currentTimeMillis();
        semaphoreTaskRunner.executeTasks();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        executionTime -= 3000;
        assertTrue(executionTime >= 0);
    }
}