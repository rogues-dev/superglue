package {{packageName}};

import dagger.Component;
import javax.inject.Singleton;
import {{packageName}}.data.DataModule;
import {{packageName}}.ui.UiModule;

@Singleton
@Component(
    modules = {
        Production{{applicationName}}Module.class,
        UiModule.class,
        DataModule.class
    }
)
interface Production{{applicationName}}Component extends {{applicationName}}Component {
}
