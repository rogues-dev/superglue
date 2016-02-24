package superglue;

import dagger.Component;
import javax.inject.Singleton;
import superglue.data.DataModule;
import superglue.ui.UiModule;

@Singleton
@Component(
    modules = {
        ProductionSuperGlueModule.class,
        UiModule.class,
        DataModule.class
    }
)
interface ProductionSuperGlueComponent extends SuperGlueComponent {
}
