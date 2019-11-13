package org.apache.hive.storage.jdbc.conf;

public final class Constants {
    public static final String JDBC_HIVE_STORAGE_HANDLER_ID =
            "org.apache.hive.storage.jdbc.JdbcStorageHandler";
    public static final String JDBC_CONFIG_PREFIX = "hbh.jdbc";
    public static final String JDBC_CATALOG = JDBC_CONFIG_PREFIX + ".catalog";
    public static final String JDBC_SCHEMA = JDBC_CONFIG_PREFIX + ".schema";
    public static final String JDBC_TABLE = JDBC_CONFIG_PREFIX + ".table";
    public static final String JDBC_DATABASE_TYPE = JDBC_CONFIG_PREFIX + ".database.type";
    public static final String JDBC_URL = JDBC_CONFIG_PREFIX + ".jdbc.url";
    public static final String JDBC_DRIVER = JDBC_CONFIG_PREFIX + ".jdbc.driver";
    public static final String JDBC_USERNAME = JDBC_CONFIG_PREFIX + ".dbcp.username";
    public static final String JDBC_PASSWORD = JDBC_CONFIG_PREFIX + ".dbcp.password";
    public static final String JDBC_KEYSTORE = JDBC_CONFIG_PREFIX + ".dbcp.password.keystore";
    public static final String JDBC_KEY = JDBC_CONFIG_PREFIX + ".dbcp.password.key";
    public static final String JDBC_QUERY = JDBC_CONFIG_PREFIX + ".query";
    public static final String JDBC_QUERY_FIELD_NAMES = JDBC_CONFIG_PREFIX + ".query.fieldNames";
    public static final String JDBC_QUERY_FIELD_TYPES = JDBC_CONFIG_PREFIX + ".query.fieldTypes";
    public static final String JDBC_SPLIT_QUERY = JDBC_CONFIG_PREFIX + ".query.split";
    public static final String JDBC_PARTITION_COLUMN = JDBC_CONFIG_PREFIX + ".partitionColumn";
    public static final String JDBC_NUM_PARTITIONS = JDBC_CONFIG_PREFIX + ".numPartitions";
    public static final String JDBC_LOW_BOUND = JDBC_CONFIG_PREFIX + ".lowerBound";
    public static final String JDBC_UPPER_BOUND = JDBC_CONFIG_PREFIX + ".upperBound";
}
