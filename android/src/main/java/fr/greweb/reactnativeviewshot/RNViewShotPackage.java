
package fr.greweb.reactnativeviewshot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

public class RNViewShotPackage extends TurboReactPackage {
  @Override
  @Nonnull
  public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();
    modules.add(new RNViewShotModule(reactContext));
    return modules;
  }
  
  @Nullable
  @Override
  public NativeModule getModule(@NonNull String name, @NonNull ReactApplicationContext reactApplicationContext) {
    if (name.equals(RNViewShotModule.NAME)) {
      return new RNViewShotModule(reactApplicationContext);
    } else {
      return null;
    }

  @Override
  public ReactModuleInfoProvider getReactModuleInfoProvider() {
    return () -> {
      final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
      boolean isTurboModule = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
      moduleInfos.put(
              RNViewShotModule.NAME,
              new ReactModuleInfo(
                      RNViewShotModule.NAME,
                      RNViewShotModule.NAME,
                      false, // canOverrideExistingModule
                      false, // needsEagerInit
                      false, // isCxxModule
                      isTurboModule // isTurboModule
              ));
      return moduleInfos;
    };
  }
}