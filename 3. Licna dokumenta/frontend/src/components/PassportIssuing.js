import React, { useState } from "react";
import { savePassport } from "../services/ID/passportActions";

const PassportIssuing = (props) => {
  const [jmbg, setJmbg] = useState("");
  const [name, setName] = useState("");
  const [lastname, setLastname] = useState("");
  const [gender, setGender] = useState("");
  const [citizenship, setCitizenship] = useState("");
  const [address, setAddress] = useState("");
  const [cityOfBirth, setCityOfBirth] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [countryOfBirth, setCountryOfBirth] = useState("");
  const [datumVazenja, setDatumVazenja] = useState("");
  const [show, setShow] = useState(false);
  const [method, setMethod] = useState("");

  const initialState = {
    jmbg: "",
    name: "",
    lastname: "",
    gender: "",
    citizenship: "",
    address: "",
    cityOfBirth: "",
    dateOfBirth: "",
    countryOfBirth: "",
    datumVazenja: "",
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    const id = {
      jmbg,
      name,
      lastname,
      gender,
      citizenship,
      address,
      cityOfBirth,
      dateOfBirth,
      countryOfBirth,
      datumVazenja,
    };

    const { payload } = await savePassport(id);
    if (payload) {
      setShow(true);
      setMethod("post");
      setTimeout(() => setShow(false), 3000);
    }

    setJmbg("");
    setName("");
    setLastname("");
    setGender("");
    setCitizenship("");
    setAddress("");
    setCityOfBirth("");
    setDateOfBirth("");
    setCountryOfBirth("");
    setDatumVazenja("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <label for="jmbg">JMBG:</label>
      <br />
      <input
        type="text"
        id="jmbg"
        name="jmbg"
        value={jmbg}
        onChange={(event) => setJmbg(event.target.value)}
      />
      <br />

      <label for="name">Name:</label>
      <br />
      <input
        type="text"
        id="name"
        name="name"
        value={name}
        onChange={(event) => setName(event.target.value)}
      />
      <br />

      <label for="lastname">Last Name:</label>
      <br />
      <input
        type="text"
        id="lastname"
        name="lastname"
        value={lastname}
        onChange={(event) => setLastname(event.target.value)}
      />
      <br />

      <label for="gender">Gender:</label>
      <br />
      <input
        type="text"
        id="gender"
        name="gender"
        value={gender}
        onChange={(event) => setGender(event.target.value)}
      />
      <br />

      <label for="address">Address:</label>
      <br />
      <input
        type="text"
        id="address"
        name="address"
        value={address}
        onChange={(event) => setAddress(event.target.value)}
      />
      <br />

      <label for="cityOfBirth">City of Birth:</label>
      <br />
      <input
        type="text"
        id="cityOfBirth"
        name="cityOfBirth"
        value={cityOfBirth}
        onChange={(event) => setCityOfBirth(event.target.value)}
      />
      <br />

      <label for="dateOfBirth">Date of Birth:</label>
      <br />
      <input
        type="date"
        id="dateOfBirth"
        name="dateOfBirth"
        value={dateOfBirth}
        onChange={(event) => setDateOfBirth(event.target.value)}
      />
      <br />

      <label for="countryOfBirth">Country of birth:</label>
      <br />
      <input
        type="text"
        id="countryOfBirth"
        name="countryOfBirth"
        value={countryOfBirth}
        onChange={(event) => setCountryOfBirth(event.target.value)}
      />
      <br />

      <label for="message">Datum vazenja:</label>
      <br />
      <input
        type="date"
        id="datumVazenja"
        name="datumVazenja"
        value={datumVazenja}
        onChange={(event) => setDatumVazenja(event.target.value)}
      />
      <br />
      <br />

      <button type="submit">Submit</button>

      {show && <div>Pasoš je izdat.</div>}
    </form>
  );
};

export default PassportIssuing;
