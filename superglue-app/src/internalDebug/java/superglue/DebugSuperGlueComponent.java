package superglue;

import dagger.Component;
import javax.inject.Singleton;
import superglue.data.DebugDataModule;
import superglue.ui.DebugUiModule;
import superglue.ui.debug.DebugView;

@Singleton
@Component(
    modules = {
        DebugSuperGlueModule.class,
        DebugUiModule.class,
        DebugDataModule.class,
    }
)
public interface DebugSuperGlueComponent extends SuperGlueComponent {
    void inject(DebugView debugView);
}
