import * as IT from "./idTypes";
import axios from "axios";

export async function saveID(id) {
  try {
    const response = await axios.post(
      "http://localhost:3002/api/id-certificates/createIDforUser",
      id
    );
    return idSuccess(response.data);
  } catch (error) {
    idFailure(error);
  }
}

const idSuccess = (id) => {
  return {
    type: IT.ID_FAILURE,
    payload: id,
  };
};

const idFailure = (error) => {
  return {
    type: IT.ID_FAILURE,
    payload: error,
  };
};
