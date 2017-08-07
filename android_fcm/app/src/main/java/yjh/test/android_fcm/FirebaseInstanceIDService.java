package yjh.test.android_fcm;

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by dsm2016 on 2017-08-03.
 */

public class FirebaseInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String token=FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Hello : "+token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token){

        OkHttpClient client=new OkHttpClient();
        RequestBody body=new FormBody.Builder()
                .add("Token",token)
                .build();

        Request request=new Request.Builder()
                .url("http://13.124.15.202:8080/print")
                .post(body)
                .build();

        try{
            client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
