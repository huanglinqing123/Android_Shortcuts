package hlq.view.service;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * @author Huanglinqing
 * @create 2018 - 09 - 12 -11:06
 */

public class JobSchedulerService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
