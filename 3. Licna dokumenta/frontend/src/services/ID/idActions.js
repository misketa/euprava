import * as IT from "./idTypes";
import axios from "axios";

const baseUrl = "http://localhost:3002/api/";
const axiosInstance = axios.create({
  baseURL: baseUrl,
  headers: {
    Authorization: localStorage.getItem("token") || undefined,
  },
});

export async function saveID(id) {
  try {
    const response = await axiosInstance.post(
      "/id-certificates/createIDforUser",
      id
    );
    return idSuccess(response.data);
  } catch (error) {
    idFailure(error);
  }
}

const idSuccess = (data) => {
  return {
    type: "SUCCESS",
    payload: data,
  };
};

const idFailure = (error) => {
  return {
    type: IT.ID_FAILURE,
    payload: error,
  };
};
