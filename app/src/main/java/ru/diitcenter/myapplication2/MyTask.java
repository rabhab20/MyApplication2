package ru.diitcenter.myapplication2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * Created by Superuser on 20.12.2015.
 */
public class MyTask extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ArrayList<News> arrayList = new ArrayList<>();

    public MyTask(Context context){
        this.context = context;
    }

    /*До загрузки*/
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }/*----------------*/

    protected Void doInBackground(Void... params) {

        //MyDataBase dataBase = new MyDataBase(context);

        URL url;
        HttpURLConnection connection = null;
        InputStream is = null;
        try{
            url = new URL("http://агродоска.рф/jindex.php");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);

            is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null ){
                response.append(line);
            }
            rd.close();
            String sss = URLDecoder.decode(response.toString(), "UTF-8");
            Log.e("internet","msg" + sss);

            try{
                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray array = jsonObject.getJSONArray("items");
                for(int i = 0; i< array.length(); i++){
                    JSONObject item = array.getJSONObject(i);

                    News news = new News();
                    news.rid = Integer.parseInt(item.optString("rid"));
                    news.region = item.optString("region");
                    //news.image = item.optString("img");
                    //news.desc = item.optString("descr");
                    //dataBase.insertNews(news);
                    arrayList.add(news);
                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
            if(is != null){
                try{
                    is.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    /*После загрузки*/
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        ((MainActivity)context).test(arrayList);
    }
}
