package {{packageName}};

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
final class {{applicationName}}Module {
  private final {{applicationName}}App app;

  {{applicationName}}Module({{applicationName}}App app) {
    this.app = app;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }
}
