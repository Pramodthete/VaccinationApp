import ReactDOM from 'react-dom/client';
import MainUI from './Components/MainUI';
import { BrowserRouter } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.css';

const root = 
    ReactDOM.createRoot(document.getElementById('root'));
    root.render(
                    <BrowserRouter>
                        <MainUI></MainUI>
                    </BrowserRouter>
                )
