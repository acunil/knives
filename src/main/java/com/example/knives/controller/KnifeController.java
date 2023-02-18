package com.example.knives.controller;

import com.example.knives.model.Knife;
import com.example.knives.service.KnifeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@RequestMapping("api/v1/knife")
@RestController
public class KnifeController {

    private final KnifeService knifeService;

    @Autowired
    public KnifeController(KnifeService knifeService) {
        this.knifeService = knifeService;
    }

    @PostMapping
    public void addKnife(@Valid @NonNull @RequestBody Knife knife) {
        knifeService.addKnife(knife);
    }

    @PostMapping(path = "random")
    public void addRandomKnife(@RequestBody String name) {
        knifeService.addRandomKnife(name);
    }

    @GetMapping
    public List<Knife> getAllKnives() {
        return knifeService.selectAllKnives();
    }

    @GetMapping(path = "{id}")
    public Knife getKnifeById(@PathVariable("id") UUID id) {
        return knifeService.selectKnifeById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateKnifeById(@PathVariable("id") UUID id,
                                @Valid @NonNull @RequestBody Knife knife) {
        knifeService.updateKnifeById(id, knife);
    }

    @DeleteMapping(path = "{id}")
    public void deleteKnifeById(@PathVariable("id") UUID id) {
        knifeService.deleteKnifeById(id);
    }

}
