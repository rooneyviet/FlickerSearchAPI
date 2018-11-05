package jp.ventures.stv.stv19skilltest2018_flicker.Utils;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class InternetCheck extends AsyncTask<Void,Void,Boolean> {
    private CheckForInternet checkForInternet;
    public  interface CheckForInternet { void checkIfThereIsInternet(Boolean internet); }

    public  InternetCheck(CheckForInternet checkForInternet) {
        this.checkForInternet = checkForInternet; execute();

    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Socket sock = new Socket();
            sock.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            sock.close();
            return true;
        } catch (IOException e) { return false; }
    }

    @Override
    protected void onPostExecute(Boolean internet) {
        checkForInternet.checkIfThereIsInternet(internet);
    }

}
