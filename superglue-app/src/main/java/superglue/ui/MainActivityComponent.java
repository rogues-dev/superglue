package superglue.ui;

import dagger.Subcomponent;
import superglue.ui.example.ExampleView;

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
  void inject(MainActivity activity);
  void inject(ExampleView exampleView);
}
