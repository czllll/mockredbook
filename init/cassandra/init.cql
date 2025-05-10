-- 1. 创建 Keyspace（库）
CREATE KEYSPACE IF NOT EXISTS algocove_cassandra
    WITH replication = {
        'class': 'SimpleStrategy',
        'replication_factor': 1
        };

-- 2. 切换到该 keyspace
USE algocove_cassandra;

-- 3. 创建 comment_content 表
CREATE TABLE IF NOT EXISTS comment_content (
                                               note_id    bigint,
                                               year_month text,
                                               content_id uuid,
                                               content    text,
                                               PRIMARY KEY ((note_id, year_month), content_id)
)
    WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
     AND compression = {'chunk_length_in_kb': '16', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
     AND speculative_retry = '99p'
     AND read_repair_chance = 0;

-- 4. 创建 note_content 表
CREATE TABLE IF NOT EXISTS note_content (
                                            id      uuid PRIMARY KEY,
                                            content text
)
    WITH caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
     AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
     AND compression = {'chunk_length_in_kb': '16', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
     AND speculative_retry = '99p'
     AND read_repair_chance = 0;
