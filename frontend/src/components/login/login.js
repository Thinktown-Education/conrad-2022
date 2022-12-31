import { Component } from 'react';
import './login.css';
import logo from 'assets/img/logo.svg';
import { AxiosInstance } from '../../util/axios-api';

const Login = () => {
    return (
        <div className="login-form">
            <h1>Sign In</h1>
            <form>
                <h1>Header: Login Form</h1>
                <fieldset>
                    <legend>Email</legend>
                    <label htmlFor='email-input'>
                        <input id='email-input' type='email' placeholder='Email Address*' />
                    </label>
                </fieldset>
                <fieldset>
                    <legend>Password</legend>
                    <label htmlFor='password-input'>
                        <input id='password-input' type='password' placeholder='Password*' />
                    </label>
                </fieldset>
                <button type='button'>Login</button>
            </form>
        </div>
    )
}

export default Login;
