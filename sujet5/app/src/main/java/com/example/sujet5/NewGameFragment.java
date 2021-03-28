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

public class NewGameFragment extends Fragment  implements View.OnClickListener{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.game, container, false);
            Button option1 = (Button) rootView.findViewById(R.id.button1);
            Button option2 = (Button) rootView.findViewById(R.id.button2);
            Button option3 = (Button) rootView.findViewById(R.id.button3);
            option1.setOnClickListener(this);
            option2.setOnClickListener(this);
            option3.setOnClickListener(this);
            return rootView;

        }
        @Override
        public void onClick(View view) {

                                Fragment fragment = null;
                                switch (view.getId()) {
                                    case R.id.button1:
                                        fragment = new Erreur();

                                        replaceFragment(fragment);

                                        break;
                                    case R.id.button2:
                                        fragment = new Score2();
                                        replaceFragment(fragment);

                                        break;
                                    case R.id.button3:
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
