package com.vocabularysrs.domain.globalwords;

import org.springframework.data.repository.Repository;

interface ExampleRepository extends Repository<WordExample, Long> {

    WordExample save(WordExample example);

}
