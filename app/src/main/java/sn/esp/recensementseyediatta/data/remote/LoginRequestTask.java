package sn.esp.recensementseyediatta.data.remote;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginRequestTask extends AsyncTask<String, String, String> {
    public static final MediaType JSON  = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    TextView r;
    public LoginRequestTask(){
        super();
        //this.r=r;

    }
    @Override
    protected String doInBackground(String ...uri) {
        Log.d("request url",uri[0]);
        Log.d("request login",uri[1]);
        Log.d("request password",uri[2]);
        String jsonString = "{'login':'"+uri[1]+"', 'password': '"+uri[2]+"'}";
        Log.d("request json",jsonString);

        //RequestBody body = RequestBody.create(jsonString, JSON);

        RequestBody formBody = new FormBody.Builder()
                .add("login", uri[1])
                .add("password", uri[2])
                .build();
        String responseString="";
        Request request = new Request.Builder()
                .url(uri[0])
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseString= response.body().string();
            Log.d("request response",responseString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

    @Override
    protected void onPostExecute(String result)
    {
        //r.setText("Resultat:"+result);
        super.onPostExecute(result);
        //Do anything with response

    }
}
