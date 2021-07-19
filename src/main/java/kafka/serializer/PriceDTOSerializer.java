package kafka.serializer;

import com.fasterxml.jackson.databind.*;
import kafka.generator.price.*;
import kafka.pojo.*;
import org.apache.kafka.common.serialization.*;

import java.util.*;

public class PriceDTOSerializer implements Serializer<PriceDTO> {

	@Override
	public byte[] serialize(String topic, PriceDTO data) {
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