package kafka;

import kafka.constants.*;
import kafka.consumer.*;
import kafka.generator.price.*;
import kafka.generator.product.*;
import kafka.producer.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class App {
    public static void main(String[] args) throws InterruptedException {
        //runProduceProduct();
        runProducePrice();
    }

    static void runConsumer() {
        Consumer<Long, String> consumer = ConsumerCreator.createConsumer();

        int noMessageToFetch = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            if (consumerRecords.count() == 0) {
                noMessageToFetch++;
                if (noMessageToFetch > KafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
                    break;
                else
                    continue;
            }

            consumerRecords.forEach(record -> {
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
            });
            consumer.commitAsync();
        }
        consumer.close();
    }

    static void runProduceProduct() {
        List<ProductDTO> productDTOs = ProductGenerator
                .of(100, 1, "5173808818148")
                .generate();


        try (Producer<String, ProductDTO> producer = ProducerCreator.createProductProducer()) {
            for (ProductDTO dto : productDTOs) {
                final ProducerRecord<String, ProductDTO> record = new ProducerRecord<>(KafkaConstants.PRODUCT_TOPIC_NAME,
                        UUID.randomUUID().toString(), dto);
                producer.send(record);
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        System.out.println("Records has been sent: " + productDTOs.size());
    }

    static void runProducePrice() throws InterruptedException {
        List<PriceDTO> priceDTOs = PriceGenerator
                .of(getArticles(), 10)
                .generate();
        List<List<PriceDTO>> batches = getBatch(priceDTOs, 4);

        try (Producer<String, PriceDTO> producer = ProducerCreator.createPriceProducer()) {
            for (List<PriceDTO> batch: batches) {
                for (PriceDTO dto : batch) {
                    final ProducerRecord<String, PriceDTO> record = new ProducerRecord<>(KafkaConstants.PRICE_TOPIC_NAME,
                            UUID.randomUUID().toString(), dto);
                    producer.send(record);
                }
                Thread.sleep(15000); // 15 sec
            }
        }
        System.out.println("Records has been sent: " + priceDTOs.size());
    }

    private static List<List<PriceDTO>> getBatch(List<PriceDTO> priceDTOS, int batchSize) {
        return range(0, priceDTOS.size())
                .boxed()
                .collect(groupingBy(index -> index / batchSize))
                .values()
                .stream()
                .map(indices -> indices
                        .stream()
                        .map(priceDTOS::get)
                        .collect(toList()))
                .collect(toList());
    }

    private static List<String> getArticles() {
        List<String> result = new ArrayList<>();
        result.add("01");
        result.add("02");
        result.add("03");
        result.add("04");

        return result;
    }
}
