package org.foree.imageloader.core;

import android.widget.ImageView;

import org.foree.imageloader.config.ImageLoaderConfig;

/**
 * Created by foree on 16-9-30.
 * 负责ImageLoader的配置与加载图片,入口
 */

public class MainImageLoader {
    ImageLoaderConfig imageLoaderConfig;
    public MainImageLoader(ImageLoaderConfig config){
        imageLoaderConfig = config;
    }



    /**
     * 初始化
     */
    public void init(){

    }

    /**
     * 根据schema显示图片到ImageView
     */
    public void displayImage(ImageView imageView, String schema){

    }
}
