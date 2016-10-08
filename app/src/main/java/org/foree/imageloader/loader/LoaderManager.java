package org.foree.imageloader.loader;

/**
 * Created by foree on 16-9-30.
 * 管理加载器的注册与注销
 */

public class LoaderManager {

    /**
     * 注册图片加载器
     */
    void registerLoader(){

    }

    /**
     * 取消注册图片加载器
     */
    void unRegisterLoader(){}

    /**
     * 根据Uri选择合适的图片加载器
     */
    public AbsLoader getLoader(String Uri){
        AbsLoader loader;

        //以file://开头
        if( Uri.startsWith("file://")){
            loader = new LocalLoader();
        }else if( Uri.startsWith("http://") || Uri.startsWith("https://")){
            loader = new NetLoader();
        }else {
            loader = new NullLoader();
        }

        return loader;
    }

}
