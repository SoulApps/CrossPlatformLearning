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

public class ListaProximasVisitasFragment_ViewBinding implements Unbinder {
  private ListaProximasVisitasFragment target;

  @UiThread
  public ListaProximasVisitasFragment_ViewBinding(ListaProximasVisitasFragment target,
      View source) {
    this.target = target;

    target.lstVisitas = Utils.findRequiredViewAsType(source, R.id.lstVisitas, "field 'lstVisitas'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListaProximasVisitasFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lstVisitas = null;
  }
}
