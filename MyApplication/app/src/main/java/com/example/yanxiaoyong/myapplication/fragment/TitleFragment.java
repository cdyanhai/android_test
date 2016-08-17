package com.example.yanxiaoyong.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.yanxiaoyong.myapplication.R;


public class TitleFragment extends Fragment {

    private Button mbtn;
      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_title, container, false);
        mbtn = (Button)view.findViewById(R.id.fragment_btn);
          mbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(getActivity(),
                          "i am an ImageButton in TitleFragment ! ",
                          Toast.LENGTH_SHORT).show();
              }
          });
        return view;
    }


}
