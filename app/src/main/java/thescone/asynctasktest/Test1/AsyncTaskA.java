package thescone.asynctasktest.Test1;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

/**
 * Created by Habibah on 30-Mar-17.
 */
public class AsyncTaskA extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        Log.d("AsyncTaskTestLog", "AsyncTaskA doInBackground");
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("AsyncTaskTestLog", "AsyncTaskA onPostExecute");
        delegate.AsyncTaskAFinished(s);
    }

    private Context mContext;

    public interface AsyncTaskAResponse {
        void AsyncTaskAFinished(String output);
    }

    public AsyncTaskAResponse delegate = null;

    public AsyncTaskA(AsyncTaskAResponse delegate, Context context){
        this.delegate = delegate;
        mContext = context;
    }
}
