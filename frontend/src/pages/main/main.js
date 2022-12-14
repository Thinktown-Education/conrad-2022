import {Component} from 'react';
import './main.css';
import logo from 'assets/img/logo.svg';
import Axios from 'axios';

class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {
            text: "This text should change when connected to backend"
        };
    }
    
    componentDidMount() {
        Axios.post("http://localhost:8080/user/login").then((response) => {
            this.setState({
                text: response.data
            })
        })
    }

    render() {
        return (
            <div className="main">
                <img src={logo} className="logo me-1" alt='logo'/>
                <div>{this.state.text}</div>
            </div>
        )
    }
}

export default Main;
