// Generated code from Butter Knife. Do not modify!
package es.iessaladillo.iessaladillo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReportarIncidenciaFragment_ViewBinding implements Unbinder {
  private ReportarIncidenciaFragment target;

  private View view2131689637;

  private View view2131689658;

  private View view2131689613;

  private View view2131689604;

  @UiThread
  public ReportarIncidenciaFragment_ViewBinding(final ReportarIncidenciaFragment target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.spnAulas, "field 'spnAulas' and method 'seleccionarAula'");
    target.spnAulas = Utils.castView(view, R.id.spnAulas, "field 'spnAulas'", Spinner.class);
    view2131689637 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.seleccionarAula(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    view = Utils.findRequiredView(source, R.id.spnMateriales, "field 'spnMateriales' and method 'seleccionarMaterial'");
    target.spnMateriales = Utils.castView(view, R.id.spnMateriales, "field 'spnMateriales'", Spinner.class);
    view2131689658 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.seleccionarMaterial(p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    target.tilDescripcion = Utils.findRequiredViewAsType(source, R.id.tilDescripcion, "field 'tilDescripcion'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.txtDescripcion, "field 'txtDescripcion' and method 'txtDescripcionEnter'");
    target.txtDescripcion = Utils.castView(view, R.id.txtDescripcion, "field 'txtDescripcion'", TextInputEditText.class);
    view2131689613 = view;
    ((TextView) view).setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        return target.txtDescripcionEnter();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnReintentar, "field 'btnReintentar', method 'cargarAulas', and method 'cargarMateriales'");
    target.btnReintentar = Utils.castView(view, R.id.btnReintentar, "field 'btnReintentar'", Button.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cargarAulas();
        target.cargarMateriales();
      }
    });
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.pantalla = Utils.findRequiredView(source, R.id.pantalla, "field 'pantalla'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ReportarIncidenciaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spnAulas = null;
    target.spnMateriales = null;
    target.tilDescripcion = null;
    target.txtDescripcion = null;
    target.btnReintentar = null;
    target.progressBar = null;
    target.pantalla = null;

    ((AdapterView<?>) view2131689637).setOnItemSelectedListener(null);
    view2131689637 = null;
    ((AdapterView<?>) view2131689658).setOnItemSelectedListener(null);
    view2131689658 = null;
    ((TextView) view2131689613).setOnEditorActionListener(null);
    view2131689613 = null;
    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
