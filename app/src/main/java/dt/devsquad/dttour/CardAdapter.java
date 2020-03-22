package dt.devsquad.dttour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {

    private Context ctx;
    private int layout;
    private LayoutInflater lInflater;
    private ArrayList<Card> objects;

    CardAdapter(Context context, ArrayList<Card> products, @LayoutRes int res) {
        ctx = context;
        layout = res;
        objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(layout, parent, false);
        }

        Card p = getCard(position);
        ((TextView) view.findViewById(R.id.textFirst)).setText(p.textFirst);
        ((TextView) view.findViewById(R.id.textSecond)).setText(p.textSecond);
        ((ImageView) view.findViewById(R.id.imageUrl)).setImageResource(p.id);
        return view;
    }

    private Card getCard(int position) {
        return ((Card) getItem(position));
    }
}
