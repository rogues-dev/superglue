package superglue;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(includes = SuperGlueModule.class)
final class InternalReleaseSuperGlueModule {
  @Provides @Singleton SuperGlueInitializer provideSuperGlueInitializer() {
    return context -> { /* Place InternalRelease Specific Stuff Here Such as Logging and Crash Reporting */ };
  }
}
