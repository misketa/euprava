package com.licnaDokumenta.repository;

import com.licnaDokumenta.model.UverenjeOKrivicnojOdgovornosti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NekaznjavanjeRepository extends JpaRepository<UverenjeOKrivicnojOdgovornosti, Long> {
}
