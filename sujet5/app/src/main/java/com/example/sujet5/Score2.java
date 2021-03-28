package com.example.sujet5;


import android.content.Intent;
        import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.widget.Button;
import android.widget.TextView;

public class Score2  extends Fragment implements View.OnClickListener{
    int sta,val;
    Handler handler = new Handler();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.score2, container, false);
        Button option1 = (Button) rootView.findViewById(R.id.button5);
        Button option2 = (Button) rootView.findViewById(R.id.button6);
        Button option3 = (Button) rootView.findViewById(R.id.button7);
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        return rootView;

    }
    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button5:
                fragment = new Resultgame();
                replaceFragment(fragment);
                break;
            case R.id.button6:
                fragment = new Erreur();
                replaceFragment(fragment);
                break;
            case R.id.button7:
                fragment = new Erreur();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);

        transaction.commit();
    }


}
