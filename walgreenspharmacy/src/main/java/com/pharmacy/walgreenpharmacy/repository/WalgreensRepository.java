package com.pharmacy.walgreenpharmacy.repository;


import com.pharmacy.walgreenpharmacy.model.Walgreens;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface WalgreensRepository extends CrudRepository<Walgreens,Long> {}

