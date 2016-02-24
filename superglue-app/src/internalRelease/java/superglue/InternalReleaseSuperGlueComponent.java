package superglue;

import dagger.Component;
import javax.inject.Singleton;
import superglue.data.InternalReleaseDataModule;
import superglue.ui.UiModule;

@Singleton
@Component(modules = {
    InternalReleaseSuperGlueModule.class,
    UiModule.class,
    InternalReleaseDataModule.class
})
interface InternalReleaseSuperGlueComponent extends SuperGlueComponent {
}
