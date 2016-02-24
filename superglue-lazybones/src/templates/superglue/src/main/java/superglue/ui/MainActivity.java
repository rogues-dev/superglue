package {{packageName}}.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import {{packageName}}.R;
import {{packageName}}.data.Injector;
import javax.inject.Inject;

public final class MainActivity extends Activity {
  @BindView(R.id.main_drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.main_navigation) NavigationView drawer;
  @BindView(R.id.main_content) ViewGroup content;

  @BindColor(R.color.status_bar) int statusBarColor;

  @Inject ViewContainer viewContainer;

  private MainActivityComponent component;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LayoutInflater inflater = getLayoutInflater();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      // Remove the status bar color. The DrawerLayout is responsible for drawing it from now on.
      setStatusBarColor(getWindow());
    }

    // Explicitly reference the application object since we don't want to match our own injector.
    component = Injector.obtain(getApplication())
        .mainActivityComponent(new MainActivityModule(this));
    component.inject(this);

    ViewGroup container = viewContainer.forActivity(this);

    inflater.inflate(R.layout.main_activity, container);
    ButterKnife.bind(this, container);

    drawerLayout.setStatusBarBackgroundColor(statusBarColor);
    drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

    inflater.inflate(R.layout.example_view, content);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return component;
    }
    return super.getSystemService(name);
  }

  @Override protected void onDestroy() {
    component = null;
    super.onDestroy();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private static void setStatusBarColor(Window window) {
    window.setStatusBarColor(Color.TRANSPARENT);
  }
}
