package superglue.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import superglue.R;
import superglue.SuperGlueComponent;
import superglue.data.Injector;

public final class DebugActivity extends Activity {
  private SuperGlueComponent component;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    component = Injector.obtain(getApplication());
    setContentView(R.layout.debug_activity);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return component;
    }
    return super.getSystemService(name);
  }
}
