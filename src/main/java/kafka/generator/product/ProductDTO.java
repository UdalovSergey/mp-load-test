package kafka.generator.product;

import java.util.*;

public class ProductDTO {

    private String productType;
    private String productClass;
    private String marketplaceId;
    private String merchantId;
    private String brandId;
    private String displayName;
    private String longDescription;
    private String usageInstructions;
    private List<MediaDTO> mediaFiles;
    private List<String> categoryIds;
    private List<SkuDTO> skuList;
    private String unitOfMeasure;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public List<MediaDTO> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MediaDTO> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<SkuDTO> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuDTO> skuList) {
        this.skuList = skuList;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
