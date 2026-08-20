import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../../api/client";

export const login = createAsyncThunk("auth/login", async(credenciales, {rejectWithValue}) => {
    try{
        const data = await api.post("/auth/login", credenciales)
        console.log(data)

        localStorage.setItem("token", data.token)
        localStorage.setItem("usuario", JSON.stringify({nombre: data.nombre, rol: data.rol}))
        return data
    }catch(error){
        console.error("error login ", error)
        return rejectWithValue("Server error")
    }
})

const savedUser = JSON.parse(localStorage.getItem("usuario") || "null")

const authSlice = createSlice({
    name: 'auth',
    initialState: {
        user: savedUser,
        token: localStorage.getItem("token"),
        loading: false,
        error: null,
    },
    reducers: {
        logout(state) {
            state.user = null
            state.token = null
            state.error = null
            localStorage.removeItem("token")
            localStorage.removeItem("usuario")
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(login.pending, (state) => {
                state.loading = true
                state.error = null
            })
            .addCase(login.fulfilled, (state, action) => {
                state.loading = false
                state.user = { nombre: action.payload.nombre, rol: action.payload.rol }
                state.token = action.payload.token
            })
            .addCase(login.rejected, (state, action) => {
                state.loading = false
                state.error = action.payload
            })
    }
})


export const {logout} = authSlice.actions

export const selectUser = (state) => state.auth.user
export const selectIsLogged = (state) => Boolean(state.auth.token)

export default authSlice.reducer