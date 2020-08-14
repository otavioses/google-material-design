package br.com.osouza.desafio.infrastructure.database;

import android.content.Context;

import java.io.IOException;
import java.security.GeneralSecurityException;

import io.realm.RealmConfiguration;

public class RealmSetup {
    private static String ALIAS = "br.com.osouza.desafio";
    private Context mContext;

    public RealmSetup(Context context) {
        mContext = context;
    }
    public RealmConfiguration getRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .build();
    }
}
