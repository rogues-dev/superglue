package {{packageName}};

import {{packageName}}.ui.MainActivityComponent;
import {{packageName}}.ui.MainActivityModule;

public interface {{applicationName}}Component {
  void inject({{applicationName}}App app);

  MainActivityComponent mainActivityComponent(MainActivityModule activityModule);
}
