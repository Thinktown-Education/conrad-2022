import { Component } from 'react';
import './login.css';
import logo from 'assets/img/logo.svg';
import { AxiosInstance } from '../../util/axios-api';
import { BrowserRouter, BrowserRouter as Routes, Route } from 'react-router-dom';
import { Dashboard } from '../dashboard/dashboard';
import { Axios } from 'axios';

function signInUser() {
    const email = "aaa@aaa.com"
    const password = "abcd1234"
    // const email = document.getElementById('email-input').value
    // const password = document.getElementById('password-input').value
    AxiosInstance.post("http://localhost:8080/auth/login", {
        email: email,
        password: password,
    }).then((response) => {
        console.log(response.data)
        // this.setState({
        //     text: response.data
        // })
    })
    
    return (
        <BrowserRouter>
            <Routes>
                <Route path='../dashboard/dashboard' component={Dashboard} />
            </Routes>
        </BrowserRouter>
    )
    // window.location = 'http://localhost:3000/dashboard'
    // window.location = 'https://example.com'
    // AxiosInstance.get("http://localhost:8080/mindmap/test").then((response) => {
    //     console.log(response.data)
        // this.setState({
        //     text: response.data
        // })
    // })
}

const Login = () => {
    return (
        <div className="login-form-container">
            <h1>Logo</h1>
            <h1>Header: Sign In</h1>
            <form className='login-form'>
                <fieldset>
                    <legend>Email</legend>
                    <label htmlFor='email-input'>
                        <input className='login-info' id='email-input' type='email' placeholder='Email Address*' />
                    </label>
                </fieldset>
                <fieldset>
                    <legend>Password</legend>
                    <label htmlFor='password-input'>
                        <input className='login-info' id='password-input' type='password' placeholder='Password*' />
                    </label>
                </fieldset>
                <label htmlFor='remember-user'>
                    <input id='remember-user' type='checkbox' />Remember me
                </label>
            </form>
            <button id='signin' type='button' onClick={signInUser}>SIGN IN</button>
            <div id='account-retrieval'>
                <a id='forgot-password' href='#'>Forgot Password?</a>
                <a id='register-account' href='#'>Register</a>
            </div>
        </div>
    )    
}

export default Login;
