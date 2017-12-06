// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.examen_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AgregarActivity_ViewBinding implements Unbinder {
  private AgregarActivity target;

  private View view2131689608;

  @UiThread
  public AgregarActivity_ViewBinding(AgregarActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AgregarActivity_ViewBinding(final AgregarActivity target, View source) {
    this.target = target;

    View view;
    target.inputTitulo = Utils.findRequiredViewAsType(source, R.id.inputTitulo, "field 'inputTitulo'", TextInputLayout.class);
    target.inputAutor = Utils.findRequiredViewAsType(source, R.id.inputAutor, "field 'inputAutor'", TextInputLayout.class);
    target.inputPublicacion = Utils.findRequiredViewAsType(source, R.id.inputPublicacion, "field 'inputPublicacion'", TextInputLayout.class);
    target.txtTitulo = Utils.findRequiredViewAsType(source, R.id.txtTitulo, "field 'txtTitulo'", TextInputEditText.class);
    target.txtAutor = Utils.findRequiredViewAsType(source, R.id.txtAutor, "field 'txtAutor'", TextInputEditText.class);
    target.txtPublicacion = Utils.findRequiredViewAsType(source, R.id.txtPublicacion, "field 'txtPublicacion'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.txtPortada, "field 'txtPortada' and method 'cargarFoto'");
    target.txtPortada = Utils.castView(view, R.id.txtPortada, "field 'txtPortada'", TextInputEditText.class);
    view2131689608 = view;
    view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View p0, boolean p1) {
        target.cargarFoto();
      }
    });
    target.txtSinopsis = Utils.findRequiredViewAsType(source, R.id.txtSinopsis, "field 'txtSinopsis'", TextInputEditText.class);
    target.imgPortada = Utils.findRequiredViewAsType(source, R.id.imgPortada, "field 'imgPortada'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AgregarActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.inputTitulo = null;
    target.inputAutor = null;
    target.inputPublicacion = null;
    target.txtTitulo = null;
    target.txtAutor = null;
    target.txtPublicacion = null;
    target.txtPortada = null;
    target.txtSinopsis = null;
    target.imgPortada = null;

    view2131689608.setOnFocusChangeListener(null);
    view2131689608 = null;
  }
}
