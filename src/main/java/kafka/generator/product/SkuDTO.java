package kafka.generator.product;

import java.util.*;

public class SkuDTO {

    private String skuType;
    private String displayName;
    private String article;
    private List<MediaDTO> mediaFiles;
    private Set<String> barCode;
    private String quantity;
    private Boolean availability;

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public List<MediaDTO> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MediaDTO> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public Set<String> getBarCode() {
        return barCode;
    }

    public void setBarCode(Set<String> barCode) {
        this.barCode = barCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
