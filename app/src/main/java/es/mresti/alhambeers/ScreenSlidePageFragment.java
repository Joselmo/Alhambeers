package es.mresti.alhambeers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;


/**
 * Controla el contenido de cada pagina
 */
public class ScreenSlidePageFragment extends Fragment {

    private static final String BACKGROUND_COLOR = "color";

    /**
     * Key to insert the index page into the mapping of a Bundle.
     */
    private static final String INDEX = "index";

    private int index;

    /**
     * Instances a new fragment with a background color and an index page.
     *
     *
     *            background color
     * @param index
     *            index page
     * @return a new page
     */
    public static ScreenSlidePageFragment newInstance(int index) {
        // Instantiate a new fragment
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt(INDEX, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

        return fragment;
    }

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load parameters when the initial creation of the fragment is done
        this.index = (getArguments() != null) ? getArguments().getInt(INDEX)
                : -1;
    }

    /**
     * Controla el contenido de cada Page
     *
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Cargamos el layaout
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_info_zona, container, false);

        // Vinculamos el TextView y Boton con la variable
        TextView tvIndex = (TextView) rootView.findViewById(R.id.tvIndice);
        ButtonFlat boton = (ButtonFlat) rootView.findViewById(R.id.btn_siguiente);

        boton.setVisibility(View.GONE);
        //Asignamos el texto que corresponda a las instrucciones
        tvIndex.setText(String.valueOf(this.index));
        switch (this.index){
            case 1: tvIndex.setText(getResources().getString(R.string.info_paso1));;break;
            case 2: tvIndex.setText(getResources().getString(R.string.info_paso2));;break;
            case 3: tvIndex.setText(getResources().getString(R.string.info_paso3));;break;
            case 4: ultimoPaso(tvIndex,boton);;break;

        }

        return rootView;

    }


    /** Activa las opciones del ultimo paso.
     *
     * @param texto TextView del fragment
     */
    private void ultimoPaso(TextView texto, ButtonFlat boton){
        texto.setText(getResources().getString(R.string.info_paso4));
        boton.setVisibility(View.VISIBLE);

    }

}