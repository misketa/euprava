import axios from "axios";

const PASSPORT_API_BASE_URL = "http://localhost:3002/api/passport";

class PassportService {
  getPassportById(passportId) {
    return axios.get(PASSPORT_API_BASE_URL + "/" + passportId);
  }

  createPassport(passport) {
    return axios.post(PASSPORT_API_BASE_URL + "/create", passport);
  }

  updatePassport(passport, passportId) {
    return axios.put(PASSPORT_API_BASE_URL + "/update/" + passportId, passport);
  }
  
}

export default new PassportService();
