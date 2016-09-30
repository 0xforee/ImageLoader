package org.foree.imageloader.config;

/**
 * Created by foree on 16-9-30.
 * 配置图片Loader的具体策略
 */

public class ImageLoaderConfig {
    public ImageLoaderConfig(){

    }

    /**
     * 配置缓存机制
     * @return
     */
    public ImageLoaderConfig setCache(){
        return this;
    }

    /**
     * 配置加载策略
     */
    public ImageLoaderConfig setDisplay(){
        return this;
    }

    /**
     * 配置
     */
}
