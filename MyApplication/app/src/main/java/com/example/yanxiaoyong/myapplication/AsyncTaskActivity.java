package com.example.yanxiaoyong.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;



public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG = "ASYNC_TASK";

    private TextView mTv;
    private ProgressBar progressBar;
    private Button execute;
    private Button cancel;
    private MyAsyncTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        execute = (Button) findViewById(R.id.execute);
        cancel = (Button) findViewById(R.id.cancel);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mTv = (TextView) findViewById(R.id.text_view);
    }


    public void OnExecuteClick(View view){
        mTask = new MyAsyncTask();
        mTask.execute("www.jd.com");
        execute.setEnabled(false);
        cancel.setEnabled(true);
    }

    public void OnCancelClick(View view){
        mTask.cancel(true);
    }

    public class MyAsyncTask extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute() called");
            mTv.setText("loading....");
        }

        @Override
        protected void onPostExecute(String s) {

            Log.i(TAG, "onPostExecute(Result result) called");
            mTv.setText(s);

            execute.setEnabled(true);
            cancel.setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            Log.i(TAG, "onProgressUpdate(Progress... progresses) called");
            progressBar.setProgress(values[0]);
            mTv.setText("loading..." + values[0] + "%");
        }


        @Override
        protected void onCancelled() {

            Log.i(TAG, "onCancelled() called");
            mTv.setText("cancelled");
            progressBar.setProgress(0);

            execute.setEnabled(true);
            cancel.setEnabled(false);
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.i(TAG, "doInBackground(Params... params) called");
            String str = new String();

            for (int i=0; i<100; i++){
                try {
                    publishProgress(i);
                    Thread.sleep(100);
                }
                catch (Exception e) {
                    //Log.e(TAG, e.getMessage());
                    return str;
                }

               str += i + " ";
            }
            return str;
        }
    }

}
