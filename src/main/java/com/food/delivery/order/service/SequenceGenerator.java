package com.food.delivery.order.service;

import com.food.delivery.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

    public Integer generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is("order_sequence")),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class
        );
        return counter == null ? 1 : counter.getSeq();
    }
}
