package com.qzh.store.util;

import com.mongodb.*;

/**
 *
 *
 * MongoDB auto increment id counter for java (Immutable, ThreadSafe)
 *
 * Example code:
 * <code>
 * MongoIDGenerator mongoIDGenerator = new MongoIDGenerator(DB,increase);
 * long id = mongoIDGenerator.generateId(collectionName);
 * </code>
 * The generateId function creating an incrementing sequence number and insert into the 'collection.ids' collection
 *
 *
 */
public final class MongoIDGenerator {
    public static final String DEFAULT_ID_COLLECTIONNAME = "product_comment";//counter collection name

    private final DBCollection dbCollection;

    private final String collectionName;

    private final long increase;

    private long initialValue;

    public MongoIDGenerator(){

        this(null, 1);
    }

    public MongoIDGenerator(DB db, long increase) {
        this(db, increase, DEFAULT_ID_COLLECTIONNAME);
    }

    public MongoIDGenerator(DB db, long increase, String collectionName)  {
        Mongo mongo = new Mongo("192.168.60.21", 27017);
        db = mongo.getDB("qzh_test");
        if (db == null)
            throw new IllegalArgumentException("DB must not be null!");

        if (collectionName == null || collectionName.isEmpty())
            this.collectionName = DEFAULT_ID_COLLECTIONNAME;
        else
            this.collectionName = collectionName;

        this.increase = increase;
        this.initialValue = 1;
        this.dbCollection = db.getCollection(this.collectionName);

    }

    /**
     * Auto generate a incrementing sequence number for _id field.
     * @param collectionName is counter name.
     * @return the last value of the sequence.
     */
    public long generateId(String collectionName) {
        try {
            if (!exists(collectionName))
                setInitialValue(collectionName, this.initialValue);
            //throw new IllegalStateException("Existing " + collectionName + " generator initialValue!");

            DBObject dbObj = this.dbCollection.findAndModify(new BasicDBObject("_id", collectionName), new BasicDBObject("$inc",
                    new BasicDBObject("id", this.increase)));

            if (dbObj == null)
                throw new IllegalStateException(collectionName
                        + " do not exist incrementID for " + collectionName + ",you can use setInitialValue to set up initial value for " + collectionName);

            return Long.parseLong(dbObj.get("id").toString());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Set up initial value for a counter
     * @param collectionName counter name
     * @param initialValue must be greater than 0
     * @throws Exception
     */
    public void setInitialValue(String collectionName, long initialValue) throws Exception {
        if (collectionName == null || collectionName.isEmpty())
            throw new IllegalArgumentException("collectionName must not be null!");

        if (initialValue < 0)
            throw new IllegalArgumentException("Generator ID initialValue must be greater than 0!");

        this.dbCollection.save(new BasicDBObject().append("_id", collectionName).append("id", initialValue));
    }

    /**
     * Check the counter already existed.
     * @param key
     * @return true is the counter existed
     * @throws Exception
     */
    public boolean exists(String key) throws Exception {
        return this.dbCollection.findOne(new BasicDBObject("_id", key)) != null;
    }
}
