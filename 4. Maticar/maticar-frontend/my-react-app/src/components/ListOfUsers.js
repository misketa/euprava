import React, { useEffect, useState } from "react";
import axios from "axios";

const ListOfUsers = () => {
  const [tableData, setTableData] = useState([]);
  const [searchJmbg, setSearchJmbg] = useState("");
  const [filteredData, setFilteredData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:2002/api/users/findAllUsers")
      .then((response) => {
        console.log(response);
        setTableData(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  useEffect(() => {
    if (searchJmbg.trim() === "") {
      setFilteredData(tableData);
    } else {
      const filtered = tableData.filter((item) =>
        item.identificationNumber.includes(searchJmbg)
      );
      setFilteredData(filtered);
    }
  }, [searchJmbg, tableData]);

  return (
    <div>
      <div>
        <label>Search by JMBG: </label>
        <input
          type="text"
          value={searchJmbg}
          onChange={(e) => setSearchJmbg(e.target.value)}
        />
      </div>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Identification Number</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Citizenship</th>
            <th>Address</th>
            <th>City of Birth</th>
            <th>Date of Birth</th>
            <th>Country of Birth</th>
            <th>Email</th>
            <th>Role</th>
          </tr>
        </thead>
        <tbody>
          {filteredData.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.username}</td>
              <td>{item.identificationNumber}</td>
              <td>{item.name}</td>
              <td>{item.lastname}</td>
              <td>{item.gender}</td>
              <td>{item.citizenship}</td>
              <td>{item.address}</td>
              <td>{item.cityOfBirth}</td>
              <td>{item.dateOfBirth}</td>
              <td>{item.countryOfBirth}</td>
              <td>{item.email}</td>
              <td>{item.role}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListOfUsers;
