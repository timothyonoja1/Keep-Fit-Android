package com.kratos.keepfit.di;

import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/** Injects interfaces needed for background tasks. */
@Module
@InstallIn(SingletonComponent.class)
public class BackgroundTaskModule {

    /** Injects Executor interface. */
    @Provides
    @Singleton
    public static Executor provideExecutor(){
        return Executors.newFixedThreadPool(3);
    }

    /** Injects Handler interface. */
    @Provides
    @Singleton
    public static Handler provideHandler(){
        return HandlerCompat.createAsync(Looper.getMainLooper());
    }
}
