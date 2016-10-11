package org.foree.imageloader.loader;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import org.foree.imageloader.cache.BitmapCache;
import org.foree.imageloader.core.MainImageLoader;
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

    private BitmapCache mBitmapCache;

    public NetLoader(){
        mBitmapCache = MainImageLoader.getInstance().getConfig().bitmapCache;
    }

    @Override
    public void loadImage(BitMapRequest request) {
        final ImageView imageView = request.getImageView();

        // check memoryCache
        Bitmap bitmap = mBitmapCache.get(request.getImageUri());
        if( bitmap == null){
            // downloadImage
            bitmap = downloadImage(request.getImageUri());

            if( bitmap != null) {
                mBitmapCache.put(request.getImageUri(), bitmap);
            }
        }

        Log.d(TAG, "url = " + request.getImageUri());

        showImage(imageView, bitmap);

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
