package com.example.knives.service;

import com.example.knives.model.Knife;
import com.example.knives.repo.KnifeDao;
import com.example.knives.util.RandomUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KnifeService {

    private final KnifeDao knifeDao;

    public KnifeService(@Qualifier("fakeDao") KnifeDao knifeDao) {
        this.knifeDao = knifeDao;
    }

    public int addKnife(Knife knife) {
        return knifeDao.addKnife(knife);
    }

    public int addRandomKnife(String name) {
        return knifeDao.addKnife(RandomUtil.randomKnife(name));
    }

    public List<Knife> selectAllKnives() {
        return knifeDao.selectAllKnives();
    }

    public Optional<Knife> selectKnifeById(UUID id) {
        return knifeDao.selectKnifeById(id);
    }

    public int updateKnifeById(UUID id, Knife knife) {
        return knifeDao.updateKnifeById(id, knife);
    }

    public int deleteKnifeById(UUID id) {
        return knifeDao.deleteKnifeById(id);
    }

}
