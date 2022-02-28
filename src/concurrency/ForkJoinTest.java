package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

/**
 * Java 7 introduced a new parallel mechanism for compute intensive tasks,
 * the fork-join framework. The fork-join framework allows you to distribute
 * a certain task on several workers and then wait for the result.
 */

public class ForkJoinTest {

    private  static final  int NB_PROCESSORS = 4;

    public static void main(String... args) {

        //start time
        Long statTime = System.currentTimeMillis();

        //create the problem
        Problem problem = new Problem();

        // check the number of available processors
        int nProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processeurs disponibles : " + nProcessors);

        //solver
        Solver solver = new Solver(problem.getList());


        //call the solver on a ForkJoinPoll which contains ForkJoinThread
        //ForkJoinPool : we define the number of thread that will be working
        // if no parameter, the default will be used

        /*ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.execute(solver);
        solver.join();
        int result = solver.getRawResult();
        System.out.println("Result :" + result);*/

        //invoke method forks the task and waits for the result, and doesn’t need any manual joining:
        ForkJoinPool pool = new ForkJoinPool(NB_PROCESSORS);
        //int result = pool.invokeAll(solver)
        int result = pool.invoke(solver);
        System.out.println("Result :" + result);

        //end time
        Long endTime = System.currentTimeMillis();

        System.out.println("Duration : " + (endTime - statTime));


    }
}


/**
 * This class defines a long list of integers which
 * defines the problem we will
 * later try to solve
 */


class Problem {
    private final int[] list = new int[2000000];

    public Problem() {

        Random generator = new Random(19580427);

        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(500000);
        }
    }

    public int[] getList() {
        return list;
    }
}

/**
 * This class solve the problem define above with concurrency approach by executing
 * simustanously tasks
 */
class Solver extends RecursiveTask<Integer> {
    private int[] list;
    public int result;
    private static Logger logger = Logger.getAnonymousLogger();
    private static final int THRESHIOLD = 2;


    public Solver(int[] list) {
        this.list = list;
    }


    @Override
    protected Integer compute() {

        if (list.length >= THRESHIOLD) {
            return ForkJoinTask.invokeAll(createSubtasks()).stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();

        } else {

            return processing(list);
        }
    }

    //divide to conquer strategy
    private List<Solver> createSubtasks() {
        List<Solver> dividedTask = new ArrayList<Solver>();
        int middle = list.length / 2;

        dividedTask.add(new Solver(Arrays.copyOfRange(list, 0, middle)));
        dividedTask.add(new Solver(Arrays.copyOfRange(list, middle, list.length)));

        return dividedTask;
    }

    //processing single task
    private Integer processing(int[] list) {
        logger.info("processed by " + Thread.currentThread().getName());
        int partialResult = Arrays.stream(list).sum();
        return partialResult;
    }

}

