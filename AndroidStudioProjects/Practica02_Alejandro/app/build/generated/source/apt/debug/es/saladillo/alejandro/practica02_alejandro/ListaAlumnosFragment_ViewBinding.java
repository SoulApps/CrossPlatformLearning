// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.practica02_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListaAlumnosFragment_ViewBinding implements Unbinder {
  private ListaAlumnosFragment target;

  @UiThread
  public ListaAlumnosFragment_ViewBinding(ListaAlumnosFragment target, View source) {
    this.target = target;

    target.lstAlumnos = Utils.findRequiredViewAsType(source, R.id.lstAlumnos, "field 'lstAlumnos'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListaAlumnosFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lstAlumnos = null;
  }
}
