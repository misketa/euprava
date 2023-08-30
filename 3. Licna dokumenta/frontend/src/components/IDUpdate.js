import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import IDService from "../services/ID/IDService";

function IDUpdate() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [datumVazenja, setDatumVazenja] = useState("");

  useEffect(() => {
    IDService.getIDById(id).then((res) => {
      let idData = res.data;

      setDatumVazenja(idData.datumVazenja);
    });
  }, [id]);

  const updateID = (e) => {
    e.preventDefault();
    const idData = {
      datumVazenja,
    };

    IDService.updateID(idData, id).then(() => {
      navigate("/id-list");
    });
  };

  const cancel = () => {
    navigate("/id-list");
  };

  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Update ID's date of expire</h3>
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label> Datum Vazenja: </label>
                  <input
                    placeholder="Datum Vazenja"
                    name="datumVazenja"
                    className="form-control"
                    value={datumVazenja}
                    onChange={(e) => setDatumVazenja(e.target.value)}
                  />
                </div>
                {/* Other form fields */}
                {/* ... */}
                <button className="btn btn-success" onClick={updateID}>
                  Save
                </button>
                <button
                  className="btn btn-danger"
                  onClick={cancel}
                  style={{ marginLeft: "10px" }}
                >
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default IDUpdate;
