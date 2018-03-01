package ehb.be.hallofragmentnew.model;

/**
 * Created by mobapp07 on 21/02/2018.
 */
// 2. Classe Film met zn variabelmes aangemaakt en ook getters direct
public class Film {

    private String title;
    private Genre genre;
    private int runtime;

    public Film(String title, Genre genre, int runtime) {
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRuntime() {
        return runtime;
    }
}
