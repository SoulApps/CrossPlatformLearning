// Generated code from Butter Knife. Do not modify!
package es.saladillo.alejandro.examenmultihilo_alejandro;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131624060;

  private View view2131624062;

  private TextWatcher view2131624062TextWatcher;

  private View view2131624063;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.cbMoneda, "field 'cbMoneda' and method 'monedaCambiada'");
    target.cbMoneda = Utils.castView(view, R.id.cbMoneda, "field 'cbMoneda'", Spinner.class);
    view2131624060 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.monedaCambiada();
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    view = Utils.findRequiredView(source, R.id.txtCantidad, "field 'txtCantidad' and method 'textoCambiado'");
    target.txtCantidad = Utils.castView(view, R.id.txtCantidad, "field 'txtCantidad'", EditText.class);
    view2131624062 = view;
    view2131624062TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.textoCambiado();
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131624062TextWatcher);
    target.lblResultado = Utils.findRequiredViewAsType(source, R.id.lblResultado, "field 'lblResultado'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnCalcular, "field 'btnCalcular' and method 'calcular'");
    target.btnCalcular = Utils.castView(view, R.id.btnCalcular, "field 'btnCalcular'", Button.class);
    view2131624063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.calcular();
      }
    });
    target.imgMoneda = Utils.findRequiredViewAsType(source, R.id.imgMoneda, "field 'imgMoneda'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cbMoneda = null;
    target.txtCantidad = null;
    target.lblResultado = null;
    target.btnCalcular = null;
    target.imgMoneda = null;

    ((AdapterView<?>) view2131624060).setOnItemSelectedListener(null);
    view2131624060 = null;
    ((TextView) view2131624062).removeTextChangedListener(view2131624062TextWatcher);
    view2131624062TextWatcher = null;
    view2131624062 = null;
    view2131624063.setOnClickListener(null);
    view2131624063 = null;
  }
}
