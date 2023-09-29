package com.example.ru.springbootmvc.repository;

import com.example.ru.springbootmvc.entity.PasteBoxEntity;
import com.example.ru.springbootmvc.exception.NotFoundEntityException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PasteBoxRepositoryImpl implements PasteBoxRepository {

    private final Map<String , PasteBoxEntity> vault = new ConcurrentHashMap<>();

    @Override
    public PasteBoxEntity getByHash(String hash) {
        var pasteBoxEntity = vault.get(hash);

        if (pasteBoxEntity == null) {
            throw new NotFoundEntityException("PasteBox not found with hash=" + hash);
        }
        return pasteBoxEntity;
    }

    @Override
    public List<PasteBoxEntity> getListPublicAndAlive(int amount) {
        LocalDateTime now = LocalDateTime.now();
        return vault.values().stream()
                .filter(PasteBoxEntity::isPublic)
                .filter(pasteBoxEntity -> pasteBoxEntity.getLifeTime().isAfter(now))
                .sorted(Comparator.comparing(PasteBoxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PasteBoxEntity pasteBoxEntity) {
        vault.put(pasteBoxEntity.getHash(), pasteBoxEntity);

    }

}
