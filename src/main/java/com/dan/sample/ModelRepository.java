

package com.dan.sample;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ModelRepository extends MongoRepository<Model, String> {

    List<Model> findByaStringProp(String toFind);

    List<Model> findByanIntProp(int toFind);

    @Override
    default <S extends Model> S save(final S arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
