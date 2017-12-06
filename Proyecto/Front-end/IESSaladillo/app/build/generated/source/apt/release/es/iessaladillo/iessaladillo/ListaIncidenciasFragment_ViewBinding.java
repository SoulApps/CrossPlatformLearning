// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListaIncidenciasFragment_ViewBinding implements Unbinder {
  private ListaIncidenciasFragment target;

  private View view2131689655;

  private View view2131689604;

  @UiThread
  public ListaIncidenciasFragment_ViewBinding(final ListaIncidenciasFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lstIncidencias, "field 'lstIncidencias' and method 'verIncidencia'");
    target.lstIncidencias = Utils.castView(view, R.id.lstIncidencias, "field 'lstIncidencias'", ListView.class);
    view2131689655 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.verIncidencia(p2);
      }
    });
    target.lblEmptyView = Utils.findRequiredViewAsType(source, R.id.lblEmptyView, "field 'lblEmptyView'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.btnReintentar, "field 'btnReintentar' and method 'cargarIncidencias'");
    target.btnReintentar = Utils.castView(view, R.id.btnReintentar, "field 'btnReintentar'", Button.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cargarIncidencias();
      }
    });
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListaIncidenciasFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lstIncidencias = null;
    target.lblEmptyView = null;
    target.progressBar = null;
    target.btnReintentar = null;
    target.refresh = null;

    ((AdapterView<?>) view2131689655).setOnItemClickListener(null);
    view2131689655 = null;
    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
