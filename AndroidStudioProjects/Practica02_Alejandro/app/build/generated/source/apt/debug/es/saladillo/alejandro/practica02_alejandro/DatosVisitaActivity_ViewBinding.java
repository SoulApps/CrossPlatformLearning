// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.practica02_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DatosVisitaActivity_ViewBinding implements Unbinder {
  private DatosVisitaActivity target;

  private View view2131689604;

  private View view2131689605;

  private View view2131689609;

  @UiThread
  public DatosVisitaActivity_ViewBinding(DatosVisitaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DatosVisitaActivity_ViewBinding(final DatosVisitaActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.txtDia, "field 'txtDia' and method 'elegirDia'");
    target.txtDia = Utils.castView(view, R.id.txtDia, "field 'txtDia'", EditText.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.elegirDia();
      }
    });
    view = Utils.findRequiredView(source, R.id.txtHoraInicio, "field 'txtHoraInicio' and method 'elegirHoraInicio'");
    target.txtHoraInicio = Utils.castView(view, R.id.txtHoraInicio, "field 'txtHoraInicio'", EditText.class);
    view2131689605 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.elegirHoraInicio();
      }
    });
    view = Utils.findRequiredView(source, R.id.txtHoraFin, "field 'txtHoraFin' and method 'elegirHoraFin'");
    target.txtHoraFin = Utils.castView(view, R.id.txtHoraFin, "field 'txtHoraFin'", EditText.class);
    view2131689609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.elegirHoraFin();
      }
    });
    target.txtResumen = Utils.findRequiredViewAsType(source, R.id.txtResumen, "field 'txtResumen'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DatosVisitaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtDia = null;
    target.txtHoraInicio = null;
    target.txtHoraFin = null;
    target.txtResumen = null;

    view2131689604.setOnClickListener(null);
    view2131689604 = null;
    view2131689605.setOnClickListener(null);
    view2131689605 = null;
    view2131689609.setOnClickListener(null);
    view2131689609 = null;
  }
}
