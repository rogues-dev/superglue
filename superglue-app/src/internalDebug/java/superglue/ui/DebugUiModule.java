package superglue.ui;

import superglue.IsInstrumentationTest;
import superglue.ui.debug.DebugViewContainer;
import superglue.ui.debug.SocketActivityHierarchyServer;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class DebugUiModule {
  @Provides @Singleton ViewContainer provideViewContainer(DebugViewContainer debugViewContainer,
      @IsInstrumentationTest boolean isInstrumentationTest) {
    // Do not add the debug controls for when we are running inside of an instrumentation test.
    return isInstrumentationTest ? ViewContainer.DEFAULT : debugViewContainer;
  }

 @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
    return new SocketActivityHierarchyServer();
  }
}
