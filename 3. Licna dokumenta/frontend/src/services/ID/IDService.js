import axios from "axios";

const ID_API_BASE_URL = "http://localhost:3002/api/id-certificates";

class IDService {
  createID(id) {
    return axios.post(ID_API_BASE_URL + "/createIDforUser", id);
  }

  getIDById(idsID) {
    return axios.get(ID_API_BASE_URL + "/" + idsID);
  }

  updateID(id, idsID) {
    return axios.put(ID_API_BASE_URL + "/update/" + idsID, id);
  }
}

export default new IDService();
