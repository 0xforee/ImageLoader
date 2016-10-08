package org.foree.imageloader.config;

import org.foree.imageloader.cache.BitMapCache;
import org.foree.imageloader.cache.MemoryCache;
import org.foree.imageloader.policy.LoadPolicy;
import org.foree.imageloader.policy.SerialPolicy;

/**
 * Created by foree on 16-9-30.
 * 配置图片Loader的具体策略
 */

public class ImageLoaderConfig {
    public ImageLoaderConfig(){

    }

    /**
     * 图片缓存策略
     */
    private BitMapCache bitMapCache = new MemoryCache();

    /**
     * 图片Loading与加载失败的配置对象
     */
    private DisplayConfig displayConfig = new DisplayConfig();

    /**
     * 图片加载策略
     */
    private LoadPolicy loadPolicy = new SerialPolicy();

    /**
     * 线程数量
     */
    private int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    /**
     * 配置线程数量
     */
    public ImageLoaderConfig setThreadCount(int count){
        threadCount = Math.max(threadCount, count);
        return this;
    }
    /**
     * 配置缓存机制
     * @return
     */
    public ImageLoaderConfig setCache(BitMapCache cache){
        bitMapCache = cache;
        return this;
    }

    /**
     * 配置加载策略
     */
    public ImageLoaderConfig setPolicy(LoadPolicy policy){
        loadPolicy = policy;
        return this;
    }

    /**
     * 配置显示设置
     */
    public ImageLoaderConfig setFailResId(int resId) {
        displayConfig.setFailResId(resId);
        return this;
    }

    public ImageLoaderConfig setLoadingResId(int resId){
        displayConfig.setLoadingResId(resId);
        return this;
    }


}
