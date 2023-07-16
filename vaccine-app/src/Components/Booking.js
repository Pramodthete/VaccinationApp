import { useEffect, useState } from "react";
//import "./asset/common.css";
import { Link, Route, Switch } from "react-router-dom";
//import "../node_modules/bootstrap/dist/css/bootstrap.css";
//import { useHistory } from "react-router-dom";
import { Table, Thead, Tbody, Tr, Th, Td } from "react-super-responsive-table";
import "react-super-responsive-table/dist/SuperResponsiveTableStyle.css";
import "./show.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Booking() {
  const [branch, setbranch] = useState([]);
  //const [customer, setcustomer] = useEffect({});
  const [order, setorder] = useState([]);
  const [Status, setstatus] = useState({ paid: 0, approve: 0 });
  const history = useNavigate();
  useEffect(() => {
    var helper = new XMLHttpRequest();
    helper.onreadystatechange = () => {
      if (helper.readyState === 4 && helper.status === 200) {
        var result = JSON.parse(helper.responseText);
        setbranch(result);
      //  console.log(result);
      }
    };

    helper.open("GET", "http://localhost:9090/centers");
    helper.send();
  }, []);

  const selectbranch = (branchId) => {
    console.log(branchId);
    sessionStorage.setItem("branchId",branchId)
    const id = sessionStorage.getItem("branchId")
    var helper = new XMLHttpRequest();
    helper.onreadystatechange = () => {
      if (helper.readyState === 4 && helper.status === 200) {
        var result = JSON.parse(helper.responseText);
        //setcustomer(result.customers);
        setorder(result);
        console.log(order);
      }
    };

    helper.open("GET", "http://localhost:9090/bookingCenter/" +id);
    helper.send();
    // sessionStorage.setItem("branchId", branchId);
    // const id = sessionStorage.getItem("branchId");
    // console.log("from Session" + id);
  };
  useEffect(() => {
    const id = sessionStorage.getItem("branchId");
    console.log("inside" + id);
    var helper = new XMLHttpRequest();
    helper.onreadystatechange = () => {
      if (helper.readyState === 4 && helper.status === 200) {
        var result = JSON.parse(helper.responseText);
        //setcustomer(result.customers);
       // setorder(result);
        console.log("booking"+result);
      }
    };

    helper.open("GET", "http://localhost:9090/bookingCenter/"+id );
    helper.send();
  }, []);
  const gotoDetails = (ID) => {
    //const { data } = await axios.get(`http://localhost:4000/branch/${ID}`);
    history.push("showDetails", { params: ID });
    console.log(ID);
  };
  // debugger;

  const Register = (No) => {
    console.log("IDHAR AYA" + No);
    setstatus({ approve: ""});
    var helper = new XMLHttpRequest();
    helper.onreadystatechange = () => {
      if (helper.readyState == 4 && helper.status == 200) {
        var result = JSON.parse(helper.responseText).data;
        console.log("IDHAR AYA" + No);
      }
    };
    helper.open("PUT", "http://localhost:9090/booking/" + No);
    helper.setRequestHeader("Content-Type", "application/json");
    helper.send();
  };

  return (
    <div>
      <div>
        Select Your Branch
        <select>
          <option>Choose Branch</option>
          {branch.map((br) => (
            <option
              key={br.id}
              value={br.id}
              onClick={() => {
                selectbranch(br.id);
               // console.log(br.id)
              }}
            >
              {br.name}
            </option>
          ))}
        </select>
      </div>

      <div className="container my-5">
        <div>
          <div>
            <Table className="table table-bordered marginset">
              <Thead style={{ backgroundColor: "#539196" }}>
                <Tr>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Serial No</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Booking ID</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">User First Name</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">User Last Name</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Booking Date</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold"> VStatus</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Vaccine NAme</h1>
                    </div>
                  </Th>
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Time Slot</h1>
                    </div>
                  </Th>
                 
                  <Th>
                    <div>
                      <h1 className="h5 fw-bold">Status</h1>
                    </div>
                  </Th>
                </Tr>
              </Thead>
              <Tbody>
                {order.map((emp, index) => {
                  return (
                    <Tr key={index}>
                      <th scope="row">{index + 1}</th>
                      <td>
                        <div>
                          <h1 className="h6">{emp.id}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.user.firstname}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.user.lastname}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.udoseDate.userdosedate}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.vaccinationStatus}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.vaccine.vaccineName}</h1>
                        </div>
                      </td>
                      <td>
                        <div>
                          <h1 className="h6">{emp.utimeSlot}</h1>
                        </div>
                      </td>
                      
                      <td>
                        <div>
                          <form
                            method="get"
                            action="controller"
                            className="d-flex btn-group"
                          >
                            <input
                              type="hidden"
                              name="command"
                              value="refresh-order-status"
                            />
                            <select
                              name="status"
                              className="btn btn-outline-dark"
                            >
                              <option
                                value="REGISTERED"
                                className="form-select-button"
                                onClick={() => {
                                  Register(emp.id);
                                }}
                              >
                                PAID
                              </option>
                              <option
                                value="CANCELED"
                                className="form-select-button"
                              >
                                CANCELED
                              </option>
                            </select>
                            
                          </form>
                        </div>
                      </td>
                    </Tr>
                  );
                })}
              </Tbody>
            </Table>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Booking;
