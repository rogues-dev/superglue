package {{packageName}}.ui;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class InternalReleaseUiModule {
  @Provides @Singleton ViewContainer provideViewContainer(
      TelescopeViewContainer telescopeViewContainer) {
    return telescopeViewContainer;
  }
}
