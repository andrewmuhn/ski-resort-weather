package com.cs50.skiresortinfo.repository;

import com.cs50.skiresortinfo.domain.Resort;

import java.util.List;

public interface ResortsRepository {
    void saveResort(Resort resort);
    List<Resort> getAllResorts();

    Resort getResort(String slug);

    static ResortsRepository openResortsRepository() {
        return new ResortsJdbcRepository();
    }
}
