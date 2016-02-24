package {{packageName}};

import dagger.Component;
import javax.inject.Singleton;
import {{packageName}}.data.InternalReleaseDataModule;
import {{packageName}}.ui.UiModule;

@Singleton
@Component(modules = {
    InternalRelease{{applicationName}}Module.class,
    UiModule.class,
    InternalReleaseDataModule.class
})
interface InternalRelease{{applicationName}}Component extends {{applicationName}}Component {
}
