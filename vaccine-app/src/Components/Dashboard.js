import { useEffect, useState } from 'react';
import {  useNavigate } from 'react-router-dom';
import './common.css'
import Users from './Users';
import axios from 'axios';
function Dashboard() 
{
    var [userName, setuserName] = useState("");
    var [message, setMessage] = useState("");
    var history = useNavigate();

    

    const win = window.sessionStorage;
    

    var [users, setUsers]  = useState([]);
    var [user,setUser]  = useState([]);

    var [searchText,setsearchText] = useState("");

    useEffect(()=>{
        var helper = new XMLHttpRequest();
        helper.onreadystatechange=()=>{
            if(helper.readyState==4 && 
               helper.status==200)
               {
                var result = 
                    JSON.parse(helper.responseText);
                    debugger;
                setUsers(result);
               }
        };
        helper.open("GET", "http://localhost:9090/users");
        helper.send();
    }, []);

   
    
    var HandleChange=(args)=>{
        var copyOfUser = {...user};
        copyOfUser[args.target.name] = args.target.value;
        setUser(copyOfUser);
    }

    var  Search=(args)=>{
        setsearchText(args.target.value);
    }

    var Clear =()=>{
        setsearchText("");
    }
    

    var Add=()=>{
        var copyOfUsers = [...users];
        copyOfUsers.push(user);
        debugger;
        setUsers(copyOfUsers);
        setUser({id: 0, firstname: "", lastname:""});
    }

    useEffect(()=>{
        setMessage("Collection Changed!");
        setTimeout(() => {
            setMessage("");
        }, 1000);
    }, [users])

    var  Remove=(id)=>{
        win.setItem("usrid",id);
        axios.delete("http://localhost:9090/user" + id)
        win.removeItem("usrid");
    }

    var  getUser=(id)=>{
        axios.get("http://localhost:9090/user" + id)
    .then();
    }
    
    
    var Logout = ()=>{
        win.removeItem("isLoggedIn");
        win.removeItem("userName");
        history("/login");
    }
       
    useEffect(()=>{
        document.title="Dashboard";
    })

    return (<div className='table-responsive'>
                   <div style={{float: "right"}}>
                        Welcome {" "} {userName} {" "}
                        <button className='btn btn-primary' 
                                onClick={Logout}>
                            Log out
                        </button>
                    </div>
                    <center>
                    
                    <hr></hr>
                        Search By id: <input type={"text"} 
                                        value={searchText}
                                        onChange={Search}/> {" "}
                        <button className='btn btn-info' 
                                onClick={Clear}>Clear</button>
                    <hr></hr>
                        <div className='alert alert-info'><b>{message}</b></div>
                    <hr></hr>
                    <table className='table table-bordered content'>
                        <tr>
                            <td><thead><b>User Id</b></thead></td>
                            <td><thead><b>User First Name</b></thead></td>
                            <td><thead><b>User Last Name</b></thead></td>
                            <td><thead><b>User Date Of Birth</b></thead></td>
                            <td><thead><b>User Adhar no</b></thead></td>
                            <td><thead><b>User Mobile No</b></thead></td>
                            <td><thead><b>Age</b></thead></td>
                            <td><thead><b>Remove</b></thead></td>
                        </tr>
                            <tbody>
                            {
                                
                                users.map((usr)=>
                                {
                                    
                                   //if((usr.lastname).toLowerCase().include(searchText).toLowerCase())
                                        {
                                            return (<tr key={usr.id}>
                                                <td>
                                                    {usr.id}
                                                </td>
                                                <td>
                                                    {usr.firstname}
                                                </td>
                                                <td>
                                                    {usr.lastname}
                                                </td>
                                                <td>
                                                    {usr.dob}
                                                </td>
                                                <td>
                                                    {usr.adhar}
                                                </td>
                                                <td>
                                                    {usr.mobileno}
                                                </td>
                                                <td>
                                                    {usr.age}
                                                </td>
                                                <td>
                                                <button className='btn btn-danger'
                                                onClick=
                                                    {
                                                    ()=>{
                                                            Remove(usr.id)
                                                        }
                                                    }>
                                                    Delete
                                                </button>
                                                </td>
                                            </tr>);
                                        
                                        } 
                                })
                            }
                            </tbody>
                        </table>
                    </center>
            </div>);


}
 
export default Dashboard;