package org.foree.imageloader.core;

import android.widget.ImageView;

import org.foree.imageloader.config.ImageLoaderConfig;
import org.foree.imageloader.loader.LoaderManager;

/**
 * Created by foree on 16-9-30.
 * 负责ImageLoader的配置与加载图片,入口
 */

public class MainImageLoader {

    private static MainImageLoader mainImageLoader;
    private static final Object syncObject = new Object();

    ImageLoaderConfig imageLoaderConfig;

    LoaderManager loaderManager;

    private MainImageLoader(){

    }

    public static MainImageLoader getInstance(){
        // double check
        if( mainImageLoader == null){
            synchronized (syncObject){
                if( mainImageLoader == null){
                    // lazy initialization
                    mainImageLoader = new MainImageLoader();
                }
            }
        }

        return mainImageLoader;
    }

    /**
     * 初始化
     */
    public void init(ImageLoaderConfig config){
        imageLoaderConfig = config;
        loaderManager = new LoaderManager();
    }

    /**
     * 根据schema显示图片到ImageView
     */
    public void displayImage(ImageView imageView, String Uri){
        loaderManager.getLoader(Uri).loadImage(Uri);
    }
}
