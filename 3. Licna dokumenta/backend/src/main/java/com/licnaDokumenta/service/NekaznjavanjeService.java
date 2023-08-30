package com.licnaDokumenta.service;

import com.licnaDokumenta.dto.ResponseOKaznjavanju;
import com.licnaDokumenta.dto.UverenjeOKaznjavanjuDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NekaznjavanjeService {

    public ResponseOKaznjavanju generateResponse(final UverenjeOKaznjavanjuDTO request) {

        ResponseOKaznjavanju response = new ResponseOKaznjavanju("Izdaje se uverenje o nekaznjavanju za  "
                + request.getName() + " " + request.getLastName()
                + ", JMBG: " + request.getJmbg() + " rodjen u  " + request.getDrzavaRodjenja() + " dana  " + request.getDatumRodjenja());



        return response;
    }


}
