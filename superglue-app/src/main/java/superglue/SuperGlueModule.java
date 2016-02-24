package superglue;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
final class SuperGlueModule {
  private final SuperGlueApp app;

  SuperGlueModule(SuperGlueApp app) {
    this.app = app;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }
}
