package org.foree.imageloader.loader;

import android.widget.ImageView;

import org.foree.imageloader.R;
import org.foree.imageloader.request.BitMapRequest;

/**
 * Created by foree on 16-9-30.
 * 从Local查找文件
 */

public class LocalLoader extends AbsLoader {

    @Override
    public void loadImage(BitMapRequest request) {
        final ImageView imageView = request.getmImageView();
        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.pubuliu);
            }
        });

    }
}
