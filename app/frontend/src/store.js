import { configureStore } from "@reduxjs/toolkit";

import authReducer from "./features/auth/authSlice"
import vendedoresReducer from "./features/vendedores/vendedoresSlice"
import mensajesReducer from "./features/mensajes/mensajesSlice"

export default configureStore({
    reducer: {
        auth: authReducer,
        vendedores: vendedoresReducer,
        mensajes: mensajesReducer
    }
})