package superglue.ui;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class UiModule {
  @Provides @Singleton ViewContainer provideViewContainer() {
    return ViewContainer.DEFAULT;
  }

  @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
    return ActivityHierarchyServer.NONE;
  }
}
