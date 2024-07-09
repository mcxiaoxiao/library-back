package com.main.reader;

import com.main.schema.BookEntity;
import com.main.schema.HistoryEntity;
import com.main.schema.ReaderEntity;
import com.main.schema.TakeEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReaderService {
    List<ReaderEntity> findReaderAll();
    ReaderEntity deleteReader(int readerid);
    ReaderEntity findReaderById(int readerid);
    ReaderEntity addReader(ReaderEntity reader);

}
