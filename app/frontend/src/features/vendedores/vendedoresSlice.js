import { createSlice,createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../../api/client";

export const fetchVendedores = createAsyncThunk("vendedores/fetch", async (_, {rejectWithValue}) => {
    try {
        const data = await api.get("/vendedores")
        console.log("vendedores ", data)
        return data
    } catch (error) {
        console.error("error vendedores", error)
        return rejectWithValue("Server error")
    }
})

const vendedoresSlice = createSlice({
    name: "vendedores",
    initialState: {
        lista: [],
        loading: false,
        error: null
    },
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchVendedores.pending, (state) => {
                state.loading = true
                state.error = null
            })
            .addCase(fetchVendedores.fulfilled, (state, action) => {
                state.loading = false
                state.lista = action.payload
            })
            .addCase(fetchVendedores.rejected, (state, action) => {
                state.loading = false
                state.error = action.payload
            })
    }
})

export const selectVendedores = (state) => state.vendedores.lista
export default vendedoresSlice.reducer