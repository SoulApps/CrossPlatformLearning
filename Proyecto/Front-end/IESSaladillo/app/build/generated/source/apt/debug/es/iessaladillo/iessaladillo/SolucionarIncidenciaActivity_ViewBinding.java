// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SolucionarIncidenciaActivity_ViewBinding implements Unbinder {
  private SolucionarIncidenciaActivity target;

  private View view2131689624;

  private View view2131689602;

  @UiThread
  public SolucionarIncidenciaActivity_ViewBinding(SolucionarIncidenciaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SolucionarIncidenciaActivity_ViewBinding(final SolucionarIncidenciaActivity target,
      View source) {
    this.target = target;

    View view;
    target.lblMaterial = Utils.findRequiredViewAsType(source, R.id.lblMaterial, "field 'lblMaterial'", TextView.class);
    target.lblProfesor = Utils.findRequiredViewAsType(source, R.id.lblProfesor, "field 'lblProfesor'", TextView.class);
    target.lblFecha = Utils.findRequiredViewAsType(source, R.id.lblFecha, "field 'lblFecha'", TextView.class);
    target.lblDescripcion = Utils.findRequiredViewAsType(source, R.id.lblDescripcion, "field 'lblDescripcion'", TextView.class);
    view = Utils.findRequiredView(source, R.id.txtHistorial, "field 'txtHistorial' and method 'comprobarSolucionadoEnter'");
    target.txtHistorial = Utils.castView(view, R.id.txtHistorial, "field 'txtHistorial'", TextInputEditText.class);
    view2131689624 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.comprobarSolucionadoEnter();
      }
    });
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'comprobarSolucionadoFab'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view2131689602 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.comprobarSolucionadoFab();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SolucionarIncidenciaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblMaterial = null;
    target.lblProfesor = null;
    target.lblFecha = null;
    target.lblDescripcion = null;
    target.txtHistorial = null;
    target.fab = null;

    ((TextView) view2131689624).setOnEditorActionListener(null);
    view2131689624 = null;
    view2131689602.setOnClickListener(null);
    view2131689602 = null;
  }
}
