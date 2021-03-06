package com.example.sitio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento_usuario extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragmento_usuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento_usuario.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento_usuario newInstance(String param1, String param2) {
        Fragmento_usuario fragment = new Fragmento_usuario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private ImageView boton_provisional;
    private ImageButton boton_ajustes, boton_comida1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_usuario, container, false);
        boton_ajustes = view.findViewById(R.id.boton_ajustes);
        boton_provisional = view.findViewById(R.id.boton_provisional_para_externo);
        boton_comida1 = view.findViewById(R.id.boton_comida1);
        boton_ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transicion = fragmentManager.beginTransaction();
                transicion.replace(R.id.Ventana_principal, new Fragmento_ajustes());
                transicion.commit();
            }
        });
        boton_provisional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transicion = fragmentManager.beginTransaction();
                transicion.replace(R.id.Ventana_principal, new Fragmento_usuarioexterno());
                transicion.commit();
            }
        });
        boton_comida1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transicion = fragmentManager.beginTransaction();
                transicion.replace(R.id.Ventana_principal, new Fragmento_ver_publicaciones());
                transicion.commit();
            }
        });
        return view;
    }
}