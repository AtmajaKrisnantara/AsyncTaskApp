package com.example.asynctaskapp;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class SampleAsyncTask extends AsyncTask <Integer, Integer, String> {
    private Context context;

    public SampleAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Integer... values) {
        int count = values[0];
        for (int i = 0; i < count; i++) {
            try {
                publishProgress(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Finished!";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Sample Async Task about to begin..", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int step = values[0];
        Toast.makeText(context, "Step number" + String.valueOf(step), Toast.LENGTH_SHORT).show();
    }
}
