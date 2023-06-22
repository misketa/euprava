import * as IT from "./idTypes";

const initialState = {
  ID: "",
  error: "",
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case IT.SAVE_ARTIKAL_REQUEST:
      return {
        ...state,
      };
    case IT.ID_SUCCESS:
      return {
        ID: action.payload,
        error: "",
      };
    case IT.ID_FAILURE:
      return {
        ID: "",
        error: action.payload,
      };

    default:
      return state;
  }
};

export default reducer;
