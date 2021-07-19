package kafka.generator.price;

import java.util.*;

public class PriceGenerator {

    private List<String> skuArticles;
    private int numberOfRecordsForEachArticle;

    private PriceGenerator(List<String> skuArticles, int numberOfRecordsForEachArticle) {
        if (skuArticles.isEmpty()) {
            throw new IllegalArgumentException("articles shouldn't be empty");
        }
        this.skuArticles = skuArticles;
        this.numberOfRecordsForEachArticle = numberOfRecordsForEachArticle;
    }

    public static PriceGenerator of(List<String> skuArticles, int numberOfRecordsForEachArticle) {
        return new PriceGenerator(skuArticles, numberOfRecordsForEachArticle);
    }

    public List<PriceDTO> generate() {
        List<PriceDTO> result = new ArrayList<>();
        for (int i = 0; i < skuArticles.size(); i++) {
            for (int j = 0; j < numberOfRecordsForEachArticle; j++) {
                result.add(generate(skuArticles.get(i)));
            }
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
