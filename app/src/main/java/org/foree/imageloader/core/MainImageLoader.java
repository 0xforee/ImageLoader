package org.foree.imageloader.core;

import android.widget.ImageView;

import org.foree.imageloader.config.ImageLoaderConfig;
import org.foree.imageloader.request.BitMapRequest;

/**
 * Created by foree on 16-9-30.
 * 负责ImageLoader的配置与加载图片,入口
 */

public class MainImageLoader {

    private static MainImageLoader mInstance;
    private static final Object syncObject = new Object();

    private ImageLoaderConfig imageLoaderConfig;
    private RequestQueue mRequestQueue;

    private MainImageLoader(){

    }

    public static MainImageLoader getInstance(){
        // double check
        if( mInstance == null){
            synchronized (syncObject){
                if( mInstance == null){
                    // lazy initialization
                    mInstance = new MainImageLoader();
                }
            }
        }

        return mInstance;
    }

    /**
     * 初始化
     */
    public void init(ImageLoaderConfig config){
        imageLoaderConfig = config;
        mRequestQueue = new RequestQueue(imageLoaderConfig.getThreadCount());
        mRequestQueue.start();
    }

    /**
     * 根据schema显示图片到ImageView
     */
    public void displayImage(ImageView imageView, String uri){
        BitMapRequest request = new BitMapRequest(imageView, uri);
        mRequestQueue.add(request);
    }

    public ImageLoaderConfig getConfig(){
        return imageLoaderConfig;
    }
}
