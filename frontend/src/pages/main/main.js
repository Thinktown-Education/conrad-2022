import { Component } from 'react';
import './main.css';
import logo from 'assets/img/logo.svg';
import { AxiosInstance } from '../../util/axios-api';
import Login from '../../components/login/login'

class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {
            text: "This text should change when connected to backend",
            email: "aaa@aaa.com",
            password: "abcd1234"

        };
    }

    clickToRegister = () => {
        AxiosInstance.post("http://localhost:8080/auth/login", {
            email: this.state.email,
            password: this.state.password,
            thCredentials: true   /* This is important, need to make a class for future requests */
        }).then((response) => {
            console.log(response.data)
            this.setState({
                text: response.data
            })
        })
        console.log(this.state.text + " (this should be changed)")
    }

    clickToTest = () => {
        AxiosInstance.get("http://localhost:8080/mindmap/test").then((response) => {
            console.log(response.data)
            this.setState({
                text: response.data
            })
        })
    }

    render() {
        return (
            <div className="main">
                <img src={logo} className="logo me-1" alt='logo' onClick={this.clickToRegister} />
                <div>{this.state.text}</div>
                <Login />
                {/* <button onClick={this.clickToRegister}>Login</button>
                <button onClick={this.clickToTest}>Mind Map Test</button> */}
            </div>
        )
    }
}

export default Main;
