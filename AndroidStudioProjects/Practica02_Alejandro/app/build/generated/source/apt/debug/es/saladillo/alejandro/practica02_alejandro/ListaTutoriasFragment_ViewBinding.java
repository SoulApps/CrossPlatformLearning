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

public class ListaTutoriasFragment_ViewBinding implements Unbinder {
  private ListaTutoriasFragment target;

  @UiThread
  public ListaTutoriasFragment_ViewBinding(ListaTutoriasFragment target, View source) {
    this.target = target;

    target.lstVisitas = Utils.findRequiredViewAsType(source, R.id.lstVisitas, "field 'lstVisitas'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListaTutoriasFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lstVisitas = null;
  }
}
