package ehb.be.hallofragmentnew.model;

/**
 * Created by mobapp07 on 21/02/2018.
 */
// een Enums van onze Film aangemaakt
public enum Genre {

    SCIFI,THRILLER, HORROR, DRAMA, ACTION, ROMCOM;

    @Override
    public String toString() {
        return name();

    }
}
