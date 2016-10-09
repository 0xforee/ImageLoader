package org.foree.imageloader;

/**
 * Created by foree on 16-10-9.
 */

public class RssItem {
    private String imageUrl;

    public RssItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
