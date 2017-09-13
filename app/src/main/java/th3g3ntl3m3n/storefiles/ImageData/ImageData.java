package th3g3ntl3m3n.storefiles.ImageData;

/**
 * Created by th3g3ntl3m3n on 1/9/17.
 */

public class ImageData {
    private String url;
    private boolean selected;

    public ImageData(String url, boolean selected) {
        this.url = url;
        this.selected = selected;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
