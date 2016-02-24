package {{packageName}}.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import {{packageName}}.R;
import {{packageName}}.{{applicationName}}Component;
import {{packageName}}.data.Injector;

public final class DebugActivity extends Activity {
  private {{applicationName}}Component component;

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
