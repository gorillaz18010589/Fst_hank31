package tw.brad.apps.brad31;
//list view 改寫自己的調變器,用BaseAdapter更多資料傳遞,之前只有文字,現在可以搭配圖片文字
//2.還有點了擴展初選單,分群出來,可以實做展開
//3.也是版面但每個版面長相不一樣,可能圖片排列的方式不一樣,適用於資料量很大的時候,read more在讀多一點
//4.還有類似相簿那種

//*創造item resuose做版面
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private  Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        initListView();
    }

    private  void initListView(){
        adapter = new Myadapter(); //呼叫自己寫的繼承BaseAdapter方法
        listView.setAdapter(adapter); //設置調變器(調變器)
    }

    private  class Myadapter extends BaseAdapter{
        //幾筆資料
        @Override
        public int getCount() {
            return 0;
        }
        //取得item
        @Override
        public Object getItem(int i) {
            return null;
        }
        //取得item_id
        @Override
        public long getItemId(int i) {
            return 0;
        }
        //取得畫面
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
