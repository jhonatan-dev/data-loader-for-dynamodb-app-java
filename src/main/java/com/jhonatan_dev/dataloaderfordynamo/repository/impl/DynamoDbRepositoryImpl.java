package com.jhonatan_dev.dataloaderfordynamo.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.jhonatan_dev.dataloaderfordynamo.repository.DynamoDbRepository;
import com.jhonatan_dev.dataloaderfordynamo.util.DynamoUtil;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class DynamoDbRepositoryImpl implements DynamoDbRepository {

  @Autowired private AmazonDynamoDB amazonDynamoDB;

  @Override
  public void loadData(String tableName, List<Map<String, Map<String, Object>>> items)
      throws Exception {
    log.info("Start -> dynamoDbRepository.loadData");

    log.info("tableName: " + tableName);

    log.info("items size: " + items.size());

    BatchWriteItemRequest batchWriteItemRequest =
        DynamoUtil.getBatchWriteItemResult(tableName, items);

    BatchWriteItemResult batchWriteItemResult =
        amazonDynamoDB.batchWriteItem(batchWriteItemRequest);

    log.info("batchWriteItemResult: " + batchWriteItemResult);

    log.info("End -> dynamoDbRepository.loadData");
  }
}
