package com.licnaDokumenta.controller;

import com.licnaDokumenta.dto.*;
import com.licnaDokumenta.model.Passport;
import com.licnaDokumenta.model.User;
import com.licnaDokumenta.model.UsersId;
import com.licnaDokumenta.service.UsersIdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/id-certificates")
public class IDCertificateController {

    @Autowired
    private UsersIdService usersIdService;

    @PostMapping
    public ResponseEntity<IDResponse> generateIDCertificateForUser(
            @RequestBody @Valid IDRequest request
    ){
        return ResponseEntity.ok(usersIdService.generateID(request));
    }

    @GetMapping("/{jmbg}")
    public ResponseEntity<CheckUserIDResponse> checkIfUserHasCertificate(@PathVariable String jmbg) {
        return ResponseEntity.ok(usersIdService.checkUserIDResponse(jmbg));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteID(@PathVariable Long id) {
        usersIdService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersId> findOne(@PathVariable Long id) {
        UsersId usersId =  usersIdService.findOne(id);
        return new ResponseEntity<>(usersId, HttpStatus.OK);
    }

    @PostMapping("/createIDforUser")
    public ResponseEntity<UsersId> save(@RequestBody UsersId usersId) {
        usersIdService.save(usersId);
        return new ResponseEntity<>(usersId, HttpStatus.CREATED);
    }

    @GetMapping("/findAllIDs")
    public ResponseEntity<List<UsersId>> findAllIDs() {
        List<UsersId> response =  usersIdService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<UsersId> update(@PathVariable("id") Long id,
                                           @Valid @RequestBody IDDto idDto) {
        UsersId update = usersIdService.update(id, idDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
//TODO DODATI LOGIKU ZA PROVERU KADA JE DOZVOLJENO PRODUZENJE LICNE KARTE

}