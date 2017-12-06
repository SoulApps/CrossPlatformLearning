// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.practica02_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DatosAlumnoFragment_ViewBinding implements Unbinder {
  private DatosAlumnoFragment target;

  @UiThread
  public DatosAlumnoFragment_ViewBinding(DatosAlumnoFragment target, View source) {
    this.target = target;

    target.txtNombreAlumno = Utils.findRequiredViewAsType(source, R.id.txtNombreAlumno, "field 'txtNombreAlumno'", TextView.class);
    target.txtTelefono = Utils.findRequiredViewAsType(source, R.id.txtTelefono, "field 'txtTelefono'", TextView.class);
    target.txtEmail = Utils.findRequiredViewAsType(source, R.id.txtEmail, "field 'txtEmail'", TextView.class);
    target.txtNombreEmpresa = Utils.findRequiredViewAsType(source, R.id.txtNombreEmpresa, "field 'txtNombreEmpresa'", TextView.class);
    target.txtNombreTutor = Utils.findRequiredViewAsType(source, R.id.txtNombreTutor, "field 'txtNombreTutor'", TextView.class);
    target.txtHorario = Utils.findRequiredViewAsType(source, R.id.txtHorario, "field 'txtHorario'", TextView.class);
    target.txtDireccion = Utils.findRequiredViewAsType(source, R.id.txtDireccion, "field 'txtDireccion'", TextView.class);
    target.imgAlumno = Utils.findRequiredViewAsType(source, R.id.imgAlumno, "field 'imgAlumno'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DatosAlumnoFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtNombreAlumno = null;
    target.txtTelefono = null;
    target.txtEmail = null;
    target.txtNombreEmpresa = null;
    target.txtNombreTutor = null;
    target.txtHorario = null;
    target.txtDireccion = null;
    target.imgAlumno = null;
  }
}
