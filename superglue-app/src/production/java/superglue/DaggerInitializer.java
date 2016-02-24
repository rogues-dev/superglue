package superglue;

final class DaggerInitializer {
  static SuperGlueComponent init(SuperGlueApp app) {
    return DaggerProductionSuperGlueComponent.builder()
        .superGlueModule(new SuperGlueModule(app))
        .build();
  }

  private DaggerInitializer() {
    throw new AssertionError("No Instances.");
  }
}
