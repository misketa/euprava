package com.licnaDokumenta.service;

import com.licnaDokumenta.dto.PassportDTO;
import com.licnaDokumenta.dto.UpdatePassportDto;
import com.licnaDokumenta.model.Passport;
import com.licnaDokumenta.repository.PassportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    public Passport findOne(Long id) {
        return  passportRepository.findById(id).orElse(null);
    }

    public void save(Passport passport) {
        passportRepository.save(passport);
    }


//TODO OBRISAO SAM PRE passportRepository.findById(id), (Passport) ako bude pucao kod vratiti to
    public Passport update(Long id, UpdatePassportDto passportDTO) {
        Passport passport =  passportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Passport with id " + id + " not found"));


        passport.setDatumVazenja(passportDTO.getDatumVazenja());

        return passportRepository.save(passport);

    }
}

