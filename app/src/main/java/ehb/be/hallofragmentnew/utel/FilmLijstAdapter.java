package ehb.be.hallofragmentnew.utel;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ehb.be.hallofragmentnew.model.Film;
import ehb.be.hallofragmentnew.model.FilmDataSource;
import ehb.be.hallofragmentnew.R;

/**
 * Created by mobapp07 on 21/02/2018.
 */
// 5. daarna resource row_film aangemaakt en nodige textvelden ingesteld
public class FilmLijstAdapter extends BaseAdapter {

    // 11. we gaan een flaterView inzetten,zodat onze lijst on andere aan te maken en resulable te maken in onze scherm

    private class ViewHolder {
        TextView tvTitle;
        TextView tvRunTime;
        ImageView ivGenre; // 20.teper poprobuem dobavit foto

    }

    private Activity mContext;
    private ArrayList<Film> items;

    // 7. constructor gegenereerd en dan helft zelf aangevuld (items = FilmDataSource.getInstance().getFilmList();)
    public FilmLijstAdapter(Activity mContext) {
        this.mContext = mContext;
        items = FilmDataSource.getInstance().getFilmList(); // dus zo hebben wij onze lijst uit FilmDataSource gehaald, om als dingens veranderen in onze DataSource, dan ze worden overal veranderd
    }

    // 6. dan methode genereerd
    //dit is alle maten van komende rijen
    @Override
    public int getCount() {
        return items.size(); // 8. onze filpjes laten vullen door in onze return ""items.size te zetten
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //9.dan hier vragen wij onze  items(dus onze filmlijst) en dan via get proberen film bij aangeklikte positie terug geven
    }

    @Override
    public long getItemId(int position) {
        return position; // 10.positie bepaald
    }

    // 12. dan vullen hier om laten onze viewhorder te werken
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) { // controlleren of er een View aangemaakt geweest
            convertView = mContext.getLayoutInflater().inflate(R.layout.row_film, parent, false); // wij tekenen hier effectief een rij
            mHolder = new ViewHolder();
            mHolder.tvTitle = convertView.findViewById(R.id.tv_row_title);// verbinden onze tekst met code
            mHolder.tvRunTime = convertView.findViewById(R.id.tv_row_runtime);
            mHolder.ivGenre = convertView.findViewById(R.id.iv_genre);//20.

            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }

        // 13. dan opbouwen wij onze rij
        Film currentFilm = items.get(position);
        mHolder.tvTitle.setText(currentFilm.getTitle());
        mHolder.tvRunTime.setText("Runtime: " + currentFilm.getRuntime());

        /*
        Picasso.with(mContext)
                .load(Uri.parse("https://i.pinimg.com/736x/94/5c/e1/945ce18322949617b8d303e0c40da5bb--ios--free-icon.jpg")) // dit is als je van
                .into(mHolder.ivGenre);
//*/
        mHolder.ivGenre.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

}
