package com.example.knives.repo;


import com.example.knives.model.Knife;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KnifeDao {

    int addKnife(UUID id, Knife knife);

    default int addKnife(Knife knife) {
        UUID id = UUID.randomUUID();
        return addKnife(id, knife);
    }

    List<Knife> selectAllKnives();

    Optional<Knife> selectKnifeById(UUID id);

    int updateKnifeById(UUID id, Knife knife);

    int deleteKnifeById(UUID id);

}
