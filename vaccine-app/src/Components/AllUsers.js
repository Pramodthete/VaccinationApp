import React,{useState} from "react";
import Users from "./Users";
import base_url from "../api/bootapi";
import axios from "axios";

const AllUsers=()=>{

    useEffect(()=>{
        document.title="AllCenters";
        getAllUsersFromServer();
    });

    const getAllUsersFromServer=()=>{
        axios.get(`${base_url}/users`).then(
            (Response)=>{
                console.log(Response);
            },
            (error)=>{
                console.log(error);
            }
        )
    };

    const [users,setUsers]=useState([
        {title:"Pramod Thete",description:"Pramod Data"},
        {title:"Nikhil Salunkhe",description:"Nikhil Data"},
        {title:"Jayesh Thete",description:"Jayesh Data"}
    ])


    return(
        <div>
            <h1>All Users</h1>

            {
                users.length > 0?
                users.map((usr)=>{
                    <Users user={usr}/>
                }) :"No Users FOund"
            }
        </div>
    );

}

export default AllUsers;
