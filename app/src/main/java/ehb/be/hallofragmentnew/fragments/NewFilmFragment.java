package ehb.be.hallofragmentnew.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ehb.be.hallofragmentnew.model.Film;
import ehb.be.hallofragmentnew.model.FilmDataSource;
import ehb.be.hallofragmentnew.model.Genre;
import ehb.be.hallofragmentnew.R;

/**
 * A simple {@link Fragment} subclass.
 */

//16. variabeles aangemaakt
public class NewFilmFragment extends Fragment {

    private EditText etTitle, etRunTime;
    private Spinner spGenre;
    private Button btnSave;

    ArrayAdapter<Genre> mGenreAdapter;
    public NewFilmFragment() {
        // Required empty public constructor
    }

    //17. factory methode aanmaken

    public static NewFilmFragment newInstance(){
        return new NewFilmFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       //18. variabele maken van tipe View en dan verbinding me knoppen en code maken en dan mijn rootefilter doorgeven

        View rootView = inflater.inflate(R.layout.fragment_new_film, container, false);
        //verwijzingen maken
        etTitle = rootView.findViewById(R.id.et_title);
        etRunTime = rootView.findViewById(R.id.et_runtime);
        spGenre = rootView.findViewById(R.id.sp_genre);
        btnSave = rootView.findViewById(R.id.btn_saven);

        mGenreAdapter = new ArrayAdapter<Genre>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,
                Genre.values());

        spGenre.setAdapter(mGenreAdapter);
        //dit methode help ons nieuwe filmen toevoegen,dit was de laatste stap voodat we gingen foto in de scherm steken
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String title = etTitle.getText().toString();
                    int runTime = Integer.parseInt(etRunTime.getText().toString());
                    Genre genre = (Genre) spGenre.getSelectedItem();

                    Film mFilm = new Film(title,genre,runTime);

                    FilmDataSource.getInstance().aadFilm(mFilm);

            }
        });

        return rootView;

    }



    }


