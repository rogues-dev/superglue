package superglue.data.api;

import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public final class ApiModule {
  /** TODO Change me! */
  public static final HttpUrl PRODUCTION_API_URL = HttpUrl.parse("https://example.com/");

  @Provides @Singleton HttpUrl provideBaseUrl() {
    return PRODUCTION_API_URL;
  }

  @Provides @Singleton Retrofit provideRetrofit(HttpUrl baseUrl, @Named("Api") OkHttpClient client,
      Moshi moshi) {
    return new Retrofit.Builder() //
        .client(client) //
        .baseUrl(baseUrl) //
        .addConverterFactory(MoshiConverterFactory.create(moshi)) //
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //
        .build();
  }

  static OkHttpClient.Builder createApiClient(OkHttpClient client) {
    return client.newBuilder();
  }
}
