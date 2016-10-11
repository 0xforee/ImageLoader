package org.foree.imageloader.request;

import android.widget.ImageView;

import org.foree.imageloader.config.ImageLoaderConfig;

/**
 * Created by foree on 16-9-30.
 * 封装加载图片的请求
 */

public class BitMapRequest implements Comparable{
    private ImageView mImageView;
    private String mUri;
    private int mSerialNum;
    private ImageLoaderConfig mConfig;

    public BitMapRequest(ImageView imageView, String uri, ImageLoaderConfig config){
        mImageView = imageView;
        mUri = uri;
        mConfig = config;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setSerialNum(int mSerialNum) {
        this.mSerialNum = mSerialNum;
    }

    public int getSerialNum(){
        return mSerialNum;
    }

    public String getImageUri() {
        return mUri;
    }

    @Override
    public int compareTo(Object o) {
        return mConfig.loadPolicy.compare(this, (BitMapRequest)o);
    }
}
