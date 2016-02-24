package {{packageName}}.data;

import android.app.Application;
import android.content.SharedPreferences;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import static android.content.Context.MODE_PRIVATE;
import static com.jakewharton.byteunits.DecimalByteUnit.MEGABYTES;

@Module
public final class DataModule {
  static final int DISK_CACHE_SIZE = (int) MEGABYTES.toBytes(50);

  @Provides @Singleton SharedPreferences provideSharedPreferences(Application app) {
    return app.getSharedPreferences("{{packageName}}", MODE_PRIVATE);
  }

  @Provides @Singleton RxSharedPreferences provideRxSharedPreferences(SharedPreferences prefs) {
    return RxSharedPreferences.create(prefs);
  }

  @Provides @Singleton Moshi provideMoshi() {
    return new Moshi.Builder()
        .build();
  }

  static OkHttpClient.Builder createOkHttpClient(Application app) {
    // Install an HTTP cache in the application cache directory.
    File cacheDir = new File(app.getCacheDir(), "http");
    Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

    return new OkHttpClient.Builder()
        .cache(cache);
  }
}
