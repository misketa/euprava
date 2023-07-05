import React, { useEffect, useState } from "react";
import axios from "axios";

const IDList = () => {
  const [tableData, setTableData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:3002/api/id-certificates/findAllIDs")
      .then((response) => {
        setTableData(response.data.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>JMBG</th>
          <th>Name</th>
          <th>Last name</th>
          <th>Address</th>
          <th>Date of birth</th>
          <th>Message</th>
        </tr>
      </thead>
      <tbody>
        {tableData.map((item) => (
          <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.jmbg}</td>
            <td>{item.name}</td>
            <td>{item.lastname}</td>
            <td>{item.address}</td>
            <td>{item.dateofbirth}</td>
            <td>{item.message}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default IDList;
