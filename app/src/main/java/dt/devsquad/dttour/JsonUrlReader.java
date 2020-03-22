package dt.devsquad.dttour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import androidx.annotation.LayoutRes;

import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

class JsonUrlReader extends AsyncTask<String, Void, String> {
    private ListView view;
    private CardAdapter cardAdapter;
    String url;
    Context context;
    int listLayout;
    int width;
    int height;
    boolean info = true;

    JsonUrlReader(ListView listView, String upUrl, Context _context, @LayoutRes int list,int _width, int _height){
        view = listView;
        url = upUrl;
        context = _context;
        listLayout = list;
        width = _width;
        height = _height;
    }

    @Override
    protected String doInBackground(@NotNull String... path) {

        String content;
        try {
            content = getContent(path[0]);
        } catch (IOException ex) {
            content = ex.getMessage();
        }
        if (path[1].equals("info")) info = false;
        return content;
    }

    @Override
    protected void onPostExecute(String content) {
        if (info) {
            cardAdapter = new CardAdapter(context, new CardDB(content, url).getCardSet(), listLayout, width, height);
            view.setAdapter(cardAdapter);
        } else {

        }
    }

    @NotNull
    private String getContent(String path) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(path);
            HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(10000);
            c.connect();
            reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            StringBuilder buf = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buf.append(line + "\n");
            }
            return (buf.toString());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
