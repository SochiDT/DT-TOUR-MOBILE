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

    Context ctx;
    int layout;
    LayoutInflater lInflater;
    ArrayList<Card> objects;

    CardAdapter(Context context, ArrayList<Card> products, @LayoutRes int res) {
        ctx = context;
        layout = res;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(layout, parent, false);
        }

        Card p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.textFirst)).setText(p.textFirst);
        ((TextView) view.findViewById(R.id.textSecond)).setText(p.textSecond);
        ((ImageView) view.findViewById(R.id.imageUrl)).setImageResource(p.id);

        //CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        // присваиваем чекбоксу обработчик
        //cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        // пишем позицию
        //cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
        //cbBuy.setChecked(p.box);
        return view;
    }

    // товар по позиции
    Card getProduct(int position) {
        return ((Card) getItem(position));
    }

    // содержимое корзины
//    ArrayList<Card> getBox() {
//        ArrayList<Card> box = new ArrayList<Card>();
//        for (Card p : objects) {
//            // если в корзине
//            if (p.box)
//                box.add(p);
//        }
//        return box;
//    }

    // обработчик для чекбоксов
//    OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
//        public void onCheckedChanged(CompoundButton buttonView,
//                                     boolean isChecked) {
//            // меняем данные товара (в корзине или нет)
//            getProduct((Integer) buttonView.getTag()).box = isChecked;
//        }
//    };
}
