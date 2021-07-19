package kafka.serializer;

import com.fasterxml.jackson.databind.*;
import kafka.generator.product.*;
import org.apache.kafka.common.serialization.*;

public class ProductDTOSerializer implements Serializer<ProductDTO> {

    @Override
    public byte[] serialize(String topic, ProductDTO data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
            System.out.println("Error in serializing object" + data);
        }
        return retVal;
    }

    @Override
    public void close() {

    }

}