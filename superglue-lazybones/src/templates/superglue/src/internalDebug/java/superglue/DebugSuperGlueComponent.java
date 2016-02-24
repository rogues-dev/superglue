package {{packageName}};

import dagger.Component;
import javax.inject.Singleton;
import {{packageName}}.data.DebugDataModule;
import {{packageName}}.ui.DebugUiModule;
import {{packageName}}.ui.debug.DebugView;

@Singleton
@Component(
    modules = {
        Debug{{applicationName}}Module.class,
        DebugUiModule.class,
        DebugDataModule.class,
    }
)
public interface Debug{{applicationName}}Component extends {{applicationName}}Component {
    void inject(DebugView debugView);
}
