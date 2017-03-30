package thescone.asynctasktest;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import thescone.asynctasktest.Test1.AsyncTaskA;
import thescone.asynctasktest.Test1.AsyncTaskB;
import thescone.asynctasktest.Test1.AsyncTaskC;
import thescone.asynctasktest.Test1.AsyncTaskD;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AsyncTaskA.AsyncTaskAResponse, AsyncTaskB.AsyncTaskBResponse, AsyncTaskC.AsyncTaskCResponse, AsyncTaskD.AsyncTaskDResponse {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.startButton:
                AsyncTaskA task = new AsyncTaskA(this, this); // First
                if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) // Above Api Level 13
                {
                    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }
                else // Below Api Level 13
                {
                    task.execute();
                }
                break;
        }

    }

    @Override
    public void AsyncTaskAFinished(String output) {
        Log.d("AsyncTaskTestLog", "AsyncTaskAFinished");

        AsyncTaskB task = new AsyncTaskB(this, this); // First
        if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) // Above Api Level 13
        {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            task.execute();
        }
    }

    @Override
    public void AsyncTaskBFinished(String output) {
        Log.d("AsyncTaskTestLog", "AsyncTaskBFinished");
        AsyncTaskC task = new AsyncTaskC(this, this); // First
        if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) // Above Api Level 13
        {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            task.execute();
        }
    }

    @Override
    public void AsyncTaskCFinished(String output) {
        Log.d("AsyncTaskTestLog", "AsyncTaskCFinished");
        AsyncTaskD task = new AsyncTaskD(this, this); // First
        if(android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) // Above Api Level 13
        {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            task.execute();
        }
    }

    @Override
    public void AsyncTaskDFinished(String output) {
        Log.d("AsyncTaskTestLog", "AsyncTaskDFinished");
        startActivity(new Intent(this, EndActivity.class));
    }
}
