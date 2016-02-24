package superglue;

import android.content.Context;

/**
 * Interface that should be implemented by different build types to enable different
 * behaviors, such as logging and crash reporting.
 */
interface SuperGlueInitializer {
  void init(Context context);
}
