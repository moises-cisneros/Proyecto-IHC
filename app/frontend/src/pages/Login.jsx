import { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'

import { login } from '../features/auth/authSlice'
import "./Login.css"

export default function Login(){
    const dispatch = useDispatch()
    const navigate = useNavigate()

    const {loading, error} = useSelector((state) => state.auth)

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const onSubmit = async(e) => {
        e.preventDefault()
        const resultado = await dispatch(login({email, password}))
        
        //just navigate when login success
        if(login.fulfilled.match(resultado)){
            navigate("/")
        }
    }


    return(
        <div className='login-wrap'>
            <form className='login-card' onSubmit={onSubmit}>
                <h1>Iniciar sesion</h1>
                <label className='login-campo'>
                    Email <input type = "email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder='email' required />
                </label>

                <label className='login-campo'>
                    Password <input type = "password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder='password' required />
                </label>

                {error && <p className='login-error'>{error}</p>}

                <button type='submit' className='login-btn' disabled={loading}>
                    {loading ? "Ingresando..." : "Ingresar"}
                </button>
            </form>
        </div>
    )
}