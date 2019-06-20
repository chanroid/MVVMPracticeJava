package co.kr.chanroid.mvvm_practice.di.module;

import android.content.Context;
import android.media.AudioManager;

import dagger.Module;
import dagger.Provides;

@Module
public class SystemServiceModule {
    @Provides
    AudioManager provideAudioManager(Context context) {
        return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }
}
