package work.dirtsai.mockredbook.kv.biz.domain.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import work.dirtsai.mockredbook.kv.biz.domain.dataobject.NoteContentDO;

import java.util.UUID;

public interface NoteContentRepository extends CassandraRepository<NoteContentDO, UUID> {

}