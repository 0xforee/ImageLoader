package org.foree.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 切换浏览模式
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter = new ImageAdapter());
    }

    class ImageAdapter extends RecyclerView.Adapter<ImageHolder> {

        @Override
        public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if( recyclerView.getLayoutManager() instanceof LinearLayoutManager)
                return new ImageHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.image_holder_linearlayout, parent, false));
            else
                return new ImageHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.image_holder_staggerd, parent, false));
        }

        @Override
        public void onBindViewHolder(ImageHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 30;
        }

    }

    class ImageHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item_image);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.action_change_card:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                recyclerView.setAdapter(imageAdapter = new ImageAdapter());
                break;
            case R.id.action_change_list:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(imageAdapter = new ImageAdapter());
                break;
        }
        return true;
    }
}
