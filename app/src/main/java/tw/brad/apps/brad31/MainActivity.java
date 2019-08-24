package tw.brad.apps.brad31;
//list view 改寫自己的調變器,用BaseAdapter更多資料傳遞,之前只有文字,現在可以搭配圖片文字
//2.還有點了擴展初選單,分群出來,可以實做展開
//3.也是版面但每個版面長相不一樣,可能圖片排列的方式不一樣,適用於資料量很大的時候,read more在讀多一點
//4.還有類似相簿那種

//*創造item resuose做版面
//*偷個影像來玩
//*寫會員類別
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private  Myadapter adapter;
    private LinkedList<Member>members = new LinkedList<>(); //泛型玩自己寫的會員類別
    private int[] imgs ={R.drawable.ball0,R.drawable.ball1,
    R.drawable.ball2,R.drawable.ball3};//宣告陣列球
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creatMembers();//宣告會員方法
        listView = findViewById(R.id.listView);
        initListView();//宣告初始化方法
    }

    //創造20個會員資料
    private  void creatMembers(){
        for (int i =0; i<20 ; i++){
            Member member = new Member("Name" + i,
                    (int)(Math.random()*4));
            members.add(member);//把資料泛型上去
        }
    }

    //初始話設定
    private  void initListView(){
        adapter = new Myadapter(); //呼叫自己寫的繼承BaseAdapter方法
        listView.setAdapter(adapter); //設置調變器(調變器)
    }
    //回下go鍵回傳哪些按鈕正打開中
    public void mytest(View view) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<members.size(); i++){
            if (members.get(i).isVIP()){
                sb.append(" " + i);
            }
        }
        Log.v("brad", sb.toString());
    }

    private  class Myadapter extends BaseAdapter{
        private LayoutInflater inflater; //需要進行初始化
        //建構式目的是初始化屬性
        public  Myadapter(){
            //inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater = getLayoutInflater();//取得inflater來接畫面物件實體
        }

        //取得幾筆資料
        @Override
        public int getCount() {
            return members.size(); //回傳會員有幾筆資料
        }
        //取得item的i
        @Override
        public Object getItem(int i) {
            return members.get(i); //回傳會員的i
        }
        //取得item的id
        @Override
        public long getItemId(int i) {
            return i;
        }
        //取得畫面,寫好的item畫面,在這邊取得
        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
           View itemView = inflater.inflate(R.layout.ietm,viewGroup,false);//把這個inflater物件浮現(寫好的item,傳回的Grounp)

            TextView title = itemView.findViewById(R.id.item_title);
            ImageView img = itemView.findViewById(R.id.item_img);
            Button test1 = itemView.findViewById(R.id.item_test1);
            Button test2 = itemView.findViewById(R.id.item_test2);
            Switch isVIP = itemView.findViewById(R.id.item_switch);

            //title顯示
            title.setText(members.get(i).getTitle());//把title的i值,跟title文字顯示出來
            //圖片顯示
            img.setImageResource(imgs[members.get(i).getIcon()]);//把圖片.從圖片Res(取得圖片陣列的i跟)取得圖片
            //按下按鈕後狀態改變,看有沒有取得vip會員狀態
            isVIP.setChecked(members.get(i).isVIP());//設置switch(switch物件)
            //當開關切換後
            isVIP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    members.get(i).setVIP(b);//取得i,跟vip
                }
            });
            //按下test1事件
//            final  int ii = i; //內部類別講好這個是什麼
            test1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("brad","i =" + i);//可以抓到各個按鈕的按鈕i
                    //點下按鈕後出現toast浮現
                    Toast.makeText(MainActivity.this, members.get(i).getTitle(),
                            Toast.LENGTH_SHORT).show();
                }
            });

            return itemView;


        }
    }
}
