package superglue.data;

import android.content.Context;
import superglue.SuperGlueComponent;

public final class Injector {
  public static final String INJECTOR_SERVICE = "superglue.injector";

  @SuppressWarnings({"ResourceType", "WrongConstant"}) // Explicitly doing a custom service.
  public static SuperGlueComponent obtain(Context context) {
    return (SuperGlueComponent) context.getSystemService(INJECTOR_SERVICE);
  }

  public static boolean matchesService(String name) {
    return INJECTOR_SERVICE.equals(name);
  }

  private Injector() {
    throw new AssertionError("No instances.");
  }
}
