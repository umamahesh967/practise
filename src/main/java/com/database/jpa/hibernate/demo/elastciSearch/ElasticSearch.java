package com.database.jpa.hibernate.demo.elastciSearch;

/**
 * Highly Scalable as it is distributed in nature.
 *
 * A single machine can have multiple nodes. This means in development we can start with multiple nodes.
 *
 *
 * Whenever we store document in index, it is stored with some metadata(like version, _id).
 * Documents are stored as JSON Objects.
 *
 *
 * Sharding is way to divide index into smaller pieces. Each piece is called shard.
 * Each shard is an Apache Lucene index.
 * Parallelization of queries increase the throughput of an index.
 *
 * Once index is created with shards, we cannot change the no of shards in the index.
 * Every shard is a self-contained lucene index in itself.
 *
 * A node contain 2 primary shards of different indexes in ElasticSearch.
 *
 * @Routing
 * https://udemy.com/course/elasticsearch-complete-guide/learn/lecture/16288134#overview
 * https://udemy.com/course/elasticsearch-complete-guide/learn/lecture/16288138#overview
 * https://udemy.com/course/elasticsearch-complete-guide/learn/lecture/16288144#overview
 *
 *
 * https://bonsai.io/blog/the-importance-of-shard-math-in-elasticsearch#:~:text=Replicas%20of%20a%20primary%20shard,have%20more%20than%202%20replicas.
 * https://stackoverflow.com/questions/15694724/shards-and-replicas-in-elasticsearch#:~:text=In%20the%20cluster%20there%20can,of%20course%20hold%20more%20shards.
 *
 * Look for Inverted Index in ClassMate book.
 *
 *
 * **********Must Match***********
 * https://www.youtube.com/watch?v=ms7FtQebWLw
 *
 *
 * Elastic Stack ** Good **
 * https://www.youtube.com/watch?v=Hqn5p67uev4
 *
 *
 * Type of nodes in elastic search.
 * https://www.instaclustr.com/blog/understanding-and-configuring-elasticsearch-node-types/
 *
 * ********* How read and writes happen in elastic search *********
 * https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-replication.html
 */
public class ElasticSearch
{

}
