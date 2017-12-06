// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DatosHardwareActivity_ViewBinding implements Unbinder {
  private DatosHardwareActivity target;

  private View view2131689602;

  private View view2131689616;

  private View view2131689615;

  @UiThread
  public DatosHardwareActivity_ViewBinding(DatosHardwareActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DatosHardwareActivity_ViewBinding(final DatosHardwareActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'guardar'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view2131689602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.guardar();
      }
    });
    target.txtCodBarras = Utils.findRequiredViewAsType(source, R.id.txtCodBarras, "field 'txtCodBarras'", TextInputEditText.class);
    target.txtDescripcion = Utils.findRequiredViewAsType(source, R.id.txtDescripcion, "field 'txtDescripcion'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.txtUnidadesTotales, "field 'txtUnidadesTotales' and method 'guardarEnter'");
    target.txtUnidadesTotales = Utils.castView(view, R.id.txtUnidadesTotales, "field 'txtUnidadesTotales'", TextInputEditText.class);
    view2131689616 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.guardarEnter();
      }
    });
    target.unidadesDisponibles = Utils.findRequiredView(source, R.id.unidadesDisponibles, "field 'unidadesDisponibles'");
    target.txtUnidadesDisponibles = Utils.findRequiredViewAsType(source, R.id.txtUnidadesDisponibles, "field 'txtUnidadesDisponibles'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.btnVerMateriales, "field 'btnVerMateriales' and method 'verMateriales'");
    target.btnVerMateriales = Utils.castView(view, R.id.btnVerMateriales, "field 'btnVerMateriales'", Button.class);
    view2131689615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.verMateriales();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DatosHardwareActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fab = null;
    target.txtCodBarras = null;
    target.txtDescripcion = null;
    target.txtUnidadesTotales = null;
    target.unidadesDisponibles = null;
    target.txtUnidadesDisponibles = null;
    target.btnVerMateriales = null;

    view2131689602.setOnClickListener(null);
    view2131689602 = null;
    ((TextView) view2131689616).setOnEditorActionListener(null);
    view2131689616 = null;
    view2131689615.setOnClickListener(null);
    view2131689615 = null;
  }
}
