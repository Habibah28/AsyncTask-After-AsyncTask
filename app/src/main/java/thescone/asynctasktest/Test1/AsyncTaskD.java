package thescone.asynctasktest.Test1;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

/**
 * Created by Habibah on 30-Mar-17.
 */
public class AsyncTaskD extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.d("AsyncTaskTestLog", "AsyncTaskD doInBackground");
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("AsyncTaskTestLog", "AsyncTaskD onPostExecute");
        delegate.AsyncTaskDFinished(s);
    }

    private Context mContext;

    public interface AsyncTaskDResponse {
        void AsyncTaskDFinished(String output);
    }

    public AsyncTaskDResponse delegate = null;

    public AsyncTaskD(AsyncTaskDResponse delegate, Context context){
        this.delegate = delegate;
        mContext = context;
    }
}
