import { Route } from "react-router-dom";
//import Dashboard from "./Dashboard";
import CenterLogin from "./CenterLogin";

function ProtectedRoute(props)
{
    debugger;
    var isLoggedIn = false; //Code is yet to be written

    var isLoggedInFromSessionStorage = sessionStorage.getItem("isLoggedIn");
    if(isLoggedInFromSessionStorage!=null)
    {
        if(isLoggedInFromSessionStorage=="true")
        {
            isLoggedIn = true;
        }
    }


    if(isLoggedIn) //check for sessionStorage values
    {
        return <Route  path={props.path} exact   
                        component={props.component} />;
    }
    else
    {
       return <CenterLogin></CenterLogin>
    }
}

export default ProtectedRoute;