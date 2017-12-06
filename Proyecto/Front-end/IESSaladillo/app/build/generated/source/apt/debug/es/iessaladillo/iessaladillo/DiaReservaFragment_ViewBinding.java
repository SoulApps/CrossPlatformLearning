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
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaReservaFragment_ViewBinding implements Unbinder {
  private DiaReservaFragment target;

  private View view2131689637;

  private View view2131689604;

  @UiThread
  public DiaReservaFragment_ViewBinding(final DiaReservaFragment target, View source) {
    this.target = target;

    View view;
    target.lblDia = Utils.findRequiredViewAsType(source, R.id.lblDia, "field 'lblDia'", TextView.class);
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
    target.lstHoras = Utils.findRequiredViewAsType(source, R.id.lstHoras, "field 'lstHoras'", ListView.class);
    view = Utils.findRequiredView(source, R.id.btnReintentar, "field 'btnReintentar', method 'cargarAulas', and method 'cargarReservas'");
    target.btnReintentar = Utils.castView(view, R.id.btnReintentar, "field 'btnReintentar'", Button.class);
    view2131689604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cargarAulas();
        target.cargarReservas();
      }
    });
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaReservaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblDia = null;
    target.spnAulas = null;
    target.lstHoras = null;
    target.btnReintentar = null;
    target.progressBar = null;
    target.refresh = null;

    ((AdapterView<?>) view2131689637).setOnItemSelectedListener(null);
    view2131689637 = null;
    view2131689604.setOnClickListener(null);
    view2131689604 = null;
  }
}
