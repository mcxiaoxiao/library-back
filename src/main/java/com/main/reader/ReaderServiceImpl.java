package com.main.reader;

import com.main.schema.BookEntity;
import com.main.schema.HistoryEntity;
import com.main.schema.ReaderEntity;
import com.main.schema.TakeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderRepository readerRepository;
    public ReaderServiceImpl(ReaderRepository readerRepository)
    {
        this.readerRepository=readerRepository;
    }
    @Override
    public List<ReaderEntity> findReaderAll() {
        return readerRepository.findAll();
    }
    @Override
    public ReaderEntity findReaderById(int id) {
        return readerRepository.findById(id).orElse(null);
    }
    @Override
    public ReaderEntity addReader(ReaderEntity reader)
    {
        return readerRepository.save(reader);
    }

    @Override
    public ReaderEntity deleteReader(int readerid) {
        ReaderEntity reader=readerRepository.findById(readerid).orElse(null);
        readerRepository.deleteById(readerid);
        return reader;
    }

}
