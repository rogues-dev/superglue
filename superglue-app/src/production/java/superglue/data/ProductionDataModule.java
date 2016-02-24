package superglue.data;

import android.app.Application;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import timber.log.Timber;

import static superglue.data.DataModule.createOkHttpClient;

@Module
public final class ProductionDataModule {
  @Provides @Singleton OkHttpClient provideOkHttpClient(Application app) {
    return createOkHttpClient(app).build();
  }

  @Provides @Singleton Picasso providePicasso(Application app, OkHttpClient client) {
    return new Picasso.Builder(app)
        .downloader(new OkHttp3Downloader(client))
        .listener((picasso, uri, e) -> Timber.e(e, "Failed to load image: %s", uri))
        .build();
  }
}
