package com.example.trabalho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalho.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        int []lista=new int[]{
                R.drawable.guitarra, R.drawable.piano,
                R.drawable.teclado, R.drawable.violao};

        binding.grid1.setAdapter(new Adaptador(getContext(), lista));

        binding.grid1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posi, long l) {
                switch (posi){
                    case 0:
                        binding.txtInstrumento.setText("Instrumento: Guitarra");
                        break;
                    case 1:
                        binding.txtInstrumento.setText("Instrumento: Piano");
                        break;
                    case 2:
                        binding.txtInstrumento.setText("Instrumento: Teclado");
                        break;
                    case 3:
                        binding.txtInstrumento.setText("Instrumento: Violão");
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}