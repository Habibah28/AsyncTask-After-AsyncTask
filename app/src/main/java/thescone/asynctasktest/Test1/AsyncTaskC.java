package thescone.asynctasktest.Test1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

/**
 * Created by Habibah on 30-Mar-17.
 */
public class AsyncTaskC extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.d("AsyncTaskTestLog", "AsyncTaskC doInBackground");
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("AsyncTaskTestLog", "AsyncTaskC onPostExecute");
        delegate.AsyncTaskCFinished(s);
    }

    private Context mContext;

    public interface AsyncTaskCResponse {
        void AsyncTaskCFinished(String output);
    }

    public AsyncTaskCResponse delegate = null;

    public AsyncTaskC(AsyncTaskCResponse delegate, Context context){
        this.delegate = delegate;
        mContext = context;
    }
}
