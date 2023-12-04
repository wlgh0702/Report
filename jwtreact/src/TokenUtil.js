import {jwtDecode} from "jwt-decode";

export function decodeJwt(token) {
    if(token == null) return null;

    console.log(jwtDecode(token));

    return jwtDecode(token);
}
