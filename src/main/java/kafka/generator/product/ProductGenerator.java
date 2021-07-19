package kafka.generator.product;

import kafka.generator.price.*;

import java.util.*;

public class ProductGenerator {

    private static final String SKU_ARTICLE_PREFIX = "MPL_TEST_";
    private static final String MARKETPLACE_ID_PREFIX = "MPL_TEST_";
    private int numberOfProduct;
    private int numberOfSKUsInProduct;
    private String merchantId;

    private ProductGenerator(int numberOfProduct, int numberOfSKUsInProduct, String merchantId) {
        this.numberOfProduct = numberOfProduct;
        this.numberOfSKUsInProduct = numberOfSKUsInProduct;
        this.merchantId = merchantId;
    }

    public static ProductGenerator of(int numberOfProduct, int numberOfSKUsInProduct, String merchantId) {
        return new ProductGenerator(numberOfProduct, numberOfSKUsInProduct, merchantId);
    }

    public List<ProductDTO> generate() {

        List<ProductDTO> result = new ArrayList<>();
        for (int productCounter = 0; productCounter < numberOfProduct; productCounter++) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductType("product");
            productDTO.setProductClass(null);
            String marketplaceId = MARKETPLACE_ID_PREFIX + productCounter;
            productDTO.setMarketplaceId(marketplaceId);
            productDTO.setMerchantId(merchantId);
            productDTO.setBrandId("11");
            productDTO.setCategoryIds(Collections.singletonList("1205"));
            productDTO.setDisplayName(MARKETPLACE_ID_PREFIX + productCounter + " display name");
            productDTO.setLongDescription("test description");
            productDTO.setUsageInstructions("bla-bla-bla");
            productDTO.setUnitOfMeasure("color");

            MediaDTO productMedia = new MediaDTO();
            productMedia.setName("main");
            productMedia.setPath("/marketplace/product.jpg");
            productDTO.setMediaFiles(Collections.singletonList(productMedia));

            List<SkuDTO> skus = new ArrayList<>();
            for (int skuCounter = 0; skuCounter < numberOfSKUsInProduct; skuCounter++) {
                SkuDTO skuDTO = new SkuDTO();
                skuDTO.setSkuType("sku");
                skuDTO.setDisplayName("test");
                skuDTO.setArticle(SKU_ARTICLE_PREFIX + marketplaceId + skuCounter);
                skuDTO.setBarCode(Collections.singleton(SKU_ARTICLE_PREFIX + skuCounter));
                skuDTO.setQuantity("100");
                skuDTO.setAvailability(true);
                skuDTO.setMediaFiles(Collections.singletonList(productMedia));

                skus.add(skuDTO);
            }
            productDTO.setSkuList(skus);
            result.add(productDTO);
        }


        return result;
    }

    private PriceDTO generate(String article) {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setArticle(article);
        priceDTO.setBasePrice(3000D);
        priceDTO.setLoyaltyPrice(2000D);
        return priceDTO;
    }
}
