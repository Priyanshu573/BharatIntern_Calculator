import React from "react";
import './Login.css';
import { Link } from 'react-router-dom';

function Login(){
    return(
        <div className='containerLogin'>
            <h1>Excellence Management System</h1>
            <div className='flex-container'>

                <div className='box-container1'>
                    <div className='box-item'>
                        <h1>Student</h1>
                        <span>Excellence Management System</span>
                        <div>
                            <span>Username:</span><input type="text" placeholder='UserName'/>
                        </div>
                        <div>
                            <span>Password:</span><input type="password" placeholder='password'/>
                        </div>
                    </div>
                </div>

                <div className='box-container1'>
                    <div className='box-item'>
                        <h1>Admin Login Right</h1>
                        <span>Excellence Management System</span>
                        <div>
                            <span>Username:</span><input type="text" placeholder='UserName'/>
                        </div>
                        <div>
                            <span>Password:</span><input type="password" placeholder='password'/>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    )
}