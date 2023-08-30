package com.licnaDokumenta.repository;

import com.licnaDokumenta.model.UsersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface UsersIdRepository extends JpaRepository<UsersId, Long> {

    @Query(value = "select * from users_id where jmbg = ?1",
            nativeQuery = true)
    List<UsersId> findByUserJmbg(String jmbg);

    @Query(value = "SELECT * FROM muplicnadokumentadb.users_id", nativeQuery = true)
    List<UsersId> findAllIDs();

    @Modifying
    @Transactional
    @Query(value = "UPDATE muplicnadokumentadb.users_id SET datum_vazenja = :newDatumVazenja WHERE id = :id", nativeQuery = true)
    void updateDatumVazenjaById(@Param("id") Long id, @Param("newDatumVazenja") Date newDatumVazenja);

    //TODO IZMENITI NAZIV BAZE U QUERY JER JE U BAZI ZA DOKER NAZIV BAZE
    // MUPLICNADOKUMENTADB A U TEST LOKALNOJ BAZI JE BAZA DOKUMENTADB
    // TODO ISTO PROVERITI U SVIM REPOIMA I IZMENITI PORTOVE NA BACKU I FRONTU
}