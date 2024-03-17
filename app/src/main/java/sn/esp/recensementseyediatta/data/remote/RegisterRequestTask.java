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


public class RegisterRequestTask extends AsyncTask<String, String, String> {
    public static final MediaType JSON  = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    TextView r;
    public RegisterRequestTask(){
        super();
        //this.r=r;

    }
    @Override
    protected String doInBackground(String ...uri) {
        Log.d("request url",uri[0]);
        Log.d("request nom",uri[1]);
        Log.d("request prenom",uri[2]);
        Log.d("request login",uri[3]);
        Log.d("request password",uri[4]);
        String jsonString = "{'nom':'"+uri[1]+"', 'prenom': '"+uri[2]+"', 'login': '"+uri[3]+"', 'password': '"+uri[4]+"'}";
        Log.d("request json",jsonString);

        //RequestBody body = RequestBody.create(jsonString, JSON);

        RequestBody formBody = new FormBody.Builder()
                .add("nom", uri[1])
                .add("prenom", uri[2])
                .add("login", uri[3])
                .add("password", uri[4])
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
