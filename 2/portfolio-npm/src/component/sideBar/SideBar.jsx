import React from 'react'
import './SideBar.css'
import {Dashboard, Subject, Groups, Grading } from '@mui/icons-material';                   
import { Link } from "react-router-dom"

 
export default function SideBar() {
    return
         <div className= 'sidebar'>
            <div className= 'sidebarWrapper'>
                <div className 'sidebarMenu'
                    <h3 className-'sidebartitle'>Dash</h3>
                     <ul className='sidebarlist'>
                        <Link to = "/">
                            <li className='sidebarlistitem active'>
                                <Dashboard className='sidebaricons' />
                                Dashboard
                            </li>
                        </Link>
                     </ul>
                     <h3 className='sidebartitle'>APPEARANCE</h3>
                     <ul className='sidebarlist'>
                        <li className='sidebarlistitem'>
                            <Dashboard className = 'sidebaricons' />
                            Student Classes
                        </li>
                     </ul>
                    </div>
                        

