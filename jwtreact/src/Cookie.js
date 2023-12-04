import { Cookies } from 'react-cookie';

const cookies = new Cookies();
const expiration = new Date(Date.now() + 1000 * 60 * 60 * 24 * 15);

export const setCookie = (name, value, option) => {
    return cookies.set(name, value, {...option});
}

export const getCookie = (name) => {
    return cookies.get(name);
}

export const removeCookie = (name) => {
    return cookies.remove(name);
}