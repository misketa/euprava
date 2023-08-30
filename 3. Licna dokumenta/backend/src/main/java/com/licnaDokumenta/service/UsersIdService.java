package com.licnaDokumenta.service;

import com.licnaDokumenta.dto.*;
import com.licnaDokumenta.model.Passport;
import com.licnaDokumenta.model.UsersId;
import com.licnaDokumenta.repository.UserRepository;
import com.licnaDokumenta.repository.UsersIdRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UsersIdService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersIdRepository usersIdRepository;

    public IDResponse generateID(final IDRequest request) {

        IDResponse response = new IDResponse("Izdaje se uverenje o vazecoj licnoj karti za  "
                + request.getName() + " " + request.getLastName()
                + ", JMBG: " + request.getJmbg() + " u svrhu " + request.getPurpose());

        noteUserRequestedCertificate(request, response.getMessage());

        return response;
    }

    private void noteUserRequestedCertificate(final IDRequest request, final String message) {
        UsersId usersId = new UsersId(request.getJmbg(), message);
        usersIdRepository.save(usersId);
    }

    public CheckUserIDResponse checkUserIDResponse(final String jmbg) {
        List<UsersId> idsOfUser = usersIdRepository.findByUserJmbg(jmbg);
        if (idsOfUser.isEmpty()) {
            return new CheckUserIDResponse(false);
        }
        return new CheckUserIDResponse(true);
    }

    public void remove(Long id) {
        usersIdRepository.deleteById(id);
    }

    public void save(UsersId usersId) {
        usersIdRepository.save(usersId);
    }

    public List<UsersId> findAll() {
       return usersIdRepository.findAllIDs();
    }

    public UsersId update(Long id, IDDto idDto) {
        UsersId usersId = (UsersId) usersIdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "UsersID with id " + id + " not found"));


        usersId.setDatumVazenja(idDto.getDatumVazenja());

        return usersIdRepository.save(usersId);

    }

    public UsersId findOne(Long id) {
        return  usersIdRepository.findById(id).orElse(null);
    }
}
