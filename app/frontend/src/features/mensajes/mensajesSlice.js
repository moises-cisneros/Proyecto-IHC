import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../../api/client";

export const enviarMensaje = createAsyncThunk("mensajes/enviar", async({vendedorId, mensaje, tipo}, {rejectWithValue}) => {
    try {
        const data = await api.post(`/mensajes/enviar/${vendedorId}`, {mensaje, tipo})
        console.log(data)
        return data
    } catch (error) {
        console.error("error mensaje ", error)
        return rejectWithValue("Server error")
    }
})

const mensajesSlice = createSlice({
    name: "mensajes",
    initialState: {
        enviados: [],
        loading: false,
        error: null,
        enviado: false
    },
    reducers: {
        limpiarEstado(state){
            state.enviado = false
            state.error = null
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(enviarMensaje.pending, (state) => {
                state.loading = true
                state.error = null
                state.enviado = false
            })
            .addCase(enviarMensaje.fulfilled, (state, action) => {
                state.loading = false
                state.enviado = true
                state.enviados.push(action.payload)
            })
            .addCase(enviarMensaje.rejected, (state, action) => {
                state.loading = false,
                state.error = action.payload
            })
    }
})

export const {limpiarEstado} = mensajesSlice.actions
export default mensajesSlice.reducer