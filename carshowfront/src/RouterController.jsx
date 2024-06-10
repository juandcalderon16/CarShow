import React, { useState, useEffect} from 'react'
import { Navigate } from 'react-router-dom'

const RouterController = props => {
    const { component: Component, isAuthenticated, ...rest } = props    

    const [isAuth, setIsAuth] = useState(true)

    const init = () => {
        if(!localStorage.getItem("auth")){
            setIsAuth(false)
        } else {
            const auth = JSON.parse(localStorage.getItem('auth'))
            if (auth === 'yes'){
                setIsAuth(true)
            } else {
                setIsAuth(false)
            }
        }
    }
    useEffect(init, [])
    return isAuth ? <Component {...rest} /> : <Navigate to="/IniciarSesion" />
}

export default RouterController;