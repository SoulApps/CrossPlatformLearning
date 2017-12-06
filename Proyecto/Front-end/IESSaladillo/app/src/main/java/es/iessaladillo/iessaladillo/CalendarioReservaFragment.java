package es.iessaladillo.iessaladillo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iessaladillo.iessaladillo.util.GlobalValues;

public class CalendarioReservaFragment extends Fragment {

    @BindView(R.id.calendario)
    DatePicker calendario;

    public CalendarioReservaFragment() {
        // Required empty public constructor
    }

    public static CalendarioReservaFragment newInstance() {
        return new CalendarioReservaFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendario_reserva, container, false);
        ButterKnife.bind(this, view);

        //Creo el listener del calendario y pongo como fecha por defecto el día de hoy.
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        //OnClick de un día.
        calendario.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                //Se comprueba si es un fin de semana o verano.
                calendar.set(calendario.getYear(), calendario.getMonth(), calendario.getDayOfMonth());
                if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
                        && calendario.getMonth() != Calendar.JULY && calendario.getMonth() != Calendar.AUGUST) {
                    Intent intent = new Intent(getContext(), DiaReservaActivity.class);
                    intent.putExtra(GlobalValues.ARG_DIA, String.format(Locale.getDefault(), "%s-%s-%s", calendario.getYear(), calendario.getMonth() + 1, calendario.getDayOfMonth()));
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
