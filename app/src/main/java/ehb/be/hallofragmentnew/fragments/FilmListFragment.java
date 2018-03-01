package ehb.be.hallofragmentnew.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ehb.be.hallofragmentnew.utel.FilmLijstAdapter;
import ehb.be.hallofragmentnew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmListFragment extends Fragment {

    //14. nadat wij onze fragmentlist nodige lists toe te voegen beginen wij variabeles aan maken
    private ListView lvFilms;
    private FilmLijstAdapter mAdapter;

    public FilmListFragment() {
        // Required empty public constructor
    }

    public static FilmListFragment newInstance(){
        return  new FilmListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 15.wij gaan onze layout creeren
        View rootView = inflater.inflate(R.layout.fragment_film_list, container, false);

        lvFilms = rootView.findViewById(R.id.lv_films);
        mAdapter = new FilmLijstAdapter(getActivity());
        lvFilms.setAdapter(mAdapter);

        return rootView;

    }

}
