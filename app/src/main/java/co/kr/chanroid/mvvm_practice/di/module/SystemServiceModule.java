package co.kr.chanroid.mvvm_practice.di.module;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.media.AudioManager;

import androidx.core.app.NotificationManagerCompat;

import dagger.Module;
import dagger.Provides;

@Module
public class SystemServiceModule {
    @Provides
    AudioManager provideAudioManager(Context context) {
        return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }
    @Provides
    BluetoothManager provideBluetoothManager(Context context) {
        return (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
    }

    @Provides
    NotificationManagerCompat provideNotificationManager(Context context) {
        return NotificationManagerCompat.from(context);
    }
}
