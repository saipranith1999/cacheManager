package com.cacheManager.JsonRead;

import io.micronaut.json.tree.JsonNode;
import io.micronaut.serde.ObjectMapper;

public class JsonNodes {

    public void handleEvent() {

        //try {

        JsonNode json = new JsonNode();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rawMessage = objectMapper.readTree(new Object);


//                if (Constants.OPERATION_TYPE_INSERT.equals(rawMessage.get(Constants.OPERATION_TYPE).asText()) && !rawMessage.get
//
//
//                commonUtil.saveEvent Status (productVendorEventStatus, Constants. PROCESSED, null;
//
//                log.info("Vendor Create event message processed: ()", productVendorEventStatus.getMessageId());
//
//           // } else if (Constants.OPERATION_TYPE_UPDATE.equals(rawMessage.get(Constants.OPERATION_TYPE).asText())) (
//
//
//           // if((rawMessage.get(Constants.FULL_DOCUMENT_BEFORE_CHANGE).get(Constants.VENDORS).isEmpty() ||rawMessage.get createEventHandler.createProcess(rawMessage, productVendorEventStatus);
//
//        }
//
//else {
//
//
//            getVendors ForCreateOrUpdates(rawMessage, productVendorEventStatus);
//}
    }
}