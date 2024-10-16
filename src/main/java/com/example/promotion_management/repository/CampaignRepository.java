package com.example.promotion_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.promotion_management.model.Campaign;

// provides set of built-in methods for working with campaign entities
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    // additional custom queries can be put here as needed

    /*
        T save(S entity): Saves a given entity.
        Optional<T> findById(ID id): Finds an entity by its primary key.
        boolean existsById(ID id): Checks if an entity exists by its primary key.
        Iterable<T> findAll(): Retrieves all entities.
        Iterable<T> findAllById(Iterable<ID> ids): Retrieves entities by a collection of primary keys.
        long count(): Counts the number of entities.
        void deleteById(ID id): Deletes an entity by its primary key.
        void delete(T entity): Deletes a given entity.
        void deleteAll(Iterable<? extends T> entities): Deletes multiple entities.
        void deleteAll(): Deletes all entities.

        Iterable<T> findAll(Sort sort): Retrieves all entities sorted by the specified field(s).
        Page<T> findAll(Pageable pageable): Retrieves entities in a paginated way.

        List<T> findAll(): Returns all entities as a list.
        List<T> findAllById(Iterable<ID> ids): Returns all entities with the given IDs as a list.
        void deleteAllInBatch(): Deletes all entities in a batch.
        void deleteAllInBatch(Iterable<T> entities): Deletes multiple entities in a batch.
        void deleteInBatch(Iterable<T> entities): Deletes multiple entities in a batch.
        T getOne(ID id): Gets a reference to an entity by its ID (lazily loads the entity).
        List<T> findAll(Sort sort): Finds all entities with sorting.
        Page<T> findAll(Pageable pageable): Finds all entities with pagination.
     */
}
