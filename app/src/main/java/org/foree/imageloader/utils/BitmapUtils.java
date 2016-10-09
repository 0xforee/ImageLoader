package org.foree.imageloader.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by foree on 16-10-9.
 * BitMap帮助类，帮助压缩图片的大小
 */

public class BitmapUtils {

    public static Bitmap decodeStreamWithReqSize(InputStream bitmapStream, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 不分配内存，只拿到图片数据
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bitmapStream, null, options);

        // calculateInSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // return bitmap
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(bitmapStream, null, options);
    }

    /**
     * 根据图片大小计算实际压缩的比率
     * @param options 图片实际大小参数
     * @param reqWidth 要显示的宽度
     * @param reqHeight 要显示的高度
     * @return 压缩比率
     */
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;
        String imageType = options.outMimeType;

        int inSampleSize = 1;
        if( imageWidth > reqWidth  || imageHeight > reqHeight ){
            int widthRatio = Math.round((float)imageWidth / (float)reqWidth);
            int heightRatio = Math.round((float)imageHeight / (float)reqHeight);

            inSampleSize = (widthRatio < heightRatio)? widthRatio:heightRatio;
        }

        return inSampleSize;
    }
}
