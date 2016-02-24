package superglue.ui;

import android.support.v4.widget.DrawerLayout;

import dagger.Module;
import dagger.Provides;

import static superglue.util.Preconditions.checkNotNull;

@Module
public final class MainActivityModule {
  private final MainActivity mainActivity;

  MainActivityModule(MainActivity mainActivity) {
    this.mainActivity = checkNotNull(mainActivity, "mainActivity == null");
  }

  @Provides DrawerLayout provideDrawerLayout() {
    return mainActivity.drawerLayout;
  }
}
