// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.practica02_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VerAlumnoActivity_ViewBinding implements Unbinder {
  private VerAlumnoActivity target;

  @UiThread
  public VerAlumnoActivity_ViewBinding(VerAlumnoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VerAlumnoActivity_ViewBinding(VerAlumnoActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VerAlumnoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
  }
}
