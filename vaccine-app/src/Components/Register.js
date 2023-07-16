
 import { ToastContainer, toast } from "react-toastify";
import React, { useState } from 'react';
import 'react-toastify/dist/ReactToastify.css';
import { Button } from "bootstrap";

function Register() {
  const [center, setCenter] = useState({
    name: '',
    password: '',
    area: ''
  });
  const [caddress,setaddress]=useState({ cpincode: '',
                                            cstate: '',
                                            cdistrict: '',
                                            carea:''})

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
     
      const response = await fetch('http://localhost:9090/center', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: center.name,
            password:center.password,
            area: center.area,
            caddress:{

                    cpincode:caddress.cpincode,
                    cstate: caddress.cstate,
                    cdistrict: caddress.cdistrict,
                    carea:caddress.carea
            }
        })
      });
      const data = await response.json();
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleChange = (e) => {
    setCenter({
      ...center,
      [e.target.name]: e.target.value
    });
  };
  const handleaddresschange=(e)=>{
    setaddress({
        ...caddress,
        [e.target.name]:e.target.value
    });
  }

  const showToastMessage = () => {
    toast.success('Successfully Register !');
    
};


  return (<div>
    
    <ToastContainer/>
    <form onSubmit={handleSubmit}>
        <center>
      <table className='table table-bordered content' >

    <thead >
        <tr>
        <td  colSpan={2}><div className="ml-10"><h3>Register Center</h3></div></td>   
        
        </tr>
        
    </thead>

        <tbody>
            <tr>
                <td> Name:</td>
                <td><input type="text" name="name" onChange={handleChange} value={center.name} /></td>
                </tr>
    
        <tr>
           <td> Password:</td>
           <td><input type="password" name="password" onChange={handleChange} value={center.password} /></td>
           </tr>
        
        <tr>
            <td>Landmark:</td>
            <td><input type="text" name="area" onChange={handleChange} value={center.area} /></td>
            </tr>
        
        <tr>
            <td>Pincode:</td>
            <td><input type="text" name="cpincode" onChange={handleaddresschange} value={caddress.cpincode} /></td>
            </tr>
        
        <tr>
            <td>State:</td>
            <td><input type="text" name="cstate" onChange={handleaddresschange} value={caddress.cstate} /></td>
            </tr>
        
        <tr>
            <td>District:</td>
            <td><input type="text" name="cdistrict" onChange={handleaddresschange} value={caddress.cdistrict} /></td>
            </tr>
        
        <tr>
            <td>CArea:</td>
            <td><input type="text" name="carea" onChange={handleaddresschange} value={caddress.carea} /></td>
            </tr>
        
        <tr style={{textAlign:"center"}}><td colSpan={2} onClick={showToastMessage}><button type="submit">Register Center</button></td></tr>
        
      </tbody>
      </table>
      </center>
    </form>
    </div>
  );
}
export default Register;