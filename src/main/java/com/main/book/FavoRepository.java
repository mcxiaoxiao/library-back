package com.main.book;

import com.main.schema.FavoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoRepository extends JpaRepository<FavoEntity, Integer>
{

}
