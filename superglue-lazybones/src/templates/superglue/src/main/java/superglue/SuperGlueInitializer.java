package {{packageName}};

import android.content.Context;

/**
 * Interface that should be implemented by different build types to enable different
 * behaviors, such as logging and crash reporting.
 */
interface {{applicationName}}Initializer {
  void init(Context context);
}
