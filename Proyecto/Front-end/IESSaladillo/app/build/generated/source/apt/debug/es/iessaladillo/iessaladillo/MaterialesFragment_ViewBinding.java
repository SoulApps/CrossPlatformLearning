// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MaterialesFragment_ViewBinding implements Unbinder {
  private MaterialesFragment target;

  private View view2131689604;

  @UiThread
  public MaterialesFragment_ViewBinding(final MaterialesFragment target, View source) {
    this.target = target;

    View view;
    target.pantalla = Utils.findRequiredView(source, R.id.pantalla, "field 'pantalla'");
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.btnReintentar, "field 'btnReintentar' and method 'cargarMateriales'");
    target.btnReintentar = Utils.castView(view, R.id.btnReintentar, "field 'btnReintentar'", Button.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cargarMateriales();
      }
    });
    target.lstMateriales = Utils.findRequiredViewAsType(source, R.id.lstMateriales, "field 'lstMateriales'", RecyclerView.class);
    target.lblListaVacia = Utils.findRequiredViewAsType(source, R.id.lblListaVacia, "field 'lblListaVacia'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MaterialesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pantalla = null;
    target.progressBar = null;
    target.btnReintentar = null;
    target.lstMateriales = null;
    target.lblListaVacia = null;

    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
