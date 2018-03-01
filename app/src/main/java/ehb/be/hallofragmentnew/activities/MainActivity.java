package ehb.be.hallofragmentnew.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ehb.be.hallofragmentnew.R;
import ehb.be.hallofragmentnew.fragments.FilmListFragment;
import ehb.be.hallofragmentnew.fragments.NewFilmFragment;

//1. Onze activity aangemaakt
public class MainActivity extends AppCompatActivity {

    //18.

    private FloatingActionButton fabNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //16.
        getSupportFragmentManager().beginTransaction() // wij zeggen ik wil een actie
                .add(R.id.frag_conainer, FilmListFragment.newInstance()) // onze containet vullen, daarme zeggen wij welk contaiter(frag_conainer) en waarmee gaan we het vullen(FilmListFragment.newInstance)
                .commit(); //en dan commit zorgt dat die gegevens worden doorgeduwd


        fabNew = findViewById(R.id.fab_new);
        fabNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frag_conainer, NewFilmFragment.newInstance())
                        .addToBackStack("Back") //mijn backknop in de scherm fragmen_new_film tovoegen
                        .commit();
            }
        });

    }
}
