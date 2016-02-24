package {{packageName}}.data;

import android.content.Context;
import {{packageName}}.{{applicationName}}Component;

public final class Injector {
  public static final String INJECTOR_SERVICE = "{{packageName}}.injector";

  @SuppressWarnings({"ResourceType", "WrongConstant"}) // Explicitly doing a custom service.
  public static {{applicationName}}Component obtain(Context context) {
    return ({{applicationName}}Component) context.getSystemService(INJECTOR_SERVICE);
  }

  public static boolean matchesService(String name) {
    return INJECTOR_SERVICE.equals(name);
  }

  private Injector() {
    throw new AssertionError("No instances.");
  }
}
