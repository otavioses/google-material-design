package br.com.osouza.desafio;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

import br.com.osouza.desafio.infrastructure.database.DatabaseController;


public class MainApplication extends Application {

    private static WeakReference<Context> mContext;

    public static Context getContext() {
        return mContext.get();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = new WeakReference<>(getApplicationContext());
        DatabaseController.startRealm(this);
    }
}
