// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.DatePicker;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CalendarioReservaFragment_ViewBinding implements Unbinder {
  private CalendarioReservaFragment target;

  @UiThread
  public CalendarioReservaFragment_ViewBinding(CalendarioReservaFragment target, View source) {
    this.target = target;

    target.calendario = Utils.findRequiredViewAsType(source, R.id.calendario, "field 'calendario'", DatePicker.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CalendarioReservaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.calendario = null;
  }
}
