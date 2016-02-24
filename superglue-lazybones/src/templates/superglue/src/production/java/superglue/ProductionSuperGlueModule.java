package {{packageName}};

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(includes = {{applicationName}}Module.class)
final class Production{{applicationName}}Module {
  @Provides @Singleton {{applicationName}}Initializer provide{{applicationName}}Initializer() {
    return context -> { /* Place Production Specific Stuff Here Such as Logging and Crash Reporting */ };
  }
}
