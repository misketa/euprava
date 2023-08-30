import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import PassportService from "../services/ID/PassportService";

function PassportUpdate() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [datumVazenja, setDatumVazenja] = useState("");

  useEffect(() => {
    PassportService.getPassportById(id).then((res) => {
      let idData = res.data;
      setDatumVazenja(idData.datumVazenja);
    });
  }, [id]);

  const updatePassport = (e) => {
    e.preventDefault();
    const idData = {
      datumVazenja,
    };

    PassportService.updatePassport(idData, id).then(() => {
      navigate("/passport-issuing");
    });
  };

  const cancel = () => {
    navigate("/passport-issuing");
  };

  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Update passport's date of expire</h3>
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
                <button className="btn btn-success" onClick={updatePassport}>
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

export default PassportUpdate;
