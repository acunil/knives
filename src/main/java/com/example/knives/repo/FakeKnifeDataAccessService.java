package com.example.knives.repo;

import com.example.knives.model.Knife;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeKnifeDataAccessService implements KnifeDao {

    private static List<Knife> DB = new ArrayList<>();

    @Override
    public int addKnife(UUID id, Knife knife) {
        DB.add(new Knife(id,
            knife.getName(),
            knife.getLength(),
            knife.getType(),
            knife.getBladeMaterial(),
            knife.getHandleMaterial()));
        return 1;
    }

    @Override
    public List<Knife> selectAllKnives() {
        return DB;
    }

    @Override
    public Optional<Knife> selectKnifeById(UUID id) {
        return DB.stream().filter(knife -> id.equals(knife.getId())).findFirst();
    }

    @Override
    public int updateKnifeById(UUID id, Knife updated) {
        return selectKnifeById(id)
            .map(existingKnife -> {
                int indexOfExistingKnife = DB.indexOf(existingKnife);
                Knife newKnife = new Knife(id,
                    updated.getName(),
                    updated.getLength(),
                    updated.getType(),
                    updated.getBladeMaterial(),
                    updated.getHandleMaterial());
                DB.set(indexOfExistingKnife, newKnife);
                return 1;
            })
            .orElse(0);
    }

    @Override
    public int deleteKnifeById(UUID id) {
        Optional<Knife> knifeMaybe = selectKnifeById(id);
        if (knifeMaybe.isEmpty()) {
            return 0;
        } else {
            DB.remove(knifeMaybe.get());
            return 1;
        }
    }
}
