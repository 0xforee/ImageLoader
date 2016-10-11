package org.foree.imageloader.loader;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import org.foree.imageloader.cache.MemoryCache;
import org.foree.imageloader.request.BitMapRequest;
import org.foree.imageloader.utils.BitmapUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by foree on 16-9-30.
 * 从网络查找图片
 */

public class NetLoader extends AbsLoader {
    private static final String TAG = NetLoader.class.getSimpleName();

    private MemoryCache mMemoryCache;

    public NetLoader(){
        mMemoryCache = MemoryCache.getInstance();
    }

    @Override
    public void loadImage(BitMapRequest request) {
        final ImageView imageView = request.getmImageView();

        // check memoryCache
        Bitmap bitmap = mMemoryCache.get(request.getImageUri());
        if( bitmap == null){
            // downloadImage
            bitmap = downloadImage(request.getImageUri());
        }

        Log.d(TAG, "url = " + request.getImageUri());

        showImage(imageView, bitmap);

        if( bitmap != null) {
            mMemoryCache.put(request.getImageUri(), bitmap);
        }
    }

    private Bitmap downloadImage(String url){
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)imageUrl.openConnection();
            InputStream in = connection.getInputStream();
            bitmap = BitmapUtils.decodeStreamWithReqSize(in, 100,100);
            in.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    private void showImage(final ImageView imageView, final Bitmap bitmap){
        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);

            }
        });
    }
}
