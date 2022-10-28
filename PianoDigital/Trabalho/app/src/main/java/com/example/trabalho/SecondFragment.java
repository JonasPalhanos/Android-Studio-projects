package com.example.trabalho;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalho.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Spinner spineer;
    private MediaPlayer mediaPlayer;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        spineer=view.findViewById(R.id.spinner1);
        spineer.setAdapter(adapter);

        spineer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                if(mediaPlayer!=null){
                    mediaPlayer.release();
                }
                switch (pos){
                    case 1:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.c);
                        break;
                    case 2:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.csus);
                        break;
                    case 3:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.d);
                        break;
                    case 4:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.dsus);
                        break;
                    case 5:
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.e);
                        break;
                }
                if(mediaPlayer!=null){
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setBackgroundResource(R.color.laranja);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}