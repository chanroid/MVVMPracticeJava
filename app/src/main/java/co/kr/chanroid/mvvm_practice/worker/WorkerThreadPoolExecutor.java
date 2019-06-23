package co.kr.chanroid.mvvm_practice.worker;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class WorkerThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 50;
    private static final TimeUnit KEEP_ALIVE_TIMEUNIT = TimeUnit.MILLISECONDS;

    @Inject
    public WorkerThreadPoolExecutor() {
        super(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIMEUNIT, new LinkedBlockingQueue<>());
    }
}
