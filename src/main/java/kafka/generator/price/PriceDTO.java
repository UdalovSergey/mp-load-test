package kafka.generator.price;

public class PriceDTO {

    private String mArticle;

    private Double mBasePrice;

    private Double mSalePrice;

    private Double mLoyaltyPrice;

    public String getArticle() {
        return mArticle;
    }

    public void setArticle(String pArticle) {
        mArticle = pArticle;
    }

    public Double getBasePrice() {
        return mBasePrice;
    }

    public void setBasePrice(Double pBasePrice) {
        mBasePrice = pBasePrice;
    }

    public Double getSalePrice() {
        return mSalePrice;
    }

    public void setSalePrice(Double pSalePrice) {
        mSalePrice = pSalePrice;
    }

    public Double getLoyaltyPrice() {
        return mLoyaltyPrice;
    }

    public void setLoyaltyPrice(Double pLoyaltyPrice) {
        mLoyaltyPrice = pLoyaltyPrice;
    }
}
