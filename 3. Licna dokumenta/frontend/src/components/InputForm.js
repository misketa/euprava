import React, { useState } from "react";
import { saveID } from "../services/ID/idActions";

const InputForm = (props) => {
  const [name, setName] = useState("");
  const [lastname, setLastname] = useState("");
  const [jmbg, setJmbg] = useState("");
  const [address, setAddress] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [message, setMessage] = useState("");
  const [show, setShow] = useState(false);
  const [method, setMethod] = useState("");

  const initialState = {
    name: "",
    lastname: "",
    jmbg: "",
    address: "",
    dateOfBirth: "",
    message: "",
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    const id = {
      name,
      lastname,
      jmbg,
      address,
      dateOfBirth,
      message,
    };

    const result = await saveID(id);
    if (result) {
      setShow(true);
      setMethod("post");
      setTimeout(() => setShow(false), 3000);
    }

    setName("");
    setLastname("");
    setJmbg("");
    setAddress("");
    setDateOfBirth("");
    setMessage("");
  };

  return (
    <form onSubmit={handleSubmit}>
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

      <label for="message">Message:</label>
      <br />
      <input
        type="text"
        id="message"
        name="message"
        value={message}
        onChange={(event) => setMessage(event.target.value)}
      />
      <br />
      <br />

      <button type="submit">Submit</button>

      {show && <div>Lična karta je izdata.</div>}
    </form>
  );
};

export default InputForm;
