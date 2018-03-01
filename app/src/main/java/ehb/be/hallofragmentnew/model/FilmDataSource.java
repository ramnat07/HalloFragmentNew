package ehb.be.hallofragmentnew.model;

import java.util.ArrayList;

/**
 * Created by mobapp07 on 21/02/2018.
 */
// 4. onze DataSource aangemaakt en dan Array van films en daarna gevuld met films
final public class FilmDataSource {

    // wij gebruiken hier "ourInstance" om onze DataSource final in hele project te maken
    private ArrayList<Film> filmList;
    private static final FilmDataSource ourInstance = new FilmDataSource();

    public static FilmDataSource getInstance() {
        return ourInstance;
    }

    private FilmDataSource() {

        filmList = new ArrayList<>(); //onze lege filmLijst en verder kunnen we het gaan vullen
        filmList.add(new Film("Walking dad", Genre.HORROR, 40));
        filmList.add(new Film("Games of thrones", Genre.THRILLER, 40));
        filmList.add(new Film("Victoria", Genre.ROMCOM, 45));
    }

    public ArrayList<Film> getFilmList(){
        return filmList;
    }
    public void aadFilm(Film f){
        filmList.add(f);

    }
}
