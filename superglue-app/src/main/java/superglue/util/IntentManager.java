package superglue.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.widget.Toast;
import superglue.R;
import java.util.List;
import javax.inject.Inject;

import static android.widget.Toast.LENGTH_LONG;

public class IntentManager {

  private final Context context;

  @Inject IntentManager(Application context) {
    this.context = context;
  }

  /**
   * Attempt to launch the supplied {@link Intent}. Queries on-device packages before launching and
   * will display a simple message if none are available to handle it.
   */
  public boolean maybeStartActivity(Intent intent) {
    return maybeStartActivity(intent, false);
  }

  /**
   * Attempt to launch Android's chooser for the supplied {@link Intent}. Queries on-device
   * packages before launching and will display a simple message if none are available to handle
   * it.
   */
  public boolean maybeStartChooser(Intent intent) {
    return maybeStartActivity(intent, true);
  }

  private boolean maybeStartActivity(Intent intent, boolean chooser) {
    if (hasHandler(intent)) {
      if (chooser) {
        intent = Intent.createChooser(intent, null);
      }
      context.startActivity(intent);
      return true;
    } else {
      Toast.makeText(context, R.string.no_intent_handler, LENGTH_LONG).show();
      return false;
    }
  }

  /**
   * Queries on-device packages for a handler for the supplied {@link Intent}.
   */
  private boolean hasHandler(Intent intent) {
    List<ResolveInfo> handlers = context.getPackageManager().queryIntentActivities(intent, 0);
    return !handlers.isEmpty();
  }
}
