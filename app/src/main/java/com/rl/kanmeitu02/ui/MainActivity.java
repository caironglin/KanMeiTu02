package com.rl.kanmeitu02.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.rl.kanmeitu02.R;
import com.rl.kanmeitu02.api.SisterApi;
import com.rl.kanmeitu02.bean.Sister;
import com.rl.kanmeitu02.data.PictureLoader;
import com.rl.kanmeitu02.data.imgloader.SisterLoader;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button showBtn;
    private Button refreshBtn;
    private ImageView showImg;

    private ArrayList<Sister> data;
    private int curPos = 0; //当前显示的是哪一张
    private int page = 1;   //当前页数
    private PictureLoader loader;
    private SisterApi sisterApi;
    private SisterTask sisterTask;
    private SisterLoader mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sisterApi = new SisterApi();
        loader = new PictureLoader();
        mLoader = SisterLoader.getInstance(MainActivity.this);
        initData();
        initUI();
    }

    private void initUI() {
        showBtn = (Button) findViewById(R.id.btn_show);
        refreshBtn = (Button) findViewById(R.id.btn_refresh);
        showImg = (ImageView) findViewById(R.id.img_show);


        showBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);
    }

    private void initData() {
        data = new ArrayList<>();
        new SisterTask().execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                if(data != null && !data.isEmpty()) {
                    if (curPos > 9) {
                        curPos = 0;
                    }
//                    loader.load(showImg, data.get(curPos).getUrl());
                    mLoader.bindBitmap(data.get(curPos).getUrl(),showImg,400,400);
                    curPos++;
                }
                break;
            case R.id.btn_refresh:
                page++;
                sisterTask = new SisterTask();
                sisterTask.execute();
                curPos = 0;
                break;
        }
    }

    private class SisterTask extends AsyncTask<Void,Void,ArrayList<Sister>> {

//        private int page;

//        public SisterTask(int page) {
//            this.page = page;
//        }

        public SisterTask(){

        }

        @Override
        protected ArrayList<Sister> doInBackground(Void... params) {
            return sisterApi.fetchSister(10,page);
        }

        @Override
        protected void onPostExecute(ArrayList<Sister> sisters) {
            super.onPostExecute(sisters);
            data.clear();
            data.addAll(sisters);
            page++;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            sisterTask.cancel(true);
            if (sisterTask != null){
                sisterTask.cancel(true);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sisterTask.cancel(true);
    }
}
