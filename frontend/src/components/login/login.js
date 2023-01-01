import { Component } from 'react';
import './login.css';
import logo from 'assets/img/logo.svg';
import { AxiosInstance } from '../../util/axios-api';

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
            <button id='signin' type='button'>SIGN IN</button>
            <div id='account-retrieval'>
                <a id='forgot-password' href='#'>Forgot Password?</a>
                <a id='register-account' href='#'>Register</a>
            </div>
        </div>
    )
}

export default Login;
