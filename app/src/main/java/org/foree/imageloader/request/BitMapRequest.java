package org.foree.imageloader.request;

import android.widget.ImageView;

/**
 * Created by foree on 16-9-30.
 * 封装加载图片的请求
 */

public class BitMapRequest implements Comparable{
    private ImageView mImageView;
    private String mUri;
    private int mSerialNum;

    public ImageView getmImageView() {
        return mImageView;
    }

    public void setmSerialNum(int mSerialNum) {
        this.mSerialNum = mSerialNum;
    }

    public BitMapRequest(ImageView imageView, String uri){
        mImageView = imageView;
        mUri = uri;
    }
    public String getImageUri() {
        return mUri;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
