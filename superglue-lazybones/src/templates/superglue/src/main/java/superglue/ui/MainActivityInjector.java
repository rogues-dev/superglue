package {{packageName}}.ui;

import android.content.Context;

import static {{packageName}}.data.Injector.INJECTOR_SERVICE;

public final class MainActivityInjector {
  @SuppressWarnings({"ResourceType", "WrongConstant"}) // Explicitly doing a custom service.
  public static MainActivityComponent obtain(Context context) {
    return (MainActivityComponent) context.getSystemService(INJECTOR_SERVICE);
  }

  public static boolean matchesService(String name) {
    return INJECTOR_SERVICE.equals(name);
  }

  private MainActivityInjector() {
    throw new AssertionError("No Instances.");
  }
}
