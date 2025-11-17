package com.exemple.fragment;   // ou com.exemple.fragment, mais le même partout

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        // Afficher FragmentOne au démarrage UNE seule fois
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false); // pas dans la back stack pour le tout premier
        }

        btn1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));
        btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
    }

    /**
     * Remplace le fragment affiché dans le FrameLayout.
     *
     * @param fragment        Le nouveau fragment à afficher
     * @param addToBackStack  true = on ajoute la transaction à la pile de retour
     */
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);

        if (addToBackStack) {
            ft.addToBackStack(null); // permet de revenir en arrière avec le bouton Back
        }

        ft.commit();
    }
}
