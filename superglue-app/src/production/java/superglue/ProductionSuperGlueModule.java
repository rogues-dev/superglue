package superglue;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(includes = SuperGlueModule.class)
final class ProductionSuperGlueModule {
  @Provides @Singleton SuperGlueInitializer provideSuperGlueInitializer() {
    return context -> { /* Place Production Specific Stuff Here Such as Logging and Crash Reporting */ };
  }
}
