package superglue;

import android.app.Application;
import android.support.annotation.NonNull;
import com.jakewharton.threetenabp.AndroidThreeTen;
import superglue.data.Injector;
import superglue.data.LumberYard;
import superglue.ui.ActivityHierarchyServer;
import com.squareup.leakcanary.LeakCanary;
import javax.inject.Inject;
import timber.log.Timber;

public class SuperGlueApp extends Application {
  private SuperGlueComponent component;

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject LumberYard lumberYard;
  @Inject SuperGlueInitializer appInitializer;

  @Override public void onCreate() {
    super.onCreate();
    AndroidThreeTen.init(this);
    LeakCanary.install(this);

    component = DaggerInitializer.init(this);
    component.inject(this);

    appInitializer.init(this);

    lumberYard.cleanUp();
    Timber.plant(lumberYard.tree());

    registerActivityLifecycleCallbacks(activityHierarchyServer);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return component;
    }
    return super.getSystemService(name);
  }
}
