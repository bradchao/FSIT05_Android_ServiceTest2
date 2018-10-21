package tw.brad.servicetest2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MyService extends Service {
    private LocalBinder binder = new LocalBinder();
    private MainActivity.UIHandler uiHandler;


    public MyService() {
        Log.v("brad", "MyService()");
    }

    public class LocalBinder extends Binder {
        MyService getService(){
            Log.v("brad", "LocalBinder:getService()");
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v("brad", "onBind()");
        return binder;
    }

    public void setUiHandler(MainActivity.UIHandler uiHandler){
        this.uiHandler = uiHandler;
    }

    public void m1(String data){
        Log.v("brad", "Service => " + data);
    }

    public void m2(){
        int rand = (int)(Math.random()*49+1);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("rand", rand);
        message.setData(bundle);
        uiHandler.sendMessage(message);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("brad", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("brad", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("brad", "onDestroy()");
    }
}
