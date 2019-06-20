package co.kr.chanroid.mvvm_practice.di.module;

import android.content.Context;
import android.media.AudioManager;

import androidx.core.app.NotificationManagerCompat;

import co.kr.chanroid.mvvm_practice.model.BaseModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ProvidesModule {
    @Provides
    BaseModel provideBaseModel() {
        return new BaseModel();
    }

    @Provides
    NotificationManagerCompat provideNotificationManager(Context context) {
        return NotificationManagerCompat.from(context);
    }

    @Provides
    AudioManager provideAudioManager(Context context) {
        return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

}
