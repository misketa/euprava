package com.licnaDokumenta.controller;

import com.licnaDokumenta.dto.ResponseOKaznjavanju;
import com.licnaDokumenta.dto.UverenjeOKaznjavanjuDTO;
import com.licnaDokumenta.service.NekaznjavanjeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/nekaznjavanje")
public class NekaznjavanjeController {

    @Autowired
    private NekaznjavanjeService nekaznjavanjeService;

    @PostMapping
    public ResponseEntity<ResponseOKaznjavanju> generateResponse(
            @RequestBody @Valid UverenjeOKaznjavanjuDTO request
    ){
        return ResponseEntity.ok(nekaznjavanjeService.generateResponse(request));
    }
}
