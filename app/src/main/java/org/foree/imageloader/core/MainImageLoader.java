package org.foree.imageloader.core;

import android.widget.ImageView;

import org.foree.imageloader.config.ImageLoaderConfig;
import org.foree.imageloader.loader.LoaderManager;

/**
 * Created by foree on 16-9-30.
 * 负责ImageLoader的配置与加载图片,入口
 */

public class MainImageLoader {

    private static MainImageLoader mInstance;
    private static final Object syncObject = new Object();

    ImageLoaderConfig imageLoaderConfig;

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

    }

    /**
     * 根据schema显示图片到ImageView
     */
    public void displayImage(ImageView imageView, String Uri){

    }
}
