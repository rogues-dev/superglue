package superglue;

import superglue.ui.MainActivityComponent;
import superglue.ui.MainActivityModule;

public interface SuperGlueComponent {
  void inject(SuperGlueApp app);

  MainActivityComponent mainActivityComponent(MainActivityModule activityModule);
}
