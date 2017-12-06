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

public class InventarioFragment_ViewBinding implements Unbinder {
  private InventarioFragment target;

  private View view2131689653;

  private View view2131689604;

  @UiThread
  public InventarioFragment_ViewBinding(final InventarioFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lstInventario, "field 'lstInventario' and method 'verHardware'");
    target.lstInventario = Utils.castView(view, R.id.lstInventario, "field 'lstInventario'", ListView.class);
    view2131689653 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.verHardware(p2);
      }
    });
    target.lblEmptyView = Utils.findRequiredViewAsType(source, R.id.lblEmptyView, "field 'lblEmptyView'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.btnReintentar, "field 'btnReintentar' and method 'cargarInventario'");
    target.btnReintentar = Utils.castView(view, R.id.btnReintentar, "field 'btnReintentar'", Button.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cargarInventario();
      }
    });
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InventarioFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lstInventario = null;
    target.lblEmptyView = null;
    target.progressBar = null;
    target.btnReintentar = null;
    target.refresh = null;

    ((AdapterView<?>) view2131689653).setOnItemClickListener(null);
    view2131689653 = null;
    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
