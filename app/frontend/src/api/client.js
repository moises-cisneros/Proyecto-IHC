const BASE_URL = import.meta.env.VITE_API_URL

async function request(endpoint, method ="GET", body){
    const token = localStorage.getItem('token')

    const response = await fetch(`${BASE_URL}${endpoint}`, {
        method,
        headers: {
            'Content-Type': 'application/json',
            ...(token && {Authorization: `Bearer ${token}`})
        },
        body: body ? JSON.stringify(body) : undefined
    })
    
    if(!response.ok){
        throw new Error(await response.text())
    }

    return response.json()
}

export const api = {
    get: (endpoint) => request(endpoint, "GET"),
    post: (endpoint, body) => request(endpoint, "POST", body),
    put: (endpoint, body) => request(endpoint, "PUT", body),
    delete: (endpoint) => request(endpoint, "DELETE")
}