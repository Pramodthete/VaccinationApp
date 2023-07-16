import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";



function CenterLogin() {
  const [center, setCenter] = useState({
    id:0,
    password:""
  });
  const [cmessage, setCmessage] = useState("");
  const [centerId,setCenterId] = useState({userId:0})
    const history=useNavigate() 

  useEffect(() => {
    if (cmessage != "") {
      setTimeout(() => {
        setCmessage("Session Timeout");
      }, 20000);
    }
  }, [cmessage]);


  const signIn = async (e) => {
    e.preventDefault();
    try {
     
      const response = await fetch('http://localhost:9090/center/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: center.id,
            password: center.password
   
        })
      });
      const data = await response.json();
      console.log(data);
      // sessionStorage.setItem("userId",data)
      if(data.message==="No value present"){
        console.log("if k adar idhar aya")
    }
    else{
      checksignIn(data);
    }
      
    } catch (error) {
      console.error(error);
      cmessage="please enter valid credentials"
    }
   
  };
  const handleChange = (e) => {
    setCenter({
      ...center,
      [e.target.name]: e.target.value
    });
  };

  const clearBoxes = () => {
    setCenter({
      value:null
    });
  };


  const checksignIn = (data) => {
    console.log(data.id);
    if (Object.keys(data).length === 0) {
      // clearBoxes();
      setCmessage("Email / password is Null!");
    }
    if (Object.keys(data).length != null) {
      console.log("Not Empty");
      sessionStorage.setItem("isloggedin", "true");
      setCenterId( data.id);
      sessionStorage.setItem("userId",data.id);
      sessionStorage.setItem("useRole",data.role);
      console.log(data.id);

      history({
        pathname:"/home",
      state:{centerId}});
    //   history.push("/SearchNearbyCenter");
      const sessionid = sessionStorage.getItem("userId");
    //   console.log( sessionid);
    }
  };

 
  return (
    <div>
      <center>
        <br></br>
        <br></br>
        <br></br>
        <table>
          <tbody>
            <tr>
              <td className="td">Center Id</td>
              <td className="td">
                <input
                  type="number"
                  name="id"
                  required
                  value={center.id}
                  onChange={handleChange}
                />
              </td>
            </tr>

            <tr>
              <td className="td">Password</td>
              <td className="td">
                <input
                  type="password"
                  name="password"
                  required
                  value={center.password}
                  onChange={handleChange}
                />
              </td>
            </tr>
            <tr>
              <td className="td">
                <button className="btn btn-primary" onClick={signIn}>
                  Log in
                </button>
              </td>
              <td className="td">
                <button className="btn btn-danger" onClick={clearBoxes}>
                  Reset
                </button>
              </td>
            </tr>
          </tbody>
        </table>
        <h6 style={{ color: "orangered" }}>{cmessage}</h6>
      </center>
    </div>
  );
}

export default CenterLogin;