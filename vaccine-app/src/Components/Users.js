import { useEffect, useState } from 'react';
import './common.css';

function Users(props) 
{
    var [allUsers, setallUsers] = useState([]);

    var [searchText,setsearchText] = useState("");
    
    useEffect(()=>{
        var helper = new XMLHttpRequest();
        helper.onreadystatechange=()=>{
            if(helper.readyState===4 && 
               helper.status===200)
               {
                var result = 
                    JSON.parse(helper.responseText);
                    debugger;
                setallUsers(result);
               }
        };
        helper.open("GET", "http://localhost:9090/users");
        helper.send();
    }, []);

    var  Search=(args)=>{
        setsearchText(args.target.value);
    }

    var  Remove=(id)=>{
        // console.log("U asked to remove " + no);
        var filteredUsers = allUsers.filter((user)=>{
                                    return (user.id !== id);
                                });
       setallUsers(filteredUsers);
    }

   
    return (<>
                  <center> 
                    <h1>Welcome To User's Page</h1>
                   </center>  
                  <hr></hr>
                    <div >
                {allUsers.map((user)=>
                    {
                        return (<div  className='table-responsive'>
                                <table>
                                    <tbody>
                                    {
                                allUsers.map(user=>
                                {
                                //    if(user.City.toLowerCase().includes
                                //         (searchText.toLowerCase()))
                                //         {
                                            return (<tr key={user.id}>
                                                <td>
                                                    {user.firstname}
                                                </td>
                                                <td>
                                                    {user.lastname}
                                                </td>
                                                <td>
                                                    {user.age}
                                                </td>
                                                <td>
                                                    {user.uaddress.uarea}
                                                </td>
                                                <td>
                                                <button className='btn btn-danger'
                                                onClick=
                                                    {
                                                    ()=>{
                                                            Remove(user.No)
                                                        }
                                                    }>
                                                    Delete
                                                </button>
                                                </td>
                                            </tr>)
                                        
                                        //} 
                                })
                            }
                                    </tbody>
                                </table>
                                </div>)
                        })}
                    </div>
                </>);
    }

 
export default Users;