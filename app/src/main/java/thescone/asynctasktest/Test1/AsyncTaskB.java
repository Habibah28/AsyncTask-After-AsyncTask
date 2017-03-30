package thescone.asynctasktest.Test1;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

/**
 * Created by Habibah on 30-Mar-17.
 */
public class AsyncTaskB extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.d("AsyncTaskTestLog", "AsyncTaskB doInBackground");
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("AsyncTaskTestLog", "AsyncTaskB onPostExecute");
        delegate.AsyncTaskBFinished(s);
    }

    private Context mContext;

    public interface AsyncTaskBResponse {
        void AsyncTaskBFinished(String output);
    }

    public AsyncTaskBResponse delegate = null;

    public AsyncTaskB(AsyncTaskBResponse delegate, Context context){
        this.delegate = delegate;
        mContext = context;
    }
}
